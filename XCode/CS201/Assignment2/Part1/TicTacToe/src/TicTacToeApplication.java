// TicTacToeApplication.java
// Caitlin Coggins

import javax.swing.JFrame;
import java.lang.*;

/**
 * TicTacToeApplication creates a TicTacToeGame.  If no size is specified, a default board of 
 * 3x3 size is created.  Otherwise, a board of n x n size is created, when n is the size specified.
 **/
public class TicTacToeApplication
{

    public static void main(String[] args)
    {
        // create a new JFrame to hold IceCreamPanel
        JFrame tictactoeFrame = new JFrame();

        // set size
        tictactoeFrame.setSize( 600, 600 );

        // no text entered: default to IceCreamPanel
        if(args.length == 0)

            // create an IceCreamPanel and add it
            tictactoeFrame.add( new TicTacToeGame() );

        // else create a game of n x n size
        else
        {
            // creates and adds TicTacToeGame with
            tictactoeFrame.add( new TicTacToeGame( Integer.valueOf(args[0]).intValue()) );
        }

        // exit normally on closing the window
        tictactoeFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        // show frame
        tictactoeFrame.setVisible( true );

    }
}