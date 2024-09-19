package com.employeemanagement.employeemanagement.service;

import com.employeemanagement.employeemanagement.dto.EmployeeDto;
import com.employeemanagement.employeemanagement.entity.Employee;
import com.employeemanagement.employeemanagement.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeID);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long id,EmployeeDto employeeDto);
    void deleteEmployee(Long id);

}
