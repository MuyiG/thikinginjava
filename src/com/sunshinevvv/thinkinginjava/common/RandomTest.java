package com.sunshinevvv.thinkinginjava.common;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by sunshine on 2017/9/18.
 */
public class RandomTest {

    private static Random random = new Random(47);

    public static void main(String[] args) {
//        Random random = new Random(47);
//        // 每次执行结果都是一样的：58、55、93、61、61、29、68、0、22、7。这就是伪随机。
//        for (int i = 0; i < 10; i++) {
//            System.out.println(random.nextInt(100));
//        }

        // 简单结论：永远使用ThreadLocalRandom
        int threads = 8, count = 10000000;
        getRandom(threads, count);
        getThreadLocalRandom(threads, count);
    }

    private static void getRandom(int threads, int count) {
        for (int i = 0; i < threads; i++) {
            new Thread(() -> {
                long begin = System.currentTimeMillis();
                for (int j = 0; j < count; j++) {
                    random.nextInt();
                }
                System.out.println("Random time cost:" + (System.currentTimeMillis() - begin));
            }, "Random-Thread-" + i).start();
        }
    }

    private static void getThreadLocalRandom(int threads, int count) {
        for (int i = 0; i < threads; i++) {
            new Thread(() -> {
                long begin = System.currentTimeMillis();
                for (int j = 0; j < count; j++) {
                    ThreadLocalRandom.current().nextInt();
                }
                System.out.println("ThreadLocalRandom time cost:" + (System.currentTimeMillis() - begin));
            }, "ThreadLocalRandom-Thread-" + i).start();
        }
    }
}
