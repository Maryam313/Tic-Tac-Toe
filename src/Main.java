import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public void play() {
		TicTacToe game = new TicTacToe();
		
	
		System.out.println("<< Welcome to Tic Tac Toe game>>.");
		System.out.print("-----------------------------");
		
//		// Ask the user if they want to resume a saved game

		
		System.out.print("Enter player one's name: ");
		game.setPlayer1(game.getPrompt());
		System.out.print("Enter player two's name: ");
		game.setPlayer2(game.getPrompt());
		boolean markerOk = false;
		while (!markerOk) {
			System.out.print("Choose X OR O <" + game.getPlayer1() + ">: ");
			String marker = game.getPrompt();
			if (marker.length() == 1 && Character.isLetter(marker.toCharArray()[0])) {
				markerOk = true;
				game.setMarker1(marker.toCharArray()[0]);
			} else {
				System.out.println("Invalid marker");
			}
		}
		markerOk = false;
		while (!markerOk) {
			System.out.print("Choose X OR O <" + game.getPlayer2() + ">: ");
			String marker = game.getPrompt();
			if (marker.length() == 1 && Character.isLetter(marker.toCharArray()[0])) {
				markerOk = true;
				game.setMarker2(marker.toCharArray()[0]);
			} else {
				System.out.println("Invalid marker");
			}
		}

		boolean continuePlaying = true;

		while (continuePlaying) {

			game.init();
			System.out.println();
			System.out.println(game.getRules());
			System.out.println();
			System.out.println(game.drawBoard());
			System.out.println();
			
	
			String player = null;
			while (!game.winner() && game.getPlays() < 9) {
				player = game.getCurrentPlayer() == 1 ? game.getPlayer1() : game.getPlayer2();
				boolean validPick = false;
				while (!validPick) {
					System.out.print("<" + player +" >ol" +"'Please enter the number: ");
					String square = game.getPrompt();
					if (square.length() == 1 && Character.isDigit(square.toCharArray()[0])) {
						int pick = 0;
						try {
							pick = Integer.parseInt(square);
						} catch (NumberFormatException e) {
							// it'll evaluate as an invalid pick on the next row.
						}
						validPick = game.placeMarker(pick);
					}
					if (!validPick) {
						System.out.println("can not be selected!!");
					}
					
				}
				game.switchPlayers();
				System.out.println();
				System.out.println(game.drawBoard());
				System.out.println();
			}
		
			if (game.winner()) {
				System.out.println("Game Over - " + player + " WINS!!!");
			} else {
				System.out.println("Game Over - Draw");
			}
			System.out.println();
			System.out.print("Play again? (Y OR N): ");
			String choice = game.getPrompt();
			if (!choice.equalsIgnoreCase("Y")) {
				continuePlaying = false;
			}
		}
	}


	public static void main(String[] args) {
		Main main = new Main();
		main.play();
	
		File dataStore=new File(Main.DATA_FILE_PATH);
		if(dataStore.exists()) {

		    try {
		    	
		        FileWriter fileWriter = new FileWriter("saved_game.txt",true);
		        char[][] board = new char[3][3];
				String player1;
				String player2;
				int currentPlayer = 0;
				char marker1 = 0;
				char marker2 = 0;
				int plays = 0;
		        // Convert the game state to a string and write it to the file
		        String gameState = board + "," + currentPlayer + "," + plays + "," + marker1 + "," + marker2;
		        fileWriter.write(gameState + "\n");
		        fileWriter.close();
		    } catch (IOException e) {
		        System.out.println("Error saving game: " + e.getMessage());
		    }
		}

		
		    	Scanner scan=new Scanner("saved_game.txt");
		        // Read the game state string from the file and parse it to extract the values
		    	    try {
		    	    	
		    	        FileReader fileReader = new FileReader("saved_game.txt");
		    	        char[][] board = new char[3][3];
		    			String player1;
		    			String player2;
		    			int currentPlayer;
		    			char marker1;
		    			char marker2;
		    			int plays;
		    	        // Read the game state string from the file and parse it to extract the values
		    	        //String gameState = fileReader.readLine();
		    		    String gameState = scan.nextLine();
		    	        String[] values = gameState.split(",");
		    	        // Parse the board string and convert it back to a character array
		    	        board = new char[3][3];
		    	        for (int i = 0; i < 3; i++) {
		    	            for (int j = 0; j < 3; j++) {
		    	                board[i][j] = values[0].charAt(i * 3 + j);
		    	            }
		    	        }
		    	        currentPlayer = Integer.parseInt(values[1]);
		    	        plays = Integer.parseInt(values[2]);
		    	        marker1 = values[3].charAt(0);
		    	        marker2 = values[4].charAt(0);
		    	        fileReader.close();
		    	    } catch (IOException e) {
		    	        System.out.println("Error resuming game: " + e.getMessage());
		    	    }
		    	
	
}
	public static final String DATA_FILE_PATH ="saved_game.txt";

}

