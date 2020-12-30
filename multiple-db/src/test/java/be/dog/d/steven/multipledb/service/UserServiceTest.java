package be.dog.d.steven.multipledb.service;

import be.dog.d.steven.multipledb.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ContextConfiguration(classes = {UserService.class})
@ExtendWith(SpringExtension.class)
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testAddUser() {
        // TODO: This test is incomplete.

        this.userService.addUser(new User());
    }

    @Test
    public void testGetAllUsers() {
        assertTrue(((ArrayList<User>) this.userService.getAllUsers()).isEmpty());
    }

    @Test
    public void testGetUserById() {
        // TODO: This test is incomplete.

        this.userService.getUserById(1);
    }

    @Test
    public void testDeleteUser() {
        assertEquals(0, this.userService.deleteUser(1));
    }
}

