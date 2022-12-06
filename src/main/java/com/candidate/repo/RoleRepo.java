package com.candidate.repo;

import com.candidate.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepo extends JpaRepository<Role,Long> {
    @Query("SELECT c FROM Role c WHERE c.roleName LIKE %:search%")
    List<Role> findByRoleName(String search);
}
