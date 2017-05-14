import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * DefaultBinarySearchTreeTest tests methods in the DefaultBinarySearchTree class.
 * @author caitlincoggins
 *
 */
public class DefaultBinarySearchTreeTest 
{

	public static final int NUM_ELEMENTS = 500;
	private Integer[] randomArray;
	private BinarySearchTree<Integer> randomBST;

	@Before
	public void setUp() throws Exception
	{
		setupRandom();
	}

	/**
	 * Creates an array of random integers.
	 */
	private void setupRandom()
	{
		randomArray = new Integer[NUM_ELEMENTS]; // random integers
		for (int i = 0; i < randomArray.length; i++)
			randomArray[i] = new Integer((int) (Math.random() * 10000));
		
		// build BST by inserting Integers one at a time
		randomBST = new DefaultBinarySearchTree<Integer>();
		for (int i = 0; i < randomArray.length; i++)
			randomBST.insert(randomArray[i]);
	}

	/**
	 * Checks to see if the minimum value method is working.
	 */
	@Test
	public void testMinRandomBST()
	{
		// print the value returned by BST minElement() method
		System.out.println( "Min in random tree is: " + randomBST.minElement() );
		// call helper method findMin() to manually find the minimum Integer in 
		// test class array, assert equal to Integer returned by BST minElement()
		assertEquals( "Testing min in random tree", findMin(randomArray),
				randomBST.minElement() );
	}
	/**
	 * Finds the minimum value in the random value array.
	 * @param a array of random integers
	 * @return min the minimum value
	 */
	private Integer findMin( Integer[] a )
	{
		// start min at first element
		Integer min = a[0];
		
		// look through the rest of the array
		for ( int i = 1; i < a.length; i++ )
			// if found something smaller
			if ( a[i].compareTo( min ) < 0 )
				// save it
				min = a[i];

		// return result
		return min;	
	}
	
	/**
	 * This test checks to see if the inorderTraversal method is working.
	 */
	@Test
	public void testInOrderTraversal()
	{
		// sort the array
		Integer[] sortedArray = bubbleSort(randomArray);
		// create a LinkedList to hold the sorted array
		LinkedList<Integer> sortedList = new LinkedList<Integer>();
		
		// holds the node in the tree to be compared
		LinkedListNode currentNodeTree;
		// holds the node in the sorted list to be compared
		LinkedListNode currentNodeSorted;
		
		// used in assertEquals
		boolean sorted = true;
		
		// put every value in the sorted array in the sorted list
		for(int i=0; i<sortedArray.length; ++i)
		{
			sortedList.insertLast(sortedArray[i]);
		}
		
		// list 
		LinkedList treeList = randomBST.inorderTraversal();
		
		currentNodeTree = treeList.getFirstNode();
		currentNodeSorted = sortedList.getFirstNode();
		
		// compare the value in each tree node with the corresponding one in the sorted list
		while( currentNodeTree.getNext() != null)
		{
			int compare = ((Integer) currentNodeSorted.getData()).compareTo((Integer)currentNodeTree.getData());
			
			// if the two values aren't equal, end the loop
			if(compare != 0)
			{
				sorted = false;
				break;
			}
			
			// move to the next value in the list
			currentNodeTree = currentNodeTree.getNext();
			currentNodeSorted = currentNodeSorted.getNext();
		}
		
		assertEquals( "Testing if every value is the same in the sorted list and the ", true,
					sorted );
	}
	
