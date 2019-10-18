
public class ComputerPlayer implements Player {
	FullBoard thinkBoard;
	@Override
	public Move think() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setThinkBoard(FullBoard thinkBoard){
		this.thinkBoard = thinkBoard;
	}
	
	public double heuristicFunc(FullBoard board){
		return 0;
	}


}
