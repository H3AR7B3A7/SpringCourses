package be.dog.d.steven.simplerest.dao;

import be.dog.d.steven.simplerest.model.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class RemotePersonDaoImplTest {
    @Autowired
    private RemotePersonDaoImpl remotePersonDaoImpl;

    @Test
    public void testInsertPerson() {
        // TODO: This test is incomplete.

        UUID id = UUID.randomUUID();
        this.remotePersonDaoImpl.insertPerson(id, new Person());
    }

    @Test
    public void testInsertPerson2() {
        // TODO: This test is incomplete.

        Person person = new Person(UUID.randomUUID(), "Name");
        this.remotePersonDaoImpl.insertPerson(UUID.randomUUID(), person);
    }

    @Test
    public void testInsertPerson3() {
        // TODO: This test is incomplete.

        Person person = new Person();
        person.setId(UUID.randomUUID());
        this.remotePersonDaoImpl.insertPerson(UUID.randomUUID(), person);
    }

    @Test
    public void testSelectAllPeople() {
        assertNull(this.remotePersonDaoImpl.selectAllPeople());
    }

    @Test
    public void testSelectPersonById() {
        // TODO: This test is incomplete.

        this.remotePersonDaoImpl.selectPersonById(UUID.randomUUID());
    }

    @Test
    public void testDeletePersonById() {
        assertEquals(0, this.remotePersonDaoImpl.deletePersonById(UUID.randomUUID()));
        assertEquals(0, this.remotePersonDaoImpl.deletePersonById(new UUID(1L, 1L)));
    }

    @Test
    public void testUpdatePersonById() {
        UUID id = UUID.randomUUID();
        assertEquals(0, this.remotePersonDaoImpl.updatePersonById(id, new Person()));
    }
}

