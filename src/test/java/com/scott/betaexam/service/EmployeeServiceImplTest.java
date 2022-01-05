package com.scott.betaexam.service;

import com.scott.betaexam.entity.Employee;
import com.scott.betaexam.repository.EmployeeRepository;
import com.scott.betaexam.service.impl.EmployeeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTest {

    @InjectMocks
    EmployeeServiceImpl employeeService;

    @Mock
    EmployeeRepository employeeRepository;

    @Before
    public void initMocks() {
        MockitoAnnotations.openMocks(this);

    }

    @Test
    public void shouldGetEmployeeByName() {
        List<Employee> employeeList = getEmployeeList();
        when(employeeRepository.findByNameContaining(any())).thenReturn(employeeList);
        List<Employee> expectedEmployee = employeeService.getEmployeeByName("Dummy Name");

        assertThat(expectedEmployee.size(), is(1));
    }

    @Test
    public void shouldGetEmployeeByEmail() {
        List<Employee> employeeList = getEmployeeList();
        when(employeeRepository.findByNameContaining(any())).thenReturn(employeeList);
        List<Employee> expectedEmployee = employeeService.getEmployeeByEmail("DummyEmail@acc.com");

        assertThat(expectedEmployee.size(), is(1));
    }

    @Test
    public void shouldCreateEmployee() {
        Employee employee = getEmployee();
        when(employeeRepository.save(any())).thenReturn(employee);
        Employee expectedEmployee = employeeService.createEmployee(employee);

        assertThat(expectedEmployee.getName(), is("Dummy Name"));
    }

    public List<Employee> getEmployeeList() {
        List<Employee> employeeList = new ArrayList<>();

        Employee employee = new Employee();
        employee.setName("Dummy Name");
        employee.setEmail("DummyEmail@acc.com");
        employee.setState("Gujarat");
        employee.setId("4028fc6d7e261374017e261380e70000");
        employee.setCity("Ahmedabad");
        employeeList.add(employee);

        return employeeList;
    }

    public Employee getEmployee() {
        Employee employee = new Employee();
        employee.setName("Dummy Name");
        employee.setEmail("DummyEmail@acc.com");
        employee.setState("Gujarat");
        employee.setId("4028fc6d7e261374017e261380e70000");
        employee.setCity("Ahmedabad");
        return employee;
    }
}
