package com.candidate.repo;

import com.candidate.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandidateRepo extends JpaRepository<Candidate,Long> {

    Optional<Candidate> findByName(String name);

    Optional<Candidate> findByPhoneNumber(String phoneNumber);


}
