package com.scott.betaexam.controller;

import com.scott.betaexam.exception.EmployeeNotFoundException;
import com.scott.betaexam.model.Employee;
import com.scott.betaexam.service.EmployeeService;
import com.scott.betaexam.util.EmployeeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1.0")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees/{name}")
    public List<Employee> getEmployees(@PathVariable String name) throws EmployeeNotFoundException {
        List<Employee> employees = employeeService.getEmployees(name);
        if (employees.isEmpty())
            throw new EmployeeNotFoundException();
        return employees;
    }

    @GetMapping("/employee/{email}")
    public Employee getEmployeeByEmailId(@PathVariable String email) throws EmployeeNotFoundException {
        Employee employee = employeeService.getEmployeeByEmail(email);
        if (null == employee)
            throw new EmployeeNotFoundException();
        return employee;

    }

    @PostMapping(path = "/save_employee", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        if (null == employee)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        if (!EmployeeUtil.validateEmployeeCreation(employee))
            return new ResponseEntity("Employee record can not be inserted!, Mandatory field are required to be filled.",
                    HttpStatus.BAD_REQUEST);

        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.OK);
    }
}

