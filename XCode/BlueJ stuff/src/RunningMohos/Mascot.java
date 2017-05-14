import objectdraw.*;
import java.awt.*;

/**
 * Creates images of the mascots and makes them all move horizontally along the lanes with different random
   speeds until they cross the finishing line.
 *
 * @author Anh Chau Pham
 * @version March 30th, 2016
 */
public class Mascot extends  ActiveObject 
{
   //the delay between the mascot motions
   private static final int DELAY_TIME = 30;
   
   //The image of the mascot
   private VisibleImage mascotGraphic;
   
   //The canvas
   private DrawingCanvas canvas; 
   
   //The finishing line
   private Location finishline; 
   
   /**
    * Initialize the instance variables and start the active object
    */
   public Mascot (Image mascotPic, Location firstlocation, Location afinishline, DrawingCanvas aCanvas)
      {
       //Remember the canvas
       canvas = aCanvas;
       
       //Remember the finishing line
       finishline = afinishline;
       
       //Initial placement of the graphical object
       mascotGraphic = new VisibleImage (mascotPic, firstlocation, canvas);
   }
   
   /**
    * Defines how the animation progresses 
    */
   public void run() 
   {
       //Create a random number generator for the speed of the mascot
       RandomIntGenerator speed = new RandomIntGenerator(1,7);
       
       //While the x coordinate of the top left of the mascot's image is larger than the x coordinate of
       //the finishing line. In other words, while the mascot hasn't crossed the finishing line
       while(mascotGraphic.getX()+mascotGraphic.getWidth() > finishline.getX()) 
       {
           //Move the mascot a random amount
           mascotGraphic.move (-speed.nextValue(), 0);
           
           //Pause to give time for the user to see the mascot in its new position
           pause (DELAY_TIME);
       }
   }
}
    
    
    
    