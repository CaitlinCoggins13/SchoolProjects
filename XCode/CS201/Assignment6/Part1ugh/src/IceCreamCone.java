// IceCreamCone.java

import java.lang.Math.*;

// awt
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class IceCreamCone extends JComponent
{
    public static final String[] FLAVORS = {"vanilla", "strawberry", "mint", "chocolate"};
    public static final Color[] PAINT_COLORS = {Color.WHITE, Color.PINK, Color.GREEN, new Color( 102, 51, 0 ) };
    public static final int CONE_WIDTH = 40;
    public static final int SCOOP_OVERLAP = 10;
    
    StackLL<T> scoopStack;
    
    int paintHeight = 60;
    
    public IceCreamCone()
    {
        super();
        
        scoopStack = new StackLL<T>();
        
        repaint();
    }
    
    public void addScoop()
    {
        int chosenFlavor = (int) Math.random()*4;
        scoopStack.push(FLAVORS[chosenFlavor]);
    }
    
    public void addScoop(String scoopType)
    {
        scoopStack.push(scoopType);
    }
    
    public void removeScoop()
    {
        if(! scoopStack.empty())
            scoopStack.pop();
    }
    
    /**
     * Override the paint method to draw an ice cream cone.
     **/
    public void paint( Graphics g )
    {
        StackLL<T> tempStack = scoopStack;
        
        if(!tempStack.empty())
        {
            calculateSize(tempStack);
        }
        
        // draw the cone
        paintCone( g );
        
        if(!tempStack.empty())
        {
            // draw the scoops
            paintScoops( g, tempStack );
        }
    }
    
    public void calculateSize(StackLL<T> countStack)
    {
        int resize = getHeight()/countElements(countStack)+1;
        
        if(resize < 60 )
        {
            paintHeight = resize;
        }
    }
    
    public int countElements(StackLL<T> countStack)
    {
        int count = 0;
        
        while(!countStack.empty())
        {
            ++ count;
            
            countStack.pop();
        }
        
        return count;
    }
    
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
    
    public void paintScoops( Graphics g, StackLL<T> paintStack )
    {
        
        while(!paintStack.isEmpty())
        {
            
            String nextFlavor = (String) paintStack.peek();
            
            int flavorIndex = findColor(nextFlavor);
            // set the paint color based on the flavor
            g.setColor( PAINT_COLORS[ flavorIndex ] );
            
            // fill oval (upper left x, upper left y, width, height)
            g.fillOval(
                       // upper left x is center minus half diameter
                       getWidth()/2 - paintHeight/2,
                       // upper left y accounts for cone height and a bit of overlap
                       getHeight() - paintHeight*2 + SCOOP_OVERLAP,
                       paintHeight, paintHeight );
        }
    }
    
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