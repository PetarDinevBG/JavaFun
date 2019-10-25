
public class Game {
	private FullBoard gameBoard;
	private Player playerOne;
	private Player playerTwo;
	private int currentPlayer;
	private int nextBoard;
	
	public Game(Player playerOne, Player playerTwo){
		gameBoard = new FullBoard();
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
		currentPlayer = 1;
		nextBoard = -1;
	}
	
	public void testGame(){
		Move nextMove;
		boolean endGame = false;
		while(endGame == false){
			gameBoard.printBoard();
			nextMove = movePlayer();
			//TODO Player2 think() doesn't give a next move, so the program crashes.
			if(nextBoard >= 0 && nextBoard <=8){
				nextMove.setBoard(nextBoard);
			}
			nextBoard = nextMove.getRow()*3 + nextMove.getCol();

 			if(gameBoard.playerMove(nextMove, false) == true){
 				if(gameBoard.checkBoard(nextMove.getBoard()) != 0){
 					System.out.println("Player " + gameBoard.checkBoard(nextMove.getBoard()) + " wins the game!!!"); 
 					gameBoard.printBoard();
 					endGame = true;
 				}
				switchPlayer();
			}
 			
		}
	}
	
	private void switchPlayer(){
		if(currentPlayer == 1){
			currentPlayer = 2;
		}else{
			currentPlayer = 1;
		}
	}
	
	private Move movePlayer(){
		if(currentPlayer == 1){
			return playerOne.think(gameBoard);
		}else{
			return playerTwo.think(gameBoard);
		}
	}
}

