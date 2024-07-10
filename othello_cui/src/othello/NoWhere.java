package othello;

public class NoWhere {
	private boolean noWhereFlag;
	private int passCount;
	
	public boolean getNoWhereFlag() {
		if(passCount == 2) {
			noWhereFlag = true;
		}
		return noWhereFlag;
	}
	public void increasePassCount() {
		passCount++;
	}
	public void resetPassCount() {
		passCount = 0;
	}
}