package othello;

public class Score {
	private Board board;
	
	private int blackStone;
	private int whiteStone;
	
	public Score(Board board) {
		this.board = board;
	}
	public void countScore() {
		blackStone = 0;
		whiteStone = 0;
		for(int i = 0; i < board.getBoard().length; i++) {
			for(int j = 0; j < board.getBoard().length; j++) {
				if (board.getBoard(i, j).equals("black")) {
					blackStone++;
				} else if(board.getBoard(i, j).equals("white")) {
					whiteStone++;
				}
			}
		}
	}
	public int getBlackStone() {
		return blackStone;
	}
	public int getWhiteStone() {
		return whiteStone;
	}
}
