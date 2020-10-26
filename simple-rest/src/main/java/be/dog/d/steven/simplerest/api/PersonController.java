package be.dog.d.steven.simplerest.api;

import be.dog.d.steven.simplerest.model.Person;
import be.dog.d.steven.simplerest.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/person")
@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }
}