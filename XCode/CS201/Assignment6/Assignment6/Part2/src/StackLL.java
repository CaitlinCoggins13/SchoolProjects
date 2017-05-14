// Stack<LL>.java
// Caitlin Coggins

public class StackLL<T> implements Stack<T>
{
    private LinkedList<T> stackList;
    
    public StackLL()
    {
        stackList = new LinkedList<T>();
    }
    
    public T peek()
    {
        return stackList.getFirst();
    }
    
    public void pop()
    {
        stackList.deleteFirst();
    }
    
    public void push(T data)
    {
        stackList.insertFirst(data);
    }
    
    public boolean empty()
    {
        return stackList.isEmpty();
    }
}