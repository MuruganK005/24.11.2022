package com.candidate.entity.logEntity;

import com.candidate.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "contactDetailsLog")
@AllArgsConstructor
@NoArgsConstructor
public class ContactDetailsLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "contact_details_log_id", nullable = false)
    private Long contactDetailsLogId;

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
    @JoinColumn(name = "contact_log_id")
    private List<AddressLog> addressLogs;

}
