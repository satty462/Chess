package ChessGame;
import pieces.King;

public class MoveCommandProcessor {

	private static String INVALID_COMMAND = "Invalid command format.";
	private static String INVALID_MOVE = "Invalid move.";
	private Color lastMovedPieceColor = null;

	public CommandResult processCommand(final Board board, String moveCommand) {
		CommandResult commandResult = new CommandResult();
		Move move = parseCommand(board, moveCommand);
		validateMove(board, move);
		makeMove(board, move);
		if(isCheck(board)){
			commandResult.setGameState(GameState.CHECK);
		}
		return commandResult;
	}

	private boolean isCheck(final Board board) {
		Spot kingSpot = Color.BLACK.equals(lastMovedPieceColor) ? board.getKingSpot(Color.WHITE)
				: board.getKingSpot(Color.BLACK);
		return ((King) kingSpot.getPiece()).isInDanger(board, kingSpot);
	}

	private void makeMove(final Board board, final Move move) {
		Spot fromSpot = move.getFromSpot();
		Spot toSpot = move.getToSpot();

		if (toSpot.getPiece() != null) {
			toSpot.getPiece().setAlive(false);
			System.out.println(toSpot.getPiece().getClass().getName() + "Captured");
		}
		toSpot.setPiece(fromSpot.getPiece());
		lastMovedPieceColor = fromSpot.getPiece().getColor();
		fromSpot.setPiece(null);
	}

	private void validateMove(final Board board, Move move) {
		if (move == null || move.getFromSpot() == null || move.getToSpot() == null
				|| move.getFromSpot().getPiece() == null
				|| (lastMovedPieceColor != null && lastMovedPieceColor == move.getFromSpot().getPiece().getColor())
				|| !move.getFromSpot().getPiece().getPossibleMoves(board, move.getFromSpot())
						.contains(move.getToSpot())) {
			throw new IllegalArgumentException(INVALID_MOVE);
		}
	}

	private Move parseCommand(Board board, String moveCommand) {
		boolean isValidCommand = true;
		Move move = null;
		if (null == moveCommand || moveCommand.length() != 5) {
			isValidCommand = false;
		} else {
			char fromRow = moveCommand.charAt(0);
			char fromCol = moveCommand.charAt(1);
			char delimiter = moveCommand.charAt(2);
			char toRow = moveCommand.charAt(3);
			char toCol = moveCommand.charAt(4);
			if (' ' != delimiter || fromRow < '1' || fromRow > '8' || fromCol < 'a' || fromCol > 'h' || toRow < '1'
					|| toRow > '8' || toCol < 'a' || toCol > 'h') {
				isValidCommand = false;
			} else {
				Spot fromSpot = board.getSpotAt(fromRow, fromCol);
				Spot toSpot = board.getSpotAt(toRow, toCol);
				move = new Move(fromSpot, toSpot);
			}
		}
		if (!isValidCommand) {
			throw new IllegalArgumentException(INVALID_COMMAND);
		}
		return move;
	}

}
