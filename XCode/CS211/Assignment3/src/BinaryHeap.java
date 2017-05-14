
public interface BinaryHeap<T extends Comparable<T>>
{
	/**
	 * Gets the root value.
	 * @return value of array[1] if it exists
	 */
	public T getRoot();
	
	/**
	 * 
	 * @param data
	 */
	public void insert(T data);
	
	/**
	 * 
	 * @param data
	 */
	public void delete(T data);
	
	/**
	 * 
	 * @param data
	 * @return
	 */
	public int search(T data);
	
	/**
	 * Returns the value stored in a cell in the vector.
	 * @param cellNum the cell number
	 * @return the data stored in a cell
	 * @pre the called cell is not null, the cell exists
	 */
	public T getData(int cellNum);
	
	/**
	 * 
	 * @param cellNum
	 */
	public void heapify(int cellNum);
	
	/**
	 * Moves a value up the tree.
	 * @param cellNum
	 */
	public void moveUp(int cellNum);
	
	/**
	 * Moves a value down the tree.
	 * @param cellNum
	 */
	public void moveDown(int cellNum);
}