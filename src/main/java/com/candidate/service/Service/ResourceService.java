package com.candidate.service.Service;

import com.candidate.dto.ResourceDTO;
import com.candidate.entity.Resource;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ResourceService {
    ResponseEntity<String> createResource(ResourceDTO resource);

    ResponseEntity<String> updateResource(ResourceDTO resource);

    ResponseEntity<String> deleteResource(Long id);

    ResponseEntity<String> deleteResourceAll();

    ResponseEntity<Optional<Resource>> getResource(Long id);

    ResponseEntity<List<Resource>> getResourceList();

    ResponseEntity<String> getLastResourceNo(String resourceType);

    /* Optional<Resource> getLastResourceNo(String resourceNo);*/
}
