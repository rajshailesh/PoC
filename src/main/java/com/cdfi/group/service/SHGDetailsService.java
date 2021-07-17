package com.cdfi.group.service;

import com.cdfi.group.domain.*;
import com.cdfi.group.filter.JWTTokenNeeded;
import com.cdfi.group.mapper.GroupMapper;
import com.cdfi.group.mapper.MemberMapper;

import com.cdfi.group.model.*;
import com.cdfi.group.repository.*;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


@Service
@Transactional
@Path("/group-v1/mobile/downloadShg/{id}")
public class SHGDetailsService {
    @PersistenceContext
    private EntityManager em;

    private static final Logger logger = Logger.getLogger(SHGDetailsService.class.getName());
    @Autowired
    CboPhoneNoDetailsRepository cboPhoneNoDetailsRepository;
    @Autowired
    MemberProfileRepository memberProfileRepository;
    @Autowired
    CboAddressesDetailsRepository cboAddressesDetailsRepository;
    @Autowired
    CboBankDetailsRepository cboBankDetailsRepository;
    @Autowired
    SystemTagsRepository systemTagsRepository;
    @Autowired
    SHGDesignationRepository shgDesignationRepository;
    @Autowired
    MemberAddressesDetailsRepository memberAddressesDetailsRepository;
    @Autowired
    MemberBankDetailsRepository memberBankDetailsRepository;
    @Autowired
    MemberKYCDetailsRepository memberKYCDetailsRepository;
    @Autowired
    MemberPhoneNoDetailsRepository memberPhoneNoDetailsRepository;
    @Autowired
    MemberSystemTagsRepository memberSystemTagsRepository;

