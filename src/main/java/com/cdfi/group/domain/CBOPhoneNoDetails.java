package com.cdfi.group.domain;

import lombok.Data;

import java.math.BigInteger;
@Data
public class CBOPhoneNoDetails {

    private BigInteger cbo_phone_id;
    private  String phone_guid;
    private String cbo_guid;
    private BigInteger cbo_id;
    private BigInteger mobile_no;
    private Short phone_ownership;
    private String phone_ownership_details;
    private Integer  valid_from;
    private Integer valid_till;
    private Short cbo_type;
    private Short status;
    private Short deduplication_status;
    private Short activation_status;
    private Short is_default;
    private Short entry_source;
    private Integer is_edited;
    private Short is_active;
    private Integer last_uploaded_date;
    private String uploaded_by;
    private Integer created_date;
    private String created_by;
    private Integer updated_date;
    private String updated_by;
    private String member_guid;
    private String member_name;
    private String identified_duplicates;

    private Integer is_verified;
    private Integer is_complete;
}
