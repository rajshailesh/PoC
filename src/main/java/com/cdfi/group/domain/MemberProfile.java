package com.cdfi.group.domain;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.List;
@Data
public class MemberProfile {

    private BigInteger member_id;
    private BigInteger member_code;
    private BigInteger cbo_id;
    private String cbo_guid;
    private String member_guid;
    private Integer group_m_code;
    private Integer seq_no;
    private String member_name;
    private String member_name_local;
    private String father_husband;
    private String relation_name;
    private String relation_name_local;
    private Short gender;
    private Short marital_status;
    private Short religion;
    private Short social_category;
    private Short tribal_category;
    private Integer bpl;
    private String bpl_number;
    private Short pip_category;
    private Integer pip_date;
    private Short highest_education_level;
    private Short dob_available;
    private Integer dob;
    private Integer age;
    private Integer age_as_on;
    private Short minority;
    private  Short is_disabled;
    private  String disability_details;
    private  Short wellbeing_category;
    private  Short primary_occupation;
    private  Short secondary_occupation;
    private  Short tertiary_occupation;
    private Integer joining_date;
    private Integer leaving_date;
    private  Short reason_for_leaving;
    private  String if_minor_member_replaced;
    private  String guardian_name;
    private  String guardian_name_local;
    private  Short guardian_relation;
    private Integer designation;
    private Integer status;
    private Integer house_hold_code;
    private Short head_house_hold;
    private Integer insurance;
    private String marked_as_defaulter;
    private Integer marked_as_defaulter_date;
    private String record_modified;
    private Integer last_sync_date;
    private Short entry_source;
    private Integer is_edited;
    private Short is_active;
    private Short settlement_status;

    private Short mem_activation_status;
    private Short mem_dedup_status;

    private String uploaded_by;
    private Integer created_date;
    private Integer uploaded_date;
    private Integer updated_date;
    private String created_by;
    private String updated_by;
    private String shg_name;
    private String checker_remarks;
    private String member_image;
    private Short approve_status;
    private String member_document;

    private List<MemberAddresses> memberAddressesList;
    private List<MemberBank> memberBankList;
    private List<MemberKYCDetails> memberKYCDetailsList;
    private List<MemberPhoneNoDetails> memberPhoneNoDetailsList;
    private List<MemberSystemTags> memberSystemTagsList;

    private String view_status;
}
