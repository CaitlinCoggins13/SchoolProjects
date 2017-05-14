// swing
import javax.swing.JFrame;

public class IceCreamApplication
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
        treeFrame.setSize( 500, 700 );

        // create a TreePanel and add it
        treeFrame.add( new IceCreamMaker() );

        // exit normally on closing the window
        treeFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        // show frame
        treeFrame.setVisible( true );
    }

}