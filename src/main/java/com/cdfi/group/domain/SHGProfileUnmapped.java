package com.cdfi.group.domain;

import lombok.Data;

import java.math.BigInteger;

@Data
public class SHGProfileUnmapped {

    private BigInteger shg_id;
    private String shg_name;
    private String panchayat_id;
    private String village_id;
    private String user_id;


}
