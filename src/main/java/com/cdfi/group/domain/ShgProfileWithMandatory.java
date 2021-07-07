package com.cdfi.group.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShgProfileWithMandatory {
    private BigInteger shg_id;
    private Integer state_id;
    private Integer district_id;
    private Integer block_id;
    private Integer panchayat_id;
    private Integer village_id;
    private String guid;
    private String shg_name;
    private Integer shg_formation_date;
    private String shg_code;
    private Short shg_type_code;

}
