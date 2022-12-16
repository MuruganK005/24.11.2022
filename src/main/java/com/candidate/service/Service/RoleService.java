package com.candidate.service.Service;

import com.candidate.entity.Role;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RoleService {
    List<Role> getAllRolesInAsc(String search);

    ResponseEntity<Role> createRole(Role role);
}
