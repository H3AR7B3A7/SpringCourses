package be.dog.d.steven.simplerest.service;

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
public class PersonServiceTest {
    @Autowired
    private PersonService personService;

    @Test
    public void testAddPerson() {
        this.personService.addPerson(new Person());
        Person getResult = this.personService.getAllPeople().get(45);
        assertNull(getResult.getName());
        assertEquals("Person(id=e307ce41-1100-4c03-96fa-1822bc574386, name=null)", getResult.toString());
    }

    @Test
    public void testAddPerson2() {
        Person person = new Person();
        person.setName("insertPerson(Lbe/dog/d/steven/simplerest/model/Person;)Ljava/util/UUID;");
        this.personService.addPerson(person);
        Person getResult = this.personService.getAllPeople().get(49);
        assertEquals("insertPerson(Lbe/dog/d/steven/simplerest/model/Person;)Ljava/util/UUID;", getResult.getName());
        assertEquals("Person(id=b8ae0f26-2ac3-4b9e-ad65-cac7f705633f, name=insertPerson(Lbe/dog/d/steven/simplerest/model"
                + "/Person;)Ljava/util/UUID;)", getResult.toString());
    }

    @Test
    public void testAddPerson3() {
        Person person = new Person();
        person.setId(UUID.randomUUID());
        this.personService.addPerson(person);
        Person getResult = this.personService.getAllPeople().get(53);
        assertNull(getResult.getName());
        assertEquals("Person(id=ebdb6708-a249-4263-924b-65a993a26b01, name=null)", getResult.toString());
    }

    @Test
    public void testGetAllPeople() {
        assertEquals(57, this.personService.getAllPeople().size());
    }

    @Test
    public void testGetPersonById() {
        // TODO: This test is incomplete.

        this.personService.getPersonById(UUID.randomUUID());
    }

    @Test
    public void testDeletePerson() {
        assertEquals(0, this.personService.deletePerson(UUID.randomUUID()));
    }

    @Test
    public void testUpdatePerson() {
        UUID id = UUID.randomUUID();
        assertEquals(0, this.personService.updatePerson(id, new Person()));
    }
}

