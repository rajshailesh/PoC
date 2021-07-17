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
@SecondaryTable(name = "federation_profile", pkJoinColumns = @PrimaryKeyJoinColumn(name = "parent_cbo_code"))
public class SHGProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shg_id", nullable = false)
    private BigInteger shg_id;
    @Column(name = "state_id", nullable = false)
    private Integer state_id;
    @Column(name = "district_id", nullable = false)
    private Integer district_id;
    @Column(name = "block_id", nullable = false)
    private Integer block_id;
    @Column(name = "village_id", nullable = false)
    private Integer village_id;
    @Column(name = "panchayat_id", nullable = false)
    private Integer panchayat_id;
    @Column(name = "hamlet_id")
    private String hamlet_id;
    @Column(name = "guid", nullable = false)
    private String guid;
    @Column(name = "shg_code")
    private String shg_code;
    @Column(name = "shg_name", nullable = false)
    private String shg_name;
    @Column(name = "composition")
    private Short composition;
    @Column(name = "shg_type_code", nullable = false)
    private Short shg_type_code;
    @Column(name = "shg_name_local")
    private String shg_name_local;
    @Column(name = "shg_name_short_en")
    private String shg_name_short_en ;
    @Column(name = "shg_name_short_local ")
    private String shg_name_short_local;
    @Column(name = "shg_formation_date", nullable = false)
    private java.util.Date shgFormationDate;
    @Column(name = "shg_revival_date")
    private java.util.Date shgRevivalDate;

    @Column(name = "shg_promoted_by", nullable = false)
    private Integer shg_promoted_by;
    @Column(name = " shg_revived_by")
    private Integer shg_revived_by;
    @Column(name = "meeting_frequency", nullable = false)
    private Short meeting_frequency;
    @Column(name = "meeting_frequency_value")
    private Short meeting_frequency_value;
    @Column(name = "meeting_on")
    private Short meeting_on;
    @Column(name = "mode", nullable = false)
    private Short mode;
    @Column(name = "month_comp_saving", nullable = false)
    private Integer month_comp_saving;
    @Column(name = "panelty_non_saving")
    private Double panelty_non_saving ;
    @Column(name = "interloaning_rate", nullable = false)
    private Double interloaning_rate ;
    @Column(name = "savings_interest", nullable = false)
    private Double savings_interest  ;
    @Column(name = "voluntary_savings_interest", nullable = false)
    private Double voluntary_savings_interest;
    @Column(name = "is_bankaccount")
    private Boolean is_bankaccount;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "funding_agency_id")
    private FundingAgencyMasterEntity fundingAgencyMasterEntity;
    @Column(name = "parent_cbo_code")
    private BigInteger parent_cbo_code;
    @Column(name = "parent_cbo_type")
    private Short parent_cbo_type;
    @Column(name = "dedupl_status")
    private Short dedupl_status;
    @Column(name = "activation_status")
    private Short activation_status;
    @Column(name = "mobile_default_user")
    private Integer mobile_default_user;
    @Column(name = "web_default_checker")
    private Integer web_default_checker;
    @Column(name = "account_books_maintained")
    private Boolean accountBooksMaintained;
    @Column(name = "cash_book_start_date")
    private Boolean cashBookStartDate;
    @Column(name = "bank_book_start_date")
    private Boolean bankBookStartDate;
    @Column(name = "members_ledger_start_date")
    private Boolean membersLedgerStartDate;
    @Column(name = "book4")
    private Boolean book_4;
    @Column(name = "book5")
    private Boolean book_5;
    @Column(name = "grade")
    private String grade;
    @Column(name = "grading_done_on")
    private LocalDateTime gradingDoneOn;
    @Column(name = "grade_confirmation_status")
    private String grade_confirmation_status;
    @Column(name = "latitude")
    private Double latitude  ;
    @Column(name = "longitude")
    private Double longitude  ;
    @Column(name = "bookkeeper_identified")
    private Short bookkeeper_identified;
    @Column(name = "micro_plan_prepared")
    private Boolean microPlanPrepared;
    @Column(name = "user_id")
    private String user_id;
    @Column(name = "read_flag")
    private Boolean read_flag;
    @Column(name = "basic_shg_training")
    private Boolean basicShgTraining;
    @Column(name = "primary_activity")
    private Integer primary_activity;
    @Column(name = "secondary_activity")
    private Integer secondary_activity;
    @Column(name = "tertiary_activity")
    private Integer tertiary_activity;
    @Column(name = "promoter_name")
    private String promoter_name;
    @Column(name = "saving_frequency")
    private Short saving_frequency;
    @Column(name = "volutary_saving")
    private Double volutary_saving;
    @Column(name = "cbo_level")
    private Short cbo_level;
    @Column(name = "geographic_level")
    private Short geographic_level;
    @Column(name = "settlement_status")
    private Short settlement_status;
    @Column(name = "bookkeeper_name")
    private String bookkeeper_name;
    @Column(name = "bookkeeper_mobile")
    private String bookkeeper_mobile;
    @Column(name = "election_tenure")
    private Integer election_tenure;
    @Column(name = "is_voluntary_saving")
    private Short is_voluntary_saving;
    @Column(name = "status")
    private Short status;
    @Column(name = "checker_remark")
    private String checker_remark;
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
    @Column(name = "entry_source", nullable = false)
    private Short entry_source;
    @Column(name = "is_edited")
    private Integer isEdited;
    @Column(name = "last_uploaded_date")
    private LocalDateTime lastUploadedDate;
    @Column(name = "uploaded_by")
    private String uploaded_by;
    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;
    @Column(name = "created_by", nullable = false)
    private String created_by;
    @Column(name = "updated_date")
    private LocalDateTime updatedDate;
    @Column(name = "updated_by")
    private String updated_by;

    @Column(name = "shg_cooption_date")
    private Date shgCooptionDate;
    @Column(name = "tags")
    private Short tags;
    @Column(name = "approve_status")
    private Short approveStatus;
    @Column(name = "profile_document_id")
    private BigInteger profile_document_id;
    @Column(name = "shg_resolution")
    private String shg_resolution;

    @Column(name = "shg_type_other")
    private  String shg_type_other;
    @Column(name = "promoter_code")
    private  String promoter_code;

    @Column(name = "is_verified")
    private Integer is_verified;

    @Column(name = "is_complete")
    private Integer is_complete;

}
