package com.javase.date;

import java.time.*;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.TimeZone;

/**
 * 时间是分时区的 GMT或者UTC
 * 所以需要使用locale来表示本地时间
 *  zh_CN：2016-11-30
 * en_US：11/30/2016
 *
 * Epoch Time是计算从1970年1月1日零点（格林威治时区／GMT+00:00）到现在所经历的秒数
 *  也被称为时间戳 会使用秒/毫秒  long类型 毫秒表示
 *
 *  Calendar 可以设置年月日  可以做简单的日期和时间运算  提供了时区转换的功能
 *
 *  时区使用TimeZone来表示  会有一个时区id ZoneId
 *
 *  localdatetime 没有办法和毫秒值来进行转化 因为没有时区信息
 *
 *  Duration localdatetime
 *  Period localdate
 *
 *  zonedatetime
 */
public class LocalDateTimeDemo {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();

        //获取当天第一秒和最后一秒
        LocalDate.now().withDayOfMonth(1).atStartOfDay();
        LocalDateTime.of(localDateTime.toLocalDate(), LocalTime.MIN);

        //获取当月第一天
        localDateTime.with(TemporalAdjusters.firstDayOfMonth());

        ZoneId zoneId = ZoneId.systemDefault();
        TimeZone zone=TimeZone.getDefault();

        // 下月第1天:
        LocalDate nextMonthFirstDay = LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth());

        // 本月第1个周一:
        LocalDate firstWeekday = LocalDate.now().with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        System.out.println(firstWeekday);

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
//        ZonedDateTime zonedDateTime1 = localDateTime.atZone(ZoneId.systemDefault());
        zonedDateTime.toLocalDateTime();

        //当前时刻
        Instant instant = Instant.now();
        instant.getEpochSecond(); // 秒
        instant.toEpochMilli(); // 毫秒


        Date date = Date.from( localDateTime.atZone( ZoneId.systemDefault()).toInstant());
        LocalDateTime ldt = date.toInstant()
                .atZone( ZoneId.systemDefault() )
                .toLocalDateTime();


    }
}
