// TetrisPieceBackwardsZ.java
// Caitlin Coggins

/**
 * TetrisPieceBackwardsZ creates a new TetrisPiece.
 **/
public class TetrisPieceBackwardsZ extends TetrisPiece
{
    
    
    /**
     * Creates a new TetrisPieceBackwardsZ.
     * Sets the values for filledSquares.
     **/
    public TetrisPieceBackwardsZ()
    {
        filledSquares[0][1][0] = true;
        filledSquares[0][1][1] = true;
        filledSquares[0][0][1] = true;
        filledSquares[0][0][2] = true;
        
        filledSquares[1][0][0] = true;
        filledSquares[1][1][0] = true;
        filledSquares[1][1][1] = true;
        filledSquares[1][2][1] = true;
        
        filledSquares[2][1][0] = true;
        filledSquares[2][1][1] = true;
        filledSquares[2][0][1] = true;
        filledSquares[2][0][2] = true;
        
        filledSquares[3][0][0] = true;
        filledSquares[3][1][0] = true;
        filledSquares[3][1][1] = true;
        filledSquares[3][2][1] = true;
    }
}