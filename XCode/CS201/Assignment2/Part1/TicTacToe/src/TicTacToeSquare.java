// TicTacToeSquare.java
// Caitlin Coggins

// swing
import javax.swing.JButton;
import javax.swing.JPanel;

// util
import java.util.Arrays;

/**
 * TicTacToeSquare constructs a TicTacToeSquare (shortened to square in some comments), 
 * checks if two squares contain the same text, and displays the symbol of the player 
 * who clicked a square on that square and disables it from being clicked again.
 **/
public class TicTacToeSquare extends JButton
{
    private static int rememberTurn;
    
    /**
     * Constructor for TicTacToeSquares
     **/
    public TicTacToeSquare()
    {
        // calls super
        super();
    }
    
    /**
	 * Check if the passed piece has the same mark as this one.
     * @param sq, TicTacToeSquare that the text of the clicked square is being compared with
	 * @return true if two squares have the same mark, false otherwise.
	 **/
	public boolean matches( TicTacToeSquare sq )
    {
        // if the text in the square clicked matches square sq, true is returned
        if( this.getText().equals(sq.getText()))
            return true;
        else
            return false;
    }
    
    /**
     * Determines whether X or O should be displayed on the clicked button 
     * based on which player clicked the button.
     * @return X for player 1, O for player 2.
     **/
    public String checkXorO()
    {
        // if the turn is even, player 1 clicked the square
        if(rememberTurn%2==0)
            return "X";
        // else, player 2 clicked the square
        else
            return "O";
    }
    
    /**
     * Sets the text on the clicked button and makes it unclickable.
     * Changes the value of rememberTurn to set it for the next player.
     **/
    public void refreshDisplay()
    {
        // sets square's text
        this.setText(checkXorO());
        
        // disables the square
        this.setEnabled(false);
        
        // adds one to the variable keeping track of whose turn it is
        ++rememberTurn;
        
	}
    
    public void replay()
    {
    	this.setEnabled(true);
    	this.setText("");
    }
   
}