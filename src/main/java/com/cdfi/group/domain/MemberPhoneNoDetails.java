package com.cdfi.group.domain;

import lombok.Data;

import java.math.BigInteger;
@Data
public class MemberPhoneNoDetails {
    private BigInteger member_phone_details_id;
    private String phone_guid;
    private String member_guid;
    private BigInteger member_code;
    private BigInteger phone_no;
    private Short is_default;
    private Short phone_ownership;
    private String phone_ownership_details;
    private Integer valid_from;
    private Integer valid_till;
    private Short entry_source;
    private Integer is_edited;
    private Short is_active;
    private String uploaded_by;
    private String created_by;
    private String updated_by;
    private Short activation_status;
    private Short dedupl_status;
    private BigInteger cbo_id;
    private Short status;
    private Integer created_date;
    private Integer uploaded_date;
    private Integer updated_date;

}
