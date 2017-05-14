// TicTacToeGame.java
// Caitlin Coggins

// awt
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// swing
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import javax.swing.JDialog;


// TA Humaira suggested that I move the ActionListener to the Game class instead leaving it in the Square class.

/**
 * TicTacToeGame creates the instructions text area, the panel of TicTacToeSquares for the game, 
 * and the status bar that displays whose turn is next.  When a TicTacToeSquare is clicked, 
 * the symbol of the player that clicked it is displayed, the game checks for a win or a tie,  
 * and the status bar prompts the other player to click a square.
 **/
public class TicTacToeGame extends JPanel implements ActionListener
{
    private int sideLength;
    private int playerTurn = 1;
    private TicTacToeSquare[] gameSquares;
    private JTextArea playerArea;
    private JTextArea scoreboard;
    private JButton resetScore;
    private int player1Score = 0;
    private int player2Score = 0;
    
    /**
     * Constructor, creates a panel with buttons for each cell on the tic tac toe board,
     * a text area that displays instructions, and a text area that tells the players whose turn it is.
     * @param dimensions, dimensions is the number of rows and columns
     * that the tic tac toe game will have.
     **/
    public TicTacToeGame(int dimensions)
    {
        // calls super
        super(new BorderLayout());
        
        // sideLength is set
        sideLength = dimensions;
        
        // the array of TicTacToeSquares is initialized
        gameSquares = new TicTacToeSquare[dimensions*dimensions];
        
        // the instructions text area is added
        add(displayInstructions(), BorderLayout.NORTH);
        // the panel of TicTacToeSquares is added
        add(createButtons(), BorderLayout.CENTER);
        // the text area that displays whose turn is next is added
        add(createTextArea(), BorderLayout.SOUTH);
    }
    
    /**
     * Goes to other constructor with the default board setting of 3.
     **/
    public TicTacToeGame()
    {
        this(3);
    }
    
    /**
     * Creates a text area that displays the game's instructions.
     * @return JTextArea instructions, the text area that displays the instructions.
     **/
    public JPanel displayInstructions()
    {
    	JPanel addition = new JPanel(new BorderLayout());
    	
        JTextArea instructions = new JTextArea("Welcome to TicTacToe! Player 1 is X, Player 2 is O.  Fill a row, column or one of the diagonals with your symbol to win.  Enjoy!\n");
        
        instructions.setEditable(false);
        
        instructions.setLineWrap(true);
        
        instructions.setWrapStyleWord(true);
        
        addition.add(instructions, BorderLayout.NORTH);
        
        JPanel score = new JPanel(new BorderLayout());
        
        scoreboard = new JTextArea("Player 1: 0  Player 2: 0");
        
        score.add(scoreboard, BorderLayout.CENTER);
        
        resetScore = new JButton("Reset Score");
        
        resetScore.addActionListener(this);
        
        score.add(resetScore, BorderLayout.EAST);
        
        addition.add(score, BorderLayout.SOUTH);
        
        return addition;
    }
    
    /**
     * Creates a JPanel for TicTacToeSquares, then creates a TicTacToeSquare for every 
     * spot on the tic tac toe board, adds an ActionListener, adds every TicTacToeSquare 
     * to the panel, and returns the panel.
     * @return JPanel buttons, a panel with every TicTacToeSquare in it.
     **/
    public JPanel createButtons()
    {
        JPanel buttons = new JPanel (new GridLayout(sideLength, sideLength));
        
        for(int i=0; i<sideLength*sideLength; ++i)
        {
            gameSquares[i]=new TicTacToeSquare();
            gameSquares[i].addActionListener(this);
            buttons.add(gameSquares[i]);
        }
        
        return buttons;
    }
    
    /**
     * The text area that displays whose turn it is is created.
     * @return JTextArea playerArea, shows whose turn is next
     **/
    public JTextArea createTextArea()
    {
        playerArea = new JTextArea("Player " + playerTurn + ", make your move!");
        
        playerArea.setEditable(false);
        
        return playerArea;
    }
    
