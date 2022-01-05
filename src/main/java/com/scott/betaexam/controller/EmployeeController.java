package com.scott.betaexam.controller;

import com.scott.betaexam.entity.Employee;
import com.scott.betaexam.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("employee")
@Slf4j
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = "/getEmployeeByName/{name}")
    public ResponseEntity<List<Employee>> getEmployeeByName(@PathVariable(value= "name") String name) {
        log.info("Inside EmployeeController:getEmployeeByName()");
        if(StringUtils.isEmpty(name)) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }

        List<Employee> employeeList = employeeService.getEmployeeByName(name);
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @GetMapping(value = "/getEmployeeByEmail/{email}")
    public ResponseEntity<List<Employee>> getEmployeeByEmail(@PathVariable(value= "email") String email) {
        log.info("Inside EmployeeController:getEmployeeByEmail()");
        if(StringUtils.isEmpty(email)) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
        List<Employee> employeeList = employeeService.getEmployeeByEmail(email);
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @PostMapping(value = "/createEmployee",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        log.info("Inside EmployeeController:createEmployee()");
        if (employee == null) {
            return new ResponseEntity<>((Employee) null, HttpStatus.BAD_REQUEST);
        }

        if (employee.getAddressLine1() == null || employee.getCity() == null || employee.getState() == null) {
            return new ResponseEntity("Employee cannot be created. Address, City, State should all be filled.", HttpStatus.BAD_REQUEST);
        }

        Employee employeeCreated = employeeService.createEmployee(employee);
        if (Optional.ofNullable(employeeCreated).isPresent()) {
            return new ResponseEntity<>(employeeCreated, HttpStatus.CREATED);
        }
        return null;
    }

    @GetMapping("/helloWorld")
    public String helloWorld(){
        return "Hello World";
    }
}
