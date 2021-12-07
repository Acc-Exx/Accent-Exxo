package com.scott.betaexam.util;


import com.scott.betaexam.entity.Employee;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class EmployeeUtil {

    public boolean validateEmployee(Employee emp){
        if(validateEmployeeCondition1(emp)){
            return true;
        }
        if(validateEmployeeCondition2(emp)){
            return true;
        }
        return false;
    }

    private boolean validateEmployeeCondition2(Employee emp) {
        return (!StringUtils.isEmpty(emp.getAddressLine1())) && (!StringUtils.isEmpty(emp.getCity())) && (!StringUtils.isEmpty(emp.getState()));
    }

    private boolean validateEmployeeCondition1(Employee emp) {
        return StringUtils.isEmpty(emp.getAddressLine1()) && StringUtils.isEmpty(emp.getCity()) && StringUtils.isEmpty(emp.getState());
    }
}
