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
@Table(name = "member_kyc_details")
public class MemberKYCDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_kyc_details_id", nullable = false)
    private BigInteger member_kyc_details_id;
    @Column(name = "kyc_guid", nullable = false)
    private String kyc_guid;
    @Column(name = "member_code")
    private BigInteger member_code;
    @Column(name = "member_guid")
    private String member_guid;
     @Column(name = "kyc_type", nullable = false)
    private Integer kyc_type;
     @Column(name = "kyc_number", nullable = false)
    private String kyc_number;
     @Column(name = "document_id")
    private Integer document_id;
    @Column(name = "kyc_valid_from", nullable = false)
    private Date kyc_valid_from;
    @Column(name = "kyc_valid_to", nullable = false)
    private Date kyc_valid_to;
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
    @Column(name = "uploaded_by")
    private String uploaded_by;
    @Column(name = "created_date", nullable = false)
    private LocalDateTime created_date;
    @Column(name = "created_by", nullable = false)
    private String created_by;
    @Column(name = "updated_date")
    private LocalDateTime updated_date;
    @Column(name = "updated_by")
    private String updated_by;
    @Column(name = "cbo_id")
    private BigInteger cbo_id;
    @Column(name = "dedupl_status")
    private Short dedupl_status;
    @Column(name = "activation_status")
    private Short activation_status;
    @Column(name = "kyc_front_doc_orig_name")
    private String kyc_front_doc_orig_name;
    @Column(name = "kyc_rear_doc_orig_name")
    private String kyc_rear_doc_orig_name;

    @Column(name = "kyc_front_doc_id")
    private BigInteger kyc_front_doc_id;
    @Column(name = "kyc_rear_doc_id")
    private BigInteger kyc_rear_doc_id;
    @Column(name = "is_verified")
    private Integer is_verified;

    @Column(name = "is_complete")
    private Integer is_complete;
}
