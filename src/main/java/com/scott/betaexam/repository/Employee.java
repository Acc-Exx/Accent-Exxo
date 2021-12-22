package com.scott.betaexam.repository;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@Entity
public class Employee {
    @Id
    private String id;

    private String name;

    private String email;

    private String addressLine1;

    private String city;

    private String state;

    private Date createdDate;

    @Override
    public String toString(){
        return "Employee [ id: " + id +" name: " +name +
                " email: " +email+
                " addressLine1 :" +addressLine1+
                " city : " +city +
                " state : " +state+
                " creationDate: "+ createdDate +"]";
    }

}
