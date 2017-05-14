import objectdraw. *;
import java.awt. *;
/**
 * Constructor for GridCell objects which hold the information about whether the cell contains a mine
 * The number of neighbors that contain mines
 * Whether the cell is flagged, whether the contents of the cell has been Exposed to the user and functionality 
 * to draw the cell according to its current state
 * 
 * @author Umama Zillur 
 * @version Version 01 04/21/16
 */
public class GridCell
{
    //instance variables
    private FilledRect gridCell;
    private FilledOval mine;

    //boolean to check whether a cell has a mine
    private boolean hasMine;    

    //booleans to check if a cell is flagged or exposed
    private boolean isFlagged = false;
    private boolean isExposed = false;

    //local variables to hold information passed in from Grid class
    private DrawingCanvas canvas;
    private int cellSize;
    private int left;
    private int top;

    /** Constructor for grid cells with cellSize, location, and canvas
     * 
     */
    public GridCell(int left, int top, int cellSize, DrawingCanvas canvas){
        this.canvas = canvas;
        this.left  = left;
        this.top = top;
        this.cellSize = cellSize;

        //create gray squares of specific size
        gridCell = new FilledRect ( left, top, cellSize, cellSize, canvas);
        gridCell.setColor(Color.GRAY);
        //create black rectangle to outline grid cells
        FramedRect outline = new FramedRect(left, top, cellSize, cellSize, canvas);
        outline.setColor(Color.BLACK);
        //place mine at the center of grid cells
        mine = new FilledOval (0,0, 10, 10, canvas);
        double mineWidth = mine.getWidth();
        mine.moveTo(left+cellSize/2 - mineWidth/2, top+cellSize/2 - mineWidth/2);
        //hide mines
        mine.hide();

    }

    /**
     * Returns if the cell if flagged or not
     */
    public boolean getIsFlagged(){
        return this.isFlagged;
    }

    /**
     * Flags cell according to the given value
     */
    public void setIsFlagged (boolean isFlagged){
        this.isFlagged = isFlagged;

    }

    /**
     * Returns whether a cell is exposed or not
     */
    public boolean getIsExposed(){
        return this.isExposed;
    }

    /**
     * Marks as exposed cell according to given value
     */
    public void setIsExposed (boolean isExposed){
        this.isExposed = isExposed;    
    }

    /**
     * Puts mine in a cell
     */
    public void setMine(){
        hasMine = true;
    }

    /**
     * Returns whether a cell has a mine
     */
    public boolean getHasMine(){
        return hasMine;

    }

    /** 
     * Shows mine
     */
    public void revealMine(){
        if(hasMine){
            mine.show();
        }
    }

    /**
     * Returns true is mouse is clicked on a grid cell
     * 
     */
    public boolean contains (Location point) {
        if (gridCell.contains (point) ) {
            return true;
        }
        else {
            return false;
        }
    }

    /** 
     * Shows neighbour count by creating text object with the variable neighbour
     * passed in from the Grid class
     * 
     */
    public void showNeighbourCount(int neighbour){
        //create text object with neighbour count
        Text textSymbol = new Text (neighbour, 0,0, canvas);
        //change text font size
        textSymbol.setFontSize(15);
        //move text to center of grid cell
        double symbolWidth = textSymbol.getWidth();
        double symbolHeight = textSymbol.getHeight();
        textSymbol.moveTo(left+cellSize/2 - symbolWidth/2, top+cellSize/2 - symbolHeight/2);

    }

    /** 
     * Takes in a color parameter and sets color to a grid cell
     * 
     */
    public void setColor (Color color){
        gridCell.setColor(color);       

    }
}
