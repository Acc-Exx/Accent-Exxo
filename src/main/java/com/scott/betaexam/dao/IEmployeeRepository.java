package com.scott.betaexam.dao;

import com.scott.betaexam.dto.Employee;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.util.List;

@Repository
public interface IEmployeeRepository {

    List<Employee> findEmployeeByNameOrEmail(String filterByAny,String filterWith);

    Employee insertEmployeeInfo(Employee employee) throws ParseException;


}
