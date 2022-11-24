package com.candidate.service.Impl;

import com.candidate.entity.Candidate;
import com.candidate.repo.CandidateRepo;
import com.candidate.service.Service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateRepo repo;

    @Override
    public Candidate createCandidate(Candidate candidate) {
        return repo.save(candidate);
    }

    @Override
    public List<Candidate> getAllCandidate() {
        return repo.findAll();
    }

    //get candidate from repository
    public Optional<Candidate> getCandidateById(Long id) {
        return repo.findById(id);
    }

   //get  candidate by name from repository
    public Optional<Candidate> getCandidateByName(String name) {
        return repo.findByName(name);
    }

    //get candidate by phone number from repository
    public Optional<Candidate> getCandidateByPhoneNumber(String phoneNumber) {
        return repo.findByPhoneNumber(phoneNumber);
    }
}
