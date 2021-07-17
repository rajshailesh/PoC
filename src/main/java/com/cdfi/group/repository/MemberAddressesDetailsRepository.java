package com.cdfi.group.repository;


import com.cdfi.group.model.MemberAddressesDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;


@Repository
public interface MemberAddressesDetailsRepository extends JpaRepository<MemberAddressesDetailsEntity, BigInteger> {
    @Query("FROM MemberAddressesDetailsEntity c WHERE c.member_code = :memberCode and c.cbo_id = :cboId")
    MemberAddressesDetailsEntity findByMemberCodeCboId(@Param("cboId") final BigInteger cboId, @Param("memberCode") final BigInteger memberCode);

    @Query("FROM MemberAddressesDetailsEntity c WHERE c.cbo_id = :cboId and c.member_code = :memberCode")
    List<MemberAddressesDetailsEntity> findListByMemberCodeCboId(@Param("cboId") final BigInteger cboId,@Param("memberCode") final BigInteger memberCode);

    @Query("FROM MemberAddressesDetailsEntity c WHERE c.cbo_id = :cboId AND c.is_active= :isActive")
    List<MemberAddressesDetailsEntity> fetchByCboId(@Param("cboId") final BigInteger cboId,@Param("isActive") final Boolean isActive);

    @Query("FROM MemberAddressesDetailsEntity c WHERE c.address_guid = :addressGUID AND c.is_active= :isActive")
    MemberAddressesDetailsEntity fetchByGUID(@Param("addressGUID") final String addressGUID,@Param("isActive") final Boolean isActive);


}
