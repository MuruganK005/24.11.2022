package com.candidate.service.Service;

import com.candidate.entity.ResourceType;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ResourceTypeService {
    ResponseEntity<ResourceType> createResourceType(ResourceType resourceType);

    List<ResourceType> getAllResourceTypeInAsc(String search);

    //List<ResourceType> getAllResourceType(String search);
}
