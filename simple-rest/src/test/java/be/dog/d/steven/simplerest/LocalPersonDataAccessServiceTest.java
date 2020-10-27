package be.dog.d.steven.simplerest;

import be.dog.d.steven.simplerest.dao.LocalPersonDataAccessService;
import be.dog.d.steven.simplerest.model.Person;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class LocalPersonDataAccessServiceTest {

    private final LocalPersonDataAccessService testService = new LocalPersonDataAccessService();

    @Test
    public void canPerformCrud() {
        // Given person called James Bond
        UUID idOne = UUID.randomUUID();
        Person personOne = new Person(idOne, "Steven D'Hondt");

        // ...And Anna Smith
        UUID idTwo = UUID.randomUUID();
        Person personTwo = new Person(idTwo, "Joeri Peters");

        // When James and Anna added to db
        testService.insertPerson(idOne, personOne);
        testService.insertPerson(idTwo, personTwo);

        // Then can retrieve James by id
        assertThat(testService.selectPersonById(idOne))
                .isPresent()
                .hasValueSatisfying(personFromDb -> assertThat(personFromDb).isEqualToComparingFieldByField(personOne));

        // ...And also Anna by id
        assertThat(testService.selectPersonById(idTwo))
                .isPresent()
                .hasValueSatisfying(personFromDb -> assertThat(personFromDb).isEqualToComparingFieldByField(personTwo));

        // When get all people
        List<Person> people = testService.selectAllPeople();

        // ...List should have size 2 and should have both James and Anna
        assertThat(people)
                .hasSize(2)
                .usingFieldByFieldElementComparator()
                .containsExactlyInAnyOrder(personOne, personTwo);

        // ... An update request (James Bond name to Jake Black)
        Person personUpdate = new Person(idOne, "John Doe");

        // When Update
        assertThat(testService.updatePersonById(idOne, personUpdate)).isEqualTo(1);

        // Then when get person with idOne then should have name as James Bond > Jake Black
        assertThat(testService.selectPersonById(idOne))
                .isPresent()
                .hasValueSatisfying(personFromDb -> assertThat(personFromDb).isEqualToComparingFieldByField(personUpdate));

        // When Delete Jake Black
        assertThat(testService.deletePersonById(idOne)).isEqualTo(1);

        // When get personOne should be empty
        assertThat(testService.selectPersonById(idOne)).isEmpty();

        // Finally DB should only contain only Anna Smith
        assertThat(testService.selectAllPeople())
                .hasSize(1)
                .usingFieldByFieldElementComparator()
                .containsExactlyInAnyOrder(personTwo);
    }

    @Test
    public void willReturn0IfNoPersonFoundToDelete() {
        // Given
        UUID id = UUID.randomUUID();

        // When
        int deleteResult = testService.deletePersonById(id);

        // Then
        assertThat(deleteResult).isEqualTo(0);
    }

    @Test
    public void willReturn0IfNoPersonFoundToUpdate() {
        // Given
        UUID id = UUID.randomUUID();
        Person person = new Person(id, "Not In DB");

        // When
        int deleteResult = testService.updatePersonById(id, person);

        // Then
        assertThat(deleteResult).isEqualTo(0);
    }
}
