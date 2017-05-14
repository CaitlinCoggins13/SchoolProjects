import objectdraw.*; import java.awt.*; 
/**
 * Write a description of class ImageManipulator here.
 * 
 * @author Nicole Gomez 
 * @version February 18, 2016
 */
public class ImageManipulator extends FrameWindowController
{
   private Picture picture; 
   private VisibleImage visibleImage;
   private Color color;
   private boolean buttonClicked;
   private Location lastPoint;
   private static final int PIXEL_LEFT = 0;
   private static final int PIXEL_TOP = 50;
   private static final int BUTTON_LEFT = 200;
   private static final int BUTTON_TOP = 20;
   private Button button;
   public void begin (){
       picture = new Picture ("SnickersInSnow2.jpg");
       button = new Button (BUTTON_LEFT, BUTTON_TOP, "Gray", canvas);
       /*button2 = new Button (BUTTON_LEFT + 10, BUTTON_TOP, "Mirror", canvas);.*/
       resize (1285, 925);
       visibleImage = picture.createVisibleImage (0, 50, canvas); 
    }
   private void grayScale (){
       int gray = ((color.getRed() + color.getGreen() + color.getBlue())/3); 
       int row = 0;
       while (row < 1285){
           int col = 0;
           while (col < 925){
               color = picture.getPixel (row, col);
               picture.setPixel (row, col, Color.gray);
               visibleImage = picture.createVisibleImage (row, col, canvas);
           
           }
           
       }
   }
   public void onMousePress (Location point){
       if (button.contains (point)) {
           buttonClicked = true;
           lastPoint = point;
      }
   }
   public void onMouseClick (Location point){
       if (buttonClicked){
           grayScale();
           lastPoint = point;
           visibleImage.removeFromCanvas();
        }
   }
}

