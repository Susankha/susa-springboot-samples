package com.susa.sample.service;

import com.susa.sample.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    ArrayList<Employee> empList = new ArrayList<Employee>();

    @Override
    public void addEmployee(Employee emp) {
        System.out.println(" adding employee with id: " + emp.getId());
        empList.add(emp);
    }

    @Override
    public Employee getEmployee(long empId) {
        System.out.println(" returning employee with id: "+empId);
        Employee emp = null;

        for (Employee employee : empList) {
            if (employee != null && employee.getId() == empId) {
                emp = employee;
                break;
            }
        }
        return emp;
    }
}
