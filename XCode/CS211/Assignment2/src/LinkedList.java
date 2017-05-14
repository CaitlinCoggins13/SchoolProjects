public class LinkedList<T>
{
    private LinkedListNode<T> head;

    /**
     * Get data stored in head node of list.
     **/
    public T getFirst()
    {
    	if(isEmpty())
    	{
    		return null;
    	}
        return(head.getData());
    }
    
    /**
     * Get the head node of the list.
     **/
    public LinkedListNode<T> getFirstNode()
    {
    	if(isEmpty())
    		return null;
        return(head);
    }
    
    /**
     * Get data stored in tail node of list.
     **/
    public T getLast()
    {
    	if(!isEmpty())
    	{
    		LinkedListNode<T> lastNode = head;
        
    		while(lastNode.getNext()!= null)
    		{
    			lastNode = lastNode.getNext();
    		}
        
    		return lastNode.getData();
    	}
    	
    	return null;
    }
    
    /**
     * Get the tail node of the list.
     **/
    public LinkedListNode<T> getLastNode()
    {
    	if(!isEmpty())
    	{
    		LinkedListNode<T> lastNode = head;
        
    		while(lastNode.getNext() != null)
    		{
    			lastNode = lastNode.getNext();
    		}
        
    		return lastNode;
    	}
    	return null;
    }
    
    /**
     * Insert a new node with data at the head of the list.
     **/
    public void insertFirst( T data )
    {
    	if(isEmpty())
    	{
    		head = new LinkedListNode<T>(data);
    	}
    	
    	else
    	{
    		LinkedListNode<T> oldFirst = head;
    		
    		LinkedListNode<T> newHead = new LinkedListNode<T>(data);
        
    		head = newHead;
        
    		head.setNext(oldFirst);
    	}
    }
    
    /**
     * Insert a new node with data after currentNode
     **/
    public void insertAfter( LinkedListNode<T> currentNode, T data )
    {
    	LinkedListNode<T> newNode = new LinkedListNode<T>(data);
        
    	newNode.setNext(currentNode.getNext());
        
    	currentNode.setNext(newNode);
    }
    
    /**
     * Insert a new node with data at the tail of the list.
     **/
    public void insertLast( T data )
    {
    	LinkedListNode<T> newNode = new LinkedListNode<T>(data);

    	if(head == null )
    	{
    		head = newNode;
    	}
    	
    	else
    	{
    		LinkedListNode<T> lastNode = head;
        
    		while(lastNode.getNext() != null)
    		{
    			lastNode = lastNode.getNext();
    		}
        
    		lastNode.setNext(newNode);
    	}
    }
    
    /**
     * Remove head node
     **/
    public void deleteFirst()
    {
    	LinkedListNode<T> deleteNode = head;
    		
    	head = head.getNext();
    		
    	deleteNode.setNext(null);   
    }
    
    /**
     * Remove tail node
     **/
    public void deleteLast()
    {
    	LinkedListNode<T> lastNode = head;
        
    	while(lastNode.getNext() != null)
    	{
    		lastNode = lastNode.getNext();
    	}
        
    	lastNode.setNext(null);
    }
    
    /**
     * Remove node following currentNode
     * If no node exists (i.e., currentNode is the tail), do nothing
     **/
    public void deleteNext( LinkedListNode<T> currentNode )
    {
        if (currentNode.getNext() != null)
        {
            currentNode.setNext(currentNode.getNext().getNext());
        }
    }
    
    /**
     * Return the number of nodes in this list.
     **/
    public int size()
    {
        int listLength = 1;
        
        LinkedListNode<T> lastNode = head;
        
        while(lastNode.getNext() != null)
        {
            lastNode = lastNode.getNext();
            
            ++listLength;
        }
        
        return listLength;
    }
    
    /**
     * Check if list is empty.
     * @return true if list contains no items.
     **/
    public boolean isEmpty()
    {
        if(head == null)
        {
            return true;
        }
        
            return false;
    }
    
    /**
     * Return a String representation of the list.
     **/
    public String toString()
    {
    	if(!isEmpty())
    	{
    		String listString = "";
        
    		listString = (Integer.toString((Integer)head.getData()));
        
    		LinkedListNode<T> lastNode = head;
        
    		while(lastNode.getNext() != null)
    		{
    			listString = (listString + " => " + Integer.toString((Integer)lastNode.getNext().getData()));
    			lastNode = lastNode.getNext();
    		}
        
    		return listString;
    	}
    	
    	return null;
    	
    	
    	
    }
}