/**
 * @file: BoardT.java
 * @Author: Anika Krishna Peer (peera1)
 * @Date: April, 9, 2021
 * @Description: Module that stores the state and status of the game
 */
 // https://gitlab.cas.mcmaster.ca/smiths/se2aa4_cs2me3/-/blob/master/Assignments/PreviousYears/2020/A4-Dots/A4Soln/src/BoardT.java
package src;
import java.util.Random;

public class BoardT{

    // State Variables
    private int[][] board = new int[4][4]; // CellType
    private int score = 0;

	/**
	* @brief Constructor method for BoardT object
	* @details BoardT is made up of a sequence of a sequence of natural numbers. 
	* It is also made up of an associated score. Make sure to start off with
	* 2 random tiles. 
	* @param board - A sequence of a sequence of  natural numbers representing
	* a game board.
	* @param score - A natural number representing the current game score.
	*/
    public BoardT(){
    	this.board = board;
    	this.score = score;
    	randTile();
    	randTile();
    }

	/**
	* @brief Getter method that returns the current score.
	* @return this.score which is a natural number representing score.
	*/
	public int getScore(){
		return this.score;
	} 

	/**
	* @brief Getter method that returns the game board as a sequence of 
	* a sequence of natural numbers.
	* @return a 2d int array representing the game board.
	*/
	public int[][] getBoard(){
		int [][] boardVal = new int[this.board.length][this.board.length];
    	for(int i = 0; i < this.board.length; i++){
			for(int j = 0; j < this.board.length; j++){
				boardVal[i][j] = this.board[i][j];
			}
		}
		return boardVal;
	}

	/**
	* @brief Setter method that changes the state of the board.
	* @details The method takes in a 2d array and replaces all the values in
	* the current board with new values. Thios is used expressly for testing
	* pruposes.
	* @param matrix - a 2d integer array that will rperesnt the values in
	* the game board.
	*/
	public void changeBoard(int[][] matrix){
    	for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix.length; j++){
				this.board[i][j] = matrix[i][j];
			}
		}
	}

	/**
	* @brief updates the score for the board.
	* @details The method takes in a tile value and then adds it to the
	* current score.
	* @param tile - a natural number representing a merged tile value to be
	* added to the current score.
	*/
	public void updateScore(int tile){ //will add the value of the most recent merged tile.
		this.score = this.score + tile;
	}

	/**
	* @brief Ads a random tile (2 or 4) to a random location on the board. 
	* @details The method uses two random functions. The first one picks 
	* between 2 or 4 as a tile value. The second one picks a place on the
	* board that is empty. Then that tile goes to that location on the board
	* to be updated. 
	*/
	public void randTile(){
		// https://www.educative.io/edpresso/how-to-generate-random-numbers-in-java
		int min = 2;
		int max = 4;
		int min2 = 0;
		int max2 = 3;
		int returnNum = 0;
		int i = 0;
		int j = 0;
		do{
			returnNum = (int)Math.floor(Math.random()*(max-min+1)+min);
		}while(returnNum == 3);

		do{
			i = (int)Math.floor(Math.random()*(max2-min2+1)+min2);
			j = (int)Math.floor(Math.random()*(max2-min2+1)+min2);
		}while(this.board[i][j] != 0);
		this.board[i][j] = returnNum; 
	}

	/**
	* @brief Updates the board with tiles slid in a particular direction.
	* @details The method calls some helper methods that will slide all
	* tiles on the board to the given direction and merge the adjacent tiles.
	* @param direction - A directionT enum that is used to detrmine which
	* direction the tiles slide in.
	*/
	public void slide(DirectionT direction){
		if (direction == DirectionT.left){
			slideLeft();
			mergeLeft();
			slideLeft();
		}
		if(direction == DirectionT.right){
			slideRight();
			mergeRight();
			slideRight();
		}
		if(direction == DirectionT.up){
			slideUp();
			mergeUp();
			slideUp();
		}
		if(direction == DirectionT.down){
			slideDown();
			mergeDown();
			slideDown();
		}
	}

	/**
	* @brief returns true if  the game has been won. 
	* @return This method will return a boolean value associated with
	* whether or not there is a tile with a value >= 2048.
	*/
	public boolean gameWon(){
		for(int i = 0; i < this.board.length; i++){
			for(int j = 0; j < this.board.length; j++){
				if(this.board[i][j] >= 2048){
					return true;
				}
			}
		}
		return false;
	}

	/**
	* @brief returns true if the game has been lost.
	* @return This method returns whether or not there are still possible
	* moves for the player. Which would entail
	*/
	public boolean gameLost(){
		if(fullBoard()){
			for(int i = 0; i < this.board.length; i++){
				for(int j = 0; j < this.board.length; j++){
					if (areStillMoves(i, j)){
						return false; // game not lost
					}
				}
			}
		}
		return true; // game lost
	}	

