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

import java.text.ParseException;
import java.time.LocalDateTime;

public class MemberMapper {
    static MapperFactory mapperFactory = new DefaultMapperFactory.Builder()
            .build();

    public static MemberPhoneNoDetails map(final MemberPhoneNoDetailsEntity memberPhoneNoDetailsEntity) {
        mapperFactory.classMap(MemberPhoneNoDetailsEntity.class, MemberPhoneNoDetails.class)
                .customize(
                        new CustomMapper<MemberPhoneNoDetailsEntity, MemberPhoneNoDetails>() {
                            @SneakyThrows
                            public void mapAtoB(MemberPhoneNoDetailsEntity a, MemberPhoneNoDetails b, MappingContext context) {
                                b.setIs_edited(0);
                                if (a.getValidFrom() != null) {
                                    b.setValid_from(DateUtils.dateToSecondsConverter(a.getValidFrom()));
                                }
                                if (a.getValidTill() != null) {
                                    b.setValid_till(DateUtils.dateToSecondsConverter(a.getValidTill()));
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
        return mapper.map(memberPhoneNoDetailsEntity, MemberPhoneNoDetails.class);
    }


    public static MemberAddresses map(final MemberAddressesDetailsEntity memberAddressesDetailsEntity) {
        mapperFactory.classMap(MemberAddressesDetailsEntity.class, MemberAddresses.class)
                .customize(
                        new CustomMapper<MemberAddressesDetailsEntity, MemberAddresses>() {
                            @SneakyThrows
                            public void mapAtoB(MemberPhoneNoDetailsEntity a, MemberAddresses b, MappingContext context) {
                                b.setIs_edited(0);
                                if (a.getCreatedDate() != null) {
                                    b.setCreated_date(DateUtils.timeStampToSecondsConverter(a.getCreatedDate()));
                                }
                                if (a.getUpdatedDate() != null) {
                                    b.setUploaded_date(DateUtils.timeStampToSecondsConverter(a.getUpdatedDate()));
                                }
                                if (a.getLastUploadedDate() != null) {
                                    b.setUploaded_date(DateUtils.timeStampToSecondsConverter(a.getLastUploadedDate()));
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
        return mapper.map(memberAddressesDetailsEntity, MemberAddresses.class);

    }


    public static MemberBank map(final MemberBankDetailsEntity memberBankDetailsEntity) {
        mapperFactory.classMap(MemberBankDetailsEntity.class, MemberBank.class)
                .customize(
                        new CustomMapper<MemberBankDetailsEntity, MemberBank>() {
                            @SneakyThrows
                            public void mapAtoB(MemberBankDetailsEntity a, MemberBank b, MappingContext context) {
                                b.setIs_edited(0);
                                if (a.getAccountOpenDate() != null) {
                                    b.setAccount_open_date(DateUtils.dateToSecondsConverter(a.getAccountOpenDate()));
                                }
                                if (a.getClosingDate() != null) {
                                    b.setClosing_date(DateUtils.dateToSecondsConverter(a.getClosingDate()));
                                }
                                if (a.getUpdatedDate() != null) {
                                    b.setUpdated_date(DateUtils.timeStampToSecondsConverter(a.getUpdatedDate()));
                                }
                                if (a.getCreatedDate() != null) {
                                    b.setCreated_date(DateUtils.timeStampToSecondsConverter(a.getCreatedDate()));
                                }
                                if (a.getLastUploadedDate() != null) {
                                    b.setUploaded_date(DateUtils.timeStampToSecondsConverter(a.getLastUploadedDate()));
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
        return mapper.map(memberBankDetailsEntity, MemberBank.class);
    }


    public static MemberKYCDetails map(final MemberKYCDetailsEntity memberKYCDetailsEntity) {
        mapperFactory.classMap(MemberKYCDetailsEntity.class, MemberKYCDetails.class)
                .customize(
                        new CustomMapper<MemberKYCDetailsEntity, MemberKYCDetails>() {
                            @SneakyThrows
                            public void mapAtoB(MemberKYCDetailsEntity a, MemberKYCDetails b, MappingContext context) {
                                b.setIs_edited(0);
                                if (a.getKycValidFrom() != null) {
                                    b.setKyc_valid_from(DateUtils.dateToSecondsConverter(a.getKycValidFrom()));
                                }
                                if (a.getKycValidTo() != null) {
                                    b.setKyc_valid_to(DateUtils.dateToSecondsConverter(a.getKycValidTo()));
                                }
                                if (a.getUpdatedDate() != null) {
                                    b.setUpdated_date(DateUtils.timeStampToSecondsConverter(a.getUpdatedDate()));
                                }
                                if (a.getCreatedDate() != null) {
                                    b.setCreated_date(DateUtils.timeStampToSecondsConverter(a.getCreatedDate()));
                                }
                                if (a.getLastUploadedDate() != null) {
                                    b.setUploaded_date(DateUtils.timeStampToSecondsConverter(a.getLastUploadedDate()));
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
        return mapper.map(memberKYCDetailsEntity, MemberKYCDetails.class);
    }

    //SHG PROFILE
    public static MemberProfileEntity map(final MemberProfile memberProfile) {
        mapperFactory.classMap(MemberProfile.class, MemberProfileEntity.class)
                .customize(
                        new CustomMapper<MemberProfile, MemberProfileEntity>() {
                            @SneakyThrows
                            public void mapAtoB(MemberProfile a, MemberProfileEntity b, MappingContext context) {
                                if (a.getPip_date() != null) {
                                    b.setPipDate(DateUtils.secondsToDateConverter(a.getPip_date()));
                                }
                                if (a.getDob() != null) {
                                    b.setDateOfBirth(DateUtils.secondsToDateConverter(a.getDob()));
                                }
                                if (a.getAge_as_on() != null) {
                                    b.setAgeAsOn(DateUtils.secondsToDateConverter(a.getAge_as_on()));
                                }
                                if (a.getJoining_date() != null) {
                                    b.setJoiningDate(DateUtils.secondsToDateConverter(a.getJoining_date()));
                                }
                                if (a.getLeaving_date() != null) {
                                    b.setLeavingDate(DateUtils.secondsToDateConverter(a.getLeaving_date()));
                                }
                                if (a.getMarked_as_defaulter_date() != null) {
                                    b.setMarkedAsDefaulterDate(DateUtils.secondsToDateConverter(a.getMarked_as_defaulter_date()));
                                }
                                if (a.getLast_sync_date() != null) {
                                    b.setLastSyncDate(DateUtils.secondsToTimestampConverter(a.getLast_sync_date()));
                                }
                                if (a.getUpdated_date() != null) {
                                    b.setUpdatedDate(DateUtils.secondsToTimestampConverter(a.getUpdated_date()));
                                }
                                if (a.getCreated_date() != null) {
                                    b.setCreatedDate(DateUtils.secondsToTimestampConverter(a.getCreated_date()));
                                }
                                b.setLastUploadedDate(LocalDateTime.now());


                                if (Short.valueOf(String.valueOf(1)).equals(a.getIs_active())) {
                                    b.setIsActive(Boolean.TRUE);
                                } else {
                                    b.setIsActive(Boolean.FALSE);
                                }
                            }
                        })
                .byDefault().register();
        MapperFacade mapper = mapperFactory.getMapperFacade();
        return mapper.map(memberProfile, MemberProfileEntity.class);
    }

    public static MemberProfile map(final MemberProfileEntity memberProfileEntity) throws ParseException {
        mapperFactory.classMap(MemberProfileEntity.class, MemberProfile.class)
                .customize(
                        new CustomMapper<MemberProfileEntity, MemberProfile>() {
                            @SneakyThrows
                            public void mapAtoB(MemberProfileEntity a, MemberProfile b, MappingContext context) {
                                b.setIs_edited(0);
                                if (a.getPipDate() != null) {
                                    b.setPip_date(DateUtils.dateToSecondsConverter(a.getPipDate()));
                                }
                                if (a.getDateOfBirth() != null) {
                                    b.setDob(DateUtils.dateToSecondsConverter(a.getDateOfBirth()));
                                }
                                if (a.getAgeAsOn() != null) {
                                    b.setAge_as_on(DateUtils.dateToSecondsConverter(a.getAgeAsOn()));
                                }
                                if (a.getJoiningDate() != null) {
                                    b.setJoining_date(DateUtils.dateToSecondsConverter(a.getJoiningDate()));
                                }
                                if (a.getLeavingDate() != null) {
                                    b.setLeaving_date(DateUtils.dateToSecondsConverter(a.getLeavingDate()));
                                }
                                if (a.getMarkedAsDefaulterDate() != null) {
                                    b.setMarked_as_defaulter_date(DateUtils.dateToSecondsConverter(a.getMarkedAsDefaulterDate()));
                                }
                                if (a.getLastSyncDate() != null) {
                                    b.setLast_sync_date(DateUtils.timeStampToSecondsConverter(a.getLastSyncDate()));
                                }
                                if (a.getUpdatedDate() != null) {
                                    b.setUpdated_date(DateUtils.timeStampToSecondsConverter(a.getUpdatedDate()));
                                }
                                if (a.getCreatedDate() != null) {
                                    b.setUploaded_date(DateUtils.timeStampToSecondsConverter(a.getLastUploadedDate()));
                                }
                                if (a.getLastUploadedDate() != null) {
                                    b.setCreated_date(DateUtils.timeStampToSecondsConverter(a.getCreatedDate()));
                                }
                                if (a.getIsActive()) {
                                    b.setIs_active(Short.valueOf((short) 1));
                                } else {
                                    b.setIs_active(Short.valueOf((short) 0));
                                }
                                if (a.getMem_activation_status() != null && a.getMem_activation_status().
                                        equals(LookUpMasterEntity.activationLookupValPending)) {
                                    if (a.getApprove_status() != null &&
                                            a.getApprove_status().equals(LookUpMasterEntity.approveLookupValReject)) {
                                        b.setView_status("New(Rejected)");
                                    } else {
                                        b.setView_status("New");
                                    }
                                } else {
                                    if (a.getApprove_status() != null && a.getApprove_status().
                                            equals(LookUpMasterEntity.approveLookupValPending)) {
                                        b.setView_status("Modified");
                                    } else if (a.getApprove_status() != null && memberProfileEntity.getApprove_status().
                                            equals(LookUpMasterEntity.approveLookupValAccept)) {
                                        b.setView_status("Activated");
                                    } else if (a.getApprove_status() != null && a.getApprove_status().
                                            equals(LookUpMasterEntity.approveLookupValReject)) {
                                        b.setView_status("Rejected");
                                    }
                                }

                            }
                        })
                .byDefault().register();
        MapperFacade mapper = mapperFactory.getMapperFacade();
        return mapper.map(memberProfileEntity, MemberProfile.class);

    }
    public static MemberSystemTags map(final MemberSystemTagsEntity memberSystemTagsEntity) {
        mapperFactory.classMap(MemberSystemTagsEntity.class, MemberSystemTags.class)
                .customize(
                        new CustomMapper<MemberSystemTagsEntity, MemberSystemTags>() {
                            @SneakyThrows
                            public void mapAtoB(MemberSystemTagsEntity a, MemberSystemTags b, MappingContext context) {
                                b.setIs_edited(0);
                                if (a.getUpdated_date() != null) {
                                    b.setUpdated_date(DateUtils.timeStampToSecondsConverter(a.getUpdated_date()));
                                }
                                if (a.getCreated_date() != null) {
                                    b.setCreated_date(DateUtils.timeStampToSecondsConverter(a.getCreated_date()));
                                }
                                if (a.getLast_uploaded_date() != null) {
                                    b.setUploaded_date(DateUtils.timeStampToSecondsConverter(a.getLast_uploaded_date()));
                                }
                                if (a.getIs_active()) {
                                    b.setIs_active(Short.valueOf((short) 1));
                                } else {
                                    b.setIs_active(Short.valueOf((short) 0));
                                }
                            }
                        })
                .byDefault().register();
        MapperFacade mapper = mapperFactory.getMapperFacade();
        return mapper.map(memberSystemTagsEntity, MemberSystemTags.class);

    }

}
