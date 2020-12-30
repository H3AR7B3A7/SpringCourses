package be.dog.d.steven.security.jwt;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ContextConfiguration(classes = {JwtConfig.class})
@ExtendWith(SpringExtension.class)
public class JwtConfigTest {
    @Autowired
    private JwtConfig jwtConfig;

    @Test
    public void testSetSecretKey() {
        this.jwtConfig.setSecretKey("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
        assertEquals("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", this.jwtConfig.getSecretKey());
    }

    @Test
    public void testSetTokenPrefix() {
        this.jwtConfig.setTokenPrefix("ABC123");
        assertEquals("ABC123", this.jwtConfig.getTokenPrefix());
    }

    @Test
    public void testSetTokenExpirationAfterDays() {
        this.jwtConfig.setTokenExpirationAfterDays(1);
        assertEquals(1, this.jwtConfig.getTokenExpirationAfterDays().intValue());
    }
}

