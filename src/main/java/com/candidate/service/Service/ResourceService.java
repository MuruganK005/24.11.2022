package com.candidate.service.Service;

import com.candidate.dto.ResourceDTO;
import com.candidate.dto.ResponseDTO;
import com.candidate.entity.Resource;
import com.candidate.exception.CandidateException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ResourceService {
    ResponseEntity<ResponseDTO> createResource(String resource, MultipartFile multipartFile) throws CandidateException, IOException;

    ResponseEntity<ResponseDTO> updateResource(String resource, MultipartFile multipartFile) throws CandidateException, IOException;

    ResponseEntity<String> deleteResource(Long id);

    ResponseEntity<String> deleteResourceAll();

    ResponseEntity<Optional<Resource>> getResource(Long id);

    ResponseEntity<List<Resource>> getResourceList();
    String getLastResourceNo();

    ResponseEntity<Object> createNewResource(ResourceDTO resource);

}
