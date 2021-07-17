package com.cdfi.group.mapper;

import com.cdfi.group.domain.*;
import com.cdfi.group.model.*;
import com.cdfi.group.util.DateUtils;
import lombok.SneakyThrows;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.util.Date;


public class GroupMapper {

    static MapperFactory mapperFactory = new DefaultMapperFactory.Builder()
            .build();
    //CBO PHONE NO
    public static CboPhoneNoDetailsEntity map(final CBOPhoneNoDetails cboPhoneNoDetails) {
        mapperFactory.classMap(CBOPhoneNoDetails.class, CboPhoneNoDetailsEntity.class)
                .customize(
                        new CustomMapper<CBOPhoneNoDetails, CboPhoneNoDetailsEntity>() {
                            public void mapAtoB(CBOPhoneNoDetails a, CboPhoneNoDetailsEntity b, MappingContext context) {
                                if (a.getValid_from() != null) {
                                    b.setValidFrom(new Date(a.getValid_from()));
                                }
                                if (a.getValid_till() != null) {
                                    b.setValidTill(new Date(a.getValid_till()));
                                }
                                if (a.getIs_active().equals(Integer.valueOf(1)))
                                    b.setIsActive(Boolean.TRUE);
                                else {
                                    b.setIsActive(Boolean.FALSE);
                                }
                            }
                        })
                .byDefault().register();
        MapperFacade mapper = mapperFactory.getMapperFacade();
        return mapper.map(cboPhoneNoDetails, CboPhoneNoDetailsEntity.class);
    }

    @SneakyThrows
    public static CBOPhoneNoDetails map(final CboPhoneNoDetailsEntity cboPhoneNoDetailsEntity) {

        mapperFactory.classMap(CboPhoneNoDetailsEntity.class, CBOPhoneNoDetails.class)
                .customize(
                        new CustomMapper<CboPhoneNoDetailsEntity, CBOPhoneNoDetails>() {
                            @SneakyThrows
                            public void mapAtoB(CboPhoneNoDetailsEntity a, CBOPhoneNoDetails b, MappingContext context) {
                                if (a.getValidFrom() != null) {
                                    b.setValid_from(DateUtils.dateToSecondsConverter(a.getValidFrom()));
                                }
                                if (a.getValidTill() != null) {
                                    b.setValid_till(DateUtils.dateToSecondsConverter( a.getValidTill()));
                                }
                                if (a.getLastUploadedDate() != null) {
                                    b.setLast_uploaded_date(DateUtils.timeStampToSecondsConverter(a.getLastUploadedDate()));
                                }
                                if (a.getCreatedDate() != null) {
                                    b.setCreated_date(DateUtils.timeStampToSecondsConverter(a.getCreatedDate()));
                                }
                                if (a.getUpdatedDate() != null) {
                                    b.setLast_uploaded_date(DateUtils.timeStampToSecondsConverter(a.getUpdatedDate()));
                                }
                                b.setIs_edited(0);

                                if (a.getIsActive()) {
                                    b.setIs_active(Short.valueOf((short) 1));
                                } else {
                                    b.setIs_active(Short.valueOf((short) 0));
                                }
                            }
                        })
                .byDefault().register();
        MapperFacade mapper = mapperFactory.getMapperFacade();
        return mapper.map(cboPhoneNoDetailsEntity, CBOPhoneNoDetails.class);

    }

    public static CBOAddresses map(final CboAddressesDetailsEntity cboAddressesDetailsEntity) {
        mapperFactory.classMap(CboAddressesDetailsEntity.class, CBOAddresses.class)
                .customize(
                        new CustomMapper<CboAddressesDetailsEntity, CBOAddresses>() {
                            @SneakyThrows
                            public void mapAtoB(CboAddressesDetailsEntity a, CBOAddresses b, MappingContext context) {
                                b.setIs_edited(0);
                                if (a.getLastUploadedDate() != null) {
                                    b.setLast_uploaded_date(DateUtils.timeStampToSecondsConverter(a.getLastUploadedDate()));
                                }
                                if (a.getCreatedDate() != null) {
                                    b.setCreated_date(DateUtils.timeStampToSecondsConverter(a.getCreatedDate()));
                                }
                                if (a.getUpdatedDate() != null) {
                                    b.setUpdated_date(DateUtils.timeStampToSecondsConverter(a.getUpdatedDate()));
                                }
                                if (a.getIsActive()) {
                                    b.setIs_active(Short.valueOf((short) 1));
                                } else {
                                    b.setIs_active(Short.valueOf((short) 0));
                                }
                            }
                        })
                .byDefault().register();
        MapperFacade mapper = mapperFactory.getMapperFacade();
        return mapper.map(cboAddressesDetailsEntity, CBOAddresses.class);

    }

