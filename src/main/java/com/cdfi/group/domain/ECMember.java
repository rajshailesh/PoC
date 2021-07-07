package com.cdfi.group.domain;

import lombok.Data;

import javax.validation.constraints.Size;
import java.math.BigInteger;

@Data
public class ECMember {
    private BigInteger executive_member_id;
    private BigInteger cbo_id;
    @Size(max = 50, message = "Cbo guid can be max of 50 char long")
    private String cbo_guid;
    @Size(max = 50, message = "guid can be max of 50 char long")
    private String guid;
    private Short cbo_level;
    private Short ec_cbo_level;
    @Size(max = 50, message = "EC Cbo Code can be max of 50 char long")
    private String ec_cbo_code;
    private BigInteger ec_cbo_id;
    private BigInteger ec_member_code;
    private Short designation;
    private Integer joining_date;
    private Integer leaving_date;
    private Short status;
    private Short is_active;
    private Short entry_source;
    private Integer is_edited;

    @Size(max = 100, message = "Uploaded By can be 100 chars")
    private String uploaded_by;
    @Size(max = 100, message = "Created By can be 100 chars")
    private String created_by;
    @Size(max = 100, message = "Updated By can be 100 chars")
    private String updated_by;
    private Integer last_uploaded_date;
    private Integer created_date;
    private Integer updated_date;

    private String vo_name;
    private String shg_name;
    private String member_name;


}