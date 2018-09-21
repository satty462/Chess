package ChessGame;
import pieces.King;
import pieces.Piece;

public class Board {
	private Spot[][] spots = new Spot[8][8];
	public Board() {
        for(int i=0; i<spots.length; i++){
            for(int j=0; j<spots.length; j++){
                this.spots[i][j] = new Spot((char) (i + '1'), (char) (j+'a'));
            }
        }
    }
	
	public Spot[][] getSpots(){
		return spots;
	}
	
	public Spot getKingSpot(Color color){
		for(int i=0; i<spots.length; i++){
            for(int j=0; j<spots.length; j++){
            	Piece piece = spots[i][j].getPiece();
            	
                if(piece instanceof King && color.equals(piece.getColor())){
                	return spots[i][j];
                }
            }
        }
		return null;
	}
	public Spot getSpotAt(char row , char column){
		return spots[row-49][column-97];
	}

	@Override
	public String toString() {
		StringBuilder spotsStr = new StringBuilder();
		for(int i=0; i<spots.length; i++){
            for(int j=0; j<spots.length; j++){
            	spotsStr.append(spots[i][j] + " ");
            }
        }
		return spotsStr.toString();
	}
	
	public void movePiece(){
		
	}
}
