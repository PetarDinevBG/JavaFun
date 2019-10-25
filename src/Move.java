
public class Move {
	private int board;
	private int row;
	private int col;
	private int player;
	
	public int getBoard() {
		return board;
	}

	public void setBoard(int board) {
		this.board = board;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getPlayer() {
		return player;
	}

	public void setPlayer(int player) {
		this.player = player;
	}

	public Move(int board, int row, int col, int player){
		this.board = board;
		this.row = row;
		this.col = col;
		this.player = player;
	}
	
	public Move(int row, int col, int player){
		this.row = row;
		this.col = col;
		this.player = player;	
	}
}
