package be.dog.d.steven.security.security.auth;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testLoadUserByUsername() throws UsernameNotFoundException {
        assertThrows(UsernameNotFoundException.class, () -> this.userService.loadUserByUsername("janedoe"));
    }

    @Test
    public void testLoadUserByUsername2() throws UsernameNotFoundException {
        UserDetails actualLoadUserByUsernameResult = this.userService.loadUserByUsername("admin");
        assertTrue(actualLoadUserByUsernameResult.isAccountNonLocked());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonExpired());
        assertTrue(actualLoadUserByUsernameResult.isEnabled());
        assertTrue(actualLoadUserByUsernameResult.isCredentialsNonExpired());
        assertEquals("admin", actualLoadUserByUsernameResult.getUsername());
        assertEquals(5, actualLoadUserByUsernameResult.getAuthorities().size());
    }
}

