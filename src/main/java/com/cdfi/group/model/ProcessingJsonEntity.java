package com.cdfi.group.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Table(name = "processing_json")
@Data
public class ProcessingJsonEntity {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private BigInteger id;
    @Column(name = "json")
    private String json;
    @Column(name = "files")
    private String files;
    @Column(name = "parameter")
    private String parameter;
    @Column(name = "start_time")
    // Not using @Convert as in existing implementation, considering that we don't time zone wise
    private LocalDateTime startTime;
    @Column(name = "end_time")
    private LocalDateTime endTime;
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @Column(name = "flag")
    private Short flag;
    @Column(name = "cbo_type")
    private Short cboType;
    @Column(name = "transaction_id")
    private String transactionId  ;

    public static Short noReadFlag=1;
    public static Short processingFlag=2;
    public static Short executedFlag=3;

    /*public BigInteger getId() {
        return id;
    }

    public void setId(final BigInteger id) {
        this.id = id;
    }

    public String getJson() {
        return json;
    }

    public void setJson(final String json) {
        this.json = json;
    }

    public String getFiles() {
        return files;
    }

    public void setFiles(final String files) {
        this.files = files;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(final String parameter) {
        this.parameter = parameter;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(final LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(final LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(final LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Short getFlag() {
        return flag;
    }

    public void setFlag(final Short flag) {
        this.flag = flag;
    }

    public Short getCboType() {
        return cboType;
    }

    public void setCboType(final Short cboType) {
        this.cboType = cboType;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(final String transactionId) {
        this.transactionId = transactionId;
    }*/
}
