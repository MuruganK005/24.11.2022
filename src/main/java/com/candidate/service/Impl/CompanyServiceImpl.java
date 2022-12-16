package com.candidate.service.Impl;

import com.candidate.entity.Company;
import com.candidate.repo.CompanyRepo;
import com.candidate.service.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepo companyRepo;


    @Override
    public ResponseEntity<Company> createService(Company company) {
        company.setCompanyNo(getLastCompanyNo());
       Company company1= companyRepo.save(company);
        return new ResponseEntity<>(company1, HttpStatus.CREATED);
    }

    public String getLastCompanyNo() {
        String companyNo="C00001";
        List<Company> temp1 = companyRepo.findOneByCompanyNoOrderByCompanyNoDesc();
        if (temp1.isEmpty()) {
            return companyNo;
        } else {
            String temp = companyRepo.findOneByCompanyNoOrderByCompanyNoDesc().get(0).getCompanyNo();
            if (temp != null) {
                int count = Integer.parseInt(temp.replaceAll("C", "")) + 1;
                temp = Integer.toString(count);
                String concat = "";
                if (temp.length() < 5) {
                    for (int i = temp.length(); i < 5; i++) {
                        concat = "0" + concat;
                        System.out.println(i);
                        System.out.println(concat);
                    }
                    temp = "C" + concat + temp;
                    return temp;
                }
                return temp;
            }
        }
        return "success";
    }
}
