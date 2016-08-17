package com.astontech.hr.rest;

import com.astontech.hr.domain.Person;
import com.astontech.hr.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Bipin on 6/13/2016.
 */
@RestController
@RequestMapping("/api/person")
public class PersonRest {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/list")
    public Iterable<Person> listAllProjects() {
        return personRepository.findAll();
    }

    @RequestMapping("/{id}")
    public Person listAllProjects2(@PathVariable Integer id) {
        return personRepository.findOne(id);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Person savePerson(@RequestBody Person person) {
        Person savedPerson = personRepository.save(person);
        return savedPerson;
    }

}
