package othello;

public class Main {
	public static void main(String[] args) {
		Stone stone = new Stone();
		Player player = new Player();
		Turn turn = new Turn();
		EndGame endgame = new EndGame();
		Board board = new Board(stone, player, turn, endgame);
		Score score = new Score(board);
		
		Game game = new Game(stone, player, turn, board, score, endgame);
		game.play();
	}
	
}