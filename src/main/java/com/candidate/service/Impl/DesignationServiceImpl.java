package com.candidate.service.Impl;

import com.candidate.entity.Designation;
import com.candidate.repo.DesignationRepo;
import com.candidate.service.Service.DesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesignationServiceImpl implements DesignationService {

    @Autowired
    private DesignationRepo repo;

    @Override
    public List<Designation> getAllDesignation(String search) {
        List<Designation> designations=repo.findByDesignationName(search);
        if (designations==null) {
            return repo.findAll();
        }
        return designations;
    }

    @Override
    public ResponseEntity<Designation> createDesignation(Designation designation) {
        designation.setDesignationNo(getLastDesignationNo());
        Designation designation1=repo.save(designation);
        return new ResponseEntity<>(designation1, HttpStatus.CREATED);
    }
    public synchronized String getLastDesignationNo() {
        String designationNo="DS00001";
        List<Designation> temp1 = repo.findOneByDesignationNoOrderByDesignationNoDesc();
        if (temp1.isEmpty()) {
            return designationNo;
        } else {
            String temp = repo.findOneByDesignationNoOrderByDesignationNoDesc().get(0).getDesignationNo();
            if (temp != null) {
                int count = Integer.parseInt(temp.replaceAll("DS", "")) + 1;
                temp = Integer.toString(count);
                String concat = "";
                if (temp.length() < 5) {
                    for (int i = temp.length(); i < 5; i++) {
                        concat = "0" + concat;
                        System.out.println(i);
                        System.out.println(concat);
                    }
                    temp = "DS" + concat + temp;
                    return temp;
                }
                return temp;
            }
        }
        return "success";
    }
}
