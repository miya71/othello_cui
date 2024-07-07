package othello;

public class Main {
	public static void main(String[] args) {
		Input input = new Input();
		
		Stone stone = new Stone();
		Player player = new Player();
		Turn turn = new Turn();
		Board board = new Board(stone, player, turn);
		Score score = new Score(board);
		
		Game game = new Game(input, stone, player, turn, board, score);
		game.play();
	}
	
}