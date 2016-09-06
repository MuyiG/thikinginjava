package com.sunshinevvv.thinkinginjava.polymorphism.music3;

import com.sunshinevvv.thinkinginjava.polymorphism.music.Note;

/**
 * Created by 光 on 2016/9/6.
 */
class Instrument {
    void play(Note note) {
        System.out.println(what() + ".play() " + note);
    }

    String what() {
        return "Intrument";
    }

    void adjust() {
        System.out.println("Adjusting Intrument");
    }
}

class Wind extends Instrument {

    String what() {
        return "Wind";
    }

    void adjust() {
        System.out.println("Adjusting Wind");
    }
}

class Percussion extends Instrument {

    String what() {
        return "Percussion";
    }

    void adjust() {
        System.out.println("Adjusting Percussion");
    }
}

class Stringed extends Instrument {

    String what() {
        return "Stringed";
    }

    void adjust() {
        System.out.println("Adjusting Stringed");
    }
}

class Brass extends Wind {

    void adjust() {
        System.out.println("Adjusting Brass");
    }
}

class Woodwind extends Wind {

    String what() {
        return "Woodwind";
    }
}

public class Music3 {
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
