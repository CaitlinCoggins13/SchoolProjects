/**
 * This class extends the functionality of LinkedList, allowing doubly linked lists
 * to be created and used.  There is one new method that allows a backwards traversal
 * of the list.  All other methods are overriding methods in LinkedList to allow
 * nodes to link to the previous node.
 * 
 * @author caitlincoggins
 *
 * @param <T> generic data type
 */

public class DoublyLinkedList<T> extends LinkedList<T>
{
	/**
	 * Empty constructor.
	 * LinkedList does not initialize anything.
	 */
	public DoublyLinkedList()
	{
		super();
	}
    
	/**
     * Insert a new node with data at the head of the list.
     * @param data the data for the new node
     * @post the new node is the head of the list
     **/
    public void insertFirst( T data )
    {
    	// sets head if there isn't one already
    	if(isEmpty())
    	{
    		head = new DoublyLinkedListNode<T>(data);
    	}
    	// sets new head
    	else
    	{
    		DoublyLinkedListNode<T> oldFirst = (DoublyLinkedListNode<T>) head;
    		
    		DoublyLinkedListNode<T> newHead = new DoublyLinkedListNode<T>(data);
        
    		head = newHead;
        
    		head.setNext(oldFirst);
            
            oldFirst.setPrevious((DoublyLinkedListNode<T>)head);
    	}
    }
    
    /**
     * Insert a new node with data after currentNode
     * @param currentNode the node the new node is inserted after
     * @param data the data for the new node
     * @post the new node is inserted after whatever node was provided
     **/
    public void insertAfter( DoublyLinkedListNode<T> currentNode, T data )
    {
    	DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<T>(data);

        newNode.setPrevious(currentNode);
        
        newNode.setNext(currentNode.getNext());
        
        currentNode.getNext().setPrevious(newNode);
        
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

    	// if there is no head, the last node is the first node
    	if(head == null )
    	{
    		head = newNode;
    	}
    	
    	// find the end of the list and add the new node
    	else
    	{
    		DoublyLinkedListNode<T> lastNode = (DoublyLinkedListNode<T>)head;
        
    		while(lastNode.getNext() != null)
    		{
    			lastNode = (DoublyLinkedListNode<T>)lastNode.getNext();
    		}
        
    		lastNode.setNext(newNode);
            
            newNode.setPrevious(lastNode);
    	}
    }
    
    /**
     * Remove head node
     * @post the node after the head becomes the head
     **/
    public void deleteFirst()
    {
    	// if the first node is the only node
    	if(size() == 1)
    		head = (DoublyLinkedListNode<T>) head.getNext();
    	
    	// if there's more than one node
    	else
    	{
    		head = (DoublyLinkedListNode<T>) head.getNext();
    		((DoublyLinkedListNode<T>) head).setPrevious(null);
    	}
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
        	// sets next of the current node and previous of the node after the one being deleted
        	if(currentNode.getNext().getNext() != null)
        	{
        		currentNode.setNext(currentNode.getNext().getNext());
        		currentNode.getNext().getNext().setPrevious(currentNode);
        	} 
        	
        	// if there is no node after the one being deleted, this is only deleting the last node, so there's 
        	//no node after the deleted node that needs previous linked
        	else
        	{
        		currentNode.setNext(null);
        	}
        }
    }
    
    /**
     * Returns all the data from every node in the list in the reverse order from their order in the list
     * @return reverseList a list of the data in every node backwards
     */
    public String toStringReversed()
    {
    	DoublyLinkedListNode<T> lastNode = head;
        
    	// reaches last node in the list
		while(lastNode.getNext() != null)
		{
			lastNode = lastNode.getNext();
		}
		
		String reverseList = (String) lastNode.getData();
		
		// adds the data in each node in reverse to the string
		while(lastNode.getPrevious() != null)
		{
			reverseList = (reverseList + "    " + lastNode.getPrevious().getData());
			lastNode = lastNode.getPrevious();
		}
		
		return reverseList;
    }
}