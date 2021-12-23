package com.scott.betaexam.service;

import com.scott.betaexam.vo.EmployeeVO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class BetaServiceImplTest {
    @Mock
    BetaExamServiceImpl betaExamService;

    @Before
    public void initMocks() {
        MockitoAnnotations.openMocks(this);

    }

    @Test
    public void testGetEmployeeDetails(){
        List<EmployeeVO> employeeVOList = betaExamService.getEmployeeDetails();
        assertNotNull(employeeVOList);
    }
    @Test
    public void testGetEmployeeDetailsByEmail(){
        List<EmployeeVO> employeeVOList = betaExamService.getEmployeeDetailsByEmail("test@gmail.com");
        assertNotNull(employeeVOList);
    }

    @Test
    public void testGetEmployeeDetailsByName(){
        List<EmployeeVO> employeeVOList = betaExamService.getEmployeeDetailsByEmail("test");
        assertNotNull(employeeVOList);
    }

    @Test
    public void testSaveEmployeeDetails(){
        EmployeeVO employeeVO = new EmployeeVO();
        employeeVO.setId("testId");
        employeeVO.setName("testname");
        employeeVO.setEmail("test@gmail.com");
        employeeVO.setAddressLine1("address1");
        employeeVO.setCity("city");
        employeeVO.setState("state");
        employeeVO.setCreationDate("2021-01-02T00:00:00.127");
        Mockito.when(betaExamService.saveOrUpdateEmployeeDetails(employeeVO)).thenReturn("test");
        String message = betaExamService.saveOrUpdateEmployeeDetails(employeeVO);
        assertNotNull(message);
    }

}
