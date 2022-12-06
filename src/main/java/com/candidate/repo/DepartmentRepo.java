package com.candidate.repo;

import com.candidate.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Long> {
    @Query("SELECT c FROM Department c WHERE c.departmentName LIKE %:search%")
    List<Department> findByDepartmentName(String search);
}
