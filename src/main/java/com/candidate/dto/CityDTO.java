package com.candidate.dto;

import com.candidate.entity.State;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityDTO {
    private Long cityId;
    private String cityName;
    private String cityCode;
    private State state;
}
