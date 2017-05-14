//TreePainter.java
//Katie Ho

//swing
import javax.swing.JComponent;

import java.util.Random;


//awt
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Color;


public class TreePainter extends JComponent implements MouseListener
{
  /**instance variables for the top and bottom of the trunk
  a is the x coordinate for bottom, b is the y; c is the x coordinate for the top, d is the y**/
  private int a;
  private int b;
  private int c;
  private int d;
  
  /**the x,y coordinates in one Point2D type point as the trunkTop**/
  Point2D trunkTop;
  
	public static final int NUM_GENERATIONS = 5;
 
	public static final int NUM_CHILDREN = 5; 
 
	public static final double GOLDEN_RATIO = 1.618;
 
	public static final double MAX_BRANCHING_ANGLE = .5*Math.PI;
 
	public static final int BLOSSOM_DIAM = 4;
  

  public TreePainter()
  {
    //inherit methods from super constructor JComponent
    super();
    
    //add mouselistener to the TreePainter
    addMouseListener(this);    
  }
  

  /**
  * Invoked when a mouse button has been pressed on a component. 
  **/
 public void mousePressed( MouseEvent e ) 
 {
   //save the x & y coordinates of the point on the canvas where mouse clicked in a & b
   a = e.getX();
   b = e.getY();
   //put them together in a new point, type Point2D
   Point2D trunkBottom = new Point2D.Double(a,b);
 } 

 /**
  * Invoked when a mouse button has been released on a component. 
  **/
 public void mouseReleased( MouseEvent e ) 
 {
   //save the x & y coordinates of the point on the canvas where mouse was released in c & d
   c = e.getX();
   d = e.getY();
   //put them together in a new point (already declared above), assign the coordinates to this point
   trunkTop = new Point2D.Double(c,d);
   //use repaint method to call paint so that sproutBranch (recursive method to draw the rest of the tree) is called
   repaint();
 }  
  
 /**
 * Calculate the arctan between 2 points.
 **/
 public double findArcTan()
 {
   //declare the trunkAngle as a double
   double trunkAngle; 
   
   //if line is flat horizontally, no value between d and b both on the y axis
   if((d-b)==0)
   {
     //check if the line was drawn from right to left, the angle is 0
     if(c>a)
       trunkAngle = 0;
     //otherwise, the line was drawn from left to right, the angle is PI
     else //a>c
       trunkAngle = Math.PI;
   }
 
   return trunkAngle;
   
 }
 
 /**
 *Calculate the length between two points.
 **/
 public double findTrunkLength()
 {
   //use Pythagorean theorem logic a2+b2=c2
   //double length = Math.sqrt(((c-a)*(a-c))+((d-b)*(b-d)));
	 double length = Math.sqrt( Math.pow( c-a, 2 ) + Math.pow( d-b, 2));
   System.out.println(length);
   return length;
 }
 
 
 /** 
	 * Compute the point that is length away from p at the angle.
	 * Uses cosine to get the new x coordinate, sine to get the new y coordinate.
	 **/
	public Point2D computeEndpoint( Point2D p, double length, double angle )
	{
		
		 Point2D endpoint = new Point2D.Double( 	p.getX() + length*Math.sin(angle),
                				p.getY() + length*Math.cos(angle));	
		 System.out.println("length " +length);
		 System.out.println("angle" +angle);
		 //System.out.println(p.getY());

     return endpoint;
	}
 
 /**
 * Calculate a new angle for the next branch.
 **/
 public double findNewAngle()
 {
    //randomize angle in range 0-180 (PI) and subtract 90 (half PI) 

   double start = 0;
   double end = Math.PI;
   double random = new Random().nextDouble();
   double randomInRange = random*Math.PI;
   double result = randomInRange-(0.5*Math.PI);
   return result;
 }
 
 /**
 * Paint the trunk and call the recursive method to paint all other branches and blossoms.
 **/
 public void paint (Graphics branch)
 {
   //account for null point exception
   if(trunkTop != null)
   {
   //set the color of the branch randomly
   branch.setColor(randomColor());
   //draw the trunk with the 4 instance variables a,b,c,d
   branch.drawLine(a,b,c,d);
   //call sproutBranch so that after the user draws the trunk, the rest of the branches and blossoms get painted!
   System.out.println(trunkTop.getX());
   System.out.println(trunkTop.getY());
   sproutBranch(branch,1,trunkTop,findTrunkLength(),findArcTan());
   }
 }
 
 /**
 *Return a new randomized color each time.
 **/
 public Color randomColor()
 {
   //http://stackoverflow.com/questions/4246351/creating-random-colour-in-java
   
   Random z = new Random();
   //r = red
   float r = z.nextFloat();
   //g = green
   float g = z.nextFloat();
   //b = blue
   float b = z.nextFloat();
   //create a new random color with variations of red, green and blue
   Color rColor = new Color(r,g,b);
   
   return rColor;
 }
   
 /**
 *Draw more branches, unless it's the last branch, draw blossom (base case). 
 **/
 public void sproutBranch (Graphics branch, int currentGen, Point2D oldPoint, double oldLength, double oldAngle)
 { 
	 
     
     System.out.println("oldlength" + oldLength);
   if (currentGen>NUM_GENERATIONS)
   {     
	   
     //set the blossom drawn to a random color
       branch.setColor(randomColor());
       //use fillOval method to fill it with the color
       branch.fillOval((int)oldPoint.getX(), (int)oldPoint.getY(), BLOSSOM_DIAM, BLOSSOM_DIAM);
   }
   else
   { 
	   
     //since all children at the same generation will be same length, calculate before loop
     double newLength = (oldLength/GOLDEN_RATIO);
     
     for(int i=0; i<NUM_CHILDREN; i++)
     {
           //add new randomized angle to old previous angle
       double newAngle = findNewAngle() + oldAngle;
        //create a new endpoint for the new branch by using computeEndpoint method
       Point2D newPoint = computeEndpoint(oldPoint, newLength, newAngle);
       //System.out.println(newPoint.getX());
     //  System.out.println(newPoint.getY());
       
       //draw the new branch with the previous point and new endpoint found
       branch.drawLine((int)oldPoint.getX(), (int)oldPoint.getY(), (int)newPoint.getX(), (int)newPoint.getY());
       System.out.println("old " + (int)oldPoint.getX() + "old " + (int)oldPoint.getY() + "new"+(int)newPoint.getX() + "new"+(int)newPoint.getY());
       
         //when you call sprout again, currentGen = currentGen+1
       sproutBranch(branch,currentGen+1,newPoint,newLength, newAngle);
     }
     
   }
 }
 
 
 
 /**
  * Invoked when the mouse enters a component. 
  **/
 public void mouseEntered( MouseEvent e ) {}

 /**
  * Invoked when the mouse exits a component. 
  **/
 public void mouseExited( MouseEvent e ) {} 

 /**
 * Invoked when a mouse button has been clicked on a component.
**/
 public void mouseClicked ( MouseEvent e ) {} 


}