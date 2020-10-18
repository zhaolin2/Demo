package com.util;

import com.sun.istack.internal.NotNull;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: zl
 * @date: 2020/10/18
 */
public class TimeUtil {

    private  TimeUtil(){

    }

    /**
     * 将字符串转日期成Long类型的时间戳，格式为：yyyy-MM-dd HH:mm:ss
     */
    public static Long convertTimeToLong(@NotNull String timestr) {
        DateTimeFormatter ftf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime parse = LocalDateTime.parse(timestr, ftf);
        return LocalDateTime.from(parse).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * 将Long类型的时间戳转换成String 类型的时间格式，时间格式为：yyyy-MM-dd HH:mm:ss
     */
    public static String convertTimeToString(@NotNull Long time){
        DateTimeFormatter ftf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return ftf.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(time),ZoneId.systemDefault()));
    }

    public static LocalDateTime dateToLocalDateTime(Date date) {
        return dateToLocalDateTime(date,ZoneId.systemDefault());
    }
    /**
     *     将Date转换为LocalDatetime
     */
    public static LocalDateTime dateToLocalDateTime(Date date,ZoneId zoneId) {
        Instant instant = date.toInstant();
        return instant.atZone(zoneId).toLocalDateTime();
    }

    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
       return localDateTimeToDate(localDateTime,ZoneId.systemDefault());
    }
    /**
     *  将LocalDateTime转换回java.util.Date：
     * 1.使用atZone（）方法将LocalDateTime转换为ZonedDateTime
     2.将ZonedDateTime转换为Instant，并从中获取Date
     */
    public static Date localDateTimeToDate(LocalDateTime localDateTime,ZoneId zoneId) {
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        return Date.from(zdt.toInstant());
    }




}
