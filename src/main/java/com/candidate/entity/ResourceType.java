package com.candidate.entity;

import lombok.*;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "resourceType")
public class ResourceType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "resource_type_id")
    private Long resourceTypeId;
    @Column(name = "resource_type")
    private String resourceType;
    @Column(name = "prefix")
    private String prefix;
    @Column(name = "resource_type_no")
    private String resourceTypeNo;


}
