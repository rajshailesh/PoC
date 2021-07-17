package com.cdfi.group.domain;

import lombok.Data;

import java.math.BigInteger;
@Data
public class MemberSystemTags {

    private BigInteger systemtags_id;

    private String system_tag_guid;
    private String member_guid;

    private BigInteger member_code;
    private BigInteger cbo_id;

    private Integer system_type;

    private String system_id;
    private Short status;

    private Short entry_source;

    private Integer is_edited;
    private Short is_active;

    private String uploaded_by;

    private String created_by;
    private String updated_by;
    private Integer created_date;
    private Integer uploaded_date;
    private Integer updated_date;
}