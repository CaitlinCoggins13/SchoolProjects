/**
 * This class implements a LinkedList.  The first and last nodes and the data from the
 * first and last nodes can be retrieved, a new node can be set to be first, in the 
 * middle, or last in the list, and any node can be deleted as well.  You can also find
 * out the size of the list, whether the list is empty, or get a String of all the
 * data stored in every node in order.
 * 
 * @author caitlincoggins
 *
 * @param <T> generic data type
 */

public class LinkedList<T>
{
	/**  Stores the first node in the list. **/
    protected DoublyLinkedListNode<T> head;

    /**
     * Get data stored in head node of list.
     * @return head.getData returns the data stored in the first node
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
     * @return head the first node in the list or null if the list is empty
     **/
    public DoublyLinkedListNode<T> getFirstNode()
    {
    	if(isEmpty())
    		return null;
        return(head);
    }
    
    /**
     * Get data stored in tail node of list.
     * @return lastNode.getData() the data in the last node of the list or null if the list is empty
     **/
    public T getLast()
    {
    	// no data to get if there is no node
    	if(!isEmpty())
    	{
    		DoublyLinkedListNode<T> lastNode = head;
        
    		while(lastNode.getNext()!= null)
    		{
    			lastNode = (DoublyLinkedListNode<T>) lastNode.getNext();
    		}
        
    		return lastNode.getData();
    	}
    	
    	return null;
    }
    
    /**
     * Get the tail node of the list.
     * @return lastNode the last node in the list or null if the list is empty
     **/
    public DoublyLinkedListNode<T> getLastNode()
    {
    	// no node if the list is empty
    	if(!isEmpty())
    	{
    		DoublyLinkedListNode<T> lastNode = head;
        
    		// loops until last node is found
    		while(lastNode.getNext() != null)
    		{
    			lastNode = (DoublyLinkedListNode<T>) lastNode.getNext();
    		}
        
    		return lastNode;
    	}
    	return null;
    }
    
    /**
     * Insert a new node with data at the head of the list.
     * @param data the data for the new node
     * @post the new node is the head of the list
     **/
    public void insertFirst( T data )
    {
    	// makes the new node the head
    	if(isEmpty())
    	{
    		head = new DoublyLinkedListNode<T>(data);
    	}
    	
    	// changes the head to the new node
    	else
    	{
    		DoublyLinkedListNode<T> oldFirst = head;
    		
    		DoublyLinkedListNode<T> newHead = new DoublyLinkedListNode<T>(data);
        
    		head = newHead;
        
    		head.setNext(oldFirst);
    	}
    }
    
    /**
     * Insert a new node with data after currentNode
     * @param currentNode the node the new node is inserted after
     * @param data the data for the new node
     * @post the new node is inserted ater whatever node was provided
     **/
    public void insertAfter( DoublyLinkedListNode<T> currentNode, T data )
    {
    	DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<T>(data);
        
    	newNode.setNext(currentNode.getNext());
        
    	currentNode.setNext(newNode);
    }
    
    /**
     * Insert a new node with data at the tail of the list.
     * @param data the data for the new node
     * @post the new node is at the end of the list
     **/
    public void insertLast( T data )
    {
    	DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<T>(data);

    	// the last node is the first node if there were no nodes
    	if(head == null )
    	{
    		head = newNode;
    	}
    	
    	else
    	{
    		DoublyLinkedListNode<T> lastNode = head;
        
    		while(lastNode.getNext() != null)
    		{
    			lastNode = lastNode.getNext();
    		}
        
    		lastNode.setNext(newNode);
    	}
    }
    
    /**
     * Remove head node
     * @post the node after the head becomes the head
     **/
    public void deleteFirst()
    {
    	DoublyLinkedListNode<T> deleteNode = head;
    		
    	head = (DoublyLinkedListNode<T>) head.getNext();
    		
    	deleteNode.setNext(null);   
    }
    
    /**
     * Remove tail node
     * @post the node before the last node is now the last node
     **/
    public void deleteLast()
    {
    	DoublyLinkedListNode<T> lastNode = head;
        
    	// finds last node
    	
    	while(lastNode.getNext().getNext() != null)
    	{
    		lastNode = lastNode.getNext();
    	}
        
    	lastNode.setNext(null);
    }
    
    /**
     * Remove node following currentNode
     * If no node exists (i.e., currentNode is the tail), do nothing
     * @param currentNode the node before the node to be deleted
     **/
    public void deleteNext( DoublyLinkedListNode<T> currentNode )
    {
        if (currentNode.getNext() != null)
        {
            currentNode.setNext(currentNode.getNext().getNext());
        }
    }
    
    /**
     * Return the number of nodes in this list.
     * @return listLength the length of the list
     **/
    public int size()
    {
        int listLength = 1;
        
        DoublyLinkedListNode<T> lastNode = head;
        
        // cycles through list
        while(lastNode.getNext() != null)
        {
            lastNode = (DoublyLinkedListNode<T>) lastNode.getNext();
            
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
     * @return listString a string containing all the data from the nodes in the list or null if the list is empty
     **/
    public String toString()
    {
    	// no data if there are no nodes
    	if(!isEmpty())
    	{
    		String listString = "";
        
    		listString = (String) head.getData();
        
    		DoublyLinkedListNode<T> lastNode = head;
        
    		// add all data in list order to the string
    		while(lastNode.getNext() != null)
    		{
    			listString = (listString + "    " + lastNode.getNext().getData());
    			lastNode = lastNode.getNext();
    		}
        
    		return listString;
    	}
    	
    	return null;
    	
    	
    	
    }
}