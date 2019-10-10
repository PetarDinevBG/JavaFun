
public class SmallBoard {
	private int[][] board;
	
	public SmallBoard(){
		board = new int[3][3];
		boardInit();
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
	
	//Marks a field on the board as played by player and checks for any illegal moves
	public boolean playMark(int i, int j, int player){
		if(i < 0 || i > 2 || j < 0 || j > 2 || player < 1 || player > 2){
			System.out.println("Wrong input in small board playMark()!");
			return false;
		}else if(board[i][j] != 0){
			System.out.println("Error: Someone has already played here!");
			return false;
		}else{
			board[i][j] = player;
			return true;
		}
	}
}
