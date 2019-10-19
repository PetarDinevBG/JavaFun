import java.util.LinkedList;

public class ComputerPlayer implements Player {
	private int playerID;
	
	public ComputerPlayer(int playerID){
		this.playerID = playerID;
	}

	@Override
	public Move think() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public double heuristicFunc(FullBoard board){
		return 0;
	}
	
	public LinkedList<FullBoard> getPossibleMoves(FullBoard board, int currentBoard){
		LinkedList<FullBoard> possibleMoves = new LinkedList<FullBoard>();
		for(int i = 0; i < 9; i++){
			FullBoard testMove = board.cloneFullBoard();
			int row = i/3;
			int col = i%3;
			Move move = new Move(row, col, playerID);
			if(testMove.playerMove(move, true) == true){
				
			}
		}
		
		return null;
	}
}
