package com.cdfi.group.mapper;

import com.cdfi.group.domain.*;
import com.cdfi.group.model.*;
import com.cdfi.group.util.DateUtils;
import lombok.SneakyThrows;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class GroupMapper {

    //CBO PHONE NO
    public static CboPhoneNoDetailsEntity map(final CBOPhoneNoDetails cboPhoneNoDetails) {
        CboPhoneNoDetailsEntity cboPhoneNoDetailsEntity = new CboPhoneNoDetailsEntity();

        cboPhoneNoDetailsEntity.setCboPhoneId(cboPhoneNoDetails.getCbo_phone_id());
        cboPhoneNoDetailsEntity.setPhoneGuid(cboPhoneNoDetails.getPhone_guid());
        cboPhoneNoDetailsEntity.setCboGuid(cboPhoneNoDetails.getCbo_guid());
        cboPhoneNoDetailsEntity.setCboId(cboPhoneNoDetails.getCbo_id());
        cboPhoneNoDetailsEntity.setMobileNo(cboPhoneNoDetails.getMobile_no());
        cboPhoneNoDetailsEntity.setPhoneOwnership(cboPhoneNoDetails.getPhone_ownership());
        cboPhoneNoDetailsEntity.setPhoneOwnershipDetails(cboPhoneNoDetails.getPhone_ownership_details());
        cboPhoneNoDetailsEntity.setCboType(cboPhoneNoDetails.getCbo_type());
        //Valid From
        if (cboPhoneNoDetails.getValid_from() != null) {
            cboPhoneNoDetailsEntity.setValidFrom(new Date(cboPhoneNoDetails.getValid_from()));

        } else {
            cboPhoneNoDetailsEntity.setValidFrom(null);
        }

        //VALID TILL
        if (cboPhoneNoDetails.getValid_till() != null) {
            cboPhoneNoDetailsEntity.setValidTill(new Date(cboPhoneNoDetails.getValid_till()));
        } else {
            cboPhoneNoDetailsEntity.setValidTill(null);
        }
        cboPhoneNoDetailsEntity.setStatus(cboPhoneNoDetails.getStatus());
        cboPhoneNoDetailsEntity.setDeduplicationStatus(cboPhoneNoDetails.getDeduplication_status());
        cboPhoneNoDetailsEntity.setActivationStatus(cboPhoneNoDetails.getActivation_status());
        cboPhoneNoDetailsEntity.setCreatedDate(DateUtils.secondsToTimestampConverter(cboPhoneNoDetails.getCreated_date()));

        Integer shortVal = 1;
        if (cboPhoneNoDetails.getIs_active() != null) {
            if (cboPhoneNoDetails.getIs_active().equals(shortVal.shortValue()))
                cboPhoneNoDetailsEntity.setIsActive(Boolean.TRUE);
            else {
                cboPhoneNoDetailsEntity.setIsActive(Boolean.FALSE);
            }
        } else {
            cboPhoneNoDetailsEntity.setIsActive(Boolean.TRUE);
        }
        cboPhoneNoDetailsEntity.setIsDefault(cboPhoneNoDetails.getIs_default());
        cboPhoneNoDetailsEntity.setEntrySource(cboPhoneNoDetails.getEntry_source());
        cboPhoneNoDetailsEntity.setIsEdited(cboPhoneNoDetails.getIs_edited());
        cboPhoneNoDetailsEntity.setCreatedBy(cboPhoneNoDetails.getCreated_by());
        cboPhoneNoDetailsEntity.setUpdatedBy(cboPhoneNoDetails.getUpdated_by());
        cboPhoneNoDetailsEntity.setUploadedBy(cboPhoneNoDetails.getUploaded_by());
        cboPhoneNoDetailsEntity.setLastUploadedDate(LocalDateTime.now());
        cboPhoneNoDetailsEntity.setMemberGuid(cboPhoneNoDetails.getMember_guid());
        cboPhoneNoDetailsEntity.setIsVerified(cboPhoneNoDetails.getIs_verified());
        cboPhoneNoDetailsEntity.setIsComplete(cboPhoneNoDetails.getIs_complete());

        return cboPhoneNoDetailsEntity;
    }

    @SneakyThrows
    public static CBOPhoneNoDetails map(final CboPhoneNoDetailsEntity cboPhoneNoDetailsEntity) {
        CBOPhoneNoDetails CBOPhoneNoDetails = new CBOPhoneNoDetails();


        CBOPhoneNoDetails.setCbo_phone_id(cboPhoneNoDetailsEntity.getCboPhoneId());
        CBOPhoneNoDetails.setPhone_guid(cboPhoneNoDetailsEntity.getPhoneGuid());
        CBOPhoneNoDetails.setCbo_guid(cboPhoneNoDetailsEntity.getCboGuid());
        CBOPhoneNoDetails.setCbo_id(cboPhoneNoDetailsEntity.getCboId());
        CBOPhoneNoDetails.setMobile_no(cboPhoneNoDetailsEntity.getMobileNo());
        CBOPhoneNoDetails.setPhone_ownership(cboPhoneNoDetailsEntity.getPhoneOwnership());
        CBOPhoneNoDetails.setPhone_ownership_details(cboPhoneNoDetailsEntity.getPhoneOwnershipDetails());

        //VALID FROM
        if (cboPhoneNoDetailsEntity.getValidFrom() != null) {
            CBOPhoneNoDetails.setValid_from(
                    DateUtils.dateToSecondsConverter(cboPhoneNoDetailsEntity.getValidFrom()));
        }

        //VALID TO
        if (cboPhoneNoDetailsEntity.getValidTill() != null) {
            CBOPhoneNoDetails.setValid_till(
                    DateUtils.dateToSecondsConverter(cboPhoneNoDetailsEntity.getValidTill()));
        }
        CBOPhoneNoDetails.setCbo_type(cboPhoneNoDetailsEntity.getCboType());

        //Created Date
        CBOPhoneNoDetails.setCreated_date(DateUtils.timeStampToSecondsConverter(cboPhoneNoDetailsEntity.getCreatedDate()));
        CBOPhoneNoDetails.setStatus(cboPhoneNoDetailsEntity.getStatus());
        CBOPhoneNoDetails.setDeduplication_status(cboPhoneNoDetailsEntity.getDeduplicationStatus());
        CBOPhoneNoDetails.setActivation_status(cboPhoneNoDetailsEntity.getActivationStatus());
        CBOPhoneNoDetails.setCreated_by(cboPhoneNoDetailsEntity.getCreatedBy());
        CBOPhoneNoDetails.setUpdated_by(cboPhoneNoDetailsEntity.getUpdatedBy());
        CBOPhoneNoDetails.setUploaded_by(cboPhoneNoDetailsEntity.getUploadedBy());
        CBOPhoneNoDetails.setLast_uploaded_date
                (cboPhoneNoDetailsEntity.getLastUploadedDate() != null ?
                        DateUtils.timeStampToSecondsConverter(cboPhoneNoDetailsEntity.getLastUploadedDate()) : null);
        CBOPhoneNoDetails.setMember_guid(cboPhoneNoDetailsEntity.getMemberGuid());
        Short shortVal = 1;
        Short shortZeroVal = 0;
        if (cboPhoneNoDetailsEntity.getIsActive()) {
            CBOPhoneNoDetails.setIs_active(shortVal);
        } else {
            CBOPhoneNoDetails.setIs_active(shortZeroVal);
        }

        CBOPhoneNoDetails.setIs_default(cboPhoneNoDetailsEntity.getIsDefault());
        CBOPhoneNoDetails.setEntry_source(cboPhoneNoDetailsEntity.getEntrySource());
        //  CBOPhoneNoDetails.setIs_edited(cboPhoneNoDetailsEntity.getIsEdited());
        CBOPhoneNoDetails.setIs_edited(0);
        CBOPhoneNoDetails.setIs_verified(cboPhoneNoDetailsEntity.getIsVerified());
        CBOPhoneNoDetails.setIs_complete(cboPhoneNoDetailsEntity.getIsComplete());


        return CBOPhoneNoDetails;
    }

    //SHG ADDRESS MAPPING
    public static CboAddressesDetailsEntity map(final CBOAddresses cboAddresses) {
        CboAddressesDetailsEntity cboAddressesDetailsEntity = new CboAddressesDetailsEntity();

        cboAddressesDetailsEntity.setCboAddressId(cboAddresses.getCbo_address_id());
        cboAddressesDetailsEntity.setCboId(cboAddresses.getCbo_id());
        if (cboAddresses.getAddress_type() != null) {
            cboAddressesDetailsEntity.setAddressType(cboAddresses.getAddress_type());
        }
        cboAddressesDetailsEntity.setCboGuid(cboAddresses.getCbo_guid());
        cboAddressesDetailsEntity.setAddressGuid(cboAddresses.getAddress_guid());
        cboAddressesDetailsEntity.setUrbanRural(cboAddresses.getUrban_rural());
        cboAddressesDetailsEntity.setAddressLine1(cboAddresses.getAddress_line1());
        cboAddressesDetailsEntity.setAddressLine2(cboAddresses.getAddress_line2());
        cboAddressesDetailsEntity.setCboType(cboAddresses.getCbo_type());
        cboAddressesDetailsEntity.setCityTown(cboAddresses.getCity_town());
        cboAddressesDetailsEntity.setLandmark(cboAddresses.getLandmark());
        cboAddressesDetailsEntity.setPostalCode(cboAddresses.getPostal_code());
        cboAddressesDetailsEntity.setStateId(cboAddresses.getState_id());
        cboAddressesDetailsEntity.setDistrictId(cboAddresses.getDistrict_id());
        cboAddressesDetailsEntity.setBlockId(cboAddresses.getBlock_id());
        cboAddressesDetailsEntity.setPanchayatId(cboAddresses.getPanchayat_id());
        cboAddressesDetailsEntity.setVillageId(cboAddresses.getVillage_id());
        cboAddressesDetailsEntity.setStatus(cboAddresses.getStatus());
        cboAddressesDetailsEntity.setCreatedDate(DateUtils.secondsToTimestampConverter(cboAddresses.getCreated_date()));
        Integer shortVal = 1;
        if (cboAddresses.getIs_active() != null) {
            if (cboAddresses.getIs_active().equals(shortVal.shortValue()))
                cboAddressesDetailsEntity.setIsActive(Boolean.TRUE);
            else {
                cboAddressesDetailsEntity.setIsActive(Boolean.FALSE);
            }
        } else {
            cboAddressesDetailsEntity.setIsActive(Boolean.TRUE);
        }
        cboAddressesDetailsEntity.setEntrySource(cboAddresses.getEntry_source());
        cboAddressesDetailsEntity.setIsEdited(cboAddresses.getIs_edited());
        cboAddressesDetailsEntity.setCreatedBy(cboAddresses.getCreated_by());
        cboAddressesDetailsEntity.setUpdatedBy(cboAddresses.getUpdated_by());
        cboAddressesDetailsEntity.setUploadedBy(cboAddresses.getUploaded_by());
        cboAddressesDetailsEntity.setLastUploadedDate(LocalDateTime.now(Clock.systemUTC()));
        cboAddressesDetailsEntity.setIsVerified(cboAddresses.getIs_verified());
        cboAddressesDetailsEntity.setIsComplete(cboAddresses.getIs_complete());

        return cboAddressesDetailsEntity;
    }

    @SneakyThrows
    public static CBOAddresses map(final CboAddressesDetailsEntity cboAddressesDetailsEntity) {
        CBOAddresses cboAddresses = new CBOAddresses();

        cboAddresses.setCbo_address_id(cboAddressesDetailsEntity.getCboAddressId());
        cboAddresses.setCbo_id(cboAddressesDetailsEntity.getCboId());
        cboAddresses.setAddress_type(cboAddressesDetailsEntity.getAddressType());
        cboAddresses.setCbo_guid(cboAddressesDetailsEntity.getCboGuid());
        cboAddresses.setAddress_guid(cboAddressesDetailsEntity.getAddressGuid());
        cboAddresses.setUrban_rural(cboAddressesDetailsEntity.getUrbanRural());
        cboAddresses.setAddress_line1(cboAddressesDetailsEntity.getAddressLine1());
        cboAddresses.setAddress_line2(cboAddressesDetailsEntity.getAddressLine2());
        cboAddresses.setCbo_type(cboAddressesDetailsEntity.getCboType());
        cboAddresses.setCity_town(cboAddressesDetailsEntity.getCityTown());
        cboAddresses.setLandmark(cboAddressesDetailsEntity.getLandmark());
        cboAddresses.setPostal_code(cboAddressesDetailsEntity.getPostalCode());
        cboAddresses.setState_id(cboAddressesDetailsEntity.getStateId());
        cboAddresses.setDistrict_id(cboAddressesDetailsEntity.getDistrictId());
        cboAddresses.setBlock_id(cboAddressesDetailsEntity.getBlockId());
        cboAddresses.setPanchayat_id(cboAddressesDetailsEntity.getPanchayatId());
        cboAddresses.setVillage_id(cboAddressesDetailsEntity.getVillageId());
        cboAddresses.setStatus(cboAddressesDetailsEntity.getStatus());
        cboAddresses.setCreated_date(DateUtils.timeStampToSecondsConverter(cboAddressesDetailsEntity.getCreatedDate()));
        cboAddresses.setCreated_by(cboAddressesDetailsEntity.getCreatedBy());
        cboAddresses.setUpdated_by(cboAddressesDetailsEntity.getUpdatedBy());
        cboAddresses.setUploaded_by(cboAddressesDetailsEntity.getUploadedBy());
        cboAddresses.setLast_uploaded_date(cboAddressesDetailsEntity.getLastUploadedDate() != null ?
                DateUtils.timeStampToSecondsConverter(cboAddressesDetailsEntity.getLastUploadedDate()) : null);
        Short shortVal = 1;
        Short shortZeroVal = 0;
        if (cboAddressesDetailsEntity.getIsActive())
            cboAddresses.setIs_active(shortVal);
        else {
            cboAddresses.setIs_active(shortZeroVal);
        }


        cboAddresses.setEntry_source(cboAddressesDetailsEntity.getEntrySource());
        cboAddresses.setIs_edited(0);
        cboAddresses.setIs_verified(cboAddressesDetailsEntity.getIsVerified());
        cboAddresses.setIs_complete(cboAddressesDetailsEntity.getIsComplete());

        return cboAddresses;
    }

    //SHG BANK MAPPING
    public static CboBankDetailsEntity map(final CBOBankDetails cboBankDetails) {
        CboBankDetailsEntity cboBankDetailsEntity = new CboBankDetailsEntity();

        cboBankDetailsEntity.setCboBankId(cboBankDetails.getCbo_bank_id());
        cboBankDetailsEntity.setBankGuid(cboBankDetails.getBank_guid());
        cboBankDetailsEntity.setCboGuid(cboBankDetails.getCbo_guid());
        cboBankDetailsEntity.setCboType(cboBankDetails.getCbo_type());
        cboBankDetailsEntity.setCboId(cboBankDetails.getCbo_id());
        cboBankDetailsEntity.setAccountNo(cboBankDetails.getAccount_no());
        cboBankDetailsEntity.setAccountType(cboBankDetails.getAccount_type());
        cboBankDetailsEntity.setBankBranch(cboBankDetails.getBank_branch());
        cboBankDetailsEntity.setBankBranchId(cboBankDetails.getBank_branch_id());
        cboBankDetailsEntity.setBankId(cboBankDetails.getBank_id());
        cboBankDetailsEntity.setBankCode(cboBankDetails.getBank_code());
        cboBankDetailsEntity.setAccountOpeningDate(cboBankDetails.getAccount_opening_date() != null ?
                DateUtils.secondsToDateConverter(cboBankDetails.getAccount_opening_date()) : null);
        cboBankDetailsEntity.setAccountLinkageDate(cboBankDetails.getAccount_linkage_date() != null ?
                DateUtils.secondsToDateConverter(cboBankDetails.getAccount_linkage_date()) : null);
        cboBankDetailsEntity.setClosureDate(cboBankDetails.getClosure_date() != null ?
                DateUtils.secondsToDateConverter(cboBankDetails.getClosure_date()) : null);
        cboBankDetailsEntity.setStatus(cboBankDetails.getStatus());
        cboBankDetailsEntity.setDeduplicationStatus(cboBankDetails.getDeduplication_status());
        cboBankDetailsEntity.setActivationStatus(cboBankDetails.getActivation_status());
        cboBankDetailsEntity.setBankpassbookName(cboBankDetails.getBankpassbook_name());
        cboBankDetailsEntity.setPassbookFirstpage(cboBankDetails.getPassbook_firstpage());
        Short shortVal = 1;
        cboBankDetailsEntity.setIsDefault(cboBankDetails.getIs_default() != null ? cboBankDetails.getIs_default().equals(shortVal)
                ? Boolean.TRUE : Boolean.FALSE : Boolean.FALSE);
        cboBankDetailsEntity.setSequenceNo(cboBankDetails.getSequence_no());
        cboBankDetailsEntity.setIfscCode(cboBankDetails.getIfsc_code());
        cboBankDetailsEntity.setAccountType(cboBankDetails.getAccount_type());
        cboBankDetailsEntity.setVerification(cboBankDetails.getVerification());
        cboBankDetailsEntity.setCreatedDate(DateUtils.secondsToTimestampConverter(cboBankDetails.getCreated_date()));

        if (cboBankDetails.getIs_active() != null) {
            if (cboBankDetails.getIs_active().equals(shortVal.shortValue()))
                cboBankDetailsEntity.setIsActive(Boolean.TRUE);
            else {
                cboBankDetailsEntity.setIsActive(Boolean.FALSE);
            }
        } else {
            cboBankDetailsEntity.setIsActive(Boolean.TRUE);
        }
        cboBankDetailsEntity.setEntrySource(cboBankDetails.getEntry_source());
        cboBankDetailsEntity.setIsEdited(cboBankDetails.getIs_edited());
        cboBankDetailsEntity.setCreatedBy(cboBankDetails.getCreated_by());
        cboBankDetailsEntity.setUpdatedBy(cboBankDetails.getUpdated_by());
        cboBankDetailsEntity.setUploadedBy(cboBankDetails.getUploaded_by());
        cboBankDetailsEntity.setLastUploadedDate(LocalDateTime.now(Clock.systemUTC()));

        cboBankDetailsEntity.setNpciStatus(cboBankDetails.getNpci_status());
        cboBankDetailsEntity.setIsVerified(cboBankDetails.getIs_verified());
        cboBankDetailsEntity.setIsComplete(cboBankDetails.getIs_complete());


        return cboBankDetailsEntity;
    }

    @SneakyThrows
    public static CBOBankDetails map(final CboBankDetailsEntity cboBankDetailsEntity) {
        CBOBankDetails cboBankDetails = new CBOBankDetails();

        Short shortVal = 1;
        Short shortZeroVal = 0;
        cboBankDetails.setCbo_bank_id(cboBankDetailsEntity.getCboBankId());
        cboBankDetails.setBank_guid(cboBankDetailsEntity.getBankGuid());
        cboBankDetails.setCbo_id(cboBankDetailsEntity.getCboId());
        cboBankDetails.setCbo_guid(cboBankDetailsEntity.getCboGuid());

        cboBankDetails.setCbo_type(cboBankDetailsEntity.getCboType());
        cboBankDetails.setClosure_date(cboBankDetailsEntity.getClosureDate() != null ?
                DateUtils.dateToSecondsConverter(cboBankDetailsEntity.getClosureDate()) : null);
        cboBankDetails.setAccount_no(cboBankDetailsEntity.getAccountNo());
        cboBankDetails.setBank_id(cboBankDetailsEntity.getBankId());
        cboBankDetails.setAccount_type(cboBankDetailsEntity.getAccountType());
        cboBankDetails.setBank_branch(cboBankDetailsEntity.getBankBranch());
        cboBankDetails.setBank_code(cboBankDetailsEntity.getBankCode());
        cboBankDetails.setIfsc_code(cboBankDetailsEntity.getIfscCode());
        cboBankDetails.setBank_branch_id(cboBankDetailsEntity.getBankBranchId());
        cboBankDetails.setAccount_opening_date(cboBankDetailsEntity.getAccountOpeningDate() != null ?
                DateUtils.dateToSecondsConverter(cboBankDetailsEntity.getAccountOpeningDate()) : null);
        cboBankDetails.setAccount_linkage_date(cboBankDetailsEntity.getAccountLinkageDate() != null ?
                DateUtils.dateToSecondsConverter(cboBankDetailsEntity.getAccountLinkageDate()) : null);
        cboBankDetails.setBankpassbook_name(cboBankDetailsEntity.getBankpassbookName());
        cboBankDetails.setPassbook_firstpage(cboBankDetailsEntity.getPassbookFirstpage());
        cboBankDetails.setStatus(cboBankDetailsEntity.getStatus());
        cboBankDetails.setDeduplication_status(cboBankDetailsEntity.getDeduplicationStatus());
        cboBankDetails.setActivation_status(cboBankDetailsEntity.getActivationStatus());
        cboBankDetails.setSequence_no(cboBankDetailsEntity.getSequenceNo());
        cboBankDetails.setVerification(cboBankDetailsEntity.getVerification());
        cboBankDetails.setCreated_date(DateUtils.timeStampToSecondsConverter(cboBankDetailsEntity.getCreatedDate()));
        cboBankDetails.setCreated_by(cboBankDetailsEntity.getCreatedBy());
        cboBankDetails.setUpdated_by(cboBankDetailsEntity.getUpdatedBy());
        cboBankDetails.setUploaded_by(cboBankDetailsEntity.getUploadedBy());
        cboBankDetails.setLast_uploaded_date(cboBankDetailsEntity.getLastUploadedDate() != null ?
                DateUtils.timeStampToSecondsConverter(cboBankDetailsEntity.getLastUploadedDate()) : null);


        if (cboBankDetailsEntity.getIsActive())
            cboBankDetails.setIs_active(shortVal);
        else {
            cboBankDetails.setIs_active(shortZeroVal);
        }


        cboBankDetails.setEntry_source(cboBankDetailsEntity.getEntrySource());
        cboBankDetails.setIs_edited(0);

        if (cboBankDetailsEntity.getIsDefault())
            cboBankDetails.setIs_default(shortVal);
        else {
            cboBankDetails.setIs_default(shortZeroVal);
        }


        cboBankDetails.setNpci_status(cboBankDetailsEntity.getNpciStatus());
        cboBankDetails.setIs_verified(cboBankDetailsEntity.getIsVerified());
        cboBankDetails.setIs_complete(cboBankDetailsEntity.getIsComplete());

        return cboBankDetails;
    }

    //SHG DOCUMENT DETAILS
    public static DocumentDetailsEntity map(final DocumentDetails documentDetails) {
        DocumentDetailsEntity documentDetailsEntity = new DocumentDetailsEntity();
        documentDetailsEntity.setDocumentId(documentDetails.getDocument_id());
        documentDetailsEntity.setFrontDocOriginalName(documentDetails.getFront_doc_original_name());
        documentDetailsEntity.setRearDocOriginalName(documentDetails.getRear_doc_original_name());
        documentDetailsEntity.setRearDocModifiedName(documentDetails.getRear_doc_modified_name());
        documentDetailsEntity.setFrontDocModifiedName(documentDetails.getFront_doc_modified_name());
        documentDetailsEntity.setDocPath(documentDetails.getDoc_path());
        documentDetailsEntity.setCreatedDate(LocalDateTime.now(Clock.systemUTC()));
        documentDetailsEntity.setCreatedBy(documentDetails.getCreated_by());
        documentDetailsEntity.setUpdatedBy(documentDetails.getUpdated_by());
        documentDetailsEntity.setUploadedBy(documentDetails.getUploaded_by());

        return documentDetailsEntity;
    }

    public static DocumentDetails map(final DocumentDetailsEntity documentDetailsEntity) {
        DocumentDetails documentDetails = new DocumentDetails();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

        documentDetails.setDocument_id(documentDetailsEntity.getDocumentId());
        documentDetails.setFront_doc_original_name(documentDetailsEntity.getFrontDocOriginalName());
        documentDetails.setRear_doc_original_name(documentDetailsEntity.getRearDocOriginalName());
        documentDetails.setRear_doc_modified_name(documentDetailsEntity.getRearDocModifiedName());
        documentDetails.setDoc_path(documentDetailsEntity.getDocPath());
        documentDetails.setCreated_date(documentDetailsEntity.getCreatedDate().format(formatter));
        documentDetails.setCreated_by(documentDetailsEntity.getCreatedBy());
        documentDetails.setUpdated_by(documentDetailsEntity.getUpdatedBy());
        documentDetails.setUploaded_by(documentDetailsEntity.getUploadedBy());


        return documentDetails;
    }

    //SHG KYC MAPPING
    public static CboKYCDetailsEntity map(final CboKYCDetails cboKYCDetails) {
        CboKYCDetailsEntity cboKYCDetailsEntity = new CboKYCDetailsEntity();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        cboKYCDetailsEntity.setCboKYCDetailsId(cboKYCDetails.getCbo_kyc_details_id());
        cboKYCDetailsEntity.setKycGuid(cboKYCDetails.getKyc_guid());
        cboKYCDetailsEntity.setCboGuid(cboKYCDetails.getCbo_guid());
        cboKYCDetailsEntity.setCboId(cboKYCDetails.getCbo_id());
        cboKYCDetailsEntity.setDocumentId(cboKYCDetails.getDocument_id());
        cboKYCDetailsEntity.setKycType(cboKYCDetails.getKyc_type());
        cboKYCDetailsEntity.setKycNumber(cboKYCDetails.getKyc_number());
        cboKYCDetailsEntity.setDocumentId(cboKYCDetails.getDocument_id());
        cboKYCDetailsEntity.setKycValidFrom(DateUtils.secondsToDateConverter(cboKYCDetails.getKyc_valid_from()));
        cboKYCDetailsEntity.setKycValidTo(DateUtils.secondsToDateConverter(cboKYCDetails.getKyc_valid_to()));
        cboKYCDetailsEntity.setStatus(cboKYCDetails.getStatus());
        cboKYCDetailsEntity.setDeduplicationStatus(cboKYCDetails.getDeduplication_status());
        cboKYCDetailsEntity.setActivationStatus(cboKYCDetails.getActivation_status());
        cboKYCDetailsEntity.setEntrySource(cboKYCDetails.getEntry_source());
        cboKYCDetailsEntity.setIsEdited(cboKYCDetails.getIs_edited());
        Integer shortVal = 1;
        if (cboKYCDetails.getIs_active() != null) {
            if (cboKYCDetails.getIs_active().equals(shortVal.shortValue()))
                cboKYCDetailsEntity.setIsActive(Boolean.TRUE);
            else {
                cboKYCDetailsEntity.setIsActive(Boolean.FALSE);
            }
        } else {
            cboKYCDetailsEntity.setIsActive(Boolean.TRUE);
        }
        cboKYCDetailsEntity.setCreatedDate(DateUtils.secondsToTimestampConverter(cboKYCDetails.getCreated_date()));
        cboKYCDetailsEntity.setUpdatedDate(DateUtils.secondsToTimestampConverter(cboKYCDetails.getUpdated_date()));
        cboKYCDetailsEntity.setLastUploadedDate(LocalDateTime.now(Clock.systemUTC()));
        cboKYCDetailsEntity.setCreatedBy(cboKYCDetails.getCreated_by());
        cboKYCDetailsEntity.setUpdatedBy(cboKYCDetails.getUpdated_by());
        cboKYCDetailsEntity.setUploadedBy(cboKYCDetails.getUploaded_by());
        cboKYCDetailsEntity.setCboType(cboKYCDetails.getCbo_type());
        cboKYCDetailsEntity.setIsVerified(cboKYCDetails.getIs_verified());
        cboKYCDetailsEntity.setIsComplete(cboKYCDetails.getIs_complete());


        return cboKYCDetailsEntity;
    }

    @SneakyThrows
    public static CboKYCDetails map(final CboKYCDetailsEntity cboKYCDetailsEntity) {
        CboKYCDetails cboKYCDetails = new CboKYCDetails();

        cboKYCDetails.setCbo_kyc_details_id(cboKYCDetailsEntity.getCboKYCDetailsId());
        cboKYCDetails.setCbo_guid(cboKYCDetailsEntity.getCboGuid());
        cboKYCDetails.setKyc_guid(cboKYCDetailsEntity.getKycGuid());
        cboKYCDetails.setKyc_type(cboKYCDetailsEntity.getKycType());
        cboKYCDetails.setCbo_id(cboKYCDetailsEntity.getCboId());
        cboKYCDetails.setKyc_number(cboKYCDetailsEntity.getKycNumber());
        cboKYCDetails.setDocument_id(cboKYCDetailsEntity.getDocumentId());
        cboKYCDetails.setKyc_valid_from(cboKYCDetailsEntity.getKycValidFrom() != null ?
                DateUtils.dateToSecondsConverter(cboKYCDetailsEntity.getKycValidFrom()) : null);
        cboKYCDetails.setKyc_valid_to(cboKYCDetailsEntity.getKycValidTo() != null ?
                DateUtils.dateToSecondsConverter(cboKYCDetailsEntity.getKycValidTo()) : null);
        cboKYCDetails.setCreated_date(cboKYCDetailsEntity.getCreatedDate() != null ?
                DateUtils.timeStampToSecondsConverter(cboKYCDetailsEntity.getCreatedDate()) : null);
        cboKYCDetails.setStatus(cboKYCDetailsEntity.getStatus());
        cboKYCDetails.setDeduplication_status(cboKYCDetailsEntity.getDeduplicationStatus());
        cboKYCDetails.setActivation_status(cboKYCDetailsEntity.getActivationStatus());
        cboKYCDetails.setCreated_by(cboKYCDetailsEntity.getCreatedBy());
        cboKYCDetails.setUpdated_by(cboKYCDetailsEntity.getUpdatedBy());
        cboKYCDetails.setUploaded_by(cboKYCDetailsEntity.getUploadedBy());
        cboKYCDetails.setLast_uploaded_date(cboKYCDetailsEntity.getLastUploadedDate() != null ?
                DateUtils.timeStampToSecondsConverter(cboKYCDetailsEntity.getLastUploadedDate()) : null);
        cboKYCDetails.setCreated_date(cboKYCDetailsEntity.getCreatedDate() != null ?
                DateUtils.timeStampToSecondsConverter(cboKYCDetailsEntity.getCreatedDate()) : null);

        cboKYCDetails.setEntry_source(cboKYCDetailsEntity.getEntrySource());
        cboKYCDetails.setIs_edited(0);
        Short shortVal = 1;
        Short shortZeroVal = 0;
        if (cboKYCDetailsEntity.getIsActive())
            cboKYCDetails.setIs_active(shortVal);
        else {
            cboKYCDetails.setIs_active(shortZeroVal);
        }

        cboKYCDetails.setCbo_type(cboKYCDetailsEntity.getCboType());
        cboKYCDetails.setIs_verified(cboKYCDetailsEntity.getIsVerified());
        cboKYCDetails.setIs_complete(cboKYCDetailsEntity.getIsComplete());

        return cboKYCDetails;
    }

    //SHG PROFILE
    public static SHGProfileEntity mapSHG(final SHGProfile shgProfile) {
        SHGProfileEntity shgProfileEntity = new SHGProfileEntity();

        shgProfileEntity.setShgId(shgProfile.getShg_id());
        shgProfileEntity.setStateId(shgProfile.getState_id());
        shgProfileEntity.setDistrictId(shgProfile.getDistrict_id());
        shgProfileEntity.setBlockId(shgProfile.getBlock_id());
        shgProfileEntity.setPanchayatId(shgProfile.getPanchayat_id());
        shgProfileEntity.setVillageId(shgProfile.getVillage_id());
        shgProfileEntity.setHamletId(shgProfile.getHamlet_id());
        shgProfileEntity.setGuid(shgProfile.getGuid());
        shgProfileEntity.setShgCode(shgProfile.getShg_code());
        shgProfileEntity.setShgName(shgProfile.getShg_name());
        shgProfileEntity.setComposition(shgProfile.getComposition());
        shgProfileEntity.setShgTypeCode(shgProfile.getShg_type_code());
        shgProfileEntity.setShgNameLocal(shgProfile.getShg_name_local());
        shgProfileEntity.setShgNameShortEN(shgProfile.getShg_name_short_en());
        shgProfileEntity.setShgNameShortLocal(shgProfile.getShg_name_short_local());
        // FORMATION DATE
        shgProfileEntity.setShgFormationDate
                (shgProfile.getShg_formation_date() != null ? DateUtils.secondsToDateConverter(shgProfile.getShg_formation_date()) : null);

        // REVIVAL DATE
        shgProfileEntity.setShgRevivalDate
                (shgProfile.getShg_revival_date() != null ? DateUtils.secondsToDateConverter(shgProfile.getShg_revival_date()) : null);

        shgProfileEntity.setShgPromotedBy(shgProfile.getShg_promoted_by());
        shgProfileEntity.setShgRevivedBy(shgProfile.getShg_revived_by());
        shgProfileEntity.setMeetingFrequency(shgProfile.getMeeting_frequency());
        shgProfileEntity.setMeetingFrequencyValue(shgProfile.getMeeting_frequency_value());
        shgProfileEntity.setMeetingOn(shgProfile.getMeeting_on());
        shgProfileEntity.setMode(shgProfile.getMode());
        shgProfileEntity.setMonthCompSaving(shgProfile.getMonth_comp_saving());
        shgProfileEntity.setPaneltyNonSaving(shgProfile.getPanelty_non_saving());
        shgProfileEntity.setInterloaningRate(shgProfile.getInterloaning_rate());
        shgProfileEntity.setSavingsInterest(shgProfile.getSavings_interest());
        shgProfileEntity.setVoluntarySavingsInterest(shgProfile.getVoluntary_savings_interest());
        // shgProfileEntity.setFundingAgencyMasterEntity(shgProfile.getFunding_agency_id());
        shgProfileEntity.setParentCboId(shgProfile.getParent_cbo_code());
        shgProfileEntity.setParentCboType(shgProfile.getParent_cbo_type());
        Integer shortVal = 1;
        if (shgProfile.getIs_active() != null) {
            if (shgProfile.getIs_active().equals(shortVal.shortValue()))
                shgProfileEntity.setIsActive(Boolean.TRUE);
            else {
                shgProfileEntity.setIsActive(Boolean.FALSE);
            }
        } else {
            shgProfileEntity.setIsActive(Boolean.TRUE);
        }

        shgProfileEntity.setIsEdited(shgProfile.getIs_edited());

        shgProfileEntity.setActivationStatus(shortVal.shortValue());
        shgProfileEntity.setEntrySource(shgProfile.getEntry_source());
        shgProfileEntity.setMobileDefaultUser(shgProfile.getMobile_default_user());
        shgProfileEntity.setWebDefaultChecker(shgProfile.getWeb_default_checker());
        if (shgProfile.getAccount_books_maintained() != null) {
            if (shgProfile.getAccount_books_maintained().equals(shortVal.shortValue()))
                shgProfileEntity.setAccountBooksMaintained(Boolean.TRUE);
            else
                shgProfileEntity.setAccountBooksMaintained(Boolean.FALSE);
        }
        if (shgProfile.getCash_book_start_date() != null) {
            if (shgProfile.getCash_book_start_date().equals(shortVal.shortValue()))
                shgProfileEntity.setCashBookStartDate(Boolean.TRUE);
            else
                shgProfileEntity.setCashBookStartDate(Boolean.FALSE);
        }
        if (shgProfile.getBank_book_start_date() != null) {
            if (shgProfile.getBank_book_start_date().equals(shortVal.shortValue()))
                shgProfileEntity.setBankBookStartDate(Boolean.TRUE);
            else
                shgProfileEntity.setBankBookStartDate(Boolean.FALSE);
        }
        if (shgProfile.getMembers_ledger_start_date() != null) {
            if (shgProfile.getMembers_ledger_start_date().equals(shortVal.shortValue()))
                shgProfileEntity.setMembersLedgerStartDate(Boolean.TRUE);
            else
                shgProfileEntity.setMembersLedgerStartDate(Boolean.FALSE);
        }
        if (shgProfile.getBook4() != null) {
            if (shgProfile.getBook4().equals(shortVal.shortValue()))
                shgProfileEntity.setBook4(Boolean.TRUE);
            else
                shgProfileEntity.setBook4(Boolean.FALSE);
        }
        if (shgProfile.getBook5() != null) {
            if (shgProfile.getBook5().equals(shortVal.shortValue()))
                shgProfileEntity.setBook5(Boolean.TRUE);
            else
                shgProfileEntity.setBook5(Boolean.FALSE);
        }

        shgProfileEntity.setGrade(shgProfile.getGrade());
        //GRADING DONE ON
        if (shgProfile.getGrading_done_on() != null) {
            shgProfileEntity.setGradingDoneOn(
                    (shgProfile.getGrading_done_on() != null || shgProfile.getGrading_done_on() != 0) ?
                            DateUtils.secondsToTimestampConverter(shgProfile.getGrading_done_on()) : null);
        }


        shgProfileEntity.setGradeConfirmationStatus(shgProfile.getGrade_confirmation_status());

        //CREATED DATE
        if (shgProfile.getCreated_date() != null) {
            shgProfileEntity.setCreatedDate(DateUtils.secondsToTimestampConverter(shgProfile.getCreated_date()));

        }

        shgProfileEntity.setCreatedBy(shgProfile.getCreated_by());
        shgProfileEntity.setLastUploadedDate(LocalDateTime.now(Clock.systemUTC()));
        shgProfileEntity.setUpdatedBy(shgProfile.getUpdated_by());
        shgProfileEntity.setUpdatedDate(shgProfile.getUpdated_date() != null ? DateUtils.secondsToTimestampConverter(shgProfile.getUpdated_date()) :
                LocalDateTime.now(Clock.systemUTC()));
        shgProfileEntity.setUploadedBy(shgProfile.getUploaded_by());
        shgProfileEntity.setLatitude(shgProfile.getLatitude());
        shgProfileEntity.setLongitude(shgProfile.getLongitude());
        shgProfileEntity.setBookkeeperIdentified(shgProfile.getBookkeeper_identified() != null ?
                shgProfile.getBookkeeper_identified() : shortVal.shortValue());

        if (shgProfile.getMicro_plan_prepared() != null) {
            if (shgProfile.getMicro_plan_prepared().equals(shortVal.shortValue()))
                shgProfileEntity.setMicroPlanPrepared(Boolean.TRUE);
            else
                shgProfileEntity.setMicroPlanPrepared(Boolean.FALSE);
        }

        shgProfileEntity.setUserId(shgProfile.getCreated_by());
        if (shgProfile.getBasic_shg_training() != null) {
            if (shgProfile.getBasic_shg_training() == 1) {
                shgProfileEntity.setBasicShgTraining(Boolean.TRUE);
            } else
                shgProfileEntity.setBasicShgTraining(Boolean.FALSE);
        }

        shgProfileEntity.setReadFlag(Boolean.FALSE);
        shgProfileEntity.setPrimaryActivity(shgProfile.getPrimary_activity());
        shgProfileEntity.setSecondaryActivity(shgProfile.getSecondary_activity());
        shgProfileEntity.setTertiaryActivity(shgProfile.getTertiary_activity());
        shgProfileEntity.setPromoterName(shgProfile.getPromoter_name());
        shgProfileEntity.setSavingFrequency(shgProfile.getSaving_frequency());
        shgProfileEntity.setVolutarySaving(shgProfile.getVolutary_saving());
        shgProfileEntity.setCboLevel(shgProfile.getCbo_level());
        shgProfileEntity.setGeographicLevel(shgProfile.getGeographic_level());
        shgProfileEntity.setSettlementStatus(shgProfile.getSettlement_status());
        shgProfileEntity.setBookkeeperName(shgProfile.getBookkeeper_name());
        shgProfileEntity.setBookkeeperMobile(shgProfile.getBookkeeper_mobile());
        shgProfileEntity.setElectionTenure(shgProfile.getElection_tenure());
        shgProfileEntity.setStatus(shgProfile.getStatus());
        shgProfileEntity.setDeduplicationStatus(shgProfile.getDedupl_status());
        shgProfileEntity.setActivationStatus(shgProfile.getActivation_status());
        shgProfileEntity.setApproveStatus(shgProfile.getApprove_status());
        shgProfileEntity.setCheckerRemark(shgProfile.getChecker_remark() != null ? shgProfile.getChecker_remark() : null);
        shgProfileEntity.setShgCooptionDate(shgProfile.getShg_cooption_date() != null ?
                DateUtils.secondsToDateConverter(shgProfile.getShg_cooption_date()) : null);
        shgProfileEntity.setTags(shgProfile.getTags());
        shgProfileEntity.setShgResolution(shgProfile.getShg_resolution());
        shgProfileEntity.setIsVoluntarySaving(shgProfile.getIs_voluntary_saving());
        //30-3-2021
        shgProfileEntity.setShgTypeOther(shgProfile.getShg_type_other());
        shgProfileEntity.setPromoterCode(shgProfile.getPromoter_code());
        shgProfileEntity.setIsVerified(shgProfile.getIs_verified());
        shgProfileEntity.setIsComplete(shgProfile.getIs_complete());

        return shgProfileEntity;

    }

    @SneakyThrows
    public static SHGProfile map(final SHGProfileEntity shgProfileEntity) {
        SHGProfile shgProfile = new SHGProfile();

        shgProfile.setShg_id(shgProfileEntity.getShgId());
        shgProfile.setState_id(shgProfileEntity.getStateId());
        shgProfile.setDistrict_id(shgProfileEntity.getDistrictId());
        shgProfile.setBlock_id(shgProfileEntity.getBlockId());
        shgProfile.setPanchayat_id(shgProfileEntity.getPanchayatId());
        shgProfile.setVillage_id(shgProfileEntity.getVillageId());
        shgProfile.setHamlet_id(shgProfileEntity.getHamletId());
        shgProfile.setGuid(shgProfileEntity.getGuid());
        shgProfile.setShg_code(shgProfileEntity.getShgCode());
        shgProfile.setShg_name(shgProfileEntity.getShgName());
        shgProfile.setComposition(shgProfileEntity.getComposition());
        shgProfile.setShg_type_code(shgProfileEntity.getShgTypeCode());
        shgProfile.setShg_name_short_en(shgProfileEntity.getShgNameShortEN());
        shgProfile.setShg_name_short_local(shgProfileEntity.getShgNameShortLocal());
        //FORMATION DATE
        shgProfile.setShg_formation_date(DateUtils.dateToSecondsConverter(shgProfileEntity.getShgFormationDate()));
        //REVIVAL DATE
        shgProfile.setShg_revival_date(shgProfileEntity.getShgRevivalDate() != null ?
                DateUtils.dateToSecondsConverter(shgProfileEntity.getShgRevivalDate()) : null);
        shgProfile.setShg_promoted_by(shgProfileEntity.getShgPromotedBy());
        shgProfile.setShg_revived_by(shgProfileEntity.getShgRevivedBy());
        shgProfile.setMeeting_frequency(shgProfileEntity.getMeetingFrequency());
        shgProfile.setMeeting_frequency_value(shgProfileEntity.getMeetingFrequencyValue());
        shgProfile.setMeeting_on(shgProfileEntity.getMeetingOn());
        shgProfile.setMode(shgProfileEntity.getMode());
        shgProfile.setMonth_comp_saving(shgProfileEntity.getMonthCompSaving());
        shgProfile.setPanelty_non_saving(shgProfileEntity.getPaneltyNonSaving());
        shgProfile.setInterloaning_rate(shgProfileEntity.getInterloaningRate());
        shgProfile.setSavings_interest(shgProfileEntity.getSavingsInterest());
        shgProfile.setVoluntary_savings_interest(shgProfileEntity.getVoluntarySavingsInterest());
        // shgProfileEntity.setFundingAgencyMasterEntity(shgProfile.getFunding_agency_id());
        shgProfile.setParent_cbo_code(shgProfileEntity.getParentCboId());
        shgProfile.setParent_cbo_type(shgProfileEntity.getParentCboType());
        shgProfile.setDedupl_status(shgProfileEntity.getDeduplicationStatus());
        shgProfile.setActivation_status(shgProfileEntity.getActivationStatus());
        shgProfile.setApprove_status(shgProfileEntity.getApproveStatus());
        Integer shortVal = 1;
        Integer shortValZero = 0;

        if (shgProfileEntity.getIsActive())
            shgProfile.setIs_active(shortVal.shortValue());
        else
            shgProfile.setIs_active(shortValZero.shortValue());


        shgProfile.setActivation_status(shgProfileEntity.getActivationStatus());
        shgProfile.setEntry_source(shgProfileEntity.getEntrySource());
        shgProfile.setMobile_default_user(shgProfileEntity.getMobileDefaultUser());
        shgProfile.setWeb_default_checker(shgProfileEntity.getWebDefaultChecker());
        if (shgProfileEntity.getAccountBooksMaintained() != null) {
            if (shgProfileEntity.getAccountBooksMaintained().equals(Boolean.TRUE))
                shgProfile.setAccount_books_maintained(new Integer(1).shortValue());
            else
                shgProfile.setAccount_books_maintained(new Integer(0).shortValue());
        }
        if (shgProfileEntity.getCashBookStartDate() != null) {
            if (shgProfileEntity.getCashBookStartDate().equals(Boolean.TRUE))
                shgProfile.setCash_book_start_date(new Integer(1).shortValue());
            else
                shgProfile.setCash_book_start_date(new Integer(0).shortValue());
        }
        if (shgProfileEntity.getBankBookStartDate() != null) {
            if (shgProfileEntity.getBankBookStartDate().equals(Boolean.TRUE))
                shgProfile.setBank_book_start_date(new Integer(1).shortValue());
            else
                shgProfile.setBank_book_start_date(new Integer(0).shortValue());
        }
        if (shgProfileEntity.getMembersLedgerStartDate() != null) {
            if (shgProfileEntity.getMembersLedgerStartDate().equals(Boolean.TRUE))
                shgProfile.setMembers_ledger_start_date(new Integer(1).shortValue());
            else
                shgProfile.setMembers_ledger_start_date(new Integer(0).shortValue());
        }
        if (shgProfileEntity.getBook4() != null) {
            if (shgProfileEntity.getBook4().equals(Boolean.TRUE))
                shgProfile.setBook4(new Integer(1).shortValue());
            else
                shgProfile.setBook4(new Integer(0).shortValue());
        }
        if (shgProfileEntity.getBook5() != null) {
            if (shgProfileEntity.getBook5().equals(Boolean.TRUE))
                shgProfile.setBook5(new Integer(1).shortValue());
            else
                shgProfile.setBook5(new Integer(0).shortValue());
        }


        shgProfile.setGrade(shgProfileEntity.getGrade());
        //GRADING DONE ON
        shgProfile.setGrading_done_on(shgProfileEntity.getGradingDoneOn() != null ?
                DateUtils.timeStampToSecondsConverter(shgProfileEntity.getGradingDoneOn()) : null);


        shgProfile.setGrade_confirmation_status(shgProfileEntity.getGradeConfirmationStatus());

        //CREATED On
        shgProfile.setCreated_date(DateUtils.timeStampToSecondsConverter(shgProfileEntity.getCreatedDate()));

        shgProfile.setLast_uploaded_date(shgProfileEntity.getLastUploadedDate() != null ?
                DateUtils.timeStampToSecondsConverter(shgProfileEntity.getLastUploadedDate()) : null);

        shgProfile.setCreated_by(shgProfileEntity.getCreatedBy());
        shgProfile.setUpdated_by(shgProfileEntity.getUpdatedBy());
        shgProfile.setUploaded_by(shgProfileEntity.getUploadedBy());
        shgProfile.setLatitude(shgProfileEntity.getLatitude());
        shgProfile.setLongitude(shgProfileEntity.getLongitude());
        shgProfile.setBookkeeper_identified(shgProfileEntity.getBookkeeperIdentified() != null ?
                shgProfileEntity.getBookkeeperIdentified() : null);


        if (shgProfileEntity.getMicroPlanPrepared() != null) {
            if (shgProfileEntity.getMicroPlanPrepared().equals(Boolean.TRUE))
                shgProfile.setMicro_plan_prepared(new Integer(1).shortValue());
            else
                shgProfile.setMicro_plan_prepared(new Integer(0).shortValue());
        }

        shgProfile.setUser_id(shgProfileEntity.getUserId());
        if (shgProfileEntity.getBasicShgTraining() != null) {
            if (shgProfileEntity.getBasicShgTraining().equals(Boolean.TRUE))
                shgProfile.setBasic_shg_training(1);
            else
                shgProfile.setBasic_shg_training(0);
        }

        shgProfile.setPrimary_activity(shgProfileEntity.getPrimaryActivity());
        shgProfile.setSecondary_activity(shgProfileEntity.getSecondaryActivity());
        shgProfile.setTertiary_activity(shgProfileEntity.getTertiaryActivity());
        shgProfile.setPromoter_name(shgProfileEntity.getPromoterName());
        shgProfile.setSaving_frequency(shgProfileEntity.getSavingFrequency());
        shgProfile.setVolutary_saving(shgProfileEntity.getVolutarySaving());
        shgProfile.setCbo_level(shgProfileEntity.getCboLevel());
        shgProfile.setGeographic_level(shgProfileEntity.getGeographicLevel());
        shgProfile.setSettlement_status(shgProfileEntity.getSettlementStatus());
        shgProfile.setBookkeeper_name(shgProfileEntity.getBookkeeperName());
        shgProfile.setBookkeeper_mobile(shgProfileEntity.getBookkeeperMobile());
        shgProfile.setElection_tenure(shgProfileEntity.getElectionTenure());
        shgProfile.setStatus(shgProfileEntity.getStatus());

        shgProfile.setChecker_remark(shgProfileEntity.getCheckerRemark() != null ? shgProfileEntity.getCheckerRemark() : null);
        shgProfile.setShg_cooption_date(shgProfileEntity.getShgCooptionDate() != null ?
                DateUtils.dateToSecondsConverter(shgProfileEntity.getShgCooptionDate()) : null);
        shgProfile.setTags(shgProfileEntity.getTags());
        shgProfile.setIs_edited(0);

        if (shgProfileEntity.getActivationStatus() != null && shgProfileEntity.getActivationStatus().
                equals(LookUpMasterEntity.activationLookupValPending)) {
            if (shgProfileEntity.getApproveStatus() != null &&
                    shgProfileEntity.getApproveStatus().equals(LookUpMasterEntity.approveLookupValReject)) {
                shgProfile.setView_status("New(Rejected)");
            } else {
                shgProfile.setView_status("New");
            }
        } else {
            if (shgProfileEntity.getApproveStatus() != null && shgProfileEntity.getApproveStatus().
                    equals(LookUpMasterEntity.approveLookupValPending)) {
                shgProfile.setView_status("Modified");
            } else if (shgProfileEntity.getApproveStatus() != null && shgProfileEntity.getApproveStatus().
                    equals(LookUpMasterEntity.approveLookupValAccept)) {
                shgProfile.setView_status("Activated");
            } else if (shgProfileEntity.getApproveStatus() != null && shgProfileEntity.getApproveStatus().
                    equals(LookUpMasterEntity.approveLookupValReject)) {
                shgProfile.setView_status("Rejected");
            }
        }
        shgProfile.setShg_resolution(shgProfileEntity.getShgResolution());
        shgProfile.setIs_voluntary_saving(shgProfileEntity.getIsVoluntarySaving());
        //30-3-2021
        shgProfile.setShg_type_other(shgProfileEntity.getShgTypeOther());
        shgProfile.setPromoter_code(shgProfileEntity.getPromoterCode());
        shgProfile.setIs_verified(shgProfileEntity.getIsVerified());
        shgProfile.setIs_complete(shgProfileEntity.getIsComplete());

        return shgProfile;
    }

    public static SHGProfileUnmapped mappingShg(final SHGProfileEntity shgProfileEntity) {
        SHGProfileUnmapped shgProfileUnmapped = new SHGProfileUnmapped();

        shgProfileUnmapped.setShg_id(shgProfileEntity.getShgId());
        shgProfileUnmapped.setShg_name(shgProfileEntity.getShgName());
        shgProfileUnmapped.setUser_id(shgProfileEntity.getUserId());
        shgProfileUnmapped.setPanchayat_id(Integer.toString(shgProfileEntity.getPanchayatId()));
        shgProfileUnmapped.setVillage_id(Integer.toString(shgProfileEntity.getVillageId()));

        return shgProfileUnmapped;
    }


    //FEDERATION PROFILE
    //FEDERATION PROFILE
    public static FederationProfileEntity mapFederation(final FederationProfile federationProfile) {
        FederationProfileEntity federationProfileEntity = new FederationProfileEntity();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        federationProfileEntity.setFederationId(federationProfile.getFederation_id());
        federationProfileEntity.setFederation_code(federationProfile.getFederation_code());
        federationProfileEntity.setTemp_code(federationProfile.getTemp_code());
        federationProfileEntity.setGuid(federationProfile.getGuid());
        federationProfileEntity.setStateId(federationProfile.getState_id());
        federationProfileEntity.setDistrictId(federationProfile.getDistrict_id());
        federationProfileEntity.setBlockId(federationProfile.getBlock_id());
        federationProfileEntity.setPanchayatId(federationProfile.getPanchayat_id());
        federationProfileEntity.setVillageId(federationProfile.getVillage_id());
        federationProfileEntity.setCboLevel(federationProfile.getCbo_level());
        federationProfileEntity.setCboType(federationProfile.getCbo_type());
        federationProfileEntity.setChildLevel(federationProfile.getChild_level());
        federationProfileEntity.setGeographicLevel(federationProfile.getGeographic_level());
        federationProfileEntity.setFederationName(federationProfile.getFederation_name());
        federationProfileEntity.setFederationNameShortLocal
                (federationProfile.getFederation_name_short_local());
        federationProfileEntity.setFederationNameShortEN
                (federationProfile.getFederation_name_short_en());
        federationProfileEntity.setFederationNameLocal(federationProfile.getFederation_name_local());
        federationProfileEntity.setFederationTypeCode(federationProfile.getFederation_type_code());
        federationProfileEntity.setReadFlag(Boolean.FALSE);
        federationProfileEntity.setPromoterName(federationProfile.getPromoter_name());
        //FORMATION DATE
        federationProfileEntity.setFederationFormationDate
                (federationProfile.getFederation_formation_date() != null ?
                        DateUtils.secondsToDateConverter(federationProfile.getFederation_formation_date()) : null);

        //REVIVAL DATE
        federationProfileEntity.setFederationRevivalDate
                (federationProfile.getFederation_revival_date() != null ?
                        DateUtils.secondsToDateConverter(federationProfile.getFederation_revival_date()) : null);


        federationProfileEntity.setMeetingFrequency(federationProfile.getMeeting_frequency());
        federationProfileEntity.setMeetingFrequencyValue(federationProfile.getMeeting_frequency_value());
        federationProfileEntity.setMeetingOn(federationProfile.getMeeting_on());
        federationProfileEntity.setMode(federationProfile.getMode());
        federationProfileEntity.setMonthCompSaving(federationProfile.getMonth_comp_saving());
        if (federationProfile.getIs_bankaccount() != null) {
            if (federationProfile.getIs_bankaccount().equals(1))
                federationProfileEntity.setIsBankAccount(Boolean.TRUE);
            else
                federationProfileEntity.setIsBankAccount(Boolean.FALSE);
        }

        federationProfileEntity.setParentCboId(federationProfile.getParent_cbo_code());
        federationProfileEntity.setParentCboType(federationProfile.getParent_cbo_type());
        Integer shortVal = 1;
        if (federationProfile.getIs_active() != null) {
            if (federationProfile.getIs_active().equals(shortVal.shortValue()))
                federationProfileEntity.setIsActive(Boolean.TRUE);
            else
                federationProfileEntity.setIsActive(Boolean.FALSE);
        } else
            federationProfileEntity.setIsActive(Boolean.TRUE);
        federationProfileEntity.setDeduplicationStatus(federationProfile.getDedupl_status());
        federationProfileEntity.setActivationStatus(federationProfile.getActivation_status());
        federationProfileEntity.setSettlementStatus(federationProfile.getSettlement_status());
        federationProfileEntity.setCheckerRemark(federationProfile.getChecker_remark());
        federationProfileEntity.setBookkeeperName(federationProfile.getBookkeeper_name());
        federationProfileEntity.setBookkeeperMobile(federationProfile.getBookkeeper_mobile());
        federationProfileEntity.setBookkeeperIdentified(federationProfile.getBookkeeper_identified());

        federationProfileEntity.setElectionTenure(federationProfile.getElection_tenure());
        federationProfileEntity.setIsVoluntarySaving(federationProfile.getIs_voluntary_saving());
        federationProfileEntity.setSavingFrequency(federationProfile.getSaving_frequency());
        federationProfileEntity.setPromotedBy(federationProfile.getPromoted_by());
        federationProfileEntity.setPrimaryActivity(federationProfile.getPrimary_activity());
        federationProfileEntity.setSecondaryActivity(federationProfile.getSecondary_activity());
        federationProfileEntity.setTertiaryActivity(federationProfile.getTertiary_activity());
        federationProfileEntity.setStatus(federationProfile.getStatus());
        federationProfileEntity.setUserId(federationProfile.getUser_id());
        federationProfileEntity.setEntrySource(federationProfile.getEntry_source());
        federationProfileEntity.setIsEdited(federationProfile.getIs_edited());
        //CREATED DATE
        federationProfileEntity.setCreatedDate
                (federationProfile.getCreated_date() != null ?
                        DateUtils.secondsToTimestampConverter(federationProfile.getCreated_date()) : null);

        //UPDATED DATE
        federationProfileEntity.setUpdatedDate
                (federationProfile.getUpdated_date() != null ?
                        DateUtils.secondsToTimestampConverter(federationProfile.getUpdated_date()) : null);

        federationProfileEntity.setCreatedBy(federationProfile.getCreated_by());
        federationProfileEntity.setLastUploadedDate(LocalDateTime.now(Clock.systemUTC()));
        federationProfileEntity.setUpdatedBy(federationProfile.getUpdated_by());
        federationProfileEntity.setUpdatedDate(LocalDateTime.now(Clock.systemUTC()));
        federationProfileEntity.setUploadedBy(federationProfile.getUploaded_by());

        federationProfileEntity.setFederationNameHindi(federationProfile.getFederation_name_hindi());
        federationProfileEntity.setFederationNameShort(federationProfile.getFederation_name_short());
        federationProfileEntity.setMeberCboCount(federationProfile.getMeber_cbo_count());
        federationProfileEntity.setSavingsInterest(federationProfile.getSavings_interest());
        federationProfileEntity.setVoluntarySavingsInterest(federationProfile.getVoluntary_savings_interest());
        federationProfileEntity.setApproveStatus(federationProfile.getApprove_status());

        if (federationProfile.getIs_financial_intermediation() != null) {
            if (federationProfile.getIs_financial_intermediation().equals(shortVal.shortValue()))
                federationProfileEntity.setIsFinancialIntermediation(Boolean.TRUE);
            else
                federationProfileEntity.setIsFinancialIntermediation(Boolean.FALSE);
        } else
            federationProfileEntity.setIsFinancialIntermediation(Boolean.TRUE);

        if (federationProfile.getIs_volutary_saving() != null) {
            if (federationProfile.getIs_volutary_saving().equals(shortVal.shortValue()))
                federationProfileEntity.setIsVolutarySaving(Boolean.TRUE);
            else
                federationProfileEntity.setIsVolutarySaving(Boolean.FALSE);
        } else
            federationProfileEntity.setIsVolutarySaving(Boolean.TRUE);

        federationProfileEntity.setCooptionDate
                (federationProfile.getCooption_date() != null ?
                        DateUtils.secondsToDateConverter(federationProfile.getCooption_date()) : null);

        federationProfileEntity.setFederationResolution(federationProfile.getFederation_resolution());

        federationProfileEntity.setPromoterCode(federationProfile.getPromoter_code());
        federationProfileEntity.setIsComplete(federationProfile.getIs_complete());

        return federationProfileEntity;
    }

    @SneakyThrows
    public static FederationProfile mapFederation(final FederationProfileEntity federationProfileEntity) {
        FederationProfile federationProfile = new FederationProfile();

        federationProfile.setFederation_id(federationProfileEntity.getFederationId());
        federationProfile.setFederation_code(federationProfileEntity.getFederation_code());
        federationProfile.setTemp_code(federationProfileEntity.getTemp_code());
        federationProfile.setState_id(federationProfileEntity.getStateId());
        federationProfile.setDistrict_id(federationProfileEntity.getDistrictId());
        federationProfile.setBlock_id(federationProfileEntity.getBlockId());
        federationProfile.setPanchayat_id(federationProfileEntity.getPanchayatId());
        federationProfile.setVillage_id(federationProfileEntity.getVillageId());
        federationProfile.setGuid(federationProfileEntity.getGuid());
        federationProfile.setFederation_type_code(federationProfileEntity.getFederationTypeCode());
        federationProfile.setFederation_name(federationProfileEntity.getFederationName());
        federationProfile.setFederation_name_local(federationProfileEntity.getFederationNameLocal());
        federationProfile.setFederation_name_short_en(federationProfileEntity.getFederationNameShortEN());
        federationProfile.setFederation_name_short_local
                (federationProfileEntity.getFederationNameShortLocal());
        federationProfile.setCbo_level(federationProfileEntity.getCboLevel());
        federationProfile.setCbo_type(federationProfileEntity.getCboType());
        federationProfile.setChild_level(federationProfileEntity.getChildLevel());
        federationProfile.setGeographic_level(federationProfileEntity.getGeographicLevel());
        //FORMATION DATE
        federationProfile.setFederation_formation_date(federationProfileEntity
                .getFederationFormationDate() != null ?
                DateUtils.dateToSecondsConverter(federationProfileEntity.getFederationFormationDate()) : null);

        //REVIVAL DATE
        federationProfile.setFederation_revival_date(federationProfileEntity
                .getFederationRevivalDate() != null ?
                DateUtils.dateToSecondsConverter(federationProfileEntity.getFederationRevivalDate()) : null);

        federationProfile.setMeeting_frequency(federationProfileEntity.getMeetingFrequency());
        federationProfile.setMeeting_frequency_value(federationProfileEntity.getMeetingFrequencyValue());
        federationProfile.setMeeting_on(federationProfileEntity.getMeetingOn());
        federationProfile.setMode(federationProfileEntity.getMode());
        federationProfile.setMonth_comp_saving(federationProfileEntity.getMonthCompSaving());

        if (federationProfileEntity.getIsBankAccount())
            federationProfile.setIs_bankaccount(1);
        else
            federationProfile.setIs_bankaccount(0);


        federationProfile.setParent_cbo_code(federationProfileEntity.getParentCboId());
        federationProfile.setParent_cbo_type(federationProfileEntity.getParentCboType());
        federationProfile.setPromoted_by(federationProfileEntity.getPromotedBy());

        federationProfile.setActivation_status(federationProfileEntity.getActivationStatus());
        federationProfile.setDedupl_status(federationProfileEntity.getDeduplicationStatus());
        federationProfile.setStatus(federationProfileEntity.getStatus());
        federationProfile.setSettlement_status(federationProfileEntity.getSettlementStatus());
        federationProfile.setChecker_remark(federationProfileEntity.getCheckerRemark());
        federationProfile.setUser_id(federationProfileEntity.getUserId());
        federationProfile.setEntry_source(federationProfileEntity.getEntrySource());
        federationProfile.setIs_edited(0);
        //CREATED On
        federationProfile.setCreated_date(federationProfileEntity
                .getCreatedDate() != null ?
                DateUtils.timeStampToSecondsConverter(federationProfileEntity.getCreatedDate()) : null);

        //Uploaded Date
        federationProfile.setLast_uploaded_date(federationProfileEntity
                .getLastUploadedDate() != null ?
                DateUtils.timeStampToSecondsConverter(federationProfileEntity.getLastUploadedDate()) : null);

        //Updated Date
        federationProfile.setUpdated_date(federationProfileEntity
                .getUpdatedDate() != null ?
                DateUtils.timeStampToSecondsConverter(federationProfileEntity.getUpdatedDate()) : null);


        federationProfile.setCreated_by(federationProfileEntity.getCreatedBy());
        federationProfile.setUpdated_by(federationProfileEntity.getUpdatedBy());
        federationProfile.setUploaded_by(federationProfileEntity.getUploadedBy());

        Short shortVal = 1;
        Short shortZeroVal = 0;

        if (federationProfileEntity.getIsActive())
            federationProfile.setIs_active(shortVal);
        else {
            federationProfile.setIs_active(shortZeroVal);
        }


        federationProfile.setFederation_name_hindi(federationProfileEntity.getFederationNameHindi());
        federationProfile.setFederation_name_short(federationProfileEntity.getFederationNameShort());
        federationProfile.setMeber_cbo_count(federationProfileEntity.getMeberCboCount());
        federationProfile.setSavings_interest(federationProfileEntity.getSavingsInterest());
        federationProfile.setVoluntary_savings_interest(federationProfileEntity.getVoluntarySavingsInterest());
        federationProfile.setApprove_status(federationProfileEntity.getApproveStatus());


        if (federationProfileEntity.getIsFinancialIntermediation())
            federationProfile.setIs_financial_intermediation(shortVal);
        else {
            federationProfile.setIs_financial_intermediation(shortZeroVal);
        }


        if (federationProfileEntity.getIsVolutarySaving())
            federationProfile.setIs_volutary_saving(shortVal);
        else {
            federationProfile.setIs_volutary_saving(shortZeroVal);
        }

        federationProfile.setCooption_date(federationProfileEntity
                .getCooptionDate() != null ?
                DateUtils.dateToSecondsConverter(federationProfileEntity.getCooptionDate()) : null);

        federationProfile.setBookkeeper_name(federationProfileEntity.getBookkeeperName());
        federationProfile.setPromoter_name(federationProfileEntity.getPromoterName());
        federationProfile.setBookkeeper_mobile(federationProfileEntity.getBookkeeperMobile());
        federationProfile.setBookkeeper_identified(federationProfileEntity.getBookkeeperIdentified());
        federationProfile.setElection_tenure(federationProfileEntity.getElectionTenure());
        federationProfile.setIs_voluntary_saving(federationProfileEntity.getIsVoluntarySaving());
        federationProfile.setSaving_frequency(federationProfileEntity.getSavingFrequency());
        federationProfile.setPrimary_activity(federationProfileEntity.getPrimaryActivity());
        federationProfile.setSecondary_activity(federationProfileEntity.getSecondaryActivity());
        federationProfile.setTertiary_activity(federationProfileEntity.getTertiaryActivity());


        if (federationProfileEntity.getActivationStatus() != null && federationProfileEntity.getActivationStatus().
                equals(LookUpMasterEntity.activationLookupValPending)) {
            if (federationProfileEntity.getApproveStatus() != null &&
                    federationProfileEntity.getApproveStatus().equals(LookUpMasterEntity.approveLookupValReject)) {
                federationProfile.setView_status("New(Rejected)");
            } else {
                federationProfile.setView_status("New");
            }
        } else {
            if (federationProfileEntity.getApproveStatus() != null && federationProfileEntity.getApproveStatus().
                    equals(LookUpMasterEntity.approveLookupValPending)) {
                federationProfile.setView_status("Modified");
            } else if (federationProfileEntity.getApproveStatus() != null && federationProfileEntity.getApproveStatus().
                    equals(LookUpMasterEntity.approveLookupValAccept)) {
                federationProfile.setView_status("Activated");
            } else if (federationProfileEntity.getApproveStatus() != null && federationProfileEntity.getApproveStatus().
                    equals(LookUpMasterEntity.approveLookupValReject)) {
                federationProfile.setView_status("Rejected");
            }
        }
        federationProfile.setFederation_resolution(federationProfileEntity.getFederationResolution());


        federationProfile.setPromoter_code(federationProfileEntity.getPromoterCode());
        federationProfile.setIs_complete(federationProfileEntity.getIsComplete());


        return federationProfile;
    }


    //MOBILE SHG
    @SneakyThrows
    public static ShgProfileMobile mapSHGMobile(final SHGProfileEntity shgProfileEntity) {
        ShgProfileMobile shgProfile = new ShgProfileMobile();

        shgProfile.setShg_id(shgProfileEntity.getShgId());
        shgProfile.setState_id(shgProfileEntity.getStateId());
        shgProfile.setDistrict_id(shgProfileEntity.getDistrictId());
        shgProfile.setBlock_id(shgProfileEntity.getBlockId());
        shgProfile.setPanchayat_id(shgProfileEntity.getPanchayatId());
        shgProfile.setVillage_id(shgProfileEntity.getVillageId());
        shgProfile.setHamlet_id(shgProfileEntity.getHamletId());
        shgProfile.setGuid(shgProfileEntity.getGuid());
        shgProfile.setShg_code(shgProfileEntity.getShgCode());
        shgProfile.setShg_name(shgProfileEntity.getShgName());
        shgProfile.setComposition(shgProfileEntity.getComposition());
        shgProfile.setShg_type_code(shgProfileEntity.getShgTypeCode());
        shgProfile.setShg_name_short_en(shgProfileEntity.getShgNameShortEN());
        shgProfile.setShg_name_short_local(shgProfileEntity.getShgNameShortLocal());
        //FORMATION DATE
        shgProfile.setShg_formation_date(DateUtils.dateToSecondsConverter(shgProfileEntity.getShgFormationDate()));
        //REVIVAL DATE
        shgProfile.setShg_revival_date(shgProfileEntity.getShgRevivalDate() != null ?
                DateUtils.dateToSecondsConverter(shgProfileEntity.getShgRevivalDate()) : null);
        shgProfile.setShg_promoted_by(shgProfileEntity.getShgPromotedBy());
        shgProfile.setShg_revived_by(shgProfileEntity.getShgRevivedBy());
        shgProfile.setMeeting_frequency(shgProfileEntity.getMeetingFrequency());
        shgProfile.setMeeting_frequency_value(shgProfileEntity.getMeetingFrequencyValue());
        shgProfile.setMeeting_on(shgProfileEntity.getMeetingOn());
        shgProfile.setMode(shgProfileEntity.getMode());
        shgProfile.setMonth_comp_saving(shgProfileEntity.getMonthCompSaving());
        shgProfile.setPanelty_non_saving(shgProfileEntity.getPaneltyNonSaving());
        shgProfile.setInterloaning_rate(shgProfileEntity.getInterloaningRate());
        shgProfile.setSavings_interest(shgProfileEntity.getSavingsInterest());
        shgProfile.setVoluntary_savings_interest(shgProfileEntity.getVoluntarySavingsInterest());
        // shgProfileEntity.setFundingAgencyMasterEntity(shgProfile.getFunding_agency_id());
        shgProfile.setParent_cbo_code(shgProfileEntity.getParentCboId());
        shgProfile.setParent_cbo_type(shgProfileEntity.getParentCboType());
        shgProfile.setDedupl_status(shgProfileEntity.getDeduplicationStatus());
        shgProfile.setActivation_status(shgProfileEntity.getActivationStatus());
        shgProfile.setApprove_status(shgProfileEntity.getApproveStatus());

        shgProfile.setActivation_status(shgProfileEntity.getActivationStatus());
        shgProfile.setEntry_source(shgProfileEntity.getEntrySource());
        shgProfile.setMobile_default_user(shgProfileEntity.getMobileDefaultUser());
        shgProfile.setWeb_default_checker(shgProfileEntity.getWebDefaultChecker());
        if (shgProfileEntity.getAccountBooksMaintained() != null) {
            if (shgProfileEntity.getAccountBooksMaintained().equals(Boolean.TRUE))
                shgProfile.setAccount_books_maintained(new Integer(1).shortValue());
            else
                shgProfile.setAccount_books_maintained(new Integer(0).shortValue());
        }
        if (shgProfileEntity.getCashBookStartDate() != null) {
            if (shgProfileEntity.getCashBookStartDate().equals(Boolean.TRUE))
                shgProfile.setCash_book_start_date(new Integer(1).shortValue());
            else
                shgProfile.setCash_book_start_date(new Integer(0).shortValue());
        }
        if (shgProfileEntity.getBankBookStartDate() != null) {
            if (shgProfileEntity.getBankBookStartDate().equals(Boolean.TRUE))
                shgProfile.setBank_book_start_date(new Integer(1).shortValue());
            else
                shgProfile.setBank_book_start_date(new Integer(0).shortValue());
        }
        if (shgProfileEntity.getMembersLedgerStartDate() != null) {
            if (shgProfileEntity.getMembersLedgerStartDate().equals(Boolean.TRUE))
                shgProfile.setMembers_ledger_start_date(new Integer(1).shortValue());
            else
                shgProfile.setMembers_ledger_start_date(new Integer(0).shortValue());
        }
        if (shgProfileEntity.getBook4() != null) {
            if (shgProfileEntity.getBook4().equals(Boolean.TRUE))
                shgProfile.setBook4(new Integer(1).shortValue());
            else
                shgProfile.setBook4(new Integer(0).shortValue());
        }
        if (shgProfileEntity.getBook5() != null) {
            if (shgProfileEntity.getBook5().equals(Boolean.TRUE))
                shgProfile.setBook5(new Integer(1).shortValue());
            else
                shgProfile.setBook5(new Integer(0).shortValue());
        }


        shgProfile.setGrade(shgProfileEntity.getGrade());
        //GRADING DONE ON
        shgProfile.setGrading_done_on(shgProfileEntity.getGradingDoneOn() != null ?
                DateUtils.timeStampToSecondsConverter(shgProfileEntity.getGradingDoneOn()) : null);


        shgProfile.setGrade_confirmation_status(shgProfileEntity.getGradeConfirmationStatus());

        //CREATED On
        shgProfile.setCreated_date(shgProfileEntity.getCreatedDate() != null ?
                DateUtils.timeStampToSecondsConverter(shgProfileEntity.getCreatedDate()) : null);

        shgProfile.setLast_uploaded_date(shgProfileEntity.getLastUploadedDate() != null ?
                DateUtils.timeStampToSecondsConverter(shgProfileEntity.getLastUploadedDate()) : null);

        shgProfile.setCreated_by(shgProfileEntity.getCreatedBy());
        shgProfile.setUpdated_by(shgProfileEntity.getUpdatedBy());
        shgProfile.setUploaded_by(shgProfileEntity.getUploadedBy());
        shgProfile.setLatitude(shgProfileEntity.getLatitude());
        shgProfile.setLongitude(shgProfileEntity.getLongitude());
        if (shgProfileEntity.getBookkeeperIdentified() != null) {
            if (shgProfileEntity.getBookkeeperIdentified().equals(Boolean.TRUE))
                shgProfile.setBookkeeper_identified(new Integer(1).shortValue());
            else
                shgProfile.setBookkeeper_identified(new Integer(0).shortValue());
        }
        if (shgProfileEntity.getMicroPlanPrepared() != null) {
            if (shgProfileEntity.getMicroPlanPrepared().equals(Boolean.TRUE))
                shgProfile.setMicro_plan_prepared(new Integer(1).shortValue());
            else
                shgProfile.setMicro_plan_prepared(new Integer(0).shortValue());
        }

        shgProfile.setUser_id(shgProfileEntity.getUserId());
        if (shgProfileEntity.getBasicShgTraining() != null) {
            if (shgProfileEntity.getBasicShgTraining().equals(Boolean.TRUE))
                shgProfile.setBasic_shg_training(1);
            else
                shgProfile.setBasic_shg_training(0);
        }

        shgProfile.setPrimary_activity(shgProfileEntity.getPrimaryActivity());
        shgProfile.setSecondary_ctivity(shgProfileEntity.getSecondaryActivity());
        shgProfile.setTertiary_activity(shgProfileEntity.getTertiaryActivity());
        shgProfile.setPromoter_name(shgProfileEntity.getPromoterName());
        shgProfile.setSaving_frequency(shgProfileEntity.getSavingFrequency());
        shgProfile.setVolutary_saving(shgProfileEntity.getVolutarySaving());
        shgProfile.setCbo_level(shgProfileEntity.getCboLevel());
        shgProfile.setGeographic_level(shgProfileEntity.getGeographicLevel());
        shgProfile.setSettlement_status(shgProfileEntity.getSettlementStatus());
        shgProfile.setBookkeeper_name(shgProfileEntity.getBookkeeperName());
        shgProfile.setBookkeeper_mobile(shgProfileEntity.getBookkeeperMobile());
        shgProfile.setElection_tenure(shgProfileEntity.getElectionTenure());
        shgProfile.setStatus(shgProfileEntity.getStatus());

        shgProfile.setChecker_remark(shgProfileEntity.getCheckerRemark() != null ? shgProfileEntity.getCheckerRemark() : null);
        Integer shortVal = 1;
        Integer shortValZero = 0;

        if (shgProfileEntity.getIsActive())
            shgProfile.setIs_active(shortVal.shortValue());
        else
            shgProfile.setIs_active(shortValZero.shortValue());


        if (shgProfileEntity.getActivationStatus() != null && shgProfileEntity.getActivationStatus().
                equals(LookUpMasterEntity.activationLookupValPending)) {
            if (shgProfileEntity.getApproveStatus() != null &&
                    shgProfileEntity.getApproveStatus().equals(LookUpMasterEntity.approveLookupValReject)) {
                shgProfile.setView_status("New(Rejected)");
            } else {
                shgProfile.setView_status("New");
            }
        } else {
            if (shgProfileEntity.getApproveStatus() != null && shgProfileEntity.getApproveStatus().
                    equals(LookUpMasterEntity.approveLookupValPending)) {
                shgProfile.setView_status("Modified");
            } else if (shgProfileEntity.getApproveStatus() != null && shgProfileEntity.getApproveStatus().
                    equals(LookUpMasterEntity.approveLookupValAccept)) {
                shgProfile.setView_status("Activated");
            } else if (shgProfileEntity.getApproveStatus() != null && shgProfileEntity.getApproveStatus().
                    equals(LookUpMasterEntity.approveLookupValReject)) {
                shgProfile.setView_status("Rejected");
            }
        }

        //30-3-2021
        shgProfile.setShg_type_other(shgProfileEntity.getShgTypeOther());
        shgProfile.setPromoter_code(shgProfileEntity.getPromoterCode());
        shgProfile.setIs_verified(shgProfileEntity.getIsVerified());
        shgProfile.setIs_complete(shgProfileEntity.getIsComplete());

        return shgProfile;
    }

    public static DataNotInsertedRecords map(final DataNotInsertedLogsEntity dataNotInsertedLogsEntity) {
        DataNotInsertedRecords dataNotInsertedRecords = new DataNotInsertedRecords();
        dataNotInsertedRecords.setGuid(dataNotInsertedLogsEntity.getGuid());
        dataNotInsertedRecords.setRemarks(dataNotInsertedLogsEntity.getRemarks());
        dataNotInsertedRecords.setUser_id(dataNotInsertedLogsEntity.getUserId());

        return dataNotInsertedRecords;
    }

    @SneakyThrows
    public static ShgProfileWithMandatory mapWithMandatory(final SHGProfileEntity shgProfileEntity) {
        ShgProfileWithMandatory shgProfile = new ShgProfileWithMandatory();

        shgProfile.setShg_id(shgProfileEntity.getShgId());
        shgProfile.setState_id(shgProfileEntity.getStateId());
        shgProfile.setDistrict_id(shgProfileEntity.getDistrictId());
        shgProfile.setBlock_id(shgProfileEntity.getBlockId());
        shgProfile.setPanchayat_id(shgProfileEntity.getPanchayatId());
        shgProfile.setVillage_id(shgProfileEntity.getVillageId());
        shgProfile.setGuid(shgProfileEntity.getGuid());
        shgProfile.setShg_name(shgProfileEntity.getShgName());
        shgProfile.setShg_code(shgProfileEntity.getShgCode());
        shgProfile.setShg_type_code(shgProfileEntity.getShgTypeCode());
        shgProfile.setShg_formation_date(DateUtils.dateToSecondsConverter(shgProfileEntity.getShgFormationDate()));

        return shgProfile;
    }

    public static SystemTagsEntity map(final SystemTags systemTags) {
        SystemTagsEntity systemTagsEntity = new SystemTagsEntity();

        systemTagsEntity.setSystemTagsId(systemTags.getSystemtags_id());
        systemTagsEntity.setCboCode(systemTags.getCbo_code());
        systemTagsEntity.setCboGUID(systemTags.getCbo_guid());
        systemTagsEntity.setSystemTagGUID(systemTags.getSystem_tag_guid());
        systemTagsEntity.setSystemType(systemTags.getSystem_type());
        systemTagsEntity.setSystemId(systemTags.getSystem_id());
        systemTagsEntity.setIsEdited(systemTags.getIs_edited());
        systemTagsEntity.setEntrySource(systemTags.getEntry_source());
        Integer shortVal = 1;
        if (systemTags.getIs_active() != null) {
            if (systemTags.getIs_active().equals(shortVal.shortValue()))
                systemTagsEntity.setIsActive(Boolean.TRUE);
            else {
                systemTagsEntity.setIsActive(Boolean.FALSE);
            }
        } else {
            systemTagsEntity.setIsActive(Boolean.TRUE);
        }
        systemTagsEntity.setLastUploadedDate(LocalDateTime.now(Clock.systemUTC()));
        systemTagsEntity.setCreatedBy(systemTags.getCreated_by());
        systemTagsEntity.setUpdatedBy(systemTags.getUpdated_by());
        systemTagsEntity.setUploadedBy(systemTags.getUploaded_by());
        systemTagsEntity.setUpdatedDate(systemTags.getUpdated_date() != null ?
                DateUtils.secondsToTimestampConverter(systemTags.getUpdated_date()) : null);
        systemTagsEntity.setCreatedDate(
                DateUtils.secondsToTimestampConverter(systemTags.getCreated_date()));
        systemTagsEntity.setLastUploadedDate(LocalDateTime.now(Clock.systemUTC()));
        systemTagsEntity.setIsComplete(systemTags.getIs_complete());

        return systemTagsEntity;
    }

    @SneakyThrows
    public static SystemTags map(final SystemTagsEntity systemTagsEntity) {
        SystemTags SystemTags = new SystemTags();

        SystemTags.setSystemtags_id(systemTagsEntity.getSystemTagsId());
        SystemTags.setCbo_code(systemTagsEntity.getCboCode());
        SystemTags.setCbo_guid(systemTagsEntity.getCboGUID());
        SystemTags.setSystem_tag_guid(systemTagsEntity.getSystemTagGUID());
        SystemTags.setSystem_type(systemTagsEntity.getSystemType());
        SystemTags.setSystem_id(systemTagsEntity.getSystemId());
        SystemTags.setEntry_source(systemTagsEntity.getEntrySource());
        SystemTags.setIs_edited(0);
        SystemTags.setCreated_by(systemTagsEntity.getCreatedBy());
        SystemTags.setUpdated_by(systemTagsEntity.getUpdatedBy());
        SystemTags.setUploaded_by(systemTagsEntity.getUploadedBy());
        SystemTags.setUpdated_date((systemTagsEntity.getUpdatedDate() != null) ? DateUtils.timeStampToSecondsConverter(systemTagsEntity.getUpdatedDate()) : null);
        SystemTags.setCreated_date(systemTagsEntity.getCreatedDate() != null ?
                DateUtils.timeStampToSecondsConverter(systemTagsEntity.getCreatedDate()) : null);
        SystemTags.setLast_uploaded_date(systemTagsEntity.getLastUploadedDate() != null ?
                DateUtils.timeStampToSecondsConverter(systemTagsEntity.getLastUploadedDate()) : null);
        Integer shortVal = 1;
        Integer shortValZero = 0;

        if (systemTagsEntity.getIsActive())
            SystemTags.setIs_active(shortVal.shortValue());
        else
            SystemTags.setIs_active(shortValZero.shortValue());

        SystemTags.setIs_complete(systemTagsEntity.getIsComplete());

        return SystemTags;
    }


    public static SHGDesignationEntity map(final SHGDesignation shgDesignation) {
        SHGDesignationEntity shgDesignationEntity = new SHGDesignationEntity();

        shgDesignationEntity.setMemberDesignationId(shgDesignation.getMember_designation_id());
        shgDesignationEntity.setMemberDesignationGUID(shgDesignation.getMember_designation_guid());
        shgDesignationEntity.setMemberCode(shgDesignation.getMember_code());
        shgDesignationEntity.setCboGUID(shgDesignation.getCbo_guid());
        shgDesignationEntity.setMemberGUID(shgDesignation.getMember_guid());
        shgDesignationEntity.setCboCode(shgDesignation.getCbo_code());
        shgDesignationEntity.setDesignation(shgDesignation.getDesignation());
        shgDesignationEntity.setStatus(shgDesignation.getStatus());
        shgDesignationEntity.setEntrySource(shgDesignation.getEntry_source());
        shgDesignationEntity.setIsEdited(shgDesignation.getIs_edited());
        Integer shortVal = 1;
        if (shgDesignation.getIs_active() != null) {
            if (shgDesignation.getIs_active().equals(shortVal.shortValue()))
                shgDesignationEntity.setIsActive(Boolean.TRUE);
            else {
                shgDesignationEntity.setIsActive(Boolean.FALSE);
            }
        } else {
            shgDesignationEntity.setIsActive(Boolean.TRUE);
        }
        shgDesignationEntity.setCreatedDate(LocalDateTime.now(Clock.systemUTC()));
        shgDesignationEntity.setCreatedBy(shgDesignation.getCreated_by());
        shgDesignationEntity.setUpdatedBy(shgDesignation.getUpdated_by());
        shgDesignationEntity.setUploadedBy(shgDesignation.getUploaded_by());
        shgDesignationEntity.setIsSignatory(shgDesignation.getIs_signatory());
        shgDesignationEntity.setCreatedDate(DateUtils.secondsToTimestampConverter(shgDesignation.getCreated_date()));
        if (shgDesignation.getUpdated_date() != null) {
            shgDesignationEntity.setUpdatedDate(DateUtils.secondsToTimestampConverter(shgDesignation.getUpdated_date()));
        }
        shgDesignationEntity.setLastUploadedDate(LocalDateTime.now(Clock.systemUTC()));
        if (shgDesignation.getDate_election() != null) {
            shgDesignationEntity.setDateElection(DateUtils.secondsToDateConverter(shgDesignation.getDate_election()));
        }
        if (shgDesignation.getFrom_date() != null) {
            shgDesignationEntity.setFromDate(DateUtils.secondsToDateConverter(shgDesignation.getFrom_date()));
        }
        if (shgDesignation.getTo_date() != null) {
            shgDesignationEntity.setToDate(DateUtils.secondsToDateConverter(shgDesignation.getTo_date()));
        }

        return shgDesignationEntity;
    }

    @SneakyThrows
    public static SHGDesignation map(final SHGDesignationEntity shgDesignationEntity) {
        SHGDesignation shgDesignation = new SHGDesignation();
        shgDesignation.setMember_designation_id(shgDesignationEntity.getMemberDesignationId());
        shgDesignation.setMember_designation_guid(shgDesignationEntity.getMemberDesignationGUID());
        shgDesignation.setCbo_guid(shgDesignationEntity.getCboGUID());
        shgDesignation.setCbo_code(shgDesignationEntity.getCboCode());
        shgDesignation.setMember_code(shgDesignationEntity.getMemberCode());
        shgDesignation.setMember_guid(shgDesignationEntity.getMemberGUID());
        shgDesignation.setDesignation(shgDesignationEntity.getDesignation());
        shgDesignation.setStatus(shgDesignationEntity.getStatus());
        shgDesignation.setEntry_source(shgDesignationEntity.getEntrySource());
        shgDesignation.setIs_edited(shgDesignationEntity.getIsEdited());
        shgDesignation.setCreated_by(shgDesignationEntity.getCreatedBy());
        shgDesignation.setUpdated_by(shgDesignationEntity.getUpdatedBy());
        shgDesignation.setUploaded_by(shgDesignationEntity.getUploadedBy());
        shgDesignation.setIs_signatory(shgDesignationEntity.getIsSignatory());

        shgDesignation.setDate_election(shgDesignationEntity.getDateElection() != null ?
                DateUtils.dateToSecondsConverter(shgDesignationEntity.getDateElection()) : null);
        shgDesignation.setFrom_date(shgDesignationEntity.getFromDate() != null ?
                DateUtils.dateToSecondsConverter(shgDesignationEntity.getFromDate()) : null);
        shgDesignation.setTo_date(shgDesignationEntity.getToDate() != null ?
                DateUtils.dateToSecondsConverter(shgDesignationEntity.getToDate()) : null);
        shgDesignation.setCreated_date(shgDesignationEntity.getCreatedDate() != null ?
                DateUtils.timeStampToSecondsConverter(shgDesignationEntity.getCreatedDate()) : null);
        shgDesignation.setUpdated_date(shgDesignationEntity.getUpdatedDate() != null ?
                DateUtils.timeStampToSecondsConverter(shgDesignationEntity.getUpdatedDate()) : null);
        shgDesignation.setLast_uploaded_date(DateUtils.timeStampToSecondsConverter(shgDesignationEntity.getLastUploadedDate()));
        Short shortVal = 1;
        Short shortZeroVal = 0;
        if (shgDesignationEntity.getIsActive())
            shgDesignation.setIs_active(shortVal);
        else {
            shgDesignation.setIs_active(shortZeroVal);
        }
        return shgDesignation;
    }

    public static TransactionStatus map(final TransactionStatusEntity transactionStatusEntity) {
        TransactionStatus transactionStatus = new TransactionStatus();
        transactionStatus.setTransaction_id(transactionStatusEntity.getTransactionId());
        transactionStatus.setStatus(transactionStatusEntity.getStatus());
        transactionStatus.setRemarks(transactionStatusEntity.getRemarks());
        return transactionStatus;
    }

    //FEDERATION PROFILE FOR UPLOAD
    public static FederationProfileEntity mapFederation(final FederationProfileForUpload federationProfile) {
        FederationProfileEntity federationProfileEntity = new FederationProfileEntity();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        federationProfileEntity.setFederationId(federationProfile.getFederation_id());
        federationProfileEntity.setGuid(federationProfile.getGuid());
        federationProfileEntity.setStateId(federationProfile.getState_id());
        federationProfileEntity.setDistrictId(federationProfile.getDistrict_id());
        federationProfileEntity.setBlockId(federationProfile.getBlock_id());
        federationProfileEntity.setPanchayatId(federationProfile.getPanchayat_id());
        federationProfileEntity.setVillageId(federationProfile.getVillage_id());
        federationProfileEntity.setCboType(federationProfile.getCbo_type());
        federationProfileEntity.setFederationName(federationProfile.getFederation_name());
        federationProfileEntity.setReadFlag(Boolean.FALSE);
        //FORMATION DATE
        federationProfileEntity.setFederationFormationDate
                (federationProfile.getFederation_formation_date() != null ?
                        DateUtils.secondsToDateConverter(federationProfile.getFederation_formation_date()) : null);

        federationProfileEntity.setMeetingFrequency((short) 0);
        federationProfileEntity.setMode((short) 0);
        federationProfileEntity.setMonthCompSaving(0);
        federationProfileEntity.setIsActive(Boolean.TRUE);
        federationProfileEntity.setUserId(federationProfile.getUser_id());
        federationProfileEntity.setEntrySource(federationProfile.getEntry_source());
        federationProfileEntity.setIsEdited(0);
        //CREATED DATE
        federationProfileEntity.setCreatedDate
                (federationProfile.getCreated_date() != null ?
                        DateUtils.secondsToTimestampConverter(federationProfile.getCreated_date()) : null);
        federationProfileEntity.setCreatedBy(federationProfile.getCreated_by());
        federationProfileEntity.setLastUploadedDate(LocalDateTime.now(Clock.systemUTC()));
        federationProfileEntity.setUploadedBy(federationProfile.getCreated_by());
        federationProfileEntity.setStatus(federationProfile.getStatus());
        //federationProfileEntity.setApproveStatus(-1);

        return federationProfileEntity;
    }
}
