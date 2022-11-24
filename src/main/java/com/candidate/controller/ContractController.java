package com.candidate.controller;

import com.candidate.dto.ContractDTO;
import com.candidate.dto.ResourceDTO;
import com.candidate.service.Impl.ContractServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ContractController {
    @Autowired
    private ContractServiceImpl service;

    @PostMapping
    public ResponseEntity<ContractDTO> createContract(@RequestBody ContractDTO contractDto){
        return service.createContract(contractDto);
    }

    @PutMapping("/update_contract")
    public String updateContract(@RequestBody ContractDTO contractDto) {
        return service.updateContract(contractDto);
    }

    @GetMapping(value = "/getByContractId/{contractId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ContractDTO> getByZenPackId(@PathVariable Long contractId){
        ContractDTO result = service.getByContractId(contractId);
        if(result == null) {
            return ResponseEntity.notFound().eTag(contractId + " not found").build();
        }
        return ResponseEntity.ok().body(result);
    }

    @GetMapping(value = "get_all")
    public List<ContractDTO> getAllContract() {
        return service.getAllContract();
    }

    @DeleteMapping("/deleteList/{contractId}")
    public String delete(@PathVariable long contractId){
        return service.delete(contractId);
    }
}
