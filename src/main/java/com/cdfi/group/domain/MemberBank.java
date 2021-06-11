package com.cdfi.group.domain;

import lombok.Data;

import java.math.BigInteger;
@Data
public class MemberBank {
    private BigInteger member_bank_details_id;
    private String bank_guid;
    private BigInteger member_code;
    private String member_guid;
    private String account_no;
    private BigInteger bank_id;
    private Short account_type;
    private String mem_branch_code;
    private String ifsc_code;
    private Integer account_open_date;
    private Integer is_default_account;
    private Short status;
    private Integer closing_date;
    private String gl_code;
    private Integer same_as_group;
    private Short entry_source;
    private Integer is_edited;
    private Short is_active;
    private String updated_by;
    private String created_by;
    private String uploaded_by;
    private Short activation_status;
    private Short dedupl_status;
    private BigInteger cbo_id;
    private String bank_passbook_name;
    private String passbook_first_page;
    private Integer created_date;
    private Integer uploaded_date;
    private Integer updated_date;
	private String member_name;
    private String member_bank_document;
    private String identify_duplicate;
    private Short npci_status;

}
