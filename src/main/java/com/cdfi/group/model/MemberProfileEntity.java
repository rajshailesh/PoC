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
    private BigInteger memberId;
    @Column(name = "member_code")
    private BigInteger memberCode;
    /*code add by mohit kumar start*/
    @Column(name = "cbo_id" , nullable = false)
    private BigInteger cboId;
    @Column(name = "cbo_GUID", nullable = false)
    private String cboGUID;
    @Column(name = "member_GUID")
    private String memberGUID;
    @Column(name = "group_m_code")
    private Integer groupMCode;
    @Column(name = "seq_no")
    private Integer seqNo;
    @Column(name = "member_name" , nullable = false)
    private String memberName;
    @Column(name = "member_name_local")
    private String memberNameLocal;
    @Column(name = "father_husband" , nullable = false)
    private String fatherHusband;
    @Column(name = "relation_name" , nullable = false)
    private String relationName;
    @Column(name = "relation_name_local")
    private String relationNameLocal;
    @Column(name = "gender", nullable = false)
    private Short gender;
    @Column(name = "marital_status", nullable = false)
    private Short maritalStatus;
    @Column(name = "religion")
    private Short religion;
    @Column(name = "social_category")
    private Short socialCategory;
    @Column(name = "tribal_category")
    private Short tribalCategory;
    @Column(name = "bpl", nullable = false)
    private Integer bpl;
    @Column(name = "bpl_number")
    private String bplNumber;
    @Column(name = "pip_category")
    private Short pipCategory;
    @Column(name = "pip_Date")
    //@Convert(converter = LocalDateTimeConverter.class)
    private Date pipDate;
    @Column(name = "highest_education_level")
    private Short highestEducationLevel;
    @Column(name = "dob_available", nullable = false)
    private Short dobAvailable;
    @Column(name = "dob")
    //@Convert(converter = LocalDateTimeConverter.class)
    private Date dob;
    @Column(name = "age")
    private Integer age;
    @Column(name = "age_as_on", nullable = false)
    //@Convert(converter = LocalDateTimeConverter.class)
    private Date ageAsOn;
    @Column(name = "minority")
    private Short minority;
    @Column(name = "is_disabled", nullable = false)
    private  Short isDisabled;
    @Column(name = "disability_details")
    private  String disabilityDetails;
    @Column(name = "wellbeing_category")
    private  Short wellbeingCategory;
    @Column(name = "primary_occupation")
    private  Short primaryOccupation;
    @Column(name = "secondary_occupation")
    private  Short secondaryOccupation;
    @Column(name = "tertiary_occupation")
    private  Short tertiaryOccupation;
    @Column(name = "joining_date", nullable = false)
    private Date joiningDate;
    @Column(name = "leaving_date")
    private Date leavingDate;
    @Column(name = "reason_for_leaving")
    private  Short reasonForLeaving;
    @Column(name = "if_minor_member_replaced")
    private  String ifMinorMemberReplaced;
    @Column(name = "guardian_name")
    private  String guardianName;
    @Column(name = "guardian_name_local")
    private  String guardianNameLocal;
    @Column(name = "guardian_relation")
    private  Short guardianRelation;
    @Column(name = "designation", nullable = false)
    private Integer designation;
    @Column(name = "status", nullable = false)
    private Integer status;
    @Column(name = "house_hold_code")
    private Integer houseHoldCode;
    @Column(name = "head_house_hold", nullable = false)
    private Short headHouseHold;
    @Column(name = "insurance", nullable = false)
    private Integer insurance;
    @Column(name = "marked_as_defaulter")
    private String markedAsDefaulter;
    @Column(name = "marked_as_defaulter_date")
    //@Convert(converter = LocalDateTimeConverter.class)
    private Date markedAsDefaulterDate;
    @Column(name = "record_modified")
    private String recordModified;
    @Column(name = "last_sync_date")
    private LocalDateTime lastSyncDate;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
    @Column(name = "mem_activation_status")
    private Short memActivationStatus;
    @Column(name = "mem_dedup_status")
    private Short memDedupStatus;
    @Column(name = "entry_source")
    private Short entrySource;
    @Column(name = "settlement_status")
    private Short settlementStatus;
    @Column(name = "read_flag")
    private Boolean readFlag;
    @Column(name = "checker_remark")
    private String checkerRemark;
    @Column(name = "is_edited", nullable = false)
    private Integer isEdited;
    @Column(name = "last_uploaded_date")
    private LocalDateTime lastUploadedDate;
    @Column(name = "uploaded_by")
    private String uploadedBy;
    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;
    @Column(name = "created_by", nullable = false)
    private String createdBy;
    @Column(name = "updated_date")
    private LocalDateTime updatedDate;
    @Column(name = "updated_by")
    private String updatedBy;
    @Column(name = "member_image")
    private String memberImage;

    @Column(name = "member_profile_document_id")
    private BigInteger memberProfileDocumentId;

    @Column(name = "approve_status")
    private Short approveStatus;

    @Column(name = "is_verified")
    private Integer isVerified;

    @Column(name = "is_complete")
    private Integer isComplete;


    public static Integer stateType = 1;
    public static Integer districtType = 2;
    public static Integer blockType = 3;
    public static Integer panchayatType = 4;
    public static Integer villageType = 5;
    public static Integer groupCodeType = 6;
    public static Integer groupNameType = 7;
    public static Integer memberCodeType = 8;
    public static Integer memberNameType = 9;
    public static Integer phoneNoType = 10;

}

