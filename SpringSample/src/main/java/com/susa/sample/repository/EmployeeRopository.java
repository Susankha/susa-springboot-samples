package com.susa.sample.repository;

import com.susa.sample.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRopository extends JpaRepository<Employee,Long> {
}
