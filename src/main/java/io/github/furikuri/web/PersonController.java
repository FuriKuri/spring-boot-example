package io.github.furikuri.web;

import io.github.furikuri.domain.Person;
import io.github.furikuri.service.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<Person> getPersonByName(@RequestParam(value="name") String name) {
        return personRepository.findByName(name);
    }
}
