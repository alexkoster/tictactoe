package tictactoe;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * The Display class is used to represent the View component of the Model-View-Controller design pattern. 
 * Here, the Display class is mainly responsible for receiving input from the user and outputting messages and game state information to the console.
 * This abstraction moves all the user input/output to a single place (the Display class) allowing other classes to deal with other functionality of the game.
 *
 * @author Alexander Koster
 * @version 2017-07-21
 */
public class Display
{
	// Static fields
	private static final int QUIT_SIGNAL = -1;

	
	// Instance variables
    private Board myBoard;

    /**
     * Constructor for objects of class Display
     * @param b a Board object to Display
     */
    public Display(Board b)
    {
        myBoard = b;
    }

    /**
     * Static method to return QUIT_VALUE an internal value representing the user wishes to quit the game
     * 
	 * @return int QUIT_VALUE field (-2)
	 */
	public static int getQuitSignal()
	{
		return QUIT_SIGNAL;
	}

	/**
     * Prints a representation of myBoard's current state to the console.  Board generated using overridden toString() method.
     */
    public void printBoard()
    {
        System.out.println(myBoard.toString());
    }
    
    /**
     * Method used to prompt the player to select a square and input its numeric value.
     * 
     * @return int representing the value the user provided.
     *
     */
    public int promptPlayer()
    {
        Scanner sc = new Scanner(System.in);
        boolean continueLoop = true;
        int value = QUIT_SIGNAL; // Here using QUIT_SIGNAL to initialize value without providing a meaningful/correct input such as 0, which could represent a square number.
        while(continueLoop)
        {
        	System.out.print("Enter square number or enter a letter to quit: ");
        	try
        	{
        		value = sc.nextInt();
        		
        	}
        	catch (InputMismatchException ime) // A letter was entered
        	{
        		continueLoop = false;
        		return QUIT_SIGNAL;
        	}

        	// Checking if value within bounds of tic tac toe board grid
        	if(value < 1 || value > myBoard.getTotalSquares())
        	{
        		printIllegalMoveMessage();
        		continueLoop = true;
        	}
        	else
        	{
        		continueLoop = false;
        	}
        }
        return value;
    }
   
    /**
     * Displays a welcome message to the console.  Used when the game begins.
     */
    public void printWelcomeMessage()
    {
        System.out.println("Welcome to Tic Tac Toe!\nWritten by Alex Koster (http://github.com/alexkoster)");
    }
    
    /**
     * Displays a message to the console indicating to the user the square they selected is occupied.
     */
    public void printSquareOccupiedMessage()
    {
    	System.out.println("Square occupied. Please try again.");
    }
    
    /**
     * Displays a message to the console indicating an illegal move was selected.  Used while the game is being played.
     */
    public void printIllegalMoveMessage()
    {
        System.out.println("You have attempted to make an illegal move.");
    }
    
    /**
     * Prints player's symbol
     * 
     * @param p Player enum to be printed to console
     */
    public void printPlayerSymbol(Player p)
    {
        System.out.print("Player ");
        System.out.println(p.name());
    }
    
    /**
     * Displays a message to the console indicating the game was drawn.  Used when the game ends in a draw.
     */
    public void printDrawMessage()
    {
        System.out.println("No more moves! Game drawn!");
    }
    
    /**
     * Displays a message to the console indicating a player has won the game.  Used at the end of a game if the game is not drawn.
     */
    public void printWinMessage()
    {
    	System.out.println();
        System.out.print(myBoard.getHasWon().name());
        System.out.println(" has won!");
    }
    
    /**
     * Displays a message to the console indicating that the quit request was recieved and acted upon.
     */
    public void printQuitMessage()
    {
    	System.out.println("Quitting game!");
    }
}