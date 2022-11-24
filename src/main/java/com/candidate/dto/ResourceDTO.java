package com.candidate.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceDTO {
    private Long resourceId;
    private String resourceNo;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Boolean status;
    private String resourceType;
}
