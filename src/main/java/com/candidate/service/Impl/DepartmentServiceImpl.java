package com.candidate.service.Impl;

import com.candidate.entity.Department;
import com.candidate.repo.DepartmentRepo;
import com.candidate.service.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepo repo;

    @Override
    public List<Department> getAllDepartmentInAsc(String search) {
        List<Department> departments=repo.findByDepartmentName(search);
        if (departments==null) {
            return repo.findAll();
        }
        return departments;
    }

    @Override
    public ResponseEntity<Department> createDepartment(Department department) {
        department.setDepartmentNo(getLastDepartmentNo());
        Department department1=repo.save(department);
        return new ResponseEntity<>(department1, HttpStatus.CREATED);
    }
    public synchronized String getLastDepartmentNo() {
        String departmentNo="D00001";
        List<Department> temp1 = repo.findOneByDepartmentNoOrderByDepartmentNoDesc();
        if (temp1.isEmpty()) {
            return departmentNo;
        } else {
            String temp = repo.findOneByDepartmentNoOrderByDepartmentNoDesc().get(0).getDepartmentNo();
            if (temp != null) {
                int count = Integer.parseInt(temp.replaceAll("D", "")) + 1;
                temp = Integer.toString(count);
                String concat = "";
                if (temp.length() < 5) {
                    for (int i = temp.length(); i < 5; i++) {
                        concat = "0" + concat;
                        System.out.println(i);
                        System.out.println(concat);
                    }
                    temp = "D" + concat + temp;
                    return temp;
                }
                return temp;
            }
        }
        return "success";
    }
}