    /**
     * The number of the next player is determined.
     **/
    public void setPlayerTurn()
    {
        if (playerTurn %2 == 0)
            playerTurn = 1;
        
        else
            playerTurn = 2;
    }
    
    /**
     * Checks to see if the game had ended in a tie.  
     * If so, a JOptionPane is created to inform the players of the tie.
     * NOTE: A tie is detected by all squares being clicked, not when it is impossible for either
     * player to win from any remaining moves.
     **/
    public void checkTie()
    {
        int count=0;
        
        for(int i=0; i<sideLength*sideLength; ++i)
        {
            if(gameSquares[i].getText() != "")
            {
                ++count;
            }
            // if even one square is empty, there is no definite tie
            else
                break;
        }
        
        // if every square is marked with an X or an O, the tie JOptionPane is created.
        if(count == sideLength*sideLength)
        {
            JOptionPane.showMessageDialog(null, "Sorry, it's a tie!");
            for(int i=0; i<sideLength*sideLength; ++i)
            {
                gameSquares[i].replay();
            }
        }
    }
    
    /**
     * Checks for a win in the row and column of the clicked square, and in the diagonals if applicable.
     * @param row, the row of the clicked piece
     * @param col, the column of the clicked piece
     * @return true for a win, false for no win
     **/
    public boolean completesMatch( int row, int col )
    {
        boolean win = false;
        
        // checks row for win
        win = completesRow(row);
        
        if(win)
            return true;
        
        // checks column for win
        win = completesColumn(col);
        
        if(win)
            return true;
        
        // checks top left to bottom right diagonal for win
        if(row == col)
            win = completesTopLeftToBottomRight();
        
        if(win)
            return true;
        
        // checks top right to bottom left diagonal for win
        if( row+col == sideLength+1 )
            win = completesTopRightToBottomLeft();
        
        if(win)
            return true;
        
        // if a player didn't win, maybe the game ended in a tie
        if(win == false)
            // checks to see if the game ended in a tie
            checkTie();
        
        return false;
    }
    
