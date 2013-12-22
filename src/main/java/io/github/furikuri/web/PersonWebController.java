package io.github.furikuri.web;

import io.github.furikuri.domain.Person;
import io.github.furikuri.service.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class PersonWebController {
    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showForm(Person person) {
        return "form";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String enterAge(@Valid Person person, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", bindingResult.getFieldError().getDefaultMessage());
            return "redirect:/";
        }
        personRepository.save(new Person("Theo", 27));
        return "results";
    }
}
