// IceCreamCone.java

import java.lang.Math.*;

// awt
import java.awt.Color;
import java.awt.Graphics;

//swing
import javax.swing.JComponent;

/**
 * IceCreamCone creates a stack, can add a scoop to the stack, and can remove a scoop from the stack.
 * @author caitlincoggins
 *
 */
public class IceCreamCone extends JComponent
{
	/** array of flavor names **/
    public static final String[] FLAVORS = {"vanilla", "strawberry", "mint", "chocolate"};
    
    /** array of colors of ice cream **/
    public static final Color[] PAINT_COLORS = {Color.WHITE, Color.PINK, Color.GREEN, new Color( 102, 51, 0 ) };
    
    /** holds the stack of scoops **/
    StackLL scoopStack;
    
    /**
     * Constructor.
     * Calls super.
     * Initializes scoopStack.
     */
    public IceCreamCone()
    {
        super();
        
        scoopStack = new StackLL();
        
        repaint();
    }
    
    /**
     * Adds a random scoop to the stack.
     */
    public void addScoop()
    {
        int chosenFlavor = (int) Math.random()*4;
        scoopStack.push(FLAVORS[chosenFlavor]);
    }
    
    /**
     * Adds a specified scoop to the stack.
     * @param scoopType
     */
    public void addScoop(String scoopType)
    {
        scoopStack.push(scoopType);
    }
    
    /**
     * Removes a scoop from the stack.
     */
    public void removeScoop()
    {
        if(! scoopStack.empty())
            scoopStack.pop();
    }
    
    /**
     * Returns the stack to the viewing class.
     * @return dontAlter the stack of scoops to be painted
     */
    public StackLL getStack()
    {
    	StackLL dontAlter = scoopStack;
    	return dontAlter;
    }
}