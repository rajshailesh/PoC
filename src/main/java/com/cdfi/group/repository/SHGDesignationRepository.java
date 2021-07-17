package com.cdfi.group.repository;

import com.cdfi.group.model.SHGDesignationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;


@Repository
public interface SHGDesignationRepository extends JpaRepository<SHGDesignationEntity, BigInteger> {

    @Query("FROM SHGDesignationEntity c WHERE c.cbo_guid = :cboGUID")
    SHGDesignationEntity fetchByCboGUID(@Param("cboGUID") final String cboGUID);

    @Query("FROM SHGDesignationEntity c WHERE c.member_designation_guid = :memberDesignationGUID AND c.isActive= :isActive")
    SHGDesignationEntity fetchByGUID(@Param("memberDesignationGUID") final String memberDesignationGUID,
                                 @Param("isActive") final Boolean isActive);


    @Query("FROM SHGDesignationEntity c WHERE c.cbo_code = :cboCode AND c.isActive= :isActive")
    List<SHGDesignationEntity> fetchByCboId(@Param("cboCode") final BigInteger cboCode,
                                        @Param("isActive") final Boolean isActive);
}
