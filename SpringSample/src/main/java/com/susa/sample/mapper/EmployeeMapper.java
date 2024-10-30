package com.susa.sample.mapper;

import com.susa.sample.dto.EmployeeDTO;
import com.susa.sample.model.Employee;

public class EmployeeMapper {

  public Employee mapEmpDTOtoEmp(EmployeeDTO employeeDTO) {
    Employee employee = new Employee();
    // employee.setId(employeeDTO.getId());
    employee.setName(employeeDTO.getName());
    employee.setAge(employeeDTO.getAge());
    employee.setAddress(employeeDTO.getAddress());

    return employee;
  }
}
