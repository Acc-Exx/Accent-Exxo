package com.scott.betaexam.controller;

import com.scott.betaexam.entity.Employee;
import com.scott.betaexam.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    public static boolean isSubstring(String s1, String s2) {
        if (s1.length() == s2.length())
            return s1.equals(s2);
        else if (s1.length() > s2.length())
            return s1.contains(s2);
        else
            return s2.contains(s1);

    }

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees() {

        try {
            List<Employee> employeeList = new ArrayList<>();
            employeeRepository.findAll().forEach(employeeList::add);
            return new ResponseEntity<>(employeeList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getEmployeeByName/{name}")
    public ResponseEntity<List<Employee>> getEmployeeByName(@PathVariable("name") String name) {
        try {
            List<Employee> employeeList = new ArrayList<>();
            employeeRepository.findAll().forEach(employeeList::add);
            List<Employee> nameEmployeeList = new ArrayList<>();
            for (Employee employee : employeeList) {
                String s1 = employee.getName().toLowerCase(Locale.ROOT);
                String s2 = name.toLowerCase(Locale.ROOT);
                if (isSubstring(s1, s2)) {
                    nameEmployeeList.add(employee);
                }

            }
            return new ResponseEntity<>(nameEmployeeList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PostMapping("/postEmployee")
    public ResponseEntity<Employee> postDetails(@RequestBody Employee employee) {
        try {
            employeeRepository.save(new Employee(employee.getId(), employee.getName(), employee.getEmail(),
                    employee.getAddressLine1(), employee.getCity(), employee.getState(), employee.getCreateDate()));
            return new ResponseEntity<>(employee, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}

