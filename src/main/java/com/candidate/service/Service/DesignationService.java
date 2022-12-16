package com.candidate.service.Service;

import com.candidate.entity.Designation;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DesignationService {
    List<Designation> getAllDesignation(String search);

    ResponseEntity<Designation> createDesignation(Designation designation);
}
