package com.scott.betaexam.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Date;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeTest {
    @Mock
    Employee employee;

    @Test
    public void testEmployee(){
        employee = new Employee();
        employee.setId("testId");
        employee.setName("testname");
        employee.setEmail("test@gmail.com");
        employee.setAddressLine1("address1");
        employee.setCity("city");
        employee.setState("state");
        Date date = new Date();
        employee.setCreatedDate(date);
        Assert.assertEquals(employee.getId(),"testId");
        Assert.assertEquals(employee.getName(),"testname");
        Assert.assertEquals(employee.getEmail(),"test@gmail.com");
        Assert.assertEquals(employee.getAddressLine1(),"address1");
        Assert.assertEquals(employee.getCity(),"city");
        Assert.assertEquals(employee.getState(),"state");
        Assert.assertEquals(employee.getCreatedDate(),date);
    }

}
