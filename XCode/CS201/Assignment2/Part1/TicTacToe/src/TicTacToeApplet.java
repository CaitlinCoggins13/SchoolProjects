// TicTacToeApplet.java
// Caitlin Coggins

// awt
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// swing
import javax.swing.JButton;
import javax.swing.JApplet;
import javax.swing.JPanel;

import java.lang.Integer;

/**
 * TicTacToeApplet creates a TicTacToe board.  With no input, a default board of 3x3 size is produced.
 * Otherwise, a board of nxn size is produced.
 * @author Caitlin Coggins
 **/
public class TicTacToeApplet extends JApplet
{
    /**
     * Constructor, invoked for a new instance
     **/
    public TicTacToeApplet()
    {
        // call super constructor
        super();
        
    }
    
    /**
     * Special method that will be invoked when applet is created
     **/
    public void start()
    {
        String inputFromPage = this.getParameter("size");
        
        // if there is no input, create a default board
        if( inputFromPage == null)
           add( new TicTacToeGame() );
        
        // else, create a board with nxn size
        else
            add( new TicTacToeGame(Integer.parseInt(inputFromPage)));
           
    }
    
}