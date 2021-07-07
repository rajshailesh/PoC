package com.cdfi.group.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cbo_phone_details")
public class CboPhoneNoDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cbo_phone_id", nullable = false)
    private BigInteger cboPhoneId;
    @Column(name = "phone_guid")
    private String phoneGuid;
    @Column(name = "cbo_guid")
    private String cboGuid;
    @Column(name = "cbo_id", nullable = false)
    private BigInteger cboId;
    @Column(name = "mobile_no", nullable = false)
    private BigInteger mobileNo;
    @Column(name = "cbo_type", nullable = false)
    private Short cboType;
    @Column(name = "phone_ownership", nullable = false)
    private Short phoneOwnership;
    @Column(name = "phone_ownership_details")
    private String phoneOwnershipDetails;
    @Column(name = "valid_from", nullable = false)
    private Date validFrom;
    @Column(name = "valid_till")
    private Date validTill;
    @Column(name = "is_default", nullable = false)
    private Short isDefault;
    @Column(name = "dedupl_status")
    private Short deduplicationStatus;
    @Column(name = "activation_status")
    private Short activationStatus;
    @Column(name = "status")
    private Short status;
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
    @Column(name = "entry_source", nullable = false)
    private Short entrySource;
    @Column(name = "is_edited", nullable = false)
    private Integer isEdited;
    @Column(name = "last_uploaded_date")
    private LocalDateTime lastUploadedDate;
    @Column(name = "uploaded_by")
    private String uploadedBy;
    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;
    @Column(name = "created_by", nullable = false)
    private String createdBy;
    @Column(name = "updated_date")
    private LocalDateTime updatedDate;
    @Column(name = "updated_by")
    private String updatedBy;
    @Column(name = "member_guid")
    private String memberGuid;

    @Column(name = "is_verified")
    private Integer isVerified;

    @Column(name = "is_complete")
    private Integer isComplete;

}
