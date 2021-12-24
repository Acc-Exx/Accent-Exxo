package com.scott.betaexam.Exception;

public class EmployeeNotFoundException extends RuntimeException{

     public EmployeeNotFoundException(){
        super("Employee record not found");
    }
}
