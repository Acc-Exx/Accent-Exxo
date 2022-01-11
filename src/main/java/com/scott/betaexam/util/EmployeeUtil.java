package com.scott.betaexam.util;

import com.scott.betaexam.model.Employee;

public class EmployeeUtil {

	public static boolean validateEmployeeCreation(Employee employee){
        boolean isValid = true;
        if( employee.getName() != null && employee.getEmail() != null)
            if(null == employee.getAddressLine1() && null == employee.getCity() && null == employee.getState())
                isValid = true;

            else if(null == employee.getAddressLine1() || null == employee.getCity() || null == employee.getState() )
                isValid = false;

        return isValid;
    }
}
