package com.cdfi.group.domain;
import lombok.Data;

import java.math.BigInteger;
@Data
public class MemberAddresses {


    private BigInteger member_address_id;
    private String address_guid;
    private String member_guid;
    private BigInteger member_code;
    private Short address_type;
    private String address_line1;
    private String address_line2;
    private Integer village_id;
    private Integer block_id;
    private Integer panchayat_id;
    private Integer landmark;
    private Integer state_id;
    private Integer district_id;
    private Integer postal_code;
    private Short status;
    private Short entry_source;
    private Integer is_edited;
    private Short is_active;
    private String created_by;
    private String updated_by;
    private BigInteger cbo_id;
    private Integer created_date;
    private Integer uploaded_date;
    private Integer updated_date;
    private Short address_location;
}
