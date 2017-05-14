import java.awt.*;
import objectdraw.*;

/**
 * A program that demonstrates a racing game between four Mascots: Griffin, Lion, Pegasus and Sphinx.
   The programs starts with the display of the lanes and the four mascots behind the starting line.
   When the user clicks on the screen, each mascot starts to move horizontally on its lane and with different
   random speeds. The mascots all stop right after they cross the finishing line.
 * 
 * @author Anh Chau Pham
 * @version March 30th, 2016
 */

public class RacingMohos extends FrameWindowController 
{
    //The first laneline
    private Line laneline1;
    //The second laneline
    private Line laneline2;
    //The third laneline
    private Line laneline3;

    //The startingline
    private Line startline;
    //The finishingline 
    private Line finishline;
    
    //Image of the griffin mascot
    private Image griffinpicture;
    //Image of the lion mascot
    private Image lionpicture;
    //Image of the pegasus mascot
    private Image pegasuspicture;
    //Image of the sphinx picture
    private Image sphinxpicture;
    
    //The griffin mascot
    private Mascot griffin;
    //The lion mascot
    private Mascot lion;
    //The pegasus mascot
    private Mascot pegasus;
    //The sphinx mascot
    private Mascot sphinx;
    
    //The location where the mascots stop
    private Location stop;
    
    //The location where the griffin mascot stays when the program starts
    private Location griffinstart;
    //The location where the lion mascot stays when the program starts
    private Location lionstart;
    //The location where the pegasus mascot stays when the program starts
    private Location pegasusstart;
    //The location where the sphinx mascot stays when the program starts
    private Location sphinxstart;
    
    //The text at the bottom of the screen
    private Text text;
    
    //The color of the text
    private Color purple;
    
    //The location of the text
    private Location textlocation;
   
    //The space between the outer edges of the canvas and the lines displayed
    private static final double SPACE = 35;
    
    //The height of each lane 
    private static final double LANE_HEIGHT = 100;
    
    /**
     * Display the three lane lines,the starting line, the finishing line, the four mascots and the text when
       the program starts.
     */
    public void begin() {
                //Resize the window to a particular size
        resize (840, 560);
        
        //The location where the griffin mascot stays when the program starts
        griffinstart = new Location (840-SPACE-LANE_HEIGHT+10, SPACE+10);
        //The location where the lion mascot stays when the program starts
        lionstart = new Location (840-SPACE-LANE_HEIGHT+10, SPACE+10+LANE_HEIGHT);
        //The location where the pegasus mascot stays when the program starts
        pegasusstart = new Location (840-SPACE-LANE_HEIGHT+10, SPACE+10+2*LANE_HEIGHT);
        //The location where the sphinx mascot stays when the program starts
        sphinxstart = new Location (840-SPACE-LANE_HEIGHT+10, SPACE+10+3*LANE_HEIGHT);
        
        //The location where the mascots stop
        stop = new Location (135,0);
        
        //Dipslay the first lane line
        laneline1 = new Line (SPACE,SPACE+LANE_HEIGHT, 840-SPACE, SPACE+LANE_HEIGHT, canvas);
        //Display the second lane line
        laneline2 = new Line (SPACE,SPACE+2*LANE_HEIGHT, 840-SPACE, SPACE+2*LANE_HEIGHT, canvas);
        //Display the third lane line
        laneline3 = new Line (SPACE,SPACE+3*LANE_HEIGHT, 840-SPACE, SPACE+3*LANE_HEIGHT,canvas);
        //Display the starting line
        startline = new Line (840-SPACE-LANE_HEIGHT, SPACE, 840-SPACE-LANE_HEIGHT, SPACE+4*LANE_HEIGHT, canvas);
        //Display the finishing line
        finishline = new Line (SPACE+100, SPACE, SPACE+LANE_HEIGHT, SPACE+4*LANE_HEIGHT, canvas);
        
        //Load the picture of the griffin mascot
        griffinpicture = getImage ("green_griffin.jpg");
        //Load the picture of the lion mascot
        lionpicture = getImage("lion.png");
        //Load the picture of the pegasus mascot
        pegasuspicture = getImage("pegasus.png"); 
        //Load the picture of the sphinx mascot
        sphinxpicture = getImage("sphinx.png");
        
        //Display the griffin mascot
        griffin = new Mascot(griffinpicture, griffinstart, stop, canvas);
        //Display the lion mascot
        lion = new Mascot (lionpicture, lionstart, stop, canvas);
        //Display the pegasus mascot
        pegasus = new Mascot (pegasuspicture, pegasusstart, stop, canvas);
        //Display the sphinx mascot
        sphinx = new Mascot (sphinxpicture, sphinxstart, stop, canvas);
        
        //Display the text
        text = new Text ("Racing Mohos", 50, 100, canvas);
        
         //The color of the text
        purple = new Color (150, 0, 150);
        
        //Set the text to bold
        text.setBold();
        
        //Set the color for the text
        text.setColor(purple);
        
        //Set the font size for the text
        text.setFontSize(20);
        
        //The final location of the text
        textlocation = new Location (0+canvas.getWidth()/2-text.getWidth()/2, SPACE+4*LANE_HEIGHT+10);
        
        //Move the text to that final location
        text.moveTo(textlocation);
    }
    
    /**
     * When the user uses the mouse to click on any point on the screen, all four mascots start to move
       horizontally on the lanes with different random speeds and stop after they cross the finishing line.
     */
    public void onMouseClick (Location point)
    {
        //start the animation of the griffin mascot
        griffin.start();
        
        //start the animation of the lion mascot
        lion.start();
        
        //start the animation of the pegasus mascot
        pegasus.start();
        
        //start the animation of the sphinx mascot
        sphinx.start(); 
    }
}

    