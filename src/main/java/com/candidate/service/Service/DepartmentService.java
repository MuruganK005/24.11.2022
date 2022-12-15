package com.candidate.service.Service;

import com.candidate.entity.Department;
import com.candidate.entity.Resource;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartmentInAsc(String search);

}
