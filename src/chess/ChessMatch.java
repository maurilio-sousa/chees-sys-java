package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch { // hearth of my system chess
	private Board board;
	
	public ChessMatch() { // method for initial board and show pieces on my board
		board = new Board(8,8); // dimension board
		initialSetup(); 
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
	
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	private void initialSetup() { // method responsible for fixing the pieces on my board
		placeNewPiece('c', 1, new Rook(board,Color.WHITE));
		placeNewPiece('c', 2, new Rook (board,Color.WHITE));
		placeNewPiece('d', 2, new Rook(board,Color.WHITE));
		placeNewPiece('e', 2, new Rook(board,Color.WHITE));
		placeNewPiece('e', 1, new Rook(board,Color.WHITE));
		placeNewPiece('d', 1, new King(board,Color.WHITE));
		
		placeNewPiece('c', 7, new Rook(board, Color.BLACK));
		placeNewPiece('c', 8, new Rook(board, Color.BLACK));
		placeNewPiece('d', 7, new Rook(board, Color.BLACK));
		placeNewPiece('e', 7, new Rook(board, Color.BLACK));
		placeNewPiece('e', 8, new Rook(board, Color.BLACK));
		placeNewPiece('d', 8, new King(board, Color.BLACK));
	}
}
