package com.sunshinevvv.thinkinginjava.polymorphism.music;

/**
 * Created by 光 on 2016/8/30.
 */
public class Wind extends Instrument {
    @Override
    public void play(Note note) {
        System.out.println("Wind.play() " + note);
    }
}
