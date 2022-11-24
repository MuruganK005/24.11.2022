package com.candidate.repo;

import com.candidate.entity.ContractType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractTypeRepo extends JpaRepository<ContractType,Long> {
}
