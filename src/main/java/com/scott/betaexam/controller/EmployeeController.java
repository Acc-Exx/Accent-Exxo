package com.scott.betaexam.controller;

import com.scott.betaexam.model.Employee;
import com.scott.betaexam.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getEmployeeByName/{name}")
    public List<Employee> getEmployeeByName(@PathVariable ( value = "name") String name)
    {
        return employeeService.findByEmpName(name);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getEmployeeByEmail/{email}")
    public List<Employee> getEmployeeByEmail(@PathVariable ( value = "email") String email)
    {
        return employeeService.findByEmpEmail(email);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getEmployees")
    public List<Employee> getEmployees()
    {
        return employeeService.getAllEmployees();
    }


    @RequestMapping(method = RequestMethod.POST, value = "/saveEmployee")
    public Employee saveEmployee(@Valid @RequestBody Employee employee) {
        // save employee to database
        if((employee.getState() != null) && !(employee.getState().isEmpty()))
        {
            if((employee.getAddressLine1() == null) || (employee.getAddressLine1().isEmpty()) )
            {
                return employee;
            }
            if((employee.getCity() == null) || (employee.getCity().isEmpty()) )
            {
                return employee;
            }
        }
        employeeService.saveEmployee(employee);
        return employee;
    }
}
