package boardgame;

public class Board { // return one piece at time
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns]; // will instantiated only with rows and cloumns informed 
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	public Piece piece (int row, int column) {
		return pieces[row][column];
	}
	
	public Piece piece (Position position) {
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) { // method that passes the position to the part
		pieces [position.getRow()][position.getColumn()] = piece;
		piece.position = position; // receives the position
	}
}
