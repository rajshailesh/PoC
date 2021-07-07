package com.cdfi.group.service;

import com.cdfi.group.domain.*;
import com.cdfi.group.filter.JWTTokenNeeded;
import com.cdfi.group.mapper.GroupMapper;
import com.cdfi.group.model.*;
import com.cdfi.group.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


@Service
@Transactional
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

    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    @JWTTokenNeeded
    @Path("/group-v1/mobile/downloadShg/{id}")
    public Response shgDetails(@NotNull @PathParam("username") Integer id) {
        SHGProfile shgProfile = null;
        SHGProfileEntity shgProfileEntity = em.find(SHGProfileEntity.class, id);
        if (shgProfileEntity == null) {
            return javax.ws.rs.core.Response.status(404).build();
        }
        if (shgProfileEntity.getIsActive()) {
            shgProfile = GroupMapper.map(shgProfileEntity);
            if (shgProfileEntity.getParentCboId() != null) {
                FederationProfileEntity federationProfileEntity = em.find(FederationProfileEntity.class, shgProfileEntity.getParentCboId());
                if (federationProfileEntity != null) {
                    shgProfile.setFederation_name(federationProfileEntity.getFederationName());
                    shgProfile.setFederation_code(federationProfileEntity.getFederation_code());
                    shgProfile.setFederation_name_local(federationProfileEntity.getFederationNameLocal());
                }
            }
            if(shgProfileEntity.getProfileDocumentId()!=null &&
                    shgProfileEntity.getProfileDocumentId().intValue() != 0){
                DocumentDetailsEntity documentDetailsEntity =
                        em.find(DocumentDetailsEntity.class, shgProfileEntity.getProfileDocumentId());
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
                    fetchPhoneNumberByCboId(shgProfileEntity.getShgId(),LookUpMasterEntity.shgLookupVal);
            shgProfile.setCboPhoneNoDetailsList(cboPhoneNoDetailsList);
            List<CBOAddresses> cboAddressesList = fetchAddressByCboId(shgProfileEntity.getShgId(),LookUpMasterEntity.shgLookupVal);
            shgProfile.setCboAddressesList(cboAddressesList);
            List<CBOBankDetails> cboBankDetailsList =
                    fetchByBankDetailsByCboId(shgProfileEntity.getShgId(),LookUpMasterEntity.shgLookupVal);
            shgProfile.setCboBankDetailsList(cboBankDetailsList);
            List<SystemTags> cboSystemTagsList =
                    fetchSystemTagsByCboId(shgProfileEntity.getShgId());
            shgProfile.setCboSystemTagsList(cboSystemTagsList);
            List<SHGDesignation> shgDesignationList =
                    fetchSHGDesignationByCboId(shgProfileEntity.getShgId());
            shgProfile.setShgDesignationList(shgDesignationList);
        }
        return Response
                .status(Response.Status.OK)
                .entity(shgProfile)
                .build();
    }
    public List<CBOPhoneNoDetails> fetchPhoneNumberByCboId(BigInteger cboCode, Short cboType){
        List<CBOPhoneNoDetails> cboPhoneNoDetailsList = new ArrayList<CBOPhoneNoDetails>();
        List<CboPhoneNoDetailsEntity> cboPhoneNoDetailsEntityList =
                cboPhoneNoDetailsRepository.fetchByCboId(cboCode,Boolean.TRUE,cboType);
        for (CboPhoneNoDetailsEntity cboPhoneNoDetailsEntity : cboPhoneNoDetailsEntityList) {
            CBOPhoneNoDetails cboPhoneNoDetails = GroupMapper.map(cboPhoneNoDetailsEntity);
            if(cboPhoneNoDetailsEntity.getMemberGuid()!=null){
                MemberProfileEntity memberProfileEntity =
                        memberProfileRepository.fetchByGUID(cboPhoneNoDetailsEntity.getMemberGuid(),Boolean.TRUE);
                if(memberProfileEntity!=null)
                    cboPhoneNoDetails.setMember_name(memberProfileEntity.getMemberName());
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
            if(cboBankDetailsEntity.getBankDocumentId()!=null &&
                    cboBankDetailsEntity.getBankDocumentId()!=bigInteger){
                DocumentDetailsEntity documentDetailsEntity =
                        em.find(DocumentDetailsEntity.class, cboBankDetailsEntity.getBankDocumentId());
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

            //30-3-2021 mohit
            MemberProfileEntity memberProfileEntity = memberProfileRepository.fetchByGUID(shgDesignation.getMember_guid(),Boolean.TRUE);
            if(memberProfileEntity != null && memberProfileEntity.getMemberName() !=null){
                shgDesignation.setMember_name(memberProfileEntity.getMemberName());
            }
            shgDesignationList.add(shgDesignation);
        }
        return shgDesignationList;
    }

}
