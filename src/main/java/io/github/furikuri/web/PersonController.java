package io.github.furikuri.web;

import io.github.furikuri.domain.Person;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody Person getPerson() {
        return new Person("Theo", 27);
    }
}
