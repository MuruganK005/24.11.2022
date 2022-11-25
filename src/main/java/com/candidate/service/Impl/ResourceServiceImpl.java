package com.candidate.service.Impl;

import com.candidate.dto.ResourceDTO;
import com.candidate.entity.Resource;
import com.candidate.repo.ResourceRepo;
import com.candidate.service.Service.ResourceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceRepo resourceRepo;


    @Override
    public ResponseEntity<String> createResource(ResourceDTO resource) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setAmbiguityIgnored(true);
        Resource resource1 = mapper.map(resource, Resource.class);
        List<Resource> resourceOptional = resourceRepo.findByResourceType(resource1.getResourceType());
            String resourceIdNextSequence = String.valueOf(resourceOptional.size() + 1);
            if (null != resourceIdNextSequence && resourceIdNextSequence.length() < 5) {
                int uuidNextSequence = resourceIdNextSequence.length();
                for (int i = 0; i <=5 - uuidNextSequence; i++) {
                    resourceIdNextSequence = "0".concat(resourceIdNextSequence);
                }
                resource1.setResourceNo(resource1.getResourceType()+resourceIdNextSequence);
            }
            resourceRepo.save(resource1);
            return new ResponseEntity<>("resource has created", HttpStatus.OK);
        }

    @Override
    public ResponseEntity<String> updateResource(ResourceDTO resource) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setAmbiguityIgnored(true);
        Resource resource1 = mapper.map(resource, Resource.class);
        resourceRepo.save(resource1);
        return new ResponseEntity<>("resource has updated", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteResource(Long id) {
        Optional<Resource> resource = resourceRepo.findById(id);
        if (resource.isPresent()) {
            resourceRepo.delete(resource.get());
            return new ResponseEntity<>("resource has deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("resource not found", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteResourceAll() {
        resourceRepo.deleteAll();
        return new ResponseEntity<>("all resources deleted", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Optional<Resource>> getResource(Long id) {
        Optional<Resource> resource = resourceRepo.findById(id);
        if (resource.isPresent()) {
            return new ResponseEntity<>(resource, HttpStatus.OK);
        }
        return new ResponseEntity<>(resource, HttpStatus.OK);
    }
    @Override
    public ResponseEntity<List<Resource>> getResourceList() {
        return new ResponseEntity<>(resourceRepo.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> getLastResourceNo(String resourceType) {
        List<Resource> resourceList=resourceRepo.findOneByResourceTypeOrderByResourceNoDesc(resourceType);
        if (resourceList.isEmpty()) {
            return new ResponseEntity<>(resourceType+"00001", HttpStatus.OK);
        }else {
            List<Resource> resourceOptional = resourceRepo.findByResourceType(resourceType);
            String resourceIdNextSequence = String.valueOf(resourceOptional.size() + 1);
            if (null != resourceIdNextSequence && resourceIdNextSequence.length() < 5) {
                int uuidNextSequence = resourceIdNextSequence.length();
                for (int i = 0; i <=5 - uuidNextSequence; i++) {
                    resourceIdNextSequence = "0".concat(resourceIdNextSequence);
                }
               resourceList.get(0).setResourceNo(resourceType+resourceIdNextSequence);
                return new ResponseEntity<>(resourceList.get(0).getResourceNo(),HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(resourceList.get(0).getResourceNo(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> createNewResource(ResourceDTO resource) {
        Optional<Resource> resource2 = resourceRepo.findById(resource.getResourceId());

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setAmbiguityIgnored(true);
        Resource resource1 = mapper.map(resource, Resource.class);
        return new ResponseEntity<>(resourceRepo.save(resource1),HttpStatus.CREATED);
    }

}
