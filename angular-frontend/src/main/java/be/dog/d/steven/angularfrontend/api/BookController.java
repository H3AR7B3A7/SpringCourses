package be.dog.d.steven.angularfrontend.api;

import be.dog.d.steven.angularfrontend.model.Book;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class BookController {

    @CrossOrigin("/")
    @GetMapping("/api/books")
    public List<Book> getBooks(){
        return Stream.of(
                new Book(1, "Beginning programming with C++ for dummies", "Stephen R. Davis"),
                new Book(2, "Learning Python", "Mark Lutz"),
                new Book(3, "Domain Driven Design", "Eric Evans"),
                new Book(4, "Agile Project Management for dummies", "Mark C. Layton"),
                new Book(5, "Scrum for dummies", "Mark C. Layton"),
                new Book(6, "Java Design Patterns", "Vaskaran Sarcar"),
                new Book(7, "Pro Spring 5", "Luliana Cosmina"),
                new Book(8, "Spring 5.0 Cookbook", "Sherwin John Calleja Tragura")
        ).collect(Collectors.toList());
    }
}
