// TetrisBoardGUIView.java
// Caitlin Coggins

import javax.swing.JComponent;

import java.awt.Graphics;
import java.awt.Color;

/**
 * TetrisBoardGUIView displays the current state of the TetrisBoard.
 **/
public class TetrisBoardGUIView extends JComponent
{
    /* Instance of the current TetrisGame. */
    private TetrisGame game;
    
    /**
     * Constructor.
     * Initializes game.
     * @param game the current TetrisGame
     **/
    public TetrisBoardGUIView(TetrisGame newGame)
    {
        super();
        
        game = newGame;
    }

    /**
     * Calculates the best size for a block based on the size of the JComponent 
     * and the number of rows and columns.
     **/
    private int computeBlockSize()
    {
        int perfectX = getWidth()/game.getCols();
        
        int perfectY = getHeight()/game.getRows();
        
        // The sixe that will actually fit inside the board is used.
        if(perfectX<=perfectY)
            return perfectX;
        else
            return perfectY;
    }

    /**
     * Computes the block size, paints the outline of the board, and paints the squares.
     * @param g Graphics object
     **/
    @Override
    public void paint(Graphics g)
    {
        int size = computeBlockSize();
        
        paintBoardOutline(g, size);
        
        for(int i=0; i<game.getRows(); ++i)
        {
            for(int j=0; j<game.getCols(); ++j)
            {
                // if there is a piece of a block there, paint a block
                if(game.testBlock(i, j) == true)
                    paintBlock(g, i, j, size);
            }
        }

        
    }
    
    /**
     * Paints each square of a tetris block.
     * @param g Graphics object
     * @param row row of the block being painted
     * @param col col of the block being painted
     * @param blockSize the length of one side of the block
     **/
    private void paintBlock( Graphics g, int row, int col, int blockSize)
    {
        // draws filled block
        g.setColor(Color.RED);
        g.fillRect(col*blockSize, row*blockSize, blockSize, blockSize);
        
        // draws black border of block
        g.setColor(Color.BLACK);
        g.drawRect(col*blockSize, row*blockSize, blockSize, blockSize);
    }
    
    /**
     * Paints the outline of the usable part of the board.
     * @param g Graphics object
     * @param blockSize the length of one side of the block
     **/
    private void paintBoardOutline( Graphics g, int blockSize)
    {
        g.drawLine(0, 0, blockSize*game.getCols(), 0);
        g.drawLine(0, 0, 0, blockSize*game.getRows());
        g.drawLine(0, blockSize*game.getRows(), blockSize*game.getCols(), blockSize*game.getRows());
        g.drawLine(blockSize*game.getCols(), 0, blockSize*game.getCols(), blockSize*game.getRows());
    }
}

