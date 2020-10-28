package be.dog.d.steven.multipledb.api;

import be.dog.d.steven.multipledb.model.User;
import be.dog.d.steven.multipledb.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("api/v1/user")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public void addPerson(@Valid @NonNull @RequestBody User user){
        userService.addUser(user);
    }

    @GetMapping
    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        userService.getAllUsers().forEach(users::add);
        return users;
    }

    @GetMapping(path = "/{id}")
    public User getUserById(@PathVariable("id") int id){
        return userService.getUserById(id)
                .orElse(null); // Could throw an actual exception here, just returning null for simplicity
    }

    @DeleteMapping(path = "{id}")
    public void deleteUserById(@PathVariable("id") int id){
        userService.getUserById(id);
    }

}
