import java.util.Vector;
/**
 * BinaryHeapA creates a minimum BinaryHeap.  Values can be inserted or deleted, and the heap will rebalance itself
 * from the methods heapify, moveUp, and moveDown.  moveUp and moveDown move lesser values up the tree and greater
 * values down the tree, respectively.  The user can also get the value of any cell in the vector.
 * @author caitlincoggins
 *
 * @param <T>
 */
public class BinaryHeapA<T extends Comparable<T>> implements BinaryHeap<T>
{
	/** Holds all values in the heap. **/
	Vector<T> holdHeap;
	
	/**
	 * Constructor.
	 * Initializes the vector.
	 */
	public BinaryHeapA()
	{
		holdHeap = new Vector<T>(0, 1);
	}
	
	/**
	 * Returns the root of the heap.
	 * @return the root's data
	 */
	public T getRoot()
	{
		return holdHeap.elementAt(1);
	}
	
	/**
	 * Inserts the specified data into the heap.
	 * @param data the data to be added to the heap
	 * @pre data is of a comparable type
	 * @post data is added to the heap
	 */
	public void insert(T data)
	{
		// if there is no root, put this data in the root
		if(holdHeap.size() == 0)
		{
			holdHeap.setSize(1);
			holdHeap.add(1, data);
		}
		
		// else, add the data and make sure the heap's rules are obeyed
		else
		{
			holdHeap.add(data);
			heapify(holdHeap.capacity()-1);
		}
	}
	
	/**
	 * Allows the user to delete any data in the heap.
	 * @param data the data to be deleted
	 * @post deletes data from the heap if it exists, if not, tells user if data is not in heap
	 */
	public void delete(T data)
	{
		if(search(data) == -1)
			System.out.println("Data is not in the heap.");
		else
			deleteNode(search(data));
	}
	
	/**
	 * Deletes data in the specified cell.
	 * @param cellNum the number of the cell
	 * @post data is deleted and heap is restructured
	 */
	public void deleteNode(int cellNum)
	{
		holdHeap.removeElementAt(cellNum);
		heapify(cellNum);
	}
	
	/**
	 * The root is set to the last element in the vector.  The last element is deleted and the heap is restructured.
	 * @pre the vector is not empty
	 * @post the root is changed to the next least value and the heap follows all min heap rules
	 */
	public void changeRoot()
	{
		setData(1, holdHeap.lastElement());
		holdHeap.removeElementAt(holdHeap.lastIndexOf(holdHeap.lastElement()));
		heapify(1);
	}
	
	/**
	 * Searches for a value in the vector.
	 * @param data the value being searched for
	 * @return the index of the value if it's there, -1 if not
	 */
	public int search(T data)
	{
		return holdHeap.indexOf(data);
	}
	
	/**
	 * Returns the data in a specific cell.
	 * @param cellNum the number of the cell
	 * @return the data in the cell
	 * @pre the cell exists
	 */
	public T getData(int cellNum)
	{
		return holdHeap.elementAt(cellNum);
	}
	
	/**
	 * Sets the data of a cell to a new value.
	 * @param cellNum the number of the cell
	 * @param data the new data 
	 * @pre the cell exists
	 */
	public void setData(int cellNum, T data)
	{
		holdHeap.set(cellNum, data);
	}
	
	/**
	 * Restructures the heap to follow its rules.
	 * @param cellNum the number of the cell that the last node was deleted from
	 */
	public void heapify(int cellNum)
	{
		// if root node
		if(cellNum == 1)
			moveDown(1);
		
		// if any other node 
		else
		{
			moveUp(cellNum);
			moveDown(cellNum);
		}
	}
	
	/**
	 * Moves the value at the cell number up in the heap until it is greater than the value above it or the root.
	 * @param cellNum the cell number of the last deleted value
	 * @post the cell specified at the beginning is in its proper spot in the heap
	 */
	public void moveUp(int cellNum)
	{
		// while the value in the current node is less than that of its parent
		while( cellNum != 1 && holdHeap.elementAt(cellNum).compareTo(holdHeap.elementAt(cellNum/2)) == -1)
		{
			// save the current cell's data
			T data = getData(cellNum);
			// change the current cell's data to that of its parent
			setData(cellNum, holdHeap.elementAt(cellNum/2));
			// set the parent's data to the current cell's saved data
			setData(cellNum/2, data);
			// increment the cell number
			cellNum = cellNum/2;
		}
	}
	
	/**
	 * Moves the value at the cell number down in the heap until it is less than the value below it or a leaf.
	 * @param cellNum the cell number of the last deleted value
	 * @post the cell specified at the beginning is in its proper spot in the heap
	 */
	public void moveDown(int cellNum)
	{
		// trims the capacity
		holdHeap.trimToSize();
		
		// while at least one child exists
		while(cellNum*2<=holdHeap.capacity() && cellNum*2+1<=holdHeap.capacity())
		{
			// cell number of left child
			int leftNum = cellNum*2;
			// cell number of right child
			int rightNum = cellNum*2+1;
		
			// if there is no right child
			if(rightNum>holdHeap.capacity()-1)
			{
				// if the value of the right child is less than that of its parent
				if(holdHeap.elementAt(cellNum).compareTo(holdHeap.elementAt(leftNum))==1)
				{
					// save the current cell's data
					T data = getData(cellNum);
					// set the current cell's data to that of its left child
					setData(cellNum, holdHeap.elementAt(leftNum));
					// set the left child's data to the current cell's saved data
					setData(leftNum, data);
					// increment cellNum
					cellNum = leftNum;
				}
				// else we're done
				else
					break;	
			}
		
			// if both children exist
			else
			{
				// if one of the children is less than its parent
				if(holdHeap.elementAt(cellNum).compareTo(holdHeap.elementAt(leftNum))==1 || holdHeap.elementAt(cellNum).compareTo(holdHeap.elementAt(rightNum))==1)
				{
					// compare the children's values
					int compare = holdHeap.elementAt(leftNum).compareTo(holdHeap.elementAt(rightNum));
				
					// if the child on the left is less than or equal to the right child
					if(compare == -1 || compare == 0)
					{
						// save the current cell's data
						T data = getData(cellNum);
						// set the current cell's data to that of its left child
						setData(cellNum, holdHeap.elementAt(leftNum));
						// set the left child's data to the current cell's saved data
						setData(leftNum, data);
						// increment cellNum
						cellNum = leftNum;
					}
				
					else
					{
						// save the current cell's data
						T data = getData(cellNum);
						// set the current cell's data to that of its right child
						setData(cellNum, holdHeap.elementAt(rightNum));
						// set the right child's data to the current cell's saved data
						setData(rightNum, data);
						// increment cellNum
						cellNum = rightNum;
					}
				}
				// else we're done
				else
					break;
			}
		}
	}
}