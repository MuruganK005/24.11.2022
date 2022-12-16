package com.candidate.service.Impl;

import com.candidate.entity.Role;
import com.candidate.repo.RoleRepo;
import com.candidate.service.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @Override
    public ResponseEntity<Role> createRole(Role role) {
        role.setRoleNo(getLastRoleNo());
        Role role1=roleRepo.save(role);
        return new ResponseEntity<>(role1, HttpStatus.CREATED);
    }

    public String getLastRoleNo() {
        String roleNo="RL00001";
        List<Role> temp1 = roleRepo.findOneByRoleNoOrderByRoleNoDesc();
        if (temp1.isEmpty()) {
            return roleNo;
        } else {
            String temp = roleRepo.findOneByRoleNoOrderByRoleNoDesc().get(0).getRoleNo();
            if (temp != null) {
                int count = Integer.parseInt(temp.replaceAll("RL", "")) + 1;
                temp = Integer.toString(count);
                String concat = "";
                if (temp.length() < 5) {
                    for (int i = temp.length(); i < 5; i++) {
                        concat = "0" + concat;
                        System.out.println(i);
                        System.out.println(concat);
                    }
                    temp = "RL" + concat + temp;
                    return temp;
                }
                return temp;
            }
        }
        return "success";
    }
}
