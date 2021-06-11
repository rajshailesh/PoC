package com.cdfi.group.domain;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;
@Data
public class CBOBankDetails {
    private BigInteger cbo_bank_id;
    private String bank_guid;
    private String cbo_guid;
    private BigInteger cbo_id;
    private String account_no;
    private Integer account_opening_date;
    private Integer account_linkage_date;
    private Integer bank_id;
    private String bank_code;
    private String bank_branch;
    private BigInteger bank_branch_id;
    private String ifsc_code;
    private String account_type;
    private Short is_default;
    private Short cbo_type;
    private Integer sequence_no;
    private Integer verification;
    private Integer closure_date;
    private String bankpassbook_name;
    private String passbook_firstpage;
    private Short status;
    private Short deduplication_status;
    private Short activation_status;
    private Short entry_source;
    private Integer is_edited;
    private Integer last_uploaded_date;
    private String uploaded_by;
    private Integer created_date;
    private String created_by;
    private Integer updated_date;
    private String updated_by;
    private Short is_active;
    private String bank_document;
    private String identify_duplicate;
    private Short npci_status;

}