    @SneakyThrows
    @GET
    //@Consumes(org.springframework.http.MediaType.ALL_VALUE)
    @Produces(MediaType.APPLICATION_JSON)
    @JWTTokenNeeded
    public Response shgDetails(@NotNull @PathParam("id") BigInteger id) {
        SHGProfile shgProfile = null;
        SHGProfileEntity shgProfileEntity = em.find(SHGProfileEntity.class, id);
        if (shgProfileEntity == null) {
            return javax.ws.rs.core.Response.status(404).build();
        }
        if (shgProfileEntity.getIsActive()) {
            shgProfile = GroupMapper.map(shgProfileEntity);
            if (shgProfileEntity.getParent_cbo_code() != null) {
                FederationProfileEntity federationProfileEntity = em.find(FederationProfileEntity.class, shgProfileEntity.getParent_cbo_code());
                if (federationProfileEntity != null) {
                    shgProfile.setFederation_name(federationProfileEntity.getFederationName());
                    shgProfile.setFederation_code(federationProfileEntity.getFederation_code());
                    shgProfile.setFederation_name_local(federationProfileEntity.getFederationNameLocal());
                }
            }
            if(shgProfileEntity.getProfile_document_id()!=null &&
                    shgProfileEntity.getProfile_document_id().intValue() != 0){
                DocumentDetailsEntity documentDetailsEntity =
                        em.find(DocumentDetailsEntity.class, shgProfileEntity.getProfile_document_id());
                if(documentDetailsEntity!= null && documentDetailsEntity.getDocPath() !=null &&
                        !documentDetailsEntity.getDocPath().isEmpty() &&
                        documentDetailsEntity.getFrontDocModifiedName() != null &&
                        !documentDetailsEntity.getFrontDocModifiedName().isEmpty()) {
                    shgProfile.setShg_resolution_document(
                            documentDetailsEntity.getDocPath()+ File.separator
                                    + documentDetailsEntity.getFrontDocModifiedName());
                }
            }
            List<CBOPhoneNoDetails> cboPhoneNoDetailsList =
                    fetchPhoneNumberByCboId(shgProfileEntity.getShg_id(), LookUpMasterEntity.shgLookupVal);
            shgProfile.setCboPhoneNoDetailsList(cboPhoneNoDetailsList);
            List<CBOAddresses> cboAddressesList = fetchAddressByCboId(shgProfileEntity.getShg_id(), LookUpMasterEntity.shgLookupVal);
            shgProfile.setCboAddressesList(cboAddressesList);
            List<CBOBankDetails> cboBankDetailsList =
                    fetchByBankDetailsByCboId(shgProfileEntity.getShg_id(), LookUpMasterEntity.shgLookupVal);
            shgProfile.setCboBankDetailsList(cboBankDetailsList);
            List<SystemTags> cboSystemTagsList =
                    fetchSystemTagsByCboId(shgProfileEntity.getShg_id());
            shgProfile.setCboSystemTagsList(cboSystemTagsList);
            List<SHGDesignation> shgDesignationList =
                    fetchSHGDesignationByCboId(shgProfileEntity.getShg_id());
            shgProfile.setShgDesignationList(shgDesignationList);
            List<MemberProfile> memberProfileList = fetchMemberProfileByCboId(shgProfileEntity.getShg_id());
            shgProfile.setMemberProfileList(memberProfileList);
        }
        return Response
                .status(Response.Status.OK)
                .entity(shgProfile)
                .build();
    }
    public List<CBOPhoneNoDetails> fetchPhoneNumberByCboId(BigInteger cboCode, Short cboType){
        List<CBOPhoneNoDetails> cboPhoneNoDetailsList = new ArrayList<CBOPhoneNoDetails>();
        List<CboPhoneNoDetailsEntity> cboPhoneNoDetailsEntityList =
                cboPhoneNoDetailsRepository.fetchByCboId(cboCode, Boolean.TRUE, cboType);
        for (CboPhoneNoDetailsEntity cboPhoneNoDetailsEntity : cboPhoneNoDetailsEntityList) {


            CBOPhoneNoDetails cboPhoneNoDetails = GroupMapper.map(cboPhoneNoDetailsEntity);
            if(cboPhoneNoDetailsEntity.getMember_guid()!=null){
                MemberProfileEntity memberProfileEntity =
                        memberProfileRepository.fetchByGUID(cboPhoneNoDetailsEntity.getMember_guid(), Boolean.TRUE);
                if(memberProfileEntity!=null)
                    cboPhoneNoDetails.setMember_name(memberProfileEntity.getMember_name());
            }
            cboPhoneNoDetailsList.add(cboPhoneNoDetails);
        }
        return cboPhoneNoDetailsList;
    }
    public List<CBOAddresses> fetchAddressByCboId(BigInteger cboId,Short cboType){
        List<CBOAddresses> cboAddressesList = new ArrayList<CBOAddresses>();
        List<CboAddressesDetailsEntity> cboAddressesDetailsEntityList = cboAddressesDetailsRepository.fetchByCboId(cboId,Boolean.TRUE,cboType);
        for (CboAddressesDetailsEntity cboAddressesDetailsEntity : cboAddressesDetailsEntityList) {

            CBOAddresses cboAddresses = GroupMapper.map(cboAddressesDetailsEntity);
            cboAddressesList.add(cboAddresses);
        }
        return cboAddressesList;
    }
    public List<CBOBankDetails> fetchByBankDetailsByCboId(BigInteger cboId,Short cboType){
        BigInteger bigInteger = new BigInteger("0");
        List<CBOBankDetails> cboBankDetailsList = new ArrayList<CBOBankDetails>();
        List<CboBankDetailsEntity> cboBankDetailsEntityList =
                cboBankDetailsRepository.fetchByCboId(cboId,Boolean.TRUE,cboType);
        for (CboBankDetailsEntity cboBankDetailsEntity : cboBankDetailsEntityList) {

            CBOBankDetails cboBankDetails = GroupMapper.map(cboBankDetailsEntity);
            if(cboBankDetailsEntity.getBank_document_id()!=null &&
                    cboBankDetailsEntity.getBank_document_id()!=bigInteger){
                DocumentDetailsEntity documentDetailsEntity =
                        em.find(DocumentDetailsEntity.class, cboBankDetailsEntity.getBank_document_id());
                if(documentDetailsEntity!= null && documentDetailsEntity.getDocPath() !=null &&
                        !documentDetailsEntity.getDocPath().isEmpty() &&
                        documentDetailsEntity.getFrontDocModifiedName() != null &&
                        !documentDetailsEntity.getFrontDocModifiedName().isEmpty()) {
                    cboBankDetails.setBank_document(
                            documentDetailsEntity.getDocPath()+File.separator
                                    + documentDetailsEntity.getFrontDocModifiedName());
                }

            }
            cboBankDetailsList.add(cboBankDetails);
        }
        return cboBankDetailsList;
    }
    public List<SystemTags> fetchSystemTagsByCboId(BigInteger cboId){
        List<SystemTags> systemTagsList = new ArrayList<SystemTags>();
        List<SystemTagsEntity> systemTagsEntityList =
                systemTagsRepository.fetchByCboId(cboId,Boolean.TRUE);
        for (SystemTagsEntity systemTagsEntity : systemTagsEntityList) {

            SystemTags systemTags = GroupMapper.map(systemTagsEntity);
            systemTagsList.add(systemTags);
        }
        return systemTagsList;
    }
    public List<SHGDesignation> fetchSHGDesignationByCboId(BigInteger cboId){
        List<SHGDesignation> shgDesignationList = new ArrayList<SHGDesignation>();
        List<SHGDesignationEntity> shgDesignationEntityList =
                shgDesignationRepository.fetchByCboId(cboId,Boolean.TRUE);
        for (SHGDesignationEntity shgDesignationEntity : shgDesignationEntityList) {

            SHGDesignation shgDesignation = GroupMapper.map(shgDesignationEntity);
            MemberProfileEntity memberProfileEntity = memberProfileRepository.fetchByGUID(shgDesignation.getMember_guid(),Boolean.TRUE);
            if(memberProfileEntity != null && memberProfileEntity.getMember_name() !=null){
                shgDesignation.setMember_name(memberProfileEntity.getMember_name());
            }
            shgDesignationList.add(shgDesignation);
        }
        return shgDesignationList;
    }
    public List<MemberProfile> fetchMemberProfileByCboId(BigInteger cboId) throws ParseException {
        this.logger.info("Inside ShgApiService->fetchMemberProfileByCboId()");
        List<MemberProfile> memberProfileList = new ArrayList<MemberProfile>();
        List<MemberProfileEntity> memberProfileEntityList = memberProfileRepository.fetchByCboId(cboId,Boolean.TRUE);
        for (MemberProfileEntity memberProfileEntity :memberProfileEntityList) {
            MemberProfile  memberProfile = null;
            memberProfile = MemberMapper.map(memberProfileEntity);
            List<MemberAddressesDetailsEntity> memberAddressesDetailsEntityList = memberAddressesDetailsRepository.findListByMemberCodeCboId(memberProfile.getMember_id(),memberProfile.getCbo_id());
            if(memberAddressesDetailsEntityList != null) {
                List<MemberAddresses> memberAddressesList = new ArrayList<>();
                for(MemberAddressesDetailsEntity ma : memberAddressesDetailsEntityList) {
                    if (ma.getIs_active().equals(Boolean.TRUE)) {
                        memberAddressesList.add(MemberMapper.map(ma));
                    }
                }
                memberProfile.setMemberAddressesList(memberAddressesList);
            }
            List<MemberBankDetailsEntity> memberBankDetailsEntityList = memberBankDetailsRepository.findListByMemberCodeCboId(memberProfile.getMember_id(),memberProfile.getCbo_id());
            if(memberBankDetailsEntityList != null) {
                List<MemberBank> memberBankList = new ArrayList<>();
                for(MemberBankDetailsEntity ma : memberBankDetailsEntityList) {
                    if (ma.getIsActive().equals(Boolean.TRUE)) {
                        memberBankList.add(MemberMapper.map(ma));
                    }
                }
                memberProfile.setMemberBankList(memberBankList);
            }
            List<MemberKYCDetailsEntity> memberKYCDetailsEntityList = memberKYCDetailsRepository.findByMemberCodeCboId(memberProfile.getMember_id(),memberProfile.getCbo_id());
            if(memberKYCDetailsEntityList != null) {
                List<MemberKYCDetails> memberKYCDetailsList = new ArrayList<>();
                for(MemberKYCDetailsEntity ma : memberKYCDetailsEntityList) {
                    if (ma.getIsActive().equals(Boolean.TRUE)) {
                        memberKYCDetailsList.add(MemberMapper.map(ma));
                    }
                }
                memberProfile.setMemberKYCDetailsList(memberKYCDetailsList);
            }
            List<MemberPhoneNoDetailsEntity> memberPhoneNoDetailsEntityList = memberPhoneNoDetailsRepository.findListByMemberCodeCboId(memberProfile.getMember_id(),memberProfile.getCbo_id());
            if(memberPhoneNoDetailsEntityList != null) {
                List<MemberPhoneNoDetails> memberPhoneNoDetailsList = new ArrayList<>();
                for(MemberPhoneNoDetailsEntity ma : memberPhoneNoDetailsEntityList) {
                    if (ma.getIsActive().equals(Boolean.TRUE)) {
                        memberPhoneNoDetailsList.add(MemberMapper.map(ma));
                    }
                }
                memberProfile.setMemberPhoneNoDetailsList(memberPhoneNoDetailsList);
            }
            List<MemberSystemTagsEntity> memberSystemTagsEntityList = memberSystemTagsRepository.findListByMemberCodeCboId(memberProfile.getMember_id(),memberProfile.getCbo_id());
            if(memberSystemTagsEntityList != null) {
                List<MemberSystemTags> memberSystemTagsList = new ArrayList<>();
                for(MemberSystemTagsEntity ma : memberSystemTagsEntityList) {
                    if (ma.getIs_active().equals(Boolean.TRUE)) {
                        memberSystemTagsList.add(MemberMapper.map(ma));
                    }
                }
                memberProfile.setMemberSystemTagsList(memberSystemTagsList);
            }
            memberProfileList.add(memberProfile);
        }
        return memberProfileList;
    }

}
