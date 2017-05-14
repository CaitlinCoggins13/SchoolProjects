// TreePanel.java
// Caitlin Coggins

/**
 * TreePanel displays instructions and a TreePainer that creates the picture of the tree.
 **/

// awt
import java.awt.BorderLayout;

// swing
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TreePanel extends JPanel
{
    /**
     * Constructor for TreePanel.
     **/
    public TreePanel()
    {
        // call super
        super( new BorderLayout() );
        
        // add instructions
        add( createInstructions(), BorderLayout.NORTH );
        
        // add TreePainter
        add( new TreePainter(), BorderLayout.CENTER );
    }
    
    /**
     * Creates a JTextArea that displays instructions for the user.
     * @return instructions, the JTextArea that shows the instructions for drawing the tree.
     **/
    public JTextArea createInstructions()
    {
        JTextArea instructions = new JTextArea( "Click, drag, and release to paint a tree!");
        
        instructions.setEditable(false);
        
        return instructions;
    }
    

}