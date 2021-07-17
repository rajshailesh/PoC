package com.cdfi.group.repository;

import com.cdfi.group.model.MemberKYCDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface MemberKYCDetailsRepository extends JpaRepository<MemberKYCDetailsEntity, BigInteger> {
    @Query("FROM MemberKYCDetailsEntity c WHERE c.cbo_id = :cboId and c.member_code = :memberCode")
    List<MemberKYCDetailsEntity> findByMemberCodeCboId(@Param("memberCode") final BigInteger memberCode, @Param("cboId") final BigInteger cboId);

}
