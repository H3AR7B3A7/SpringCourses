package be.dog.d.steven.security.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.concurrent.TimeUnit;

import static be.dog.d.steven.security.security.UserRole.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

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

        // Form Based authentication:
        http
                .csrf().disable() // Cross Site Request Forgery - Tokens disabled for non browser applications or postman
                .authorizeRequests()
                .antMatchers("/", "/index", "/goodbye", "/css/*", "/js/*")
                .permitAll()
                .antMatchers("/api/**")
                .hasRole(STUDENT.name())
                .anyRequest()
                .authenticated()

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
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID", "remember-me")
                .logoutSuccessUrl("/goodbye");
    }



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
}
