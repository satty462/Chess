package pieces;
import java.util.ArrayList;

import ChessGame.Board;
import ChessGame.Color;
import ChessGame.Spot;

public class King  extends Piece{
	
	public King(Color color) {
		super(color);
	}
	
	/**
	 * Method to get all Possible moves for the bishop on the current state of board from the current spot.
	 * A King can move 1 step in any of the below directions -
	 * <ul>
	 * 	<li> 1 step upward or downward
	 *  <li> 1 step left or right
	 *  <li> 1 step in NE,NW,SE or SW directions.
	 * </ul>
	 */
	@Override
	public ArrayList<Spot> getPossibleMoves(final Board board, final Spot currentSpot){
		possibleMoves.clear();
		Spot[][] spots = board.getSpots();
		int currentRow = currentSpot.getRow() - 49;
		int currentColumn = currentSpot.getColumn() - 97;
		int posRow[] = {currentRow, currentRow , currentRow -1, currentRow -1,currentRow-1, currentRow +1, currentRow +1, currentRow+1};
		int posCol[] = {currentColumn -1, currentColumn +1,  currentColumn -1, currentColumn , currentColumn +1, currentColumn -1, currentColumn , currentColumn +1 };
		for(int i=0;i<8;i++)
			if((posRow[i]>=0&&posRow[i]<8&&posCol[i]>=0&&posCol[i]<8))
				if((spots[posRow[i]][posCol[i]].getPiece()==null||spots[posRow[i]][posCol[i]].getPiece().getColor()!=this.getColor()))
					possibleMoves.add(spots[posRow[i]][posCol[i]]);
		return possibleMoves;
	}
	
