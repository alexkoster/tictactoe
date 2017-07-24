package tictactoe;


/**
 * The Position class represents a Cartesian coordinate indicating a square in the tic tac toe board.
 * This class provides functionality via methods to convert a coordinate (row, column) pair to a single integer representing a square (square number).
 * Requires Board class to exist in the same package to access static method Board.getLength().
 * 
 * @author Alexander Koster
 * @version 2017-07-21
 */
public class Position
{
    private int x;
    private int y;
    
    //TODO consider removing this constructor
    /**
     * Construct a Position object by passing in either a whole number (ranging from 0 to one less than the number of squares in the board)
     * or a natural number (ranging from 1 to the number of squares in the board).
     * 
     * @param squareNumber an integer representing a square either starting from 1 if isNatural set to true, or starting from 0 if isNatural is set to false.
     * @param isNatural Boolean indicating whether squareNumber is a whole number (beginning at 0) if false, or a natural number (beginning at 1) if true.
     */
    public Position(int squareNumber, Boolean isNatural)
    {
        //if square number is natural (aka starting from 1) subtract 1 from it to make it a whole number.
        if(isNatural)
        {
            squareNumber--;
        }
        x = squareNumber / Board.getLength();
        y = squareNumber % Board.getLength();
    }
    
    /**
     * Constructor for a Position object accepting a single integer representing a square number between 0 and one less than the number of squares in the board.
     * 
     * @param squareNumber integer between 0 and one less than the number of squares in the board.
     */
    public Position(int squareNumber)
    {
    	x = squareNumber / Board.getLength();
        y = squareNumber % Board.getLength();
    }
    
    /**
     * Construct a Position object by passing in just a square number from 1-9 (or 0-8 if isNatural is set to false)
     * @param squareNumber 
     * @param isNatural Boolean indicating whether squareNumber is a natural number (1-9) or not (then assuming input is 0-8)
     */
    public Position(int inX, int inY)
    {
        // Initialize instance variables
        x = inX;
        y = inY;
    }

    /* Getter methods */
    
    /**
     * Method to get an integer representing this Position object's row.
     * 
     * @return int representing the row of this position object (ranging from 0 to one less than the number of rows).
     */
    public int getRow()
    {
        return x;
    }
    
    /**
     * Method to get an integer representing this Position object's column.
     * 
     * @return int representing the column of this position object (ranging from 0 to one less than the number of columns).
     */
    public int getColumn()
    {
        return y;
    }
    
    /**
     * Method to get a single integer representation of a square (square number).  Similar in function to toString() methods.
     * 
     * @return int representing square number for a Position object ranging from 0 to one less than the number of squares in the board.
     */
    public int toInt()
    {
        return (x*Board.getLength()) + y;
    }
    
    //TODO consider removing this method
    /**
     * Method to get an integer representation of the square represented by this Position object's coordinates suitable for display to user.
     * The integer will range from 1 to the number of squares in the board.
     * 
     * @return int representing square number for a Position object.
     */
    public int toDisplayInt()
    {
    	return toInt() + 1;
    }
    
}