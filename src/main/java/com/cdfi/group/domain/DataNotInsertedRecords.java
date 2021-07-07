package com.cdfi.group.domain;

import lombok.Data;

import java.math.BigInteger;
@Data
public class DataNotInsertedRecords {
    private BigInteger id;
    private String guid;
    private String remarks;
    private String user_id;

}
