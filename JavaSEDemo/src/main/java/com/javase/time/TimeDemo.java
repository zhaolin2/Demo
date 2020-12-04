package com.javase.time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.Date;

/**
 * @Description:
 * @Author: zl
 * @date: 2020/10/18
 */
public class TimeDemo {
    public static void main(String[] args) {

    }

    private LocalDateTime minusDay(int dayCount){
        return LocalDateTime.now().minusDays(dayCount);
    }
}
