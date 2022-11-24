package com.candidate.service.Impl;

import com.candidate.dto.ContractDTO;
import com.candidate.entity.Contract;
import com.candidate.entity.Resource;
import com.candidate.repo.ContractRepo;
import com.candidate.service.Service.ContractService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractRepo contractRepo;
    @Override
    public ResponseEntity<ContractDTO> createContract(ContractDTO contractDto) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setAmbiguityIgnored(true);
        Contract contract = mapper.map(contractDto,Contract.class);
        contractRepo.save(contract);
        return new ResponseEntity<>(contractDto, HttpStatus.OK);
    }

    @Override
    public String updateContract(ContractDTO contractDto) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setAmbiguityIgnored(true);
        Contract contract = mapper.map(contractDto,Contract.class);
        contractRepo.save(contract);
        return "Updated Successfully";
    }

    @Override
    public ContractDTO getByContractId(Long contractId) {
        Optional<Contract> contract = contractRepo.findById(contractId);
        if(contract != null && contract.isPresent()) {
            ModelMapper mapper = new ModelMapper();
            mapper.getConfiguration().setAmbiguityIgnored(true);
            ContractDTO contractDTO = mapper.map(contract, ContractDTO.class);
            contractDTO.setContractId(contract.get().getContractId());
            contractDTO.setContractType(contract.get().getContractType());
            contractDTO.setContactNo(contract.get().getContactNo());
            contractDTO.setDescription(contract.get().getDescription());
            contractDTO.setStartDate(contract.get().getStartDate());
            contractDTO.setEndDate(contract.get().getEndDate());
            contractDTO.setRevisedEndDate(contract.get().getRevisedEndDate());
            contractDTO.setStatus(contract.get().getStatus());
            return contractDTO;
        }
        else {
            return null;
        }
    }

    @Override
    public List<ContractDTO> getAllContract() {
        List<Contract> contracts = contractRepo.findAll();
        List<ContractDTO> contractDTOS = new ArrayList<>();
        for (Contract contract : contracts) {
            ModelMapper mapper=new ModelMapper();
            mapper.getConfiguration().setAmbiguityIgnored(true);
            ContractDTO contractDTO =mapper.map(contract, ContractDTO.class);
            contractDTO.setContractId(contract.getContractId());
            contractDTO.setContractType(contract.getContractType());
            contractDTO.setContactNo(contract.getContactNo());
            contractDTO.setDescription(contract.getDescription());
            contractDTO.setStartDate(contract.getStartDate());
            contractDTO.setEndDate(contract.getEndDate());
            contractDTO.setRevisedEndDate(contract.getRevisedEndDate());
            contractDTO.setStatus(contract.getStatus());
            contractDTOS.add(contractDTO);
        }
        return contractDTOS;
    }

    @Override
    public String delete(long contractId) {
        Contract contract = contractRepo.findById(contractId).get();
        contractRepo.delete(contract);
        return "Id " + contractId + " Deleted Successfully";
    }


}
