/**
 * TestRunTimes calculates the runtimes for a RedBlackTree and a BinarySearchTree when given
 * ramdom and sorted data sets.  The results are printed.
 * @author caitlincoggins
 *
 */

public class TestRunTimes
{
	/**
	 * Generates the data sets and starts the tests.
	 * @param args
	 */
	public static void main(String[] args)
	{
		int numValues = 2;	// current number of values
		int holdValues[];	// holds the data set
		
		System.out.println("Random Sequence");
		
		// keeps data sets small enough
		while(numValues<100000)
		{
			// generates the random data set
			holdValues = generateRandomSequence(numValues);
			// starts tests
			testTime(holdValues, numValues);
			// increments number of values
			numValues*=5;
		}
		
		System.out.println("In Order Sequence");
		
		// reset the value
		numValues = 2;
		
		while(numValues<100000)
		{
			// generates the sorted data set
			holdValues = generateInOrderSequence(numValues);
			// starts tests
			testTime(holdValues, numValues);
			// increments number of values
			numValues*=5;
		}
		
	}

	/**
	 * Calculates insertion time and search time for a RedBlackTree and a BinarySearchTree.
	 * @param newInts the data set
	 * @param value the number of integers in the data set
	 */
	public static void testTime(int[] newInts, int value)
	{
		long redBlackInsertTime = 0;			// holds insert time for RBT
		long binarySearchTreeInsertTime = 0;	// holds insert time for BST
		long redBlackSearchTime = 0;			// holds search time for RBT
		long binarySearchTreeSearchTime = 0;	// holds search time for BST
		int numValues = value;					// holds number of values
		int[] holdValues = newInts;				// holds data set
		
		RedBlackTree rbTimeTest = new RedBlackTree();
		DefaultBinarySearchTree dbstTimeTest = new DefaultBinarySearchTree();
			
		System.out.println("Number of Values: " + numValues);
			
		// start time for operation
		long startRBInsert = System.currentTimeMillis();
			
		// inserts every number in the data set into the RedBlackTree
		for(int i = 0; i < numValues; ++i)
		{
			rbTimeTest.insert(holdValues[i]);
		}
			
		// calculates span of time operation took
		redBlackInsertTime = System.currentTimeMillis() - startRBInsert;
		
		System.out.println("RB Insert Time: " + redBlackInsertTime);
			
		// start time for operation
		long startBSTInsert = System.currentTimeMillis();
			
		// inserts every number in the data set into the BinarySearchTree
		for(int i = 0; i < numValues; ++i)
		{
			dbstTimeTest.insert(holdValues[i]);
		}
			
		// calculates span of time operation took
		binarySearchTreeInsertTime = System.currentTimeMillis() - startBSTInsert;
			
		System.out.println("BST Insert Time: " + binarySearchTreeInsertTime);
			
		// start time for operation
		long startRBSearch = System.currentTimeMillis();
		
		// searches for one value in the RedBlackTree
		rbTimeTest.search(holdValues[numValues-1]);
		
		// calculates span of time operation took
		redBlackSearchTime = System.currentTimeMillis() - startRBSearch;

		System.out.println("RB Search Time: " + redBlackSearchTime);

		// start time for operation
		long startBSTSearch = System.currentTimeMillis();
				
		// searches for one value in the BinarySearchTree
		dbstTimeTest.search(holdValues[numValues-1]);
		
		// calculates span of time operation took
		binarySearchTreeSearchTime = System.currentTimeMillis() - startBSTSearch;
			
		System.out.println("BST Search Time: " + binarySearchTreeSearchTime);
			
	}
	
	/**
	 * Generates a randomized data set with numValues integers.
	 * @param numValues the number of integers in the data set
	 * @return randValues the random data set
	 */
	public static int[] generateRandomSequence(int numValues)
	{
		// creates array with specified number of values
		int[] randValues = new int[numValues];
		
		// puts random numbers from 0 to 999 in the array
		for(int i = 0; i<numValues; ++i)
		{
			randValues[i] = (int)(Math.random()*1000);
		}
		
		return randValues;
	}
	
	/**
	 * Generates an ordered data set with numValues integers.
	 * @param numValues the number of integers in the data set
	 * @return orderedValues the sorted data set
	 */
	public static int[] generateInOrderSequence(int numValues)
	{
		// creates array with specified number of values
		int[] orderedValues = new int[numValues];
		
		// puts integers 0-(numValues-1) in the array
		for(int i = 0; i<numValues; ++i)
		{
			orderedValues[i] = i;
		}
		
		return orderedValues;
	}
}