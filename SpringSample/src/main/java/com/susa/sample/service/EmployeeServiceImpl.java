package com.susa.sample.service;

import com.susa.sample.dto.EmployeeDTO;
import com.susa.sample.mapper.EmployeeMapper;
import com.susa.sample.model.Employee;
import com.susa.sample.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  private EmployeeRepository empRepo;

  ArrayList<Employee> empList = new ArrayList<Employee>();
  EmployeeMapper empMapper;

  public EmployeeServiceImpl() {
    System.out.println(" ******* EmployeeServiceImpl  ******* ");
  }

  @Override
  public void addEmployee(EmployeeDTO emp) {
    empMapper = new EmployeeMapper();
    Employee employee = empMapper.mapEmpDTOtoEmp(emp);
    System.out.println(" adding employee with id: " + employee.getId());
    empList.add(employee);
    System.out.println("Inserting emp to DB ******");
    empRepo.save(employee);
    System.out.println("Added emp to DB ******");
  }

  @Override
  public Employee getEmployee(long empId) {
    System.out.println(" returning employee with id: " + empId);
    Employee emp = null;

    if (empRepo.findById(empId).isPresent()) {
      emp = empRepo.findById(empId).get();
      System.out.println("**** fetching emp from db ****** " + emp.getName());
    } else {
      System.out.println(" ****** No emp with " + empId);
    }
    return emp;
  }

  @Override
  public List<Employee> getEmployees() {
    return empRepo.findAll();
  }

}
