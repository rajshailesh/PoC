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
@Table(name = "shg_member_designation")
public class SHGDesignationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_designation_id", nullable = false)
    private BigInteger member_designation_id;
    @Column(name = "cbo_guid", nullable = false)
    private String cbo_guid;
    @Column(name = "member_designation_guid", nullable = false)
    private String member_designation_guid;
    @Column(name = "cbo_code")
    private BigInteger cbo_code;
    @Column(name = "member_code")
    private BigInteger member_code;
    @Column(name = "member_guid")
    private String member_guid;
    @Column(name = "designation", nullable = false)
    private Short designation;
    @Column(name = "date_election")
    private Date dateElection;
    @Column(name = "from_date")
    private Date fromDate;
    @Column(name = "to_date")
    private Date toDate;
    @Column(name = "status")
    private Short status;
    @Column(name = "entry_source", nullable = false)
    private Short entry_source;
    @Column(name = "is_edited", nullable = false)
    private Integer is_edited;
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
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
    @Column(name = "is_signatory")
    private Short is_signatory;


}