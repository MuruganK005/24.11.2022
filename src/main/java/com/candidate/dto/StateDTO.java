package com.candidate.dto;

import com.candidate.entity.City;
import com.candidate.entity.Country;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StateDTO {
    private Long stateId;
    private String stateName;
    private String stateCode;
    private Country country;
    private List<City> city;
}
