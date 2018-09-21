package pieces;
import java.util.ArrayList;

import ChessGame.Board;
import ChessGame.Color;
import ChessGame.Spot;;

public class Bishop extends Piece{

	public Bishop(Color color) {
		super(color);
	}

	/**
	 * Method to get all Possible moves for the bishop on the current state of board from the current spot.
	 * A Bishop can move in North-East, North-West, South-East and South-West directions.
	 */
	@Override
	public ArrayList<Spot> getPossibleMoves(Board board, final Spot currentSpot) {
		possibleMoves.clear();
		Spot spots[][] = board.getSpots();
		int row = currentSpot.getRow() - 49;
		int col = currentSpot.getColumn() - 97;
		int tempRow=row+1,tempCol=col-1;
		//find all possible moves in North-West direction.
		while(tempRow<8&&tempCol>=0)
		{
			if(spots[tempRow][tempCol].getPiece()==null)
			{
				possibleMoves.add(spots[tempRow][tempCol]);
			}
			else if(spots[tempRow][tempCol].getPiece().getColor()==this.getColor())
				break;
			else
			{
				possibleMoves.add(spots[tempRow][tempCol]);
				break;
			}
			tempRow++;
			tempCol--;
		}
		// find all possible moves in South-East directions.
		tempRow=row-1;tempCol=col+1;
		while(tempRow>=0&&tempCol<8)
		{
			if(spots[tempRow][tempCol].getPiece()==null)
				possibleMoves.add(spots[tempRow][tempCol]);
			else if(spots[tempRow][tempCol].getPiece().getColor()==this.getColor())
				break;
			else
			{
				possibleMoves.add(spots[tempRow][tempCol]);
				break;
			}
			tempRow--;
			tempCol++;
		}
		//find all possible moves in South-West direction.
		tempRow=row-1;tempCol=col-1;
		while(tempRow>=0&&tempCol>=0)
		{
			if(spots[tempRow][tempCol].getPiece()==null)
				possibleMoves.add(spots[tempRow][tempCol]);
			else if(spots[tempRow][tempCol].getPiece().getColor()==this.getColor())
				break;
			else
			{
				possibleMoves.add(spots[tempRow][tempCol]);
				break;
			}
			tempRow--;
			tempCol--;
		}
		//find all possible moves in North-East direction.
		tempRow=row+1;tempCol=col+1;
		while(tempRow<8&&tempCol<8)
		{
			if(spots[tempRow][tempCol].getPiece()==null)
				possibleMoves.add(spots[tempRow][tempCol]);
			else if(spots[tempRow][tempCol].getPiece().getColor()==this.getColor())
				break;
			else
			{
				possibleMoves.add(spots[tempRow][tempCol]);
				break;
			}
			tempRow++;
			tempCol++;
		}
		return possibleMoves;
	}

}
