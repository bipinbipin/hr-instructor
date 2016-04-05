package com.astontech.hr.rest;

import com.astontech.hr.domain.Element;
import com.astontech.hr.domain.ElementType;
import com.astontech.hr.services.ElementService;
import com.astontech.hr.services.ElementTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Bipin on 4/4/2016.
 */
@RestController
@RequestMapping("/rest/elementType")
public class ElementTypeRest {

    @Autowired
    private ElementTypeService elementTypeService;

    @RequestMapping(value = "/{Id}", method = RequestMethod.GET)
    public ElementType getElementType(@PathVariable int Id) {
        ElementType elementType = elementTypeService.getElementTypeById(Id);
        return elementType;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<ElementType> getAllElementTypes() {
        Iterable<ElementType> elementTypeList = elementTypeService.listAllElementTypes();
        return elementTypeList;
    }
}
