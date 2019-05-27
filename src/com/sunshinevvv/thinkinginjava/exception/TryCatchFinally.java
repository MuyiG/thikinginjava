package com.sunshinevvv.thinkinginjava.exception;

public class TryCatchFinally {

    private int i;

    public static void main(String[] args) {
        System.out.println(test2());
    }

    public static int test() {
        int x = 0;
        try {
            System.out.println("try");
            x = 1;
            x = x / 0;
            return x;
        } catch (Exception e) {
            System.out.println("catch");
            x = 2;
            return x;
        } finally {
            x = 3; // return 语句保存好要返回的值之后，再执行finally，因此这里修改x是无意义的
            System.out.println("finally");
        }
    }

    public static TryCatchFinally test2() {
        TryCatchFinally t = new TryCatchFinally();
        try {
            System.out.println("try");
            t.i = 1;
            t.i = t.i / 0;
            return t;
        } catch (Exception e) {
            System.out.println("catch");
            t.i = 2;
            return t;
        } finally {
            t.i = 3; // 引用类型的修改则是可以生效的
            System.out.println("finally");
        }
    }

    @Override
    public String toString() {
        return "i=" + i;
    }
}
