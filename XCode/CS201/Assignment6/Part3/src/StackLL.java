// Stack<LL>.java
// Caitlin Coggins

/**
 * StackLL<T> implements the Stack<T> interface.
 * @author caitlincoggins
 *
 * @param <T>
 */
public class StackLL<T> implements Stack<T>
{
	// the LinkedList all values go in
    private LinkedList<T> stackList;
    
    /**
     * Creates a new StackLL.
     */
    public StackLL()
    {
        stackList = new LinkedList<T>();
    }
    
    /**
     * Returns the data of the first node
     */
    public T peek()
    {
        return stackList.getFirst();
    }
    
    /**
     * Removes the first node.
     */
    public void pop()
    {
        stackList.deleteFirst();
    }
    
    /**
     * Creates a new first node.
     */
    public void push(T data)
    {
        stackList.insertFirst(data);
    }
    
    /**
     * Determines whether stackList is empty.
     */
    public boolean empty()
    {
        return stackList.isEmpty();
    }
}