// TetrisGameGUIController.java
// Caitlin Coggins

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.Timer;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

/**
 * TetrisGameGUIController controls when displays are updated, the timer dropping the tetris pieces, and
 * what behaviors are enacted when certain keys are pressed.
 **/
public class TetrisGameGUIController extends JPanel implements KeyListener
{
    /* The default rate at which a tetris piece will drop automatically. */
    public static int DEFAULT_DROP_RATE = 1000;
    
    /* Instance of a TetrisGame. */
    private TetrisGame game;
    
    /* Instanc of a TetrisBoardGUIView. */
    private TetrisBoardGUIView view;
    
    /* Timer, is used to move the pieces down. */
    private Timer gameTimer;
    
    /* Displays the number of lines cleared. */
    private JLabel linesLabel;
    
    /* Displays the number of tetrises cleared. */
    private JLabel tetrisesLabel;
    
    /**
     * Constuctor.
     * Adds key listener.
     * Initializes game and view and adds the score and board displays.
     * Sets up timer.
     **/
    public TetrisGameGUIController()
    {
        // calls super
        super(new BorderLayout());
        
        // add key listener
        setFocusable(true);
        addKeyListener(this);
        
        // initializing
        game = new TetrisGame();
        view = new TetrisBoardGUIView(game);
        
        // adding score and board
        add(createScore(), BorderLayout.NORTH);
        add(view, BorderLayout.CENTER);
        
        // set up and start timer
        setupTimer();
        
    }
    
    /**
     * Initializes the panel with the labels in it and adds it to the main panel.
     **/
    private JPanel createScore()
    {
        JPanel labels = new JPanel();
        
        linesLabel = new JLabel("Lines cleared: " + game.getNumLines() + "       ");
        tetrisesLabel = new JLabel("Tetrises cleared: " + game.getNumTetrises());
        
        // add the labels
        labels.add(linesLabel);
        labels.add(tetrisesLabel);
        
        return labels;
    }
    
    /**
     * Refreshes the displayed score.
     **/
    private void refreshScore()
    {
        linesLabel.setText("Lines cleared: " + game.getNumLines() + "       ");
        tetrisesLabel.setText("Tetrises cleared: " + game.getNumTetrises());
    }
    
    /**
     * Refreshes the view of the board.
     **/
    private void createView()
    {
        view = new TetrisBoardGUIView(game);
        repaint();
    }
    
    /**
     * Determines which key was pressed and acts in a different way for each usable key. 
     * Refreshes the view and score.
     * @param e KeyEvent object
     **/
    public void keyPressed(KeyEvent e)
    {
        // different behavior depending on which key was pressed
        switch( e.getKeyCode() )
        {
                // if it's L
            case KeyEvent.VK_L:
                // apply an impulse to the ball
                game.attemptMove(0);
                
                // update the view
                createView();
                
                // apply any score changes
                refreshScore();
                
                break;
            case KeyEvent.VK_R:
                game.attemptMove(1);
                
               // update the view
                createView();
                
                // apply any score changes
                refreshScore();
                
                break;
            case KeyEvent.VK_D:
                game.attemptMove(2);
                
                // update the view
                createView();
                
                // apply any score changes
                refreshScore();
                
                break;
            case KeyEvent.VK_Z:
                game.attemptMove(3);
                
                // update the view
                createView();
                
                // apply any score changes
                refreshScore();
                
                break;
            case KeyEvent.VK_X:
                game.attemptMove(4);
                
                // update the view
                createView();
                
                // apply any score changes
                refreshScore();
                
                break;
            default:
                System.out.println("KEY RELEASED: " + e.getKeyCode() );
        }
    }
    
    /**
     * Not in use, but required to use KeyListener.
     * @param e KeyEvent object
     **/
    public void keyReleased(KeyEvent e)
    {
       
    }
    
    /**
     * Not in use, but required to use KeyListener.
     * @param e KeyEvent object
     **/
    public void keyTyped(KeyEvent e)
    {
        
    }
    
    /**
     * Starts the timer that slowly drops the tetris pieces.
     **/
    public void setupTimer()
    {
        gameTimer = new Timer( DEFAULT_DROP_RATE, new ActionListener()
        {
            /**
             * Invoked every time the timer finishes.
             */
            public void actionPerformed(ActionEvent e)
            {
                // move the current tetris piece down one
                game.attemptMove(2);
                
                // update the view
                createView();
                
                // apply any score changes
                refreshScore();
            }
        });
        
        // loop the timer
        gameTimer.restart();
    }
}