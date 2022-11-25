package com.candidate.controller;

import com.candidate.dto.CountryDTO;
import com.candidate.service.Impl.CountryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/country")
public class CountryController {

    @Autowired
    private CountryServiceImpl service;


    @PostMapping("create_country")
    public ResponseEntity<Object> createCountry(@RequestBody CountryDTO country){
        return service.createCountry(country);
    }

}
