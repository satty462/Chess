package pieces;
import java.util.ArrayList;

import ChessGame.Board;
import ChessGame.Color;
import ChessGame.Spot;

public class Knight extends Piece{

	public Knight(Color color) {
		super(color);
	}

	@Override
	public ArrayList<Spot> getPossibleMoves(Board board, final Spot currentSpot) {
		possibleMoves.clear();
		Spot[][] spots = board.getSpots();
		int row = currentSpot.getRow() - 49;
		int col = currentSpot.getColumn() - 97;
		int posx[]={row+1,row+1,row+2,row+2,row-1,row-1,row-2,row-2};
		int posy[]={col-2,col+2,col-1,col+1,col-2,col+2,col-1,col+1};
		for(int i=0;i<8;i++)
			if((posx[i]>=0&&posx[i]<8&&posy[i]>=0&&posy[i]<8))
				if((spots[posx[i]][posy[i]].getPiece()==null||spots[posx[i]][posy[i]].getPiece().getColor()!=this.getColor()))
				{
					possibleMoves.add(spots[posx[i]][posy[i]]);
				}
		return possibleMoves;
	}

}
