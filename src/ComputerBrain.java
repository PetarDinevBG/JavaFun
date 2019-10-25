import java.util.LinkedList;

public class ComputerBrain {
	private int currentPlayer;
	private FullBoard realBoard;
	private int movesExplored;

	public ComputerBrain(FullBoard board, int currentPlayer){
		this.currentPlayer = currentPlayer;
		this.realBoard = board;
		movesExplored = 0;
	}
	
	public FullBoard getBoard() {
		return realBoard;
	}

	public void setBoard(FullBoard board) {
		this.realBoard = board;
	}
	
	public Move nextMove(FullBoard board){
		movesExplored = 0;
		LinkedList<Move> possibleMoves = getPossibleMoves(board, board.getNextBoard(),currentPlayer(0));
		LinkedList<FullBoard> possibleBoards = getPossibleBoards(board, board.getNextBoard(),currentPlayer(0));
		LinkedList<Double> moveValues = new LinkedList<Double>();
		for(FullBoard posBoard: possibleBoards){
			moveValues.add(evaluateMove(posBoard, 0));
		}
		System.out.println(moveValues);
		double moveValue;
		if(currentPlayer(0) == 1){
			moveValue = maxValueLinkedList(moveValues);
		}else{
			moveValue = minValueLinkedList(moveValues);
		}
		System.out.println("Moves Explored: " + movesExplored);
		return possibleMoves.get(moveValues.indexOf(moveValue));
	}
	
	private double evaluateMove(FullBoard board, int currentLevel){
		movesExplored ++;
		int winner = board.checkWinner();
		if(winner == 2){
			return -1;
		}else if(winner == 1){
			return 1;
		}
		//TODO Change currentLevel to implement computer difficulty
		if(currentLevel < 5){
			LinkedList<Double> possibleMovesValues = evaluateChildren(getPossibleBoards(board, board.getNextBoard(), currentPlayer(currentLevel + 1)), currentLevel + 1);
			if(currentPlayer(currentLevel) == 1){
				return maxValueLinkedList(possibleMovesValues);
			}else{
				return minValueLinkedList(possibleMovesValues);
			}
		}else{
			//TODO Heuristic is implement here
			return heuristicFunction(board, currentLevel);
		}

	}
	
	public LinkedList<Double> evaluateChildren(LinkedList<FullBoard> possibleMoves, int currentLevel){
		LinkedList<Double> possibleMovesValues = new LinkedList<Double>();
		for(FullBoard board: possibleMoves){
			possibleMovesValues.add(evaluateMove(board, currentLevel));
		}
		return possibleMovesValues;
	}

	public LinkedList<Move> getPossibleMoves(FullBoard board, int currentBoard, int currentPlayer){
		LinkedList<Move> possibleMoves = new LinkedList<Move>();
		for(int i = 0; i < 9; i++){
			FullBoard testMove = board.cloneFullBoard();
			int row = i/3;
			int col = i%3;
			Move move = new Move(testMove.getNextBoard(), row, col, currentPlayer);
			if(testMove.playerMove(move, true) == true){
				possibleMoves.add(move);
			}
		}
		return possibleMoves;
	}
	
	public LinkedList<FullBoard> getPossibleBoards(FullBoard board, int currentBoard, int currentPlayer){
		LinkedList<FullBoard> possibleBoards = new LinkedList<FullBoard>();
		for(int i = 0; i < 9; i++){
			FullBoard testBoard = board.cloneFullBoard();
			int row = i/3;
			int col = i%3;
			Move move = new Move(testBoard.getNextBoard(), row, col, currentPlayer);
			if(testBoard.playerMove(move, true) == true){
				possibleBoards.add(testBoard);
			}
		}
		
		return possibleBoards;
	}
	
	public double heuristicFunction(FullBoard board, int currentLevel){
		double heuristic = 0;
		heuristic += board.numberOfCenters(1)*0.001;
		heuristic -= board.numberOfCenters(2)*0.001;
		heuristic += board.possibleWinningMoves(1)*0.003;
		heuristic -= board.possibleWinningMoves(2)*0.003;
		return heuristic;
	}
	
	public int currentPlayer(int currentLevel){
		if((currentPlayer + currentLevel)%2 == 1){
			return 1;
		}else{
			return 2;
		}
	}
	
	public int oponentID(int currentLevel){
		if((currentPlayer + currentLevel)%2 == 0){
			return 1;
		}else{
			return 2;
		}
	}
	
	public double maxValueLinkedList(LinkedList<Double> values){
		double max = -1000;
		for(Double i: values){
			if(max <= i){
				max =  i;
			}
		}
		return max;
	}
	
	public double minValueLinkedList(LinkedList<Double> values){
		double min = 1000;
		for(Double i: values){
			if(min >= i){
				min =  i;
			}
		}
		return min;
	}
}