//---------------------------------------- Private Methods-------------------------------
	/**
	* @brief returns true if the board is full
	* @details This method is meant to be used as part of checking if a game 
	* has been lost. By running through every cell, if the value is not 0,
	* we know that it is full and if all the cells are full, the board is full.
	* @return A boolean that shows whether the board is full or not.
	*/
	private boolean fullBoard(){
		for(int i = 0; i < this.board.length; i++){
			for(int j = 0; j < this.board.length; j++){
				if(this.board[i][j] == 0){
					return false;
				}
			}
		}
		return true;
	}

	/**
	* @brief returns true if there is a possible merge.
	* @details This method is meant to be used as part of checking if a game 
	* has been lost. If we found that a board is full, then we can make use of
	* this method to check if there are any possible merges that will free up a
	* cell on the game board. The checking just sees if a merge can happen in
	* any of the directions that the tiles can move in.
	* @param i - A natural number representing a row in the board.
	* @param j - A natural number representing a column in the board.
	* @return This method will return a booleab value denoting if there are 
	* possible moves on the full board.
	*/
	private boolean areStillMoves(int i, int j){

		if (!(j + 1 > this.board.length)){
			if (this.board[i][j] == this.board[i][j+1]){
				return true;
			}
		}
		if (!(j - 1 < 0)){
			if (this.board[i][j] == this.board[i][j-1]){
				return true;
			}
		}
		if (!(i + 1 > this.board.length)){
			if (this.board[i][j] == this.board[i+1][j]){
				return true;
			}
		}
		if (!(i - 1 < 0)){
			if (this.board[i][j] == this.board[i-1][j]){
				return true;
			}
		}
		return false;
	}

	/**
	* @brief Slides all tiles to the left
	* @details As long as the left column is not full or a boundary, this
	* method will check for values and while there is a possibility, move them
	* as many columns to the left as possible. It will only move for cells 
	* with tiles (!= 0).
	*/
	private void slideLeft(){
        for (int row = 0; row < this.board.length; row++){
        	for (int col = 0; col < this.board.length; col++){
        		int value = col;
        		while ((value - 1 >= 0) && this.board[row][value] != 0){
        			if (board[row][value - 1] == 0){
        				this.board[row][value - 1] = this.board[row][value];
        				this.board[row][value] = 0;
        				value--;
        			}
        			else{
        			    break;
        			}
        		}
        	}
        	
        }
	}

	/**
	* @brief Slides all tiles to the right
	* @details As long as the right column is not full or a boundary, this
	* method will check for values and while there is a possibility, move them
	* as many columns to the right as possible. It will only move for cells 
	* with tiles (!= 0).
	*/
	private void slideRight(){
        for (int row = 0; row < this.board.length; row++){
        	for (int col = this.board.length-1; col >= 0; col--){
        		int value = col;
        		while ((value + 1 < board.length) && this.board[row][value] != 0){
        			if (this.board[row][value + 1] == 0){
        				this.board[row][value + 1] = this.board[row][value];
        				this.board[row][value] = 0;
        				value++;
        			}
        			else{
        			    break;
        			}
        		}
        	}
        	
        }
	}

	/**
	* @brief Slides all tiles upwards
	* @details As long as the upper row is not full or a boundary, this
	* method will check for values and while there is a possibility, move them
	* as many rows upwards as possible. It will only move for cells 
	* with tiles (!= 0).
	*/
	private void slideUp(){
        for (int row = 0; row < this.board.length; row++){
        	for (int col = 0; col < this.board.length; col++){
        		int value = row;
        		while ((value - 1 >= 0) && this.board[value][col] != 0){
        			if (this.board[value - 1][col] == 0){
        				this.board[value - 1][col] = this.board[value][col];
        				this.board[value][col] = 0;
        				value--;
        			}
        			else{
        			    break;
        			}
        		}
        	}
        }
    }

	/**
	* @brief Slides all tiles downwards
	* @details As long as the lowest row is not full or a boundary, this
	* method will check for values and while there is a possibility, move them
	* as many rows downwards as possible. It will only move for cells 
	* with tiles (!= 0).
	*/
    private void slideDown(){
        for (int row = 0; row < this.board.length; row++){
        	for (int col = this.board.length-1; col >= 0; col--){
        		int value = row;
        		while ((value + 1 < board.length) && this.board[value][col] != 0){
        			if (this.board[value + 1][col] == 0){
        				this.board[value + 1][col] = this.board[value][col];
        				this.board[value][col] = 0;
        				value++;
        			}
        			else{
        			    break;
        			}
        		}
        	}
        	
        }    	
    }

	/**
	* @brief Merges tiles to the left
	* @details Checks if a tile is the same as the one to its right. If so,
	* it runs the helper method merge. It runs left to right specifically 
	* because if there were three in a row, the leftmost 2 cells would be
	* merged so it makes sense to account for those first.
	*/
	private void mergeLeft(){
		for (int row = 0; row < this.board.length; row++){
			for (int col = 0; col <this.board.length; col++){
				if (col+1 < this.board.length){
					if ((this.board[row][col] == this.board[row][col + 1]) && (this.board[row][col] != 0)){
						merge(row, col, row, col + 1);
					}
				}
			}
		}
	}

	/**
	* @brief Merges tiles to the right
	* @details Checks if a tile is the same as the one to its left. If so,
	* it runs the helper method merge. It runs right to left specifically 
	* because if there were three in a row, the rightmost 2 cells would be 
	* merged so it makes sense to account for those first.
	*/
	private void mergeRight(){
		for (int row = 0; row < this.board.length; row++){
			for (int col = this.board.length - 1; col >= 0; col--){
				if (col-1 >= 0){
					if ((this.board[row][col] == this.board[row][col - 1]) && (this.board[row][col] != 0)){
						merge(row, col, row, col - 1);
					}
				}
			}
		}
	}	

	/**
	* @brief Merges tiles upwards
	* @details Checks if a tile is the same as the one below it. If so,
	* it runs the helper method merge. It runs top to bottom specifically 
	* because if there were three in a row, the topmost 2 cells would be 
	* merged so it makes sense to account for those first.
	*/
	private void mergeUp(){
		for (int row = 0; row < this.board.length; row++){
			for (int col = 0; col < this.board.length; col++){
				if (row + 1 < this.board.length){
					if ((this.board[row][col] == this.board[row + 1][col]) && (this.board[row][col] != 0)){
						merge(row, col, row + 1, col);
					}
				}
			}
		}
	}

	/**
	* @brief Merges tiles downwards
	* @details Checks if a tile is the same as the one above it. If so,
	* it runs the helper method merge. It runs bottom to top specifically 
	* because if there were three in a row, the lowest 2 cells would be 
	* merged so it makes sense to account for those first.
	*/
	private void mergeDown(){
		for (int row = this.board.length - 1; row >= 0; row--){
			for (int col = 0; col < this.board.length; col++){
				if (row-1 >= 0){
					if ((this.board[row][col] == this.board[row - 1][col]) && (this.board[row][col] != 0)){
						merge(row, col, row - 1, col);
					}
				}
			}
		}
	}

	/**
	* @brief Merges tiles into the specified cell.
	* @details Takes in indices of the merging and merges the tiles into
	* the merge cell indices. Then it replaces the merged tile with 0. 
	* @param row - Natural number representing the row of the cell that will
	* be merged into.
	* @param col - Natural number representing the column of the cell that will
	* be merged into.
	* @param row1 - Natural number representing the row of the cell that 
	* does the merging.
	* @param col1 - Natural number representing the column of the cell that 
	* does the merging.
	*/
	private void merge(int row, int col, int row1, int col1){
		this.board[row][col] = this.board[row][col] * 2;
		updateScore(this.board[row][col]);
		this.board[row1][col1] = 0;
	}

}
