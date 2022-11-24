package com.candidate.service.Service;

import com.candidate.dto.ContractDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ContractService {
    ResponseEntity<ContractDTO> createContract(ContractDTO contractDto);

    String updateContract(ContractDTO contractDto);

    ContractDTO getByContractId(Long contractId);

    List<ContractDTO> getAllContract();

    String delete(long contractId);
}
