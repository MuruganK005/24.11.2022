package com.candidate.service.Impl;

import com.candidate.entity.Role;
import com.candidate.repo.RoleRepo;
import com.candidate.service.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepo roleRepo;

    @Override
    public List<Role> getAllRolesInAsc(String search) {
        List<Role> roles=roleRepo.findByRoleName(search);
        if (roles==null) {
            return roleRepo.findAll();
        }
        return roles;
    }
}
