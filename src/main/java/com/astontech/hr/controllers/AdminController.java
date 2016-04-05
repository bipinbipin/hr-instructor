package com.astontech.hr.controllers;

import com.astontech.hr.domain.Element;
import com.astontech.hr.domain.ElementType;
import com.astontech.hr.domain.VO.ElementVO;
import com.astontech.hr.repositories.ElementRepository;
import com.astontech.hr.repositories.ElementTypeRepository;
import com.astontech.hr.services.ElementService;
import com.astontech.hr.services.ElementTypeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bipin on 3/29/2016.
 */
@Controller
public class AdminController {

    @Autowired
    private ElementTypeService elementTypeService;

    private Logger log = Logger.getLogger(AdminController.class);

//    @ModelAttribute("successAlert")
//    public String successAlert(String visible){
//        if(visible.equals("true")){
//            return "visible";
//        } else {
//            return "hidden";
//        }
//
//    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminIndex() {
        return "admin/admin";
    }

    @RequestMapping(value = "/admin/element", method = RequestMethod.GET)
    public String adminElementGet(Model model) {
        model.addAttribute("elementVO", new ElementVO());
        model.addAttribute("warningAlert", "visible");
        return "admin/element_add";
    }

    @RequestMapping(value = "/admin/element", method = RequestMethod.POST)
    public String adminElementPost(ElementVO elementVO, Model model) {
        elementVO.splitNewElements();
        logElementVO(elementVO);

        saveElementTypeAndElementsFromVO(elementVO);

        boolean success = true;
        if(success)
            model.addAttribute("successAlert", "visible");
        else
            model.addAttribute("errorAlert", "visible");

        model.addAttribute("elementVO", new ElementVO());
        return "admin/element_add";
    }

    @RequestMapping(value = "/admin/element/list", method = RequestMethod.GET)
    public String elementList(Model model) {
        model.addAttribute("elementTypeList", elementTypeService.listAllElementTypes());


        return "admin/element_list";
    }

    private void saveElementTypeAndElementsFromVO(ElementVO elementVO) {

        List<Element> newElementList = new ArrayList<Element>();
        for(String str : elementVO.getNewElement()) {
            newElementList.add(new Element(str));
        }
        ElementType newElementType = new ElementType(elementVO.getNewElementType());
        newElementType.setElementList(newElementList);
        elementTypeService.saveElementType(newElementType);
    }

    private void logElementVO(ElementVO elementVO) {
        log.info("New Element Type: " + elementVO.getNewElementType());
        //String splitStrings[] = StringHelper.splitStringByNewLine(elementVO.getNewElements());
        for(String str : elementVO.getNewElement()) {
            log.info("New Elements: " + str);
        }

    }
}
