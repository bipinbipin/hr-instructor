package com.astontech.hr.controllers;

import com.astontech.hr.domain.Person;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Bipin on 6/13/2016.
 */
@Controller
public class PersonController {

    @RequestMapping(value = "/person")
    public String getPersonFromService(Model model) {

        // Get a single object
        RestTemplate restTemplate = new RestTemplate();
        Person person = restTemplate.getForObject("http://localhost:8080/people/1", Person.class);

        model.addAttribute("firstName", person.getLastName());


        // Get a collection of objects
        RestTemplate collectionTemplate = new RestTemplate();

        Person[] personArray = collectionTemplate.getForObject("http://localhost:8080/rest/person/list", Person[].class);
        List<Person> personList = Arrays.asList(personArray);

//        ResponseEntity<List<Person>> personListResponse =
//                collectionTemplate.exchange("http://localhost:8080/people",
//                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Person>>() {
//                });
//        List<Person> personList = personListResponse.getBody();


        model.addAttribute("personList", personList.get(1).getFirstName());

        return "person";
    }
}
