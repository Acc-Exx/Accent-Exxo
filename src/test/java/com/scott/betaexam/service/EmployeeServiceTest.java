package com.scott.betaexam.service;

import com.scott.betaexam.dao.EmployeeRepository;
import com.scott.betaexam.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepository employeeRepository;

    @BeforeEach
    void setup(){
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employeeData());

        Mockito.when(employeeRepository.getEmployeeByNameOrEmailId(Mockito.anyString(), Mockito.anyString())).
                thenReturn(employeeList);
        Mockito.when(employeeRepository.save(Mockito.any())).thenReturn(employeeData());
    }

    private Employee employeeData() {
        Employee emp = new Employee();
        emp.setId(UUID.fromString("e2ab4d57-89c0-4eb2-b6b1-3c6b803a3ba8"));
        emp.setName("SAM");
        emp.setEmail("SAM@ACC.COM");
        emp.setAddress("Downtown San Jose");
        emp.setCity("SanJose");
        emp.setState("California");
        emp.setCreateDate("2021-12-24 19:11:53.040");
        return emp;
    }

    @Test
    public void shouldReturn_EmployeeDetails_WhenValidInput_IsPassedTest(){
        assertNotNull(employeeService.getEmployee("Sam", "Sam@Acc.com"));
        assertEquals(1, employeeService.getEmployee("Sam", "sam@acc.com").size());
    }

    @Test
    public void shouldMatch_WhenValid_EmployeeData_IsPassedTest() {
        assertNotEquals("Sam",employeeService.getEmployee("Sam", "sam@acc.com").get(0).getName());
        assertEquals("SAM",employeeService.getEmployee("Sam", "sam@acc.com").get(0).getName());
        assertEquals("e2ab4d57-89c0-4eb2-b6b1-3c6b803a3ba8", employeeService.getEmployee("Sam", "sam@acc.com").get(0).getId().toString());
    }

    @Test
    public void shouldSave_EmployeeDetails_WhenValidInput_IsPassedTest(){
        assertNotNull(employeeService.saveEmployee(employeeData()));
        assertEquals("SAM", employeeService.saveEmployee(employeeData()).getName());
    }
}
