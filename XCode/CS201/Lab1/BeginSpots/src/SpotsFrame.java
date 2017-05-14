// SpotsFrame.java
// Audrey St. John

// awt
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// swing 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/** 
 * SpotsFrame takes a name as input, then uses it to draw random spots.
 * @author Audrey St. John
 **/
public class SpotsFrame extends JFrame implements ActionListener
{
	
	// instance variables
	private JTextField nameInputField;
	private SpotsDisplay spotsDisplay;
	
	/**
	 * Constructor, invoked for a new instance
	 **/
	public SpotsFrame()
	{
		// call super constructor, passing title of frame
		super( "Seeing spots" );
		
		// set size
		setSize( 600, 400 );
		
		// exit normally on closing the window
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		// call instance method to initialize the graphics
		// method returns the main panel
		JPanel mainPanel = createMainPanel();

		// add it 
		add( mainPanel );
		
		// show frame
		setVisible( true );
	}

	/** 
	 * Create GUI components.
	 * returns the created main panel
	 **/
	public JPanel createMainPanel()
	{
		// create panel to hold everything, using a border layout
		JPanel mainPanel = new JPanel( new BorderLayout() );
		
		// first, create panel to hold input 
		// and add to north
		mainPanel.add( createInputPanel(), BorderLayout.NORTH );
		
		// then, create panel for drawing the ice cream cone
		// and add to center
		mainPanel.add(  createSpotsDisplay(), BorderLayout.CENTER );
		
		// finally, create button for prompting spots to display
		// and add to south
		mainPanel.add( createSpotsButton(), BorderLayout.SOUTH );
		
		// return created panel
		return mainPanel;
	}
	
 	/** 
     * Create and return input panel.
	 **/
	public JPanel createInputPanel()
	{
		// create panel to hold input GUI elements, using default FlowLayout
		JPanel inputPanel = new JPanel();
		
		// create and add label
		inputPanel.add( new JLabel( "Your name" ) );
		
		// create input textfield
		nameInputField = new JTextField( 10 );
		
		// add it
		inputPanel.add( nameInputField );
		
		// return created panel
		return inputPanel;
	}
	
	/**
	 * Create and return spots display.
	 **/
	public SpotsDisplay createSpotsDisplay()
	{	
		spotsDisplay = new SpotsDisplay();
		return spotsDisplay;
	}
	
	/**
	 * Create and return spots button.
	 **/
	public JButton createSpotsButton()
	{
		// create a button
		JButton spotsButton = new JButton( "Time to see some spots!" );
		
		// add this as the action listener for button's action (click)
	    spotsButton.addActionListener( this );
		
		// return the button
		return spotsButton;
	}
	
	/**
	 * Display spots.
	 **/
	public void seeSpots()
	{
		// get the person's name 
		String name = nameInputField.getText();
		
		// set the number of spots to see
		spotsDisplay.setNumberOfSpots( name.length() );
		
		// tell graphics to update
		spotsDisplay.repaint();
	}
	
	/**
	 * Special method required by implementing ActionListener 
	 * (function signature cannot be changed)
	 * Invoked when an action is performed on the spotsButton, since this
	 * was added as an ActionListener.
	 **/
	public void actionPerformed( ActionEvent e )
	{
		// this is where you put the code you want
		// executed when the button is pressed
		// here, we call a method to update the display     
		seeSpots();
	}
	
}