import java.util.LinkedList;
import java.util.Random;

public class ComputerPlayer implements Player {
	private int playerID;
	private ComputerBrain brain;
	
	public ComputerPlayer(int playerID){
		this.playerID = playerID;
		brain = new ComputerBrain(null, playerID);
	}

	@Override
	public Move think(FullBoard board) {
		brain.setBoard(board.cloneFullBoard());
		LinkedList<Move> possibleMoves = brain.getPossibleMoves(board, board.getNextBoard());
		//TODO Implement actual thinking, Random moves in the meantime
		Random rand = new Random();
		int randomMove = rand.nextInt(possibleMoves.size());
		
		return possibleMoves.get(randomMove);
	}
}
