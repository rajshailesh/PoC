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
    private BigInteger memberDesignationId;
    @Column(name = "cbo_guid", nullable = false)
    private String cboGUID;
    @Column(name = "member_designation_guid", nullable = false)
    private String memberDesignationGUID;
    @Column(name = "cbo_code")
    private BigInteger cboCode;
    @Column(name = "member_code")
    private BigInteger memberCode;
    @Column(name = "member_guid")
    private String memberGUID;
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
    private Short entrySource;
    @Column(name = "is_edited", nullable = false)
    private Integer isEdited;
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
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
    @Column(name = "is_signatory")
    private Short isSignatory;


}