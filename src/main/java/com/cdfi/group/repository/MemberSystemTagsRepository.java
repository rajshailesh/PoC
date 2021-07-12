
package com.cdfi.group.repository;

import com.cdfi.group.model.MemberSystemTagsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;


@Repository
public interface MemberSystemTagsRepository extends JpaRepository<MemberSystemTagsEntity, BigInteger> {
    @Query("FROM MemberSystemTagsEntity c WHERE c.memberCode = :memberCode and c.cboId = :cboId")
    MemberSystemTagsEntity findByMemberCodeCboId(@Param("memberCode") final BigInteger memberCode, @Param("cboId") final BigInteger cboId);

    @Query("FROM MemberSystemTagsEntity c WHERE c.cboId = :cboId and  c.memberCode = :memberCode")
    List<MemberSystemTagsEntity> findListByMemberCodeCboId(@Param("memberCode") final BigInteger memberCode, @Param("cboId") final BigInteger cboId);

    @Query("FROM MemberSystemTagsEntity c WHERE c.cboId = :cboId AND c.isActive= :isActive")
    List<MemberSystemTagsEntity> fetchByCboId(@Param("cboId") final BigInteger cboId, @Param("isActive") final Boolean isActive);

    @Query("FROM MemberSystemTagsEntity c WHERE c.systemTagGUID = :systemTagGUID AND c.isActive= :isActive")
    MemberSystemTagsEntity fetchByGUID(@Param("systemTagGUID") final String systemTagGUID, @Param("isActive") final Boolean isActive);

}