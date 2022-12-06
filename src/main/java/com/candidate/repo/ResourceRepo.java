package com.candidate.repo;

import com.candidate.dto.ResourceDTO;
import com.candidate.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResourceRepo extends JpaRepository<Resource,Long> {

    @Query("SELECT u FROM Resource u ORDER BY u.resourceNo DESC")
    List<Resource> findOneByResourceNoOrderByResourceNoDesc();

    Optional<Resource> findByAadhaarNumber(Long aadhaarNumber);

}
