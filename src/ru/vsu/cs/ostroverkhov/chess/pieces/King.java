package ru.vsu.cs.ostroverkhov.chess.pieces;

import java.util.ArrayList;

import ru.vsu.cs.ostroverkhov.chess.Board;
import ru.vsu.cs.ostroverkhov.chess.Move;


public class King extends Piece {
	boolean hasMoved = false;

	public King(boolean color) {
		super(color);
		value = 0;
	}

	public King(boolean color, boolean hasMoved) {
		super(color);
		this.hasMoved = hasMoved;
		value = 0;
	}

	public King clone() {
		return new King(color, hasMoved);
	}

	public String toString() {
		if (color == Piece.WHITE)
			return "K";
		else
			return "k";
	}

	public ArrayList<Move> getMoves(Board b, int x, int y) {
		ArrayList<Move> moves = new ArrayList<Move>();

		// N
		if (valid(x, y + 1) &&
				(!b.getTile(x, y + 1).isOccupied() ||
						(b.getTile(x, y + 1).isOccupied() && b.getTile(x, y + 1).getPiece().getColor() != color)))
			moves.add(new Move(x, y, x, y + 1));

		// NE
		if (valid(x + 1, y + 1) &&
				(!b.getTile(x + 1, y + 1).isOccupied() ||
						(b.getTile(x + 1, y + 1).isOccupied() && b.getTile(x + 1, y + 1).getPiece().getColor() != color)))
			moves.add(new Move(x, y, x + 1, y + 1));

		// E
		if (valid(x + 1, y) &&
				(!b.getTile(x + 1, y).isOccupied() ||
						(b.getTile(x + 1, y).isOccupied() && b.getTile(x + 1, y).getPiece().getColor() != color)))
			moves.add(new Move(x, y, x + 1, y));


		// SE
		if (valid(x + 1, y - 1) &&
				(!b.getTile(x + 1, y - 1).isOccupied() ||
						(b.getTile(x + 1, y - 1).isOccupied() && b.getTile(x + 1, y - 1).getPiece().getColor() != color)))
			moves.add(new Move(x, y, x + 1, y - 1));

		// S
		if (valid(x, y - 1) &&
				(!b.getTile(x, y - 1).isOccupied() ||
						(b.getTile(x, y - 1).isOccupied() && b.getTile(x, y - 1).getPiece().getColor() != color)))
			moves.add(new Move(x, y, x, y - 1));

		// SW
		if (valid(x - 1, y - 1) &&
				(!b.getTile(x - 1, y - 1).isOccupied() ||
						(b.getTile(x - 1, y - 1).isOccupied() && b.getTile(x - 1, y - 1).getPiece().getColor() != color)))
			moves.add(new Move(x, y, x - 1, y - 1));

		// W
		if (valid(x - 1, y) &&
				(!b.getTile(x - 1, y).isOccupied() ||
						(b.getTile(x - 1, y).isOccupied() && b.getTile(x - 1, y).getPiece().getColor() != color)))
			moves.add(new Move(x, y, x - 1, y));

		// NW
		if (valid(x - 1, y + 1) &&
				(!b.getTile(x - 1, y + 1).isOccupied() ||
						(b.getTile(x - 1, y + 1).isOccupied() && b.getTile(x - 1, y + 1).getPiece().getColor() != color)))
			moves.add(new Move(x, y, x - 1, y + 1));

		// Castling
		if (color == Piece.WHITE) {
			if (!hasMoved && x == Board.e && y == 0) {
				if (!b.getTile(Board.f, 0).isOccupied() &&
						!b.getTile(Board.g, 0).isOccupied() &&
						b.getTile(Board.h, 0).isOccupied() &&
						b.getTile(Board.h, 0).getPiece().toString().equals("R"))
					moves.add(new Move(x, y, x + 2, y));


			} else
				hasMoved = true;
		} else {
			if (!hasMoved && x == Board.e && y == 7) {

			} else
				hasMoved = true;
		}

		return moves;
	}
}