    /**
     * Checks for a win in the row of the square the player clicked.
     * @param row, the row number of the square clicked
     * @return true for a win, false otherwise
     **/
    public boolean completesRow(int row)
    {
        boolean rowWin = false;
        
        // if the square's row is 1
        if(row==1)
        {
            // checks every TicTacToeSquare in the row to see if all squares have the same symbol
            for(int i=0; i<sideLength-1; ++i)
            {
                // checks for a match
                rowWin = gameSquares[i].matches(gameSquares[i+1]);
                
                // if there is no match, end the loop
                if(rowWin == false)
                    break;
            }
            
            // if every square in the row matched the others, a player has won
            if(rowWin == true)
            {
                return true;
            }
        }
        
        // if the row is greater than 1
        else
        {
            // checks every TicTacToeSquare in the row to see if all squares have the same symbol
            for(int i=(row-1)*sideLength; i<(row-1)*sideLength+(sideLength-1); ++i)
            {
                // checks for a match
                rowWin = gameSquares[i].matches(gameSquares[i+1]);
                
                // if there is no match, end the loop
                if(rowWin == false)
                    break;
            }
            
            // if every square in the row matched the others, a player has won
            if(rowWin==true)
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Checks for a win in the column of the square the player clicked.
     * @param col, the column number of the square clicked
     * @return true for a win, false otherwise
     **/
    public boolean completesColumn(int col)
    {
        boolean colWin = false;
        // if the column number is 1
        if( col ==1)
        {
            // checks every TicTacToeSquare in the row to see if all squares have the same symbol
            for(int i=0; i<sideLength*sideLength-sideLength; i+=sideLength)
            {
                // checks for a match
                if(gameSquares[i].matches(gameSquares[i+sideLength]) == false)
                    break;
                
                // if there is no match, end the loop
                if(colWin == false)
                    break;
            }
            
            // if every square in the column matched the others, a player has won
            if(colWin==true)
            {
                return true;
            }
        }
        
        // if the column number is greater than 1
        else
        {
            // checks every TicTacToeSquare in the row to see if all squares have the same symbol
            for(int i=col-1; i<sideLength*sideLength-sideLength; i+=sideLength)
            {
                // checks for a match
                colWin = gameSquares[i].matches(gameSquares[i+sideLength]);
                
                // if there is no match, end the loop
                if(colWin == false)
                    break;
            }
            
            // if every square on the diagonal matched the others, a player has won
            if(colWin==true)
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Checks for a win in the top left to bottom right diagonal.
     * @return true for a win, false otherwise
     **/
    public boolean completesTopLeftToBottomRight()
    {
        boolean topLBottomRWin = false;
        // checks every TicTacToeSquare in the row to see if all squares have the same symbol
        for(int i=0; i<sideLength*sideLength-1; i+=sideLength+1)
        {
            // checks for a match
            topLBottomRWin = gameSquares[i].matches(gameSquares[i+(sideLength+1)]);
            
            // if there is no match, end the loop
            if(topLBottomRWin == false)
            {
                break;
            }
        }
        
        // if every square on the diagonal matched the others, a player has won
        if(topLBottomRWin==true)
            return true;
        else
            return false;
    }
    
    /**
     * Checks for a win in the top right to bottom left diagonal.
     * @return true for a win, false otherwise
     **/
    public boolean completesTopRightToBottomLeft()
    {
        boolean topRBottomLWin = false;
        // checks every TicTacToeSquare in the row to see if all squares have the same symbol
        for(int i=sideLength-1; i<sideLength*sideLength-sideLength; i+=sideLength-1)
        {
            // checks for a match
            topRBottomLWin = gameSquares[i].matches(gameSquares[i+(sideLength-1)]);
            
            // if there is no match, end the loop
            if(topRBottomLWin == false)
                break;
        }
        
        // if every square on the diagonal matched the others, a player has won
        if( topRBottomLWin == true)
            return true;
        else
            return false;
    }
    
    /**
     * Finds the row and column of the TicTacToeSquare clicked and checks if a player won.
     * If a player did win, an option pane informs the players of the winner.
     * @param cell, location of the square clicked in the array
     **/
    public void checkWin(int cell)
    {
        boolean done;
        int row;
        int col=cell%sideLength+1; // finds column of square clicked
        
        // finds row of the square clicked
        if(cell<sideLength)
            row=1;
        else
            row=cell/sideLength+1;
        
        // checks to see if a player won
        done = completesMatch(row, col);
        
        // when a player wins
        if(done == true)
        {
            // a JOptionPane informs the players of who won
            JOptionPane.showMessageDialog(null, "Player " + playerTurn +" wins!");
            
            if(playerTurn == 1)
            	player1Score ++;
            else
            	player2Score ++;
            
            scoreboard.setText("Player 1: " + player1Score +"  Player 2: "+ player2Score);
            
            // all remaining unclicked buttons become unclickable
            for(int i=0; i<sideLength*sideLength; ++i)
            {
                gameSquares[i].replay();
            }
        }
    }
    
    /**
     * Retrieves the square clicked, matches it with the square in the TicTacToeSquare array, 
     * then puts the X or O in the square and checks if a player has won.
     * @param e, used to detect a click of a button
     **/
    public void actionPerformed( ActionEvent e)
    {
        // gets square clicked
        if(e.getSource() == resetScore)
        {
        	player1Score = 0;
        	player2Score = 0;
        	scoreboard.setText("Player 1: 0  Player 2: 0");
        }
        
        else
        {
        	TicTacToeSquare buttonPressed = (TicTacToeSquare)e.getSource();
        	// checks with every square to find the one clicked
        	for(int i=0; i<sideLength*sideLength; ++i)
        	{
        		if(buttonPressed.equals(gameSquares[i]))
        		{
        			// adds X or O
        			gameSquares[i].refreshDisplay();
        			
        			// checks to see if a player has won
        			checkWin(i);
                
        			// exit loop
        			break;
        		}
        	}
        
        	// sets playerTurn to the other player's number
        	setPlayerTurn();
        
        	// changes text area to prompt the other player to take their turn
        	playerArea.setText("Player " + playerTurn +", make your move!");
        }
    }

}