package com.scott.betaexam.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table
@Getter@Setter
public class Employee {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(
            name="UUID", strategy = "org.hibernate.id.UUIDGenerator"
    )

    @Column(name = "employee_id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "name", columnDefinition = "varchar(20)")
    private String name;

    @Column(name = "email", columnDefinition = "varchar(40)")
    private String email;

    @Column(name = "addressLine1", columnDefinition = "varchar(30)")
    private String addressLine1;

    @Column(name = "city", columnDefinition = "varchar(20)")
    private String city;

    @Column(name = "state", columnDefinition = "varchar(20)")
    private String state;

    @Column(name = "createDate")
    private LocalDateTime createDate;

}
