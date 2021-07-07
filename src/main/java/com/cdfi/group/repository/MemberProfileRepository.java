package com.cdfi.group.repository;

import com.cdfi.group.model.MemberProfileEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;
import java.util.Set;

@Repository
public interface MemberProfileRepository extends JpaRepository<MemberProfileEntity, BigInteger> {

    @Query("FROM MemberProfileEntity c WHERE c.memberCode = :memberCode and c.cboGUID = :cboGUID")
    MemberProfileEntity findByMemberCode(@Param("memberCode") final BigInteger memberCode, @Param("cboGUID") final String cboGUID);

    @Query("FROM MemberProfileEntity c WHERE c.groupMCode = :groupMCode")
    List<MemberProfileEntity> findByGroupCode(@Param("groupMCode") final Integer groupMCode);

    @Query("FROM MemberProfileEntity c WHERE c.cboGUID = :cboGUID")
    List<MemberProfileEntity> findByGroupName(@Param("cboGUID") final Integer cboGUID);

    @Query("FROM MemberProfileEntity c WHERE c.memberCode = :memberCode")
    List<MemberProfileEntity> findByMemberCodes(@Param("memberCode") final Integer memberCode);

    @Query("FROM MemberProfileEntity c WHERE c.memberName = :memberName")
    List<MemberProfileEntity> findByMemberName(@Param("memberName") final Integer memberName);

    @Query("FROM MemberProfileEntity c WHERE c.cboId = :cboId")
    List<MemberProfileEntity> findByCboId(@Param("cboId") final BigInteger cboId);

    @Query("FROM MemberProfileEntity c WHERE c.cboId = :cboId AND c.isActive= :isActive")
    List<MemberProfileEntity> fetchByCboId(@Param("cboId") final BigInteger cboId,@Param("isActive") final Boolean isActive);

    @Query("FROM MemberProfileEntity c WHERE (c.memDedupStatus = :deduplicationStatus1 OR c.memDedupStatus = :deduplicationStatus2 OR "+
            "(c.memDedupStatus = :deduplicationStatus3 AND c.memActivationStatus = :memActivationStatus))"
            +" AND c.cboId = :cboId AND c.isActive= :isActive")
    List<MemberProfileEntity> fetchByCboIdWithDedups(@Param("cboId") final BigInteger cboId,
                                                     @Param("deduplicationStatus1") final Short deduplicationStatus1,
                                                     @Param("deduplicationStatus2") final Short deduplicationStatus2,
                                                     @Param("deduplicationStatus3") final Short deduplicationStatus3,
                                                     @Param("memActivationStatus") final Short memActivationStatus,
                                                     @Param("isActive") final Boolean isActive);

@Query("FROM MemberProfileEntity c WHERE c.approveStatus = :approveStatus " +
        "AND c.memDedupStatus != :memDedupStatus"
            +" AND c.cboId = :cboId AND c.isActive= :isActive")
    Page<MemberProfileEntity> fetchByCboIdApproveStatus(@Param("cboId") final BigInteger cboId,
                                                     @Param("approveStatus") final Short approveStatus,
                                                     @Param("memDedupStatus") final Short memDedupStatus,
                                                     @Param("isActive") final Boolean isActive,
                                                        Pageable pageable);


    @Query("FROM MemberProfileEntity c WHERE c.cboId = :cboId AND c.isActive= :isActive")
    Page<MemberProfileEntity> fetchByCboIdWithPagination(@Param("cboId") final BigInteger cboId,@Param("isActive") final Boolean isActive, Pageable pageable);

    @Query("FROM MemberProfileEntity c WHERE "+
            "c.cboId IN :shgIdLists AND c.isActive= :isActive AND "+
            "(:memberCode = 0 OR c.memberCode= :memberCode) AND "+
            "(:memberName is null OR lower(c.memberName) like :memberName)")
    Page<MemberProfileEntity> searchMember(
               @Param("shgIdLists") final Set<BigInteger> shgIdLists,
               @Param("isActive") final Boolean isActive,
               @Param("memberCode") final BigInteger memberCode,
               @Param("memberName") final String memberName,
               Pageable pageable);

