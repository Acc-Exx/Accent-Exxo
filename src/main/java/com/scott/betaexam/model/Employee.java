package com.scott.betaexam.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID employeeId = UUID.randomUUID();

    @Column(name = "Name")
    private String name;

    @Column(name = "Email")
    private String email;

    @Column(name = "Address_line1")
    private String addressLine1;


    @Column(name = "City")
    private String city;

    @Column(name = "State")
    private String state;

    @Column(name = "Create_Date")
    private String date = LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'hh:mm:ss.SSS"));


    @Override
    public String toString() {
        return "Employee{" + "Id=" + employeeId + ", Email=" + email
                + ", Name=" + name + ", Address_line1=" + addressLine1 + '}';
    }

}
