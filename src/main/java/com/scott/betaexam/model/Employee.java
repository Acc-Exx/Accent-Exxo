package com.scott.betaexam.model;


import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Employee {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @ColumnDefault("random_uuid()")
    private UUID employeeId;
    private String name;
    private String email;
    private String addressLine1;
    private String city;
    private String state;
    private Timestamp createDate;
}