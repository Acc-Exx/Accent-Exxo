package com.scott.betaexam.controller;

import com.scott.betaexam.vo.EmployeeVO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.Assert.assertNotNull;




public class BetaExamApplicationControllerTest {
    @Mock
    BetaExamApplicationController betaExamApplicationController;

    @Before
    public void initMocks() {
        MockitoAnnotations.openMocks(this);

    }

    @Test
    public void testGetEmployeeDetails(){
        ResponseEntity<List<EmployeeVO>> employees =null;
        Mockito.when(betaExamApplicationController.getEmployeeDetails()).thenReturn(new ResponseEntity<List<EmployeeVO>>(HttpStatus.OK));

         try {
             employees =betaExamApplicationController.getEmployeeDetails();
         }
        catch(Exception ex){
            ex.printStackTrace();
        }
        assertNotNull(employees);
    }

    @Test
    public void testGetEmployeeDetailsByEmail(){
        ResponseEntity<List<EmployeeVO>> employees =null;
        Mockito.when(betaExamApplicationController.getEmployeeDetailsByEmail("test@gmail.com")).thenReturn(new ResponseEntity<List<EmployeeVO>>(HttpStatus.OK));
        try {
           employees= betaExamApplicationController.getEmployeeDetailsByEmail("test@gmail.com");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        assertNotNull(employees);
    }


    @Test
    public void testGetEmployeeDetailsByName(){
        ResponseEntity<List<EmployeeVO>> employees =null;
        Mockito.when(betaExamApplicationController.getEmployeeDetailsByEmail("Test")).thenReturn(new ResponseEntity<List<EmployeeVO>>(HttpStatus.OK));
        try {
           employees= betaExamApplicationController.getEmployeeDetailsByEmail("Test");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        assertNotNull(employees);
    }

    @Test
    public void testSaveEmployeeDetails(){
        ResponseEntity<String> response =null;
        EmployeeVO employeeVO = new EmployeeVO();
        employeeVO.setId("testId");
        employeeVO.setName("testname");
        employeeVO.setEmail("test@gmail.com");
        employeeVO.setAddressLine1("address1");
        employeeVO.setCity("city");
        employeeVO.setState("state");
        employeeVO.setCreationDate("2021-01-02T00:00:00.127");
        Mockito.when(betaExamApplicationController.saveEmployeeDetails(employeeVO)).thenReturn(new ResponseEntity<String>(HttpStatus.OK));
        try {
           response = betaExamApplicationController.saveEmployeeDetails(employeeVO);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        assertNotNull(response);
    }

}
