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
@Table(name = "member_bank_details")
public class MemberBankDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_bank_details_id", nullable = false)
    private BigInteger member_bank_details_id;
    @Column(name = "bank_guid", nullable = false)
    private String bank_guid;
    @Column(name = "member_guid")
    private String member_guid;
    @Column(name = "member_code")
    private BigInteger member_code;
    @Column(name = "account_no", nullable = false)
    private String account_no;
    @Column(name = "bank_id", nullable = false)
    private BigInteger bank_id;
    @Column(name = "account_type", nullable = false)
    private Short account_type;
    @Column(name = "mem_branch_code", nullable = false)
    private String mem_branch_code;
    @Column(name = "ifsc_code", nullable = false)
    private String ifsc_code;
    @Column(name = "account_open_date", nullable = false)
    private Date accountOpenDate;
    @Column(name = "is_default_account", nullable = false)
    private Integer is_default_account;
    @Column(name = "status")
    private Short status;
    @Column(name = "closing_date")
    private java.util.Date closingDate;
    @Column(name = "gl_code")
    private String gl_code;
    @Column(name = "same_As_Group")
    private Integer same_As_Group;
    @Column(name = "entry_source", nullable = false)
    private Short entry_source;
    @Column(name = "is_edited", nullable = false)
    private Integer isEdited;
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
    @Column(name = "last_uploaded_date", nullable = false)
    private LocalDateTime lastUploadedDate;
    @Column(name = "uploaded_by", nullable = false)
    private String uploaded_by;
    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;
    @Column(name = "created_by", nullable = false)
    private String created_by;
    @Column(name = "updated_date")
    private LocalDateTime updatedDate;
    @Column(name = "updated_by")
    private String updated_by;
    @Column(name = "activation_status")
    private Short activation_status;
    @Column(name = "dedupl_status")
    private Short dedupl_status;
    @Column(name = "cbo_id")
    private BigInteger cbo_id;
    @Column(name = "bank_passbook_name")
    private String bank_passbook_name;
    @Column(name = "passbook_first_page")
    private String passbook_first_page;
    @Column(name = "mem_bank_doc_id")
    private BigInteger mem_bank_doc_id;
    @Column(name = "identified_duplicates")
    private String identified_duplicates;
    @Column(name = "npci_status")
    private Short npci_status;
    @Column(name = "is_verified")
    private Integer is_verified;
    @Column(name = "is_complete")
    private Integer is_complete;
}
