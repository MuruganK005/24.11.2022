package com.candidate.repo;

import com.candidate.entity.ResourceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceTypeRepo extends JpaRepository<ResourceType,Long> {
}
