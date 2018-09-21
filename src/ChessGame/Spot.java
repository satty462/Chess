package ChessGame;

import pieces.Piece;

public class Spot {
	private char row;
	private char column;
	private Piece piece;
	
	public Spot(char row, char col) {
        this.row = row;
        this.column = col;
        piece = null;
    }
	
	public int getRow(){
		return row;
	}
	
	public char getColumn(){
		return column;
	}
	
	public Piece getPiece(){
		return piece;
	}
	public void setPiece(Piece piece){
		this.piece = piece;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + column;
		result = prime * result + row;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Spot other = (Spot) obj;
		if (column != other.column)
			return false;
		if (row != other.row)
			return false;
		return true;
	}
	
	
	

}
