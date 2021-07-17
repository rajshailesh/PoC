package com.cdfi.group.domain;

import com.cdfi.group.util.DateUtils;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class SHGProfileMM {

    private BigInteger shg_id;
    private Integer state_id;
    private Integer district_id;
    private Integer block_id;
    private Integer panchayat_id;
    private Integer village_id;
    private String hamlet_id;
    private String guid;
    private String shg_code;
    private String shg_name;
    private Short composition;
    private Short shg_type_code;
    private String language_id;
    private String shg_name_local;
    private String shg_name_short_en;
    private String shg_name_short_local;
    private Integer shg_formation_date;
    private Integer shg_revival_date;
    private Integer shg_promoted_by;
    private Integer shg_revived_by;
    private Short meeting_frequency;
    private Short meeting_frequency_value;
    private Short meeting_on;
    private Short mode;
    private Integer month_comp_saving;
    private Double panelty_non_saving;
    private Double interloaning_rate;
    private Double savings_interest;
    private Double voluntary_savings_interest;
    private Short is_bankaccount;
    private Integer funding_agency_id;
    private BigInteger parent_cbo_code;
    private Short parent_cbo_type;
    private Short is_active;
    private Short dedupl_status;
    private Short activation_status;
    private Short entry_source;
    private Integer mobile_default_user;
    private Integer web_default_checker;
    private Integer is_edited;
    private Short account_books_maintained;
    private Short cash_book_start_date;
    private Short bank_book_start_date;
    private Short members_ledger_start_date;
    private Short book4;
    private Short book5;
    private String grade;
    private Integer grading_done_on;
    private String grade_confirmation_status;
    private Integer last_uploaded_date;
    private String uploaded_by;
    private Integer created_date;
    private String created_by;
    private Integer updated_date;
    private String updated_by;
    private Double latitude;
    private Double longitude;
    private Short bookkeeper_identified;
    private Short micro_plan_prepared;
    private String user_id;
    private Integer basic_shg_training;
    private Integer primary_activity;
    private Integer secondary_activity;
    private Integer tertiary_activity;
    private String promoter_name;
    private Short saving_frequency;
    private Double volutary_saving;
    private Short cbo_level;
    private Short geographic_level;
    private Short settlement_status;
    private String bookkeeper_name;
    private String bookkeeper_mobile;
    private Integer election_tenure;
    private Short is_voluntary_saving;
    private Short status;
    private String checker_remark;
    private List<CBOAddresses> cboAddressesList;
    private List<CBOPhoneNoDetails> cboPhoneNoDetailsList;
    private List<CBOBankDetails> cboBankDetailsList;
    private CboKYCDetails cboKYCDetails;
    private List<MemberProfile> memberProfileList;

    private List<SystemTags> cboSystemTagsList;

    private List<SHGDesignation> shgDesignationList;

    private Integer shg_cooption_date;
    private Short tags;

    //FEDERATION
    private BigInteger federation_code;
    private String federation_name;
    private String federation_name_local;
    private Short child_level;

    private Long member_count;
    private Long dedup_member_count;
    private Long active_member_count;
    private String transaction_id;

    private Short approve_status;

    public static String exceptionString;

    private String view_status;

    private Integer mapped_date;
    private Integer unmapped_date;
    private Integer federation_joining_date;
    private String shg_resolution;
    private String shg_resolution_document;


    private String shg_type_other;
    private String promoter_code;
    private Integer is_verified;
    private Integer is_complete;

    public void setGradingDoneOn(Timestamp dateTime){
        try {
            this.grading_done_on = DateUtils.timeStampToSecondsConverter(dateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void setCreatedDate(Timestamp dateTime){
        try {
            this.created_date = DateUtils.timeStampToSecondsConverter(dateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public void setLastUploadedDate(Timestamp dateTime){
        try {
            this.last_uploaded_date = DateUtils.timeStampToSecondsConverter(dateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public void setShgFormationDate(Date dateTime){
        try {
            this.shg_formation_date = DateUtils.dateToSecondsConverter(dateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public void setShgRevivalDate(Date dateTime){
        try {
            this.shg_revival_date = DateUtils.dateToSecondsConverter(dateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
