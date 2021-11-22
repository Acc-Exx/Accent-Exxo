package com.scott.betaexam.controller;

import com.scott.betaexam.model.Employee;
import com.scott.betaexam.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/hello")
    public String helloDemo(){
        return "Hello Demo mapped.";
    }

    @GetMapping("/employee")
    public List<Employee> getAllEmployee()
    {
        return  employeeService.findAllEmployee();
    }


    @GetMapping("/employee/{name}")
    public List<Employee> findAllEmployeeBYName(@PathVariable String name)
    {
        return  employeeService.findAllEmployeeBYName(name);
    }



    @PostMapping("/employeeSave")
    public UUID saveOrUpdateEmployee(@RequestBody Employee emp)
    {
        return  employeeService.saveEmployee(emp);
    }


}
