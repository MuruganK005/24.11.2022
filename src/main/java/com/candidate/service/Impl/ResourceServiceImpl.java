package com.candidate.service.Impl;

import com.candidate.dto.ResourceDTO;
import com.candidate.dto.ResponseDTO;
import com.candidate.entity.Resource;
import com.candidate.entity.ResourceType;
import com.candidate.entity.logEntity.AddressLog;
import com.candidate.entity.logEntity.ContactDetailsLog;
import com.candidate.entity.logEntity.ResourceLog;
import com.candidate.exception.CandidateException;
import com.candidate.repo.ResourceLogRepo;
import com.candidate.repo.ResourceRepo;
import com.candidate.repo.ResourceTypeRepo;
import com.candidate.service.Service.ResourceService;
import com.candidate.uploadAndDownload.FileUploadResponse;
import com.candidate.uploadAndDownload.FileUploadUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceRepo resourceRepo;

    @Autowired
    private ResourceLogRepo resourceLogRepo;

    @Autowired
    private ResourceTypeRepo resourceTypeRepo;

    @Override
    public ResponseEntity<ResponseDTO> createResource(String resource, MultipartFile multipartFile) throws CandidateException, IOException {
        GsonBuilder gsonBuilder=new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        gsonBuilder.setLenient();
        Gson gson=gsonBuilder.create();
        ResourceDTO resourceDTO=gson.fromJson(resource,ResourceDTO.class);
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setAmbiguityIgnored(true);
        Resource resource1 = mapper.map(resourceDTO, Resource.class);
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        long size = multipartFile.getSize();
        String filecode = FileUploadUtil.saveFile(fileName, multipartFile);
        resource1.setProfilePicturePath(filecode);
        FileUploadResponse response = new FileUploadResponse();
        response.setFileName(fileName);
        response.setSize(size);
        response.setDownloadUri("/downloadFile/" + filecode);
            resource1.setResourceNo(getLastResourceNo());
            Optional<Resource> resource2=resourceRepo.findByAadhaarNumber(resource1.getAadhaarNumber());
            if (resource2.isPresent()) {
                throw new CandidateException(HttpStatus.BAD_REQUEST,"Aadhaar Number Already Exist");
            }else {
                resourceRepo.save(resource1);
            }
            ResponseDTO responseDTO=new ResponseDTO();
            responseDTO.setFile(response);
            responseDTO.setData(resource1);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseDTO> updateResource(String resource, MultipartFile multipartFile) throws CandidateException, IOException {
        GsonBuilder gsonBuilder=new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson=gsonBuilder.create();
        ResourceDTO resourceDTO=gson.fromJson(resource,ResourceDTO.class);
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setAmbiguityIgnored(true);
        Resource resource1 = mapper.map(resourceDTO, Resource.class);
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        long size = multipartFile.getSize();
        String filecode = FileUploadUtil.saveFile(fileName, multipartFile);
        FileUploadResponse response = new FileUploadResponse();
        response.setFileName(fileName);
        response.setSize(size);
        response.setDownloadUri("/downloadFile/" + filecode);
        resource1.setResourceNo(getLastResourceNo());
        Optional<Resource> resource2=resourceRepo.findByAadhaarNumber(resource1.getAadhaarNumber());
        if (resource2.isPresent()&& resource2.get().getResourceId()!= resourceDTO.getResourceId()) {
            throw new CandidateException(HttpStatus.BAD_REQUEST,"Aadhaar Number Already Exist");
        }else {
            resourceRepo.save(resource1);
        }
        if (resourceDTO.getResourceId() != null) {
            ResourceLog log = new ResourceLog();
            log.setResourceLogId(resource1.getResourceId());
            log.setFirstName(resource1.getFirstName());
            log.setMiddleName(resource1.getMiddleName());
            log.setLastName(resource1.getLastName());
            log.setResourceNo(resource1.getResourceNo());
            log.setStatus(resource1.getStatus());
            log.setGender(resource1.getGender());
            log.setDepartment(resource1.getDepartment());
            log.setDesignation(resource1.getDesignation());
            log.setAadhaarNumber(resource1.getAadhaarNumber());
            log.setPanNumber(resource1.getPanNumber());
            log.setReportingManger(resource1.getReportingManger());
            ResourceType resourceType = new ResourceType();
            resourceType.setResourceType(resource1.getResourceType().getResourceType());
            resourceType.setResourceType(resource1.getResourceType().getPrefix());
            ContactDetailsLog contactDetailsLog = new ContactDetailsLog();
            contactDetailsLog.setContactDetailsLogId(resource1.getContactDetails().getContactId());
            contactDetailsLog.setPrimaryEmail(resource1.getContactDetails().getPrimaryEmail());
            contactDetailsLog.setSecondaryEmail(resource1.getContactDetails().getSecondaryEmail());
            contactDetailsLog.setPhoneNumber(resource1.getContactDetails().getPhoneNumber());
            contactDetailsLog.setAlternatePhoneNumber(resource1.getContactDetails().getAlternatePhoneNumber());
            AddressLog addressLogs = new AddressLog();
            addressLogs.setAddressLogId(resource1.getContactDetails().getAddress().get(0).getAddressId());
            addressLogs.setDoorNo(resource1.getContactDetails().getAddress().get(0).getDoorNo());
            addressLogs.setStreet(resource1.getContactDetails().getAddress().get(0).getStreet());
            addressLogs.setLocality(resource1.getContactDetails().getAddress().get(0).getLocality());
            addressLogs.setCity(resource1.getContactDetails().getAddress().get(0).getCity());
            addressLogs.setState(resource1.getContactDetails().getAddress().get(0).getState());
            addressLogs.setZipCode(resource1.getContactDetails().getAddress().get(0).getZipCode());
            addressLogs.setCountry(resource1.getContactDetails().getAddress().get(0).getCountry());
            resourceLogRepo.save(log);
        }
        ResponseDTO responseDTO=new ResponseDTO();
        responseDTO.setData(resource1);
        responseDTO.setFile(response);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
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
    public synchronized String getLastResourceNo() {
        String resourceNo="T00001";
        List<Resource> temp1 = resourceRepo.findOneByResourceNoOrderByResourceNoDesc();
        if (temp1.isEmpty()) {
            return resourceNo;
        } else {
            String temp = resourceRepo.findOneByResourceNoOrderByResourceNoDesc().get(0).getResourceNo();
            if (temp != null) {
                int count = Integer.parseInt(temp.replaceAll("T", "")) + 1;
                temp = Integer.toString(count);
                String concat = "";
                if (temp.length() < 5) {
                    for (int i = temp.length(); i < 5; i++) {
                        concat = "0" + concat;
                        System.out.println(i);
                        System.out.println(concat);
                    }
                    temp = "T" + concat + temp;
                    return temp;
                }
                return temp;
            }
        }
        return "success";
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
