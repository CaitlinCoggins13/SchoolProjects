// Stack<LL>.java
// Caitlin Coggins

public class StackLL<T> implements Stack<T>
{
    private LinkedList<T> stackList;
    
    public StackLL<T>()
    {
        stackList = new LinkedList<T>();
    }
    
    public T peek()
    {
        return stackList.getFirst();
    }
    
    public void pop()
    {
        stackList.deleteLast();
    }
    
    public void push(T data)
    {
        stackList.insertLast(data);
    }
    
    public boolean empty()
    {
        return stackList.isEmpty();
    }
}