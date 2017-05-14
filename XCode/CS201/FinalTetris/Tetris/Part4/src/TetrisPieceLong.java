// TetrisPieceLong.java
// Caitlin Coggins

/**
 * TetrisPieceLong creates a new TetrisPiece.
 **/
public class TetrisPieceLong extends TetrisPiece
{
    
    /**
     * Creates a new TetrisPieceLong.
     * Sets the values for filledSquares.
     **/
    public TetrisPieceLong()
    {
        filledSquares[0][0][0] = true;
        filledSquares[0][1][0] = true;
        filledSquares[0][2][0] = true;
        filledSquares[0][3][0] = true;
        
        filledSquares[1][0][0] = true;
        filledSquares[1][0][1] = true;
        filledSquares[1][0][2] = true;
        filledSquares[1][0][3] = true;
        
        filledSquares[2][0][0] = true;
        filledSquares[2][1][0] = true;
        filledSquares[2][2][0] = true;
        filledSquares[2][3][0] = true;
        
        filledSquares[3][0][0] = true;
        filledSquares[3][0][1] = true;
        filledSquares[3][0][2] = true;
        filledSquares[3][0][3] = true;
    }
}