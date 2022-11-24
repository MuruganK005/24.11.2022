package com.candidate.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class ContractDTO {
    private Long contractId;
    private String contractType;
    private Long contactNo;
    private String description;
    private Date startDate=new Date();
    private Date endDate=new Date();
    private Date revisedEndDate=new Date();
    private String status;
}
