package be.dog.d.steven.simplerest.dao;

import be.dog.d.steven.simplerest.model.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ContextConfiguration(classes = {LocalPersonDaoImpl.class})
@ExtendWith(SpringExtension.class)
public class LocalPersonDaoImplTest {
    @Autowired
    private LocalPersonDaoImpl localPersonDaoImpl;

    @Test
    public void testInsertPerson() {
        // TODO: This test is incomplete.

        UUID id = UUID.randomUUID();
        this.localPersonDaoImpl.insertPerson(id, new Person());
    }

    @Test
    public void testInsertPerson2() {
        // TODO: This test is incomplete.

        Person person = new Person();
        person.setId(UUID.randomUUID());
        this.localPersonDaoImpl.insertPerson(UUID.randomUUID(), person);
    }

    @Test
    public void testSelectAllPeople() {
        assertEquals(92, this.localPersonDaoImpl.selectAllPeople().size());
    }

    @Test
    public void testSelectPersonById() {
        // TODO: This test is incomplete.

        this.localPersonDaoImpl.selectPersonById(new UUID(1L, 1L));
    }

    @Test
    public void testDeletePersonById() {
        assertEquals(0, this.localPersonDaoImpl.deletePersonById(UUID.randomUUID()));
        assertEquals(0, this.localPersonDaoImpl.deletePersonById(new UUID(1L, 1L)));
    }

    @Test
    public void testUpdatePersonById() {
        UUID id = new UUID(1L, 1L);
        assertEquals(1, this.localPersonDaoImpl.updatePersonById(id, new Person()));
    }

    @Test
    public void testUpdatePersonById2() {
        UUID id = new UUID(1L, 1L);
        Person person = new Person();
        person.setId(UUID.randomUUID());
        assertEquals(1, this.localPersonDaoImpl.updatePersonById(id, person));
    }
}

