package be.dog.d.steven.simplerest.api;

import be.dog.d.steven.simplerest.model.Person;
import be.dog.d.steven.simplerest.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final PersonService personService;

    @GetMapping("/")
    public String home(Model model){

        List<Person> allPersons = personService.getAllPeople();

        model.addAttribute("all", allPersons);

        return "index";
    }

}
