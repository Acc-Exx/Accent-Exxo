package com.scott.betaexam.service;

import com.scott.betaexam.dao.EmployeeRepository;
import com.scott.betaexam.model.Employee;
import com.scott.betaexam.dto.EmployeeDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.when;

public class EmployeeServiceTest {

    @InjectMocks
    EmployeeService service;

    @Mock
    EmployeeRepository repo;

   /* @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }*/

    @Mock
    ModelMapper mapper;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        Employee employee = Employee.builder().employeeId(UUID.randomUUID()).name("Sanyu").email("sanyu@gmail.com").addressLine1("kurla,Mumbai").city("Mumbai").state("Maharashtra").createDate(new Timestamp(System.currentTimeMillis())).build();
        Employee employee1 = Employee.builder().employeeId(UUID.randomUUID()).name("Sanyu").email("sanyu@gmail.com").addressLine1("kurla,Mumbai").city("Mumbai").state("Maharashtra").createDate(new Timestamp(System.currentTimeMillis())).build();
        List<Employee> list = new ArrayList<>();
        list.add(employee);
        list.add(employee1);
      /*  when(repo.findByName("Sanyu")).thenReturn(list);
        when(repo.findByEmail("sanyu@gmail.com")).thenReturn(list);*/

        when(repo.getEmployeeByNameOrEmail("sanyu","sanyu@gmail.com")).thenReturn(list);

    }

   /* @Test
    public void findByNameTest() {
        List<Employee> employeeList = service.findByName("Sanyu");
        assertEquals(2, employeeList.size());
    }

    @Test
    public void findByEmailTest() {

        List<Employee> employeeList = service.findByEmail("sanyu@gmail.com");
        assertEquals(2, employeeList.size());
    }*/

    @Test
    public void findByEmailTest() {

        List<Employee> employeeList = service.getEmployeeByNameOrEmailId("sanyu","sanyu@gmail.com");
        assertEquals(2, employeeList.size());
    }

/*    @Test
    public void saveEmployeeTest() {
        UUID uuid=UUID.randomUUID();
        Employee employee = Employee.builder().name("Sanyu").email("sanyu@gmail.com").addressLine1("kurla,Mumbai").city("Mumbai").state("Maharashtra").createDate(new Timestamp(System.currentTimeMillis())).build();
        Employee employee1 = Employee.builder().employeeId(UUID.randomUUID()).name("Sanyu").email("sanyu@gmail.com").addressLine1("kurla,Mumbai").city("Mumbai").state("Maharashtra").createDate(new Timestamp(System.currentTimeMillis())).build();

        EmployeeDTO employee2 = EmployeeDTO.builder().name("Sanyu").email("sanyu@gmail.com").addressLine1("kurla,Mumbai").city("Mumbai").state("Maharashtra").createDate(new Timestamp(System.currentTimeMillis())).build();
        EmployeeDTO employee21 = EmployeeDTO.builder().employeeId(uuid).name("Sanyu").email("sanyu@gmail.com").addressLine1("kurla,Mumbai").city("Mumbai").state("Maharashtra").createDate(new Timestamp(System.currentTimeMillis())).build();

        when(mapper.map(employee2,Employee.class)).thenReturn(employee);
        when(repo.save(employee)).thenReturn(employee1);
        when(mapper.map(employee1,EmployeeDTO.class)).thenReturn(employee21);

        EmployeeDTO employeeDTO = service.saveEmployee(employee2);
        assertEquals(employeeDTO.getEmployeeId(),uuid);
    }*/
@Test
public void saveEmployeeTest() {
    UUID uuid=UUID.randomUUID();
    Employee employee = Employee.builder().name("Sanyu").email("sanyu@gmail.com").addressLine1("kurla,Mumbai").city("Mumbai").state("Maharashtra").createDate(new Timestamp(System.currentTimeMillis())).build();
    Employee employee1 = Employee.builder().employeeId(uuid).name("Sanyu").email("sanyu@gmail.com").addressLine1("kurla,Mumbai").city("Mumbai").state("Maharashtra").createDate(new Timestamp(System.currentTimeMillis())).build();

    EmployeeDTO employee2 = EmployeeDTO.builder().name("Sanyu").email("sanyu@gmail.com").addressLine1("kurla,Mumbai").city("Mumbai").state("Maharashtra").createDate(new Timestamp(System.currentTimeMillis())).build();
    EmployeeDTO employee21 = EmployeeDTO.builder().employeeId(uuid).name("Sanyu").email("sanyu@gmail.com").addressLine1("kurla,Mumbai").city("Mumbai").state("Maharashtra").createDate(new Timestamp(System.currentTimeMillis())).build();


    when(repo.save(employee)).thenReturn(employee1);
    when(mapper.map(employee1,EmployeeDTO.class)).thenReturn(employee21);

    EmployeeDTO employeeDTO = service.saveEmployee(employee2);
    assertEquals(employeeDTO.getEmployeeId(),uuid);
}

}
