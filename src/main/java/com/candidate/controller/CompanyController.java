package com.candidate.controller;

import com.candidate.entity.Company;
import com.candidate.service.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CompanyController {

    @Autowired
    private CompanyService service;

    @PostMapping("/create_company")
    private ResponseEntity<Company> createCompany(@RequestBody Company company){
        return service.createService(company);
    }

}
