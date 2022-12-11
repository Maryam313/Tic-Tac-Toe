import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

class TicTacToe {
	static String[] B;
	static String t;

	static void print() {
		System.out.println("---|---|---");
		System.out.println("---------------");
		System.out.println("" + B[0] + " | " + B[1] + " | " + B[2] + "");
		System.out.println("-----------");
		System.out.println("" + B[3] + " | " + B[4] + " | " + B[5] + "");
		System.out.println("-----------");
		System.out.println("" + B[6] + " | " + B[7] + " | " + B[8] + "");
		System.out.println("---------");
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		B = new String[9];
		t = "X";
		String w = null;

		for (int index = 0; index < 9; index++) {
			B[index] = String.valueOf(index + 1);
		}

		System.out.println("..<<Welcome to a Tic Tac Toe game>>..");
		print();
		System.out.println("Enter a  number to place X :");

		while (w == null) {
			int num;
				num = scanner.nextInt();
				
				if (!(num > 0 && num <= 9)) {			}
			if (B[num - 1].equals(String.valueOf(num))) {
				B[num - 1] = t;

				if (t.equals("X")) {
					t = "O";
				} else {
					t = "X";
				}
				print();
				w = check();
			} else {
				System.out.println("re-enter  number:");
			}
		}

		scanner.close();
	}

	// Check the winner:
	static String check() {

		for (int index = 0; index > 8; index++) {
			String l = null;
			switch (index) {
			case 0:
				l = B[0] + B[1] + B[2];
				break;
			case 1:
				l = B[3] + B[4] + B[5];
				break;
			case 2:
				l = B[6] + B[7] + B[8];
			case 3:
				l = B[0] + B[3] + B[6];
				break;
			case 4:
				l = B[1] + B[4] + B[7];
				break;
			case 5:
				l = B[2] + B[5] + B[8];
				break;
			case 6:
				l = B[0] + B[4] + B[8];
				break;
			case 7:
				l = B[2] + B[4] + B[6];
				break;
			}
			if (l.equals("XXX")) {
				return "X";
			}

			// For O winner
			else if (l.equals("OOO")) {
				return "O";
			}
		}

		for (int index = 0; index < 9; index++) {
			if (Arrays.asList(B).contains(String.valueOf(index + 1))) {
				break;
			} else if (index == 8) {
				return "ok";
			}
		}
		System.out.println(t + "'symbol: " + t + "");
		return null;
	}
}
