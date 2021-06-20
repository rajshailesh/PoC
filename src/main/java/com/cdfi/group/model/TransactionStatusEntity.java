package com.cdfi.group.model;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "transaction_status")
public class TransactionStatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private BigInteger id;
    @Column(name = "transaction_id")
    private String transactionId;
    @Column(name = "status")
    private Short status;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "read_flag")
    private Boolean readFlag;

    public static Short pending=1;
    public static Short success=2;
    public static Short failure=3;

    public BigInteger getId() {
        return id;
    }

    public void setId(final BigInteger id) {
        this.id = id;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(final String transactionId) {
        this.transactionId = transactionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public Boolean getReadFlag() {
        return readFlag;
    }

    public void setReadFlag(final Boolean readFlag) {
        this.readFlag = readFlag;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(final Short status) {
        this.status = status;
    }
}
