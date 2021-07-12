package com.cdfi.group.repository;


import com.cdfi.group.model.MemberPhoneNoDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface MemberPhoneNoDetailsRepository extends JpaRepository<MemberPhoneNoDetailsEntity, BigInteger> {

    @Query("FROM MemberPhoneNoDetailsEntity c WHERE c.memberCode = :memberCode and c.cboId = :cboId")
    MemberPhoneNoDetailsEntity findByMemberCodeCboId(@Param("memberCode") final BigInteger memberCode, @Param("cboId") final BigInteger cboId);

    @Query("FROM MemberPhoneNoDetailsEntity c WHERE c.cboId = :cboId and  c.memberCode = :memberCode")
    List<MemberPhoneNoDetailsEntity> findListByMemberCodeCboId(@Param("memberCode") final BigInteger memberCode, @Param("cboId") final BigInteger cboId);

    @Query("FROM MemberPhoneNoDetailsEntity c WHERE c.memberCode = :memberCode and c.cboId = :cboId")
    MemberPhoneNoDetailsEntity findByCboId(@Param("memberCode") final BigInteger memberCode, @Param("cboId") final BigInteger cboId);

    @Query("FROM MemberPhoneNoDetailsEntity c WHERE c.cboId = :cboId")
    List<MemberPhoneNoDetailsEntity> findListByCboId(@Param("cboId") final BigInteger cboId);

    @Query("FROM MemberPhoneNoDetailsEntity c WHERE c.cboId = :cboId AND c.isActive= :isActive")
    List<MemberPhoneNoDetailsEntity> fetchByCboId(@Param("cboId") final BigInteger cboId, @Param("isActive") final Boolean isActive);

    @Query("FROM MemberPhoneNoDetailsEntity c WHERE c.phoneGUID = :phoneGUID AND c.isActive= :isActive")
    MemberPhoneNoDetailsEntity fetchByGUID(@Param("phoneGUID") final String phoneGUID,@Param("isActive") final Boolean isActive);

    @Query(value = "SELECT c.cboId FROM MemberPhoneNoDetailsEntity c WHERE c.phoneNo = :phoneNo AND c.isActive= :isActive")
    List<Object[]> findShgIdByMobileNo(@Param("phoneNo") final BigInteger phoneNo,@Param("isActive") final Boolean isActive);

    @Query(value = "SELECT c.memberCode FROM MemberPhoneNoDetailsEntity c WHERE c.phoneNo = :phoneNo AND (:cboId = -1 OR c.cboId= :cboId) AND c.isActive= :isActive")
    List<Object[]> findMemberIdByMobileNo(@Param("phoneNo") final BigInteger phoneNo,@Param("cboId") final BigInteger cboId,@Param("isActive") final Boolean isActive);


    @Modifying
    @Transactional
    @Query("update MemberPhoneNoDetailsEntity u set u.activationStatus = :activationStatus where u.memberPhoneDetailsId =:memberPhoneDetailsId")
    void updateActivationStatusByMemberPhoneId(@Param("memberPhoneDetailsId") final BigInteger memberPhoneDetailsId,
                                    @Param("activationStatus") final Short activationStatus);



    @Query("FROM MemberPhoneNoDetailsEntity c WHERE c.memberCode = :memberCode and c.cboId = :cboId and c.isActive = :isActive")
    List<MemberPhoneNoDetailsEntity> findListByMemberCodeCboIdStatus(@Param("memberCode") final BigInteger memberCode,
                                                                     @Param("cboId") final BigInteger cboId,
                                                                     @Param("isActive") final Boolean isActive);


    @Query("FROM MemberPhoneNoDetailsEntity c WHERE (c.deduplSatus = :deduplicationStatus1 OR " +
            "c.deduplSatus = :deduplicationStatus2) AND c.memberCode = :id AND c.isActive= :isActive")
    List<MemberPhoneNoDetailsEntity> fetchByIdWithDedups(@Param("id") final BigInteger id,
                                                      @Param("deduplicationStatus1") final Short deDupStatus1,
                                                      @Param("deduplicationStatus2") final Short deDupStatus2,
                                                      @Param("isActive") final Boolean isActive);


    @Query("FROM MemberPhoneNoDetailsEntity c WHERE (c.deduplSatus = :deduplicationStatus1 OR c.deduplSatus = :deduplicationStatus2 OR "+
            "(c.deduplSatus = :deduplicationStatus3 AND c.activationStatus = :activationStatus))"
            +" AND c.memberCode = :id AND c.isActive= :isActive")
    List<MemberPhoneNoDetailsEntity> fetchByIdWithDedups2(@Param("id") final BigInteger id,
                                                      @Param("deduplicationStatus1") final Short deduplicationStatus1,
                                                      @Param("deduplicationStatus2") final Short deduplicationStatus2,
                                                      @Param("deduplicationStatus3") final Short deduplicationStatus3,
                                                      @Param("activationStatus") final Short activationStatus,
                                                      @Param("isActive") final Boolean isActive);


    @Modifying
    @Transactional
    @Query("update MemberPhoneNoDetailsEntity u set u.deduplSatus = :deduplSatus, u.activationStatus = :activationStatus where u.memberPhoneDetailsId =:memberPhoneDetailsId")
    void updateDDSById(@Param("memberPhoneDetailsId") final BigInteger memberPhoneDetailsId,
                       @Param("deduplSatus") final Short deduplSatus,
                       @Param("activationStatus") final Short activationStatus);

    @Query("FROM MemberPhoneNoDetailsEntity c WHERE c.deduplSatus = :deduplSatus " +
            "AND c.memberCode= :memberCode AND c.isActive= :isActive")
    List<MemberPhoneNoDetailsEntity> fetchMemberPhoneNoDetailsByDedupStatusAndMemberId
            (@Param("deduplSatus") final Short deduplSatus,
             @Param("memberCode") final BigInteger memberCode
                    ,@Param("isActive") final Boolean isActive);


    @Query("select case when count(c)>1 then true else false end from MemberPhoneNoDetailsEntity c" +
            "    where c.phoneNo= :phoneNo AND c.isActive= :isActive")
    Boolean existsByMobileNo(@Param("phoneNo") final
                             BigInteger phoneNo,@Param("isActive") final Boolean isActive);

    @Modifying
    @Transactional
    @Query("update MemberPhoneNoDetailsEntity u set u.deduplSatus = :deduplSatus where u.memberPhoneDetailsId =:memberPhoneDetailsId")
    void updateDedupStatusByMemberPhoneId(@Param("memberPhoneDetailsId") final BigInteger memberPhoneDetailsId,
                                          @Param("deduplSatus") final Short deduplSatus);



}
