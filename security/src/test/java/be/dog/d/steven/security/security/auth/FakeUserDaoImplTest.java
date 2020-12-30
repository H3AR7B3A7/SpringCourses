package be.dog.d.steven.security.security.auth;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class FakeUserDaoImplTest {
    @Autowired
    private FakeUserDaoImpl fakeUserDaoImpl;

    @Test
    public void testSelectUserByUsername() {
        // TODO: This test is incomplete.

        this.fakeUserDaoImpl.selectUserByUsername("janedoe");
    }

    @Test
    public void testSelectUserByUsername2() {
        User getResult = this.fakeUserDaoImpl.selectUserByUsername("admin").get();
        assertTrue(getResult.isAccountNonLocked());
        assertTrue(getResult.isAccountNonExpired());
        assertTrue(getResult.isEnabled());
        assertTrue(getResult.isCredentialsNonExpired());
        assertEquals("admin", getResult.getUsername());
        assertEquals(5, getResult.getAuthorities().size());
    }
}

