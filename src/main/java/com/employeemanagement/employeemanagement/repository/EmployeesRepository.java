package com.employeemanagement.employeemanagement.repository;

import com.employeemanagement.employeemanagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<Employee,Long> {
}
