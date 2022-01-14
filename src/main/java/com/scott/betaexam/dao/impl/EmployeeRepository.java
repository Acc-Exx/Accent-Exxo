package com.scott.betaexam.dao.impl;

import com.scott.betaexam.dao.IEmployeeRepository;
import com.scott.betaexam.dto.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
@Slf4j
public class EmployeeRepository implements IEmployeeRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Employee> findEmployeeByNameOrEmail(String filterByAny,String filterWith) {
        List<Employee> employeeListByName = new ArrayList<>();

        try{

            jdbcTemplate.queryForObject("SELECT *FROM EMPLOYEE WHERE  "+ filterWith +" like  '%"+ filterByAny+ "%'",
                    new BeanPropertyRowMapper<Employee>(Employee.class) {
                        @Override
                        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {

                            Employee employeeList = new Employee();
                            employeeList.setId(rs.getString("ID")!=null? rs.getString("ID"):null);
                            employeeList.setName(rs.getString("NAME")!=null?rs.getString("NAME"):null);
                            employeeList.setEmail(rs.getString("EMAIL")!=null?rs.getString("EMAIL"):null);
                            employeeList.setAddress(rs.getString("ADDRESS")!=null ? rs.getString("ADDRESS"):null);
                            employeeList.setCity(rs.getString("CITY")!=null?rs.getString("CITY"):null);
                            employeeList.setState(rs.getString("STATE")!=null?rs.getString("STATE"):null);
                            employeeList.setCreateDate(rs.getTimestamp("CREATE_DATE"));
                            employeeListByName.add(employeeList);
                            return employeeList;
                        }
                    });

        }catch (Exception e){
            log.error("findEmployeeByNameOrEmail||error message"+e.getMessage());
        }

        return employeeListByName;
    }

    @Override
    public Employee insertEmployeeInfo(Employee employee) throws ParseException {
        employee.setId(UUID.randomUUID().toString());
        int returnCode=-1;

        try{
            returnCode = jdbcTemplate.update("INSERT INTO EMPLOYEE (ID, NAME, EMAIL, ADDRESS, CITY, STATE, CREATE_DATE) VALUES ("+
                   "'"+employee.getId()+"',"+
                   "'"+employee.getName()+"' ,"+
                   "'"+employee.getEmail()+"' ,"+
                   "'"+employee.getAddress()+"' ,"+
                   "'"+employee.getCity()+"' ,"+
                   "'"+employee.getState()+"' ,"+
                   "CURRENT_TIME)"
            );
        }catch (Exception ex){
            log.error("insertEmployeeInfo||returnCode "+returnCode+"||error message"+ex.getMessage());
        }

        return employee;
    }

}
