/**
 * DefaultBinarySearchTree extends DefaultBinaryTree by adding methods to insert a value, 
 * search for a value, and find the minimum and maximum element.
 * @author caitlincoggins
 *
 * @param <T>
 */
public class DefaultBinarySearchTree<T extends Comparable<T>> extends DefaultBinaryTree<T> implements BinarySearchTree<T>
{
	/**
	 * Constructor.
	 * Calls super.
	 */
    public DefaultBinarySearchTree()
    {
        super();    
    }

    /**
     * Insert the data into the tree, maintaining the
     * search tree invariant.
     * @param data the data of the new node
     **/
    public void insert( T data )
    {
    	// if there is no root node, set the node to be the root
        if( empty() )
        {
        	BinaryTreeNode<T> newRoot = new DefaultBinaryTreeNode<T>( data );
        	setRoot( newRoot );
        }
        
        // compare the new data value to the root
        else
        {
        	// start a loop to find where the node will go
        	insertLeaf( root, data );
        }
    }
    
    /**
     * Finds the place where the new node goes and inserts it.
     * @param currentNode the current node that is being compared to
     * @param data the data of the new node
     */
    private void insertLeaf( BinaryTreeNode<T> currentNode, T data )
    {
    	// compares the new node's data and the current node's data
    	int compare = currentNode.getData().compareTo(data);
    	
    	// if there is no left node and the new node would go on the left
    	if(currentNode.getLeftChild() == null && compare == 1)
    	{
    		// set the new node to be the left node of the current node
    		BinaryTreeNode<T> newLeaf = new DefaultBinaryTreeNode<T>( data );
        	currentNode.setLeftChild( newLeaf );
    	}
    	
    	// if there is no right node and the new node would go on the right
    	else if( currentNode.getRightChild() == null && (compare == -1 || compare ==0 ))
    	{
    		// set the new node to be the right node of the current node
    		BinaryTreeNode<T> newLeaf = new DefaultBinaryTreeNode<T>( data );
        	currentNode.setRightChild( newLeaf );
    	}
    	
    	// if the current node is not a leaf
    	else
        {
    		// if the new node would have been a left node
        	if( compare == 1 && currentNode.getLeftChild() != null )
        		// check the next node
                insertLeaf( currentNode.getLeftChild(), data );

        	// if the new node would have been a right node
        	else if( currentNode.getRightChild() != null )
        		// check the next node
            	insertLeaf( currentNode.getRightChild(), data );
        }
    }
        
    /**
     * Search for data in the tree, finding the node
     * containing it, or null if the data is not present
     * in the tree.
     * @return the node containing data or null if none exists.
     **/
    public BinaryTreeNode<T> search( T data )
    {
    	// if there is no root node, return null
        if( empty() )
            return null;
        
        // compare the new data and the root's data
        int compare = this.root.getData().compareTo(data);
        
        // if the node should be on the left
        if( compare == 1 && root.getLeftChild() != null )
        	// search for and return the node
            return search( this.root.getLeftChild(), data );

        // if the node should be on the right side of the tree
        if( root.getRightChild() != null )
        	// search for and return the node
        	return search( this.root.getRightChild(), data );
        
        // if none of these situations apply, return null
        return null;
    }

    /**
     * 
     * @param compareNode
     * @param data
     * @return
     */
    public BinaryTreeNode<T> search( BinaryTreeNode<T> compareNode, T data )
    {
    	// compare the node's data and the new data
    	int compare = compareNode.getData().compareTo(data);
    	
        // if the node is a leaf and there is no match, a node with that value does not exist, return null
        if( compareNode.isLeaf() && compare != 0)
            return null;

        // if the data matches the node's data, return the node
        if( compare == 0 )
            return compareNode;

        // if the data is less than the node's data, check the left branch node
        if( compare == 1 && root.getLeftChild() != null )
            return search( compareNode.getLeftChild(), data );

        // if the data is greater than the node's data, check the right branch node
        if( compare == -1 && root.getRightChild() != null )
        	return search( compareNode.getRightChild(), data );
        
        // if no cases apply, return null
        return null;
    }

    /**
     * Find the minimum element in the tree.
     * @return the minimum data
     */
    public T minElement()
    {
    	// if there is no root, return null
        if( empty() )
            return null;
        
        // finds the minimum element
        BinaryTreeNode<T> least = minElementFind( this.root );

        // return the minimum data
        return least.getData();
    }

    /**
     * Finds the node with the minimum data.
     * @param currentNode the current node being checked
     * @return the node with the minimum data
     */
    private BinaryTreeNode<T> minElementFind( BinaryTreeNode<T> currentNode)
    {
    	// if the node is the furthest left leaf, return it
        if( currentNode.getLeftChild() == null )
            return currentNode;

        // try the next node to the left
        return minElementFind( currentNode.getLeftChild() );
    }

    /**
     * Find the maximum element in the tree.
     * @return the maximum element
     */
    public T maxElement()
    {
    	// if there is no root, return null
        if( empty() )
            return null;

        // finds the maximum element
        BinaryTreeNode<T> greatest = maxElementFind( this.root );

        // return the maximum data
        return greatest.getData();
    }

    /**
     * Finds the node with maximum data.
     * @param currentNode 
     * @return the node with the maximum element as data
     */
    private BinaryTreeNode<T> maxElementFind( BinaryTreeNode<T> currentNode)
    {
    	// if the node is the furthest right leaf, return it
        if( currentNode.getRightChild() == null )
            return currentNode;

        // try the next node to the right
        return maxElementFind( currentNode.getRightChild() );   
    }
}