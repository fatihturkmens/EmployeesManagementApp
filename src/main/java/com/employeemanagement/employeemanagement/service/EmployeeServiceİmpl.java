package com.employeemanagement.employeemanagement.service;

import com.employeemanagement.employeemanagement.dto.EmployeeDto;
import com.employeemanagement.employeemanagement.entity.Employee;
import com.employeemanagement.employeemanagement.exception.ResourceNotFoundException;
import com.employeemanagement.employeemanagement.mapper.EmployeeMapper;
import com.employeemanagement.employeemanagement.repository.EmployeesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceİmpl implements EmployeeService{


    private EmployeesRepository employeesRepository;


    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedemployee=employeesRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedemployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeID) {
       Employee employee= employeesRepository.findById(employeeID).orElseThrow(() ->
                new ResourceNotFoundException("Employee is not exist :"+employeeID));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {

        List<Employee>employeeList=employeesRepository.findAll();
        return employeeList.stream().map((employee -> EmployeeMapper.mapToEmployeeDto(employee))).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        Employee employee=employeesRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employe is not exist"+id));
       employee.setFirstName(employeeDto.getFirstName());
       employee.setLastName(employeeDto.getLastName());
       employee.setEmail(employeeDto.getEmail());

       Employee updatedemployee= employeesRepository.save(employee);
       return EmployeeMapper.mapToEmployeeDto(updatedemployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee=employeesRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employe is not exist"+id));
      employeesRepository.deleteById(id);

    }
}
