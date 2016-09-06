package com.sunshinevvv.thinkinginjava.resuing;

/**
 * Created by 光 on 2016/8/27.
 */
public class BlankFinal {
    private final int i = 0; // Initialized final
    private final int j; // Blank final
    private final Poppet p; // Blank final reference

    // Blank finals MUST be initialized in the constructor:
    // 如下的两个构造函数少了任意一句编译器都会报错
    public BlankFinal() {
        j = 1; // Initialize blank final
        p = new Poppet(1); // Initialize blank final reference
    }

    public BlankFinal(int x) {
        j = x; // Initialize blank final
        p = new Poppet(x); // Initialize blank final reference
    }

    public static void main(String[] args) {
        new BlankFinal();
        new BlankFinal(47);
    }
}

class Poppet {
    private int i;

    Poppet(int ii) {
        i = ii;
    }
}
