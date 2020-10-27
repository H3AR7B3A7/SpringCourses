package be.dog.d.steven.simplerest.dao;

import be.dog.d.steven.simplerest.model.Person;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Primary // Annotate LocalPersonDaoImpl with Primary to switch between Repositories
@Repository
@AllArgsConstructor
public class RemotePersonDaoImpl implements PersonDao {

    DataSource dataSource;

    @Override
    public UUID insertPerson(UUID id, Person person) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        UUID uuid = UUID.randomUUID();
        jdbcTemplate.update("INSERT INTO Person (id, name) VALUES (?,?)",
                uuid, person.getName());
        return uuid;
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
