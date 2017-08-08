package com.sunshinevvv.thinkinginjava.polymorphism;

import com.sunshinevvv.thinkinginjava.polymorphism.music.Note;

/**
 * Created by 光 on 2016/9/6.
 */
abstract class Instrument {
    private int i; // Storage allocated for each

    abstract void play(Note note);

    String what() {
        return "Intrument";
    }

    abstract void adjust();
}

class Wind extends Instrument {
    void play(Note n) {
        System.out.println("Wind.play() " + n);
    }

    String what() {
        return "Wind";
    }

    void adjust() {
        System.out.println("Adjusting Wind");
    }
}

class Percussion extends Instrument {
    void play(Note n) {
        System.out.println("Precrussion.play() " + n);
    }

    String what() {
        return "Percussion";
    }

    void adjust() {
        System.out.println("Adjusting Percussion");
    }
}

class Stringed extends Instrument {
    void play(Note n) {
        System.out.println("Stringed.play() " + n);
    }

    String what() {
        return "Stringed";
    }

    void adjust() {
        System.out.println("Adjusting Stringed");
    }
}

class Brass extends Wind {
    void play(Note n) {
        System.out.println("Brass.play() " + n);
    }

    void adjust() {
        System.out.println("Adjusting Brass");
    }
}

class Woodwind extends Wind {
    void play(Note n) {
        System.out.println("Woodwind.play() " + n);
    }

    String what() {
        return "Woodwind";
    }
}

public class Music4 {
    // Doesn’t care about type, so new types added to the system still work right:
    public static void tune(Instrument i) {
        System.out.println(i.what());
        i.adjust();
        i.play(Note.MIDDLE_C);
    }

    public static void tuneAll(Instrument[] e) {
        for (Instrument i : e) {
            tune(i);
        }
    }

    public static void main(String[] args) {
        // Upcasting during addition to the array:
        Instrument[] orchestra = {new Wind(),
                new Percussion(), new Stringed(), new Brass(), new Woodwind()
        };

        tuneAll(orchestra);
    }
}
