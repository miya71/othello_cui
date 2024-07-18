package othello;

public class Main {
	public static void main(String[] args) {
		Stone stone = new Stone();
		Player player = new Player();
		Turn turn = new Turn();
		Pass pass = new Pass();
		Board board = new Board(stone, player, turn, pass);
		Score score = new Score(board);
		
		Game game = new Game(stone, player, turn, board, score, pass);
		game.play();
	}
	
}