package com.candidate.controller;

import com.candidate.entity.Role;
import com.candidate.repo.RoleRepo;
import com.candidate.service.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {



    @Autowired
    private RoleService service;


    @GetMapping("/get_all_role")
    public List<Role> getAllRoles(@RequestParam String search){
        return service.getAllRolesInAsc(search);
    }

}
