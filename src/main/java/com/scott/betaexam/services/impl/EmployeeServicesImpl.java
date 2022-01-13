package com.scott.betaexam.services.impl;

import com.scott.betaexam.dao.IEmployeeRepository;
import com.scott.betaexam.dto.Employee;
import com.scott.betaexam.services.IEmployeeServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Pattern;


@Service
@Slf4j
public class EmployeeServicesImpl implements IEmployeeServices {

    private static final Pattern VALIDATE_EMAIL =
            Pattern.compile( "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE );

    @Autowired
    IEmployeeRepository iEmployeeRepository;

    public void setiEmployeeRepository(IEmployeeRepository iEmployeeRepository) {
        this.iEmployeeRepository = iEmployeeRepository;
    }

    @Override
    public List<Employee> findEmployeeByNameOrEmail(String filterByAny) {
        List<Employee> employeeList = null;
        String filterWith = "";
        try {
            if (VALIDATE_EMAIL.matcher( filterByAny).find()) {
                log.info( "FilterByEmail " + filterByAny );
                filterWith = "EMAIL";
                employeeList = iEmployeeRepository.findEmployeeByNameOrEmail( filterByAny, filterWith );
            } else {
                filterWith = "NAME";
                log.info( "FilterByName " + filterByAny );
                employeeList = iEmployeeRepository.findEmployeeByNameOrEmail( filterByAny, filterWith );
            }

        } catch (Exception ex) {
            System.out.println( ex.getMessage() );
        }
        return employeeList;
    }

    @Override
    public LinkedHashMap<String, String> insertEmployeeInfo(Employee employee) throws ParseException {
        LinkedHashMap<String, String> resp = new LinkedHashMap<>();
        Employee response = new Employee();
        String formatCreateAt = new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ss.SSS" ).format( new Date() );

        if (employee.getAddress().isEmpty()) {
            if (!employee.getCity().isEmpty() && !employee.getState().isEmpty()  ) {
                log.debug("When all three Address, City and State provided");
                resp.put( "message", "Please provide all three Address,City and State" );
                return resp;
            }
        }
        response = iEmployeeRepository.insertEmployeeInfo( employee );
        resp.put( "id", response.getId() );
        resp.put( "name", response.getName() );
        resp.put( "address", response.getAddress() );
        resp.put( "city", response.getCity() );
        resp.put( "state", response.getState() );
        resp.put( "createAt", formatCreateAt);

        return resp;
    }


}



