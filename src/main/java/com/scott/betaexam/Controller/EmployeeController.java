package com.scott.betaexam.Controller;

import com.scott.betaexam.Model.Employee;
import com.scott.betaexam.Service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

//    @GetMapping("/employee")
//    public String getEmployees()
//    {
//        return "Success Response";
//       // List<Employee> employeeList = employeeService.retrieveEmployees(name)
//    }

    @PostMapping("/postTest")
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee)
    {
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.OK);
    }

 //   @GetMapping(path = "/testGet", produces = "application/json")
    @GetMapping(path = "/testGet", produces = "application/json")
    public List<Employee> getEmployees(@RequestParam(required = false) String name,
                                       @RequestParam(required = false) String email)
    {
       // UUID empID='';
       List<Employee> employeeList = employeeService.retrieveEmployees(name,email);
       return employeeList;
    }

}
