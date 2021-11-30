package com.scott.betaexam;

import com.scott.betaexam.dao.EmployeeDAO;
import com.scott.betaexam.model.Employee;
import com.scott.betaexam.model.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
    private EmployeeDAO employeeDAO;

    @GetMapping(path = "/", produces="application/json")
    public Employees getEmployess(){
        return employeeDAO.getAllEmployees();

    }

    @PostMapping(path="/",consumes="application/json")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee)
    {

        String id = employeeDAO.getAllEmployees().getEmployeeList().toString();
        employee.setId(UUID.fromString(id));
        employeeDAO.addEmployee(employee);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employee.getId()).toUri();

        return  ResponseEntity.created(location).build();
    }

}
