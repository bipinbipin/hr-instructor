package com.astontech.hr.services.Impl;

import com.astontech.hr.domain.Element;
import com.astontech.hr.repositories.ElementRepository;
import com.astontech.hr.services.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Bipin on 3/28/2016.
 */
@Service
public class ElementServiceImpl implements ElementService{

    @Autowired
    private ElementRepository elementRepository;

    @Override
    public Iterable<Element> listAllElements() {
        return elementRepository.findAll();
    }

    @Override
    public Element getElementById(Integer id) {
        return elementRepository.findOne(id);
    }

    @Override
    public Element saveElement(Element element) {
        return elementRepository.save(element);
    }

    @Override
    public Iterable<Element> saveElementList(Iterable<Element> elementIterable) {
        return elementRepository.save(elementIterable);
    }

    @Override
    public void deleteElement(Integer id) {
        elementRepository.delete(id);
    }
}
