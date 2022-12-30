package ds1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Board {
	// Add your own PRIVATE fields here.
	// They must have type char, int, boolean, String, or they can be 1D or 2D arrays of these types.
	private char[][] board;
	private char currplayer= 'X';
	private char gameWinner = ' ';
	private int moveCounter = 0;
	
	/**
	 * Constructs a new empty connect 4 game board with player X being the first player
	 * and player 'O' being the second player.
	 */
	public Board() {
		board = new char[6][7];
		//int colCount = new int[7];
		for(int row =0; row <board.length; row++) {
			for(int column = 0; column<board[row].length; column++) {
				board[row][column] = 'E';
			}
		}
	}

	/**
	 * Gets the current player (either 'X' or 'O')
	 * 
	 * @return the current player
	 */
	public char currentPlayer() {
		return currplayer;
	}

	/**
	 * The current player tries to make a move in a given column.  If the move
	 * is valid, the board is updated and {@code true} is returned.  If the move
	 * is invalid (not a valid column number of the column is already full)
	 * the board remains unchanged and {@code false} is returned.  If the game is
	 * already over, a RuntimeException is thrown instead.
	 * 
	 * @param column the column in which to make a move.  For the move to be valid,
	 * the column value must an {@code int} between 1 and 7 inclusive, and
	 * there must have been fewer than 6 moves already made in the given column.
	 * @return {@code true} if the move is valid and false if it is not valid.
	 * @throws RuntimeException if the game is already over.
	 */
	public boolean play(int column) {
		int move = column -1;
		if(gameOver()==false) {
			if(move <0 || move>6) {
				return false;
			}
			if(board[5][move]=='X' || board[5][move]=='O') {
				return false; 
			}
			for(int row = 0; row<6; row++) {
				if(board[row][move]=='E') {
					board[row][move] = currplayer;
					moveCounter += 1;
					break;
				}
			}
			if(currplayer =='X') {
				currplayer = 'O';
			}else {
				currplayer = 'X';
			}
			return true;
		} else {
			throw new RuntimeException("Game is already over!");
		}
			
		}

	

	/**
	 * Determines if the game is already over.
	 * 
	 * @return {@ccode true} if the game is over and {@code false} if it is not over.
	 */
	public boolean gameOver() {
		//horizontal victory
		for(int row = 0; row <board.length; row++) {
			for(int column = 0; column <board[0].length-3; column++) {
				if(board[row][column]== 'X' && board[row][column+1]== 'X' &&board[row][column+2]== 'X' && board[row][column+3]== 'X') {
					gameWinner = 'X';
					return true;
				}
				if(board[row][column]== 'O' && board[row][column+1]== 'O' && board[row][column+2]== 'O' && board[row][column+3]== 'O') {
					//horizontal victory p2
					gameWinner = 'O';
					return true;
				}
		}
		}
		
		//vertical victory
		for(int row = 0; row <board.length -3; row++) {
			for(int column =0; column < board[row].length; column++) {
				if(board[row][column]=='X' && board[row+1][column]== 'X' && board[row+2][column]== 'X' && board[row+3][column]== 'X') {
					gameWinner = 'X';
					return true;
				}							
				if(board[row][column]=='O' && board[row+1][column]== 'O' && board[row+2][column]== 'O' && board[row+3][column]== 'O') {
					gameWinner = 'O';
					return true;
			}
		}
		}
		//upwards diagonal
		for(int row = 3; row <board.length; row++) {
			for(int column = 0; column <board[0].length-3;column++) {
				if(board[row][column]== 'X' && board[row-1][column+1]== 'X' && board[row-2][column+2]== 'X' && board[row-3][column+3]== 'X') {
					
					gameWinner = 'X';
					return true;
				}
				if(board[row][column]== 'O' && board[row-1][column+1]== 'O' && board[row-2][column+2]== 'O' && board[row-3][column+3]== 'O') {
					gameWinner = 'O';
					return true;
				}
			}
		}
		
		//diagonal down victory
		for(int row = 0; row <board.length-3; row++) {
			for(int column = 0; column <board[0].length-3; column++) {
				if(board[row][column] == 'X' && board[row+1][column+1] == 'X' && board[row+2][column+2]=='X' && board[row+3][column+3]=='X') {
					gameWinner = 'X';
					return true;

				}
				if(board[row][column] == 'O' &&board[row+1][column+1]== 'O' &&board[row+2][column+2]== 'O' &&board[row+3][column+3]== 'O') {
					gameWinner = 'O';
					return true;
				}
			}
		}
		if(moveCounter >=42) {
			gameWinner = ' ';
			return true;
		}
		return false;
	}

	/**
	 * Determine the winner (assuming the game is over).
	 * 
	 * @return {@code 'X'} or {@code 'O'} if either player has won and {@code ' '}
	 * if the game is not over or if the game is a draw.
	 */
	public char winner() {
		if (gameWinner == 'X') {
			return 'X';
		} else if(gameWinner == 'O') {
			return 'O'; 
		}else {
			return gameWinner;
		}
	}

	/**
	 * Construct a string describing the state of the game.  You are not requried to implement
	 * this method, however, implementing this method will make debugging much easier so
	 * you are encrouaged to implement this to return a string that looks like the game board.
	 * 
	 * @return a string representation of the game
	 */
	public String toString() {
		String myBoard = "";
		for(int row =0; row <board.length; row++) {
			myBoard+= "|";
			for(int column = 0; column<board[row].length; column++) {
				myBoard += board[row][column];
				myBoard += "|";
			}
			myBoard +="\n";
		}
		return myBoard;
		//return "toString() method not implemented.";
	}

	/*
	 * This main can be used to play a game of Connect 4.  In order to display the game board
	 * you must have defined the toString method.
	 */
	public static void main(String[] args) {
		Board b = new Board();
		while (!b.gameOver()) {
			boolean legalMove = false;
			while (!legalMove) {
				StdOut.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
				StdOut.println(b);
				StdOut.println("Current player: " + b.currentPlayer());
				StdOut.println("Enter column number for next move: ");
				int col = StdIn.readInt();
				legalMove = b.play(col);
			}
		}
		StdOut.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
		StdOut.println(b);
		StdOut.println("GAME OVER");
		if (b.winner() == ' ')
			StdOut.println("It's a draw");
		else
			StdOut.println(b.winner() + " WINS!!!");
	}
}
