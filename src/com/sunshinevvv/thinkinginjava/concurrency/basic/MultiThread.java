package com.sunshinevvv.thinkinginjava.concurrency.basic;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * Created by 光 on 2017/2/9.
 */
public class MultiThread {
    public static void main(String[] args) {
        // 获取Java线程管理Bean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // dump线程信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println(threadInfo.getThreadId() + " " + threadInfo.getThreadName() + " " + threadInfo.getThreadState());
        }

    }
}
