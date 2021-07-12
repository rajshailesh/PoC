package com.cdfi.group.repository;

import com.cdfi.group.model.MemberKYCDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface MemberKYCDetailsRepository extends JpaRepository<MemberKYCDetailsEntity, BigInteger> {
    @Query("FROM MemberKYCDetailsEntity c WHERE c.cboId = :cboId and c.memberCode = :memberCode")
    List<MemberKYCDetailsEntity> findByMemberCodeCboId(@Param("memberCode") final BigInteger memberCode, @Param("cboId") final BigInteger cboId);

    @Query("FROM MemberKYCDetailsEntity c WHERE c.cboId = :cboId AND c.isActive= :isActive")
    List<MemberKYCDetailsEntity> fetchByCboId(@Param("cboId") final BigInteger cboId, @Param("isActive") final Boolean isActive);

    @Query("FROM MemberKYCDetailsEntity c WHERE c.kycGUID = :kycGUID AND c.isActive= :isActive")
    MemberKYCDetailsEntity fetchByGUID(@Param("kycGUID") final String kycGUID,@Param("isActive") final Boolean isActive);


    @Query("FROM MemberKYCDetailsEntity c WHERE (c.deduplStatus = :deduplicationStatus1 OR " +
            "c.deduplStatus = :deduplicationStatus2) AND c.memberCode = :id AND c.isActive= :isActive")
    List<MemberKYCDetailsEntity> fetchByIdWithDedups(@Param("id") final BigInteger id,
                                                      @Param("deduplicationStatus1") final Short deDupStatus1,
                                                      @Param("deduplicationStatus2") final Short deDupStatus2,
                                                      @Param("isActive") final Boolean isActive);

    @Query("FROM MemberKYCDetailsEntity c WHERE (c.deduplStatus = :deduplicationStatus1 OR c.deduplStatus = :deduplicationStatus2 OR "+
            "(c.deduplStatus = :deduplicationStatus3 AND c.activationStatus = :activationStatus))"
            +" AND c.memberCode = :id AND c.isActive= :isActive")
    List<MemberKYCDetailsEntity> fetchByIdWithDedups2(@Param("id") final BigInteger id,
                                                       @Param("deduplicationStatus1") final Short deduplicationStatus1,
                                                       @Param("deduplicationStatus2") final Short deduplicationStatus2,
                                                       @Param("deduplicationStatus3") final Short deduplicationStatus3,
                                                       @Param("activationStatus") final Short activationStatus,
                                                       @Param("isActive") final Boolean isActive);


    @Modifying
    @Transactional
    @Query("update MemberKYCDetailsEntity u set u.deduplStatus = :deduplStatus,  u.activationStatus = :activationStatus where u.memberKycDetailsId =:memberKycDetailsId")
    void updateDDSById(@Param("memberKycDetailsId") final BigInteger memberKycDetailsId,
                       @Param("deduplStatus") final Short deduplStatus,
                       @Param("activationStatus") final Short activationStatus);

    @Query("FROM MemberKYCDetailsEntity c WHERE c.deduplStatus = :deduplStatus AND c.memberCode= :memberCode " +
            "AND c.isActive= :isActive")
    List<MemberKYCDetailsEntity> fetchMemberKYCDetailsByDedupStatusAndMemberIdAll(@Param("deduplStatus") final Short deduplStatus,
                                                                                 @Param("memberCode") final BigInteger memberCode
            ,@Param("isActive") final Boolean isActive);

    @Query("select case when count(c)>1 then true else false end from MemberKYCDetailsEntity c" +
            "    where c.kycNumber= :kycNumber AND c.isActive= :isActive")
    Boolean existsByKYCNo(@Param("kycNumber") final
                             String kycNumber,@Param("isActive") final Boolean isActive);

    @Modifying
    @Transactional
    @Query("update MemberKYCDetailsEntity u set u.deduplStatus = :deduplStatus where u.memberKycDetailsId =:memberKycDetailsId")
    void updateDedupStatusByMemberKYCId(@Param("memberKycDetailsId") final BigInteger memberKycDetailsId,
                                          @Param("deduplStatus") final Short deduplStatus);


}
