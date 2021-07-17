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
    private BigInteger cbo_address_id;
    @Column(name = "cbo_id", nullable = false)
    private BigInteger cbo_id;
    @Column(name = "address_guid")
    private String address_guid;
    @Column(name = "cbo_guid")
    private String cbo_guid;
    @Column(name = "address_type")
    private Short address_type;
    @Column(name = "cbo_type", nullable = false)
    private Short cbo_type;
    @Column(name = "urban_rural")
    private String urban_rural;
    @Column(name = "address_line1", nullable = false)
    private String address_line1;
    @Column(name = "address_line2")
    private String address_line2;
    @Column(name = "city_town")
    private String city_town;
    @Column(name = "landmark")
    private String landmark;
    @Column(name = "village_id", nullable = false)
    private Integer village_id;
    @Column(name = "panchayat_id", nullable = false)
    private Integer panchayat_id;
    @Column(name = "block_id", nullable = false)
    private Integer block_id;
    @Column(name = "district_id", nullable = false)
    private Integer district_id;
    @Column(name = "state_id", nullable = false)
    private Integer state_id;
    @Column(name = "postal_code", nullable = false)
    private String postal_code;
    @Column(name = "status")
    private Short status;
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
    @Column(name = "entry_source", nullable = false)
    private Short entry_source;
    @Column(name = "is_edited", nullable = false)
    private Integer isEdited;
    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;
    @Column(name = "created_by", nullable = false)
    private String created_by;
    @Column(name = "last_uploaded_date")
    private LocalDateTime lastUploadedDate;
    @Column(name = "uploaded_by")
    private String uploaded_by;
    @Column(name = "updated_date")
    private LocalDateTime updatedDate;
    @Column(name = "updated_by")
    private String updated_by;

    @Column(name = "is_verified")
    private Integer is_verified;

    @Column(name = "is_complete")
    private Integer is_complete;


}
