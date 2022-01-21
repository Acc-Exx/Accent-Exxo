package com.scott.betaexam.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scott.betaexam.model.Employee;
import com.scott.betaexam.service.EmployeeService;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @MockBean
    private EmployeeService employeeService;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetEmployees() throws Exception {
        Employee employee = Employee.builder()
                .name("Mark SAM")
                .email("MARK@accn.com")
                .addressLine1("181 E Weber Ave Stockton")
                .city("Ralf")
                .state("New York").build();

        Employee employee1 = Employee.builder()
                .name("SAM Peter")
                .email("sampeter@accn.com")
                .addressLine1("182 E Weber Ave Stockton")
                .city("Jose")
                .state("California").build();

        List<Employee> employeeList = Arrays.asList(employee, employee1);

        //Code to find Employee by NAME
        when(employeeService.getAllEmployees()).thenReturn(employeeList);
        ResultActions resultActions = mvc.perform(get("/getEmployees"));
        resultActions.andExpect(status().isOk()).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", CoreMatchers.is(employeeList.size())));
    }

    @Test
    public void testSaveEmployee() throws Exception {
        Employee employee = Employee.builder()
                .employeeId(UUID.randomUUID())
                .name("Mark SAM")
                .email("MARKSAM@accn.com")
                .addressLine1("180 E Weber Ave Stockton")
                .city("Dallas")
                .state("Texas")
                .date(String.valueOf(LocalDateTime.of(2022, 01, 21, 9, 51, 30, 123))).build();

        //given - stubbing the method call
        when(employeeService.saveEmployee(ArgumentMatchers.any(Employee.class))).thenAnswer((invocation -> invocation.getArguments()[0]));

        //when
        ResultActions resultActions = mvc.perform(post("/saveEmployee")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(employee)));

        //then - verifying the method call
        resultActions.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", CoreMatchers.is(employee.getName())));

    }

    @Test
    public void testGetEmployeeByName() throws Exception {
        Employee employee = Employee.builder()
                .name("Mark SAM")
                .email("MARK@accn.com")
                .addressLine1("181 E Weber Ave Stockton")
                .city("Ralf")
                .state("New York").build();

        Employee employee1 = Employee.builder()
                .name("SAM Peter")
                .email("sampeter@accn.com")
                .addressLine1("182 E Weber Ave Stockton")
                .city("Jose")
                .state("California").build();

        List<Employee> employeeList = Arrays.asList(employee, employee1);

        //Code to find Employee by NAME
        when(employeeService.findByEmpName("Peter")).thenReturn(employeeList);
        ResultActions resultActions = mvc.perform(get("/getEmployeeByName/Peter"));

        resultActions.andExpect(status().isOk()).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", CoreMatchers.is(employeeList.size())));
    }

    @Test
    public void testGetEmployeeByEmail() throws Exception {

        Employee employee = Employee.builder()
                .name("Mark SAM")
                .email("MARK@accn.com")
                .addressLine1("181 E Weber Ave Stockton")
                .city("Ralf")
                .state("New York").build();

        Employee employee1 = Employee.builder()
                .name("SAM Peter")
                .email("sampeter@accn.com")
                .addressLine1("182 E Weber Ave Stockton")
                .city("Jose")
                .state("California").build();

        List<Employee> employeeList = Arrays.asList(employee, employee1);

        //Code to find Employee by EMAIL
        when(employeeService.findByEmpEmail("sampeter@accn.com")).thenReturn(employeeList);
        ResultActions resultActions = mvc.perform(get("/getEmployeeByEmail/sampeter@accn.com"));

        resultActions.andExpect(status().isOk()).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", CoreMatchers.is(employeeList.size())));
    }
}
