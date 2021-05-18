/**
 * @file: UserInterface.java
 * @Author: Anika Krishna Peer (peera1)
 * @Date: April, 9, 2021
 * @Description: Module that displays the game
 */

package src;

public class UserInterface{
// Made great use of the link below:
// https://gitlab.cas.mcmaster.ca/smiths/se2aa4_cs2me3/-/blob/master/Assignments/PreviousYears/2020/A4-Dots/A4Soln/src/UserInterface.java

    private static UserInterface visual = null;


	private UserInterface(){
	}

    /**
     * @brief Obtains an instance of UserInterface. Only once.
     * @return visuaal - a UserInterface object
     */
    public static UserInterface getInstance(){
        if (visual == null){
            return visual = new UserInterface();
        }
        return visual;
    }

    /**
     * @brief Displays welcome message on screen.
     */
    public void printWelcomeMessage(){
    	System.out.println("-----------------------");
    	System.out.println("    Welcome to 2048    ");
    	System.out.println("-----------------------");
    }

    /**
     * @brief Displays current status of board on screen.
     * @param board - BoardT object representing the game board.
     */
    public void printBoard(BoardT board){
        int[][] temp = board.getBoard();
        for (int i = 0; i < temp.length; i ++){
            System.out.println();
            for (int j = 0; j < temp.length; j++){
                System.out.print(temp[i][j] + ", ");
            }
        }
    }

    /**
     * @brief Displays instructions on screen.
     */
    public void printInstructions(){
    	System.out.println("------------------------");
    	System.out.println("      Instructions      ");
    	System.out.println("------------------------");
    	System.out.println("1. Use the arrow keys to slide the tiles.");
    	System.out.println("2. Tiles with the same number will add up and merge when they touch.");
     	System.out.println("3. Tiles will merge in pairs.");
    }

    /**
     * @brief Displays score on screen.
     * @param board - BoardT object representing the game board.
     */
    public void printScore(BoardT board){
    	System.out.println("-------------------------");
    	System.out.println("          Score          ");
    	System.out.println("-------------------------");
    	System.out.println("The score is: "+ board.getScore());
    }

    /**
     * @brief Displays winning message on screen. 
     */
    public void printWinMessage(){
    	System.out.println("-----------------------");
    	System.out.println("        You win!       ");
    	System.out.println("-----------------------");
    }

    /**
     * @brief Displays losing message on screen.
     */
    public void printGameOverMessage(){
    	System.out.println("-----------------------");
    	System.out.println("       Game Over       ");
    	System.out.println("-----------------------");
    }

}