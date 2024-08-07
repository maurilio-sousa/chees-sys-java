package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece{

	public Rook(Board board, Color color) { // inform color, and board
		super(board, color);
	}
	
	@Override
	public String toString() { // print R in the board
		return "R"; 
	}
	
}
