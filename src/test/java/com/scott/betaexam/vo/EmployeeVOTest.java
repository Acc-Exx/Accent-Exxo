package com.scott.betaexam.vo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)

public class EmployeeVOTest {

    @Mock
    EmployeeVO employeeVO;

    @Test
    public void testEmployeeVO(){
        employeeVO = new EmployeeVO();
        employeeVO.setId("testId");
        employeeVO.setName("testname");
        employeeVO.setEmail("test@gmail.com");
        employeeVO.setAddressLine1("address1");
        employeeVO.setCity("city");
        employeeVO.setState("state");
        employeeVO.setCreationDate("2021-01-02T00:00:00.127");
        Assert.assertEquals(employeeVO.getId(),"testId");
        Assert.assertEquals(employeeVO.getName(),"testname");
        Assert.assertEquals(employeeVO.getEmail(),"test@gmail.com");
        Assert.assertEquals(employeeVO.getAddressLine1(),"address1");
        Assert.assertEquals(employeeVO.getCity(),"city");
        Assert.assertEquals(employeeVO.getState(),"state");
        Assert.assertEquals(employeeVO.getCreationDate(),"2021-01-02T00:00:00.127");
    }

}
