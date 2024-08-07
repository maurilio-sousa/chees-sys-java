package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece{

	public King(Board board, Color color) { // the same method for rook but now is king
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "K";
	}
}
