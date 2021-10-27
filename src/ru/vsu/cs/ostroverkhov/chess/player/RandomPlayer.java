package ru.vsu.cs.ostroverkhov.chess.player;

import java.util.ArrayList;
import java.util.Random;


import ru.vsu.cs.ostroverkhov.chess.Move;
import ru.vsu.cs.ostroverkhov.chess.Board;


public class RandomPlayer extends Player {
    Random rand;

    public RandomPlayer(boolean color) {
        super(color);
        rand = new Random();
    }


    public Move getNextMove(Board b) {
        ArrayList<Move> moves = b.getMoves(color);
        int n = moves.size();

        if (n == 0)
            return null;
        int k = rand.nextInt(n);
        return moves.get(k);
    }

}
