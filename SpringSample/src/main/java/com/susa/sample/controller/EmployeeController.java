package com.susa.sample.controller;

import com.susa.sample.dto.EmployeeDTO;
import com.susa.sample.model.Employee;
import com.susa.sample.service.EmployeeService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

  @Autowired
  @Qualifier("employeeServiceImpl")
  EmployeeService employeeService;

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping("/")
  public void addEmployee(@RequestBody @Valid EmployeeDTO emp) {
    System.out.println("Adding employee with id: " + emp.getId());
    employeeService.addEmployee(emp);
  }

  @GetMapping("/findbyid/{empId}")
  public ResponseEntity<Employee> getEmployeeById(@PathVariable long empId) {
    System.out.println("******* Getting employee with id: " + empId);
    Employee employee = employeeService.getEmployee(empId);
    return ResponseEntity.ok().body(employee);
  }

  @GetMapping("/employees")
  public ResponseEntity<List<Employee>> getEmployees() {
    System.out.println(" ******* Getting All employees ***********");
    return ResponseEntity.ok().body(employeeService.getEmployees());
  }
}
