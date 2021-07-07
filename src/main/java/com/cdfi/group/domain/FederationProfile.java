package com.cdfi.group.domain;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigInteger;
import java.util.List;

@Data
public class FederationProfile {
    private BigInteger federation_id;
    private BigInteger federation_code;
    private BigInteger temp_code;
    @NotNull(message = "State Must be given")
    private Integer state_id;
    @NotNull(message = "District must be given")
    private Integer district_id;
    @NotNull(message = "Block must be given")
    private Integer block_id;
    //@NotNull(message = "Panchayat must be given")
    private Integer panchayat_id;
    //@NotNull(message = "Village must be given")
    private Integer village_id;
    @NotNull
    private Short cbo_type;
    @Size(max = 50, message = "GUID can be max of 50 chars long")
    private String guid;
    private Short federation_type_code;
    @NotBlank(message = "Federation Name must be given")
    @Size(max = 200, message = "Federation Name can be max of 200 chars long")
    private String federation_name;
    private Short cbo_level;
    private Short child_level;
    private Short geographic_level;
    @Size(max = 20, message = "Federation Name Short EN can be max of 20 chars long")
    private String federation_name_short_en;
    @Size(max = 120, message = "Federation Name Local can be max of 120 chars long")
    private String federation_name_local;
    @Size(max = 40, message = "Federation Name Short Local can be max of 40 chars long")
    private String federation_name_short_local;
    @NotNull(message = "Formation Date must be given")
    private Integer federation_formation_date;
    private Integer federation_revival_date;
    @NotNull(message = "please select meeting frequency")

    private Short meeting_frequency;
    private Short meeting_frequency_value;
    private Short meeting_on;
    @NotNull(message = "Select mode")
    private Short mode;
    @NotNull(message = "Monthly Compulsory Savings must be given")
    private Integer month_comp_saving;
    private Integer is_bankaccount;
    private BigInteger parent_cbo_code;
    private Short parent_cbo_type;
    private Short is_active;
    private Short dedupl_status;
    private Short activation_status;

    private Short status;
    private Short settlement_status;
    @Size(max = 250, message = "Checker Remark can be max of 250 chars long")
    private String checker_remark;
    @Size(max = 60, message = "Bookkeeper Name can be max of 60 chars long")
    private String bookkeeper_name;
    private String bookkeeper_mobile;
    private Integer election_tenure;
    private Short is_voluntary_saving;

    private Short saving_frequency;

    private Integer promoted_by;

    private Integer primary_activity;

    private Integer secondary_activity;

    private Integer tertiary_activity;

    private Short bookkeeper_identified;
    @NotBlank(message = "User id is not null or blank")
    @Size(max = 100, message = "User Id can be max of 100 chars long")
    private String user_id;
    @NotNull(message = "Set Entry Source ")
    private Short entry_source;
    @NotNull(message = "Set Is Edited")
    private Integer is_edited;
    private Integer last_uploaded_date;
    @Size(max = 100, message = "Uploaded By can be max of 100 chars long")
    private String uploaded_by;
    private Integer created_date;
    @NotBlank(message = "Set User Login Details")
    @Size(max = 100, message = "Created By can be max of 100 chars long")
    private String created_by;
    private Integer updated_date;
    @Size(max = 100, message = "Updated By can be max of 100 chars long")
    private String updated_by;
    @Size(max = 5, message = "Promoter Code can be max of 5 chars long")
    private String promoter_code;
    //@satwant06052021
    private Integer is_complete;

    //@NotEmpty(message = "Address should be specified")
    private @Valid
    List<CBOAddresses> cboAddressesList;
    //@NotEmpty(message = "Phone Details should be specified")
    private @Valid
    List<CBOPhoneNoDetails> cboPhoneNoDetailsList;
    //@NotEmpty(message = "Bank Details should be specified")
    private @Valid
    List<CBOBankDetails> cboBankDetailsList;
    private @Valid
    List<CboKYCDetails> cboKYCDetailsList;
    private List<ECMember> ecMembersList;
    private List<SubCommittee> subCommitteeList;

    public static String exceptionStringFederation;

    private Integer cooption_date;
    @Size(max = 100, message = "Federation Name Hindi can be max of 100 chars long")
    private String federation_name_hindi;
    @Size(max = 100, message = "Federation Name Short can be max of 100 chars long")
    private String federation_name_short;

    private Short is_financial_intermediation;

    private Short is_volutary_saving;
    private Short meber_cbo_count;
    private Double savings_interest;
    private Double voluntary_savings_interest;
    private Short approve_status;

    private Long ec_member_count;
    private Long sc_count;
    @Size(max = 50, message = "Promoter Name can be max of 50 chars long")
    private String promoter_name;
    private String federation_resolution;


    private String view_status;
    private String federation_resolution_document;
    private String transaction_id;

    private String parent_cbo_name;

    private Long cbo_mapping_count;


}
