package com.susa.sample.service;

import com.susa.sample.dto.EmployeeDTO;
import com.susa.sample.exception.ResourceNotFoundException;
import com.susa.sample.mapper.EmployeeMapper;
import com.susa.sample.model.Employee;
import com.susa.sample.repository.EmployeeRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  ArrayList<Employee> empList = new ArrayList<Employee>();
  EmployeeMapper empMapper;
  @Autowired private EmployeeRepository empRepo;

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
  public Employee getEmployee(long empId) throws ResourceNotFoundException {
    Employee emp = null;

    if (empRepo.findById(empId).isPresent()) {
      emp = empRepo.findById(empId).get();
      System.out.println("**** fetching emp from db ****** " + emp.getName());
    } else {
      System.out.println("**** employee not found with id:" + empId);
      throw new ResourceNotFoundException("employee not found with id:" + empId);
    }
    return emp;
  }

  @Override
  public List<Employee> getEmployees() {
    List<Employee> employees = null;
    if (!empRepo.findAll().isEmpty()) {
      employees = empRepo.findAll();
      System.out.println("**** fetching employees from db ****** " + employees.size());
    } else {
      System.out.println("**** employees list is empty ****");
      throw new ResourceNotFoundException("employees list is empty");
    }
    return empRepo.findAll();
  }
}
