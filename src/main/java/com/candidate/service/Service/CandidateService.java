package com.candidate.service.Service;

import com.candidate.entity.Candidate;

import java.util.List;
import java.util.Optional;

public interface CandidateService {
    Candidate createCandidate(Candidate candidate);

    List<Candidate> getAllCandidate();

   Optional<Candidate> getCandidateById(Long id);

    Optional<Candidate> getCandidateByName(String name);

    Optional<Candidate> getCandidateByPhoneNumber(String phoneNumber);
}
