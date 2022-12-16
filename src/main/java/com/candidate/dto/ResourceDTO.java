package com.candidate.dto;

import com.candidate.entity.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private long departmentId;
    private long destinationId;
    private Long aadhaarNumber;
    private String panNumber;
    private String profilePicturePath;
    private java.sql.Date dateOfBirth;
    private java.sql.Date jointDate;
    private String reportingManger;
    private Boolean status=false;
    private long resourceTypeId;
    private ContactDetails contactDetails;
    private long companyId;
    private String role;
    private List<Role> roles;
}
