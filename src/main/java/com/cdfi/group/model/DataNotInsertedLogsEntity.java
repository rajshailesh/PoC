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
@Table(name = "data_not_inserted_logs")
public class DataNotInsertedLogsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private BigInteger id;
    @Column(name = "guid")
    private String guid;
    @Column(name = "remarks")
    private String remarks;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "read_flag")
    private Boolean readFlag;


}
