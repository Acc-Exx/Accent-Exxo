package com.scott.betaexam.restController;


import com.scott.betaexam.dto.Employee;
import com.scott.betaexam.services.IEmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    IEmployeeServices iEmployeeServices;

    @GetMapping("/getEmployeeBySearch")
    public List<Employee> getEmployeeBySearch(@RequestParam String filterByAny) {
        List<Employee> getEmployeeList = iEmployeeServices.findEmployeeByNameOrEmail(filterByAny);
        return getEmployeeList;
    }

    @PostMapping("/insertEmployeeInfo")
    public  HashMap<String,String> insertEmployeeInfo(@RequestBody Employee employee)throws ParseException {
        LinkedHashMap<String,String> resp=iEmployeeServices.insertEmployeeInfo(employee);
        return resp;
    }
}
