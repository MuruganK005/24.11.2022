package com.candidate.repo;

import com.candidate.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
@Repository
public interface ContractRepo extends JpaRepository<Contract,Long> {
}
