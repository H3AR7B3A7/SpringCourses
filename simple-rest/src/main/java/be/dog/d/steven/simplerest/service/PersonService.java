package be.dog.d.steven.simplerest.service;

import be.dog.d.steven.simplerest.dao.PersonDao;
import be.dog.d.steven.simplerest.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("fakeDao")
public class PersonService {

    private final PersonDao personDao;

    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople(){
        return personDao.selectAllPeople();
    }
}
