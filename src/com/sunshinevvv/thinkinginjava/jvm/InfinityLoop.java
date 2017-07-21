package com.sunshinevvv.thinkinginjava.jvm;

/**
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * <p>
 * Created by 光 on 2017/4/1.
 */
public class InfinityLoop {

    public static void main(String[] args) {
        while (true) {
            try {
                byte[] bytes = new byte[1024 * 1024];
                System.out.println("looping...");
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
