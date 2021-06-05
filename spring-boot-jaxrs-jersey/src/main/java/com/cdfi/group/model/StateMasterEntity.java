package com.cdfi.group.model;

import java.math.BigInteger;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "state_master")
public class StateMasterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "state_id", nullable = false)
    private BigInteger stateId;
    @Column(name = "state_name_en", nullable = false)
    private String stateNameEnglish;
    @Column(name = "state_name_hi", nullable = false)
    private String stateNameHindi;
    @Column(name = "state_name_local", nullable = false)
    private String stateNameLocal;
    @Column(name = "state_code", nullable = false)
    private Integer stateCode;
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
    @Column(name = "created_date", nullable = false)
    private Timestamp createdDate;
    @Column(name = "created_by", nullable = false)
    private Integer createdBy;
    @Column(name = "updated_date")
    private Timestamp updatedDate;
    @Column(name = "updated_by")
    private Integer updatedBy;


    public BigInteger getStateId() {
        return stateId;
    }

    public void setStateId(final BigInteger stateId) {
        this.stateId = stateId;
    }

    public Integer getStateCode() {
        return stateCode;
    }

    public void setStateCode(final Integer stateCode) {
        this.stateCode = stateCode;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(final Boolean active) {
        isActive = active;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(final Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(final Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(final Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(final Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getStateNameEnglish() {
        return stateNameEnglish;
    }

    public void setStateNameEnglish(String stateNameEnglish) {
        this.stateNameEnglish = stateNameEnglish;
    }

    public String getStateNameHindi() {
        return stateNameHindi;
    }

    public void setStateNameHindi(String stateNameHindi) {
        this.stateNameHindi = stateNameHindi;
    }

    public String getStateNameLocal() {
        return stateNameLocal;
    }

    public void setStateNameLocal(String stateNameLocal) {
        this.stateNameLocal = stateNameLocal;
    }

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
    
}
