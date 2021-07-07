
package com.cdfi.group.repository;

import com.cdfi.group.model.SystemTagsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;


@Repository
public interface SystemTagsRepository extends JpaRepository<SystemTagsEntity, BigInteger> {

    @Query("FROM SystemTagsEntity c WHERE c.systemTagGUID = :systemTagGUID AND c.isActive= :isActive")
    SystemTagsEntity fetchByGUID(@Param("systemTagGUID") final String systemTagGUID,
                                        @Param("isActive") final Boolean isActive);

    @Query("FROM SystemTagsEntity c WHERE c.cboCode = :cboCode AND c.isActive= :isActive")
    List<SystemTagsEntity> fetchByCboId(@Param("cboCode") final BigInteger cboCode,
                                        @Param("isActive") final Boolean isActive);



}