package com.susa.sample.controller;

import com.susa.sample.model.Employee;
import com.susa.sample.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeService;

    @PostMapping("/")
    public void addEmployee(@RequestBody Employee emp) {
        System.out.println("Adding employee with id: "+emp.getId());
        employeeService.addEmployee(emp);
    }

    @GetMapping("/findbyid/{empId}")
    public Employee getEmployeeById(@PathVariable long empId) {
        System.out.println("Getting employee with id: ");
        return employeeService.getEmployee(empId);
    }

}
