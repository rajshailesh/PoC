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

    @Query("FROM MemberProfileEntity c WHERE c.member_code = :memberCode and c.cbo_guid = :cboGUID")
    MemberProfileEntity findByMemberCode(@Param("memberCode") final BigInteger memberCode, @Param("cboGUID") final String cboGUID);

    @Query("FROM MemberProfileEntity c WHERE c.group_m_code = :groupMCode")
    List<MemberProfileEntity> findByGroupCode(@Param("groupMCode") final Integer groupMCode);

    @Query("FROM MemberProfileEntity c WHERE c.cbo_guid = :cboGUID")
    List<MemberProfileEntity> findByGroupName(@Param("cboGUID") final Integer cboGUID);

    @Query("FROM MemberProfileEntity c WHERE c.member_code = :memberCode")
    List<MemberProfileEntity> findByMemberCodes(@Param("memberCode") final Integer memberCode);

    @Query("FROM MemberProfileEntity c WHERE c.member_name = :memberName")
    List<MemberProfileEntity> findByMemberName(@Param("memberName") final Integer memberName);

    @Query("FROM MemberProfileEntity c WHERE c.cbo_id = :cboId")
    List<MemberProfileEntity> findByCboId(@Param("cboId") final BigInteger cboId);

    @Query("FROM MemberProfileEntity c WHERE c.cbo_id = :cboId AND c.isActive= :isActive")
    List<MemberProfileEntity> fetchByCboId(@Param("cboId") final BigInteger cboId,@Param("isActive") final Boolean isActive);

    @Query("FROM MemberProfileEntity c WHERE (c.mem_dedup_status = :deduplicationStatus1 OR c.mem_dedup_status = :deduplicationStatus2 OR "+
            "(c.mem_dedup_status = :deduplicationStatus3 AND c.mem_activation_status = :memActivationStatus))"
            +" AND c.cbo_id = :cboId AND c.isActive= :isActive")
    List<MemberProfileEntity> fetchByCboIdWithDedups(@Param("cboId") final BigInteger cboId,
                                                     @Param("deduplicationStatus1") final Short deduplicationStatus1,
                                                     @Param("deduplicationStatus2") final Short deduplicationStatus2,
                                                     @Param("deduplicationStatus3") final Short deduplicationStatus3,
                                                     @Param("memActivationStatus") final Short memActivationStatus,
                                                     @Param("isActive") final Boolean isActive);

