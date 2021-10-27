package ru.vsu.cs.ostroverkhov.chess;

import ru.vsu.cs.ostroverkhov.chess.pieces.Piece;
import ru.vsu.cs.ostroverkhov.chess.player.Player;
import ru.vsu.cs.ostroverkhov.chess.player.RandomPlayer;


public class Chess {

	public static void main(String[] args) {
		int iterator = 3;
		float player1Score = 0, player2Score = 0;
		int draw = 0;
		for (int i = 0; i < iterator; i++) {
			Board board = new Board();
			System.out.println(board);
			Player player1 = new RandomPlayer(Piece.WHITE);
			Player player2 = new RandomPlayer(Piece.BLACK);

			int winner = play(player1, player2, board);

			if (winner == 1)
				player1Score++;
			if (winner == 0) {
				player1Score += 0.5f;
				player2Score += 0.5f;
				draw++;
			}
			if (winner == -1) {
				player2Score++;
			}
		}

		outputOfWinner(player1Score, player2Score, draw);
	}

	public static int play(Player player1, Player player2, Board b) {
		Move move;
		int result;
		int turn = 0;
		while (true) {
			if (turn++ > 300) {
				return 0;
			}

			move = player1.getNextMove(b);
			if (move == null && b.isCheck(player1.getColor()))
				return -1;
			if (move == null)
				return 0;

			result = b.makeMove(move);
			System.out.println(b);
			if (result == -1) return (player1.getColor() == Piece.BLACK) ? -1 : 1;
			if (result == 1) return (player1.getColor() == Piece.WHITE) ? 1 : -1;


			move = player2.getNextMove(b);
			if (move == null && b.isCheck(player2.getColor())) // check and can't move
				return 1;
			if (move == null)
				return 0;

			result = b.makeMove(move);
			System.out.println(b);
			if (result == -1) return (player1.getColor() == Piece.BLACK) ? 1 : -1;
			if (result == 1) return (player1.getColor() == Piece.WHITE) ? -1 : 1;

		}
	}

	public static void outputOfWinner(float player1Score, float player2Score, int draw) {
		System.out.println("Quantity of score of white player = " + player1Score);
		System.out.println("Quantity of score of black player = " + player2Score);
		System.out.println("Quantity of draws = " + draw);
	}

}
