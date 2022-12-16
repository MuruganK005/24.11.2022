package com.candidate.controller;

import com.candidate.entity.ResourceType;
import com.candidate.entity.Role;
import com.candidate.service.Service.ResourceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ResourceTypeController {

    @Autowired
    private ResourceTypeService service;


    @PostMapping("/create_resource_type")
    private ResponseEntity<ResourceType> createResourceType(@RequestBody ResourceType resourceType){
        return service.createResourceType(resourceType);
    }

    @GetMapping("/get_all_resource_type")
    public List<ResourceType> getAllResourceType(@RequestParam String search){
        return service.getAllResourceTypeInAsc(search);
    }


}
