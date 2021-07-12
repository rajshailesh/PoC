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
                            public void mapAtoB(CboPhoneNoDetailsEntity a, CBOPhoneNoDetails b, MappingContext context) {
                                if (a.getValid_from() != null) {
                                    b.setValid_from(DateUtils.dateToSecondsConverter(a.getValid_from()));
                                }
                                if (a.getValid_till() != null) {
                                    b.setValid_till(DateUtils.dateToSecondsConverter(a.getValid_till()));
                                }
                                if (a.getCreated_date() != null) {
                                    b.setCreated_date(DateUtils.timeStampToSecondsConverter(a.getCreated_date()));
                                }
                                if (a.getUpdated_date() != null) {
                                    b.setUpdated_date(DateUtils.timeStampToSecondsConverter(a.getUpdated_date()));
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
        return mapper.map(memberPhoneNoDetailsEntity, MemberPhoneNoDetails.class);
    }


    public static MemberAddresses map(final MemberAddressesDetailsEntity memberAddressesDetailsEntity) {
        mapperFactory.classMap(MemberAddressesDetailsEntity.class, MemberAddresses.class)
                .customize(
                        new CustomMapper<MemberAddressesDetailsEntity, MemberAddresses>() {
                            @SneakyThrows
                            public void mapAtoB(MemberPhoneNoDetailsEntity a, MemberAddresses b, MappingContext context) {
                                b.setIs_edited(0);
                                if (a.getCreated_date() != null) {
                                    b.setCreated_date(DateUtils.timeStampToSecondsConverter(a.getCreated_date()));
                                }
                                if (a.getUpdated_date() != null) {
                                    b.setUploaded_date(DateUtils.timeStampToSecondsConverter(a.getUpdated_date()));
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
                .register();
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
                                if (a.getAccount_open_date() != null) {
                                    b.setAccount_open_date(DateUtils.dateToSecondsConverter(a.getAccount_open_date()));
                                }
                                if (a.getClosing_date() != null) {
                                    b.setClosing_date(DateUtils.dateToSecondsConverter(a.getClosing_date()));
                                }
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
                .register();
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
                                if (a.getKyc_valid_from() != null) {
                                    b.setKyc_valid_from(DateUtils.dateToSecondsConverter(a.getKyc_valid_from()));
                                }
                                if (a.getKyc_valid_to() != null) {
                                    b.setKyc_valid_to(DateUtils.dateToSecondsConverter(a.getKyc_valid_to()));
                                }
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
                .register();
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
                                    b.setPip_Date(DateUtils.secondsToDateConverter(a.getPip_date()));
                                }
                                if (a.getDob() != null) {
                                    b.setDob(DateUtils.secondsToDateConverter(a.getDob()));
                                }
                                if (a.getAge_as_on() != null) {
                                    b.setAge_as_on(DateUtils.secondsToDateConverter(a.getAge_as_on()));
                                }
                                if (a.getJoining_date() != null) {
                                    b.setJoining_date(DateUtils.secondsToDateConverter(a.getJoining_date()));
                                }
                                if (a.getLeaving_date() != null) {
                                    b.setLeaving_date(DateUtils.secondsToDateConverter(a.getLeaving_date()));
                                }
                                if (a.getMarked_as_defaulter_date() != null) {
                                    b.setMarked_as_defaulter_date(DateUtils.secondsToDateConverter(a.getMarked_as_defaulter_date()));
                                }
                                if (a.getLast_sync_date() != null) {
                                    b.setLast_sync_date(DateUtils.secondsToTimestampConverter(a.getLast_sync_date()));
                                }
                                if (a.getUpdated_date() != null) {
                                    b.setUpdated_date(DateUtils.secondsToTimestampConverter(a.getUpdated_date()));
                                }
                                if (a.getCreated_date() != null) {
                                    b.setCreated_date(DateUtils.secondsToTimestampConverter(a.getCreated_date()));
                                }
                                b.setLast_uploaded_date(LocalDateTime.now());


                                if (Short.valueOf(String.valueOf(1)).equals(a.getIs_active())) {
                                    b.setIs_active(Boolean.TRUE);
                                } else {
                                    b.setIs_active(Boolean.FALSE);
                                }
                            }
                        })
                .register();
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
                                if (a.getPip_Date() != null) {
                                    b.setPip_date(DateUtils.dateToSecondsConverter(a.getPip_Date()));
                                }
                                if (a.getDob() != null) {
                                    b.setDob(DateUtils.dateToSecondsConverter(a.getDob()));
                                }
                                if (a.getAge_as_on() != null) {
                                    b.setAge_as_on(DateUtils.dateToSecondsConverter(a.getAge_as_on()));
                                }
                                if (a.getJoining_date() != null) {
                                    b.setJoining_date(DateUtils.dateToSecondsConverter(a.getJoining_date()));
                                }
                                if (a.getLeaving_date() != null) {
                                    b.setLeaving_date(DateUtils.dateToSecondsConverter(a.getLeaving_date()));
                                }
                                if (a.getMarked_as_defaulter_date() != null) {
                                    b.setMarked_as_defaulter_date(DateUtils.dateToSecondsConverter(a.getMarked_as_defaulter_date()));
                                }
                                if (a.getLast_sync_date() != null) {
                                    b.setLast_sync_date(DateUtils.timeStampToSecondsConverter(a.getLast_sync_date()));
                                }
                                if (a.getUpdated_date() != null) {
                                    b.setUpdated_date(DateUtils.timeStampToSecondsConverter(a.getUpdated_date()));
                                }
                                if (a.getCreated_date() != null) {
                                    b.setUploaded_date(DateUtils.timeStampToSecondsConverter(a.getLast_uploaded_date()));
                                }
                                if (a.getLast_uploaded_date() != null) {
                                    b.setCreated_date(DateUtils.timeStampToSecondsConverter(a.getCreated_date()));
                                }
                                if (a.getIs_active()) {
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
                .register();
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
                .register();
        MapperFacade mapper = mapperFactory.getMapperFacade();
        return mapper.map(memberSystemTagsEntity, MemberSystemTags.class);

    }

}
