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
@Table(name = "cbo_bank_details")
public class CboBankDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cbo_bank_id", nullable = false)
    private BigInteger cbo_bank_id;
    @Column(name = "bank_guid")
    private String bank_guid;
    @Column(name = "cbo_guid")
    private String cbo_guid;
    @Column(name = "cbo_id", nullable = false)
    private BigInteger cbo_id;
    @Column(name = "account_no", nullable = false)
    private String account_no;
    @Column(name = "bank_id", nullable = false)
    private Integer bank_id;
    @Column(name = "account_opening_date")
    private Date account_opening_date;
    @Column(name = "account_linkage_date")
    private Date account_linkage_date;
    @Column(name = "bank_code")
    private String bank_code;
    @Column(name = "bank_branch")
    private String bank_branch;
    @Column(name = "bank_branch_id", nullable = false)
    private BigInteger bank_branch_id;
    @Column(name = "ifsc_code", nullable = false)
    private String ifsc_code;
    @Column(name = "is_default", nullable = false)
    private Boolean is_default;
    @Column(name = "sequence_no", nullable = false)
    private Integer sequence_no;
    @Column(name = "account_type")
    private String account_type;
    @Column(name = "verification")
    private Integer verification;
    @Column(name = "closure_date")
    private Date closure_date;
    @Column(name = "dedupl_status")
    private Short dedupl_status;
    @Column(name = "cbo_type")
    private Short cbo_type;
    @Column(name = "activation_status")
    private Short activation_status;
    @Column(name = "bankpassbook_name")
    private String bankpassbook_name;
    @Column(name = "passbook_firstpage")
    private String passbook_firstpage;
    @Column(name = "status")
    private Short status;
    @Column(name = "is_active", nullable = false)
    private Boolean is_active;
    @Column(name = "entry_source", nullable = false)
    private Short entry_source;
    @Column(name = "is_edited", nullable = false)
    private Integer is_edited;
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

    @Column(name = "bank_document_id")
    private BigInteger bank_document_id;


    @Column(name = "identified_duplicates")
    private String identifiidentified_duplicatesedDuplicates;
    @Column(name = "npci_status")
    private Short npci_status;


    @Column(name = "is_verified")
    private Integer is_verified;

    @Column(name = "is_complete")
    private Integer is_complete;


}
