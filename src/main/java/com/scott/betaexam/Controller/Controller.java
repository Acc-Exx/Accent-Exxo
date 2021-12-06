package com.scott.betaexam.Controller;

import com.scott.betaexam.EmployeeNotFoundException;
import com.scott.betaexam.entity.EmployeeEntity;
import com.scott.betaexam.service.Service;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.awt.*;
import java.net.URI;
import java.util.List;


@RestController
public class Controller {
    @Autowired
    Service empservice;

    @RequestMapping(value = "emp/controller/getDetails", method= RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
         public List<EmployeeEntity> retrieveEmployee(){
           return empservice.retrieveEmployee();
       }

    @RequestMapping(value = "emp/controller/getDetailsById/{id}", method= RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
        public List<EmployeeEntity> retrieveEmployee(@PathVariable("id") Long id)throws EmployeeNotFoundException{
        EmployeeEntity employee = empservice.getEmployee(id);

            if (employee == null)
                throw new EmployeeNotFoundException(" Employee with id ==> " + id + "was not found in the data base");
            return (List<EmployeeEntity>) employee;
        }


        @RequestMapping(value = "emp/controller/addEmployee", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
            public ResponseEntity<Object> saveEmployee(@RequestBody EmployeeEntity emp){
            EmployeeEntity emp1 = empservice.saveEmployee(emp);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(emp1.getUuid()).toUri();
            return ResponseEntity.created(location).build();
        }
    }



