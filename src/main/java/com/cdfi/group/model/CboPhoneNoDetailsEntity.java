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
    private BigInteger cbo_phone_id;
    @Column(name = "phone_guid")
    private String phone_guid;
    @Column(name = "cbo_guid")
    private String cbo_guid;
    @Column(name = "cbo_id", nullable = false)
    private BigInteger cbo_id;
    @Column(name = "mobile_no", nullable = false)
    private BigInteger mobile_no;
    @Column(name = "cbo_type", nullable = false)
    private Short cbo_type;
    @Column(name = "phone_ownership", nullable = false)
    private Short phone_ownership;
    @Column(name = "phone_ownership_details")
    private String phone_ownership_details;
    @Column(name = "valid_from", nullable = false)
    private Date validFrom;
    @Column(name = "valid_till")
    private Date validTill;
    @Column(name = "is_default", nullable = false)
    private Short is_default;
    @Column(name = "dedupl_status")
    private Short dedupl_status;
    @Column(name = "activation_status")
    private Short activation_status;
    @Column(name = "status")
    private Short status;
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
    @Column(name = "entry_source", nullable = false)
    private Short entry_source;
    @Column(name = "is_edited", nullable = false)
    private Integer isEdited;
    @Column(name = "last_uploaded_date")
    private LocalDateTime lastUploadedDate;
    @Column(name = "uploaded_by")
    private String uploaded_by;
    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;
    @Column(name = "created_by", nullable = false)
    private String created_by;
    @Column(name = "updated_date")
    private LocalDateTime updatedDate;
    @Column(name = "updated_by")
    private String updated_by;
    @Column(name = "member_guid")
    private String member_guid;
    @Column(name = "is_verified")
    private Integer is_verified;

    @Column(name = "is_complete")
    private Integer is_complete;

}
