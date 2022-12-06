package com.candidate.service.Impl;

import com.candidate.entity.Department;
import com.candidate.entity.Role;
import com.candidate.repo.DepartmentRepo;
import com.candidate.service.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepo repo;

    @Override
    public List<Department> getAllDepartmentInAsc(String search) {
        List<Department> departments=repo.findByDepartmentName(search);
        if (departments==null) {
            return repo.findAll();
        }
        return departments;
    }
}
