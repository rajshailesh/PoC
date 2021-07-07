package com.cdfi.group.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
    @Column(name = "remarks")
    private String remarks;

    public static Short pending=1;
    public static Short success=2;
    public static Short failure=3;

}
