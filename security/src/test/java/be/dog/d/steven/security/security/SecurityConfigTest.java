package be.dog.d.steven.security.security;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class SecurityConfigTest {
    @Autowired
    private ObjectPostProcessor<Object> objectPostProcessor;

    @Autowired
    private AuthenticationManagerBuilder authenticationManagerBuilder;

    @Autowired
    private SecurityConfig securityConfig;

    @Test
    public void testConfigure() throws Exception {
        this.securityConfig.configure(this.authenticationManagerBuilder);
        assertTrue(this.authenticationManagerBuilder.isConfigured());
    }

    @Test
    public void testConfigure2() throws Exception {
        HttpSecurity httpSecurity = new HttpSecurity(this.objectPostProcessor, this.authenticationManagerBuilder,
                new HashMap<Class<?>, Object>());
        this.securityConfig.configure(httpSecurity);
        assertSame(httpSecurity, httpSecurity.logout().and());
    }

    @Test
    public void testDaoAuthenticationProvider() {
        // TODO: This test is incomplete.

        this.securityConfig.daoAuthenticationProvider();
    }
}

