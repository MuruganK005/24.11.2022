package com.candidate.service.Impl;

import com.candidate.entity.Designation;
import com.candidate.repo.DesignationRepo;
import com.candidate.service.Service.DesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesignationServiceImpl implements DesignationService {

    @Autowired
    private DesignationRepo repo;

    @Override
    public List<Designation> getAllDesignation(String search) {
        List<Designation> designations=repo.findByDesignationName(search);
        if (designations==null) {
            return repo.findAll();
        }
        return designations;
    }
}
