package be.dog.d.steven.security.security;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserRoleTest {
    @Test
    public void testGetGrantedAuthorities() {
        assertEquals(5, UserRole.ADMIN.getGrantedAuthorities().size());
        assertEquals(1, UserRole.STUDENT.getGrantedAuthorities().size());
    }
}

