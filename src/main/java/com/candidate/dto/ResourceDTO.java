package com.candidate.dto;

import com.candidate.entity.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ResourceDTO implements Serializable {
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
    private String profilePicturePath;
    private String reportingManger;
    private Boolean status=false;
    private ResourceType resourceType;
    private ContactDetails contactDetails;
    private Company company;
    private List<Role> role;
}
