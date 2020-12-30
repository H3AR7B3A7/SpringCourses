package be.dog.d.steven.security.jwt;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class JwtSecretKeyTest {
    @Autowired
    private JwtSecretKey jwtSecretKey;

    @Test
    public void testSecretKey() {
        assertTrue(this.jwtSecretKey.secretKey() instanceof javax.crypto.spec.SecretKeySpec);
    }
}

