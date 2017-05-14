import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * This class creates the GUI components for the display.  There are buttons, labels,
 * and a text field created in one panel, and two text areas created in another.  Both
 * panels are added to a larger panel.  There are also different actions for each
 * button when it is clicked. One button removes a student from the roster or waitlist
 * by calling removeStudent in the class Roster, and the other adds a student by 
 * calling addStudent in Roster.  The text displayed to the user is then updated.
 * 
 * @author caitlincoggins
 *
 */
public class RosterDisplay extends JPanel implements ActionListener
{
	/** Button to remove a student whose name was entered in the text field. **/
	JButton removeStudent;
	
	/** Button to add a student whose name was entered in the text field. **/
	JButton addStudent;
	
	/** Text area for displaying the class roster. **/
	JTextArea rosterArea;
	
	/** Text area for displaying the waitlist. **/
	JTextArea waitlistArea;
	
	/** Fied where student names are entered. **/
	JTextField studentInputField;
	
	/** Instance of Roster, used to access lists **/
	Roster studentRoster;
	
	/**
	 * Constructor.
	 */
	public RosterDisplay()
	{
		super(new BorderLayout());
		
		//initialize instance of Roster
		studentRoster = new Roster();
		
		// add panels to the main panel
		add(addAndRemoveStudentsButtons(), BorderLayout.NORTH);
        add(textSpace(), BorderLayout.CENTER);
	}

	/**
     * Created the area for users to enter a name and buttons for adding and removing students
     * @return bottomDisplay the part of the display that appears at the bottom of the GUI
     * @post a panel with a text field and label, two buttons, and two labels for text areas
     **/
    public JPanel addAndRemoveStudentsButtons()
    {
        JPanel topDisplay = new JPanel(new BorderLayout());
        
        // create panel to hold the text fiels and label
        JPanel inputPanel = new JPanel();
            
        // create and add label
        inputPanel.add( new JLabel( "Type name (Lastname, Firstname): " ) );
            
        // create input textfield
        studentInputField = new JTextField( 20 );
            
        inputPanel.add( studentInputField );

        topDisplay.add(inputPanel, BorderLayout.NORTH);
        
        JPanel buttonsPanel = new JPanel(new GridLayout(1, 2));
        
        // create addStudent button and add ActionListener
        addStudent = new JButton( "Add Student");
        addStudent.addActionListener(this);
        buttonsPanel.add(addStudent);
        
        // create removeStudent button and add ActionListener
        removeStudent = new JButton( "Remove Student");
        removeStudent.addActionListener(this);
        buttonsPanel.add(removeStudent);
        
        // add the buttons to the display
        topDisplay.add(buttonsPanel, BorderLayout.CENTER);
        
        // holds the labels
        JPanel areaLabels = new JPanel(new GridLayout(1, 2));
        
        // create input label
        JLabel classRoster = new JLabel("Class Roster");
        areaLabels.add(classRoster);
        
        // create output label
        JLabel waitlist = new JLabel("Waitlist");
        areaLabels.add(waitlist);
        
        topDisplay.add(areaLabels, BorderLayout.SOUTH);
        
        return(topDisplay);
    }
    
	/**
     * Creates the text areas to display the roster and waitlist.
     * @return testAreas the text areas for the display
     * @post a panel with two text areas of different colors
     **/
    public JPanel textSpace()
    {
        JPanel displayText = new JPanel(new GridLayout(1, 2));
        
        // create input text area
        rosterArea = new JTextArea( "" );
        // adds line wrapping
        rosterArea.setLineWrap(true);
        // adds word wrapping
        rosterArea.setWrapStyleWord(true);
        // user isn't allowed to edit the text displayed
        rosterArea.setEditable(false);
        displayText.add( rosterArea );
        
        // create and add output text area
        waitlistArea = new JTextArea( "" );
        // change background color to make it easier to tell where one list ends and the other begins
        waitlistArea.setBackground(Color.LIGHT_GRAY);
        // adds line wrapping
        waitlistArea.setLineWrap(true);
        // adds word wrapping
        waitlistArea.setWrapStyleWord(true);
        // user isn't allowed to edit the text displayed
        waitlistArea.setEditable(false);
        displayText.add( waitlistArea );
        
        return(displayText);
    }
    


	@Override
	/**
	 * Gets the source of the button click and the name typed, then either removes
	 * or adds the student based on which button was clicked.
	 * @param e ActionEvent variable
	 * @post a student is removed or added and the text in the text areas is refreshed
	 */
	public void actionPerformed(ActionEvent e) 
	{
		// gets the button that was clicked
        JButton buttonPressed = (JButton)e.getSource();
        
        // get the person's name
     	String name = studentInputField.getText();
        
     	// removes student and updates text displayed
		if(buttonPressed == removeStudent)
		{
			studentRoster.removeStudent(name);
			rosterArea.setText(studentRoster.getRosterNames());
			waitlistArea.setText(studentRoster.getWaitlistNames());
		}
		
		// adds student and updates text displayed
		else if(buttonPressed == addStudent)
		{
			studentRoster.addStudent(name);
			rosterArea.setText(studentRoster.getRosterNames());
			waitlistArea.setText(studentRoster.getWaitlistNames());
		}
	}
}
