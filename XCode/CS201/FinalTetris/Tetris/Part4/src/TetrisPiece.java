// TetrisPiece.java
// Caitlin Coggins

/**
 * TetrisPiece holds the array for the pieces, the rotation of the pieces, and can tell if a cell in the 
 * array for pieces is true.
 **/
public abstract class TetrisPiece
{
    /** Holds the different rotated forms of the piece. **/
    protected boolean [][][] filledSquares;
    
    /** Holds the rotation of the TetrisPiece. **/
    protected int pieceRotation;
    
    /**
     * Constructor.
     * Initializes filledSquares and pieceRotation.
     **/
    public TetrisPiece()
    {
        filledSquares = new boolean[4][4][4];
        pieceRotation = 0;
    }
    
    /**
     * Returns the piece rotation.
     * @return piecerotation the rotation of the piece
     **/
    public int getPieceRotation()
    {
        return pieceRotation;
    }
    
    /**
     * Checks to see if a cell in filledSquares is true.
     * @param rot the rotation of the TetrisPiece
     * @param row the row of the possible block
     * @param col the column of the possible block
     * @return true if cell is true, false otherwise
     **/
    public boolean isFilled( int rot, int row, int col)
    {
        if(filledSquares[rot][row][col]==true)
            return true;
        else
            return false;
    }
    
    /**
     * Changes the value of pieceRotation one clockwise-rotated value.
     **/
    public void rotateCW()
    {
        pieceRotation = ((pieceRotation + 1) + 4) % 4;
    }
    
    /**
     * Changes the value of pieceRotation one counterclockwise-rotated value.
     **/
    public void rotateCCW()
    {
        pieceRotation = ((pieceRotation - 1) + 4) % 4;
    }
}