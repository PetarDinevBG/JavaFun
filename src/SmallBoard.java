
public class SmallBoard {
	private int[][] board;
	
	public SmallBoard(){
		board = new int[3][3];
		boardInit();
	}
	
	public SmallBoard(int[][] board){
		this.board = board.clone();
	}
	
	//Initialize board entries to 0
	private void boardInit(){
		for(int i = 0; i < 3; i++){
			for(int j = 0;j < 3; j++){
				board[i][j] = 0;
			}
		}
	}
	
	public void printBoard(){
		for(int i = 0; i < 3; i++){
			for(int j = 0;j < 3; j++){
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	//Prints a given row
	public void printRow(int row){
		System.out.print(board[row][0] + " " + board[row][1] + " " + board[row][2]);
	}
	
	//Marks a field on the board as played by player and checks for any illegal moves
	public boolean playMark(int i, int j, int player, boolean testMove){
		if(i < 0 || i > 2 || j < 0 || j > 2 || player < 1 || player > 2){
			System.out.println("Wrong input in small board playMark()!");
			return false;
		}else if(board[i][j] != 0){
			if(testMove == false){
				System.out.println("Error: Someone has already played here!");
			}
			return false;
		}else{
			board[i][j] = player;
			return true;
		}
	}
	
	public SmallBoard cloneBoard(){
		int[][] cloneBoard = new int[3][3];
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				cloneBoard[i][j] = board[i][j];
			}
		}
		return new SmallBoard(cloneBoard);
	}
	
	//Return 0, 1 or 2 depending if someone is winning the given row or not
	private int checkRow(int row){
		if(row < 0 || row > 2){
			System.out.println("Wrong input in SmallBoard.checkRow() method: row = " + row);
			return -1;
		}else{
			if(board[0][row] == board[1][row] && board[1][row] == board[2][row]){
				return board[0][row];
			}else{
				return 0;
			}
		}
	}
	
	//Return 0, 1 or 2 depending if someone is winning the given column or not
	private int checkCol(int col){
		if(col < 0 || col > 2){
			System.out.println("Wrong input in SmallBoard.checkCol() method: col = " + col);
			return -1;
		}else{
			if(board[col][0] == board[col][1] && board[col][1] == board[col][2]){
				return board[col][0];
			}else{
				return 0;
			}
		}
	}
	
	private int checkDiagonals(){
		if(board[0][0] == board[1][1] && board[1][1] == board[2][2]){
			return board[0][0];
		}else if(board[0][2] == board[1][1] && board[1][1] == board[2][0]){
			return board[1][1];
		}else{
			return 0;
		}
	}
	
	public int checkWinner(){
		int rowWinner = Math.max(Math.max(checkRow(0), checkRow(1)), checkRow(2));
		int colWinner = Math.max(Math.max(checkCol(0), checkCol(1)), checkCol(2));
		int diagWinner = checkDiagonals();
		return Math.max(rowWinner, Math.max(colWinner, diagWinner));
	}
	
	//Heuristic Helping Functions
	public int hasCenter(){
		return board[1][1];
	}
}
