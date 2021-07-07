package com.cdfi.group.domain;

import lombok.Data;

import javax.validation.constraints.Size;
import java.math.BigInteger;
@Data
public class SubCommitteeMember {
    private BigInteger subcommitee_member_id;
    private BigInteger subcommitee_id;
    @Size(max=50,message="Subcommittee guid can be max of 50 char long")
    private String subcommitee_guid;
    private BigInteger subcommitee_code;
    private BigInteger ec_member_id;
    private BigInteger ec_member_code;
    @Size(max=50,message="EC Member guid can be max of 50 char long")
    private String ec_member_guid;
    private Integer fromdate;
    private Integer todate;

    private Short status;
    private Short is_active;
    private Short entry_source;
    private Integer is_edited;
    @Size(max=100,message="Uploaded By can be 100 chars")
    private String uploaded_by;
    @Size(max=100,message="Created By can be 100 chars")
    private String created_by;
    @Size(max=100,message="Updated By can be 100 chars")
    private String updated_by;
    private Integer last_uploaded_date;
    private Integer created_date;
    private Integer updated_date;
    private String member_name;

    private Integer is_complete;

}