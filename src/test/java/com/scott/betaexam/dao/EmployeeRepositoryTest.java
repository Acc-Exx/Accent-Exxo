package com.scott.betaexam.dao;

import com.scott.betaexam.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository repo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        /*Employee employee1 = Employee.builder().employeeId(2).name("Sanyu").email("sanyu@gmail.com").addressLine1("kurla,Mumbai").city("Mumbai").state("Maharashtra").createDate(new Timestamp(System.currentTimeMillis())).build();
        List<Employee> list = new ArrayList<>();
        list.add(employee);
        list.add(employee1);*/
       // when(repo.findByName("Sanyu")).thenReturn(list);
       // when(repo.findByEmail("sanyu@gmail.com")).thenReturn(list);
    }

    @Test
    public void findByNameTest() {
        Employee employee = Employee.builder().name("Sanyu").email("sanyu@gmail.com").addressLine1("kurla,Mumbai").city("Mumbai").state("Maharashtra").createDate(new Timestamp(System.currentTimeMillis())).build();
        repo.save(employee);
        Employee employee1 = Employee.builder().name("Sanyu").email("sanyu@gmail.com").addressLine1("kurla,Mumbai").city("Mumbai").state("Maharashtra").createDate(new Timestamp(System.currentTimeMillis())).build();
        repo.save(employee1);
        List<Employee> employeeList = repo.getEmployeeByNameOrEmail("Sanyu","sanyu@gmail.com");
        assertEquals(2, employeeList.size());
    }

    /*@Test
    public void findByEmailTest() {
        Employee employee = Employee.builder().name("Sanyu").email("sanyu@gmail.com").addressLine1("kurla,Mumbai").city("Mumbai").state("Maharashtra").createDate(new Timestamp(System.currentTimeMillis())).build();
        repo.save(employee);
         List<Employee> employeeList = repo.findByEmail("sanyu@gmail.com");
        assertEquals(1, employeeList.size());
    }*/
}