	/**
	 * This method is to check whether the king is in danger or not. 
	 * @param board
	 * @param currentSpot
	 * @return true if the king is in danger else false.
	 */
	public boolean isInDanger(final Board board, final Spot currentSpot){
		Spot spots[][] = board.getSpots();
		int row = currentSpot.getRow() - 49;
		int col = currentSpot.getColumn() - 97;
		//Checking for attack from above
    	for(int i=row+1;i<8;i++)
    	{
    		if(spots[i][col].getPiece()==null)
    			continue;
    		else if(spots[i][col].getPiece().getColor()==this.getColor())
    			break;
    		else
    		{
    			if ((spots[i][col].getPiece() instanceof Rook) || (spots[i][col].getPiece() instanceof Queen))
    				return true;
    			else
    				break;
    		}
    	}
    	for(int i=row-1;i>=0;i--)
    	{
    		if(spots[i][col].getPiece()==null)
    			continue;
    		else if(spots[i][col].getPiece().getColor()==this.getColor())
    			break;
    		else
    		{
    			if ((spots[i][col].getPiece() instanceof Rook) || (spots[i][col].getPiece() instanceof Queen))
    				return true;
    			else
    				break;
    		}
    	}
    	for(int i=col+1;i<8;i++)
    	{
    		if(spots[row][i].getPiece()==null)
    			continue;
    		else if(spots[row][i].getPiece().getColor()==this.getColor())
    			break;
    		else
    		{
    			if ((spots[row][i].getPiece() instanceof Rook) || (spots[row][i].getPiece() instanceof Queen))
    				return true;
    			else
    				break;
    		}
    	}
    	for(int i=col-1;i>=0;i--)
    	{
    		if(spots[row][i].getPiece()==null)
    			continue;
    		else if(spots[row][i].getPiece().getColor()==this.getColor())
    			break;
    		else
    		{
    			if ((spots[row][i].getPiece() instanceof Rook) || (spots[row][i].getPiece() instanceof Queen))
    				return true;
    			else
    				break;
    		}
    	}
    	
    	//checking for attack from diagonal direction
    	int temprow=row+1,tempcol=col-1;
		while(temprow<8&&tempcol>=0)
		{
			if(spots[temprow][tempcol].getPiece()==null)
			{
				temprow++;
				tempcol--;
			}
			else if(spots[temprow][tempcol].getPiece().getColor()==this.getColor())
				break;
			else
			{
				if (spots[temprow][tempcol].getPiece() instanceof Bishop || spots[temprow][tempcol].getPiece() instanceof Queen)
    				return true;
    			else
    				break;
			}
		}
		temprow=row-1;tempcol=col+1;
		while(temprow>=0&&tempcol<8)
		{
			if(spots[temprow][tempcol].getPiece()==null)
			{
				temprow--;
				tempcol++;
			}
			else if(spots[temprow][tempcol].getPiece().getColor()==this.getColor())
				break;
			else
			{
				if (spots[temprow][tempcol].getPiece() instanceof Bishop || spots[temprow][tempcol].getPiece() instanceof Queen)
    				return true;
    			else
    				break;
			}
		}
		temprow=row-1;tempcol=col-1;
		while(temprow>=0&&tempcol>=0)
		{
			if(spots[temprow][tempcol].getPiece()==null)
			{
				temprow--;
				tempcol--;
			}
			else if(spots[temprow][tempcol].getPiece().getColor()==this.getColor())
				break;
			else
			{
				if (spots[temprow][tempcol].getPiece() instanceof Bishop || spots[temprow][tempcol].getPiece() instanceof Queen)
    				return true;
    			else
    				break;
			}
		}
		temprow=row+1;tempcol=col+1;
		while(temprow<8&&tempcol<8)
		{
			if(spots[temprow][tempcol].getPiece()==null)
			{
				temprow++;
				tempcol++;
			}
			else if(spots[temprow][tempcol].getPiece().getColor()==this.getColor())
				break;
			else
			{
				if (spots[temprow][tempcol].getPiece() instanceof Bishop || spots[temprow][tempcol].getPiece() instanceof Queen)
    				return true;
    			else
    				break;
			}
		}
		
		//Checking for attack from the Knight of opposite color
		int posrow[]={row+1,row+1,row+2,row+2,row-1,row-1,row-2,row-2};
		int poscol[]={col-2,col+2,col-1,col+1,col-2,col+2,col-1,col+1};
		for(int i=0;i<8;i++)
			if((posrow[i]>=0&&posrow[i]<8&&poscol[i]>=0&&poscol[i]<8))
				if(spots[posrow[i]][poscol[i]].getPiece()!=null && spots[posrow[i]][poscol[i]].getPiece().getColor()!=this.getColor() && (spots[posrow[i]][poscol[i]].getPiece() instanceof Knight))
				{
					return true;
				}
		
		
		//Checking for attack from the King of opposite color
		int posRow[]={row+1,row+1,row+1,row,row,row-1,row-1,row-1};
		int posCol[]={col-1,col+1,col,col+1,col-1,col+1,col-1,col};
		{
			for(int i=0;i<8;i++)
				if((posRow[i]>=0&&posRow[i]<8&&posCol[i]>=0&&posCol[i]<8))
					if(spots[posRow[i]][posCol[i]].getPiece()!=null && spots[posRow[i]][posCol[i]].getPiece().getColor()!=this.getColor() && (spots[posRow[i]][posCol[i]].getPiece() instanceof King))
					{
						return true;
					}
		}
		//Checking for attack from the pawn of opposite color
		if(Color.WHITE.equals(getColor()))
		{
			if(row>0&&col>0&&spots[row-1][col-1].getPiece()!=null&&Color.BLACK.equals(spots[row-1][col-1].getPiece().getColor())&&(spots[row-1][col-1].getPiece() instanceof Pawn))
				return true;
			if(row>0&&col<7&&spots[row-1][col+1].getPiece()!=null&&Color.BLACK.equals(spots[row-1][col+1].getPiece().getColor())&&(spots[row-1][col+1].getPiece() instanceof Pawn))
				return true;
		}
		else
		{
			if(row<7&&col>0&&spots[row+1][col-1].getPiece()!=null&&Color.WHITE.equals(spots[row+1][col-1].getPiece().getColor())&&(spots[row+1][col-1].getPiece() instanceof Pawn))
				return true;
			if(row<7&&col<7&&spots[row+1][col+1].getPiece()!=null&&Color.WHITE.equals(spots[row+1][col+1].getPiece().getColor())&&(spots[row+1][col+1].getPiece() instanceof Pawn))
				return true;
		}
    	return false;
	}


}
