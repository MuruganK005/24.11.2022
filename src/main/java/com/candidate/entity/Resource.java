package com.candidate.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "resource")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Resource implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "resource_id")
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

    @Column(name = "date_of_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private java.sql.Date dateOfBirth;

    @Column(name = "joint_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private java.sql.Date jointDate;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    @JoinColumn(name = "department_no",referencedColumnName = "department_no")
    private Department department;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    @JoinColumn(name = "designation_no",referencedColumnName = "designation_no")
    private Designation designation;

    @Column(name = "aadhaar_number",length = 12)
    private Long aadhaarNumber;

    @Column(name = "pan_number",length = 15)
    private String panNumber;

    @Column(name = "profile_picture_path")
    private String profilePicturePath;

    @Column(name = "reporting_manager")
    private String reportingManger;

    @Column(name="status")
    private Boolean status=false;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "resource_type_no",referencedColumnName = "resource_type_no")
    private ResourceType resourceType;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    @JoinColumn(name = "contact_id")
    private ContactDetails contactDetails;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    @JoinColumn(name = "company_no",referencedColumnName = "company_no")
    private Company company;

    private String role;
}
