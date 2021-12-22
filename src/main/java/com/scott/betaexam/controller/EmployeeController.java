package com.scott.betaexam.controller;

import com.scott.betaexam.model.Employee;
import com.scott.betaexam.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
public class EmployeeController {

        @Autowired
        private EmployeeService employeeService;

        private final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

        @GetMapping (value="/employee")
        public ResponseEntity<List<Employee>> getEmployeeDetails(@RequestBody(required = false) Employee employee) {
                logger.info("EmployeeController - inside getEmployeeDetails method");
                List<Employee> emp = employeeService.getEmployeeDetails(employee);
                return new ResponseEntity<>(emp, HttpStatus.OK);
        }

        @PostMapping (value="/saveemployee")
        public ResponseEntity<Employee> saveEmployeeDetails(@Valid  @RequestBody Employee employee){
                logger.info("EmployeeController - inside saveEmployeeDetails method");
                Employee emp = employeeService.saveEmployeeDetails(employee);
                return new ResponseEntity<>(Objects.nonNull(emp) ? emp : null,
                        Objects.nonNull(emp) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
        }
}
