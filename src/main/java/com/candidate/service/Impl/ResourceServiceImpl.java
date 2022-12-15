package com.candidate.service.Impl;

import com.candidate.dto.ResourceDTO;
import com.candidate.dto.ResponseDTO;
import com.candidate.entity.*;
import com.candidate.entity.logEntity.AddressLog;
import com.candidate.entity.logEntity.ContactDetailsLog;
import com.candidate.entity.logEntity.ResourceLog;
import com.candidate.exception.CandidateException;
import com.candidate.repo.*;
import com.candidate.service.Service.ResourceService;
import com.candidate.uploadAndDownload.FileUploadResponse;
import com.candidate.uploadAndDownload.FileUploadUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
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

    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private DesignationRepo designationRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private CompanyRepo companyRepo;


    @Override
    public ResponseEntity<ResponseDTO> createResource(ResourceDTO resourceDTO, MultipartFile multipartFile) throws CandidateException, IOException {

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
            Optional<Resource> resource2=resourceRepo.findByAadhaarNumber(resource1.getAadhaarNumber());
            if (resource2.isPresent()) {
                throw new CandidateException(HttpStatus.BAD_REQUEST,"Aadhaar Number Already Exist");
            }else {
                resource1.setResourceNo(getLastResourceNo());
                resource1.getResourceType().setResourceTypeNo(getLastResourceTypeNo());
                resource1.getCompany().setCompanyNo(getLastCompanyNo());
                resource1.getRole().get(0).setRoleNo(getLastRoleNo());
                resource1.getDepartment().setDepartmentNo(getLastDepartmentNo());
                resource1.getDesignation().setDesignationNo(getLastDesignationNo());
                resourceRepo.save(resource1);
            }
            ResponseDTO responseDTO=new ResponseDTO();
            responseDTO.setFile(response);
            responseDTO.setData(resource1);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseDTO> updateResource(ResourceDTO resource, MultipartFile multipartFile) throws CandidateException, IOException {

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setAmbiguityIgnored(true);
        Resource resource1 = mapper.map(resource, Resource.class);
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        long size = multipartFile.getSize();
        String filecode = FileUploadUtil.saveFile(fileName, multipartFile);
        FileUploadResponse response = new FileUploadResponse();
        response.setFileName(fileName);
        response.setSize(size);
        response.setDownloadUri("/downloadFile/" + filecode);
        if (resource.getResourceId()==null) {
            resource1.setResourceNo(getLastResourceNo());
        }
        Optional<Resource> resource2 = resourceRepo.findByAadhaarNumber(resource.getAadhaarNumber());
        if (resource2.isPresent() && !resource2.get().getResourceId().equals(resource.getResourceId())) {
            throw new CandidateException(HttpStatus.BAD_REQUEST, "Aadhaar Number Already Exist");
        } else {
            resourceRepo.save(resource1);
        }
        if (resource.getResourceId() != null) {
            Optional<Resource> resource3 = resourceRepo.findByResourceId(resource.getResourceId());
            if (resource3.isPresent()) {
                ResourceLog log = new ResourceLog();
                log.setResourceLogId(resource3.get().getResourceId());
                log.setResourceId(resource3.get().getResourceId());
                log.setFirstName(resource3.get().getFirstName());
                log.setMiddleName(resource3.get().getMiddleName());
                log.setLastName(resource3.get().getLastName());
                log.setResourceNo(resource3.get().getResourceNo());
                log.setStatus(resource3.get().getStatus());
                log.setGender(resource3.get().getGender());
                log.setDepartment(resource3.get().getDepartment());
                log.setDesignation(resource3.get().getDesignation());
                log.setAadhaarNumber(resource3.get().getAadhaarNumber());
                log.setPanNumber(resource3.get().getPanNumber());
                log.setReportingManger(resource3.get().getReportingManger());
                log.setProfilePicturePath(resource3.get().getProfilePicturePath());
                log.setCompany(resource3.get().getCompany());
                log.setResourceType(resource3.get().getResourceType());
                ResourceType resourceType = new ResourceType();
                resourceType.setResourceType(resource3.get().getResourceType().getResourceType());
                resourceType.setResourceType(resource3.get().getResourceType().getPrefix());
                ContactDetailsLog contactDetailsLog = new ContactDetailsLog();
                contactDetailsLog.setContactDetailsLogId(resource3.get().getContactDetails().getContactId());
                contactDetailsLog.setContactId(resource3.get().getContactDetails().getContactId());
                contactDetailsLog.setPrimaryEmail(resource3.get().getContactDetails().getPrimaryEmail());
                contactDetailsLog.setSecondaryEmail(resource3.get().getContactDetails().getSecondaryEmail());
                contactDetailsLog.setPhoneNumber(resource3.get().getContactDetails().getPhoneNumber());
                contactDetailsLog.setAlternatePhoneNumber(resource3.get().getContactDetails().getAlternatePhoneNumber());
                log.setContactDetails(contactDetailsLog);
                ArrayList<AddressLog> addresses = new ArrayList<AddressLog>();
                AddressLog addressLogs = new AddressLog();
                addressLogs.setAddressLogId(resource3.get().getContactDetails().getAddress().get(0).getAddressId());
                addressLogs.setAddressId(resource3.get().getContactDetails().getAddress().get(0).getAddressId());
                addressLogs.setDoorNo(resource3.get().getContactDetails().getAddress().get(0).getDoorNo());
                addressLogs.setStreet(resource3.get().getContactDetails().getAddress().get(0).getStreet());
                addressLogs.setLocality(resource3.get().getContactDetails().getAddress().get(0).getLocality());
                addressLogs.setCity(resource3.get().getContactDetails().getAddress().get(0).getCity());
                addressLogs.setState(resource3.get().getContactDetails().getAddress().get(0).getState());
                addressLogs.setZipCode(resource3.get().getContactDetails().getAddress().get(0).getZipCode());
                addressLogs.setCountry(resource3.get().getContactDetails().getAddress().get(0).getCountry());
                addresses.add(addressLogs);
                contactDetailsLog.setAddressLogs(addresses);
                Company company=new Company();
                company.setCompanyId(resource3.get().getCompany().getCompanyId());
                company.setCompanyName(resource3.get().getCompany().getCompanyName());
                company.setCompanyPhone(resource3.get().getCompany().getCompanyPhone());
                company.setCompanyEmail(resource3.get().getCompany().getCompanyEmail());
                company.setCompanyAddress(resource3.get().getCompany().getCompanyAddress());
                resourceLogRepo.save(log);
            }
        }
            ResponseDTO responseDTO = new ResponseDTO();
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
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setAmbiguityIgnored(true);
        Resource resource1 = mapper.map(resource, Resource.class);
        return new ResponseEntity<>(resourceRepo.save(resource1),HttpStatus.CREATED);
    }

    @Override
    public synchronized String getLastDepartmentNo() {
        String departmentNo="D00001";
        List<Department> temp1 = departmentRepo.findOneByDepartmentNoOrderByDepartmentNoDesc();
        if (temp1.isEmpty()) {
            return departmentNo;
        } else {
            String temp = departmentRepo.findOneByDepartmentNoOrderByDepartmentNoDesc().get(0).getDepartmentNo();
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

    @Override
    public synchronized String getLastDesignationNo() {
        String designationNo="DS00001";
        List<Designation> temp1 = designationRepo.findOneByDesignationNoOrderByDesignationNoDesc();
        if (temp1.isEmpty()) {
            return designationNo;
        } else {
            String temp = designationRepo.findOneByDesignationNoOrderByDesignationNoDesc().get(0).getDesignationNo();
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

    @Override
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

    @Override
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

    @Override
    public String getLastRoleNo() {
        String roleNo="RL00001";
        List<Role> temp1 = roleRepo.findOneByRoleNoOrderByRoleNoDesc();
        if (temp1.isEmpty()) {
            return roleNo;
        } else {
            String temp = roleRepo.findOneByRoleNoOrderByRoleNoDesc().get(0).getRoleNo();
            if (temp != null) {
                int count = Integer.parseInt(temp.replaceAll("RL", "")) + 1;
                temp = Integer.toString(count);
                String concat = "";
                if (temp.length() < 5) {
                    for (int i = temp.length(); i < 5; i++) {
                        concat = "0" + concat;
                        System.out.println(i);
                        System.out.println(concat);
                    }
                    temp = "RL" + concat + temp;
                    return temp;
                }
                return temp;
            }
        }
        return "success";
    }

}
