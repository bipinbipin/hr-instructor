package com.astontech.hr.rest;

import com.astontech.hr.domain.Element;
import com.astontech.hr.services.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Bipin on 4/4/2016.
 */
@RestController
@RequestMapping("/rest/element")
public class ElementRest {

    @Autowired
    private ElementService elementService;

    @RequestMapping(value = "/{Id}", method = RequestMethod.GET)
    public Element getElement(@PathVariable int Id) {
        Element element = elementService.getElementById(Id);
        return element;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Element> getAllElements() {
        Iterable<Element> elementList = elementService.listAllElements();
        return elementList;
    }
}
