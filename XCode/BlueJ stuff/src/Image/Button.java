import objectdraw. *;
import java.awt. *;

/**
 * Constructor for buttons consisting of rectangles and 
 * texts. 
 * 
 * @author Umama
 * @version Version 02/18/16
 */
public class Button {
    //framed rectangle named button
    FramedRect button;
    //Constructor that creates buttons consisting of a rectangle and text
    public Button (double left, double top, String label, DrawingCanvas buttoncanvas){
        // new Text named text
        Text text = new Text (label, 0, 0, buttoncanvas);
        double height = text.getHeight();
        double width = text.getWidth();
        
        //new Framed rectangle named button
        button = new FramedRect (left,top,width+4,height+4, buttoncanvas);
        
        //move text to center of button
        text.moveTo(left+2,top+2);

    }
    
    //boolean to identify if mouse is clicked on any of the hot air balloon components
    public boolean contains (Location point){
        if (button.contains (point)) { 
            return true;
        }
        else {
            return false;
        }
    }
    
    //method to get x coordinate of top right corner of button
    public double getRight(){
        double textRightEdge = button.getX()+button.getWidth();
        return textRightEdge;

    }
}