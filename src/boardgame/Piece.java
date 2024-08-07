package boardgame;

public class Piece {
	protected Position position;
	private Board board;
	
	public Piece(Board board) {
		this.board = board;
		this.position = null; // position in game inicillazine null
	}

	protected Board getBoard() { // this method accessible only classes the same packge ou subclass
		return board;
	}
	
}
