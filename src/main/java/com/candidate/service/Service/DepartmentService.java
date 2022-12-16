package com.candidate.service.Service;

import com.candidate.entity.Department;
import com.candidate.entity.Resource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartmentInAsc(String search);

    ResponseEntity<Department> createDepartment(Department department);
}
