package com.candidate.repo;

import com.candidate.entity.Designation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DesignationRepo extends JpaRepository<Designation,Long> {
    @Query("SELECT c FROM Designation c WHERE c.designationName LIKE %:search%")
    List<Designation> findByDesignationName(String search);
}
