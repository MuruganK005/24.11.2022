package com.candidate.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "contactDetails")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ContactDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "contact_id")
    private Long contactId;
    @Column(name="primary_email",length = 50)
    private String primaryEmail;
    @Column(name="secondary_email",length = 50)
    private String secondaryEmail;
    @Column(name="phone_number",length = 15)
    private String phoneNumber;
    @Column(name="alternate_phone_number",length = 15)
    private String alternatePhoneNumber;


    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name = "contact_id")
    private List<Address> address;

}