// Queue<T>.java
// Caitlin Coggins

/**
 * QueueLL<T> implements the Queue<T> interface.
 * @author caitlincoggins
 *
 * @param <T>
 */
public class QueueLL<T> implements Queue<T>
{
    private LinkedList<T> queueList;
    
    /**
     * Constructor.
     */
    public QueueLL()
    {
        queueList = new LinkedList<T>();
    }
    
    /**
     * Returns the data in the first node.
     */
    public T peek()
    {
        return queueList.getFirst();
    }
     
    /**
     * Removes the first node.
     */
    public void dequeue()
    {
        queueList.deleteFirst();
    }
      
    /**
     * Puts new data at the end of the list.
     */
    public void enqueue(T data)
    {
        queueList.insertLast(data);
    }
    
    /**
     * Determines if a queue is empty or not.
     * Returns true if it is, false otherwise.
     */
    public boolean empty()
    {
        return queueList.isEmpty();
    }
}