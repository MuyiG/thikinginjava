package com.sunshinevvv.thinkinginjava.polymorphism.music;


/**
 * Created by 光 on 2016/8/30.
 */
public class Music {
    public static void tune(Instrument i) {
        // ...
        i.play(Note.MIDDLE_C);
    }

    public static void main(String[] args) {
        Wind flute = new Wind();
        tune(flute); // Upcasting
    }
}
