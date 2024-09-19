package com.employeemanagement.employeemanagement.controller;

import com.employeemanagement.employeemanagement.dto.EmployeeDto;
import com.employeemanagement.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee=employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/byid/{id}")
    public ResponseEntity<EmployeeDto> findbyid(@PathVariable Long id){
       EmployeeDto findbyid= employeeService.getEmployeeById(id);
        return new ResponseEntity<>(findbyid,HttpStatus.OK);
    }

    @GetMapping("getallemployees")

    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto>employeeDtoList=employeeService.getAllEmployees();
        return new ResponseEntity<>(employeeDtoList,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id,@RequestBody EmployeeDto employeeDto){
       EmployeeDto updated= employeeService.updateEmployee(id,employeeDto);
        return new ResponseEntity<>(updated,HttpStatus.OK);
    }
     @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("DELETED");
     }

}
