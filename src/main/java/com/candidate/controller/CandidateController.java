package com.candidate.controller;

import com.candidate.entity.Candidate;
import com.candidate.service.Impl.CandidateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CandidateController {

    @Autowired
    private CandidateServiceImpl service;

    @PostMapping("create_candidate")
    public Candidate createCandidate(@RequestBody Candidate candidate){
        return service.createCandidate(candidate);
    }

    @GetMapping("/candidate_all")
    public List<Candidate> getCandidateList(){
        return service.getAllCandidate();
    }

    //get candidate by id
    @GetMapping("get_candidate_by_id")
    public Optional<Candidate> getCandidateById(@RequestBody Long id){
        return service.getCandidateById(id);
    }

    //get candidate by name
    @GetMapping("get_candidate_by_name")
    public Optional<Candidate> getCandidateByName(@RequestBody String name){
        return service.getCandidateByName(name);
    }

    //get candidate by phone number
    @GetMapping("get_candidate_by_phone_number")
    public Optional<Candidate> getCandidateByPhoneNumber(@RequestBody String phoneNumber){
        return service.getCandidateByPhoneNumber(phoneNumber);
    }






}
