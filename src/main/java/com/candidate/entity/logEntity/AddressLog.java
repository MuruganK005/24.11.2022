package com.candidate.entity.logEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "addressLog")
@AllArgsConstructor
@NoArgsConstructor
public class AddressLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_log_id")
    private Long addressLogId;

    @Column(name = "address_id")
    private Long addressId;
    @Column(name = "door_no")
    private String doorNo;
    @Column(name = "street")
    private String street;
    @Column(name = "locality")
    private String locality;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "zip_code")
    private String zipCode;
    @Column(name = "country")
    private String country;

}
