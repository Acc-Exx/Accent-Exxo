package com.scott.betaexam.controller;

import com.google.gson.Gson;
import com.scott.betaexam.model.Employee;
import com.scott.betaexam.model.EmployeeDTO;
import com.scott.betaexam.service.EmployeeService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @MockBean
    EmployeeService employeeService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testfindByName() throws Exception {
        UUID uuid = UUID.randomUUID();
        UUID uuid1 = UUID.randomUUID();

        Employee employee = Employee.builder().employeeId(UUID.randomUUID()).name("Sanyu").email("sanyu@gmail.com").addressLine1("kurla,Mumbai").city("Mumbai").state("Maharashtra").createDate(new Timestamp(System.currentTimeMillis())).build();
        Employee employee1 = Employee.builder().employeeId(UUID.randomUUID()).name("Sanyu").email("sanyu@gmail.com").addressLine1("kurla,Mumbai").city("Mumbai").state("Maharashtra").createDate(new Timestamp(System.currentTimeMillis())).build();
        List<Employee> list = new ArrayList<>();
        list.add(employee);
        list.add(employee1);
        //  given(service.findByName("Sanyu")).willReturn(list);
        when(employeeService.findByName("sanyu")).thenReturn(list);
        this.mockMvc.perform(get("/employee/findByName/sanyu")).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", Matchers.is("Sanyu")));
    }

    @Test
    public void testfindByEmail() throws Exception {
        Employee employee = Employee.builder().employeeId(UUID.randomUUID()).name("Sanyu").email("sanyu@gmail.com").addressLine1("kurla,Mumbai").city("Mumbai").state("Maharashtra").createDate(new Timestamp(System.currentTimeMillis())).build();
        Employee employee1 = Employee.builder().employeeId(UUID.randomUUID()).name("Sanyu").email("sanyu@gmail.com").addressLine1("kurla,Mumbai").city("Mumbai").state("Maharashtra").createDate(new Timestamp(System.currentTimeMillis())).build();
        List<Employee> list = new ArrayList<>();
        list.add(employee);
        list.add(employee1);
        //  given(service.findByName("Sanyu")).willReturn(list);
        when(employeeService.findByEmail("sanyu@gmail.com")).thenReturn(list);
        this.mockMvc.perform(get("/employee/findByEmail/sanyu@gmail.com")).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].email", Matchers.is("sanyu@gmail.com")));
    }

    /*@Test
    public void saveEmployeeTest() throws Exception {
        EmployeeDTO employee2 = EmployeeDTO.builder().name("Sanyu").email("sanyu@gmail.com").addressLine1("kurla,Mumbai").city("Mumbai").state("Maharashtra").createDate(new Timestamp(System.currentTimeMillis())).build();
        EmployeeDTO employee21 = EmployeeDTO.builder().employeeId(1).name("Sanyu").email("sanyu@gmail.com").addressLine1("kurla,Mumbai").city("Mumbai").state("Maharashtra").createDate(new Timestamp(System.currentTimeMillis())).build();
        when(employeeService.saveEmployee(employee2)).thenReturn(employee21);

        this.mockMvc.perform(post("/employee/save")
                        .content(new Gson().toJson(employee2))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].employeeId", Matchers.is(1)));

    }*/

    @Test
    public void saveEmployeeTest() throws Exception {
        UUID uuid = UUID.randomUUID();
        EmployeeDTO employee2 = EmployeeDTO.builder().name("Sanyu").email("sanyu@gmail.com").addressLine1("kurla,Mumbai").city("Mumbai").state("Maharashtra").createDate(new Timestamp(System.currentTimeMillis())).build();
        EmployeeDTO employee21 = EmployeeDTO.builder().employeeId(uuid).name("Sanyu").email("sanyu@gmail.com").addressLine1("kurla,Mumbai").city("Mumbai").state("Maharashtra").createDate(new Timestamp(System.currentTimeMillis())).build();
        // when(employeeService.saveEmployee(employee2)).thenReturn(employee21);
        given(employeeService.saveEmployee(employee2)).willReturn(employee21);
        String val = " {\n  \"name\": \"sanyu1\",\n        \"email\": \"sanyu@acn.com\",\n        \"addressLine1\": \"Kurla\",\n        \"city\": \"Mumbai\",\n        \"state\": \"mhs\",\n        \"createDate\": \"2022-01-21T10:43:30.272+00:00\"\n    }";
        mockMvc.perform(post("/employee/save")
                        .content(val)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
