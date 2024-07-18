package othello;

public class Board {
	Stone stone;
	Player player;
	Turn turn;
	EndGame endgame;
	
	private String board[][] = new String[8][8];
	private boolean changeFlag;
	
	public Board(Stone stone, Player player, Turn turn, EndGame endgame) {
		this.stone = stone;
		this.player = player;
		this.turn = turn;
		this.endgame = endgame;
	}
	public void reset() {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {
				board[i][j] = "none";
			}
		}
		board[3][3] = "black";
		board[4][4] = "black";
		board[3][4] = "white";
		board[4][3] = "white";
	}
	public String[][] getBoard() {
		return board;
	}
	public String getBoard(int y, int x) {
		return board[y][x];
	}
	public boolean getChangeFlag() {
		return changeFlag;
	}
	public void putStone(int y, int x) {
		y--;
		x--;
		changeFlag = false;
		changeTop(y, x);
		changeBottom(y, x);
		changeLeft(y, x);
		changeRight(y,x);
		changeTopLeft(y, x);
		changeTopRight(y, x);
		changeBottomLeft(y, x);
		changeBottomRight(y, x);
		if(changeFlag) {
			setBoard(y, x, player.getMyColor());
			stone.increaseStone();
			turn.setTurnEndFlag(true);
			// パスカウントをリセットする
			endgame.resetPassCount();
		}else {
			turn.setTurnEndFlag(false);
		}
	}
	private void setBoard(int y, int x, String myColor) {
		this.board[y][x] = myColor;
	}
	private void changeTop(int y, int x) {
		if(y > 1) {
			if(getBoard(--y, x).equals(player.getEnemyColor())) {
				while(y > 0) {
					y--;
					if(getBoard(y, x).equals(player.getMyColor())) {
						y++;
						while(getBoard(y, x).equals(player.getEnemyColor())) {
							setBoard(y, x, player.getMyColor());
							y++;
						}
						changeFlag = true;
						break;
					} else if(getBoard(y, x).equals("none")) {
						break;
					}
				}
			}
		}
	}
	private void changeBottom(int y, int x) {
		if(y < 6) {
			if(getBoard(++y, x).equals(player.getEnemyColor())) {
				while(y < 7) {
					y++;
					if(getBoard(y, x).equals(player.getMyColor())) {
						y--;
						while(getBoard(y, x).equals(player.getEnemyColor())) {
							setBoard(y, x, player.getMyColor());
							y--;
						}
						changeFlag = true;
						break;
					} else if(getBoard(y, x).equals("none")) {
						break;
					}
				}
			}
		}
	}
	private void changeLeft(int y, int x) {
		if(x > 1) {
			if(getBoard(y, --x).equals(player.getEnemyColor())) {
				while(x > 0) {
					x--;
					if(getBoard(y, x).equals(player.getMyColor())) {
						x++;
						while(getBoard(y, x).equals(player.getEnemyColor())) {
							setBoard(y, x, player.getMyColor());
							x++;
						}
						changeFlag = true;
						break;
					} else if(getBoard(y, x).equals("none")) {
						break;
					}
				}
			}
		}
	}
	private void changeRight(int y, int x) {
		if(x < 6) {
			if(getBoard(y, ++x).equals(player.getEnemyColor())) {
				while(x < 7) {
					x++;
					if(getBoard(y, x).equals(player.getMyColor())) {
						x--;
						while(getBoard(y, x).equals(player.getEnemyColor())) {
							setBoard(y, x, player.getMyColor());
							x--;
						}
						changeFlag = true;
						break;
					} else if(getBoard(y, x).equals("none")) {
						break;
					}
				}
			}
		}
	}
	private void changeTopLeft(int y, int x) {
		if(y > 1 && x > 1) {
			if(getBoard(--y, --x).equals(player.getEnemyColor())) {
				while(y > 0 && x > 0) {
					y--;
					x--;
					if(getBoard(y, x).equals(player.getMyColor())) {
						y++;
						x++;
						while(getBoard(y, x).equals(player.getEnemyColor())) {
							setBoard(y, x, player.getMyColor());
							y++;
							x++;
						}
						changeFlag = true;
						break;
					} else if(getBoard(y, x).equals("none")) {
						break;
					}
				}
			}
		}
	}
	private void changeTopRight(int y, int x) {
		if(y > 1 && x < 6) {
			if(getBoard(--y, ++x).equals(player.getEnemyColor())) {
				while(y > 0 && x < 7) {
					y--;
					x++;
					if(getBoard(y, x).equals(player.getMyColor())) {
						y++;
						x--;
						while(getBoard(y, x).equals(player.getEnemyColor())) {
							setBoard(y, x, player.getMyColor());
							y++;
							x--;
						}
						changeFlag = true;
						break;
					} else if(getBoard(y, x).equals("none")) {
						break;
					}
				}
			}
		}
	}
	private void changeBottomLeft(int y, int x) {
		if(y < 6 && x > 1) {
			if(getBoard(++y, --x).equals(player.getEnemyColor())) {
				while(y < 7 && x > 0) {
					y++;
					x--;
					if(getBoard(y, x).equals(player.getMyColor())) {
						y--;
						x++;
						while(getBoard(y, x).equals(player.getEnemyColor())) {
							setBoard(y, x, player.getMyColor());
							y--;
							x++;
						}
						changeFlag = true;
						break;
					} else if(getBoard(y, x).equals("none")) {
						break;
					}
				}
			}
		}
	}
	private void changeBottomRight(int y, int x) {
		if(y < 6 && x < 6) {
			if(getBoard(++y, ++x).equals(player.getEnemyColor())) {
				while(y < 7 && x < 7) {
					y++;
					x++;
					if(getBoard(y, x).equals(player.getMyColor())) {
						y--;
						x--;
						while(getBoard(y, x).equals(player.getEnemyColor())) {
							setBoard(y, x, player.getMyColor());
							y--;
							x--;
						}
						changeFlag = true;
						break;
					} else if(getBoard(y, x).equals("none")) {
						break;
					}
				}
			}
		}
	}
}