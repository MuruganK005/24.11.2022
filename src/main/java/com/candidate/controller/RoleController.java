package com.candidate.controller;

import com.candidate.entity.Role;
import com.candidate.service.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleController {



    @Autowired
    private RoleService service;


    @GetMapping("/get_all_role")
    public List<Role> getAllRoles(@RequestParam String search){
        return service.getAllRolesInAsc(search);
    }

    @PostMapping("/create_role")
    public ResponseEntity<Role> createRole(@RequestBody Role role){
        return service.createRole(role);
    }

}
