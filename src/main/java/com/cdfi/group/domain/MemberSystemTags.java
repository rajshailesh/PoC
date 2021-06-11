package com.cdfi.group.domain;

import lombok.Data;

import java.math.BigInteger;
@Data
public class MemberSystemTags {

    private BigInteger systemtags_id;
   // @NotBlank(message = "system_tag_guid cannot be empty")
    private String system_tag_guid;
    private String member_guid;

    private BigInteger member_code;
    private BigInteger cbo_id;
    //@NotNull(message = "System Type cannot be empty")
    private Integer system_type;
    //@NotNull(message = "System Id cannot be empty")
    private String system_id;
    private Short status;
    //@NotNull(message = "Set Entry Source")
    private Short entry_source;
    //@NotNull(message = "Set Is Edited")
    private Integer is_edited;
    private Short is_active;

    private String uploaded_by;
    //@NotBlank(message = "Created By cannot be empty")
    private String created_by;
    private String updated_by;
    private Integer created_date;
    private Integer uploaded_date;
    private Integer updated_date;
}