package com.scott.betaexam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("/")
    public String test()
    {
        return "Hello";
    }

    @GetMapping("/getemployee")
    public List<EmployeePojo>getAllEmployeeDetail()
    {

        return employeeService.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity<EmployeePojo> saveEmployee(@RequestBody EmployeePojo employee)
    {
        try {
            EmployeePojo employee1 =employeeService.save(employee);
            return new ResponseEntity<>(employee1, HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/getEmployeeByName/{name}")
    public List<EmployeePojo>getEmployeeByName(@PathVariable("name") String name)
    {
      return employeeService.findOne(name);
    }

}