    @SneakyThrows
    public static CBOBankDetails map(final CboBankDetailsEntity cboBankDetailsEntity) {
        mapperFactory.classMap(CboBankDetailsEntity.class, CBOBankDetails.class)
                .customize(
                        new CustomMapper<CboBankDetailsEntity, CBOBankDetails>() {
                            @SneakyThrows
                            public void mapAtoB(CboBankDetailsEntity a, CBOBankDetails b, MappingContext context) {
                                b.setIs_edited(0);
                                if (a.getClosureDate() != null) {
                                    b.setClosure_date(DateUtils.dateToSecondsConverter(a.getClosureDate()));
                                }
                                if (a.getAccountOpeningDate() != null) {
                                    b.setAccount_opening_date(DateUtils.dateToSecondsConverter(a.getAccountOpeningDate()));
                                }
                                if (a.getAccountLinkageDate() != null) {
                                    b.setAccount_linkage_date(DateUtils.dateToSecondsConverter(a.getAccountLinkageDate()));
                                }
                                if (a.getLastUploadedDate() != null) {
                                    b.setLast_uploaded_date(DateUtils.timeStampToSecondsConverter(a.getLastUploadedDate()));
                                }
                                if (a.getCreatedDate() != null) {
                                    b.setCreated_date(DateUtils.timeStampToSecondsConverter(a.getCreatedDate()));
                                }
                                if (a.getUpdatedDate() != null) {
                                    b.setUpdated_date(DateUtils.timeStampToSecondsConverter(a.getUpdatedDate()));
                                }
                                if (a.getIsDefault())
                                    b.setIs_default(Short.valueOf((short) 1));
                                else {
                                    b.setIs_default(Short.valueOf((short) 0));
                                }
                                if (a.getIsActive()) {
                                    b.setIs_active(Short.valueOf((short) 1));
                                } else {
                                    b.setIs_active(Short.valueOf((short) 0));
                                }
                            }
                        })
                .byDefault().register();
        MapperFacade mapper = mapperFactory.getMapperFacade();
        return mapper.map(cboBankDetailsEntity, CBOBankDetails.class);
    }


    @SneakyThrows
    public static SHGProfile map(final SHGProfileEntity shgProfileEntity) {
         mapperFactory.classMap(SHGProfileEntity.class, SHGProfile.class)
                .customize(
                        new CustomMapper<SHGProfileEntity, SHGProfile>() {
                            @SneakyThrows
                            @Override
                            public void mapAtoB(SHGProfileEntity a, SHGProfile b, MappingContext context) {
                                if (a.getShgFormationDate() != null) {
                                    b.setShg_formation_date(DateUtils.dateToSecondsConverter(a.getShgFormationDate()));
                                }
                                if (a.getShgRevivalDate() != null) {
                                    b.setShg_revival_date(DateUtils.dateToSecondsConverter(a.getShgRevivalDate()));
                                }
                                if (a.getIsActive()) {
                                    b.setIs_active(Short.valueOf((short) 1));
                                } else {
                                    b.setIs_active(Short.valueOf((short) 0));
                                }
                                if (a.getAccountBooksMaintained())
                                    b.setAccount_books_maintained(Short.valueOf((short) 1));
                                else
                                    b.setAccount_books_maintained(Short.valueOf((short) 0));

                                if (a.getCashBookStartDate())
                                    b.setCash_book_start_date(Short.valueOf((short) 1));
                                else
                                    b.setCash_book_start_date(Short.valueOf((short) 0));
                                if (a.getBankBookStartDate())
                                    b.setBank_book_start_date(Short.valueOf((short) 1));
                                else
                                    b.setBank_book_start_date(Short.valueOf((short) 0));
                                if (a.getMembersLedgerStartDate().equals(Boolean.TRUE))
                                    b.setMembers_ledger_start_date(Short.valueOf((short) 1));
                                else
                                    b.setMembers_ledger_start_date(Short.valueOf((short) 0));
                                if (a.getBook_4())
                                    b.setBook4(Short.valueOf((short) 1));
                                else
                                    b.setBook4(Short.valueOf((short) 0));
                                if (a.getBook_5().equals(Boolean.TRUE))
                                    b.setBook5(Short.valueOf((short) 1));
                                else
                                    b.setBook5(Short.valueOf((short) 0));
                                if (a.getGradingDoneOn() != null) {
                                    b.setGrading_done_on(DateUtils.timeStampToSecondsConverter(a.getGradingDoneOn()));
                                }
                                if (a.getCreatedDate() != null) {
                                    b.setCreated_date(DateUtils.timeStampToSecondsConverter(a.getCreatedDate()));
                                }
                                if (a.getLastUploadedDate() != null) {
                                    b.setLast_uploaded_date(DateUtils.timeStampToSecondsConverter(a.getLastUploadedDate()));
                                }
                                if (a.getMicroPlanPrepared())
                                    b.setMicro_plan_prepared(Short.valueOf((short) 1));
                                else
                                    b.setMicro_plan_prepared(Short.valueOf((short) 0));

                                if (a.getBasicShgTraining())
                                    b.setBasic_shg_training(1);
                                else
                                    b.setBasic_shg_training(0);
                                if (a.getShgCooptionDate() != null) {
                                    b.setShg_cooption_date(DateUtils.dateToSecondsConverter(a.getShgCooptionDate()));
                                }
                                b.setIs_edited(0);
                                if (LookUpMasterEntity.activationLookupValPending.equals(a.getActivation_status())) {
                                    if (LookUpMasterEntity.approveLookupValReject.equals(a.getApproveStatus())) {
                                        b.setView_status("New(Rejected)");
                                    } else {
                                        b.setView_status("New");
                                    }
                                } else {
                                    if (LookUpMasterEntity.approveLookupValPending.equals(shgProfileEntity.getApproveStatus())) {
                                        b.setView_status("Modified");
                                    } else if (LookUpMasterEntity.approveLookupValAccept.equals(shgProfileEntity.getApproveStatus())) {
                                        b.setView_status("Activated");
                                    } else if (LookUpMasterEntity.approveLookupValReject.equals(shgProfileEntity.getApproveStatus())) {
                                        b.setView_status("Rejected");
                                    }
                                }

                            }
                        })
                .byDefault().register();
        MapperFacade mapper = mapperFactory.getMapperFacade();
        return mapper.map(shgProfileEntity, SHGProfile.class);
    }


