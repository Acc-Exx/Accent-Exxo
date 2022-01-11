package com.scott.betaexam.exception;

public class EmployeeNotFoundException extends Exception{
    public EmployeeNotFoundException(){
        super("Employee Not Found");
    }
}
