package com.scott.betaexam.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Setter
@Getter
@ToString
public class Employee {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "\"Employee Id\"", nullable = false)
    private String id;

    private String name;
    private String email;
    private String addressLine1;
    private String city;
    private String state;

    @Column(name = "\"Create Date\"")
    private String createdTimestamp;
}
