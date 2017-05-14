//LinkedListNode<T>.java
// Caitlin Coggins

package cs201.coggi22c.util;

public class LinkedListNode<T>
{
    private T data;
    
    private LinkedListNode<T> next;
    
    public LinkedListNode(T data)
    {
        setData(data);
        setNext(null);
    }
    
    /**
     * Get the data stored at this node.
     **/
    public T getData()
    {
        return this.data;
    }
    
    /**
     * Set the data stored at this node.
     **/
    public void setData( T data )
    {
        this.data = data;
    }
    
    /**
     * Get (pointer to) next node.
     **/
    public LinkedListNode<T> getNext()
    {
        return this.next;
    }
    
    /**
     * Set the next pointer to passed node.
     **/
    public void setNext( LinkedListNode<T> next )
    {
        this.next = next;
    }
    
    /**
     * Returns a String representation of this node.
     **/
    public String toString()
    {
        return (String) (this.data);
    }
}