// DoublyLinkedListNode<T>.java
// Caitlin Coggins

/**
 * This class extends the functionality of LinkedListNode, allowing the node to 
 * be used in a doubly linked list.  The nodes can now be traversed forwards, as
 * they could be before, as well as backwards through the new methods. You can
 * now store the node previous to the current node and get that previous node to
 * be used.
 * 
 * @author caitlincoggins
 *
 * @param <T> generic data type
 */
public class DoublyLinkedListNode<T> extends LinkedListNode<T>
{
    private DoublyLinkedListNode<T> previous;
    
    /**
     * Constructor.
     * Sets data, and previous and next to null.
     * @param data the data held in the node
     */
    public DoublyLinkedListNode(T data)
    {
    	super(data);
        setPrevious(null);
    }
    
    /**
     * Get previous node.
     * @return this.previous the node previous to this node
     **/
    public DoublyLinkedListNode<T> getPrevious()
    {
        return this.previous;
    }
    
    /**
     * Set the previous pointer to passed node.
     * @param previous the new node previous to this node
     **/
    public void setPrevious( DoublyLinkedListNode<T> previous )
    {
        this.previous = previous;
    }
    
    /**
     * Override of getNext in super.
     * Returns next node after this node.
     * @return next node
     */
	public DoublyLinkedListNode<T> getNext()
    {
    	return((DoublyLinkedListNode<T>)super.getNext());
    }
}