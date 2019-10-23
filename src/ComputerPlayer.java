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
		return brain.nextMove(board);
	}
}
