package com.candidate.entity.logEntity;

import com.candidate.entity.Company;
import com.candidate.entity.ContactDetails;
import com.candidate.entity.Department;
import com.candidate.entity.Designation;
import com.candidate.entity.logEntity.AddressLog;
import com.candidate.entity.logEntity.ContactDetailsLog;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "resourceLog")
@AllArgsConstructor
@NoArgsConstructor
public class ResourceLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "resource_log_id")
    private Long resourceLogId;

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

  /*  @Column(name = "dob")
    private Date dob;*/


    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "department_department_id")
    private Department department;


    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "designation_designation_id")
    private Designation designation;

    @Column(name = "aadhaar_number",length = 12)
    private Long aadhaarNumber;

    @Column(name = "pan_number",length = 15)
    private String panNumber;

  /*  @Column(name = "date_of_joining")
    private Date doj;*/

    @Column(name = "reporting_manager")
    private String reportingManger;

    @Column(name="status")
    private Boolean status=false;

    @Column(name="resource_type")
    private String resourceType;


    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id")
    private ContactDetailsLog contactDetailsLog;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

}
