package com.candidate.service.Impl;

import com.candidate.entity.ResourceType;
import com.candidate.repo.ResourceTypeRepo;
import com.candidate.service.Service.ResourceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceTypeServiceimpl implements ResourceTypeService {

    @Autowired
    private ResourceTypeRepo resourceTypeRepo;


    @Override
    public ResponseEntity<ResourceType> createResourceType(ResourceType resourceType) {

        resourceType.setResourceTypeNo(getLastResourceTypeNo());

        ResourceType resourceType1=resourceTypeRepo.save(resourceType);

        return new ResponseEntity<>(resourceType1, HttpStatus.CREATED);
    }

    @Override
    public List<ResourceType> getAllResourceTypeInAsc(String search) {
        List<ResourceType> resourceTypes=resourceTypeRepo.findByResourceType(search);
        if (resourceTypes==null) {
            return resourceTypeRepo.findAll();
        }
        return resourceTypes;
    }

    public String getLastResourceTypeNo() {
        String resourceTypeNo="RT00001";
        List<ResourceType> temp1 = resourceTypeRepo.findOneByResourceTypeNoOrderByResourceTypeNoDesc();
        if (temp1.isEmpty()) {
            return resourceTypeNo;
        } else {
            String temp = resourceTypeRepo.findOneByResourceTypeNoOrderByResourceTypeNoDesc().get(0).getResourceTypeNo();
            if (temp != null) {
                int count = Integer.parseInt(temp.replaceAll("RT", "")) + 1;
                temp = Integer.toString(count);
                String concat = "";
                if (temp.length() < 5) {
                    for (int i = temp.length(); i < 5; i++) {
                        concat = "0" + concat;
                        System.out.println(i);
                        System.out.println(concat);
                    }
                    temp = "RT" + concat + temp;
                    return temp;
                }
                return temp;
            }
        }
        return "success";
    }
}
