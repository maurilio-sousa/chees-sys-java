package chess;

import boardgame.Board;

public class ChessMatch { // hearth of my system chess
	private Board board;
	
	public ChessMatch() {
		board = new Board(8,8); // dimension board
	}
	
	public ChessPiece[][] getPieces(){ // return one matrix of chess pieces for this match
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		
		for (int i=0;i<board.getRows();i++) { // travel rows in matrix
			for (int j=0;j<board.getColumns();j++) { // travel columns in matrix
				mat[i][j] = (ChessPiece) board.piece(i,j); // Downcasting
			}
		}
		return mat; // return my parts matrix
	}
}
