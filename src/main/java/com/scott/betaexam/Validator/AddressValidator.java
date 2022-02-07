package com.scott.betaexam.Validator;

import com.scott.betaexam.entity.Employee;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AddressValidator implements ConstraintValidator<EmployeeAddressValidator , Employee> {

    @Override
    public void initialize(EmployeeAddressValidator arg0) {

    }

    @Override
    public boolean isValid(Employee employee, ConstraintValidatorContext context) {
        if((employee.getAddressline1()!= null) && (employee.getState()==null)){
            return false;
        }

        return true;
    }
}
