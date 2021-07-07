package com.cdfi.group.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cbo_addresses_details")
public class CboAddressesDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cbo_address_id", nullable = false)
    private BigInteger cboAddressId;
    @Column(name = "cbo_id", nullable = false)
    private BigInteger cboId;
    @Column(name = "address_guid")
    private String addressGuid;
    @Column(name = "cbo_guid")
    private String cboGuid;
    @Column(name = "address_type")
    private Short addressType;
    @Column(name = "cbo_type", nullable = false)
    private Short cboType;
    @Column(name = "urban_rural")
    private String urbanRural;
    @Column(name = "address_line1", nullable = false)
    private String addressLine1;
    @Column(name = "address_line2")
    private String addressLine2;
    @Column(name = "city_town")
    private String cityTown;
    @Column(name = "landmark")
    private String landmark;
    @Column(name = "village_id", nullable = false)
    private Integer villageId;
    @Column(name = "panchayat_id", nullable = false)
    private Integer panchayatId;
    @Column(name = "block_id", nullable = false)
    private Integer blockId;
    @Column(name = "district_id", nullable = false)
    private Integer districtId;
    @Column(name = "state_id", nullable = false)
    private Integer stateId;
    @Column(name = "postal_code", nullable = false)
    private String postalCode;
    @Column(name = "status")
    private Short status;
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
    @Column(name = "entry_source", nullable = false)
    private Short entrySource;
    @Column(name = "is_edited", nullable = false)
    private Integer isEdited;
    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;
    @Column(name = "created_by", nullable = false)
    private String createdBy;
    @Column(name = "last_uploaded_date")
    private LocalDateTime lastUploadedDate;
    @Column(name = "uploaded_by")
    private String uploadedBy;
    @Column(name = "updated_date")
    private LocalDateTime updatedDate;
    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "is_verified")
    private Integer isVerified;

    @Column(name = "is_complete")
    private Integer isComplete;


}
