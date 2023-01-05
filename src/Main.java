import java.io.IOException;

public class Main {
	public void play() {

		TicTacToe game = new TicTacToe();
		
	
		System.out.println("<< Welcome to Tic Tac Toe game>>.");
		
		// Ask the user if they want to resume a saved game
        System.out.print("Do you want to resume a saved game? (y/n) ");
        try {
            String response = game.reader.readLine();
            if (response.equalsIgnoreCase("y") || response.equalsIgnoreCase("yes")) {
                game.resume();
            } else {
                game.init();
            }
        } catch (IOException e) {
            System.out.println("Error reading user input: " + e.getMessage());
        }
		
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
		
		
	}

}
