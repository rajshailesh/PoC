package com.cdfi.group.mapper;

import com.cdfi.group.domain.*;
import com.cdfi.group.model.*;
import com.cdfi.group.util.DateUtils;
import lombok.SneakyThrows;
import ma.glasnost.orika.*;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.util.Date;


public class GroupMapper {

    static MapperFactory mapperFactory = new DefaultMapperFactory.Builder()
            .build();
    //static MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();


    //CBO PHONE NO
    public static CboPhoneNoDetailsEntity map(final CBOPhoneNoDetails cboPhoneNoDetails) {
        mapperFactory.classMap(CBOPhoneNoDetails.class, CboPhoneNoDetailsEntity.class)
                .customize(
                        new CustomMapper<CBOPhoneNoDetails, CboPhoneNoDetailsEntity>() {
                            public void mapAtoB(CBOPhoneNoDetails a, CboPhoneNoDetailsEntity b, MappingContext context) {
                                if (a.getValid_from() != null) {
                                    b.setValid_from(new Date(a.getValid_from()));
                                }
                                if (a.getValid_till() != null) {
                                    b.setValid_till(new Date(a.getValid_till()));
                                }
                                if (a.getIs_active().equals(Integer.valueOf(1)))
                                    b.setIs_active(Boolean.TRUE);
                                else {
                                    b.setIs_active(Boolean.FALSE);
                                }
                            }
                        })
                .register();
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
                                if (a.getValid_from() != null) {
                                    b.setValid_from(DateUtils.dateToSecondsConverter(a.getValid_from()));
                                }
                                if (a.getValid_till() != null) {
                                    b.setValid_till(DateUtils.dateToSecondsConverter(a.getValid_till()));
                                }
                                if (a.getLast_uploaded_date() != null) {
                                    b.setLast_uploaded_date(DateUtils.timeStampToSecondsConverter(a.getLast_uploaded_date()));
                                }

                                if (a.getIs_active()) {
                                    b.setIs_active(Short.valueOf((short) 1));
                                } else {
                                    b.setIs_active(Short.valueOf((short) 0));
                                }
                            }
                        })
                .register();
        MapperFacade mapper = mapperFactory.getMapperFacade();
        return mapper.map(cboPhoneNoDetailsEntity, CBOPhoneNoDetails.class);

    }

    public static CBOAddresses map(final CboAddressesDetailsEntity cboAddressesDetailsEntity) {
        mapperFactory.classMap(CboAddressesDetailsEntity.class, CBOAddresses.class)
                .customize(
                        new CustomMapper<CboAddressesDetailsEntity, CBOAddresses>() {
                            @SneakyThrows
                            public void mapAtoB(CboAddressesDetailsEntity a, CBOAddresses b, MappingContext context) {
                                if (a.getLastUploadedDate() != null) {
                                    b.setLast_uploaded_date(DateUtils.timeStampToSecondsConverter(a.getLastUploadedDate()));
                                }

                                if (a.getIsActive()) {
                                    b.setIs_active(Short.valueOf((short) 1));
                                } else {
                                    b.setIs_active(Short.valueOf((short) 0));
                                }
                            }
                        })
                .register();
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
                                if (a.getClosure_date() != null) {
                                    b.setClosure_date(DateUtils.dateToSecondsConverter(a.getClosure_date()));
                                }
                                if (a.getAccount_opening_date() != null) {
                                    b.setAccount_opening_date(DateUtils.dateToSecondsConverter(a.getAccount_opening_date()));
                                }
                                if (a.getAccount_linkage_date() != null) {
                                    b.setAccount_linkage_date(DateUtils.dateToSecondsConverter(a.getAccount_linkage_date()));
                                }
                                if (a.getLast_uploaded_date() != null) {
                                    b.setLast_uploaded_date(DateUtils.timeStampToSecondsConverter(a.getLast_uploaded_date()));
                                }
                                if (a.getIs_default())
                                    b.setIs_default(Short.valueOf((short) 1));
                                else {
                                    b.setIs_default(Short.valueOf((short) 0));
                                }
                                if (a.getIs_active()) {
                                    b.setIs_active(Short.valueOf((short) 1));
                                } else {
                                    b.setIs_active(Short.valueOf((short) 0));
                                }
                            }
                        })
                .register();
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
                                if (a.getShg_formation_date() != null) {
                                    b.setShg_formation_date(DateUtils.dateToSecondsConverter(a.getShg_formation_date()));
                                }

                                //REVIVAL DATE
                                if (a.getShg_revival_date() != null) {
                                    b.setShg_revival_date(DateUtils.dateToSecondsConverter(a.getShg_revival_date()));
                                }


                                if (a.getIs_active()) {
                                    b.setIs_active(Short.valueOf((short) 1));
                                } else {
                                    b.setIs_active(Short.valueOf((short) 0));
                                }
                                if (a.getAccount_books_maintained())
                                    b.setAccount_books_maintained(Short.valueOf((short) 1));
                                else
                                    b.setAccount_books_maintained(Short.valueOf((short) 0));

                                if (a.getCash_book_start_date())
                                    b.setCash_book_start_date(Short.valueOf((short) 1));
                                else
                                    b.setCash_book_start_date(Short.valueOf((short) 0));
                                if (a.getBank_book_start_date())
                                    b.setBank_book_start_date(Short.valueOf((short) 1));
                                else
                                    b.setBank_book_start_date(Short.valueOf((short) 0));
                                if (a.getMembers_ledger_start_date().equals(Boolean.TRUE))
                                    b.setMembers_ledger_start_date(Short.valueOf((short) 1));
                                else
                                    b.setMembers_ledger_start_date(Short.valueOf((short) 0));
                                if (a.getBook4())
                                    b.setBook4(Short.valueOf((short) 1));
                                else
                                    b.setBook4(Short.valueOf((short) 0));
                                if (a.getBook5().equals(Boolean.TRUE))
                                    b.setBook5(Short.valueOf((short) 1));
                                else
                                    b.setBook5(Short.valueOf((short) 0));
                                //GRADING DONE ON
                                if (a.getGrading_done_on() != null) {
                                    b.setGrading_done_on(DateUtils.timeStampToSecondsConverter(a.getGrading_done_on()));
                                }

                                //CREATED On
                                if (a.getCreated_date() != null) {
                                    b.setCreated_date(DateUtils.timeStampToSecondsConverter(a.getCreated_date()));
                                }
                                if (a.getLast_uploaded_date() != null) {
                                    b.setLast_uploaded_date(DateUtils.timeStampToSecondsConverter(a.getLast_uploaded_date()));
                                }

                                if (a.getMicro_plan_prepared())
                                    b.setMicro_plan_prepared(Short.valueOf((short) 1));
                                else
                                    b.setMicro_plan_prepared(Short.valueOf((short) 0));

                                if (a.getBasic_shg_training())
                                    b.setBasic_shg_training(1);
                                else
                                    b.setBasic_shg_training(0);
                                if (a.getShg_cooption_date() != null) {
                                    b.setShg_cooption_date(DateUtils.dateToSecondsConverter(a.getShg_cooption_date()));
                                }

                                b.setIs_edited(0);

                                if (LookUpMasterEntity.activationLookupValPending.equals(a.getActivation_status())) {
                                    if (LookUpMasterEntity.approveLookupValReject.equals(a.getApprove_status())) {
                                        b.setView_status("New(Rejected)");
                                    } else {
                                        b.setView_status("New");
                                    }
                                } else {
                                    if (LookUpMasterEntity.approveLookupValPending.equals(shgProfileEntity.getApprove_status())) {
                                        b.setView_status("Modified");
                                    } else if (LookUpMasterEntity.approveLookupValAccept.equals(shgProfileEntity.getApprove_status())) {
                                        b.setView_status("Activated");
                                    } else if (LookUpMasterEntity.approveLookupValReject.equals(shgProfileEntity.getApprove_status())) {
                                        b.setView_status("Rejected");
                                    }
                                }

                            }
                        })
                .register();
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

                                if (a.getIsActive()) {
                                    b.setIs_active(Short.valueOf((short) 1));
                                } else {
                                    b.setIs_active(Short.valueOf((short) 0));
                                }
                            }
                        })
                .register();
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

                                if (a.getIsActive()) {
                                    b.setIs_active(Short.valueOf((short) 1));
                                } else {
                                    b.setIs_active(Short.valueOf((short) 0));
                                }
                            }
                        })
                .register();
        MapperFacade mapper = mapperFactory.getMapperFacade();
        return mapper.map(shgDesignationEntity, SHGDesignation.class);
    }

}
