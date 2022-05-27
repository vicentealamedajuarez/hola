package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SEC_USER_TEST_EX")
@Data
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SE_ID")
    private Long id;
    @Column(name = "SE_ACTIVE")

    private String firstName;
    @Column(name = "SE_ISSUPERVISOR")

    private String lastName;
    @Column(name = "SE_EMAIL")

    private String email;

    public Employee() {
    }

    @Override
    public String toString() {
        return "EmployeeVO [id=" + id + ", firstName=" + firstName + ","+lastName + ", email=" + email  + "]";
    }
}