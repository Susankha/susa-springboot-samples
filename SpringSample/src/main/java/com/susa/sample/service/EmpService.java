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
public class EmpService implements EmployeeService {

  @Autowired
  private EmployeeRepository empRepo;

  ArrayList<Employee> empList = new ArrayList<Employee>();
  EmployeeMapper empMapper;

  public EmpService() {
    System.out.println(" ******** EP service *********");
  }

  @Override
  public void addEmployee(EmployeeDTO emp) {
    empMapper = new EmployeeMapper();
    Employee employee = empMapper.mapEmpDTOtoEmp(emp);
    System.out.println(" ******** EP service adding employee with id: " + employee.getId());
    empList.add(employee);
    System.out.println(" ******** EP Inserting emp to DB ******");
    empRepo.save(employee);
    System.out.println(" ******** EP Added emp to DB ******");
  }

  @Override
  public Employee getEmployee(long id) {
    return null;
  }

  @Override
  public List<Employee> getEmployees() {
    return empList;
  }
}
