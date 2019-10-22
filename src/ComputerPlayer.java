import java.util.LinkedList;
import java.util.Random;

public class ComputerPlayer implements Player {
	private int playerID;
	
	public ComputerPlayer(int playerID){
		this.playerID = playerID;
	}

	@Override
	public Move think(FullBoard board) {
		LinkedList<Move> possibleMoves = getPossibleMoves(board, board.getNextBoard());
		//TODO Implement actual thinking, Random moves in the meantime
		Random rand = new Random();
		int randomMove = rand.nextInt(possibleMoves.size());
		
		return possibleMoves.get(randomMove);
	}
	
	public double heuristicFunc(FullBoard board){
		return 0;
	}
	
	public LinkedList<Move> getPossibleMoves(FullBoard board, int currentBoard){
		LinkedList<Move> possibleMoves = new LinkedList<Move>();
		for(int i = 0; i < 9; i++){
			FullBoard testBoard = board.cloneFullBoard();
			int row = i/3;
			int col = i%3;
			Move move = new Move(row, col, playerID);
			if(testBoard.playerMove(move, true) == true){
				possibleMoves.add(move);
			}
		}
		return possibleMoves;
	}
	
	public LinkedList<FullBoard> getPossibleBoards(FullBoard board, int currentBoard){
		LinkedList<FullBoard> possibleBoards = new LinkedList<FullBoard>();
		for(int i = 0; i < 9; i++){
			FullBoard testMove = board.cloneFullBoard();
			int row = i/3;
			int col = i%3;
			Move move = new Move(row, col, playerID);
			if(testMove.playerMove(move, true) == true){
				possibleBoards.add(testMove);
			}
		}
		
		return possibleBoards;
	}
}
