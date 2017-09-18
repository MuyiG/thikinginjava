package com.sunshinevvv.thinkinginjava.common;

import java.util.Random;

/**
 * Created by sunshine on 2017/9/18.
 */
public class RandomTest {
    public static void main(String[] args) {
        Random random = new Random(47);
        // 每次执行结果都是一样的：58、55、93、61、61、29、68、0、22、7
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(100));
        }
    }
}
