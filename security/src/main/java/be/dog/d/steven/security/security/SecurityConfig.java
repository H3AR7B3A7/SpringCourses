package be.dog.d.steven.security.security;

import be.dog.d.steven.security.jwt.JwtConfig;
import be.dog.d.steven.security.jwt.JwtCredentialAuthenticationFilter;
import be.dog.d.steven.security.jwt.JwtTokenVerifier;
import be.dog.d.steven.security.security.auth.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.crypto.SecretKey;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
@EnableConfigurationProperties(JwtConfig.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final SecretKey secretKey;
    private final JwtConfig jwtConfig;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
/*
        // Basic authentication (always authenticate, no Spring mapping) with whitelisting:
        http
                .csrf().disable() // Cross Site Request Forgery - Tokens disabled for non browser applications or postman
                .authorizeRequests()
                .antMatchers("/", "/index", "/css/*", "/js/*")
                .permitAll()
                .antMatchers("/api/**")
                .hasRole(STUDENT.name())
                // Either use COURSE_READ or role for GET methods
//                .antMatchers(HttpMethod.GET,"/admin/api/**")
//                .hasAuthority(COURSE_READ.name())
//                .antMatchers(HttpMethod.GET,"/admin/api/**") // Order matters if Method not defined
//                .hasAnyRole(ADMIN.name(), PROFESSOR.name())
//                .antMatchers(HttpMethod.POST,"/admin/api/**")
//                .hasAuthority(COURSE_WRITE.getPermission())
//                .antMatchers(HttpMethod.DELETE,"/admin/api/**")
//                .hasAuthority(COURSE_WRITE.getPermission())
//                .antMatchers(HttpMethod.PUT,"/admin/api/**")
//                .hasAuthority(COURSE_WRITE.getPermission())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();

        // To generate tokens in local environment:
//        http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
*/

        // Form Based (single application) / Jwt authentication (multiple platform applications):
        http
                .csrf().disable() // Cross Site Request Forgery - Tokens disabled for non browser applications or postman

                // For Jwt authentication only
                // -- Comment this out for FORM authentication --

                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtCredentialAuthenticationFilter(authenticationManager(), jwtConfig, secretKey))
                .addFilterAfter(new JwtTokenVerifier(secretKey, jwtConfig), JwtCredentialAuthenticationFilter.class)

                // -- Comment this out for FORM authentication --


                .authorizeRequests()
                .antMatchers("/", "/index", "/goodbye", "/css/*", "/js/*", "/img/*","/fragments/*")
                .permitAll()
                .antMatchers("/api/**")
                .hasRole(UserRole.STUDENT.name())
                .anyRequest()
                .authenticated(); // Close with ; when using JWT

                // Form based authentication for when no other devices need access
                // -- Comment this out for JWT authentication --
/*
                .and()
                .formLogin()
                .loginPage("/login") // For custom login page
                .permitAll()
                .defaultSuccessUrl("/courses", true)

                .and()
                .rememberMe() // Defaults to 2 weeks
                .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(30))

                .and()
                .logout()
                .logoutUrl("/logout")
                // When csrf is disabled httpMethod is GET by default, when enabled it is a POST
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID", "remember-me")
                .logoutSuccessUrl("/goodbye");
*/
                // -- Comment this out for JWT authentication --

    }


/*
    // Hardcoded users
    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        // Creating users - should fetch these from a remote db IRL:
        // PasswordEncoder needed! (see: PasswordConfig)
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin"))
//                .roles(ADMIN.name())
                .authorities(ADMIN.getGrantedAuthorities())
                .build();
        UserDetails professor = User.builder()
                .username("professor")
                .password(passwordEncoder.encode("professor"))
//                .roles(PROFESSOR.name())
                .authorities(PROFESSOR.getGrantedAuthorities())
                .build();
        UserDetails student = User.builder()
                .username("student")
                .password(passwordEncoder.encode("student"))
//                .roles(STUDENT.name())
                .authorities(STUDENT.getGrantedAuthorities())
                .build();

        return new InMemoryUserDetailsManager(
                admin,
                professor,
                student
        );
    }

 */

    // 'Remote' DB users
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(userService);
        return provider;
    }
}
