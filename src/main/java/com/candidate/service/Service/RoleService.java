package com.candidate.service.Service;

import com.candidate.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRolesInAsc(String search);
}
