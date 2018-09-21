package ChessGame;
import java.util.Scanner;

import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Queen;
import pieces.Rook;

public class Game {
	private static Board board;
	private static MoveCommandProcessor moveCommandProcessor = new MoveCommandProcessor();
	private static String EXIT_COMMAND = "exit";
	
	public static void main(String[] args) throws Exception{
		initializeGame();
		System.out.println("Rows are named from 1 to 8 and columns are named from a to h");
		System.out.println("Enter move command like - 2a 3b");
		System.out.println("To exit the game type  -'exit' ");
	    
	    Scanner in = new Scanner(System.in);
	    while(true){
	    	String moveCommand = in.nextLine();
	    	if(EXIT_COMMAND.equalsIgnoreCase(moveCommand)){
	    		break;
	    	}
	    	try{
	    		CommandResult commandResult = moveCommandProcessor.processCommand(board, moveCommand);
	    		processCommandResult(commandResult);
	    	} catch (final IllegalArgumentException e){
	    		System.out.println("ERROR  : " + e.getMessage());
	    	}
	    }
	    in.close();
	}
	
	private static void processCommandResult(CommandResult commandResult){
		if(GameState.CHECK.equals(commandResult.getGameState())){
			System.out.println("It's a Check..");
		}
	}
	public static void initializeGame(){
		System.out.println("Initialing the Chess Game..");
		board = new Board();
		setPiecesOnBoard();
		System.out.println("Initialization complete.");
		
	}
	
	private static void setPiecesOnBoard(){
		setWhitePieces();
		setBlackPieces();
	}
	
	private static void setBlackPieces() {
		Spot[][] spots = board.getSpots();
		for(int i = 0;i< 8 ; i++){
			spots[1][i].setPiece(new Pawn(Color.BLACK));
		}
		spots[0][0].setPiece(new Rook(Color.BLACK));
		spots[0][1].setPiece(new Knight(Color.BLACK));
		spots[0][2].setPiece(new Bishop(Color.BLACK));
		spots[0][3].setPiece(new Queen(Color.BLACK));
		spots[0][4].setPiece(new King(Color.BLACK));
		spots[0][5].setPiece(new Bishop(Color.BLACK));
		spots[0][6].setPiece(new Knight(Color.BLACK));
		spots[0][7].setPiece(new Rook(Color.BLACK));
	}
	
	private static void setWhitePieces() {
		Spot[][] spots = board.getSpots();
		for(int i = 0;i< 8 ; i++){
			spots[6][i].setPiece(new Pawn(Color.WHITE));
		}
		spots[7][0].setPiece(new Rook(Color.WHITE));
		spots[7][1].setPiece(new Knight(Color.WHITE));
		spots[7][2].setPiece(new Bishop(Color.WHITE));
		spots[7][3].setPiece(new Queen(Color.WHITE));
		spots[7][4].setPiece(new King(Color.WHITE));
		spots[7][5].setPiece(new Bishop(Color.WHITE));
		spots[7][6].setPiece(new Knight(Color.WHITE));
		spots[7][7].setPiece(new Rook(Color.WHITE));
	}
}
