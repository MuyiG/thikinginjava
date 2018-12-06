package com.sunshinevvv.thinkinginjava.date;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * <p>文件描述：</p>
 * <p>版权所有： 版权所有(C)2011-2099</p>
 * <p>公   司： 口袋购物</p>
 * <p>其他说明：</p>
 * <p>作   者：杨光</p>
 * <p>完成日期：2018/12/6</p>
 */
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
