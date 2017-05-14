// TetrisPieceZ.java
// Caitlin Coggins

/**
 * TetrisPieceZ creates a new TetrisPiece.
 **/
public class TetrisPieceZ extends TetrisPiece
{
  
    
    /**
     * Creates a new TetrisPieceZ.
     * Sets the values for filledSquares.
     **/
    public TetrisPieceZ()
    {
        filledSquares[0][0][0] = true;
        filledSquares[0][0][1] = true;
        filledSquares[0][1][1] = true;
        filledSquares[0][1][2] = true;
        
        filledSquares[1][0][1] = true;
        filledSquares[1][1][1] = true;
        filledSquares[1][1][0] = true;
        filledSquares[1][2][0] = true;
        
        filledSquares[2][0][0] = true;
        filledSquares[2][0][1] = true;
        filledSquares[2][1][1] = true;
        filledSquares[2][1][2] = true;
        
        filledSquares[3][0][1] = true;
        filledSquares[3][1][1] = true;
        filledSquares[3][1][0] = true;
        filledSquares[3][2][0] = true;
    }
}