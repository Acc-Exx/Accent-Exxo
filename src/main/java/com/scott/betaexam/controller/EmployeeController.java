package com.scott.betaexam.controller;

import com.scott.betaexam.model.Employee;
import com.scott.betaexam.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService empService;

    @PostMapping("/create")
    public ResponseEntity createEmployee(@RequestBody Employee employee) {
        if(employee == null) {
            return new ResponseEntity<Employee>((Employee) null, HttpStatus.BAD_REQUEST);
        }
        Employee employeeCreated = empService.createEmployee(employee);
        if(Optional.ofNullable(employeeCreated).isPresent()) return new ResponseEntity<Employee>(employeeCreated, HttpStatus.CREATED);
        else return new ResponseEntity("Employee cannot be created. Address, City, State should all be filled.", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/searchName/{name}")
    public ResponseEntity<List<Employee>> searchEmployeeByName(@PathVariable(value= "name") String name) {
        if(paramNullOrEmpty(name)) {
            return new ResponseEntity<List<Employee>>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
        List<Employee> employeesSearchResult = empService.getEmployeeByName(name);
        return new ResponseEntity<List<Employee>>(employeesSearchResult, HttpStatus.OK);
    }

    @GetMapping("/searchEmail/{email}")
    public ResponseEntity<List<Employee>> searchEmployeeByEmail(@PathVariable(value= "email") String email) {
        if(paramNullOrEmpty(email)) {
            return new ResponseEntity<List<Employee>>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
        List<Employee> employeesSearchResult = empService.getEmployeeByEmail(email);
        return new ResponseEntity<List<Employee>>(employeesSearchResult, HttpStatus.OK);
    }

    @GetMapping("/searchAll")
    public ResponseEntity<List<Employee>> searchEmployees() {
        List<Employee> employeesSearchResult = empService.getAllEmployees();
        return new ResponseEntity<List<Employee>>(employeesSearchResult, HttpStatus.OK);
    }

    private boolean paramNullOrEmpty(String param) {
        return !Optional.ofNullable(param).isPresent();
    }
}
