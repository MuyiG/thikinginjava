package com.sunshinevvv.thinkinginjava.strings;

/**
 * Created by sunshine on 2017/8/14.
 */
public class SplitString {
    public static void main(String[] args) {
        new SplitString().testPerformance();
    }

    public void testPerformance() {
        int lineNum = 1000000;
        String largeString = buildLargeString(lineNum);
        System.out.println("line number: " + lineNum);

        long start, end;
        String firstLine;

        start = System.currentTimeMillis();
        String[] arr = largeString.split("\n");
        firstLine = arr[0];
        firstLine.contains("non_existing1");
        firstLine.contains("non_existing2");
        firstLine.contains("non_existing3");
        end = System.currentTimeMillis();
        System.out.println("split + contains*3 time cost (ms): " + (end - start));

        start = System.currentTimeMillis();
        largeString.contains("non_existing1");
        largeString.contains("non_existing2");
        largeString.contains("non_existing3");
        end = System.currentTimeMillis();
        System.out.println("directly contains*3 time cost (ms): " + (end - start));

        start = System.currentTimeMillis();
        firstLine = largeString.substring(0, largeString.indexOf("\n"));
        firstLine.contains("non_existing1");
        firstLine.contains("non_existing2");
        firstLine.contains("non_existing3");
        end = System.currentTimeMillis();
        System.out.println("substring + contains*3 time cost (ms): " + (end - start));
    }

    private String buildLargeString(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < num; i++) {
            stringBuilder.append("test_email" + i + "@zoom.us\n");
        }
        return stringBuilder.toString();
    }
}
