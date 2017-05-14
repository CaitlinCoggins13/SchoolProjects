import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * TetrisGameTextController plays Tetris from the command line,
 * printing the game after each move.
 */
public class TetrisGameTextController
{
    
    /* the game (model) */
    private TetrisGame game;
    
    /* the view */
    private TetrisGameTextView view;
    
    /*
     * Constructor for a new tetris game for the command line.
     */
    public TetrisGameTextController()
    {
        // create a tetris game
        game = new TetrisGame();
        
        // create its view
        view = new TetrisGameTextView( game );
        
        // show the initial game
        view.getView();
        
        // start play
        readInput();
    }
    
    /**
     * Get input from the user, looping until the user types "Quit".
     **/
    private void readInput()
    {
        // wrap input stream read input from user
        // you do not need to understand what is going on here
        // for now, just take it as is
        BufferedReader in =
        new BufferedReader( new InputStreamReader( System.in ) );
        
        // I/O almost always requires a try/catch
        // block as exceptions may be thrown
        try
        {
            String line;
            
            // loop until the user types "Quit"
            do {
                // prompt the user for input
                System.out.println( "Please enter a move (l,r,d,z,x) or type Quit to end." );
                
                // try to read a line
                // this function potentially throws an IOException
                line = in.readLine();
                
                // enter the move
                moveEntered( line );
                
                // refresh the view
                refreshDisplay();
            } while ( (!line.equals( "Quit" ) ) );
        }
        // catch I/O exception
        catch ( IOException ioe )
        {
            // tell exception to print its error log
            ioe.printStackTrace();
        }
    }
    
    /**
     *  Print text view of the game.
     */
    private void refreshDisplay()
    {
        view = new TetrisGameTextView( game );
        view.getView();
    }
    
    /**
     * r: right
     * l: left
     * d: down
     * z: cw
     * x: ccw
     * @param move
     */
    private void moveEntered( String move )
    {
        if(move.equals ("l"))
            game.attemptMove(0);
        else if(move.equals ("r"))
            game.attemptMove(1);
        else if(move.equals ("d"))
            game.attemptMove(2);
        else if(move.equals ("z"))
            game.attemptMove(3);
        else if(move.equals ("x"))
            game.attemptMove(4);
    }
    
    /**
     * Start the game!
     * @param args
     */
    public static void main( String[] args )
    {
        // make a new controller instance
        new TetrisGameTextController();
    }
    
}
