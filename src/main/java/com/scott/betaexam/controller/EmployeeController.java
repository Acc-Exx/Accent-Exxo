package com.scott.betaexam.controller;
import com.scott.betaexam.entity.Employee;
import com.scott.betaexam.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
@RequestMapping("/employee")
@RestController
public class EmployeeController {

@Autowired
EmployeeService employeeService ;

   @GetMapping("/getEmployeeBynameOrEmail")
    public List<Employee> getEmployeeDetails(
                      @RequestParam (name= "name", required = false) String name,
                      @RequestParam (name="email" ,required = false) String email) {
          return employeeService.getEmployeeData(name,email);
       }

   @PostMapping("/saveEmployee")
   public ResponseEntity<Employee> SaveEmployee(@Valid @RequestBody Employee employee) {

          return new ResponseEntity(employeeService.saveEmployee(employee), HttpStatus.CREATED);

       }
}
