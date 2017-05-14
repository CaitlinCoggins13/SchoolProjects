// TetrisPieceT.java
// Caitlin Coggins

/**
 * TetrisPieceT creates a new TetrisPiece.
 **/
public class TetrisPieceT extends TetrisPiece
{
   
    
    /**
     * Creates a new TetrisPieceT.
     * Sets the values for filledSquares.
     **/
    public TetrisPieceT()
    {
        filledSquares[0][0][1] = true;
        filledSquares[0][1][0] = true;
        filledSquares[0][1][1] = true;
        filledSquares[0][1][2] = true;
        
        filledSquares[1][0][0] = true;
        filledSquares[1][1][0] = true;
        filledSquares[1][1][1] = true;
        filledSquares[1][2][0] = true;
        
        filledSquares[2][0][0] = true;
        filledSquares[2][0][1] = true;
        filledSquares[2][0][2] = true;
        filledSquares[2][1][1] = true;
        
        filledSquares[3][1][0] = true;
        filledSquares[3][0][1] = true;
        filledSquares[3][1][1] = true;
        filledSquares[3][2][1] = true;
    }
}