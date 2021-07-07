package com.cdfi.group.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
@Entity
@Table(name = "funding_agency_master")
public class FundingAgencyMasterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "funding_agency_id", nullable = false)
    private BigInteger fundingAgencyId;
    @Column(name = "state_id", nullable = false)
    private Integer stateId;
    @Column(name = "district_id")
    private String districtId;
    @Column(name = "block_id")
    private String blockId;
    @Column(name = "agency_code")
    private String agencyCode;
    @Column(name = "agency_name", nullable = false)
    private String agencyName;
    @Column(name = "agency_name_language_id")
    private String agencyNameLanguageId;
    @Column(name = "agency_type")
    private Short agencyType;
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;
    @Column(name = "created_by", nullable = false)
    private String createdBy;
    @Column(name = "updated_date")
    private LocalDateTime updatedDate;
    @Column(name = "updated_by")
    private String updatedBy;

}
