package com.scott.betaexam;

import lombok.NonNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.auditing.CurrentDateTimeProvider;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="Employee")
public class EmployeePojo {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID Employee_id;
    @Column(name="Name")
    private String Name;
     @Column(name="Email")
    private String Email;
     @Column(name="Address_Line")
    private String Address_Line;
     @Column(name="City")
    private String City;
     @Column(name="State")
    private String State;
     @Column(name="Create_Date")
     @CreationTimestamp
    private LocalDateTime Create_Date;

    public EmployeePojo(UUID employee_id, String name, String email, String address_Line, String city, String state, LocalDateTime create_Date) {
        Employee_id = employee_id;
        Name = name;
        Email = email;
        Address_Line = address_Line;
        City = city;
        State = state;
        Create_Date = create_Date;
    }

    public EmployeePojo() {

    }

    public UUID getEmployee_id() {
        return Employee_id;
    }

    public void setEmployee_id(UUID employee_id) {
        Employee_id = employee_id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress_Line() {
        return Address_Line;
    }

    public void setAddress_Line(String address_Line) {
        Address_Line = address_Line;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public LocalDateTime getCreate_Date() {
        return Create_Date;
    }

    public void setCreate_Date(LocalDateTime create_Date) {
        Create_Date = create_Date;
    }

    @Override
    public String toString() {
        return "EmployeePojo{" +
                "Employee_id='" + Employee_id + '\'' +
                ", Name='" + Name + '\'' +
                ", Email='" + Email + '\'' +
                ", Address_Line='" + Address_Line + '\'' +
                ", City='" + City + '\'' +
                ", State='" + State + '\'' +
                ", Create_Date='" + Create_Date + '\'' +
                '}';
    }
}
