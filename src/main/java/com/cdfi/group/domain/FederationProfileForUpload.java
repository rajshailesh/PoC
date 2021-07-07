package com.cdfi.group.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigInteger;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FederationProfileForUpload {
    private BigInteger federation_id;
    @NotNull(message = "State Must be given")
    private Integer state_id;
    @NotNull(message = "District must be given")
    private Integer district_id;
    @NotNull(message = "Block must be given")
    private Integer block_id;
    private Integer panchayat_id;
    private Integer village_id;
    @NotNull
    private Short cbo_type;
    @Size(max=50,message="GUID can be max of 50 chars long")
    private String guid;
    @NotBlank(message = "Federation Name must be given")
    @Size(max=200,message="Federation Name can be max of 200 chars long")
    private String federation_name;
    @NotNull(message = "Formation Date must be given")
    private Integer federation_formation_date;

    @NotBlank(message = "User id is not null or blank")
    @Size(max=100,message="User Id can be max of 100 chars long")
    private String user_id;
    @NotNull(message = "Set Entry Source ")
    private Short entry_source;

    private Short status;
    @NotBlank(message = "Set User Login Details")
    @Size(max=100,message="Created By can be max of 100 chars long")
    private String created_by;
    private Integer created_date;

}
