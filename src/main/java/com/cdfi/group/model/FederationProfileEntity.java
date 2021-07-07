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
@Table(name = "federation_profile")
public class
FederationProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "federation_id", nullable = false)
    private BigInteger federationId;
    @Column(name = "state_id", nullable = false)
    private Integer stateId;
    @Column(name = "district_id", nullable = false)
    private Integer districtId;
    @Column(name = "block_id", nullable = false)
    private Integer blockId;
    @Column(name = "panchayat_id", nullable = false)
    private Integer panchayatId;
    @Column(name = "village_id", nullable = false)
    private Integer villageId;
    @Column(name = "federation_code")
    private BigInteger federation_code;
    @Column(name = "temp_code")
    private BigInteger temp_code;
    @Column(name = "guid")
    private String guid;
    @Column(name = "federation_name", nullable = false)
    private String federationName;
    @Column(name = "federation_type_code")
    private Short federationTypeCode;
    @Column(name = "cbo_type")
    private Short cboType;
    @Column(name = "cbo_level")
    private Short cboLevel;
    @Column(name = "child_level")
    private Short childLevel;
    @Column(name = "geographic_level")
    private Short geographicLevel;
    @Column(name = "federation_name_short_en")
    private String federationNameShortEN;
    @Column(name = "federation_name_local")
    private String federationNameLocal;
    @Column(name = "federation_name_short_local")
    private String federationNameShortLocal;
    @Column(name = "federation_formation_date")
    private Date federationFormationDate;
    @Column(name = "federation_revival_date")
    private Date federationRevivalDate;
    @Column(name = "meeting_frequency")
    private Short meetingFrequency;
    @Column(name = "meeting_frequency_value")
    private Short meetingFrequencyValue;
    @Column(name = "meeting_on")
    private Short meetingOn;
    @Column(name = "mode")
    private Short mode;
    @Column(name = "month_comp_saving")
    private Integer monthCompSaving;
    @Column(name = "is_bankaccount")
    private Boolean isBankAccount;
    @Column(name = "parent_cbo_code")
    private BigInteger parentCboId;
    @Column(name = "parent_cbo_type")
    private Short parentCboType;
    @Column(name = "dedupl_status")
    private Short deduplicationStatus;
    @Column(name = "activation_status")
    private Short activationStatus;
    @Column(name = "status")
    private Short status;
    @Column(name = "settlement_status")
    private Short settlementStatus;
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "checker_remark")
    private String checkerRemark;
    @Column(name = "promoted_by")
    private Integer promotedBy;
    @Column(name = "savings_frequency")
    private Short savingFrequency;
    @Column(name = "is_voluntary_saving")
    private Short isVoluntarySaving;
    @Column(name = "savings_interest")
    private Double savingsInterest;
    @Column(name = "voluntary_savings_interest")
    private Double voluntarySavingsInterest;
    @Column(name = "primary_activity")
    private Integer primaryActivity;
    @Column(name = "secondary_activity")
    private Integer secondaryActivity;
    @Column(name = "tertiary_activity")
    private Integer tertiaryActivity;
    @Column(name = "bookkeeper_name")
    private String bookkeeperName;
    @Column(name = "bookkeeper_mobile")
    private String bookkeeperMobile;
    @Column(name = "bookkeeper_identified")
    private Short bookkeeperIdentified;
    @Column(name = "election_tenure")
    private Integer electionTenure;
    @Column(name = "entry_source", nullable = false)
    private Short entrySource;
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

    @Column(name = "cooption_date")
    private Date cooptionDate;
    @Column(name = "federation_name_hindi")
    private String federationNameHindi;
    @Column(name = "federation_name_short")
    private String federationNameShort;
    @Column(name = "is_financial_intermediation")
    private Boolean isFinancialIntermediation;
    @Column(name = "is_volutary_saving")
    private Boolean isVolutarySaving;
    @Column(name = "meber_cbo_count")
    private Short meberCboCount;
    @Column(name = "approve_status")
    private Short approveStatus;
    @Column(name = "read_flag")
    private Boolean readFlag;
    @Column(name = "promoter_name")
    private String promoterName;
    @Column(name = "promoter_code")
    private String promoterCode;

    @Column(name = "federation_profile_doc_id")
    private BigInteger federationProfileDocId;
    @Column(name = "federation_resolution")
    private String federationResolution;
    @Column(name = "is_complete")
    private Integer isComplete;

}
