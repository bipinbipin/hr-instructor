package com.astontech.hr.bootstrap;

import com.astontech.hr.domain.Employee;
import com.astontech.hr.domain.GlobalParameters;
import com.astontech.hr.domain.Person;
import com.astontech.hr.domain.Project;
import com.astontech.hr.repositories.PersonRepository;
import com.astontech.hr.services.EmployeeService;
import com.astontech.hr.services.GlobalParametersService;
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

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private GlobalParametersService globalParametersService;

    private Logger log = Logger.getLogger(SeedData.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
//        generateEmployees();
//        generatePersons();
//        generateProjects();
//        generateUsers();
    }

    public void generateUsers() {
        GlobalParameters globalParameters = new GlobalParameters();
        globalParameters.setTheme("sandstone");
        globalParametersService.saveGlobalParameters(globalParameters);

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

    public void generateEmployees() {

        Employee employee = new Employee();
        employee.setFirstName("Dan");
        employee.setLastName("Simmer");
        employee.setBackground("Dot Net Developer");
        employeeService.saveEmployee(employee);

        Employee employee1 = new Employee();
        employee1.setFirstName("Tony");
        employee1.setLastName("Morano");
        employee1.setBackground("Aston Trainer");
        employeeService.saveEmployee(employee1);

        Employee employee2 = new Employee();
        employee2.setFirstName("Sean");
        employee2.setLastName("Nilsen");
        employee2.setBackground("Java Principle");
        employeeService.saveEmployee(employee2);

        Employee employee3 = new Employee();
        employee3.setFirstName("Bob");
        employee3.setLastName("Dapolapolis");
        employee3.setBackground("dot Java Developer");
        employeeService.saveEmployee(employee3);


    }

}
