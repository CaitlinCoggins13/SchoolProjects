// TetrisPieceL.java
// Caitlin Coggins

/**
 * TetrisPieceL creates a new TetrisPiece.
 **/
public class TetrisPieceL extends TetrisPiece
{
    
    
    /**
     * Creates a new TetrisPieceL.
     * Sets the values for filledSquares.
     **/
    public TetrisPieceL()
    {
        filledSquares[0][0][0]=true;
        filledSquares[0][1][0]=true;
        filledSquares[0][2][0]=true;
        filledSquares[0][2][1]=true;
        
        filledSquares[1][0][0]=true;
        filledSquares[1][0][1]=true;
        filledSquares[1][0][2]=true;
        filledSquares[1][1][0]=true;
        
        filledSquares[2][0][0]=true;
        filledSquares[2][0][1]=true;
        filledSquares[2][1][1]=true;
        filledSquares[2][2][1]=true;
        
        filledSquares[3][0][2]=true;
        filledSquares[3][1][0]=true;
        filledSquares[3][1][1]=true;
        filledSquares[3][1][2]=true;
    }
}