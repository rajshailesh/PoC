package com.cdfi.group.repository;


import com.cdfi.group.model.CboPhoneNoDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface CboPhoneNoDetailsRepository extends JpaRepository<CboPhoneNoDetailsEntity, BigInteger> {

    @Query("FROM CboPhoneNoDetailsEntity c WHERE c.cboId = :cboId AND c.isActive= :isActive AND c.cboType= :cboType")
    List<CboPhoneNoDetailsEntity> fetchByCboId(@Param("cboId") final BigInteger cboId,@Param("isActive") final Boolean isActive,
                                               @Param("cboType") final Short cboType);

    @Query("FROM CboPhoneNoDetailsEntity c WHERE c.phoneGuid = :phoneGuid AND c.isActive= :isActive AND c.cboType= :cboType")
    CboPhoneNoDetailsEntity fetchByGUID(@Param("phoneGuid") final String phoneGuid,
                                        @Param("isActive") final Boolean isActive,
                                        @Param("cboType") final Short cboType);

    @Modifying
    @Query("update CboPhoneNoDetailsEntity u set u.isActive = :status where u.cboPhoneId= :cboPhoneId")
    void deactivateCboPhoNoDetails(@Param("status") final Boolean status,
                                   @Param("cboPhoneId") final BigInteger cboPhoneId);

    @Modifying
    @Query("update CboPhoneNoDetailsEntity u set u.deduplicationStatus = :deduplicationStatus where u.cboPhoneId =:cboPhoneId")
    void updateDedupStatusByCboPhoneDetailsId(@Param("cboPhoneId") final BigInteger cboPhoneId,@Param("deduplicationStatus") final Short deduplStatus);

    @Modifying
    @Query("update CboPhoneNoDetailsEntity u set u.activationStatus = :activationStatus where u.cboPhoneId =:cboPhoneId")
    void updateActivationByCboPhoneDetailsId(@Param("cboPhoneId") final BigInteger cboPhoneId,
                                 @Param("activationStatus") final Short activationStatus);

    @Query("FROM CboPhoneNoDetailsEntity c WHERE c.deduplicationStatus = :deduplicationStatus AND c.isActive= :isActive AND c.cboType= :cboType")
    List<CboPhoneNoDetailsEntity> fetchCboPhoneNoDetailsByDedupStatus
            (@Param("deduplicationStatus") final Short deDupStatus,@Param("isActive") final Boolean isActive,
             @Param("cboType") final Short cboType);

    @Query("FROM CboPhoneNoDetailsEntity c WHERE c.deduplicationStatus = :deduplicationStatus " +
            "AND c.cboId= :cboId AND c.isActive= :isActive AND c.cboType= :cboType")
    List<CboPhoneNoDetailsEntity> fetchCboPhoneNoDetailsByDedupStatusAndCboId
            (@Param("deduplicationStatus") final Short deDupStatus,
                                                                      @Param("cboId") final BigInteger cboId
                                                                    ,@Param("isActive") final Boolean isActive,
             @Param("cboType") final Short cboType);


    @Query("FROM CboPhoneNoDetailsEntity c WHERE c.activationStatus = :activationStatus AND c.isActive= :isActive " +
            "AND c.cboType= :cboType")
    List<CboPhoneNoDetailsEntity> fetchCboPhoneNoDetailsByActivationStatus(@Param("activationStatus") final
                                                             Short activationStatus,
                                                              @Param("isActive") final Boolean isActive,
                                                                           @Param("cboType") final Short cboType);


    @Query("FROM CboPhoneNoDetailsEntity c WHERE c.activationStatus = :activationStatus AND c.cboId= :cboId " +
            "AND c.isActive= :isActive AND c.cboType= :cboType")
    List<CboPhoneNoDetailsEntity> fetchCboPhoneNoDetailsByActivationStatusAndCboId(@Param("activationStatus") final Short activationStatus,
                                                                              @Param("cboId") final BigInteger cboId
            ,@Param("isActive") final Boolean isActive,@Param("cboType") final Short cboType);

    @Query("select case when count(c)>1 then true else false end from CboPhoneNoDetailsEntity c\n" +
            "    where c.mobileNo= :mobileNo AND c.isActive= :isActive AND c.cboType= :cboType")
    Boolean existsByMobileNo(@Param("mobileNo") final
                             BigInteger mobileNo,@Param("isActive") final Boolean isActive,@Param("cboType") final Short cboType);


    @Modifying
    @Transactional
    @Query("update CboPhoneNoDetailsEntity u set u.deduplicationStatus = :deduplicationStatus,  u.activationStatus = :activationStatus where u.cboPhoneId =:cboPhoneId")
    void updateDDSById(@Param("cboPhoneId") final BigInteger cboPhoneId,
                       @Param("deduplicationStatus") final Short deduplicationStatus,
                       @Param("activationStatus") final Short activationStatus);

}
