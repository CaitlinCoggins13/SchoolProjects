package cs201.coggi22c.unrestguessgme;

import javax.swing.JFrame;

/**
 * Application for the 20 Questions game.
 * @author caitlincoggins
 */
public class QuestionsApplication
{
    
    /**
     * Start the game!
     * @param args
     */
    public static void main( String[] args )
    {
        
        // create a new JFrame to hold a new controller instance
        JFrame questionsFrame = new JFrame("20 Questions");
        
        // set size
        questionsFrame.setSize( 500, 250 );
        
        // make a new controller instance and add it
        questionsFrame.add( new QuestionsPanel( ) );
        
        // exit normally on closing the window
        questionsFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        
        // show frame
        questionsFrame.setVisible( true );		
    }
}