import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



/**
 * @author LAP-2
 *
 */
public class TicTacToe {

	/**
	 * This class  allows the user to play a tic tac toe
	 */
	 
	 
	char[][] board = new char[3][3];
	String player1;
	String player2;
	int currentPlayer;
	char marker1;
	char marker2;
	int plays;

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	

	void init() {
		int counter = 0;
		for (int i = 0; i < 3; i++) {
			for (int index = 0; index < 3; index++) {
				board[i][index] = Character.forDigit(++counter, 10);
			}
		}
		currentPlayer = 1;
		plays = 0;
	}

	void switchPlayers() {
		if (getCurrentPlayer() == 1) {
			setCurrentPlayer(2);
		} else {
			setCurrentPlayer(1);
		}
		setPlays(getPlays() + 1);
	}

	boolean placeMarker(int play) {
		for (int i = 0; i < 3; i++) {
			for (int index = 0; index < 3; index++) {
				if (board[i][index] == Character.forDigit(play, 10)) {
					board[i][index] = (getCurrentPlayer() == 1) ? getMarker1() : getMarker2();
					return true;
				}
			}
		}
		return false;
	}

	boolean winner() {
		// Checking rows
		char current = ' ';
		for (int i = 0; i < 3; i++) {
			int index = 0;
			for (index = 0; index < 3; index++) {
				if (!Character.isLetter(board[i][index])) {
					break;
				}
				if (index == 0) {
					current = board[i][index];
				} else if (current != board[i][index]) {
					break;
				}
				if (index == 2) {
					// Found winner
					return true;
				}
			}
		}
		// Checking columns
		for (int i = 0; i < 3; i++) {
			current = ' ';
			int index = 0;
			for (index = 0; index < 3; index++) {
				if (!Character.isLetter(board[index][i])) {
					break;
				}
				if (index == 0) {
					current = board[index][i];
				} else if (current != board[index][i]) {
					break;
				}
				if (index == 2) {
					// Found winner
					return true;
				}
			}
		}
		// Checking diagonals
		current = board[0][0];
		if (Character.isLetter(current) && board[1][1] == current && board[2][2] == current) {
			return true;
		}
		current = board[2][0];
		if (Character.isLetter(current) && board[1][1] == current && board[0][2] == current) {
			return true;
		}
		return false;
	}

	protected String getRules() {
		StringBuilder builder = new StringBuilder();
		builder.append("--------------------------------- \n");

		return builder.toString();
	}

	String getPrompt() {
		String prompt = "";
		try {
			prompt = reader.readLine();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return prompt;
	}

	String drawBoard() {
		StringBuilder builder = new StringBuilder("Game board: \n");
		for (int i = 0; i < 3; i++) {
			for (int index = 0; index < 3; index++) {
				builder.append("[" + board[i][index] + "]");
			}
			builder.append("\n");
		}
		return builder.toString();
	}

	

	// Getter and Setter
	public int getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(int currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public char getMarker1() {
		return marker1;
	}

	public void setMarker1(char marker1) {
		this.marker1 = marker1;
	}

	public char getMarker2() {
		return marker2;
	}

	public void setMarker2(char marker2) {
		this.marker2 = marker2;
	}

	public int getPlays() {
		return plays;
	}

	public void setPlays(int plays) {
		this.plays = plays;
	}

	public String getPlayer1() {
		return player1;
	}

	public void setPlayer1(String player1) {
		this.player1 = player1;
	}

	public String getPlayer2() {
		return player2;
	}

	public void setPlayer2(String player2) {
		this.player2 = player2;
	}
}