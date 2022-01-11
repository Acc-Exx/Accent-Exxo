package com.scott.betaexam;

import com.scott.betaexam.model.Employee;
import com.scott.betaexam.repo.EmployeeRepository;
import com.scott.betaexam.service.EmployeeService;
import com.scott.betaexam.service.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import static org.junit.Assert.*;

@SpringBootTest
public class EmployeeServiceImplTest {

    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @Autowired
    EmployeeService employeeService;

    @MockBean
    EmployeeRepository employeeRepository;

    @BeforeEach
    void setup(){
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employeeData());
        Mockito.when(employeeRepository.findByEmail(Mockito.anyString())).thenReturn(employeeData());
        Mockito.when(employeeRepository.findByNameContaining(Mockito.anyString())).thenReturn(employeeList);
        Mockito.when(employeeRepository.save(Mockito.any())).thenReturn(employeeData());
    }

    private Employee employeeData() {
        Employee emp = new Employee();
        emp.setId(UUID.fromString("cc5a8d9f-21dd-4ce0-9e7f-18090b3d3268"));
        emp.setName("Sams Dan");
        emp.setEmail("samsdan@accn.com");
        emp.setAddressLine1("St John's Anglican Church");
        emp.setCity("Canberra");
        emp.setState("New South Wales");

        LocalDateTime time = LocalDateTime.now();
        //   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        //   LocalDateTime time = formatter.parse(time);

        emp.setCreatedAt(time);
        //emp.setCreatedAt("2021-01-03T00:00:00.131");
        return emp;
    }

    @Test
    public void getEmployeeDetailsWithValidInput(){
        assertNotNull(employeeService.getEmployees("Sam"));
        assertEquals(1, employeeService.getEmployees("Sam").size());
    }

    @Test
    public void getEmployeeDetailByEmailWithValidInput() {
        assertNotEquals("SamsDan",employeeService.getEmployeeByEmail("samsdan@accn.com").getName());
        assertEquals("cc5a8d9f-21dd-4ce0-9e7f-18090b3d3268", employeeService.getEmployeeByEmail("samsdan@accn.com").getId().toString());
        assertEquals("Sams Dan",employeeService.getEmployeeByEmail("samsdan@accn.com").getName());
    }

    @Test
    public void saveEmployeeWithValidData(){
        assertNotNull(employeeService.saveEmployee(employeeData()));
        assertEquals("Sams Dan", employeeService.saveEmployee(employeeData()).getName());
    }
}
