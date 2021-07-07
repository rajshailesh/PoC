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
    private BigInteger cboBankId;
    @Column(name = "bank_guid")
    private String bankGuid;
    @Column(name = "cbo_guid")
    private String cboGuid;
    @Column(name = "cbo_id", nullable = false)
    private BigInteger cboId;
    @Column(name = "account_no", nullable = false)
    private String accountNo;
    @Column(name = "bank_id", nullable = false)
    private Integer bankId;
    @Column(name = "account_opening_date")
    private Date accountOpeningDate;
    @Column(name = "account_linkage_date")
    private Date accountLinkageDate;
    @Column(name = "bank_code")
    private String bankCode;
    @Column(name = "bank_branch")
    private String bankBranch;
    @Column(name = "bank_branch_id", nullable = false)
    private BigInteger bankBranchId;
    @Column(name = "ifsc_code", nullable = false)
    private String ifscCode;
    @Column(name = "is_default", nullable = false)
    private Boolean isDefault;
    @Column(name = "sequence_no", nullable = false)
    private Integer sequenceNo;
    @Column(name = "account_type")
    private String accountType;
    @Column(name = "verification")
    private Integer verification;
    @Column(name = "closure_date")
    private Date closureDate;
    @Column(name = "dedupl_status")
    private Short deduplicationStatus;
    @Column(name = "cbo_type")
    private Short cboType;
    @Column(name = "activation_status")
    private Short activationStatus;
    @Column(name = "bankpassbook_name")
    private String bankpassbookName;
    @Column(name = "passbook_firstpage")
    private String passbookFirstpage;
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

    @Column(name = "bank_document_id")
    private BigInteger bankDocumentId;


    @Column(name = "identified_duplicates")
    private String identifiedDuplicates;
    @Column(name = "npci_status")
    private Short npciStatus;


    @Column(name = "is_verified")
    private Integer isVerified;

    @Column(name = "is_complete")
    private Integer isComplete;


}
