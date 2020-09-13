package com.javase;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @Description:
 * @Author: zl
 * @date: 2020/9/10
 */
public class TimeDemo {
    public static void main(String[] args) {
        //An instantaneous point on the time-line.(时间线上的一个瞬时点。)
        Date date = new Date();
        Instant instant = date.toInstant();
        //A time-zone ID, such as {@code Europe/Paris}.(时区)
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        LocalDateTime now = LocalDateTime.now();
    }
}
