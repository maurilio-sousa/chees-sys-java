package chess;

import boardgame.Board;
import boardgame.BoardException;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch { // hearth of my system chess
	private int turn;
	private Color currentPlayer;
	private Board board;
	
	public ChessMatch() { // method for initial board and show pieces on my board
		board = new Board(8,8); // dimension board
		turn = 1;
		currentPlayer = Color.WHITE; // chess the white pieces start
		initialSetup(); 
	}
	
	public int getTurn() {
		return turn;
	}
	
	public Color getCurrentPlayer() {
		return currentPlayer;
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
	
	public boolean [][] possibleMoves(ChessPosition sourcePosition){
		Position position = sourcePosition.toPosition();
		validateSourcePosition(position);
		return board.piece(position).possibleMoves();
	}
	
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition(source);
		validateTargetPosition(source,target);
		Piece capturePiece = makeMove(source, target);
		nextTurn();
		return (ChessPiece)capturePiece;
	}
	
	private Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source);
		Piece captuedPiece = board.removePiece(target);
		board.placePiece(p, target);
		return captuedPiece;
	}
	
	private void validateSourcePosition(Position position) {
		if(!board.thereIsAPiece(position)) {
			throw new ChessException("There is no piece on source position");
		}
		if(currentPlayer != ((ChessPiece)board.piece(position)).getColor()) // down casting | if this color != current color. piece enemy
			throw new ChessException("The chosen piece is not yours");
		if(!board.piece(position).isThereAnyPossibleMove()) {
			throw new ChessException("There is no possible moves for the chosen piece");
		}
	}
	
	public void validateTargetPosition(Position source, Position target) {
		if(!board.piece(source).possibleMove(target)) {
			throw new ChessException("The chosen piece can't move to target position");
		}
	}
	
	private void nextTurn() {
		turn++;
		currentPlayer = (currentPlayer == Color.BLACK) ? Color.WHITE : Color.BLACK; // Change players in turns
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
