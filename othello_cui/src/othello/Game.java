package othello;

public class Game {
	Input input;
	Stone stone;
	Player player;
	Turn turn;
	Board board;
	Score score;
	NoWhere nowhere;
	
	public Game(Input input, Stone stone, Player player, Turn turn, Board board, Score score, NoWhere nowhere) {
		this.input = input;
		this.stone = stone;
		this.player = player;
		this.turn = turn;
		this.board = board;
		this.score = score;
		this.nowhere = nowhere;
	}
	public void play() {
		System.out.println("オセロゲームにようこそ。");
		System.out.println("パスする場合は(0, 0)の座標を指定してください。");
		board.reset();
		while(stone.getStone() < 64) {
			printBoard();
			score.countScore();
			System.out.println("黒：" + score.getBlackStone() + " 白：" + score.getWhiteStone());
			if(player.getMyColor() == "black") {
				System.out.println("黒の番です。");
			} else {
				System.out.println("白の番です。");
			}
			System.out.println("上から何番目に置きますか。");
			int y = input.inputY();
			System.out.println("左から何番目に置きますか。");
			int x = input.inputX();
			if(y == 0 && x == 0) {
				turn.setTurnEndFlag(true);
				System.out.println("パスしました。");
				// パスカウントを1増やす
				nowhere.increasePassCount();
			} else if(board.getBoard((y-1), (x-1)) != "none") {
				turn.setTurnEndFlag(false);
				System.out.println("既に石が置いてあります。");
			} else {
				board.putStone(y, x);
			}
			if(turn.getTurnEndFlag()) {
				player.changeColor();
			}
			if(nowhere.getNoWhereFlag()) {
				// パスカウントが2になったら（パスが2回続いたら）ゲーム終了
				System.out.println("どちらも石を置けなかったので終了します。");
				break;
			}
		}
		printBoard();
		score.countScore();
		System.out.println("黒：" + score.getBlackStone() + " 白：" + score.getWhiteStone());
		if(score.getBlackStone() > score.getWhiteStone()) {
			System.out.println("黒の勝ちです。");
		} else if(score.getBlackStone() < score.getWhiteStone()) {
			System.out.println("白の勝ちです。");
		} else {
			System.out.println("引き分けです。");
		}
	}
	
	private void printBoard() {
		System.out.println("0 1 2 3 4 5 6 7 8 ");
		for(int i = 0; i < board.getBoard().length; i++) {
			System.out.print((i + 1) + " ");
			for(int j = 0; j < board.getBoard().length; j++) {
				if(board.getBoard(i, j) == "black") {
					System.out.print("● ");
				} else if(board.getBoard(i, j) == "white") {
					System.out.print("○ ");
				} else if(board.getBoard(i,j) == "none"){
					System.out.print(": ");
				}
			}
			System.out.println("");
		}
	}
	
}