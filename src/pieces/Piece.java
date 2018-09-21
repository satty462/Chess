package pieces;
import java.util.ArrayList;

import ChessGame.Board;
import ChessGame.Color;
import ChessGame.Spot;
public abstract class Piece {

	private Color color;
	private boolean isALive;
	protected ArrayList<Spot> possibleMoves = new ArrayList<>();
	
	
	public abstract ArrayList<Spot> getPossibleMoves(final Board board, final Spot fromSpot);
	
	public Piece(Color color){
		this.color = color;
		this.isALive = true;
	}
	
	public Color getColor(){
		return color;
	}
	
	public boolean isALive(){
		return isALive;
	}
	
	public void setAlive(boolean isAlive){
		this.isALive = isAlive;
	}
	
	
}
