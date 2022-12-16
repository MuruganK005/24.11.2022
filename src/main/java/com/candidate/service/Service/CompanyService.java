package com.candidate.service.Service;

import com.candidate.entity.Company;
import org.springframework.http.ResponseEntity;

public interface CompanyService {
    ResponseEntity<Company> createService(Company company);
}
