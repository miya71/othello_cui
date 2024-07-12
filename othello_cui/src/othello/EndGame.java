package othello;

public class EndGame {
	private boolean endGameFlag;
	private int passCount;
	
	public boolean getEndGameFlag() {
		if(passCount == 2) {
			endGameFlag = true;
		}
		return endGameFlag;
	}
	public void increasePassCount() {
		passCount++;
	}
	public void resetPassCount() {
		passCount = 0;
	}
}