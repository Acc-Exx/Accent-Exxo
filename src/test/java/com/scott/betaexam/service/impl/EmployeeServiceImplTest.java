package com.scott.betaexam.service.impl;

import com.scott.betaexam.entity.Employee;
import com.scott.betaexam.repository.EmployeeRepository;
import com.scott.betaexam.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTest {

    @InjectMocks
    EmployeeService employeeService;

    @Mock
    private EmployeeRepository empRepo;

    @BeforeEach
    public void init(){

    }

    public void globalSerachTest1(){

        Employee e1=new Employee();
        Employee e2=new Employee();
        List<Employee> employees= Arrays.asList(e1,e2);
        when(empRepo.findAll()).thenReturn(employees);
        assertEquals(employeeService.globalSearch("Shubham"),null);

    }

    public void globalSerachTest2(){

        Employee e1=new Employee();
        e1.setName("Shubham");
        Employee e2=new Employee();
        List<Employee> employees= Arrays.asList(e1,e2);
        when(empRepo.findAll()).thenReturn(employees);
        assertEquals(employeeService.globalSearch("Shubham").size(),1);

    }

    @Test
    public void addOrUpdateEmployeeTest()
    {
        Employee e1=new Employee();
        e1.setName("Shubham");
        e1.setEmployeeId("123");
        e1.setEmail("abc@gmail.com");

        employeeService.addOrUpdateEmployee(e1);
    }


}
