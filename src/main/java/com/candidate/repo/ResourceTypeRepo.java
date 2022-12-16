package com.candidate.repo;

import com.candidate.entity.Resource;
import com.candidate.entity.ResourceType;
import com.candidate.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceTypeRepo extends JpaRepository<ResourceType,Long> {

    @Query("SELECT u FROM ResourceType u ORDER BY u.resourceTypeNo DESC")
    List<ResourceType> findOneByResourceTypeNoOrderByResourceTypeNoDesc();

    //List<ResourceType> findByResourceTypeName(String search);

    List<ResourceType> findByResourceType(String search);

   // ResourceType findByResourceTypeNo(String resourceTypeNo);

    //ResourceType findByResourceTypeId(long resourceTypeId);
}
