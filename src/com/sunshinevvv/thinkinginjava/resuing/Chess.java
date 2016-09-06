package com.sunshinevvv.thinkinginjava.resuing;

/**
 * Created by 光 on 2016/8/24.
 */
class Game {
    Game() {
        System.out.println("Game()");
    }

    Game(int i) {
        System.out.println("Game(i)");
    }
}

class BoardGame extends Game {
    BoardGame(int i) {
//        super(i);
        System.out.println("BoardGame(i)");
    }
}

public class Chess extends BoardGame {
    Chess(int i) {
        super(i);
        System.out.println("Chess~");
    }

    public static void main(String[] args) {
        Chess chess = new Chess(1);
    }
}
