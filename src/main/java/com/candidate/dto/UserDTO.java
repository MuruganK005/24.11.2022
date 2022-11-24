package com.candidate.dto;

import com.candidate.entity.Address;
import com.candidate.enums.RoleType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserDTO {

    private Long id;
    private String username;
    private int age;
    private String sex;
    private Address address;
    private String email;
    private String password;
    private Long phone;
    private String status;
    private RoleType role;
    private LocalDate createDate;
    private LocalDate updateDate;
    private String createdBy;
    private String updatedBy;

}
