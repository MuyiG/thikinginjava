package com.sunshinevvv.thinkinginjava.concurrency;

/**
 * Created by sunshine on 2017/2/7.
 * 重排序对多线程的影响，来源《Java并发编程的艺术》，但是这里并没有显示出重排序的迹象啊
 */
public class ReorderExample {
    int a = 0;
    boolean flag = false;

    static ReorderExample reorderExample = new ReorderExample();

    public void write() {
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        a = 1;
        flag = true;
    }

    public void read() {
        if (flag) {
            System.out.println("a=" + a);
        } else {
            System.out.println("Not written yet.");
        }
    }


    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                reorderExample.write();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                reorderExample.read();
            }
        });
        thread1.start();
        thread2.start();
    }
}
