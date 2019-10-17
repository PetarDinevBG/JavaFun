
public class FullBoard {
	private SmallBoard[][] fullBoard;
	
	public FullBoard(){
		fullBoard = new SmallBoard[3][3];
		initBoard();
	}
	
	private void initBoard(){
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				fullBoard[i][j] = new SmallBoard();
			}
		}
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
	
	public void playerMove(Move move){
		fullBoard[move.getBoard()/3][move.getBoard()%3].playMark(move.getRow(), move.getCol(), move.getPlayer());;
	}
}
