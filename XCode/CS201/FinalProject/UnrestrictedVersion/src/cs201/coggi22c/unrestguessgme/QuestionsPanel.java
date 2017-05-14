package cs201.coggi22c.unrestguessgme;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import java.awt.Insets;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

// QuestionsPanel.java
// Caitlin Coggins
/**
 * QuestionsPanel sets up all of the GUI components to be displayed.  
 * It performs actions when the user clicks buttons.
 * @author caitlincoggins
 *
 */
public class QuestionsPanel extends JPanel implements ActionListener
{
	/** Instance of the game **/
	QuestionsGame game;
	
	/** Label that displays the question being asked to the user **/
	JLabel question;
	
	/** Text area that displays all the cities that are being considered as the answer **/
	JTextArea choices;
	
	/** Button clicked to answer 'yes' to the question **/
	JButton yesButton;
	
	/** Button clicked to answer 'no' to the question **/
	JButton noButton;
	
	/**
	 * Constructor.
	 * Initializes the instance of game.
	 * Adds all GUI elements.
	 * Begins the music.
	 */
	public QuestionsPanel()
	{
		// call super
		super(new BorderLayout());
		
		//initialize instance
		game = new QuestionsGame();
		
		// add elements
		add(topLabel(), BorderLayout.NORTH);
		add(printChoices(), BorderLayout.CENTER);
		add(buttonPanel(), BorderLayout.SOUTH);
		
		// begin music
		play("Jeopardy.wav");
	}
	
	/**
	 * Creates the area that displays the cities being considered for the user's choice.
	 * @return choices the JTextArea
	 */
	public JTextArea printChoices()
	{
		// gets the list of cities the user could have picked
		String cities = game.getCities();
		
		// creates text area with the list
		choices = new JTextArea(cities);
		
		// can't edit the area
		choices.setEditable(false);
        
		// creates margins
        choices.setMargin( new Insets(40,10,40,10) );
        
        // adds line wrapping
        choices.setLineWrap(true);
        
        // adds word wrapping
        choices.setWrapStyleWord(true);
        
        return choices;
	}
	
	/**
	 * Creates a label that gives instructions for the game.
	 * @return topBoard the JPanel containing the instructions
	 */
	public JPanel topLabel()
	{
		// panel to hold label
		JPanel topBoard = new JPanel(new GridLayout(3, 1));
		
		// add title to label
		JLabel welcome = new JLabel("Welcome to 20 Questions!", SwingConstants.CENTER);
		topBoard.add(welcome);
		
		// what to do now
		JLabel instructions = new JLabel("Pick a city from the list below and answer the questions that appear.", SwingConstants.CENTER);
		topBoard.add(instructions);
		
		// winning criteria
		JLabel winning = new JLabel("If your city is guessed correctly, I win, but if I can't guess it, you win!", SwingConstants.CENTER);
		topBoard.add(winning);
		
		//return
		return topBoard;
	}
	
	/**
	 * Creates a panel with yes and no buttons and a label that displays the current question.
	 * @return allBottom the panel with the buttons and the label.
	 */
	public JPanel buttonPanel()
	{
		JPanel allBottom = new JPanel(new GridLayout(2, 1));
		
		question = new JLabel(game.getQuestion(), SwingConstants.CENTER);

		allBottom.add(question);
		
		JPanel bothButtons = new JPanel(new GridLayout(1, 2));
		
		yesButton = new JButton("Yes!");
		yesButton.addActionListener(this);
		bothButtons.add(yesButton);		
		
		noButton = new JButton("No!");
		noButton.addActionListener(this);
		bothButtons.add(noButton);
		
		allBottom.add(bothButtons);
		
		return allBottom;
	}
	
	/**
	 * Plays a clip of music on loop until the program is closed.
	 * @param filename the name of the WAV file
	 */
	public static void play(String filename)
	{
	    try
	    {
	        Clip clip = AudioSystem.getClip();
	        clip.open(AudioSystem.getAudioInputStream(new File(filename)));
	        clip.loop(Clip.LOOP_CONTINUOUSLY);
	    }
	    catch (Exception exc)
	    {
	        exc.printStackTrace(System.out);
	    }
	}

	/**
	 * Depending on which button was pressed, different strings are sent to the game.  
	 * After game completes its duties, the list of cities and the question are refreshed.
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		JButton clickedButton = (JButton) e.getSource();
		
		// clicked the yes button
		if (clickedButton.equals(yesButton))
		{
			game.chooseBranch("yes");
			
			//refreshes the question and cities
			question.setText( game.getQuestion());
	        choices.setText( game.getCities());	
		}
		
		// clicked the no button
		else if( clickedButton.equals(noButton))
		{
			game.chooseBranch("no");
			
			//refreshes the question and cities
			question.setText( game.getQuestion());
	        choices.setText( game.getCities());	
		}
		
		//shouldn't get here
		else
		{
			System.out.println("Something's up");
		}
		
	}
}