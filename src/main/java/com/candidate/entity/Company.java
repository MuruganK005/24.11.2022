package com.candidate.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "company")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "company_id", nullable = false)
    private Long companyId;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "company_address")
    private String companyAddress;
    @Column(name = "company_phone")
    private String companyPhone;
    @Column(name = "company_email")
    private String companyEmail;

}
