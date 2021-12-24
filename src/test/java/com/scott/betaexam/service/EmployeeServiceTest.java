package com.scott.betaexam.service;

import com.scott.betaexam.Helper.FactorBeanClass;
import com.scott.betaexam.dao.EmployeeRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepository employeeRepository;

    private FactorBeanClass factorBeanClass;

    public EmployeeServiceTest(FactorBeanClass factorBeanClass) {
        this.factorBeanClass = factorBeanClass;
    }

    @Test
    public void getEmployeeTest(){
        when(employeeRepository.getEmployeeByNameOrEmailId(Mockito.any(), Mockito.any())).
                thenReturn(factorBeanClass.populateEmployee());

        Assert.assertNotNull(employeeService.getEmployee("Sam", "Sam@Acc.com"));
        Assert.assertEquals(2, employeeService.getEmployee("Sam", "sam@acc.com"));
    }

}
