package com.astontech.hr.controllers;

import com.astontech.hr.domain.VO.FormDemoVO;
import com.astontech.hr.repositories.FormDemoRepository;
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
public class FormDemoController {

    @Autowired
    private FormDemoRepository formDemoRepository;

    private Logger log = Logger.getLogger(FormDemoController.class);


    @RequestMapping(value = "admin/form_demo", method = RequestMethod.GET)
    public String formDemoGet(Model model) {
        model.addAttribute("formDemoVO", new FormDemoVO());
//        model.addAttribute("singleList", buildSingleDropdownList());
        return "admin/form_demo";
    }

    @RequestMapping(value = "admin/form_demo", method = RequestMethod.POST)
    public String formDemoPost(FormDemoVO formDemo, Model model) {
        logFormDemoVO(formDemo);
//        model.addAttribute("singleList", buildSingleDropdownList());
        //convertCheckBoxes(formDemo);
        formDemo.convertCheckBoxArrayToValues();
        formDemoRepository.save(formDemo);
        return "admin/form_demo";
    }

    @ModelAttribute("singleList")
    private List<String> buildSingleDropdownList() {
        List<String> singleList = new ArrayList<String>();
        singleList.add("1");
        singleList.add("2");
        singleList.add("3");
        singleList.add("4");
        singleList.add("5");
        return  singleList;
    }

    private void logFormDemoVO(FormDemoVO formDemoVO) {
        log.info("Email: " + formDemoVO.getEmail());
        log.info("Password: " + formDemoVO.getPassword());
        for(String chkbox : formDemoVO.getCheckboxes()){
            log.info("CheckBoxes: " + chkbox);
        }
        log.info("TextArea: " + formDemoVO.getTextarea());
        log.info("Radio: " + formDemoVO.getRadios());
        log.info("Single Select: " + formDemoVO.getSelectSingle());
        log.info("Multiple Select: " + formDemoVO.getSelectMultiple());
    }

    private void convertCheckBoxes(FormDemoVO formDemoVO) {
        String str = "";
        for(String chkbox : formDemoVO.getCheckboxes()){
            str = str.concat(chkbox);
        }
        formDemoVO.setCheckboxVal(str);
    }
}
