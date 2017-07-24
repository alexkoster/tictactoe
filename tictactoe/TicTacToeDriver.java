package tictactoe;


/**
 * The TicTacToeDriver class is the entry point of execution for the Tic Tac Toe game.  
 * It Instantiates new instances of the Board, Display, and Game classes representing the model, view, and controller components respectively of the MVC software design pattern.
 *
 * @author Alexander Koster
 * @version 2017-07-21
 */
public class TicTacToeDriver
{
    public static void main(String[] args)
    {
        Board tttBoard = new Board(); //model
        Display tttDisplay = new Display(tttBoard); //view
        Game tttGame = new Game(tttBoard, tttDisplay); //controller
        
        tttGame.mainLoop(); //start execution of the game from the controller Game class.
    }
}