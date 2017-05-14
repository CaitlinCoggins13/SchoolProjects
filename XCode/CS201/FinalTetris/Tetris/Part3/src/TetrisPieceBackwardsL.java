// TetrisPieceBackwardsL.java
// Caitlin Coggins

/**
 * TetrisPieceBackwardsL creates a new TetrisPiece.
 **/
public class TetrisPieceBackwardsL extends TetrisPiece
{
    /**
     * Creates a new TetrisPieceBackwardsL.
     * Sets the values for filledSquares.
     **/
    public TetrisPieceBackwardsL()
    {
        filledSquares[0][2][0]=true;
        filledSquares[0][0][1]=true;
        filledSquares[0][1][1]=true;
        filledSquares[0][2][1]=true;
        
        filledSquares[1][0][0]=true;
        filledSquares[1][1][0]=true;
        filledSquares[1][1][1]=true;
        filledSquares[1][1][2]=true;
        
        filledSquares[2][0][0]=true;
        filledSquares[2][0][1]=true;
        filledSquares[2][1][0]=true;
        filledSquares[2][2][0]=true;
        
        filledSquares[3][0][0]=true;
        filledSquares[3][0][1]=true;
        filledSquares[3][0][2]=true;
        filledSquares[3][1][2]=true;
    }
}