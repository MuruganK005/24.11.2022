package com.candidate.controller;

import com.candidate.entity.Designation;
import com.candidate.service.Service.DesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DesignationController {

    @Autowired
    private DesignationService service;

    @GetMapping("/get_all_designation")
    public List<Designation> getAllDesignation(@RequestParam String search){
        return service.getAllDesignation(search);
    }


    @PostMapping("/create_designation")
    public ResponseEntity<Designation> createDesignation(@RequestBody Designation designation){
        return service.createDesignation(designation);
    }

}
