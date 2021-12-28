package com.scott.betaexam.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "email", length = 40, unique = true)
    private String email;

    @Column(name = "addressLine1", length = 30)
    private String addressLine1;

    @Column(name = "city", length = 20)
    private String city;

    @Column(name = "state", length = 20)
    private String state;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createDate;

}
