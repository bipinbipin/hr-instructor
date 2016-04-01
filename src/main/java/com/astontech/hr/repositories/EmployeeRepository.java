package com.astontech.hr.repositories;

import com.astontech.hr.domain.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Bipin on 3/25/2016.
 */
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
