package com.candidate.entity.logEntity;

import com.candidate.entity.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "resourceLog")
@AllArgsConstructor
@NoArgsConstructor
public class ResourceLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "resource_log_id")
    private Long resourceLogId;

    @Column(name = "resource_id")
    private Long resourceId;

    @Column(name="resource_no")
    private String resourceNo;

    @Column(name="first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name="last_name")
    private String lastName;

    @Column(name = "gender")
    private String gender;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "department_department_id")
    private Department department;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "designation_designation_id")
    private Designation designation;

    @Column(name = "aadhaar_number",length = 12)
    private Long aadhaarNumber;

    @Column(name = "pan_number",length = 15)
    private String panNumber;

    @Column(name = "reporting_manager")
    private String reportingManger;

    @Column(name="status")
    private Boolean status=false;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "resource_type_resource_id")
    private ResourceType resourceType;

    @Column(name = "profile_picture_path")
    private String profilePicturePath;


    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_details_contact_details_log_id")
    private ContactDetailsLog contactDetails;


    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "resource_role_log_ids",
            joinColumns = {@JoinColumn(name = "resource_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private List<Role> role;

}
