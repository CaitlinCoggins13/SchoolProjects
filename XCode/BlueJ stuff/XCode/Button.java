import objectdraw.*; import java.awt.*;
/**
 * Write a description of class Button here.
 * 
 * @author Nicole Gomez 
 * @version February 18, 2016
 */
public class Button extends FrameWindowController
{   
    private FramedRect button;
    private Text gray;
    private double right;
   /**
    * Creates a button
    * left id the left of the button
    * top is the top of the button
    * DrawingCanvas canvas is where to draw the button
    */
    public Button (double left, double top, String label, DrawingCanvas canvas){
       /* Create the text.*/
       gray = new Text ("Gray", 200, 20, canvas);
       /* Move the text to the center.*/
       gray.moveTo (left + 3, top + 2);
       /* Create the button.*/
       button = new FramedRect (left, top, gray.getWidth() + 5, gray.getHeight() + 5, canvas);
   }   
   }