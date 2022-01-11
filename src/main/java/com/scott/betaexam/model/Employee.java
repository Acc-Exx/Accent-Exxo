package com.scott.betaexam.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.UUID;


@Data
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="\"Employee Id\"")
    private UUID id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Email")
    private String email;

    @JsonProperty("address line 1")
    @Column(name = "\"Address Line 1\"")
    private String addressLine1;

    @Column(name = "City")
    private String city;

    @Column(name = "State")
    private String state;

    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @Column(name = "\"Create Date\"")
    private LocalDateTime createdAt;

}
