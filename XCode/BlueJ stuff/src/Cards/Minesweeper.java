import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
/**
 * Creates a minesweeper game. User wins by exposing all the cells without mines
 * If a mine exposed the game is over
 * 
 * @author Umama Zillur 
 * @version Version 04/18/16
 */
public class Minesweeper extends FrameWindowController implements ActionListener,MouseListener 
{
    //JButtons in instance variables
    private JButton newGame;
    private JLabel minesFound;

    //constants for rows and columns of grid 
    private static final int MAX_ROWS = 10;
    private static final int MAX_COLUMNS = 10;

    //instance variable for the grid class
    private Grid grid;
    //determines if the game is over
    private boolean isGameOver = false;

    /**
     * Creates and layout the Swing components in the user interface.
     * Calls the Grid constructor.
     */
    public void begin(){
        //creates new JPanels and JButtons 
        JPanel upperPanel = new JPanel();
        newGame = new JButton ("New Game");
        newGame.addActionListener(this);
        upperPanel.add(newGame);
        JPanel lowerPanel = new JPanel();
        
        JPanel commonPanel = new JPanel();
        commonPanel.setLayout(new BoxLayout(commonPanel, BoxLayout.Y_AXIS));
        commonPanel.add(upperPanel);
        commonPanel.add(lowerPanel);
        //adds Panel to the bottom of the window
        add(commonPanel,BorderLayout.SOUTH);

        //creates JLabel to display mines found count
        minesFound = new JLabel();
        minesFound.setText("Mines Found" +  ":" + "0/10");
        lowerPanel.add(minesFound);

        //add mouselistener to canvas
        canvas.addMouseListener(this);

        //create new grid
        grid = new Grid (MAX_ROWS, MAX_COLUMNS, canvas);
        // place ten mines
        grid.placeMines(10);
        //resize canvas to fit grid and panels
        resize(250,400);

        //grid.showAllMines();

    }

    /**
     * Identifies between left and right clicks and performs appropriate actions
     */
    public void mousePressed(MouseEvent event) {
        //checks if game is over
        if(!isGameOver){
            Location point = new Location (event.getX(), event.getY());
            //checks if mouse is clicked within grid
            if (grid.gridOutline.contains(point)){
                if (event.getButton() == MouseEvent.BUTTON3 || 
                (event.getModifiersEx() & MouseEvent.CTRL_DOWN_MASK) == MouseEvent.CTRL_DOWN_MASK) {
                    //flags or unflags cell on right click
                    grid.setFlagged(point);

                    //updates mines found count in JLabel
                    minesFound.setText("Mines Found" +  ":" + grid.getMinesFound()  + "/10");

                    //System.out.println ("Right click at " + point.getX() + ", " + point.getY());
                }
                //if control click
                else {
                    //if mine is not exploded on the click
                    if(! grid.explodeMine(point)){
                        //either displays neighbour or exposes it 
                        grid.processCell(point);

                    }
                    //if mine is exploded
                    else {

                        isGameOver = true;
                        //displays losing text
                        Text loseText = new Text ("YOU LOSE!!!", 40, 220, canvas);
                        loseText.setFontSize(25);
                        loseText.setBold(true);
                        System.out.println ("Click at " + point.getX() + ", " + point.getY());
                    }

                }

            }
        }
    }

    // The following methods are part of the MouseListener interface but you do not need them
    // for this assignment.  Leave them blank.
    public void mouseClicked(MouseEvent arg0) {
    }

    public void mouseReleased(MouseEvent arg0) {
    }

    public void mouseEntered(MouseEvent arg0) {
    }

    public void mouseExited(MouseEvent arg0) {
    }

    /**
     * Method carries out specific actions in response to user interaction with the button
     * When newGame button is pressed game is reset
     */
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == newGame){

            //reset mines found count
            minesFound.setText("Mines Found" +  ":" + "0/10");
            //reset all instance variables to original values
            grid = null;
            isGameOver = false;
            //recreate grid and place mines
            grid = new Grid (MAX_ROWS, MAX_COLUMNS, canvas);
            grid.placeMines(10);

            //grid.showAllMines();

        }
    }

}
