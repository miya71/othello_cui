package othello;

public class Stone {
	private int stone;
	
	public Stone() {
		stone = 4;
	}
	public void increaseStone() {
		stone++;
	}
	public int getStone() {
		return stone;
	}
}