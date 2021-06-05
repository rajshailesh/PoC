package com.cdfi.group.model;



import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;


@Entity
@Table(name = "district_master")
public class DistrictMasterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "district_id", nullable = false)
    private BigInteger districtId;
    @Column(name = "district_name_en")
    private String districtNameEnglish;
    @Column(name = "district_name_hi")
    private String districtNameHindi;
    @Column(name = "district_name_local")
    private String districtNameLocal;
    @Column(name = "district_code", nullable = false)
    private Integer districtCode;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "state_id", nullable = false)
    private StateMasterEntity stateMasterEntity;
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


    public BigInteger getDistrictId() {
        return districtId;
    }

    public void setDistrictId(final BigInteger districtId) {
        this.districtId = districtId;
    }

    public Integer getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(final Integer districtCode) {
        this.districtCode = districtCode;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(final Boolean active) {
        isActive = active;
    }


    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(final Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(final Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getDistrictNameEnglish() {
        return districtNameEnglish;
    }

    public void setDistrictNameEnglish(String districtNameEnglish) {
        this.districtNameEnglish = districtNameEnglish;
    }

    public String getDistrictNameHindi() {
        return districtNameHindi;
    }

    public void setDistrictNameHindi(String districtNameHindi) {
        this.districtNameHindi = districtNameHindi;
    }

    public String getDistrictNameLocal() {
        return districtNameLocal;
    }

    public void setDistrictNameLocal(String districtNameLocal) {
        this.districtNameLocal = districtNameLocal;
    }

	public StateMasterEntity getStateMasterEntity() {
		return stateMasterEntity;
	}

	public void setStateMasterEntity(StateMasterEntity stateMasterEntity) {
		this.stateMasterEntity = stateMasterEntity;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}
    
    
}
