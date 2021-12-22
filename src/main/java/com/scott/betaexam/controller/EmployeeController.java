package com.scott.betaexam.controller;

import com.scott.betaexam.model.Employee;
import com.scott.betaexam.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

        @Autowired
        private EmployeeService employeeService;

        @GetMapping (value="/employee")
        public ResponseEntity<List<Employee>> getEmployeeDetails(){
                List<Employee> emp = employeeService.getEmployeeDetails();
                return new ResponseEntity<>(emp, HttpStatus.OK);
        }

        @PostMapping (value="/saveemployee")
        public ResponseEntity<Employee> saveEmployeeDetails(@RequestBody Employee employee){
                Employee emp = employeeService.saveEmployeeDetails(employee);
                return new ResponseEntity<>(emp, HttpStatus.OK);
        }
}
