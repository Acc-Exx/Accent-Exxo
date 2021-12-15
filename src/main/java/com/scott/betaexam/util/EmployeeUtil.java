package com.scott.betaexam.util;

import com.scott.betaexam.entity.Employee;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class EmployeeUtil {
    public boolean validateEmployee(Employee employee) {
        if (validateEmployee1(employee)) {
            return true;
        }
        if (validateEmployee2(employee)) {
            return false;
        }


return false;
}

    private boolean validateEmployee1(Employee employee) {

        return StringUtils.isEmpty(employee.getAddressLine1()) && StringUtils.isEmpty(employee.getCity()) && StringUtils.isEmpty(employee.getState());
    }

    private boolean validateEmployee2(Employee employee) {
        return (!StringUtils.isEmpty(employee.getAddressLine1())) && (!StringUtils.isEmpty(employee.getCity())) && (!StringUtils.isEmpty(employee.getState()));
    }
    }

