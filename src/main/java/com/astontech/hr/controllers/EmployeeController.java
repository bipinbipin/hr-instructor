package com.astontech.hr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Bipin on 8/17/2016.
 */
@Controller
public class EmployeeController {

    //this is just a very simple controller used to return a view.
    //  no logic or db/repo connectivity is in this controller.

    @RequestMapping("/employee")
    public String employeeBase() {
        return "employee";
    }


}
