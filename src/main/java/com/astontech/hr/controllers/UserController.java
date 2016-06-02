package com.astontech.hr.controllers;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Bipin on 5/27/2016.
 */
@Controller
public class UserController {

    @Autowired
    private DataSource datasource;


}
