// SorterPanel.java
// Caitlin Coggins

// awt
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Color;

// swing
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

// lang
import java.lang.Math.*;

/*
 * SorterPanel creates the GUI display, generates random arrays, and sorts an array with heap sort.
 */
public class SorterPanel extends JPanel implements ActionListener
{
	/** The number of elements to be placed in the array. **/
	public static int NUM_COMPARABLES = 20;
    
	/** Holds numbers to be sorted. **/
    private Integer[] sortEntireArray;
    
    /** Button pressed to generate a new array. **/
    private JButton createArray;
    
    /** Button pressed to sort the array with heap sort. **/
    private JButton sortHeap;
    
    /*
     * Constructor.
     * Initializes the array that holds the values being sorted.
     * Adds all the GUI display elements.
     */
    public SorterPanel()
    {
    	// call super
        super( new BorderLayout());
        
        // initialize the array where the values are kept
        sortEntireArray = new Integer[NUM_COMPARABLES];
        
        // add buttons and the panel where the bars are drawn
        add(menuBar(), BorderLayout.NORTH);

        add(new SorterPaint(sortEntireArray), BorderLayout.CENTER);

        add(buttons(), BorderLayout.SOUTH);
    }
    
    /**
     * Creates the button used to pick a sorting method and adds ActionListeners.
     * @return sortOptions the JPanel with sorting buttons in it
     */
    public JPanel menuBar()
    {
        JPanel sortOptions = new JPanel(new BorderLayout());
        
        // heap sort
        sortHeap = new JButton("Heap Sort");
        sortHeap.addActionListener(this);
        sortOptions.add(sortHeap, BorderLayout.CENTER);
        
        return sortOptions;
    }
    
    /**
     * Creates a button to generate new arrays.
     * @return buttonPanel the panel containing the button to generate new arrays
     */
    public JPanel buttons()
    {
        JPanel buttonPanel = new JPanel();
        
        // generate new array button
        createArray = new JButton("Get a new array");
        createArray.addActionListener(this);
        buttonPanel.add(createArray);

        return buttonPanel;
    }

    /**
     * Creates a random array on numbers between 0 and 30.
     */
    public void createTesterArray()
    {  
        for ( int i = 0; i < this.sortEntireArray.length; ++i )
        {
        	// generate a random number from 0 to 30
            Integer testNum = ((int) (Math.random()*31));
            
            // put in current odd number
            this.sortEntireArray[i] = testNum;
        }
    }
       
    /**
     * Performs different actions, depending on which button was clicked.
     * @param e ActionEvent object
     */
    public void actionPerformed( ActionEvent e )
    {
    	// get source
    	JButton chosen = (JButton)e.getSource();
    	
    	// prevents NullPointerException
    	if(sortEntireArray[0] != null)
    	{
    		// use heap sort
    		if(chosen == sortHeap)
    		{
    			// sorts the array and repaints
    			sortEntireArray = (Integer[])Sorter.heapSort(sortEntireArray);
    			repaint();
    		}
    	}
    	
        // Generates a new array      
        if(chosen == createArray)
        {
            createTesterArray();
            repaint();
        }
            
    }
                                  
}