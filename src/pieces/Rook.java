package pieces;
import java.util.ArrayList;

import ChessGame.Board;
import ChessGame.Color;
import ChessGame.Spot;

public class Rook extends Piece{

	public Rook(Color color) {
		super(color);
	}

	@Override
	public ArrayList<Spot> getPossibleMoves(Board board, final Spot currentSpot) {
		possibleMoves.clear();
		Spot spots[][] = board.getSpots();
		int row = currentSpot.getRow() - 49;
		int col = currentSpot.getColumn() - 97;
		// Checking possible moves in vertical direction
		int tempRow = row - 1;
		while (tempRow >= 0) {
			if (spots[tempRow][col].getPiece() == null)
				possibleMoves.add(spots[tempRow][col]);
			else if (spots[tempRow][col].getPiece().getColor() == this.getColor())
				break;
			else {
				possibleMoves.add(spots[tempRow][col]);
				break;
			}
			tempRow--;
		}

		tempRow = row + 1;
		while (tempRow < 8) {
			if (spots[tempRow][col].getPiece() == null)
				possibleMoves.add(spots[tempRow][col]);
			else if (spots[tempRow][col].getPiece().getColor() == this.getColor())
				break;
			else {
				possibleMoves.add(spots[tempRow][col]);
				break;
			}
			tempRow++;
		}

		// Checking possible moves in horizontal Direction
		int tempcol = col - 1;
		while (tempcol >= 0) {
			if (spots[row][tempcol].getPiece() == null)
				possibleMoves.add(spots[row][tempcol]);
			else if (spots[row][tempcol].getPiece().getColor() == this.getColor())
				break;
			else {
				possibleMoves.add(spots[row][tempcol]);
				break;
			}
			tempcol--;
		}
		tempcol = col + 1;
		while (tempcol < 8) {
			if (spots[row][tempcol].getPiece() == null)
				possibleMoves.add(spots[row][tempcol]);
			else if (spots[row][tempcol].getPiece().getColor() == this.getColor())
				break;
			else {
				possibleMoves.add(spots[row][tempcol]);
				break;
			}
			tempcol++;
		}
		return possibleMoves;
	}

}
