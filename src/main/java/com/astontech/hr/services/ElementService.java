package com.astontech.hr.services;

import com.astontech.hr.domain.Element;

/**
 * Created by Bipin on 3/28/2016.
 */
public interface ElementService {

    Iterable<Element> listAllElements();

    Element getElementById(Integer id);

    Element saveElement(Element element);

    Iterable<Element> saveElementList(Iterable<Element> elementIterable);

    void deleteElement(Integer id);

}
