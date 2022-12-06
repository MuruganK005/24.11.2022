package com.candidate.controller;

import com.candidate.entity.Department;
import com.candidate.repo.DepartmentRepo;
import com.candidate.service.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @GetMapping("/get_all_department")
    public List<Department> getAllDepartment(@RequestParam String search){
        return service.getAllDepartmentInAsc(search);
    }

}
