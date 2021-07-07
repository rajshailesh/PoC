package com.cdfi.group.repository;

import com.cdfi.group.model.CboBankDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface CboBankDetailsRepository extends JpaRepository<CboBankDetailsEntity, BigInteger> {
    @Query("FROM CboBankDetailsEntity c WHERE c.cboId = :cboId AND c.isActive= :isActive AND c.cboType = :cboType")
    List<CboBankDetailsEntity> fetchByCboId(@Param("cboId") final BigInteger cboId,@Param("isActive") final Boolean isActive
            ,@Param("cboType") final Short cboType);

    @Query("FROM CboBankDetailsEntity c WHERE c.bankGuid = :bankGuid AND c.isActive= :isActive " +
            "AND c.cboType = :cboType")
    CboBankDetailsEntity fetchByGUID(@Param("bankGuid") final String bankGuid,
                                     @Param("isActive") final Boolean isActive
            ,@Param("cboType") final Short cboType);

    @Modifying
    @Query("update CboBankDetailsEntity u set u.isActive = :status where u.cboBankId= :cboBankId")
    void deactivateCboBankDetails(@Param("status") final Boolean status,
                                  @Param("cboBankId") final BigInteger cboBankId);

    @Modifying
    @Query("update CboBankDetailsEntity u set u.deduplicationStatus = :deduplicationStatus where u.cboBankId =:cboBankId")
    void updateDedupStatusByCboBankDetailsId(@Param("cboBankId") final BigInteger cboBankId,@Param("deduplicationStatus") final Short deduplStatus);

    @Modifying
    @Query("update CboBankDetailsEntity u set u.activationStatus = :activationStatus where u.cboBankId =:cboBankId")
    void updateActivationByCboBankDetailsId(@Param("cboBankId") final BigInteger cboBankId,
                                             @Param("activationStatus") final Short activationStatus);

    @Query("FROM CboBankDetailsEntity c WHERE c.deduplicationStatus = :deduplicationStatus AND " +
            "c.isActive= :isActive AND c.cboType= :cboType")
    List<CboBankDetailsEntity> fetchCboBankDetailsByDedupStatus(@Param("deduplicationStatus") final Short deDupStatus
            ,@Param("isActive") final Boolean isActive,@Param("cboType") final Short cboType);

    @Query("FROM CboBankDetailsEntity c WHERE c.deduplicationStatus = :deduplicationStatus AND c.cboId= :cboId " +
            "AND c.isActive= :isActive AND c.cboType= :cboType")
    List<CboBankDetailsEntity> fetchCboBankDetailsByDedupStatusAndCboId(@Param("deduplicationStatus") final Short deDupStatus,
                                                                              @Param("cboId") final BigInteger cboId
            ,@Param("isActive") final Boolean isActive,@Param("cboType") final Short cboType);


    @Query("FROM CboBankDetailsEntity c WHERE c.activationStatus = :activationStatus AND c.isActive= :isActive " +
            "AND c.cboType= :cboType")
    List<CboBankDetailsEntity> fetchCboBankDetailsByActivationStatus(@Param("activationStatus") final
                                                                           Short activationStatus,
                                                                     @Param("isActive") final Boolean isActive
            ,@Param("cboType") final Short cboType);


    @Query("FROM CboBankDetailsEntity c WHERE c.activationStatus = :activationStatus AND c.cboId= :cboId " +
            "AND c.isActive= :isActive AND c.cboType= :cboType")
    List<CboBankDetailsEntity> fetchCboBankDetailsByActivationStatusAndCboId(@Param("activationStatus") final Short activationStatus,
                                                                                   @Param("cboId") final BigInteger cboId
            ,@Param("isActive") final Boolean isActive,@Param("cboType") final Short cboType);

    @Query("select case when count(c)> 1 then true else false end from CboBankDetailsEntity c\n" +
            "    where c.accountNo= :accountNo AND c.ifscCode= :ifscCode AND c.isActive= :isActive")
    Boolean existsByAccountNoAndIfscCode(@Param("accountNo") final
                                         String accountNo,@Param("ifscCode") final String ifscCode,
                                         @Param("isActive") final Boolean isActive);

    @Query("select case when count(c)> 0 then true else false end from CboBankDetailsEntity c" +
            "    where c.accountNo= :accountNo AND c.ifscCode= :ifscCode AND c.isActive= :isActive")
    Boolean existsByAccountNoAndIfscCodeMember(@Param("accountNo") final
                                               String accountNo,@Param("ifscCode") final String ifscCode,
                                               @Param("isActive") final Boolean isActive);

    @Query("FROM CboBankDetailsEntity c WHERE c.deduplicationStatus = :deduplicationStatus AND c.cboId= :cboId " +
            "AND c.isActive= :isActive")
    List<CboBankDetailsEntity> fetchCboBankDetailsByDedupStatusAndCboIdAll(@Param("deduplicationStatus") final Short deDupStatus,
                                                                           @Param("cboId") final BigInteger cboId
            ,@Param("isActive") final Boolean isActive);


    @Modifying
    @Transactional
    @Query("update CboBankDetailsEntity u set u.deduplicationStatus = :deduplicationStatus,  u.activationStatus = :activationStatus where u.cboBankId =:cboBankId")
    void updateDDSById(@Param("cboBankId") final BigInteger cboBankId,
                       @Param("deduplicationStatus") final Short deduplicationStatus,
                       @Param("activationStatus") final Short activationStatus);

}
