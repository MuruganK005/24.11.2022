package com.candidate.service.Service;

import com.candidate.dto.CountryDTO;
import org.springframework.http.ResponseEntity;

public interface CountryService {
    ResponseEntity<Object> createCountry(CountryDTO country);
}
