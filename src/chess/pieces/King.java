package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

	public King(Board board, Color color) { // the same method for rook but now is king
		super(board, color);
	}

	@Override
	public String toString() {
		return "K";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position p = new Position(0, 0);

		// above | position above King
		p.setValues(position.getRow() - 1, position.getColumn());
		if (getBoard().positionExists(p) && canMove(p)) { // if position above there no have a piece then:
			mat[p.getRow()][p.getColumn()] = true; // move
		}

		// below
		p.setValues(position.getRow() + 1, position.getColumn());
		if (getBoard().positionExists(p) && canMove(p)) { // if position below there no have a piece then:
			mat[p.getRow()][p.getColumn()] = true; // move
		}

		// left
		p.setValues(position.getRow(), position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) { // if position left there no have a piece then:
			mat[p.getRow()][p.getColumn()] = true; // move
		}

		// right
		p.setValues(position.getRow(), position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) { // if position right there no have a piece then:
			mat[p.getRow()][p.getColumn()] = true; // move
		}

		// diagonal up left
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) { 
			mat[p.getRow()][p.getColumn()] = true; // move
		}

		// diagonal up right
		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) { 
			mat[p.getRow()][p.getColumn()] = true; // move
		}

		// diagonal below left
		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) { 
			mat[p.getRow()][p.getColumn()] = true; // move
		}

		// diagonal below right
		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) { 
			mat[p.getRow()][p.getColumn()] = true; // move
		}

		return mat;
	}

	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position); // get position the piece p in my board
		return p == null || p.getColor() != getColor(); 
	}

}
