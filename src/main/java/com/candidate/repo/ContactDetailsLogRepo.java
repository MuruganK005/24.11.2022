package com.candidate.repo;

import com.candidate.entity.logEntity.ContactDetailsLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactDetailsLogRepo extends JpaRepository<ContactDetailsLog,Long> {
}
