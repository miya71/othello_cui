package othello;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
	private Scanner scanner = new Scanner(System.in);
	
	private Stone stone;
	private Player player;
	private Turn turn;
	private Board board;
	private Score score;
	private Pass pass;
	
	public Game(Stone stone, Player player, Turn turn, Board board, Score score, Pass pass) {
		this.stone = stone;
		this.player = player;
		this.turn = turn;
		this.board = board;
		this.score = score;
		this.pass = pass;
	}
	public void play() {
		System.out.println("オセロゲームを開始します。");
		board.reset();
		while(stone.getStone() < 64) {
			printBoard();
			score.countScore();
			System.out.println("黒：" + score.getBlackStone() + " 白：" + score.getWhiteStone());
			if(player.getMyColor().equals("black")) {
				System.out.println("黒の番です。");
			} else {
				System.out.println("白の番です。");
			}
			System.out.println("石を置くx軸を入力してください（1〜8、パスの場合は0）。");
			int x = inputX();
			System.out.println("石を置くy軸を入力してください（1〜8、パスの場合は0）。");
			int y = inputY();
			if(y == 0 && x == 0) {
				turn.setTurnEndFlag(true);
				System.out.println("パスしました。");
				pass.increasePassCount();
			} else if(!(board.getBoard((y-1), (x-1)).equals("none"))) {
				turn.setTurnEndFlag(false);
				System.out.println("既に石が置いてあります。");
			} else {
				board.putStone(y, x);
			}
			if(turn.getTurnEndFlag()) {
				player.changeColor();
			}
			if(board.getChangeFlag() == false) {
				System.out.println("1つ以上の石をひっくり返してください。");
			}
			if(pass.getPassCount() == 2) {
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
		System.out.println("  1 2 3 4 5 6 7 8 ");
		for(int i = 0; i < board.getBoard().length; i++) {
			System.out.print((i + 1) + " ");
			for(int j = 0; j < board.getBoard().length; j++) {
				if(board.getBoard(i, j).equals("black")) {
					System.out.print("● ");
				} else if(board.getBoard(i, j).equals("white")) {
					System.out.print("○ ");
				} else if(board.getBoard(i,j).equals("none")) {
					System.out.print(": ");
				}
			}
			System.out.println("");
		}
	}
	private int inputX() {
		int x;
		while(true) {
			try {
				x = scanner.nextInt();
				if(x < 0 || x > 8) {
					System.out.println("盤面内の座標を指定してください。");
					continue;
				}
				break;
			} catch(InputMismatchException e) {
				System.out.println("数字を入力してください。");
				scanner.next();
			}
		}
		return x;
	}
	private int inputY() {
		int y;
		while(true) {
			try {
				y = scanner.nextInt();
				if(y < 0 || y > 8) {
					System.out.println("盤面内の座標を指定してください。");
					continue;
				}
				break;
			} catch(InputMismatchException e) {
				System.out.println("数字を入力してください。");
				scanner.next();
			}
		}
		return y;
	}
}