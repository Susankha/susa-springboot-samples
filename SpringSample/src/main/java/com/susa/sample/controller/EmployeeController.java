package com.susa.sample.controller;

import com.susa.sample.dto.EmployeeDTO;
import com.susa.sample.model.Employee;
import com.susa.sample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    @Qualifier("employeeServiceImpl")
    EmployeeService employeeService;

    @PostMapping("/")
    public void addEmployee(@RequestBody EmployeeDTO emp) {
        System.out.println("Adding employee with id: " + emp.getId());
        employeeService.addEmployee(emp);
    }

    @GetMapping("/findbyid/{empId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long empId) {
        System.out.println("******* Getting employee with id: "+empId);
        return ResponseEntity.ok().body(employeeService.getEmployee(empId));
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees() {
        System.out.println(" ******* Getting All employees ***********");
        return ResponseEntity.ok().body(employeeService.getEmployees());
    }

}
