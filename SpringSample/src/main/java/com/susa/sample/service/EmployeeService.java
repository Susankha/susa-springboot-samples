package com.susa.sample.service;

import com.susa.sample.dto.EmployeeDTO;
import com.susa.sample.model.Employee;

public interface EmployeeService {

    void addEmployee(EmployeeDTO emp);

    Employee getEmployee(long id);

}
