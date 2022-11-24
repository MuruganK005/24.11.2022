package com.candidate.dto;

import com.candidate.entity.State;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CountryDTO {
    private Long countryId;
    private String countryName;
    private String countryCode;
    private List<State> states;
}
