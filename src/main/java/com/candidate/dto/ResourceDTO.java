package com.candidate.dto;

import com.candidate.entity.Company;
import com.candidate.entity.ContactDetails;
import com.candidate.entity.Department;
import com.candidate.entity.Designation;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ResourceDTO {
    private Long resourceId;
    private String resourceNo;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
 /*   private Date dob;*/
    private Department department;
    private Designation designation;
    private Long aadhaarNumber;
    private String panNumber;
 /*   private Date doj;*/
    private String reportingManger;
    private Boolean status=false;
    private String resourceType;
    private ContactDetails contactDetails;
    private Company company;
}
