package com.candidate.repo;

import com.candidate.entity.Company;
import com.candidate.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepo extends JpaRepository<Company,Long> {
    @Query("SELECT u FROM Company u ORDER BY u.companyNo DESC")
    List<Company> findOneByCompanyNoOrderByCompanyNoDesc();

   // Company findByCompanyNo(String companyNo);

   // Company findByCompanyId(long companyId);
}
