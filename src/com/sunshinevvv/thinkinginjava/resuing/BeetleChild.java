package com.sunshinevvv.thinkinginjava.resuing;

/**
 * Created by 光 on 2016/8/27.
 */
class Insect {
    private int i = 9;
    protected int j;

    private static int x1 = printInit("static Insect.x1 initialized");

    static int printInit(String s) {
        System.out.println(s);
        return 47;
    }

    Insect() {
        System.out.println("i=" + i + ", j=" + j);
        j = 39;
    }
}

class Beetle extends Insect {
    private int k = printInit("Beetle.k initialized");

    private static int x2 =
            printInit("static Beetle.x2 initialized");

    public Beetle() {
        System.out.println("k = " + k);
        System.out.println("j = " + j);
    }

}

public class BeetleChild extends Beetle {
    private int l = printInit("BeetleChile.l initialized");

    private static int x3 =
            printInit("static BeetleChile.x3 initialized");

    public BeetleChild() {
        System.out.println("l = " + l);
        System.out.println("j = " + j);
    }

    public static void main(String[] args) {
        System.out.println("BeetleChild constructor");
        BeetleChild b = new BeetleChild();
    }
}