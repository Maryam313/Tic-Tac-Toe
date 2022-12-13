package TicTacToeClass;
import java.util.Scanner;

public class TicTac {

	 String one = "1";
	    String two = "2";
	    String three = "3";
	    String four = "4";
	    String five = "5";
	    String six = "6";
	    String seven = "7";
	    String eight = "8";
	    String nine = "9";
	    int win = 0;
	    int end = 0;
	    String player1 = "X";
	    String player2 = "O";

	    public int check(int win) {
	    	// checks row for player1
	        if ((((one == "X") && (two == "X") && (three == "X")) || ((four == "X") && (five == "X") && (six == "X"))
	                || ((seven == "X") && (eight == "X") && (nine == "X")))
	        		// checks column for player1>>
	                || (((one == "X") && (four == "X") && (seven == "X"))
	                        || ((two == "X") && (five == "X") && (eight == "X"))
	                        || ((three == "X") && (six == "X") && (nine == "X")))
	             // checks row for player2 >>
	                || (((one == "O") && (two == "O") && (three == "O")) || ((four == "O") && (five == "O") && (six == "O"))
	                        || ((seven == "O") && (eight == "O") && (nine == "O")))
	             // checks column for player2>>
	                || (((one == "O") && (four == "O") && (seven == "O"))
	                        || ((two == "O") && (five == "O") && (eight == "O"))
	                        || ((three == "O") && (six == "O") && (nine == "O")))
	             // checks the diagonal for player2>>
	                || (((one == "O") && (five == "O") && (nine == "O"))
	                        || ((three == "O") && (five == "O") && (seven == "O")))
	             // checks the diagonal for player1>>
	                || (((one == "X") && (five == "X") && (nine == "X"))
	                        || ((three == "X") && (five == "X") && (seven == "X")))) {
	            return 1;
	        }
	        return 0;
	    }
	    //Fun to check the input>>
	    public int check_input(int input, boolean i) {

	        switch (input) {
	            case 1: {
	                if ((one == "1") && (i == true)) {
	                    one = "X";
	                    win = check(win);
	                    i = false;
	                } else if ((one == "1") && (i == false)) {
	                    one = "O";
	                    win = check(win);
	                    i = true;
	                } else if (one != "1") {
	                    System.out.println("Already entered");
	                    return 5;
	                }
	                break;
	            }
	            case 2: {
	                if ((two == "2") && (i == true)) {
	                    two = "X";
	                    win = check(win);
	                    i = false;
	                } else if ((two == "2") && (i == false)) {
	                    two = "O";
	                    win = check(win);
	                    i = true;
	                } else if (two != "2") {
	                    System.out.println("Already entered");
	                    return 5;
	                }
	                break;
	            }
	            case 3: {
	                if ((three == "3") && (i == true)) {
	                    three = "X";
	                    win = check(win);
	                    i = false;
	                } else if ((three == "3") && (i == false)) {
	                    three = "O";
	                    win = check(win);
	                    i = true;
	                } else if (three != "3") {
	                    System.out.println("Already entered");
	                    return 5;
	                }
	                break;
	            }
	            case 4: {
	                if ((four == "4") && (i == true)) {
	                    four = "X";
	                    win = check(win);
	                    i = false;
	                } else if ((four == "4") && (i == false)) {
	                    four = "O";
	                    win = check(win);
	                    i = true;
	                } else if (four != "4") {
	                    System.out.println("Already entered");
	                    return 5;
	                }
	                break;
	            }
	            case 5: {
	                if ((five == "5") && (i == true)) {
	                    five = "X";
	                    win = check(win);
	                    i = false;
	                } else if ((five == "5") && (i == false)) {
	                    five = "O";
	                    win = check(win);
	                    i = true;
	                } else if (five != "5") {
	                    System.out.println("Already entered");
	                    return 5;
	                }
	                break;
	            }
	            case 6: {
	                if ((six == "6") && (i == true)) {
	                    six = "X";
	                    win = check(win);
	                    i = false;
	                } else if ((six == "6") && (i == false)) {
	                    six = "O";
	                    win = check(win);
	                    i = true;
	                } else if (six != "6") {
	                    System.out.println("Already entered");
	                    return 5;
	                }
	                break;
	            }
	            case 7: {
	                if ((seven == "7") && (i == true)) {
	                    seven = "X";
	                    win = check(win);
	                    i = false;
	                } else if ((seven == "7") && (i == false)) {
	                    seven = "O";
	                    win = check(win);
	                    i = true;
	                } else if (seven != "7") {
	                    System.out.println("Already entered");
	                    return 5;
	                }
	                break;
	            }
	            case 8: {
	                if ((eight == "8") && (i == true)) {
	                    eight = "X";
	                    win = check(win);
	                    i = false;
	                } else if ((eight == "8") && (i == false)) {
	                    eight = "O";
	                    win = check(win);
	                    i = true;
	                } else if (eight != "8") {
	                    System.out.println("Already entered");
	                    return 5;

	                }
	                break;
	            }
	            case 9: {
	                if ((nine == "9") && (i == true)) {
	                    nine = "X";
	                    win = check(win);
	                    i = false;
	                } else if ((nine == "9") && (i == false)) {
	                    nine = "O";
	                    win = check(win);
	                    i = true;
	                } else if (nine != "9") {
	                    System.out.println("Already entered");
	                    return 5;
	                }
	                break;
	            }
	            default: {
	                System.out.println("Invalid entry");
	                break;
	            }
	        }
	        return win;
	    }
	    //Fun to display the Board>>
	    public void displayBoard() {
	        System.out.println("--------------------------------");
	        System.out.println("---------");
	        System.out.println("|" + one + "|" + two + "|" + three + "|");
	        System.out.println("|------|");
	        System.out.println("|" + four + "|" + five + "|" + six + "|");
	        System.out.println("|------|");
	        System.out.println("|" + seven + "|" + eight + "|" + nine + "|");
	        System.out.println("---------");
	    }
	    //Fun for the winner
	    public void win(boolean i) {
	        if (i == true) {
	            System.out.println("Congratulations! X's have win!!! Thanks for playing");
	            System.out.println("The final result of Tic Tac Toe game is ");
	            displayBoard();
	        } else {
	            System.out.println("Congratulations! O's have win!!! Thanks for playing");
	            System.out.println("The final result of Tic Tac Toe game is ");
	            displayBoard();
	        }
	    }
	    
