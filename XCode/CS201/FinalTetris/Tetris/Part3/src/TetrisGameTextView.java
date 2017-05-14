// TetrisGameTextView.java
// Caitlin Coggins

public class TetrisGameTextView
{
    /** Instance of a TetrisGame. **/
    private TetrisGame game;
    
    /** Array to hold String version of the view. **/
    private String[][] view;
    
    /**
     * Constructor.
     * Initializes game and view.
     **/
    public TetrisGameTextView( TetrisGame g)
    {
        game = g;
        view = new String[18][10];
        getBoardView();
    }
    
    /**
     * Creates the array of Strings to be printed when called.
     **/
    private void getBoardView()
    {
        for(int i=0; i<view.length; ++i)
        {
            for(int j=0; j<view[i].length; ++j)
            {
                // if there is a piece of a block there, add an x to the corresponding cell
                if(game.testBlock(i, j) == true)
                    view[i][j]="x";
                // else, add a space
                else
                    view[i][j]=" ";
                
            }
        }
    }
    
    /**
     * Prints the view of the tetris board for the user.
     **/
    public void getView()
    {
        // prints lines cleared
        System.out.println("Number of lines cleared: " + game.getNumLines() );
        
        // prints tetrises cleared
        System.out.println("Number of tetrises cleared: " + game.getNumTetrises());
        
        System.out.println("----------");
        
        // prints board
        for(int i=0; i<view.length; ++i)
        {
            for(int j=0; j<view[i].length; ++j)
            {
                System.out.print(view[i][j]);
            }
            System.out.println();
        }
        System.out.println("----------");
    }
    
    
}