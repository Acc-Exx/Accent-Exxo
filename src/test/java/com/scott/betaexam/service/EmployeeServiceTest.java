package com.scott.betaexam.service;

import com.scott.betaexam.model.Employee;
import com.scott.betaexam.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.net.HttpURLConnection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepository employeeRepository;

    @BeforeEach
    void setUp() {
        List<Employee> employeeList = new ArrayList<>();
        Employee employee = Employee.builder()
                .employeeId(UUID.fromString("cc5a8d9f-21dd-4ce0-9e7f-18090b3d3268"))
                .name("Sams Dan")
                .email("samsdan@accn.com")
                .addressLine1("St John's Anglican Church")
                .city("Canberra")
                .state("New South Wales")
                .createDate(LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS"))))
                .build();
        employeeList.add(employee);
        Mockito.when(employeeRepository.findByNameContaining("Sam")).thenReturn(employeeList);
        Mockito.when(employeeRepository.findByEmailContaining("samsdan@accn.com")).thenReturn(employeeList);
    }

    @Test
    @DisplayName("Get data based on Employee Name")
    public void whenValidEmployeeName_thenEmployeeListShouldReturn(){
        Employee employee = Employee.builder().name("Sam").build();

        List<Employee> empListFound = employeeService.getEmployeeDetails(employee);
        assertEquals(empListFound.size(),1);

    }

    @Test
    @DisplayName("Get data based on Employee email")
    public void whenValidEmployeeEmail_thenEmployeeListShouldReturn(){
        Employee employee = Employee.builder().email("samsdan@accn.com").build();

        List<Employee> empListFound = employeeService.getEmployeeDetails(employee);
        assertEquals(empListFound.size(),1);

    }
}