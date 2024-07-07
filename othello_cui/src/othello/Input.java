package othello;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
	Scanner scanner = new Scanner(System.in);

	public int inputY() {
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
	public int inputX() {
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
}
