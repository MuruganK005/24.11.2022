package com.candidate.repo;

import com.candidate.entity.logEntity.ResourceLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceLogRepo extends JpaRepository<ResourceLog,Long> {
}
