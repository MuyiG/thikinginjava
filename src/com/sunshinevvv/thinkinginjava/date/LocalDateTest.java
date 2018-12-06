package com.sunshinevvv.thinkinginjava.date;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LocalDateTest {
    public static void main(String[] args) {
        testUntil();
    }

    private static void testUntil() {
        LocalDate start = LocalDate.of(2018, 11, 20);
        LocalDate end = LocalDate.of(2018, 12, 6);
        System.out.println(start.until(start, ChronoUnit.DAYS));
        System.out.println(start.until(end, ChronoUnit.DAYS));

    }
}
