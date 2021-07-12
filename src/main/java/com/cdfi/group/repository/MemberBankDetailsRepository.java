package com.cdfi.group.repository;

import com.cdfi.group.model.MemberBankDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface MemberBankDetailsRepository extends JpaRepository<MemberBankDetailsEntity, BigInteger> {
   @Query("FROM MemberBankDetailsEntity c WHERE c.memberCode = :memberCode and c.cboId = :cboId")
   MemberBankDetailsEntity findByMemberCodeCboId(@Param("memberCode") final BigInteger memberCode, @Param("cboId") final BigInteger cboId);

  @Query("FROM MemberBankDetailsEntity c WHERE c.cboId = :cboId and c.memberCode = :memberCode")
    List<MemberBankDetailsEntity> findListByMemberCodeCboId(@Param("memberCode") final BigInteger memberCode,@Param("cboId") final BigInteger cboId);

    @Query("FROM MemberBankDetailsEntity c WHERE c.cboId = :cboId AND c.isActive= :isActive")
    List<MemberBankDetailsEntity> fetchByCboId(@Param("cboId") final BigInteger cboId,@Param("isActive") final Boolean isActive);


    @Query("FROM MemberBankDetailsEntity c WHERE c.bankGUID = :bankGUID AND c.isActive= :isActive")
    MemberBankDetailsEntity fetchByGUID(@Param("bankGUID") final String bankGUID,@Param("isActive") final Boolean isActive);

    @Modifying
    @Transactional
    @Query("update MemberBankDetailsEntity u set u.activationStatus = :activationStatus where u.memberBankDetailsId =:memberBankDetailsId")
    void updateActivationStatusByMemberBankId(@Param("memberBankDetailsId") final BigInteger memberBankDetailsId,
                                               @Param("activationStatus") final Short activationStatus);


  @Query("FROM MemberBankDetailsEntity c WHERE (c.deduplStatus = :deduplicationStatus1 OR " +
          "c.deduplStatus = :deduplicationStatus2) AND c.memberCode = :id AND c.isActive= :isActive")
  List<MemberBankDetailsEntity> fetchByIdWithDedups(@Param("id") final BigInteger id,
                                                   @Param("deduplicationStatus1") final Short deDupStatus1,
                                                   @Param("deduplicationStatus2") final Short deDupStatus2,
                                                   @Param("isActive") final Boolean isActive);


  @Query("FROM MemberBankDetailsEntity c WHERE (c.deduplStatus = :deduplicationStatus1 OR c.deduplStatus = :deduplicationStatus2 OR "+
          "(c.deduplStatus = :deduplicationStatus3 AND c.activationStatus = :activationStatus))"
          +" AND c.memberCode = :id AND c.isActive= :isActive")
  List<MemberBankDetailsEntity> fetchByIdWithDedups2(@Param("id") final BigInteger id,
                                                   @Param("deduplicationStatus1") final Short deduplicationStatus1,
                                                   @Param("deduplicationStatus2") final Short deduplicationStatus2,
                                                   @Param("deduplicationStatus3") final Short deduplicationStatus3,
                                                   @Param("activationStatus") final Short activationStatus,
                                                   @Param("isActive") final Boolean isActive);

  @Modifying
  @Transactional
  @Query("update MemberBankDetailsEntity u set u.deduplStatus = :deduplStatus, u.activationStatus = :activationStatus where u.memberBankDetailsId =:memberBankDetailsId")
  void updateDDSById(@Param("memberBankDetailsId") final BigInteger memberBankDetailsId,
                           @Param("deduplStatus") final Short deduplStatus,
                            @Param("activationStatus") final Short activationStatus);

  @Query("select case when count(c)> 0 then true else false end from MemberBankDetailsEntity c " +
          " where c.accountNo= :accountNo AND c.ifscCode= :ifscCode AND c.isActive= :isActive")
  Boolean existsByAccountNoAndIfscCode(@Param("accountNo") final
                                       String accountNo,@Param("ifscCode") final String ifscCode,
                                       @Param("isActive") final Boolean isActive);

  @Query("select case when count(c)> 1 then true else false end from MemberBankDetailsEntity c " +
          " where c.accountNo= :accountNo AND c.ifscCode= :ifscCode AND c.isActive= :isActive")
  Boolean existsByAccountNoAndIfscCodeSameTable(@Param("accountNo") final
                                                String accountNo,@Param("ifscCode") final String ifscCode,
                                                @Param("isActive") final Boolean isActive);

  @Query("FROM MemberBankDetailsEntity c WHERE c.deduplStatus = :deduplStatus AND c.memberCode= :memberCode " +
          "AND c.isActive= :isActive")
  List<MemberBankDetailsEntity> fetchCboBankDetailsByDedupStatusAndMemberIdAll(@Param("deduplStatus") final Short deduplStatus,
                                                                               @Param("memberCode") final BigInteger memberCode
          ,@Param("isActive") final Boolean isActive);

  @Modifying
  @Query("update MemberBankDetailsEntity u set u.deduplStatus = :deduplStatus where u.memberBankDetailsId =:memberBankDetailsId")
  void updateDedupStatusByMemberBankDetailsId(@Param("memberBankDetailsId") final BigInteger memberBankDetailsId,
                                              @Param("deduplStatus") final Short deduplStatus);

}
