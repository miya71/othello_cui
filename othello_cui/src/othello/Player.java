package othello;

public class Player {
	private String myColor;
	private String enemyColor;
	
	public Player() {
		myColor = "black";
		enemyColor = "white";
	}
	public String getMyColor() {
		return myColor;
	}
	public String getEnemyColor() {
		return enemyColor;
	}
	public void changeColor() {
		if(myColor.equals("black")) {
			myColor = "white";
			enemyColor = "black";
		} else {
			myColor = "black";
			enemyColor = "white";
		}
	}
}