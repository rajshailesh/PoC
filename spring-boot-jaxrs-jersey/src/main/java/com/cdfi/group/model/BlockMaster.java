package com.cdfi.group.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;


@Entity
@Table(name = "block_master")
public class BlockMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "block_id", nullable = false)
    private BigInteger blockId;
    @Column(name = "block_name_en")
    private String blockNameEnglish;
    @Column(name = "block_name_hi")
    private String blockNameHindi;
    @Column(name = "block_name_local")
    private String blockNameLocal;
    @Column(name = "block_code", nullable = false)
    private Integer blockCode;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "district_id", nullable = false)
    private DistrictMasterEntity districtMasterEntity;
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



    public BigInteger getBlockId() {
        return blockId;
    }

    public void setBlockId(final BigInteger blockId) {
        this.blockId = blockId;
    }


    public Integer getBlockCode() {
        return blockCode;
    }

    public void setBlockCode(final Integer blockCode) {
        this.blockCode = blockCode;
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

    public String getBlockNameEnglish() {
        return blockNameEnglish;
    }

    public void setBlockNameEnglish(String blockNameEnglish) {
        this.blockNameEnglish = blockNameEnglish;
    }

    public String getBlockNameHindi() {
        return blockNameHindi;
    }

    public void setBlockNameHindi(String blockNameHindi) {
        this.blockNameHindi = blockNameHindi;
    }

    public String getBlockNameLocal() {
        return blockNameLocal;
    }

    public void setBlockNameLocal(String blockNameLocal) {
        this.blockNameLocal = blockNameLocal;
    }

	public DistrictMasterEntity getDistrictMasterEntity() {
		return districtMasterEntity;
	}

	public void setDistrictMasterEntity(DistrictMasterEntity districtMasterEntity) {
		this.districtMasterEntity = districtMasterEntity;
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
