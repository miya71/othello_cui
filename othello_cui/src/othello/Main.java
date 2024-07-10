package othello;

public class Main {
	public static void main(String[] args) {
		Stone stone = new Stone();
		Player player = new Player();
		Turn turn = new Turn();
		NoWhere nowhere = new NoWhere();
		Board board = new Board(stone, player, turn, nowhere);
		Score score = new Score(board);
		
		Game game = new Game(stone, player, turn, board, score, nowhere);
		game.play();
	}
	
}