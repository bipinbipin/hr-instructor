package com.astontech.hr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Bipin on 3/24/2016.
 */
@Controller
public class IndexController {

    @RequestMapping(value="/")
    public String index() {
        return "index";
    }

}
