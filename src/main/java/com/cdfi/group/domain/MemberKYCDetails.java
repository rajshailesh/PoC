package com.cdfi.group.domain;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.math.BigInteger;
@Data
public class MemberKYCDetails {
    private BigInteger member_kyc_details_id;
    private String kyc_guid;
    private String member_guid;
    private BigInteger member_code;
    private Integer kyc_type;
    private String kyc_number;
    private Integer document_id;
    private Integer kyc_valid_from;
    private Integer kyc_valid_to;
    private Short status;
    private Short entry_source;
    private Integer is_edited;
    private Short is_active;
    private String uploaded_by;
    private String created_by;
    private String updated_by;
    private BigInteger cbo_id;
    private Short dedupl_status;
    private Short activation_status;
    private Integer created_date;
    private Integer uploaded_date;
    private Integer updated_date;
    private DocumentDetails documentDetails;
    private String front_doc_original_name;
    private String rear_doc_original_name;
    private String kyc_front_document;
    private String kyc_rear_document;

 }
