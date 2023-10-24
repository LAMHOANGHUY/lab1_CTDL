package lab5;

public class TicTacToe {
	private static final char EMPTY = ' ';
	private char[][] board;

//	 	This method checks all rows and returns true if any of them are marked with
//		all of a single player's markers. Otherwise, returns false.

	public boolean checkRows() {
		for (int i = 0; i < 3; i++) {
			if (board[i][0] != EMPTY && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
				return true;

			}
		}
		return false;
	}

	/*
	 * This method checks all columns and returns true if any of them are marked
	 * with all of a single player's. Otherwise, returns false.
	 */
	public boolean checkColumns() {
		for (int i = 0; i < 3; i++) {
			if (board[0][i] != EMPTY && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
				return true;
			}
		}

		return false;
	}

	/*
	 * This method checks both diagonals and returns true if any of them are marked
	 * with all of a single player's markers. Otherwise, returns false.
	 */
	public boolean checkDiagonals() {
		// Check top-left to bottom-right
		if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != EMPTY) {
			return true;
		}
		// Check bottom-left to top-right
		if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != EMPTY) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		TicTacToe check = new TicTacToe();

		char checkersBoard[][] = { { 'o', 'x', 'x' }, 
								   { 'x', 'o', 'x' }, 
								   { 'x', 'o', 'x' } };
		
		check.board = checkersBoard;
		System.out.println(check.checkRows());

		char checkersBoard2[][] = { { 'o', 'o', 'o' }, 
								 { 'o', 'x', 'x' }, 
								 { 'o', 'x', 'x' } };
		check.board = checkersBoard2;
		System.out.println(check.checkColumns());
		
		char checkersBoard3[][] = { { 'x', 'o', 'o' }, 
				 				 	{ 'o', 'x', 'x' }, 
				 				 	{ 'o', 'o', 'x' } };
		check.board = checkersBoard3 ;
		System.out.println(check.checkDiagonals());
		
	}
}
