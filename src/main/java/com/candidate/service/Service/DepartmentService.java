package com.candidate.service.Service;

import com.candidate.entity.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartmentInAsc(String search);
}
