package com.scott.betaexam.controller;

import com.scott.betaexam.entity.Employee;
import com.scott.betaexam.manager.EmployeeManager;
import com.scott.betaexam.util.EmployeeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeManager manager;

    @Autowired
    private EmployeeUtil employeeUtil;

    @GetMapping(path = "/findEmployee/{keyword}")
    public ResponseEntity<List<Employee>> getSearchEmployee(@PathVariable String keyword){
        List<Employee> employeeList = null;
        try{
            if(null==employeeList){
                employeeList = new ArrayList<>();
            }
        }

        catch (Exception exception){
             exception.getMessage();

        }
        return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);

    }




    @RequestMapping(value = { "/addEmployee" }, method = RequestMethod.POST, consumes = {
           MediaType.APPLICATION_JSON_VALUE }, produces = {
           MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Employee> InsertOrUpdateEmployee(@RequestBody Employee employee)throws Exception{
        if(employeeUtil.validateEmployee(employee)) {
            try {

                manager.InsertOrUpdateEmployee(employee);
                return new ResponseEntity<Employee>(employee, HttpStatus.OK);
            }

             catch (Exception exception) {
                exception.getMessage();

            }

            return new ResponseEntity<Employee>(employee, HttpStatus.BAD_REQUEST);
        }
        throw new Exception("Input data is not valid format");
    }

}
