package com.astontech.hr.services.Impl;

import com.astontech.hr.domain.Employee;
import com.astontech.hr.repositories.EmployeeRepository;
import com.astontech.hr.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Bipin on 8/16/2016.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Iterable<Employee> listAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findOne(id);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Iterable<Employee> saveEmployeeList(Iterable<Employee> employeeIterable) {
        return employeeRepository.save(employeeIterable);
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeRepository.delete(id);
    }
}