    @SneakyThrows
    public static SystemTags map(final SystemTagsEntity systemTagsEntity) {
        mapperFactory.classMap(SystemTagsEntity.class, SystemTags.class)
                .customize(
                        new CustomMapper<SystemTagsEntity, SystemTags>() {
                            @SneakyThrows
                            public void mapAtoB(SystemTagsEntity a, SystemTags b, MappingContext context) {
                                if (a.getLastUploadedDate() != null) {
                                    b.setLast_uploaded_date(DateUtils.timeStampToSecondsConverter(a.getLastUploadedDate()));
                                }
                                if (a.getCreatedDate() != null) {
                                    b.setCreated_date(DateUtils.timeStampToSecondsConverter(a.getCreatedDate()));
                                }
                                if (a.getUpdatedDate() != null) {
                                    b.setUpdated_date(DateUtils.timeStampToSecondsConverter(a.getUpdatedDate()));
                                }
                                if (a.getIsActive()) {
                                    b.setIs_active(Short.valueOf((short) 1));
                                } else {
                                    b.setIs_active(Short.valueOf((short) 0));
                                }
                            }
                        })
                .byDefault().register();
        MapperFacade mapper = mapperFactory.getMapperFacade();
        return mapper.map(systemTagsEntity, SystemTags.class);
    }

    @SneakyThrows
    public static SHGDesignation map(final SHGDesignationEntity shgDesignationEntity) {
        mapperFactory.classMap(SHGDesignationEntity.class, SHGDesignation.class)
                .customize(
                        new CustomMapper<SHGDesignationEntity, SHGDesignation>() {
                            @SneakyThrows
                            public void mapAtoB(SHGDesignationEntity a, SHGDesignation b, MappingContext context) {
                                if (a.getLastUploadedDate() != null) {
                                    b.setLast_uploaded_date(DateUtils.timeStampToSecondsConverter(a.getLastUploadedDate()));
                                }
                                if (a.getDateElection() != null) {
                                    b.setDate_election(DateUtils.dateToSecondsConverter(a.getDateElection()));
                                }
                                if (a.getFromDate() != null) {
                                    b.setFrom_date(DateUtils.dateToSecondsConverter(a.getFromDate()));
                                }
                                if (a.getToDate() != null) {
                                    b.setTo_date(DateUtils.dateToSecondsConverter(a.getToDate()));
                                }
                                if (a.getUpdatedDate() != null) {
                                    b.setUpdated_date(DateUtils.timeStampToSecondsConverter(a.getUpdatedDate()));
                                }
                                if (a.getCreatedDate() != null) {
                                    b.setCreated_date(DateUtils.timeStampToSecondsConverter(a.getCreatedDate()));
                                }
                                if (a.getIsActive()) {
                                    b.setIs_active(Short.valueOf((short) 1));
                                } else {
                                    b.setIs_active(Short.valueOf((short) 0));
                                }
                            }
                        })
                .byDefault().register();
        MapperFacade mapper = mapperFactory.getMapperFacade();
        return mapper.map(shgDesignationEntity, SHGDesignation.class);
    }

}
