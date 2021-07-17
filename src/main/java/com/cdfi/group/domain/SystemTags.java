package com.cdfi.group.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;

@Data
public class SystemTags {

    private BigInteger systemtags_id;

    private String system_tag_guid;
    private String cbo_guid;

    private BigInteger cbo_code;

    private Short system_type;

    private String system_id;
    private Short status;

    private Short entry_source;

    private Integer is_edited;
    private Short is_active;

    private String uploaded_by;

    private String created_by;
    private String updated_by;
    private Integer last_uploaded_date;
    @NotNull(message = "Created Date Must be Given")
    private Integer created_date;
    private Integer updated_date;
    private Integer is_complete;
}