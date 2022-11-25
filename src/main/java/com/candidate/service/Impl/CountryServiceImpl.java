package com.candidate.service.Impl;

import com.candidate.dto.CountryDTO;
import com.candidate.entity.Country;
import com.candidate.repo.CountryRepo;
import com.candidate.service.Service.CountryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepo repo;

    @Override
    public ResponseEntity<Object> createCountry(CountryDTO country) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setAmbiguityIgnored(true);
        Country country1 = mapper.map(country,Country.class);
        return new ResponseEntity<>(repo.save(country1), HttpStatus.CREATED);
    }
}
