package com.scott.betaexam.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Employee {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "\"Employee Id\"", nullable = false)
    private String id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Email")
    private String email;
    @Column(name = "\"Address Line 1\"")
    private String addressLine1;
    @Column(name = "City")
    private String city;
    @Column(name = "State")
    private String state;
    @Column(name = "\"Create Date\"")
    private String createdTimestamp;

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", createdTimestamp='" + createdTimestamp + '\'' +
                '}';
    }
}