    @Query("FROM MemberProfileEntity c WHERE c.memberGUID = :memberGUID AND c.isActive= :isActive")
    MemberProfileEntity fetchByGUID(@Param("memberGUID") final String memberGUID,@Param("isActive") final Boolean isActive);

    @Modifying
    @Transactional
    @Query("update MemberProfileEntity u set u.readFlag = :readFlag where u.memberId =:memberId")
    void updateReadFlag(@Param("memberId") final BigInteger memberId,@Param("readFlag") final Boolean readFlag);


    @Query("FROM MemberProfileEntity c WHERE c.cboId = :cboId AND (c.memActivationStatus = :activationStatus1 OR " +
            "c.memActivationStatus = :activationStatus2) AND " +
            "c.readFlag = :readFlag  AND c.isActive = :isActive")
    List<MemberProfileEntity> nonSyncShgsByActivationStatus(@Param("cboId") final BigInteger cboId,
                                                         @Param("activationStatus1") final Short activationStatus1,
                                                         @Param("activationStatus2") final Short activationStatus2,
                                                         @Param("readFlag") final Boolean readFlag,
                                                         @Param("isActive") final Boolean isActive);

    @Query("FROM MemberProfileEntity c WHERE c.cboId = :cboId AND (c.approveStatus = :approveStatus1 OR " +
            "c.approveStatus = :approveStatus2) AND " +
            "c.readFlag = :readFlag  AND c.isActive = :isActive")
    List<MemberProfileEntity> nonSyncShgsByApproveStatus(@Param("cboId") final BigInteger cboId,
                                                         @Param("approveStatus1") final Short approveStatus1,
                                                         @Param("approveStatus2") final Short approveStatus2,
                                                         @Param("readFlag") final Boolean readFlag,
                                                         @Param("isActive") final Boolean isActive);



    @Query("FROM MemberProfileEntity c WHERE "+
            "c.memberId IN :memberIdLists AND c.isActive= :isActive AND "+
            "(:memberCode = 0 OR c.memberCode= :memberCode) AND "+
            "(:memberName is null OR lower(c.memberName) like :memberName)")
    Page<MemberProfileEntity> searchMemberByMob(
            @Param("memberIdLists") final Set<BigInteger> memberIdLists,
            @Param("isActive") final Boolean isActive,
            @Param("memberCode") final BigInteger memberCode,
            @Param("memberName") final String memberName,
            Pageable pageable);


	  @Query("SELECT count(c) FROM MemberProfileEntity c WHERE c.cboId = :cboId AND c.isActive= :isActive")
    Long getMemberCountByShgId(@Param("cboId") final BigInteger cboId,@Param("isActive") final Boolean isActive);

    @Query("SELECT count(c) FROM MemberProfileEntity c WHERE c.cboId = :cboId AND (c.memDedupStatus = :memDedupStatus1 OR c.memDedupStatus = :memDedupStatus2) AND c.isActive= :isActive")
    Long getDedupMemberCountByShgId(@Param("cboId") final BigInteger cboId,
                                    @Param("memDedupStatus1") final Short memDedupStatus1,
                                    @Param("memDedupStatus2") final Short memDedupStatus2,
                                    @Param("isActive") final Boolean isActive);


    @Query("SELECT count(c) FROM MemberProfileEntity c WHERE c.cboId = :cboId AND c.memActivationStatus = :memActivationStatus AND c.isActive= :isActive")
    Long getActivationMemberCountByShgId(@Param("cboId") final BigInteger cboId,
                                    @Param("memActivationStatus") final Short memActivationStatus,
                                    @Param("isActive") final Boolean isActive);



    @Modifying
    @Transactional
    @Query("update MemberProfileEntity u set u.memActivationStatus = :memActivationStatus, u.checkerRemark = :checkerRemark where u.memberId =:memberId")
    void updateActivationByMemberId(@Param("memberId") final BigInteger memberId,
                                 @Param("memActivationStatus") final Short memActivationStatus,
                                 @Param("checkerRemark") final String checkerRemark);

    @Modifying
    @Transactional
    @Query("update MemberProfileEntity u set u.memActivationStatus = :memActivationStatus where u.memberId =:memberId")
    void updateActivationByMemberId2(@Param("memberId") final BigInteger memberId,
                                    @Param("memActivationStatus") final Short memActivationStatus);

