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
        JFrame iceCreamFrame = new JFrame();

        // set size
        iceCreamFrame.setSize( 500, 700 );

        // create an IceCreamShop and add it
        iceCreamFrame.add( new IceCreamMaker() );

        // exit normally on closing the window
        iceCreamFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        // show frame
        iceCreamFrame.setVisible( true );
    }

}