package pieces;
import java.util.ArrayList;

import ChessGame.Board;
import ChessGame.Color;
import ChessGame.Spot;

public class Pawn extends Piece{

	public Pawn(Color color) {
		super(color);
	}

	@Override
	public ArrayList<Spot> getPossibleMoves(Board board, Spot currentSpot) {
		possibleMoves.clear();
		Spot[][] spots = board.getSpots();
		int row = currentSpot.getRow() - 49;
		int col = currentSpot.getColumn() - 97;
		
		if(Color.WHITE == getColor())
		{
			if(row==0)
				return possibleMoves;
			if(spots[row-1][col].getPiece()==null)
			{
				possibleMoves.add(spots[row-1][col]);
				if(row==6)
				{
					if(spots[4][col].getPiece()==null)
						possibleMoves.add(spots[4][col]);
				}
			}
			if((col>0)&&(spots[row-1][col-1].getPiece()!=null)&&(spots[row-1][col-1].getPiece().getColor()!=this.getColor()))
				possibleMoves.add(spots[row-1][col-1]);
			if((col<7)&&(spots[row-1][col+1].getPiece()!=null)&&(spots[row-1][col+1].getPiece().getColor()!=this.getColor()))
				possibleMoves.add(spots[row-1][col+1]);
		}
		else
		{
			if(row==8)
				return possibleMoves;
			if(spots[row+1][col].getPiece()==null)
			{
				possibleMoves.add(spots[row+1][col]);
				if(row==1)
				{
					if(spots[3][col].getPiece()==null)
						possibleMoves.add(spots[3][col]);
				}
			}
			if((col>0)&&(spots[row+1][col-1].getPiece()!=null)&&(spots[row+1][col-1].getPiece().getColor()!=this.getColor()))
				possibleMoves.add(spots[row+1][col-1]);
			if((col<7)&&(spots[row+1][col+1].getPiece()!=null)&&(spots[row+1][col+1].getPiece().getColor()!=this.getColor()))
				possibleMoves.add(spots[row+1][col+1]);
		}
		return possibleMoves;
	}
}
