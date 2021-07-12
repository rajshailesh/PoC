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
@Table(name = "member_phone_details")
public class MemberPhoneNoDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_phone_details_id", nullable = false)
    private BigInteger member_phone_details_id;
    @Column(name = "phone_guid", nullable = false)
    private String phone_guid;
    @Column(name = "member_guid")
    private String member_guid;
    @Column(name = "member_code")
    private BigInteger member_code;
    @Column(name = "phone_no", nullable = false)
    private BigInteger phone_no;
    @Column(name = "is_default", nullable = false)
    private Short is_default;
    @Column(name = "phone_ownership", nullable = false)
    private Short phone_ownership;
    @Column(name = "phone_ownership_details")
    private String phone_ownership_details;
    @Column(name = "valid_from", nullable = false)
    private Date valid_from;
    @Column(name = "valid_till")
    private Date valid_till;
    @Column(name = "entry_source", nullable = false)
    private Short entry_source;
    @Column(name = "is_edited", nullable = false)
    private Integer is_edited;
    @Column(name = "is_active", nullable = false)
    private Boolean is_active;
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
    @Column(name = "activation_status")
    private Short activation_status;
    @Column(name = "dedupl_status")
    private Short dedupl_status;
    @Column(name = "cbo_id")
    private BigInteger cbo_id;

    @Column(name = "is_verified")
    private Integer is_verified;

    @Column(name = "is_complete")
    private Integer is_complete;

}
