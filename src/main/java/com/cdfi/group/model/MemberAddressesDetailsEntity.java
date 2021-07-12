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
@Table(name = "member_address")
public class MemberAddressesDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_address_id", nullable = false)
    private BigInteger member_address_id;


    @Column(name = "member_guid")
    private String member_guid;
   @Column(name = "address_guid", nullable = false)
   private String address_guid;
    @Column(name = "cbo_id")
    private BigInteger cbo_id;
    @Column(name = "member_code")
    private BigInteger memberCode;
    @Column(name = "address_type")
    private Short addressType;
    @Column(name = "address_line1", nullable = false)
    private String addressLine1;
    @Column(name = "address_line2")
    private String addressLine2;
    @Column(name = "village" , nullable = false)
    private Integer village;
    @Column(name = "block_id" , nullable = false)
    private Integer block_id;
    @Column(name = "panchayat_id" , nullable = false)
    private Integer panchayat_id;
    @Column(name = "landmark")
    private Integer landmark;
    @Column(name = "state", nullable = false)
    private Integer state;
    @Column(name = "district", nullable = false)
    private Integer district;
    @Column(name = "postal_code", nullable = false)
    private Integer postalCode;
    @Column(name = "status")
    private Short status;
    @Column(name = "entry_source", nullable = false)
    private Short entrySource;
    @Column(name = "is_edited", nullable = false)
    private Integer isEdited;
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
    @Column(name = "last_uploaded_date")
    private LocalDateTime lastUploadedDate;
    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;
    @Column(name = "created_by", nullable = false)
    private String createdBy;
    @Column(name = "updated_date")
    private LocalDateTime updatedDate;
    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "address_location")
    private Short addressLocation;

    @Column(name = "is_verified")
    private Integer isVerified;

    @Column(name = "is_complete")
    private Integer isComplete;

}
