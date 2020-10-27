package be.dog.d.steven.simplerest.dao;

import be.dog.d.steven.simplerest.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//@Primary
@Repository
public class RemotePersonDataAccessService implements PersonDao {

    @Override
    public UUID insertPerson(UUID id, Person person) {
        return id;
    }

    @Override
    public List<Person> selectAllPeople() {
        return null;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return 0;
    }
}
