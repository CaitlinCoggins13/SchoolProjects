// TreePainter.java
// Caitlin Coggins

// awt
import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// swing
import javax.swing.JComponent;

// lang
import java.lang.Math.*;

/**
 * TreePainter recursively draws a tree from a user's click and drag in the window.
 **/

// Professor Pon-Barry suggested I do all of my recursion from within the paint method.

public class TreePainter extends JComponent implements MouseListener
{
    /** Number of generations to create branches. Play with this for coarser/finer detail. **/
    public static final int NUM_GENERATIONS = 8;

    /** Number of children for each branch. Play with this for sparser/fluffier trees. **/
    public static final int NUM_CHILDREN = 3;

    /** Golden ratio makes the child branches aesthetically appealing **/
    public static final double GOLDEN_RATIO = 1.618;

    /** Maximum branching angle of children from a parent stick **/
    public static final double MAX_BRANCHING_ANGLE = .5*Math.PI;

    /** Diameter of the blossoms. **/
    public static final int BLOSSOM_DIAM = 4;
    
    /** Holds initial start point. **/
    private Point2D startPoint = new Point2D.Double();
    
    /** Holds initial end point. **/
    private Point2D endPoint = new Point2D.Double();

    /**
     * Constructor.
     **/
    public TreePainter()
    {
        // call super
        super();
        
        // wait for click and drag to start drawing tree
        addMouseListener(this);
    }
    
    /**
     * Get the length and angle of the user's line.  Draw the trunk of the tree.  Begin recursion.
     * @param g, Graphics object
     **/
    public void beginRecursion( Graphics g )
    {
        // get length of user's line
        double length = Math.sqrt( Math.pow( endPoint.getX()-startPoint.getX(), 2 ) + Math.pow( endPoint.getY()-startPoint.getY(), 2));
    
        // get angle of user's line
        double angle = Math.atan2( (endPoint.getY()-startPoint.getY()), (endPoint.getX()-startPoint.getX() ));
        
        // draw trunk
        drawLimb( g, NUM_GENERATIONS, startPoint, endPoint );
        
        // begin recursion
        continueRecursion( NUM_GENERATIONS, endPoint, length, angle, g );
    }
    
    /**
     * Get the length and angle of the user's line.  Draw the trunk of the tree.  Begin recursion.
     * @param generation, the number of generations into the recursion
     * @param startDraw, the starting point for the new branch
     * @param length, the length of the new branch
     * @param angle, the angle of the new branch
     * @param g, Graphics object
     **/
    public void continueRecursion( int generation, Point2D startDraw, double length, double angle, Graphics g )
    {
        // Paints a leaf at the end of a branch
        if ( generation == 0)
        {
            drawBlossom( g, startDraw );
        }
        
        // Creates new branches and paints them.
        else
        {
            // creates new child branches
            for(int i=0; i<NUM_CHILDREN; ++i)
            {
                // gets length of new branches
                double newLength = computeLength( length );
            
                // gets angle of new branches
                double newAngle = computeAngle( angle );
            
                // endpoint of the new branch is computed
                Point2D newEndPoint = computeEndpoint( startDraw, newLength, newAngle);
            
                // new branch is drawn
                drawLimb( g, generation, startDraw, newEndPoint );
           
                // more child branches are created
                continueRecursion( generation-1, newEndPoint, newLength, newAngle, g );
            }
        }
    }
    
    /**
     * Computes the length of the next branch.
     * @param length, the length of the last branch
     * @return newLength, the length of the next branch
     **/
    public double computeLength( double length )
    {
        double newLength = length * (1/GOLDEN_RATIO);
        
        return newLength;
    }
    
    /**
     * Picks the angle of the next branch.
     * @param angle, the angle of the last branch
     * @return newAngle, the angle of the next branch
     **/
    public double computeAngle( double angle )
    {
        double newAngle = (double) (Math.random()*((angle+MAX_BRANCHING_ANGLE)-(angle-MAX_BRANCHING_ANGLE))+angle-MAX_BRANCHING_ANGLE);
        
        return newAngle;
    }
    
    /**
     * Overrides paint method.
     * @param g, Graphics object
     **/
    public void paint ( Graphics g )
    {
        beginRecursion( g );
    }
    
    /**
     * Draws a branch of the tree.
     * @param g, Graphics object
     * @param generation, sets color of the branch
     * @param p, starting point of the branch
     * @param p2, ending point of the branch
     **/
    public void drawLimb( Graphics g, int generation, Point2D p, Point2D p2 )
    {
        // sets color of the branch
        g.setColor(new Color(0f, .25f*generation/NUM_GENERATIONS + .25f, 0f));
        
        // draws branch
        g.drawLine( (int)(p.getX()), (int)(p.getY()), (int)(p2.getX()), (int)(p2.getY()));
    }
    
    /**
     * Draws a blossom at the end of a branch.
     * @param g, Graphics object
     * @param p, end point of branch where blossom will be drawn
     **/
    public void drawBlossom( Graphics g, Point2D p )
    {
        // randomly set color from greenish to orangeish reddish
        g.setColor(new Color((float) (Math.random()*.6f + .3f), // more red
                                 (float)(.1f+.5f*Math.random()), // some green
                                 (float)(.1f+.1f*Math.random()))); // low blue
        
        // draws blossom
        g.fillOval( (int)p.getX(), (int)p.getY(), 5, 5);
    }
    
    /**
     * Compute the point that is length away from p at the angle.
     * Uses cosine to get the new x coordinate, sine to get the new y coordinate.
     **/
    public Point2D computeEndpoint( Point2D p, double length, double angle )
    {
        return new Point2D.Double( 	p.getX() + length*Math.cos(angle), // x is cos
                                  p.getY() + length*Math.sin(angle));	// y is sin
    }
    
    /**
     * Gets point where user clicked.
     * @param e, MouseEvent object
     **/
    public void mousePressed( MouseEvent e )
    {
        startPoint = e.getPoint();
    }
    
    /**
     * Gets point where user released the mouse, then starts the creation of the tree.
     * @param e, MouseEvent object
     **/
    public void mouseReleased( MouseEvent e)
    {
        endPoint = e.getPoint();
        
        // calls paint method
        repaint();
    }
    
    public void mouseEntered( MouseEvent e)
    {
        
    }
    
    public void mouseExited( MouseEvent e)
    {
        
    }
    
    public void mouseClicked( MouseEvent e)
    {
        
    }
    
}