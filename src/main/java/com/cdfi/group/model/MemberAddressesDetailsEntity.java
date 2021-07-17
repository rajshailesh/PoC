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
    private BigInteger member_code;
    @Column(name = "address_type")
    private Short address_type;
    @Column(name = "address_line1", nullable = false)
    private String address_line1;
    @Column(name = "address_line2")
    private String address_line2;
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
    private Short entry_source;
    @Column(name = "is_edited", nullable = false)
    private Integer is_edited;
    @Column(name = "is_active", nullable = false)
    private Boolean is_active;
    @Column(name = "last_uploaded_date")
    private LocalDateTime last_uploaded_date;
    @Column(name = "created_date", nullable = false)
    private LocalDateTime created_date;
    @Column(name = "created_by", nullable = false)
    private String created_by;
    @Column(name = "updated_date")
    private LocalDateTime updated_date;
    @Column(name = "updated_by")
    private String updated_by;

    @Column(name = "address_location")
    private Short address_location;

    @Column(name = "is_verified")
    private Integer is_verified;

    @Column(name = "is_complete")
    private Integer is_complete;

}
