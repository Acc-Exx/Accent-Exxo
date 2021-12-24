package com.scott.betaexam.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "EMPLOYEE")
@Getter @Setter
public class Employee {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private String email;

    private String address;

    private String city;

    private String state;

    private String createDate;

    @PrePersist
    public void onCreate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        this.createDate = simpleDateFormat.format(new Date());
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", createDate='" + createDate + '\'' +
                '}';
    }

    public Employee(String name, String email, String address, String city, String state) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.city = city;
        this.state = state;
    }
}
