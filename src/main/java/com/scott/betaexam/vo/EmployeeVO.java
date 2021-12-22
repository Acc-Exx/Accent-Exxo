package com.scott.betaexam.vo;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class EmployeeVO {
    private String id;
    private String name;
    private String email;
    private String addressLine1;
    private String city;
    private String state;
    private String creationDate;
   @Override
    public String toString(){
       return "Employee [ id: " + id +" name: " +name +
               " email: " +email+
               " addressLine1 :" +addressLine1+
               " city : " +city +
               " state : " +state+
               " creationDate: "+ creationDate +"]";
   }
}
