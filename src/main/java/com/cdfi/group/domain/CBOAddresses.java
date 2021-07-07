package com.cdfi.group.domain;

import lombok.Data;

import java.math.BigInteger;
@Data
public class CBOAddresses {
    private  BigInteger cbo_address_id;
    private BigInteger cbo_id;
    private Short cbo_type;
    private String address_guid;
    private String cbo_guid;
    private Short address_type;
    private String urban_rural;
    private String address_line1;
    private String address_line2;
    private String city_town;
    private String postal_code;
    private String landmark;
    private Integer state_id;
    private Integer district_id;
    private Integer block_id;
    private Integer panchayat_id;
    private Integer village_id;
    private Short status;
    private Short deduplication_status;
    private Short activation_status;
    private Short entry_source;
    private Integer is_edited;
    private Integer last_uploaded_date;
    private String uploaded_by;
    private Integer created_date;
    private String created_by;
    private Integer updated_date;
    private String updated_by;
    private Short is_active;
    private Integer is_verified;
    private Integer is_complete;

}
