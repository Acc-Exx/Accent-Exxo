package com.scott.betaexam.services;

import com.scott.betaexam.dto.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

@Service
public interface IEmployeeServices {
    List<Employee> findEmployeeByNameOrEmail(String filterBy);

    LinkedHashMap<String,String> insertEmployeeInfo(Employee employee) throws ParseException;

}
