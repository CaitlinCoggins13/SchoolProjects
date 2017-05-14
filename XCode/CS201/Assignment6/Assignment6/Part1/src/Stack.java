// Stack<T>.java
// Caitlin Coggins

/**
 * Stack<T> is an interface that will create a stack when implemented.
 * @author caitlincoggins
 *
 * @param <T>
 */
public interface Stack<T>
{
	/**
     * Returns the data of the first node
     */
    public T peek();
    
    /**
     * Removes the first node.
     */
    public void pop();
    
    /**
     * Creates a new first node.
     */
    public void push(T data);
    
    /**
     * Determines whether stackList is empty.
     */
    public boolean empty();
}