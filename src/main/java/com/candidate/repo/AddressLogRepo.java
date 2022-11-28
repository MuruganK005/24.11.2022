package com.candidate.repo;

import com.candidate.entity.logEntity.AddressLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressLogRepo extends JpaRepository<AddressLog,Long> {
}
