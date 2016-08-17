package com.astontech.hr.rest;

import com.astontech.hr.domain.Employee;
import com.astontech.hr.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Bipin on 8/16/2016.
 */
@RestController
@RequestMapping("/api/employee")
public class EmployeeRest {

    //region VIDEO 1

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Employee> employeeGetAll() {
        return employeeService.listAllEmployees();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Employee employeeGetById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    //endregion

    //region VIDEO 2

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Employee employeeSave(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    //endregion
}
