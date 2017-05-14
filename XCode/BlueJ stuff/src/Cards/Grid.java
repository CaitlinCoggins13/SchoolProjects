import objectdraw.*;
import java.awt.*;

/** 
 * Constructing the individual GridCells, converting from x, y pixel coordinates to row, col coordinates
 * Randomly placing the mines in the grid
 * Calculating the number of neighbors of a cell that contain a mine
 * Providing the logic about what should happen when the user clicks or right-clicks on a cell
 * Determining when the game is over
 * 
 * @author Umama Zillur 
 * @version Version 04/21/16
 */
public class Grid 
{
    //maximum number of grid cells in the grid cell array
    private static final int MAX_GRIDS = 100;
    //new GridCell array
    private GridCell[][] gridArray;
    //distance between canvas border and grid from the left and top 
    private static final int GRID_INSET = 10;
    // size of grid
    private static final int CELL_SIZE = 20;

    //creates grid outline
    public FilledRect gridOutline;
    //new canvas
    private DrawingCanvas canvas;
    //variable for number of neighbours
    public int neighbour;
    // maximum number of rows and columns in the array
    private int maxRows;
    private int maxColumns;
    // variable for number of mines found
    private int minesFound = 0;
    //count of cells which have been exposed
    private int exposedCell = 90;

    /**
     * Constructs the individual GridCells and takes in the number of rows and columns the 
     * grid should have
     * 
     */
    public Grid (int maxRows, int maxColumns, DrawingCanvas canvas){
        //storing variables in instance variables
        this.canvas = canvas;
        this.maxRows = maxRows;
        this.maxColumns = maxColumns;
        //creates grid cells and adds to grid
        newGrid();

    }

    /**
     * Creates individual grid cells and adding to the 2D array
     */
    private void newGrid(){
        //creating new array of grid cells with specific rows and columns
        gridArray = new GridCell[maxRows][maxColumns];
        //creates an outline used to check if mouse is clicked within grid
        gridOutline = new FilledRect(GRID_INSET, GRID_INSET ,CELL_SIZE*maxColumns, CELL_SIZE*maxRows, canvas);

        //creates grid cells and adds to 2D array
        for(int i = 0; i < maxRows; i++){
            for (int j = 0; j < maxColumns; j++){
                GridCell newCell = new GridCell(GRID_INSET+CELL_SIZE*j, GRID_INSET + CELL_SIZE*i, CELL_SIZE,canvas);
                gridArray[i][j] = newCell;
            }
        }

    }

    /**
     * Reveals all mines that are on the grid
     */
    public void showAllMines(){
        //walks through the 2D array and reveals mines
        for(int i = 0; i < maxRows; i++){
            for (int j = 0; j < maxColumns; j++){
                gridArray[i][j].revealMine();

            }
        }
    }

    /**
     * Places number of mines given in random array indexes
     */
    public void placeMines(int mineCount){
        //creates two RandomIntGenerators with specified range
        RandomIntGenerator rowGenerator = new RandomIntGenerator (0,maxRows-1);
        RandomIntGenerator colGenerator = new RandomIntGenerator (0,maxColumns-1);

        //places number of mines denoted by mineCount in randomly generated rows and columns
        for(int i = 0; i < mineCount; i++){
            int randRow = rowGenerator.nextValue();
            int randCol = colGenerator.nextValue();
            //System.out.println(randRow+" " +  randCol);'
            gridArray[randRow][randCol].setMine();
            //gridArray[randRow][randCol].revealMine();

        }
    }

    /**
     * If mouse is clicked on cell with a mine, all mines are exposed and the cell is 
     * colored red
     * If mine explodes return true so that the caller can decide game is over
     */

    public boolean explodeMine(Location point){
        int row = getRow(point);
        int column = getCol(point);
        if(!gridArray[row][column].getIsFlagged()){

            if(gridArray[row][column].getHasMine()){
                showAllMines();
                gridArray[row][column].setColor(Color.RED);

                return true;
            }

        }
        return false;
    }

    /**
     * When right clicked on a cell, cell colored blue and flagged
     * If right clicked on a flagged cell, cell is colored gray and unflagged
     */
    public void setFlagged(Location point){
        //translates x, y pixel coordinates to row, col coordinates 
        int row = getRow(point);
        int column = getCol(point);

        //When right clicked on a cell, cell colored blue and flagged
        //If right clicked on a flagged cell, cell is colored gray and unflagged
        if(gridArray[row][column].getIsFlagged()){
            gridArray[row][column].setIsFlagged(false);
            gridArray[row][column].setColor(Color.GRAY); 
            minesFound--;

        }
        else{
            gridArray[row][column].setIsFlagged(true);     
            gridArray[row][column].setColor(Color.BLUE);
            minesFound++;

        }
    }

    /**
     * Count and display neighbouring cells with mines, track exposed cells
     * If all cells without mines are exposed, display text 'You Win'
     */
    public void processCell(Location point){
        int row = getRow(point);
        int column = getCol(point);

        //checks that cell is not exposed
        if(!gridArray[row][column].getIsExposed()){
            //checks that user did not expose all cells
            if(exposedCell > 0){
                //checks that cell is not flagged
                if(!gridArray[row][column].getIsFlagged()){
                    neighbour = 0;
                    //clockwise checks that adjacent cells to see if there is a mine
                    //increments counts for each mine found
                    for(int i = row-1; i < row+2; i++){
                        for(int j = column-1; j < column+2; j++){
                            if(i >= 0 && i < maxRows && j >= 0 && j < maxColumns){
                                if(gridArray[i][j].getHasMine()){
                                    neighbour ++;
                                }
                            }
                        }
                    }

                    //if there are mines in neighbouring cells, cell is colored white
                    //display neighbour count
                    //reduce expose cell count to reach towards all cells exposed
                    if(neighbour != 0){
                        gridArray[row][column].showNeighbourCount(neighbour);
                        gridArray[row][column].setColor(Color.WHITE);
                        gridArray[row][column].setIsExposed(true);
                        exposedCell--;

                    }
                    //if no neighbours are found with mines, cell is colored white
                    //cell is marked as exposed and expose cell count reduced
                    else{
                        gridArray[row][column].setColor(Color.WHITE);
                        gridArray[row][column].setIsExposed(true);
                        exposedCell--;
                    }

                    //System.out.println(exposedCell);
                }

            }

            //if all cells without mines are exposed, user wins
            else{
                Text winText = new Text ("YOU WIN !!!", 40, 220, canvas);
                winText.setFontSize(25);
                winText.setBold(true);
            }
        }
    }

    /**
     * Translates x pixel coordinates to row coordinates
     */
    private int getRow (Location point) {
        return ((int)(point.getY() - GRID_INSET)) / CELL_SIZE;
    }

    /**
     * Translates y pixel coordinates to col coordinate
     */
    private int getCol (Location point) {
        return ((int)(point.getX() - GRID_INSET)) / CELL_SIZE;
    }

    /**
     * Returns the number of flagged cells
     */
    public int getMinesFound(){
        return minesFound;
    }
}
