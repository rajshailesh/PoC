package com.cdfi.group.domain;


import lombok.Data;

import java.math.BigInteger;

@Data
public class CboKYCDetails {

    private BigInteger cbo_kyc_details_id;
    private String cbo_guid;
    private String kyc_guid;
    private BigInteger cbo_id;
    private Integer kyc_type;
    private String kyc_number;
    private BigInteger document_id;
    private Integer kyc_valid_from;
    private Integer kyc_valid_to;
    private DocumentDetails documentDetails;
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
    private Short cbo_type;
    private String kyc_document;
    private Integer is_verified;
    private Integer is_complete;

}
