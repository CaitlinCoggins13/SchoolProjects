import objectdraw. *;
import java.awt. *;

/**
 * The program allows users to manipulate displayed image by clicking
 * on different buttons. 
 *
 * @author Umama 
 * @version Version 02/18/16
 */
public class ImageManipulator extends FrameWindowController
{
    //height of the image
    int IMAGE_HEIGHT = 0;
    //width of the image
    int IMAGE_WIDTH = 0;
    private Picture picture; 
    private VisibleImage image;
    private Button Gray;
    private Button Blur;
    private Button Mirror;
    private Button Original;
    private Picture blankPicture;
    private static final int BLUR_WIDTH = 5;
    private static final int BUTTON_SPACING = 10;

    //Displays an image and four buttons when the program starts  
    public void begin () {
        picture = new Picture ("http://www.mtholyoke.edu/~blerner/SnickersInSnow2.jpg");
        image = picture.createVisibleImage ( 0,63, canvas);
        IMAGE_HEIGHT = picture.getHeight();
        IMAGE_WIDTH = picture.getWidth();

        // resizes canvas to fit image and buttons
        resize(IMAGE_WIDTH, IMAGE_HEIGHT+63);

        //creates buttons on top of the image
        Gray = new Button (20,20,"Gray",canvas);
        Blur = new Button (Gray.getRight()+BUTTON_SPACING, 20, "Blur", canvas);
        Mirror = new Button (Blur.getRight()+BUTTON_SPACING, 20, "Mirror", canvas);
        Original = new Button (Mirror.getRight()+BUTTON_SPACING, 20, "Original", canvas);
    }

    //Displays image in gray scale when clicked on the "Gray" button
    public void grayScale () {

        int red = 0;
        int green = 0;
        int blue = 0;
        int average = 0;

        /* While loop to get location and color of every pixel of the
         * image and change pixel color to gray */
        int rowNumber = 0;
        int columnNumber = 0;
        while (rowNumber<IMAGE_HEIGHT){
            while (columnNumber< IMAGE_WIDTH){
                Color color = picture.getPixel( rowNumber, columnNumber);
                red = color.getRed();
                blue = color.getBlue();
                green = color.getGreen();
                average = (red+green+blue)/3;
                Color newColor = new Color (average, average, average);
                picture.setPixel (rowNumber, columnNumber, newColor  );
                columnNumber++;
            }
            rowNumber++;
            columnNumber = 0;
        }

        image.removeFromCanvas();
        image = picture.createVisibleImage ( 0,63, canvas);
    } 

    //determines which button is clicked and then calls the respective method
    public void onMouseClick (Location point){

        if (Gray.contains(point)){
            grayScale();

        }
        if (Mirror.contains(point)){
            mirror();

        }
        if (Original.contains(point)){
            original();
        }
        if (Blur.contains(point)){
            blur();
        }
    }

    //displays mirrored version of image when clicked on "Mirror button
    public void mirror(){
        // creates a new picture object which is blank
        blankPicture = new Picture (1280, 857);

        /* While loop to get location and color of every pixel 
         * set pixel color to respective new location on blank picture */
        int rowNumber = 0; 
        int columnNumber = 0;
        while (rowNumber<IMAGE_HEIGHT){
            while (columnNumber< IMAGE_WIDTH){
                Color color = picture.getPixel( rowNumber, columnNumber);
                //new location of pixels for mirrored image
                double newColumnNumber =IMAGE_WIDTH - columnNumber;

                //set previous pixel color to new column on blank picture 
                blankPicture.setPixel (rowNumber, newColumnNumber, color  );
                columnNumber++;
            }
            rowNumber++;
            columnNumber = 0;
        }

        image.removeFromCanvas();

        image = blankPicture.createVisibleImage ( 0,63, canvas);

    }

    // shows original image when clicked on "Original" button
    public void original (){

        image.removeFromCanvas();
        picture = new Picture ("http://www.mtholyoke.edu/~blerner/SnickersInSnow2.jpg");
        image = picture.createVisibleImage ( 0,63, canvas);

    }

    // This procedure will create a blurred version of the original image
    public void blur(){
        // Create a placeholder for the blurred image to be created
        blankPicture = new Picture (IMAGE_WIDTH, IMAGE_HEIGHT);
        // image row and column numbers
        int rowNumber = 0;
        int columnNumber = 0;
        // the level of blurryness defined by pixels
        final int BLUR_WIDTH = 7;
        // get a random number with spanning the range of negative BLUR_WIDTH to positive BLUR_WIDTH
        RandomIntGenerator colorGen = new RandomIntGenerator(-BLUR_WIDTH,BLUR_WIDTH);

        // For each row till we hit the last row ..
        while (rowNumber<IMAGE_HEIGHT){
            // For each column till we hit the last column .. 
            while (columnNumber< IMAGE_WIDTH){
                // get an offset value for pixels with the random generator
                int offsetValue = colorGen.nextValue();

                // read the pixel color defined by row/column numbers 
                Color color = picture.getPixel( rowNumber, columnNumber);

                // prepare a random column/row number to read a random pixel around the original pixel read before. 
                int randColumnNumber = columnNumber + offsetValue;
                int randRowNumber = rowNumber + offsetValue;

                // validate if we are going out of bounds then reset the value to a valid col/row value
                if (randColumnNumber >= IMAGE_WIDTH){
                    randColumnNumber = IMAGE_WIDTH-1;
                } else if (randColumnNumber < 0) {
                    randColumnNumber = 0; 
                } 
                if (randRowNumber >= IMAGE_HEIGHT){
                    randRowNumber = IMAGE_HEIGHT-1;
                } else if (randRowNumber < 0) {
                    randRowNumber = 0; 
                } 

                // read the color for a random pixel around original pixel using random row/column value prepared before. 

                Color randColor = picture.getPixel(randRowNumber, randColumnNumber);

                // set that random color to our original pixel for blur effect
                blankPicture.setPixel (rowNumber, columnNumber, randColor  );
                columnNumber++;
            }
            rowNumber++;
            columnNumber = 0;
        }
        image.removeFromCanvas();

        image = blankPicture.createVisibleImage ( 0,63, canvas);

    }

}