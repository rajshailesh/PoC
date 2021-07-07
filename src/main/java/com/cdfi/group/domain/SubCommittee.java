package com.cdfi.group.domain;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.math.BigInteger;
import java.util.List;

public class SubCommittee {
    private BigInteger subcommitee_id;
    private BigInteger cbo_id;
    private BigInteger cbo_code;
    @Size(max=50,message="Cbo guid can be max of 50 char long")
    private String cbo_guid;
    @Size(max=50,message="Subcommittee guid can be max of 50 char long")
    private String subcommitee_guid;
    private BigInteger subcommitee_code;
    private BigInteger subcommitee_type_id;
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
    private @Valid
    List<SubCommitteeMember> subCommitteeMemberList;
    private String subcommitee_name;

    private Integer is_complete;


}