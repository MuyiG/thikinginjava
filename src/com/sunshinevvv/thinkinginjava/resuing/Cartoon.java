package com.sunshinevvv.thinkinginjava.resuing;

/**
 * Created by 光 on 2016/8/24.
 */

class Art {

    Art() {
        System.out.println("Art constructor");
    }
}

class Drawing extends Art {
    Drawing() {
        System.out.println("Drawing constructor");
    }
}

public class Cartoon extends Drawing {
//    public Cartoon() {
//        System.out.println("Cartoon constructor");
//    }

    public Cartoon(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        Cartoon x = new Cartoon("Cartoon");
    }
}

