package com.candidate.controller;

import com.candidate.dto.ResourceDTO;
import com.candidate.dto.ResponseDTO;
import com.candidate.entity.Resource;
import com.candidate.entity.ResourceType;
import com.candidate.exception.CandidateException;
import com.candidate.service.Impl.ResourceServiceImpl;
import com.candidate.service.Service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value ="/api/v1")
public class ResourceController {

    @Autowired
    private ResourceService service;

    @PostMapping("/create_resource")
    public ResponseEntity<ResponseDTO> createResource(@RequestParam String resource, @RequestParam MultipartFile multipartFile) throws CandidateException, IOException {
        return service.createResource(resource,multipartFile);
    }

    @PutMapping("/update_resource")
    public ResponseEntity<ResponseDTO> updateResource(@RequestParam String resource, @RequestParam MultipartFile multipartFile) throws CandidateException, IOException {
        return service.updateResource(resource,multipartFile);
    }

    @DeleteMapping("/delete_resource/{id}")
    public ResponseEntity<String> deleteResource(@PathVariable("id") Long id) {
        return service.deleteResource(id);
    }

    @DeleteMapping("/delete_resource_all")
    public ResponseEntity<String> deleteResourceAll() {
        return service.deleteResourceAll();
    }

    @GetMapping("/get_resource/{id}")
    public ResponseEntity<Optional<Resource>> getResource(@PathVariable("id") Long id) {
        return service.getResource(id);
    }

    @GetMapping("/get_resource_all")
    public ResponseEntity<List<Resource>> getResourceList() {
        return service.getResourceList();
    }

    @GetMapping("/get_last_resource_no")
    public String getLastResourceNo() {
        return service.getLastResourceNo();
    }

    @PostMapping("/create_new_resource")
    public ResponseEntity<Object> createNewResource(@RequestBody ResourceDTO resource) {
        return service.createNewResource(resource);
    }

}
