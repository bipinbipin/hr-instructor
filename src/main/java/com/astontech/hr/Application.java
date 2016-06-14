package com.astontech.hr;

import com.astontech.hr.configuration.TestComponent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.apache.tomcat.jdbc.pool.DataSource;

import java.util.Arrays;


/**
 * Created by Bipin on 3/24/2016.
 */
@SpringBootApplication
public class Application {

    @Value("${spring.datasource.driverClassName}")
    private String databaseDriverClassName;

    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @Value("${spring.datasource.username}")
    private String datasourceUsername;

    @Value("${spring.datasource.password}")
    private String datasourcePassword;

    @Bean
    public DataSource dataSource() {
        DataSource ds = new DataSource();
        ds.setDriverClassName(databaseDriverClassName);
        ds.setUrl(datasourceUrl);
        ds.setUsername(datasourceUsername);
        ds.setPassword(datasourcePassword);

        return ds;
    }

    public static void main(String[] args)  {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        //Bean names created as lowercase of class name
        TestComponent testComponent = (TestComponent) ctx.getBean("testComponent");

        //now we have the component from the context we can call methods from within it.
        testComponent.sayHello();

//        System.out.println("Entering spring boot");
//        ApplicationContext ctx = SpringApplication.run(Application.class, args);
//
//        System.out.println("Let's inspect the beans provided by Spring Boot:");
//        String[] beanNames = ctx.getBeanDefinitionNames();
//        Arrays.sort(beanNames);
//        for (String beanName : beanNames) {
//            System.out.println(beanName);
//        }

    }

}