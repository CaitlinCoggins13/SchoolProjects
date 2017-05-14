// TetrisBoard
// Caitlin Coggins

// lang
import java.lang.Math.*;

/**
 * Holds the location of the blocks on the board and the location of the TetrisPiece.
 * Randomly chooses new TetrisPieces to be created.
 * Checks if moves are possible and executes some moves.
 * Checks if there is a block at a specific row and column.
 * Adds pieces to the board array when they reach the bottom of the board.
 **/
public class TetrisBoard
{
    /** The number of rows in a TetrisBoard. **/
    private static int NUM_ROWS = 18;
    
    /** The number of columns in a TetrisBoard. **/
    private static int NUM_COLS = 10;
    
    /** Holds the tetris blocks settled on the board. **/
    private boolean board[][];
    
    /** Instance of a TetrisPiece. **/
    private TetrisPiece currentPiece;
    
    /** Holds row and column values for the upper left corner of the filledSquares TetrisPiece array. **/
    private int[] currentGridPosition;
    
    /**
     * Constructor.
     * Initializes board.
     * Adds a new TetrisPiece and initializes the array that tells where the piece is.
     **/
    public TetrisBoard()
    {
        board = new boolean[NUM_ROWS][NUM_COLS];
        
        addNewPiece();
        
        initCurrentGP();
    }
    
    /**
     * Randomly generates an integer that selects which kind of piece will be created.
     **/
    public void addNewPiece()
    {
        int pickPiece;
        
        // randomly generated number between 0 and 6 is produced
        pickPiece = (int)(Math.random()*7);
        
        // chooses the piece associated with the number that was generated
        switch(pickPiece)
        {
            case 0: currentPiece = new TetrisPieceBackwardsL();
                break;
            case 1: currentPiece = new TetrisPieceBackwardsZ();
                break;
            case 2: currentPiece = new TetrisPieceL();
                break;
            case 3: currentPiece = new TetrisPieceLong();
                break;
            case 4: currentPiece = new TetrisPieceSquare();
                break;
            case 5: currentPiece = new TetrisPieceT();
                break;
            case 6: currentPiece = new TetrisPieceZ();
                break;
            default: System.out.println("We shouldn't be here...");
        }
    }
    
    /**
     * Checks to see if the move is possible.
     * If it is, executes the move.
     **/
    public void moveLeft()
    {
        // checks if the move is possible
        boolean left = detectCollision(currentPiece, currentPiece.getPieceRotation(), currentGridPosition[0], currentGridPosition[1]-1);

        // moves the corner of the filledSquares array one column to the left
        if (left == false)
            currentGridPosition[1]-=1;
    }
    
    /**
     * Checks to see if the move is possible.
     * If it is, executes the move.
     **/
    public void moveRight()
    {
        // checks if the move is possible
        boolean right = detectCollision(currentPiece, currentPiece.getPieceRotation(), currentGridPosition[0], currentGridPosition[1]+1);
        
        // moves the corner of the filledSquares array one column to the right
        if (right == false)
        {
            currentGridPosition[1]+=1;
        }
    }
    
    /**
     * Checks to see if the move is possible.
     * If it is, executes the move.
     **/
    public void moveDown()
    {
        // checks if the move is possible
        boolean down = detectCollision(currentPiece, currentPiece.getPieceRotation(), currentGridPosition[0]+1, currentGridPosition[1]);
        
        // moves the corner of the filledSquares array one row down
        if (down == false)
        {
            currentGridPosition[0]+=1;
        }
    }
    
    /**
     * Checks to see if the rotation is possible.
     * If it is, executes the rotation.
     **/
    public void rotateCW()
    {
        // gets the rotation the user wants to change to
        int newRotation = ( ( currentPiece.getPieceRotation() + 1) + 4) % 4;
        
        // checks if the rotation is possible
        boolean cw = detectCollision(currentPiece, newRotation, currentGridPosition[0], currentGridPosition[1]);
        
        // rotates the piece clockwise
        if ( cw == false )
            currentPiece.rotateCW();
    }
    
    /**
     * Checks to see if the rotation is possible.
     * If it is, executes the rotation.
     **/
    public void rotateCCW()
    {
        // gets the rotation the user wants to change to
        int newRotation = ( ( currentPiece.getPieceRotation() - 1) + 4) % 4;
        
        // checks if the rotation is possible
        boolean ccw = detectCollision(currentPiece, newRotation, currentGridPosition[0], currentGridPosition[1]);
        
        // rotates the piece counterclockwise
        if ( ccw == false )
            currentPiece.rotateCCW();
    }
    
    /**
     * Checks if a piece is at the lowest point it can go.
     * @return true if there is a collision, false otherwise
     **/
    public boolean checkLanded()
    {
        // checks if piece could move down further
        boolean bottom = detectCollision(currentPiece, currentPiece.getPieceRotation(), currentGridPosition[0]+1, currentGridPosition[1]);
        
        if (bottom == false)
            return false;
        else
            return true;
    }
   
