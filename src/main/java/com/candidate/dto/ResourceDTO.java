package com.candidate.dto;

import com.candidate.entity.*;
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
    private Department department;
    private Designation designation;
    private Long aadhaarNumber;
    private String panNumber;
    private String reportingManger;
    private Boolean status=false;
    private ResourceType resourceType;
    private ContactDetails contactDetails;
    private Company company;
}
