package ru.vsu.cs.ostroverkhov.chess.player;

import ru.vsu.cs.ostroverkhov.chess.Move;
import ru.vsu.cs.ostroverkhov.chess.Board;

public abstract class Player {

    protected boolean color;

    public Player(boolean color) {
        this.color = color;
    }


    public Move getNextMove(Board b) {
        return null;
    }

    public boolean getColor() {
        return color;
    }

}
