package com.candidate.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "designation")
@AllArgsConstructor
@NoArgsConstructor
public class Designation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "designation_id", nullable = false)
    private Long designationId;
    @Column(name = "department_name", nullable = false)
    private String department_name;
    @Column(name = "description")
    private String description;

}