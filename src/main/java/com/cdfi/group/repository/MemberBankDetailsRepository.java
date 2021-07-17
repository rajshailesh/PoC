package com.cdfi.group.repository;

import com.cdfi.group.model.MemberBankDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface MemberBankDetailsRepository extends JpaRepository<MemberBankDetailsEntity, BigInteger> {
    @Query("FROM MemberBankDetailsEntity c WHERE c.cbo_id = :cboId and c.member_code = :memberCode")
    List<MemberBankDetailsEntity> findListByMemberCodeCboId(@Param("memberCode") final BigInteger memberCode,@Param("cboId") final BigInteger cboId);
}