    /**
     * Checks if the piece is hitting any blocks on the board.
     * @param piece the current TetrisPiece
     * @param rot the rotation of the TetrisPiece
     * @param gridRow the row of the cell being tested
     * @param gridCol the column of the cell being tested
     * @return true if there is a piece outside, false otherwise
     **/
    private boolean detectCollision(TetrisPiece piece, int rot, int gridRow, int gridCol)
    {
        
        for(int i=0; i<piece.filledSquares.length; ++i)
        {
            for(int j=0; j<piece.filledSquares[i].length; ++j)
            {
                // if the area being checked is out of bounds of the board array
                if(gridRow+i >= board.length || gridCol+j >= board[0].length || gridCol <0)
                {
                    if(detectOutOfBounds(piece, rot, gridRow+i, gridCol+j)==true)
                        return true;
                }
                
                // if the area is inside the array
                else
                {
                    // if there is a collision, return true
                    if(piece.isFilled(rot, i, j)==true && board[gridRow+i][gridCol+j]==true)
                        return true;
                }
            }
        }
        // return false if there are no collisions
        return false;
    }
    
    /**
     * Checks if there is a part of the piece outside the bounds of the board.
     * @param piece the current TetrisPiece
     * @param rot the rotation of the TetrisPiece
     * @param gridRow the row of the cell being tested
     * @param gridCol the column of the cell being tested
     * @return true if there is a piece outside, false otherwise
     **/
    private boolean detectOutOfBounds(TetrisPiece piece, int rot, int gridRow, int gridCol)
    {
        boolean outside;
        
        // case if a part of the piece array is off the right side
        if(gridCol >= 10)
        {
            for( int i=0; i<4; ++i)
            {
                for(int j=13-gridCol; j<4; ++j)
                {
                    outside = piece.filledSquares[rot][i][j];
                
                    // if there is a piece in the part outside the board array
                    if(outside)
                        return true;
                }
            }
        }
        
        // case if a part of the piece array is off the left side
        if(gridCol == -1)
        {
            for( int i =0; i<4; ++i)
            {
                outside = piece.filledSquares[rot][i][0];
                
                // if there is a piece in the part outside the board array
                if( outside )
                    return true;
            }
        }
        
        // case if a part of the piece array is off the bottom
        if(gridRow >= 18)
        {
            for(int j = 21-gridRow; j<4; ++j)
            {
                for( int i =0; i<4; ++i)
                {
                    outside = piece.filledSquares[rot][j][i];
                
                    // if there is a piece in the part outside the board array
                    if( outside )
                        return true;
                }
            }
        }
        
        return false;
    }
    
    /**
     * Checks to see if a row is full or not.
     * @param row the row being tested
     * @return true if the row is complete, false otherwise
     **/
    public boolean fullLine( int row )
    {
        boolean seeRow = true;
        
        for(int i = 0; i<board[0].length; ++i)
        {
            if(board[row][i]==false)
            {
                seeRow=false;
                break;
            }
        }
        
        if(seeRow)
            return true;
        else
            return false;
    }
    
    /**
     * Initializes the grid position array.
     **/
    private void initCurrentGP()
    {
        // initializes the array
        currentGridPosition = new int[2];
        
        // starting location of the pieces
        currentGridPosition[0] = 0;
        currentGridPosition[1] = 3;
    }
    
    /**
     * Checks if there is a block in the board or in the TetrisPiece at a location in the board.
     * @param row the row of the cell being tested
     * @param col the column of the cell being tested
     * @return true if there is a block, false if there isn't
     **/
    public boolean hasBlock(int row, int col)
    {
        // if there is a block in the board at this location
        if( board[row][col] == true)
            return true;
        // maybe there is a piece of the current TetrisPiece there
        else
        {
            // does the row and column specified match up with where the TetrisPiece is
            if(row>=currentGridPosition[0] && row<= currentGridPosition[0]+3)
            {
                if(col>=currentGridPosition[1] && col<= currentGridPosition[1]+3)
                {
                    // is there a piece of a TetrisPiece there
                    boolean filled = currentPiece.filledSquares[currentPiece.getPieceRotation()][row-currentGridPosition[0]][col-currentGridPosition[1]];
                    // if there is
                   if( filled == true)
                       return true;
                }
            }
        }
        // if there is no block there
        return false;
    }
    
    /**
     * Adds the TetrisPiece blocks to the board array.
     **/
    public void landPiece()
    {
        for(int i=0; i<4; ++i)
        {
            for(int j=0; j<4; ++j)
            {
                // ignore anythig outside the bounds of the board array; there were already checks
                // to make sure nothing was in these cells
                if(currentGridPosition[0]+i >= board.length|| currentGridPosition[1]+j >= board[0].length)
                {
                
                }
                 // add the block to the board array
                else if(currentPiece.filledSquares[currentPiece.getPieceRotation()][i][j] == true)
                {
                    board[currentGridPosition[0]+i][currentGridPosition[1]+j] = true;
                }
            }
        }
        
        // resets the location of the piece
        currentGridPosition[0] = 0;
        currentGridPosition[1] = 3;
        
        // creates a new piece
        addNewPiece();
    }
    
    /**
     * Removes every block in a completed row and moves everything else above this row down one.
     * @param row the row being checked
     **/
    public void removeRow( int row )
    {
        // gets rid of blocks in the row
        for(int i=0; i<board[0].length; ++i)
        {
            board[row][i] = false;
        }
        
        // moves everything above the deleted row down
        for(int i=row; i>0; --i)
        {
            for( int j=0; j<board[0].length; ++j)
            {
                board[i][j]=board[i-1][j];
            }
        }
    }
     
    
    
    
}