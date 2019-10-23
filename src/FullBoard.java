
public class FullBoard {
	private SmallBoard[][] fullBoard;
	private int nextBoard;
	
	public FullBoard(){
		fullBoard = new SmallBoard[3][3];
		initBoard();
	}
	
	public FullBoard(SmallBoard[][] fullBoard){
		this.fullBoard = fullBoard.clone();
	}
	
	private void initBoard(){
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				fullBoard[i][j] = new SmallBoard();
			}
		}
	}
	
	public int getNextBoard(){
		return nextBoard;
	}
	
	public FullBoard cloneFullBoard(){
		SmallBoard[][] cloneBoard = new SmallBoard[3][3];
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				cloneBoard[i][j] = fullBoard[i][j].cloneBoard();
			}
		}
		return new FullBoard(cloneBoard);
	}
	
	public SmallBoard getSmallBoard(int row, int col){
		return fullBoard[row][col];
	}
	
	public void printBoard(){
		for(int i = 0; i < 9; i++){
			if(i%3 == 0){
				System.out.println("-------------------");
			}
			System.out.print("|");
			fullBoard[i/3][0].printRow(i%3);
			System.out.print("|");
			fullBoard[i/3][1].printRow(i%3);
			System.out.print("|");
			fullBoard[i/3][2].printRow(i%3);
			System.out.println("|");
		}
		System.out.println("-------------------");
	}
	
	public int checkBoard(int board){
		return fullBoard[board/3][board%3].checkWinner();
	}
	
	public int checkWinner(){
		for(int board = 0; board < 9; board++){
			int winner = checkBoard(board);
			if(winner != 0){
				return winner;
			}
		}
		return 0;
	}
	
	public boolean playerMove(Move move, boolean testMove){
		nextBoard = move.getRow()*3 + move.getCol();
		return fullBoard[move.getBoard()/3][move.getBoard()%3].playMark(move.getRow(), move.getCol(), move.getPlayer(), testMove);
	}
}
