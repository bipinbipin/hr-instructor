package com.astontech.hr.repositories;

import com.astontech.hr.domain.Element;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Bipin on 3/25/2016.
 */
public interface ElementRepository extends CrudRepository<Element, Integer> {

    //will auto generate the required code from the structure of the method name
    //todo:     give reference
    List<Element> findAllByElementName(String elementName);

}
