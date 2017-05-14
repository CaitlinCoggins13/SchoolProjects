import objectdraw.*;
import java.awt. *;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * Creates text objects of text that is put in by the user wherever the user clicks
 * The slider allows user to change text size, the drop down menu allows user to 
 * change fonts. A button also allows the user to remove the last text object created. 
 * 
 * @author Umama 
 * @version Version 04/06/16
 */

public class TextPlay extends FrameWindowController implements ActionListener , ChangeListener 
{
    //four JPanels on the south, north, west and east of the window respectively
    private JPanel southPanel;
    private JPanel northPanel;
    private JPanel westPanel;
    private JPanel eastPanel;

    //JTextField named southTextField
    private JTextField southTextField;

    //text object named text
    private Text text;

    // JButton named button
    private JButton button;

    //JSlider named slider
    private JSlider slider;

    //JComboBox named fontBox
    private JComboBox fontBox;

    //fonts
    private String Courier;
    private String Sand;
    private String Times;
    private String Zapfino;

    //store fontchoice in an instance variable 
    private String fontChoice = "Courier";

    //store font size in an instance variable to be used throughout the class
    private int size = 12;

    /**
     * Creates display of all the panels, buttons, textfields 
     * */
    public void begin(){        
        //resize the canvas to the given dimensions
        resize (500,420);

        //create new jpanel and add it to the south of the window
        southPanel = new JPanel();
        add(southPanel, BorderLayout.SOUTH);
        //new textfield which is added to the south panel
        southTextField = new JTextField(40);
        southPanel.add(southTextField, BorderLayout.SOUTH);

        //create new jpanel for the north of the window
        northPanel = new JPanel ();
        //create new jbutton 
        button = new JButton ( "Remove Last Text");
        northPanel.add(button);
        /* add actionlistener to the button so the WindowController extension
         * responds when it is pressed */
        button.addActionListener(this);
        //add the button to the north panel 
        add(northPanel, BorderLayout.NORTH);

        //create new jpanel
        eastPanel = new JPanel ();
        //add panel to the east of the window
        add(eastPanel, BorderLayout.EAST);
        /*create new vertical slider with maximum and minimum 
        value of 48 and 10 respectively*/
        slider = new JSlider (JSlider.VERTICAL, 10, 48, 29);
        //add slider to east panel
        eastPanel.add(slider);
        /*add ChangeListener to the slider so the WindowController knows 
        when the user interacts with the JSlider */
        slider.addChangeListener(this);

        //new JComboBox named fontBox
        fontBox = new JComboBox ();
        //add font types to the combo box
        fontBox.addItem("Courier");
        fontBox.addItem("Sand");
        fontBox.addItem("Times");
        fontBox.addItem("Zapfino");

        //new JPanel named westPanel 
        westPanel = new JPanel ();
        //add the panel to the west of the window
        add(westPanel, BorderLayout.WEST);
        //add combo box to westPanel
        westPanel.add(fontBox);
        //add actionlistener to the fontbox
        fontBox.addActionListener(this);

    }

    /*creates Text object of the text from the textField
     *every new Text object is set to have the size and font 
     *put in by the user
     */
    public void onMouseClick(Location point){

        text = new Text (southTextField.getText(),point, canvas);
        //set font type to whichever font is selected at a particular time
        text.setFont(fontChoice);
        //set font size to whichever size is selected at a particular time
        text.setFontSize(size);

    }

    /* Method carries out specific actions in response to 
     * user interaction with the button and fontbox
     * The last text object is removed when the button is pressed, 
     * and specific font is set to text object when font is chose from the font box
     */
    public void actionPerformed (ActionEvent evt){
        //gets the string of the font selected from the fontbox
        fontChoice = fontBox.getSelectedItem().toString();

        /*If the event source is the button and text object is not null,
        then remove it from the canvas and set text object value to null */         
        if (evt.getSource()==button && text!=null){
            text.removeFromCanvas();
            text = null;
        }

        /* checks if fontbox was pressed and that text object is not null and carries 
        out appropriate action */
        if(evt.getSource()== fontBox && text!=null){
            //checks string value of selected font and sets appropriate font to the text object
            if(fontChoice.equals("Courier")){
                text.setFont("Courier");
            }

            else if (fontChoice.equals("Zapfino")){
                text.setFont("Zapfino");
            }

            else if (fontChoice.equals("Sand")){
                text.setFont("Sand");
            }

            else if (fontChoice.equals("Times")){
                text.setFont("Times");
            }

        }
    }

    /* Method changes font size in response to the change listener
     * added to the JSlider
     */
    public void stateChanged (ChangeEvent evt){
        //value from the slider
        size = slider.getValue();
        //set font size to appropriate size
        text.setFontSize(size);
    }
}