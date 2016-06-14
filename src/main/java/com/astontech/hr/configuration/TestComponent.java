package com.astontech.hr.configuration;

import org.springframework.stereotype.Component;

/**
 * Created by Bipin on 6/2/2016.
 */
@Component  // this adds the class as a bean to the spring context
public class TestComponent {

    public void sayHello() {
        System.out.println("Hello World from the Spring Context!");
    }
}
