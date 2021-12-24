package com.scott.betaexam.controller;

import com.scott.betaexam.Exception.EmployeeNotFoundException;
import com.scott.betaexam.model.Employee;
import com.scott.betaexam.service.EmployeeService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/get/emp")
    public List<Employee> getAllEmployees(@RequestParam(value = "name", required = false) String name,
                                          @RequestParam(value = "email", required = false) String email) {
        try {
             List<Employee> employeeList = employeeService.getEmployee(name, email);
             if (employeeList.size() == 0){
                 throw new EmployeeNotFoundException();
             }
             return employeeList;
        } catch (EmployeeNotFoundException e) {
            throw new EmployeeNotFoundException();
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
        return null;
    }

    @PostMapping("/save")
    public Employee saveEmployees(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }
}
