import java.util.Scanner;

public class HumanPlayer implements Player {
	private int playerID;
	private boolean firstMove;
	
	public HumanPlayer(int playerID, boolean firstMove){
		this.playerID = playerID;
		this.firstMove = firstMove;
	}

	@Override
	public Move think(FullBoard board) {
		return promptMove();
		
	}
	//TODO implement check if board place is occupied
	public Move promptMove(){
		Scanner scan = new Scanner(System.in);
		int board = 0;
		if(firstMove){
			while(board < 1 || board > 9){
				System.out.println("Indicate board to play on(1 - 9): ");
				board = scan.nextInt();
			}
		}
		int row = 0;
		while(row < 1 || row > 9){
			System.out.println("Indicate row to play on(1 - 3): ");
			row = scan.nextInt();
		}
		int column = 0;
		while(column < 1 || column > 9){
			System.out.println("Indicate column to play on(1 - 3): ");
			column = scan.nextInt();
		}
		if(firstMove){
			firstMove = false;
			return(new Move(board - 1, row - 1, column - 1, playerID));	
		}else{
			return(new Move(row - 1, column - 1, playerID));
		}
	}

}
