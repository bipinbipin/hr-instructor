package com.astontech.hr.bootstrap;

import com.astontech.hr.domain.Person;
import com.astontech.hr.domain.Project;
import com.astontech.hr.repositories.PersonRepository;
import com.astontech.hr.services.ProjectService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bipin on 4/25/2016.
 */
@Component
public class SeedData implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ProjectService projectService;

    private Logger log = Logger.getLogger(SeedData.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        generatePersons();
        generateProjects();
    }

    public void generateProjects(){
        Project p1 = new Project();
        p1.setClientName("UHG");
        p1.setProjectName("Cirrus");
        p1.setFieldRate(22);
        projectService.saveProject(p1);


        Project p2 = new Project();
        p2.setClientName("Medisur");
        p2.setProjectName("Ajudication");
        p2.setFieldRate(20);
        projectService.saveProject(p2);


        Project p3 = new Project();
        p3.setClientName("Target");
        p3.setProjectName("OrderPluz");
        p3.setFieldRate(19);
        projectService.saveProject(p3);


        Project p4 = new Project();
        p4.setClientName("US Bank");
        p4.setProjectName("LifeRay");
        p4.setFieldRate(21);
        projectService.saveProject(p4);

    }

    public void generatePersons() {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Bipin", "Butala"));
        personList.add(new Person("Dan", "Simmer"));
        personList.add(new Person("Sean", "Nilsen"));
        personList.add(new Person("Sarah", "Butala"));
        personList.add(new Person("Olive", "Butala"));
        personList.add(new Person("Vasant", "Butala"));

        personRepository.save(personList);
    }

}