	    //Fun to print the board
	    public void printBoard() {
	        Scanner sc = new Scanner(System.in);
	        boolean i = true;
	        int input;
	        while (true) {
	            System.out.println("<< Welcome to  Tic Tac Toe>>.");
	            displayBoard();
	            System.out.println("X's will play first..");
	            while ((win != 1) && (end <= 9)) {
	                if (end == 9) {
	                    System.out.println("It's a draw! Thanks for playing");
	                    System.out.println("The final result of Tic Tac Toe game is ");
	                    displayBoard();
	                    System.exit(0);
	                }
	                if (i == true) {
	                    System.out.println("Player1's : Please enter the number:");
	                    input = sc.nextInt();
	                    win = check_input(input, i);
	                    if (win == 1) {
	                        win(i);
	                        System.exit(0);
	                    }
	                    if (win == 5) {
	                        continue;
	                    }
	                    i = false;
	                } else if (i == false) {
	                    System.out.println("Player2's : Please enter the number:");
	                    input = sc.nextInt();
	                    win = check_input(input, i);
	                    if (win == 1) {
	                        win(i);
	                        System.exit(0);
	                    }
	                    if (win == 5) {
	                        continue;
	                    }
	                    i = true;
	                }
	                end = end + 1;
	            }
	        }
	    }

	    public static void main(String[] args) {
	    	TicTac t = new TicTac();
	        t.printBoard();
	    }
	}

