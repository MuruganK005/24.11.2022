package com.candidate.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "department_id")
    private Long departmentId;
    @Column(name = "department_name")
    private String departmentName;
    @Column(name = "description")
    private String description;
    @Column(name = "department_no")
    private String departmentNo;
}
