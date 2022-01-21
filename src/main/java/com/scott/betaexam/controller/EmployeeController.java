package com.scott.betaexam.controller;

//import com.google.gson.Gson;
import com.google.gson.Gson;
import com.scott.betaexam.model.Employee;
import com.scott.betaexam.model.EmployeeDTO;
import com.scott.betaexam.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

  /*  EmployeeController(EmployeeService service){
       this.service=service;
   }*/

   @GetMapping(value = "/findByName/{name}")
   public ResponseEntity<List<Employee>> getEmployeeListByName(@PathVariable("name") String name){
       List<Employee> list= service.findByName(name);
      // String val=  new Gson().toJson(list);
       return new ResponseEntity<>(list,HttpStatus.OK);
   }

    @GetMapping(value = "/findByEmail/{email}")
  //  public String getEmployeeListByEmail(@PathVariable("email") String email){
        public ResponseEntity<List<Employee>> getEmployeeListByEmail(@PathVariable("email") String email){
            List<Employee> list= service.findByEmail(email);
       //return new Gson().toJson(list);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<?> saveEmployee(@RequestBody EmployeeDTO  empDto){
        EmployeeDTO response = service.saveEmployee(empDto);
       return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
