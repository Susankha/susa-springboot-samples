package com.susa.sample.service;

import com.susa.sample.model.Employee;

public interface EmployeeService {

    void addEmployee(Employee emp);

    Employee getEmployee(long id);

}
