package com.DatabaseMvc1.Mvc1.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="employee")

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="emp_Id")
    private int empId;
    @Column(name="emp_name")
    private String empName;
    @Column(name = "emp_desg")
    private String empDesg;
    @Column(name="emp_sal")
    private double empSal;



}
