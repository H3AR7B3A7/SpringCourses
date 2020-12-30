package be.dog.d.steven.multipledb.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    @Test
    public void testSetId() {
        User user = new User();
        user.setId(1);
        assertEquals(1, user.getId());
    }

    @Test
    public void testSetUsername() {
        User user = new User();
        user.setUsername("janedoe");
        assertEquals("janedoe", user.getUsername());
    }
}

