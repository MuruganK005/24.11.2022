package com.candidate.service.Service;

import com.candidate.entity.Designation;

import java.util.List;

public interface DesignationService {
    List<Designation> getAllDesignation(String search);
}
