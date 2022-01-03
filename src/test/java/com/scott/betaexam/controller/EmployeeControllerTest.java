package com.scott.betaexam.controller;


import com.scott.betaexam.model.Employee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EmployeeControllerTest {
    @Mock
    EmployeeController employeeController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    static List<Employee> employeesList = new ArrayList<>();
    static Employee e1 = new Employee();

    @BeforeAll
    static void initObjects() {
        e1.setId("82828hahjwA172njssW119");
        e1.setEmail("samsdan@accn.com");
        e1.setCreatedTimestamp("2022-01-03T09:47:48.126");
        e1.setCity("Brooklyn");
        e1.setAddressLine1("Brooklyn New York");
        e1.setState("New York");
        e1.setName("Sam Will");
        employeesList.add(e1);
    }

    @Test
    public void testCreateEmployee(){
        ResponseEntity<Employee> employee =null;
        Mockito.when(employeeController.createEmployee(e1)).thenReturn(new ResponseEntity<Employee>(e1,HttpStatus.OK));
        try {
            employee= employeeController.createEmployee(e1);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        assertNotNull(employee);
    }

    @Test
    public void testSearchEmployees(){
        ResponseEntity<List<Employee>> employees =null;
        Mockito.when(employeeController.searchEmployees()).thenReturn(new ResponseEntity<List<Employee>>(employeesList,HttpStatus.OK));
        try {
            employees= employeeController.searchEmployees();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        assertNotNull(employees);
    }

    @Test
    public void testSearchEmployeeByName(){
        ResponseEntity<List<Employee>> employees =null;
        Mockito.when(employeeController.searchEmployeeByName("sam")).thenReturn(new ResponseEntity<List<Employee>>(employeesList,HttpStatus.OK));
        try {
            employees= employeeController.searchEmployeeByName("sam");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        assertNotNull(employees);
    }

    @Test
    public void testSearchEmployeeByEmail(){
        ResponseEntity<List<Employee>> employees =null;
        Mockito.when(employeeController.searchEmployeeByEmail("samsdan@accn.com")).thenReturn(new ResponseEntity<List<Employee>>(employeesList,HttpStatus.OK));
        try {
            employees= employeeController.searchEmployeeByEmail("samsdan@accn.com");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        assertNotNull(employees);
    }
    
}
