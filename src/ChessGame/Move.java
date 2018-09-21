package ChessGame;
public class Move {
	private Spot fromSpot;
	private Spot toSpot;
	
	public Move(Spot fromSpot, Spot toSpot){
		this.fromSpot = fromSpot;
		this.toSpot = toSpot;
	}

	public Spot getFromSpot() {
		return fromSpot;
	}

	public Spot getToSpot() {
		return toSpot;
	}

	
	

}
