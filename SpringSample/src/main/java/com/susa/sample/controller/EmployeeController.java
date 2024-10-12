package com.susa.sample.controller;

import com.susa.sample.dto.EmployeeDTO;
import com.susa.sample.model.Employee;
import com.susa.sample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/")
    public void addEmployee(@RequestBody EmployeeDTO emp) {
        System.out.println("Adding employee with id: "+emp.getId());
        employeeService.addEmployee(emp);
    }

    @GetMapping("/findbyid/{empId}")
    public Employee getEmployeeById(@PathVariable long empId) {
        System.out.println("Getting employee with id: ");
        return employeeService.getEmployee(empId);
    }

}
