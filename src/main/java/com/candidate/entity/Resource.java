package com.candidate.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "resource")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "resource_id", nullable = false)
    private Long resourceId;

    @Column(name="resource_no")
    private String resourceNo;

    @Column(name="first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name="last_name")
    private String lastName;

    @Column(name = "gender")
    private String gender;

   /* @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "MM/dd/yyyy")
    @Column(name = "dob", nullable = false)
    private Date dob;*/

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "resource_id")
    private Department department;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "resource_id")
    private Designation designation;

    @Column(name = "aadhaar_number",length = 12)
    private Long aadhaarNumber;

    @Column(name = "pan_number",length = 15)
    private String panNumber;

    /*@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "MM/dd/yyyy")
    @Column(name = "date_of_joining")
    private Date doj;*/

    @Column(name = "reporting_manager")
    private String reportingManger;

    @Column(name="status")
    private Boolean status=false;

    @Column(name="resource_type")
    private String resourceType;


    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id")
    private ContactDetails contactDetails;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;


}
