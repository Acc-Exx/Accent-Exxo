package com.scott.betaexam.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static org.springframework.data.jpa.domain.AbstractAuditable_.createdDate;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Employee {
    @Id
    @GeneratedValue(generator = "hibernate-uuid")
    @GenericGenerator(name = "hibernate-uuid",strategy = "org.hibernate.id.UUIDGenerator")
    private String employeeId;
    private String email;
    private String addressLine1;
    private String city;
    private String state;

    private String name;


    public void setCreateDate(String format) {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", email='" + email + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
