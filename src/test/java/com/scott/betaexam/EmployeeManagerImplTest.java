package com.scott.betaexam;
import com.scott.betaexam.entity.Employee;
import com.scott.betaexam.manager.EmployeeManager;
import com.scott.betaexam.repo.EmployeeRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static javafx.beans.binding.Bindings.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeManagerImplTest {

    @InjectMocks
    EmployeeManager employeeService;

    @Mock
    private EmployeeRepo empRepo;

    @BeforeEach
    public void init(){

    }

    public void globalSerachTest1(){

        Employee e1=new Employee();
        Employee e2=new Employee();
        List<Employee> employees= Arrays.asList(e1,e2);
     //   when(empRepo.findAll()).thenReturn(employees);
        assertEquals(employeeService.search("Gayathri Jayaraman"),null);

    }

    public void globalSerachTest2(){

        Employee e1=new Employee();
        e1.setName("Shubham");
        Employee e2=new Employee();
        List<Employee> employees= Arrays.asList(e1,e2);
     //   when(empRepo.findAll()).thenReturn(employees);
        assertEquals(employeeService.search("Gayathri").size(),1);

    }

    @Test
    public void InsertOrUpdateEmployeeTest()
    {
        Employee e1=new Employee();
        e1.setName("Gayathri");
        e1.setEmployeeId("123");
        e1.setEmail("abc@gmail.com");

        employeeService.InsertOrUpdateEmployee(e1);
    }


}