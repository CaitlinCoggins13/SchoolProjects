import javax.swing.JFrame;

/**
 * This is the application for the Roster program.  It creates a JFrame to display 
 * the GUI and starts the program by creating a new RosterDisplay.
 * 
 * @author caitlincoggins
 */
public class RosterApplication
{
    /**
     * Starts the program.
     * @param args
     */
    public static void main( String[] args )
    {
        
        // create a new JFrame to hold a new controller instance
        JFrame questionsFrame = new JFrame("Class Roster");
        
        // set size
        questionsFrame.setSize( 550, 300 );
        
        // make a new controller instance and add it
        questionsFrame.add( new RosterDisplay( ) );
        
        // exit normally on closing the window
        questionsFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        
        // show frame
        questionsFrame.setVisible( true );		
    }
}