@Query("FROM MemberProfileEntity c WHERE c.approve_status = :approveStatus " +
        "AND c.mem_dedup_status != :memDedupStatus"
            +" AND c.cbo_id = :cboId AND c.isActive= :isActive")
    Page<MemberProfileEntity> fetchByCboIdApproveStatus(@Param("cboId") final BigInteger cboId,
                                                     @Param("approveStatus") final Short approveStatus,
                                                     @Param("memDedupStatus") final Short memDedupStatus,
                                                     @Param("isActive") final Boolean isActive,
                                                        Pageable pageable);


    @Query("FROM MemberProfileEntity c WHERE c.cbo_id = :cboId AND c.isActive= :isActive")
    Page<MemberProfileEntity> fetchByCboIdWithPagination(@Param("cboId") final BigInteger cboId,@Param("isActive") final Boolean isActive, Pageable pageable);

    @Query("FROM MemberProfileEntity c WHERE "+
            "c.cbo_id IN :shgIdLists AND c.isActive= :isActive AND "+
            "(:member_code = 0 OR c.member_code= :memberCode) AND "+
            "(:member_name is null OR lower(c.member_name) like :memberName)")
    Page<MemberProfileEntity> searchMember(
               @Param("shgIdLists") final Set<BigInteger> shgIdLists,
               @Param("isActive") final Boolean isActive,
               @Param("memberCode") final BigInteger memberCode,
               @Param("memberName") final String memberName,
               Pageable pageable);

    @Query("FROM MemberProfileEntity c WHERE c.member_guid = :memberGUID AND c.isActive= :isActive")
    MemberProfileEntity fetchByGUID(@Param("memberGUID") final String memberGUID,@Param("isActive") final Boolean isActive);

    @Modifying
    @Transactional
    @Query("update MemberProfileEntity u set u.read_flag = :readFlag where u.member_id =:memberId")
    void updateReadFlag(@Param("memberId") final BigInteger memberId,@Param("readFlag") final Boolean readFlag);


    @Query("FROM MemberProfileEntity c WHERE c.cbo_id = :cboId AND (c.mem_activation_status = :activationStatus1 OR " +
            "c.mem_activation_status = :activationStatus2) AND " +
            "c.read_flag = :readFlag  AND c.isActive = :isActive")
    List<MemberProfileEntity> nonSyncShgsByActivationStatus(@Param("cboId") final BigInteger cboId,
                                                         @Param("activationStatus1") final Short activationStatus1,
                                                         @Param("activationStatus2") final Short activationStatus2,
                                                         @Param("readFlag") final Boolean readFlag,
                                                         @Param("isActive") final Boolean isActive);

    @Query("FROM MemberProfileEntity c WHERE c.cbo_id = :cboId AND (c.approve_status = :approveStatus1 OR " +
            "c.approve_status = :approveStatus2) AND " +
            "c.read_flag = :readFlag  AND c.isActive = :isActive")
    List<MemberProfileEntity> nonSyncShgsByApproveStatus(@Param("cboId") final BigInteger cboId,
                                                         @Param("approveStatus1") final Short approveStatus1,
                                                         @Param("approveStatus2") final Short approveStatus2,
                                                         @Param("readFlag") final Boolean readFlag,
                                                         @Param("isActive") final Boolean isActive);



    @Query("FROM MemberProfileEntity c WHERE "+
            "c.member_id IN :memberIdLists AND c.isActive= :isActive AND "+
            "(:member_code = 0 OR c.member_code= :memberCode) AND "+
            "(:member_name is null OR lower(c.member_name) like :memberName)")
    Page<MemberProfileEntity> searchMemberByMob(
            @Param("memberIdLists") final Set<BigInteger> memberIdLists,
            @Param("isActive") final Boolean isActive,
            @Param("memberCode") final BigInteger memberCode,
            @Param("memberName") final String memberName,
            Pageable pageable);


	  @Query("SELECT count(c) FROM MemberProfileEntity c WHERE c.cbo_id = :cboId AND c.isActive= :isActive")
    Long getMemberCountByShgId(@Param("cboId") final BigInteger cboId,@Param("isActive") final Boolean isActive);

    @Query("SELECT count(c) FROM MemberProfileEntity c WHERE c.cbo_id = :cboId AND (c.mem_dedup_status = :memDedupStatus1 OR c.mem_dedup_status = :memDedupStatus2) AND c.isActive= :isActive")
    Long getDedupMemberCountByShgId(@Param("cboId") final BigInteger cboId,
                                    @Param("memDedupStatus1") final Short memDedupStatus1,
                                    @Param("memDedupStatus2") final Short memDedupStatus2,
                                    @Param("isActive") final Boolean isActive);


    @Query("SELECT count(c) FROM MemberProfileEntity c WHERE c.cbo_id = :cboId AND c.mem_activation_status = :memActivationStatus AND c.isActive= :isActive")
    Long getActivationMemberCountByShgId(@Param("cboId") final BigInteger cboId,
                                    @Param("memActivationStatus") final Short memActivationStatus,
                                    @Param("isActive") final Boolean isActive);



    @Modifying
    @Transactional
    @Query("update MemberProfileEntity u set u.mem_activation_status = :memActivationStatus, u.checker_remark = :checkerRemark where u.member_id =:memberId")
    void updateActivationByMemberId(@Param("memberId") final BigInteger memberId,
                                 @Param("memActivationStatus") final Short memActivationStatus,
                                 @Param("checkerRemark") final String checkerRemark);

    @Modifying
    @Transactional
    @Query("update MemberProfileEntity u set u.mem_activation_status = :memActivationStatus where u.member_id =:memberId")
    void updateActivationByMemberId2(@Param("memberId") final BigInteger memberId,
                                    @Param("memActivationStatus") final Short memActivationStatus);

    @Modifying
    @Transactional
    @Query("update MemberProfileEntity u set u.mem_dedup_status = :memDedupStatus, u.approve_status = :approveStatus, u.checker_remark = :checkerRemark where u.member_id =:memberId")
    void updateDDSByMemberId(@Param("memberId") final BigInteger memberId,
                                    @Param("memDedupStatus") final Short memDedupStatus,
                                    @Param("approveStatus") final Short approveStatus,
                                    @Param("checkerRemark") final String checkerRemark);

    @Query("FROM MemberProfileEntity c WHERE c.mem_dedup_status = :memDedupStatus AND c.isActive= :isActive")
    List<MemberProfileEntity> fetchMemberProfileByDedupStatus(@Param("memDedupStatus") final Short memDedupStatus,@Param("isActive") final Boolean isActive);


    @Modifying
    @Transactional
    @Query("update MemberProfileEntity u set u.mem_dedup_status = :memDedupStatus, u.checker_remark = :checkerRemark where u.member_id =:memberId")
    void updateDDSByMemberIdWtihoutAS(@Param("memberId") final BigInteger memberId,
                             @Param("memDedupStatus") final Short memDedupStatus,
                             @Param("checkerRemark") final String checkerRemark);



    @Modifying
    @Transactional
    @Query("update MemberProfileEntity u set u.mem_dedup_status = :memDedupStatus where u.member_id =:memberId")
    void updatDedupByMemberId(@Param("memberId") final BigInteger memberId,
                              @Param("memDedupStatus") final Short memDedupStatus);


  @Query(value = "SELECT c.checker_remark FROM MemberProfileEntity c WHERE c.member_id = :memberId")
    String getCheckerRemarksById(@Param("memberId") final BigInteger memberId);

    @Query("FROM MemberProfileEntity c WHERE (c.member_code is null OR c.member_code = :memberCode) " +
            "AND c.isActive= :isActive")
    List<MemberProfileEntity> fetchByMemberCodeNull(@Param("memberCode") final BigInteger memberCode,
                                                    @Param("isActive") final Boolean isActive);

    @Modifying
    @Transactional
    @Query("update MemberProfileEntity u set u.member_code = :memberCode where u.member_id =:memberId")
    void updateMemberCode(@Param("memberId") final BigInteger memberId,
                          @Param("memberCode") final BigInteger memberCode);

    @Query("SELECT count(c) FROM MemberProfileEntity c WHERE c.cbo_id = :cboId AND c.approve_status = :approveStatus AND c.isActive= :isActive")
    Long getMemberCountByShgIdApproveStatus(@Param("cboId") final BigInteger cboId,
                                         @Param("approveStatus") final Short approveStatus,
                                         @Param("isActive") final Boolean isActive);


	@Query("SELECT count(c) FROM MemberProfileEntity c WHERE c.cbo_id IN :shgIdLists AND c.mem_activation_status= :memActivationStatus AND" +
            " c.isActive= :isActive")
    Long getPendingActivated(
            @Param("shgIdLists") final Set<BigInteger> shgIdLists,
            @Param("memActivationStatus") final Short memActivationStatus,
            @Param("isActive") final Boolean isActive);

    @Query("SELECT count(c) FROM MemberProfileEntity c WHERE c.cbo_id IN :shgIdLists AND c.approve_status= :approveStatus AND" +
            " c.isActive= :isActive")
    Long getPendingApprove(
            @Param("shgIdLists") final Set<BigInteger> shgIdLists,
            @Param("approveStatus") final Short approveStatus,
            @Param("isActive") final Boolean isActive);

    @Query("SELECT count(c) FROM MemberProfileEntity c WHERE c.cbo_id IN :shgIdLists AND c.mem_dedup_status= :memDedupStatus AND" +
            " c.isActive= :isActive")
    Long getPendingDedup(
            @Param("shgIdLists") final Set<BigInteger> shgIdLists,
            @Param("memDedupStatus") final Short memDedupStatus,
            @Param("isActive") final Boolean isActive);



    @Query("SELECT MAX(c.member_code/10) FROM MemberProfileEntity c")
    BigInteger getMaxCode();



}
