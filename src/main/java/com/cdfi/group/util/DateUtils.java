package com.cdfi.group.util;



import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

public class DateUtils {

//DATE
public static Date secondsToDateConverter(Integer seconds){
    if(seconds!=0 && seconds!=null){
        long millis = seconds;
        LocalDateTime date = LocalDateTime.ofEpochSecond(millis, 0, ZoneOffset.UTC);
       Date out = Date.from(date.atZone(ZoneId.systemDefault()).toInstant());
        return out;
    }
    else
    return null;
}

    public static Integer dateToSecondsConverter(Date date) throws ParseException {

        LocalDateTime dateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        if(dateTime!=null) {
            long ldt = dateTime.toEpochSecond(ZoneOffset.UTC);
            Integer intDate = (int) ldt;
            return intDate;
        }
        else
            return 0;

    }
    //TIMESTAMP
    public static LocalDateTime secondsToTimestampConverter(Integer seconds) {
        if(seconds!=0) {
            long millis = seconds;
            LocalDateTime date = LocalDateTime.ofEpochSecond(millis, 0, ZoneOffset.UTC);
            return date;
        }
        else
        return null;
    }

    public static Integer timeStampToSecondsConverter(LocalDateTime dateTime) throws ParseException {
        if(dateTime!=null) {
        long ldt = dateTime.toEpochSecond(ZoneOffset.UTC);
        Integer intDate = (int) ldt;
        return intDate;
            }
        else
            return 0;
        }
}
