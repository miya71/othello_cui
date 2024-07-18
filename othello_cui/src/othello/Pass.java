package othello;

public class Pass {
	private int passCount;
	
	public int getPassCount() {
		return passCount;
	}
	public void increasePassCount() {
		passCount++;
	}
	public void resetPassCount() {
		passCount = 0;
	}
}