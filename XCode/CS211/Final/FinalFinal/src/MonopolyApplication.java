// awt
import java.awt.Color;

// swing
import javax.swing.JFrame;

/**
 * MonopolyApplication.java
 * @author Curtain Kaufman and Guideline Coggins
 *
 */
public class MonopolyApplication extends JFrame {

	/**
	 * Start the game!
	 * @param 
	 */
	public static void main( String[] args )
	{
		// Colors
		Color purple = new Color(176, 155, 198);
		
		// create a new JFrame to hold a new controller instance
		JFrame monopolyFrame = new JFrame("Monopoly!");
		
		// set size
		monopolyFrame.setSize( 10000, 10000 );
		
		
		
		// add panel
		monopolyFrame.add(new MonopolyGUIPanel());
		
		
		
		// close the window
		monopolyFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		// show frame
		monopolyFrame.setVisible( true );
		
		monopolyFrame.setBackground(purple);
	}
}