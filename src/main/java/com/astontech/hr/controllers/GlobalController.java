package com.astontech.hr.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Created by Bipin on 5/11/2016.
 */
@ControllerAdvice
public final class GlobalController {

    @Value("${design.bootstrap.theme}")
    private String themeName;

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("theme", themeName);
    }

}
