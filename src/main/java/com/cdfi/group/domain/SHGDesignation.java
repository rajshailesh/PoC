package com.cdfi.group.domain;

import lombok.Data;

import java.math.BigInteger;
@Data
public class SHGDesignation {
    private BigInteger member_designation_id;
    private String cbo_guid;
    private String member_designation_guid;
    private BigInteger cbo_code;
    private BigInteger member_code;
    private String member_guid;
    private Short designation;
    private Integer date_election;
    private Integer from_date;
    private Integer to_date;
    private Short status;
    private Short is_active;
    private Short entry_source;
    private Integer is_edited;
    private Integer last_uploaded_date;
    private String uploaded_by;
    private Integer created_date;
    private String created_by;
    private Integer updated_date;
    private String updated_by;
    private Short is_signatory;

    //30-3-2021
    private String member_name;
}