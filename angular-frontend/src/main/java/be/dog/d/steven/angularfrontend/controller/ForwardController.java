package be.dog.d.steven.angularfrontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ForwardController {

    @GetMapping(value = {"/index", "/books"})
    public String frontend() {
        return "forward:/";
    }
}
