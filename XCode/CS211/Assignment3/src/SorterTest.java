import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the heap sort method.
 * @author caitlincoggins
 *
 */
public class SorterTest 
{
	/** default number of Comparables to test on **/
    public static int NUM_COMPARABLES = 20;
    
    /** testing array **/
    private Comparable[] comparables;
    
    /**
     * Initializes the testing array.
     */
    @Before
    public void initTesterArray()
    {
        comparables = createTesterArray( NUM_COMPARABLES );
    }
    
    /**
     * Create array with random Integers between 0 and 30.
     **/
    public static Comparable[] createTesterArray( int numComparables )
    {
        // array for randomized values in order
        Comparable<Integer>[] newComparables = new Comparable[numComparables];
        
        for ( int i = 0; i < newComparables.length; i++ )
        {
        	// generate value between 0 and 30
            Integer testLetter = ((int) (Math.random()*31));
            // put in current number
            newComparables[i] = testLetter;
        }
        
        return newComparables;
    }

	@Test
	/**
	 * Makes sure heap sort has sorted all inputted values.
	 */
	public void testHeapSort() 
	{
		boolean run = true;
    	
    	Comparable[] sorted = Sorter.heapSort(comparables);
    	
    	// Run through array, make sure each value is in order
    	for(int i = 0; i<sorted.length-1; ++i)
    	{	
    		// if a value is out of order, the sort failed
    		if(sorted[i].compareTo(sorted[i+1]) == 1)
    		{
    			run = false;
    			break;
    		}
    	}
    
        // check that all values were in order
        assertEquals("Searching for no greater numbers to the left of lesser numbers should give true", 
                     true, // correct answer
                     run);

	}

}
