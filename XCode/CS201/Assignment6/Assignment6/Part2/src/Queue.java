// Queue<T>.java
// Caitlin Coggins

/**
 * Queue<T> is the interface for a queue.
 * @author caitlincoggins
 *
 * @param <T>
 */
public interface Queue<T>
{
	/**
     * Returns the data in the first node.
     */
    public T peek();
     
    /**
     * Removes the first node.
     */
    public void dequeue();
        
    /**
     * Puts new data at the end of the list.
     */
    public void enqueue(T data);
    
    /**
     * Determines if a queue is empty or not.
     * Returns true if it is, false otherwise.
     */
    public boolean empty();
}