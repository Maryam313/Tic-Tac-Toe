/**
 * 
 */
package TicTacToeClass;

/**
 * @author LAP-2
 *
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class test {
		    // Constants
		    public static final int X = 1, O = -1;
		    public static final int EMPTY = 0;

		    public static int rows, cols;
		    public static int[][] board;
		    public static Scanner in;

		    public static void main(String[] args) throws IOException {
		        in = new Scanner(System.in);

		        // Read the board dimensions from the input file
		        File file = new File("input.txt");
		        try (Scanner inputFile = new Scanner(file)) {
					rows = inputFile.nextInt();
					cols = inputFile.nextInt();

					// Initialize the board
					board = new int[rows][cols];
					for (int i = 0; i < rows; i++) {
					    for (int j = 0; j < cols; j++) {
					        board[i][j] = inputFile.nextInt();
					    }
					}
				}
		        // Print the initial board
		        System.out.println("Current board:");
		        printBoard();

		        // Play the game
		        while (true) {
		            // X's turn
		            int xRow, xCol;
		            do {
		                System.out.println("X's turn. Enter row and column: ");
		                xRow = in.nextInt();
		                xCol = in.nextInt();
		            } while (!placeMark(xRow, xCol, X));
		            System.out.println("X placed at (" + xRow + ", " + xCol + ")");
		            printBoard();
		            if (isWin(X)) {
		                System.out.println("X wins!");
		                break;
		            }
		            if (isDraw()) {
		                System.out.println("Draw!");
		                break;
		            }

		            // O's turn
		            int oRow, oCol;
		            do {
		                System.out.println("O's turn. Enter row and column: ");
		                oRow = in.nextInt();
		                oCol = in.nextInt();
		            } while (!placeMark(oRow, oCol, O));
		            System.out.println("O placed at (" + oRow + ", " + oCol + ")");
		            printBoard();
		            if (isWin(O)) {
		                System.out.println("O wins!");
		                break;
		            }
		            if (isDraw()) {
		                System.out.println("Draw!");
		                break;
		            }
		        }
		    }

		    // Place a mark on the board at the specified row and column
		    // Returns true if the mark was successfully placed, false otherwise
		    public static boolean placeMark(int row, int col, int player) {
		        if (row < 0 || row >= rows || col < 0 || col >= cols || board[row][col] != EMPTY) {
		            return false;
		        }
		        board[row][col] = player;
		        return true;
		    }

		    // Check if the player has won the game
		    public static boolean isWin(int player) {
		        // Check rows and columns
		        for (int i = 0; i < rows; i++) {
		        	if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
		                return true;
		            }
		            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
		                return true;
		            }
		        }
		        // Check diagonals
		        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
		            return true;
		        }
		        if (board[2][0] == player && board[1][1] == player && board[0][2] == player) {
		            return true;
		        }
		        return false;
		    }

		    // Check if the game is a draw
		    public static boolean isDraw() {
		        for (int i = 0; i < rows; i++) {
		            for (int j = 0; j < cols; j++) {
		                if (board[i][j] == EMPTY) {
		                    return false;
		                }
		            }
		        }
		        return true;
		    }

		    // Print the current state of the board
		    public static void printBoard() {
		        for (int i = 0; i < rows; i++) {
		            for (int j = 0; j < cols; j++) {
		                if (board[i][j] == X) {
		                    System.out.print("X");
		                } else if (board[i][j] == O) {
		                    System.out.print("O");
		                } else {
		                    System.out.print(" ");
		                }
		                if (j < cols - 1) {
		                    System.out.print("|");
		                }
		            }
		            System.out.println();
		            if (i < rows - 1) {
		                System.out.println("-----");
		            }
		        }
		    }
		}
		