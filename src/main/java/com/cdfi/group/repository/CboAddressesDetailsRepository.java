package com.cdfi.group.repository;


import com.cdfi.group.model.CboAddressesDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;


@Repository
public interface CboAddressesDetailsRepository extends JpaRepository<CboAddressesDetailsEntity, BigInteger> {

    @Query("FROM CboAddressesDetailsEntity c WHERE c.cboId = :cboId AND c.isActive= :isActive AND c.cboType= :cboType")
    List<CboAddressesDetailsEntity> fetchByCboId(@Param("cboId") final BigInteger cboId,
                                                 @Param("isActive") final Boolean isActive,
                                                 @Param("cboType") final Short cboType);

    @Query("FROM CboAddressesDetailsEntity c WHERE c.addressGuid = :addressGuid AND c.isActive= :isActive AND c.cboType= :cboType")
    CboAddressesDetailsEntity fetchByGUID(@Param("addressGuid") final String addressGuid,
                                          @Param("isActive") final Boolean isActive,
                                          @Param("cboType") final Short cboType);

    @Modifying
    @Query("update CboAddressesDetailsEntity u set u.isActive = :status where u.cboAddressId= :cboAddressId")
    void deactivateCboAddressesDetails(@Param("status") final Boolean status,@Param("cboAddressId") final BigInteger cboAddressId);

}
