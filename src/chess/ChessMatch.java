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
	private void initialSetup() { // method responsible for fixing the pieces on my board
		board.placePiece(new Rook(board,Color.WHITE), new Position(2,1));
		board.placePiece(new King (board,Color.BLACK), new Position(7,4));
		board.placePiece(new King(board,Color.WHITE), new Position(0,4));
	}
}