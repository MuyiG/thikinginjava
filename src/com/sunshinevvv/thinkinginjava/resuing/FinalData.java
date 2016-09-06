package com.sunshinevvv.thinkinginjava.resuing;

import java.util.Random;

/**
 * Created by 光 on 2016/8/27.
 */
public class FinalData {
    public static Random random = new Random(48);

    private String id;

    // Conpile-time constants
    private final int valueOne = 9;
    private static final int VALUE_TWO = 99;
    public static final int VALUE_THREE = 39;

    // Cannot be compile-time constants
    private int i4 = random.nextInt(20);
    static final int INT_5 = random.nextInt(20); // final类型的变量也不一定可以再编译器确定值，这既是例证

    private Value v1 = new Value(11);
    private final Value v2 = new Value(22);
    private static final Value VALUE_3 = new Value(33);

    // Arrays
    private final int a[] = {1, 2, 3, 4, 5, 6};


    public FinalData(String id) {
        this.id = id;
    }

    public String toString() {
        return id + " i4=" + i4 + " i5=" + INT_5;
    }

    // final args
    public void withFinal(final int i) {
        // i++; // cannot do this
        int j = i + 1;
    }

    // 感觉把引用设置为final没卵用啊。。
    public void withFinal(final Value value) {
        // value =new Value(0); // cannot do this
        value.i++;
    }

    public static void main(String[] args) {
        FinalData fd1 = new FinalData("fd1");
        // fd1.valueOne ++;  // cannot do this
        // fd1.VALUE_TWO = 100;
        // VALUE_THREE, INT_5同理

        fd1.i4++;

        // fd1.v2 = new Value(12); // cannot do this
        System.out.println("fd1.v2.i=" + fd1.v2.i);
        fd1.v1 = fd1.v2;
        fd1.v1.i++;
        System.out.println("fd1.v2.i=" + fd1.v2.i); // v2的i值成功被修改，即：v2所引用的对象是可变的

        // fd1.a = new int[3]; // cannot do this
        for (int i = 0; i < fd1.a.length; i++) {
            fd1.a[i]++; // 数组也是引用
        }

        System.out.println(fd1);
        System.out.println("Creating new FinalData");
        FinalData fd2 = new FinalData("fd2");
        System.out.println(fd2);

    }
}

class Value {
    int i;

    public Value(int i) {
        this.i = i;
    }
}
