import java.util.Scanner;

public class HumanPlayer implements Player {
	private int playerID;
	
	public HumanPlayer(int playerID){
		this.playerID = playerID;
	}

	@Override
	public void think() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move(int board, int row, int col, int player) {
		// TODO Auto-generated method stub
		
	}
	
	public void promptMove(){
		Scanner scan = new Scanner(System.in);
		int board = 0;
		while(board < 1 || board > 9){
			System.out.println("Indicate board to play on(1 - 9): ");
			board = scan.nextInt();
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
		this.move(board, row, column, playerID);
	}

}