	/**
	 * Tests the preorder method.
	 */
	@Test
	public void testPreorderTraversal()
	{
		boolean check = false;
		
		LinkedList treeList = randomBST.preorderTraversal();
		Integer middle = (Integer) treeList.getLast();
		
		// sets every value to the value after the root node
		LinkedListNode greatestLess = treeList.getFirstNode().getNext();
		LinkedListNode leastGreater = treeList.getFirstNode().getNext();
		LinkedListNode currentNode = treeList.getFirstNode().getNext();
		
		while(currentNode.getNext() != null)
		{
			// if the current node is less than the supposed root node and the value is greater than the current value in greatestLess, change greatestLess to the current node
			if((Integer)greatestLess.getData() <= (Integer)currentNode.getData() && (Integer)currentNode.getData() <= (Integer)treeList.getFirstNode().getData() )
			{
				greatestLess = currentNode;
			}
			
			// if the current node is greater than the supposed root node and the value is less than the current value in leastGreater, change leastGreater to the current node
			if((Integer)currentNode.getData() > (Integer)treeList.getFirstNode().getData() && (Integer)leastGreater.getData() < (Integer)treeList.getFirstNode().getData())
			{
				leastGreater = currentNode;
			}
			
			// if the current node is less than the current value and the current node is greater than the root node, change leastGreater to the current node
			if(((Integer) currentNode.getData()).compareTo((Integer)leastGreater.getData()) == -1 && ((Integer) currentNode.getData()).compareTo((Integer)treeList.getFirstNode().getData()) == 1 )
			{
				leastGreater = currentNode;
			}
			
			// move to the next node
			currentNode = currentNode.getNext();
		}

		// if the greatest least value is less than the root value and the root value is less than the least greatest value, the list is in order and the boolean check's value becomes true
		if((Integer)greatestLess.getData() <= (Integer)treeList.getFirstNode().getData() && (Integer)treeList.getFirstNode().getData() <= (Integer)leastGreater.getData())
		{
			check = true;
		}
		
		assertEquals("Check is true if the preorder list is in order", true, check);
		
		
	}
	
	/**
	 * Tests the postorder method.
	 */
	@Test
	public void testPostorderTraversal()
	{
		boolean check = false;
		// 
		LinkedList treeList = randomBST.postorderTraversal();
		
		// sets every value to the value after the root node
		LinkedListNode greatestLess = treeList.getFirstNode().getNext();
		LinkedListNode leastGreater = treeList.getFirstNode().getNext();
		LinkedListNode currentNode = treeList.getFirstNode().getNext();
		
		while(currentNode.getNext() != null)
		{
			// if the current node is less than the supposed root node and the value is greater than the current value in greatestLess, change the value to the current node
			if((Integer)greatestLess.getData() <= (Integer)currentNode.getData() && (Integer)currentNode.getData() <= (Integer)treeList.getLastNode().getData() )
			{
				greatestLess = currentNode;
			}
			
			// if the current node is greater than the supposed root node and the value is less than the current value in leastGreater, change the value to the current node
			if((Integer)currentNode.getData() > (Integer)treeList.getLastNode().getData() && (Integer)leastGreater.getData() < (Integer)treeList.getLastNode().getData())
			{
				leastGreater = currentNode;
			}
			
			// if the current node is less than the current value and the current node is greater than the root node, change leastGreater to the current node
			if(((Integer) currentNode.getData()).compareTo((Integer)leastGreater.getData()) == -1 && ((Integer) currentNode.getData()).compareTo((Integer)treeList.getLastNode().getData()) == 1 )
			{

				leastGreater = currentNode;
				
			}
			
			// move to the next node
			currentNode = currentNode.getNext();
		}
		
		// if the greatest least value is less than the root value and the root value is less than the least greatest value, the list is in order and the boolean check's value becomes true
		if((Integer)greatestLess.getData() <= (Integer)treeList.getLastNode().getData() && (Integer)treeList.getLastNode().getData() <= (Integer)leastGreater.getData())
		{
			check = true;
		}
		
		assertEquals("Check is true if the postorder list is in order", true, check);
		
		
	}
	
	
    /**
     * Sorts the parameter array with bubble sort.
     * @param comparable the unsorted array
     * @return comparable the sorted array
     */
    public static Integer[] bubbleSort(Comparable[] comparable)
    {
    	// assists with switching two values
        Comparable move;
        
        // counts the number of elements in order
        int inOrder = 0;
        
        // while the number of sorted elements is less than the total number of elements
        while(inOrder < comparable.length-1)
        {
            inOrder = 0;
            
            for(int i=0; i<comparable.length-1; ++i)
            {
            	// compare two consecutive elements
                int compare = comparable[i].compareTo(comparable[i+1]);
                
                // if the one to the right is less than the one one the right
                if(compare == 1)
                {
                	// switch the order of the values
                    move = comparable[i];
                    comparable[i] = comparable[i+1];
                    comparable[i+1] = move;
                }
                // if they're in order
                else
                {
                	// add one to the "in order" counter
                	++inOrder;
                }
                   
            }
            
        }
        return (Integer[]) (comparable);
    }

}
