package com.cdfi.group.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "member_profile")
public class MemberProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id", nullable = false)
    private BigInteger member_id;
    @Column(name = "member_code")
    private BigInteger member_code;
    @Column(name = "cbo_id" , nullable = false)
    private BigInteger cbo_id;
    @Column(name = "cbo_GUID", nullable = false)
    private String cbo_GUID;
    @Column(name = "member_GUID")
    private String member_GUID;
    @Column(name = "group_m_code")
    private Integer group_m_code;
    @Column(name = "seq_no")
    private Integer seq_no;
    @Column(name = "member_name" , nullable = false)
    private String member_name;
    @Column(name = "member_name_local")
    private String member_name_local;
    @Column(name = "father_husband" , nullable = false)
    private String father_husband;
    @Column(name = "relation_name" , nullable = false)
    private String relation_name;
    @Column(name = "relation_name_local")
    private String relation_name_local;
    @Column(name = "gender", nullable = false)
    private Short gender;
    @Column(name = "marital_status", nullable = false)
    private Short marital_status;
    @Column(name = "religion")
    private Short religion;
    @Column(name = "social_category")
    private Short social_category;
    @Column(name = "tribal_category")
    private Short tribal_category;
    @Column(name = "bpl", nullable = false)
    private Integer bpl;
    @Column(name = "bpl_number")
    private String bpl_number;
    @Column(name = "pip_category")
    private Short pip_category;
    @Column(name = "pip_Date")
    private Date pip_Date;
    @Column(name = "highest_education_level")
    private Short highest_education_level;
    @Column(name = "dob_available", nullable = false)
    private Short dob_available;
    @Column(name = "dob")
    private Date dob;
    @Column(name = "age")
    private Integer age;
    @Column(name = "age_as_on", nullable = false)
    private Date age_as_on;
    @Column(name = "minority")
    private Short minority;
    @Column(name = "is_disabled", nullable = false)
    private  Short is_disabled;
    @Column(name = "disability_details")
    private  String disability_details;
    @Column(name = "wellbeing_category")
    private  Short wellbeing_category;
    @Column(name = "primary_occupation")
    private  Short primary_occupation;
    @Column(name = "secondary_occupation")
    private  Short secondary_occupation;
    @Column(name = "tertiary_occupation")
    private  Short tertiary_occupation;
    @Column(name = "joining_date", nullable = false)
    private Date joining_date;
    @Column(name = "leaving_date")
    private Date leaving_date;
    @Column(name = "reason_for_leaving")
    private  Short reason_for_leaving;
    @Column(name = "if_minor_member_replaced")
    private  String if_minor_member_replaced;
    @Column(name = "guardian_name")
    private  String guardian_name;
    @Column(name = "guardian_name_local")
    private  String guardian_name_local;
    @Column(name = "guardian_relation")
    private  Short guardian_relation;
    @Column(name = "designation", nullable = false)
    private Integer designation;
    @Column(name = "status", nullable = false)
    private Integer status;
    @Column(name = "house_hold_code")
    private Integer house_hold_code;
    @Column(name = "head_house_hold", nullable = false)
    private Short head_house_hold;
    @Column(name = "insurance", nullable = false)
    private Integer insurance;
    @Column(name = "marked_as_defaulter")
    private String marked_as_defaulter;
    @Column(name = "marked_as_defaulter_date")
    private Date marked_as_defaulter_date;
    @Column(name = "record_modified")
    private String record_modified;
    @Column(name = "last_sync_date")
    private LocalDateTime last_sync_date;

    @Column(name = "is_active", nullable = false)
    private Boolean is_active;
    @Column(name = "mem_activation_status")
    private Short mem_activation_status;
    @Column(name = "mem_dedup_status")
    private Short mem_dedup_status;
    @Column(name = "entry_source")
    private Short entry_source;
    @Column(name = "settlement_status")
    private Short settlement_status;
    @Column(name = "read_flag")
    private Boolean read_flag;
    @Column(name = "checker_remark")
    private String checker_remark;
    @Column(name = "is_edited", nullable = false)
    private Integer is_edited;
    @Column(name = "last_uploaded_date")
    private LocalDateTime last_uploaded_date;
    @Column(name = "uploaded_by")
    private String uploaded_by;
    @Column(name = "created_date", nullable = false)
    private LocalDateTime created_date;
    @Column(name = "created_by", nullable = false)
    private String created_by;
    @Column(name = "updated_date")
    private LocalDateTime updated_date;
    @Column(name = "updated_by")
    private String updated_by;
    @Column(name = "member_image")
    private String member_image;

    @Column(name = "member_profile_document_id")
    private BigInteger member_profile_document_id;

    @Column(name = "approve_status")
    private Short approve_status;

    @Column(name = "is_verified")
    private Integer is_verified;

    @Column(name = "is_complete")
    private Integer is_complete;

}

