package com.scott.betaexam.util;

import com.scott.betaexam.entity.Employee;
import org.junit.Before;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class EmployeeUtilTest {

    @InjectMocks
    EmployeeUtil employeeUtil;

    @BeforeEach
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void validateEmployeeTest()
    {

        assertEquals(employeeUtil.validateEmployee(new Employee()),true);
        Employee employee= new Employee();
        employee.setCity("Kolkata");
        employee.setAddressLine1("Barasat");
        assertEquals(employeeUtil.validateEmployee(employee),false);
    }




}
