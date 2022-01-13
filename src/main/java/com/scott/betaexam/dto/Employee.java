package com.scott.betaexam.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
public class Employee {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("employee id")
    public String id;

    public String name;

    public String email;

    @JsonProperty("address line 1")
    public String address;

    public String city;

    public String state;

    @JsonProperty("create date")
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss:SSS")
    public Timestamp createDate;


}
