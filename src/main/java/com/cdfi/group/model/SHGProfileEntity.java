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
@Table(name = "shg_profile")
public class SHGProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shg_id", nullable = false)
    private BigInteger shgId;
    @Column(name = "state_id", nullable = false)
    private Integer stateId;
    @Column(name = "district_id", nullable = false)
    private Integer districtId;
    @Column(name = "block_id", nullable = false)
    private Integer blockId;
    @Column(name = "village_id", nullable = false)
    private Integer villageId;
    @Column(name = "panchayat_id", nullable = false)
    private Integer panchayatId;
    @Column(name = "hamlet_id")
    private String hamletId;
    @Column(name = "guid", nullable = false)
    private String guid;
    @Column(name = "shg_code")
    private String shgCode;
    @Column(name = "shg_name", nullable = false)
    private String shgName;
    @Column(name = "composition")
    private Short composition;
    @Column(name = "shg_type_code", nullable = false)
    private Short shgTypeCode;
    @Column(name = "shg_name_local")
    private String shgNameLocal;
    @Column(name = "shg_name_short_en")
    private String shgNameShortEN ;
    @Column(name = "shg_name_short_local ")
    private String shgNameShortLocal;
    @Column(name = "shg_formation_date", nullable = false)
    private Date shgFormationDate;
    @Column(name = "shg_revival_date")
    private Date shgRevivalDate;

    @Column(name = "shg_promoted_by", nullable = false)
    private Integer shgPromotedBy;
    @Column(name = " shg_revived_by")
    private Integer shgRevivedBy;
    @Column(name = "meeting_frequency", nullable = false)
    private Short meetingFrequency;
    @Column(name = "meeting_frequency_value")
    private Short meetingFrequencyValue;
    @Column(name = "meeting_on")
    private Short meetingOn;
    @Column(name = "mode", nullable = false)
    private Short mode;
    @Column(name = "month_comp_saving", nullable = false)
    private Integer monthCompSaving;
    @Column(name = "panelty_non_saving")
    private Double paneltyNonSaving ;
    @Column(name = "interloaning_rate", nullable = false)
    private Double interloaningRate ;
    @Column(name = "savings_interest", nullable = false)
    private Double savingsInterest  ;
    @Column(name = "voluntary_savings_interest", nullable = false)
    private Double voluntarySavingsInterest;
    @Column(name = "is_bankaccount")
    private Boolean isBankAccount;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "funding_agency_id")
    private FundingAgencyMasterEntity fundingAgencyMasterEntity;
    @Column(name = "parent_cbo_code")
    private BigInteger parentCboId;
    @Column(name = "parent_cbo_type")
    private Short parentCboType;
    @Column(name = "dedupl_status")
    private Short deduplicationStatus;
    @Column(name = "activation_status")
    private Short activationStatus;
    @Column(name = "mobile_default_user")
    private Integer mobileDefaultUser;
    @Column(name = "web_default_checker")
    private Integer webDefaultChecker;
    @Column(name = "account_books_maintained")
    private Boolean accountBooksMaintained;
    @Column(name = "cash_book_start_date")
    private Boolean cashBookStartDate;
    @Column(name = "bank_book_start_date")
    private Boolean bankBookStartDate;
    @Column(name = "members_ledger_start_date")
    private Boolean membersLedgerStartDate;
    @Column(name = "book4")
    private Boolean book4;
    @Column(name = "book5")
    private Boolean book5;
    @Column(name = "grade")
    private String grade;
    @Column(name = "grading_done_on")
    private LocalDateTime gradingDoneOn;
    @Column(name = "grade_confirmation_status")
    private String gradeConfirmationStatus;
    @Column(name = "latitude")
    private Double latitude  ;
    @Column(name = "longitude")
    private Double longitude  ;
    @Column(name = "bookkeeper_identified")
    private Short bookkeeperIdentified;
    @Column(name = "micro_plan_prepared")
    private Boolean microPlanPrepared;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "read_flag")
    private Boolean readFlag;
    @Column(name = "basic_shg_training")
    private Boolean basicShgTraining;
    @Column(name = "primary_activity")
    private Integer primaryActivity;
    @Column(name = "secondary_activity")
    private Integer secondaryActivity;
    @Column(name = "tertiary_activity")
    private Integer tertiaryActivity;
    @Column(name = "promoter_name")
    private String promoterName;
    @Column(name = "saving_frequency")
    private Short savingFrequency;
    @Column(name = "volutary_saving")
    private Double volutarySaving;
    @Column(name = "cbo_level")
    private Short cboLevel;
    @Column(name = "geographic_level")
    private Short geographicLevel;
    @Column(name = "settlement_status")
    private Short settlementStatus;
    @Column(name = "bookkeeper_name")
    private String bookkeeperName;
    @Column(name = "bookkeeper_mobile")
    private String bookkeeperMobile;
    @Column(name = "election_tenure")
    private Integer electionTenure;
    @Column(name = "is_voluntary_saving")
    private Short isVoluntarySaving;
    @Column(name = "status")
    private Short status;
    @Column(name = "checker_remark")
    private String checkerRemark;
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
    @Column(name = "entry_source", nullable = false)
    private Short entrySource;
    @Column(name = "is_edited")
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

    @Column(name = "shg_cooption_date")
    private Date shgCooptionDate;
    @Column(name = "tags")
    private Short tags;
    @Column(name = "approve_status")
    private Short approveStatus;
    @Column(name = "profile_document_id")
    private BigInteger profileDocumentId;
    @Column(name = "shg_resolution")
    private String shgResolution;

    @Column(name = "shg_type_other")
    private  String shgTypeOther;
    @Column(name = "promoter_code")
    private  String promoterCode;

    @Column(name = "is_verified")
    private Integer isVerified;

    @Column(name = "is_complete")
    private Integer isComplete;

}
