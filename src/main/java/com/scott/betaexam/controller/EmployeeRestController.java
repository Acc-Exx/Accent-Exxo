package com.scott.betaexam.controller;


import com.scott.betaexam.entity.Employee;
import com.scott.betaexam.service.EmployeeService;
import com.scott.betaexam.util.EmployeeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Employees")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeUtil employeeUtil;

    @GetMapping("findEmployees/{keyword}")
    public ResponseEntity<List<Employee>> getGlobalSerachedEmployees(@PathVariable String keyword){

        List<Employee> matchedEmployees=null;
        try{
            matchedEmployees= employeeService.globalSearch(keyword);
            if(null==matchedEmployees){
                matchedEmployees=new ArrayList<>();
            }
        }
        catch(Exception ex){
            ex.getMessage();
        }
        return new ResponseEntity<List<Employee>>(matchedEmployees, HttpStatus.OK);

    }

    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> addorUpdateEmployee(@RequestBody Employee employee) throws Exception {

        if (employeeUtil.validateEmployee(employee)){
            try {
                employeeService.addOrUpdateEmployee(employee);
                return new ResponseEntity<Employee>(employee, HttpStatus.OK);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        return new ResponseEntity<Employee>(employee, HttpStatus.BAD_REQUEST);
        }
        throw new Exception("Input Data is in invalid format");

    }


}
