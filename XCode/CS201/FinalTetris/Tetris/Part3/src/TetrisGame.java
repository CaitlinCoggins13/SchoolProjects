// TetrisGame.java
// Caitlin Coggins

/**
 * Creates the TetrisBoard.
 * Attempts to move and rotate pieces.
 * Ends a round when a piece reaches the lowest point it can go, and counts the 
 * lines and tetrises produced.
 **/
public class TetrisGame
{
    /** Instance of a TetrisBoard. **/
    private TetrisBoard board;
    
    /** Number of lines cleared. **/
    private int numLines;
    
    /** Number of tetrises cleared. **/
    private int numTetrises;
    
    /**
     * Constructor.
     * Creates a new TetrisBoard.
     * Initializes numLines and numTetrises.
     **/
    public TetrisGame()
    {
        board = new TetrisBoard();
        numLines = 0;
        numTetrises = 0;
    }
    
    /**
     * Tries to implement the move that the user wants to make, then checks for the end of a round.
     * @param moveType tells what kind of move the user wants to make.
     **/
    public void attemptMove( int moveType )
    {
        switch( moveType )
        {
            case 0: board.moveLeft();
                break;
            case 1: board.moveRight();
                break;
            case 2: board.moveDown();
                break;
            case 3: board.rotateCW();
                break;
            case 4: board.rotateCCW();
                break;
            default: System.out.println("Should never come here");
        }
        
        endRound();
    }
    
    /**
     * Checks to see if the current TetrisPiece has moved down as far as it can go.
     * If it has, it adds the TetrisPiece true cells to the corresponding cells in the board array.
     * It then tries to find any completed lines or tetrises.
     **/
    private void endRound()
    {
        // holds whether or not the piece has landed
        boolean end;
        
        // holds the number of rows in a row that were eliminated
        int tetrisCount=0;
        
        // checks whether or not the piece has landed
        end = board.checkLanded();
        
        // adds piece to board if it has landed
        if(end == true)
        {
            board.landPiece();
        }
        
        // checks every row for completion
        for(int i=17; i>=0; --i)
        {
            if(board.fullLine(i)==true)
            {
                ++tetrisCount;
                
                // removes the completed row and shifts everything above that row down one
                board.removeRow(i);
                
                // checks the row again to see if what moved down was another completed row
                ++i;
            }
            
            // if the next row is not a completed row, adds tetrises and lines completed
            // to numTetrises and numLines
            else
            {
                while(tetrisCount>=4)
                {
                    ++numTetrises;
                    tetrisCount-=4;
                }
                while(tetrisCount>=1)
                {
                    ++numLines;
                    tetrisCount-=1;
                }
            }
            
        }
        // adds any remaining tetrises and lines into numTetrises and numLines
        while(tetrisCount>=4)
        {
            ++numTetrises;
            tetrisCount-=4;
        }
        while(tetrisCount>=1)
        {
            ++numLines;
            tetrisCount-=1;
        }
        
    }
    
    /**
     * Returns the number of lines completed.
     * @return numLines the number of lines completed
     **/
    public int getNumLines()
    {
        return numLines;
    }
    
    /**
     * Returns the number of tetrises completed.
     * @return numTetrises the number of tetrises completed
     **/
    public int getNumTetrises()
    {
        return numTetrises;
    }
    
    /**
     * Returns the TetrisBoard.
     * @return board the TetrisBoard in use
     **/
    public TetrisBoard getTetrisBoard()
    {
        return board;
    }
    
    /**
     * Checks board for a piece of a TetrisPiece in the specified cell.
     * @rowNum the row of the cell
     * @colNum the column of the cell
     * @return tetrisBlock true if there is a piece, false otherwise
     **/
    public boolean testBlock(int rowNum, int colNum)
    {
        boolean tetrisBlock = board.hasBlock(rowNum, colNum);
        
        return tetrisBlock;
    }
}