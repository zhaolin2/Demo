package com.sinozo.util;

import com.sun.istack.internal.NotNull;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

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
    public static Long convertTimeToLong(@NotNull String timeStr) {
        DateTimeFormatter ftf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime parse = LocalDateTime.parse(timeStr, ftf);
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

//    public static List<LocalDate> getMonthLocalDate(int month){
//        List<LocalDate> days = Stream.iterate(start, d -> d.plusDays(1)).limit(distance + 1).collect(toList());
//    }

    private TemporalAccessor getTemporalAccessorFromPattern(String pattern){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return formatter.parse("2020年10月");
    }


    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        TemporalAccessor parse = formatter.parse("2020年10月");

        System.out.println(parse);
        parse.get(ChronoField.YEAR);
        parse.get(ChronoField.MONTH_OF_YEAR);

//        parse.get(ChronoField.DAY_OF_MONTH);
    }



}
