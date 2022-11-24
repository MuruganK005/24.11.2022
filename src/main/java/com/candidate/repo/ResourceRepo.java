package com.candidate.repo;

import aj.org.objectweb.asm.ConstantDynamic;
import com.candidate.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResourceRepo extends JpaRepository<Resource,Long> {
    //Optional<Resource> findByResourceNo(String resourceNo);

   // Optional<Resource> findByResourceNoByOrderByDesc(String resourceNo);


    List<Resource> findByResourceType(String resourceNo);

    //List<Resource> findByResourceTypeOrderByResourceNoDesc(String resourceType);

    List<Resource> findOneByResourceTypeOrderByResourceNoDesc(String resourceType);
}
