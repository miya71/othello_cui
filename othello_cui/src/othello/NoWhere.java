package othello;

public class NoWhere {
	boolean noWhereFlag;
	int passCount;
	
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