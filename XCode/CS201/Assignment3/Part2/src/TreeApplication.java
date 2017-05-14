// TreeApplication.java
// Caitlin Coggins

/**
 * Main application to show a TreeFrame
 **/

// swing
import javax.swing.JFrame;

public class TreeApplication
{
    /**
     * main method starts the program
     * @param args, user input, none for this program
     **/
    public static void main( String[] args )
    {
        // create a new JFrame to hold TreePanel
        JFrame treeFrame = new JFrame();

        // set size
        treeFrame.setSize( 600, 400 );

        // create a TreePanel and add it
        treeFrame.add( new TreePanel() );

        // exit normally on closing the window
        treeFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        // show frame
        treeFrame.setVisible( true );
    }

}