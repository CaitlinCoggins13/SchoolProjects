import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class IceCreamConeView extends JComponent
{
	/** Instance of IceCreamCone **/
	private IceCreamCone cone;
	
	/** Used to paint the elements of the original array **/
	StackLL tempStack;
	
	/** height of ice cream cone and diameter of scoop **/
	private int paintHeight = 60;
	
	/** array of ice cream names **/
	public static final String[] FLAVORS = {"vanilla", "strawberry", "mint", "chocolate"};
	
	/** array of ice cream colors **/
    public static final Color[] PAINT_COLORS = {Color.WHITE, Color.PINK, Color.GREEN, new Color( 102, 51, 0 ) };
    
    /** width of cone **/
    public static final int CONE_WIDTH = 40;
    
    /** overlap of scoop and cone **/
    public static final int SCOOP_OVERLAP = 10;
	
    /**
     * Constructor.
     * @param cone the current instance of IceCreamCone
     */
	public IceCreamConeView(IceCreamCone cone)
	{
		super();
		
		this.cone = cone;
	}
	
	@Override
	/**
	 * Overrides the paint method to paint the cone and scoops
	 */
	public void paint( Graphics g )
    {
    	this.tempStack = cone.getStack();
    	
    	boolean empty = tempStack.empty();
        
    	// draw the cone
    	paintCone( g );

    	if(empty == false)
    	{
    		// draw the scoops
    		paintScoops( g );
    	}
    }
    
	/**
	 * Paints the cone.
	 * @param g Graphics object
	 */
    public void paintCone( Graphics g )
    {
        int[] xPoints = new int[3];
        int[] yPoints = new int[3];
        
        // center bottom point
        xPoints[0] = getWidth() / 2;
        yPoints[0] = getHeight();
        
        // upper left point
        xPoints[1] = xPoints[0] - (CONE_WIDTH/2);
        yPoints[1] = yPoints[0] - paintHeight;
        
        // upper right point
        xPoints[2] = xPoints[0] + (CONE_WIDTH/2);
        yPoints[2] = yPoints[0] - paintHeight;
        
        // set the paint color
        g.setColor( Color.YELLOW );
        
        // draw triangle
        g.fillPolygon( xPoints, yPoints, 3 );
    }
    
    /**
     * Paints each scoop by popping them off the stack, then adds them back on.
     * @param g Graphics object
     */
    public void paintScoops( Graphics g )
    {
        boolean empty = tempStack.empty();
        
        // put popped off elements back on
        StackLL<String> putBack = new StackLL<String>();
        // reverse the order for painting
        StackLL<String> reverse = new StackLL<String>();
        
        // helps paint scoops
        int count = 0;
        
        // empty tempStack into putBack and reverse
        while(empty == false)
        {
            String nextFlavor = (String) tempStack.peek();
            putBack.push(nextFlavor);
            reverse.push(nextFlavor);
            
            tempStack.pop();
            
            empty = tempStack.empty();
        }
          
        // paint the reverse of the original stack, empties reverse
        while(reverse.empty() == false )
        {
        	String nextFlavor = (String) reverse.peek();
            int flavorIndex = findFlavor(nextFlavor);
            // set the paint color based on the flavor
            g.setColor( PAINT_COLORS[ flavorIndex ] );
            
            // fill oval (upper left x, upper left y, width, height)
            g.fillOval(
                       // upper left x is center minus half diameter
                       getWidth()/2 - paintHeight/2,
                       // upper left y accounts for cone height and a bit of overlap
                       getHeight() - paintHeight*2 + SCOOP_OVERLAP -count*paintHeight,
                       paintHeight, paintHeight );
            ++count;
            
            reverse.pop();
            
        }

        // empties reverse into original stack in original order
        while(putBack.empty() == false)
        {
        	tempStack.push(putBack.peek());
        	putBack.pop();
        } 
    }
    
    /**
     * Finds the color name in the FLAVOR array.
     * @param flavorName the name of the flavor
     * @return
     */
    public int findFlavor(String flavorName)
    {
        for( int i = 0; i< FLAVORS.length; ++i)
        {
            if( FLAVORS[i].equals(flavorName))
            {
                return i;
            }
        }
        
        return -1;
    }
    
}