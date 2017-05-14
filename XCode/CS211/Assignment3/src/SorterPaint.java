// awt
import java.awt.Graphics;
import java.awt.Color;

// swing
import javax.swing.JComponent;

// lang
import java.lang.Math.*;

/**
 * SorterPaint creates a display that shows the current values in the sorting array represented
 * as bars.
 * @author Caitlin Coggins
 */
public class SorterPaint extends JComponent
{
	/** Holds the values of the bars to be painted. **/
    Integer[] painting;
    
    /**
     * Constructor.
     * @param painting the first array to be painted
     */
    public SorterPaint(Integer[] painting)
    {
        this.painting = painting;
        repaint();
    }
    
    @Override
    /**
     * Overrides paint method.
     * @param g Graphics object
     */
    public void paint(Graphics g)
    {
        drawBars(g);
    }
    
    /**
     * Draws bars representing what is in the sorting array.
     * @param g Graphics object
     */
    public void drawBars(Graphics g)
    {
    	// makes sure the are no NullPointerExceptions
    	if(painting[0] != null)
    	{
    		// calculates the width of the bars
    		int width = getWidth()/painting.length;
        
    		for( int i = 0; i<painting.length; ++i)
    		{
    			// calculates the height of the bars
    			int height = painting[i].intValue();
            
    			g.setColor(Color.GREEN);
    			// draws the bar
    			g.fillRect( width*i, getHeight()-(height*8), width, height*8);
    			
    			g.setColor(Color.BLACK);
    			
    			// draws box around the bar
    			g.drawRect( width*i, getHeight()-(height*8), width, height*8);
    			
    			// writes the number above the bar
    			g.drawString(painting[i].toString(), width*i, getHeight()-height*8);
            
    		}
    	}
        
    }
    
    /**
     * Allows the array painting to be changed after generating a new array or sorting.
     * @param painting new array to be painted
     */
    public void changeArray(Integer[] painting)
    {
    	this.painting = painting;
    }
}