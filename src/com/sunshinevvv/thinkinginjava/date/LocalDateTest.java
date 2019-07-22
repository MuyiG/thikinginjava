package com.sunshinevvv.thinkinginjava.date;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class LocalDateTest {
    public static void main(String[] args) {
        testUntil();
    }

    private static void testUntil() {
        LocalDate start = LocalDate.of(2018, 11, 20);
        LocalDate end = LocalDate.of(2018, 12, 6);
        System.out.println(start.until(end, ChronoUnit.DAYS));
        System.out.println(start.until(start, ChronoUnit.DAYS));
        System.out.println(end.until(start, ChronoUnit.DAYS));

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1544772832000L);
        LocalDate localDate = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));
        LocalDate now = LocalDate.now();
        System.out.println(localDate.until(now, ChronoUnit.DAYS));
    }
}