    @Modifying
    @Transactional
    @Query("update MemberProfileEntity u set u.memDedupStatus = :memDedupStatus, u.approveStatus = :approveStatus, u.checkerRemark = :checkerRemark where u.memberId =:memberId")
    void updateDDSByMemberId(@Param("memberId") final BigInteger memberId,
                                    @Param("memDedupStatus") final Short memDedupStatus,
                                    @Param("approveStatus") final Short approveStatus,
                                    @Param("checkerRemark") final String checkerRemark);

    @Query("FROM MemberProfileEntity c WHERE c.memDedupStatus = :memDedupStatus AND c.isActive= :isActive")
    List<MemberProfileEntity> fetchMemberProfileByDedupStatus(@Param("memDedupStatus") final Short memDedupStatus,@Param("isActive") final Boolean isActive);


    @Modifying
    @Transactional
    @Query("update MemberProfileEntity u set u.memDedupStatus = :memDedupStatus, u.checkerRemark = :checkerRemark where u.memberId =:memberId")
    void updateDDSByMemberIdWtihoutAS(@Param("memberId") final BigInteger memberId,
                             @Param("memDedupStatus") final Short memDedupStatus,
                             @Param("checkerRemark") final String checkerRemark);



    @Modifying
    @Transactional
    @Query("update MemberProfileEntity u set u.memDedupStatus = :memDedupStatus where u.memberId =:memberId")
    void updatDedupByMemberId(@Param("memberId") final BigInteger memberId,
                              @Param("memDedupStatus") final Short memDedupStatus);


  @Query(value = "SELECT c.checkerRemark FROM MemberProfileEntity c WHERE c.memberId = :memberId")
    String getCheckerRemarksById(@Param("memberId") final BigInteger memberId);

    @Query("FROM MemberProfileEntity c WHERE (c.memberCode is null OR c.memberCode = :memberCode) " +
            "AND c.isActive= :isActive")
    List<MemberProfileEntity> fetchByMemberCodeNull(@Param("memberCode") final BigInteger memberCode,
                                                    @Param("isActive") final Boolean isActive);

    @Modifying
    @Transactional
    @Query("update MemberProfileEntity u set u.memberCode = :memberCode where u.memberId =:memberId")
    void updateMemberCode(@Param("memberId") final BigInteger memberId,
                          @Param("memberCode") final BigInteger memberCode);

    @Query("SELECT count(c) FROM MemberProfileEntity c WHERE c.cboId = :cboId AND c.approveStatus = :approveStatus AND c.isActive= :isActive")
    Long getMemberCountByShgIdApproveStatus(@Param("cboId") final BigInteger cboId,
                                         @Param("approveStatus") final Short approveStatus,
                                         @Param("isActive") final Boolean isActive);


	@Query("SELECT count(c) FROM MemberProfileEntity c WHERE c.cboId IN :shgIdLists AND c.memActivationStatus= :memActivationStatus AND" +
            " c.isActive= :isActive")
    Long getPendingActivated(
            @Param("shgIdLists") final Set<BigInteger> shgIdLists,
            @Param("memActivationStatus") final Short memActivationStatus,
            @Param("isActive") final Boolean isActive);

    @Query("SELECT count(c) FROM MemberProfileEntity c WHERE c.cboId IN :shgIdLists AND c.approveStatus= :approveStatus AND" +
            " c.isActive= :isActive")
    Long getPendingApprove(
            @Param("shgIdLists") final Set<BigInteger> shgIdLists,
            @Param("approveStatus") final Short approveStatus,
            @Param("isActive") final Boolean isActive);

    @Query("SELECT count(c) FROM MemberProfileEntity c WHERE c.cboId IN :shgIdLists AND c.memDedupStatus= :memDedupStatus AND" +
            " c.isActive= :isActive")
    Long getPendingDedup(
            @Param("shgIdLists") final Set<BigInteger> shgIdLists,
            @Param("memDedupStatus") final Short memDedupStatus,
            @Param("isActive") final Boolean isActive);



    @Query("SELECT MAX(c.memberCode/10) FROM MemberProfileEntity c")
    BigInteger getMaxCode();



}
