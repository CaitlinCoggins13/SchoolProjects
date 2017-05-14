/**
 * RedBlackTree creates a BinarySearchTree that maintains certain properties.  It must have
 * a black root, every node must be red or black, a red node must have two black nodes as children,
 * and every path to a leaf must contain the same number of black nodes.  After inserting,
 * the tree goes to the method fixClashes() to restructure if necessary.
 * @author caitlincoggins
 *
 * @param <T>
 */

public class RedBlackTree<T extends Comparable<T>> extends DefaultBinarySearchTree<T> implements BinarySearchTree<T>
{
	/** Holds the root node of the tree. **/
	RedBlackTreeNode<T> root;
	
	/**
	 * Fixes all red-red clashes in the tree with six cases of color changes and/or rotations.
	 * @param newNode
	 * @pre the tree, with the exception of the clash created by inserting the new node, follows all red black rules
	 * @post the entire tree follows red black rules
	 */
	public void fixClashes(RedBlackTreeNode newNode)
	{
		// while the node being checked is no the root and a clash still exists
		while(newNode != root && newNode.getParent().getIsRed() == true)
		{
			// if newNode's parent is a left child
			if(newNode.getParent() == newNode.getParent().getParent().getLeftChild())
			{
				// the uncle node is the right child
				RedBlackTreeNode uncleNode = newNode.getParent().getParent().getRightChild();
				// if the uncle is null, it is a black node
				if(uncleNode != null && uncleNode.getIsRed())
				{
					// newNode's parent and uncle become black and its grandfather becomes red
					newNode.getParent().setIsRed(false);
					newNode.getParent().getParent().setIsRed(true);
					uncleNode.setIsRed(false);
						
					// newNode is set to its grandfather to check for red-red clashes
					newNode = newNode.getParent().getParent();
				}
				
				// if the uncle is black
				else
				{
					// if newNode is a right child, we know newNode's parent is a left child, Case 3 
					if(newNode == newNode.getParent().getRightChild())
					{
						// rotate from the parent
						newNode = newNode.getParent();
						leftRotate(newNode);
					}
					// Case 2
					// set parent to black and grandparent to red, then rotate right from the grandparent
					newNode.getParent().setIsRed(false);
					newNode.getParent().getParent().setIsRed(true);
					rightRotate(newNode.getParent().getParent());
				}
				
				// set root to black
				root.setIsRed(false);
			}
			
			// if newNode's parent is a right child, all references to left and right are switched from what they
			// were in the previous section
			else
			{
				// the uncle node is the left child
				RedBlackTreeNode uncleNode = newNode.getParent().getParent().getLeftChild();
				
				// if the uncle is null, it is a black node
				if(uncleNode != null && uncleNode.getIsRed())
				{
					// newNode's parent and uncle become black and its grandfather becomes red
					newNode.getParent().setIsRed(false);
					newNode.getParent().getParent().setIsRed(true);
					uncleNode.setIsRed(false);
						
					// newNode is set to its grandfather to check for red-red clashes
					newNode = newNode.getParent().getParent();
					
				}
				
				// if the uncle is black
				else
				{
					// if newNode is a left child, we know newNode's parent is a right child, Case 3 
					if(newNode == newNode.getParent().getLeftChild())
					{
						// rotate from the parent
						newNode = newNode.getParent();
						rightRotate(newNode);
					}
					// Case 2
					// set parent to black and grandparent to red, then rotate left from the grandparent
					newNode.getParent().setIsRed(false);
					newNode.getParent().getParent().setIsRed(true);
					leftRotate(newNode.getParent().getParent());
				}
				// set root to black
				root.setIsRed(false);
			}	
		}
	}
	
	/**
	 * Moves the passed node to be the left child of its current right child
	 * @param moveNode the root of this section of the tree
	 * @pre passed node has a right node
	 * @post passed node is the left child of what was its right child
	 */
	public void leftRotate(RedBlackTreeNode moveNode)
	{
		// hold node that will become the root of this section of the tree
		RedBlackTreeNode rightNode = moveNode.getRightChild();
		
		// sets right child of moveNode to the left child of the right child of moveNode
		moveNode.setRightChild(rightNode.getLeftChild());
		
		// if rightNode has a left child, set its parent to be moveNode
		if(rightNode.getLeftChild()!=null)
		{
			rightNode.getLeftChild().setParent(moveNode);
		}
		
		// set the rightNode's parent to be moveNode's parent
		rightNode.setParent(moveNode.getParent());
		
		// if moveNode was the root, rightNode is now the root
		if(moveNode.getParent() == null)
			root = rightNode;
		
		// if moveNode was a left child, leftNode is moveNode's parent's new left child
		else if(moveNode == moveNode.getParent().getLeftChild())
			moveNode.getParent().setLeftChild(rightNode);
		
		// if moveNode was a right child, leftNode is moveNode's parent's new right child
		else
			moveNode.getParent().setRightChild(rightNode);
		
		// moveNode becomes the right child of leftNode
		rightNode.setLeftChild(moveNode);
		moveNode.setParent(rightNode);	
	}
	
	/**
	 * Moves the passed node to be the right child of its current left child
	 * @param moveNode the root of this section of the tree
	 * @pre passed node has a left node
	 * @post passed node is the right child of what was its left child
	 */
	public void rightRotate(RedBlackTreeNode moveNode)
	{
		// hold node that will become the root of this section of the tree
		RedBlackTreeNode leftNode = moveNode.getLeftChild();
		
		// sets left child of the current node to the right child of the left child of the current node
		moveNode.setLeftChild(leftNode.getRightChild());
		
		// if leftNode has a right child, set its parent to be moveNode
		if(leftNode.getRightChild()!=null)
		{
			leftNode.getRightChild().setParent(moveNode);
		}
		
		// set the leftNode's parent to be moveNode's parent
		leftNode.setParent(moveNode.getParent());
		
		// if moveNode was the root, leftNode is now the root
		if(moveNode.getParent() == null)
			root = leftNode;
		
		// if moveNode was a right child, leftNode is moveNode's parent's new right child
		else if(moveNode == moveNode.getParent().getRightChild())
			moveNode.getParent().setRightChild(leftNode);
		
		// if moveNode was a left child, leftNode is moveNode's parent's new left child
		else
			moveNode.getParent().setLeftChild(leftNode);
		
		// moveNode becomes the right child of leftNode
		leftNode.setRightChild(moveNode);
		moveNode.setParent(leftNode);	
	}
	
	/**
     * Insert the data into the tree, maintaining the
     * search tree invariant.
     * @param data the data of the new node
     * @post the data is inserted into the tree
     **/
	
    public void insert( T data )
    {
    	RedBlackTreeNode newRoot;
    	
    	// if there is no root node, set the node to be the root
        if( getRoot() == null )
        {
        	newRoot = new RedBlackTreeNode<T>( data );
        	this.root = newRoot;
        	root.setIsRed(false);
        }
        
        // compare the new data value to the root
        else
        {
        	// start a loop to find where the node will go
        	newRoot = insertLeaf( root, data );
        }
        
        fixClashes(newRoot);
    }
    
    /**
     * Finds the place where the new node goes and inserts it.
     * @param currentNode the current node that is being compared to
     * @param data the data of the new node
     */
    private RedBlackTreeNode insertLeaf( RedBlackTreeNode<T> currentNode, T data )
    {
    	// compares the new node's data and the current node's data
    	int compare = currentNode.getData().compareTo(data);
    	
    	// if there is no left node and the new node would go on the left
    	if(currentNode.getLeftChild() == null && compare == 1)
    	{
    		// set the new node to be the left node of the current node
    		RedBlackTreeNode<T> newLeaf = new RedBlackTreeNode<T>( data );
    		newLeaf.setParent(currentNode);
        	currentNode.setLeftChild( newLeaf );
        	return(newLeaf);
    	}
    	
    	// if there is no right node and the new node would go on the right
    	else if( currentNode.getRightChild() == null && (compare == -1 || compare ==0 ))
    	{
    		// set the new node to be the right node of the current node
    		RedBlackTreeNode<T> newLeaf = new RedBlackTreeNode<T>( data );
    		newLeaf.setParent(currentNode);
        	currentNode.setRightChild( newLeaf );
        	return(newLeaf);
    	}
    	
    	// if the current node is not a leaf
    	else
        {
    		// if the new node would have been a left node
        	if( compare == 1 && currentNode.getLeftChild() != null )
        		// check the next node
                return insertLeaf( currentNode.getLeftChild(), data );

        	// if the new node would have been a right node
        	else if( currentNode.getRightChild() != null )
        		// check the next node
            	return insertLeaf( currentNode.getRightChild(), data );
        }
    	
    	return null;
    }
    
    /**
     * Returns the root node.
     * @return the root of the tree
     */
    public RedBlackTreeNode getRoot()
    {
    	return root;
    }
    
    /**
     * Search for data in the tree, finding the node
     * containing it, or null if the data is not present
     * in the tree.
     * @param data the data for the new node
     * @return the node containing data or null if none exists.
     * @pre tree is a viable BinarySearchTree
     * @post returns node if found, returns null if not
     **/
    public RedBlackTreeNode<T> search( T data )
    {
    	// if there is no root node, return null
        if( root == null )
        {
        	System.out.println("wrong");
        }
            
        
        // compare the new data and the root's data
        int compare = this.root.getData().compareTo(data);
        
        if(compare == 0)
        	return root;
        
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
     * Finds the spot where the data should be, returns the node with that data if it exists.
     * @param compareNode the node whose data will be compared with
     * @param data the data of the new node
     * @return compareNode if it has the same data as data, null if the data is not in this tree
     */
    public RedBlackTreeNode<T> search( RedBlackTreeNode<T> compareNode, T data )
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
        if( compare == 1 && compareNode.getLeftChild() != null )
            return search( compareNode.getLeftChild(), data );

        // if the data is greater than the node's data, check the right branch node
        if( compare == -1 && compareNode.getRightChild() != null )
        	return search( compareNode.getRightChild(), data );
        
        // if no cases apply, return null
        return null;
    }
    
    /**
     * Checks to make sure every node placement in the tree still follows the rules of a red black tree.
     * @post know if tree is viable
     */
    public void validate()
    {
    	if(root.getIsRed())
    		System.out.println("ROOT IS RED");
    	validateTree(root, 0, 0);
    }
    
    /**
     * Checks that red nodes have only black roots and that there are the same number of black nodes on all paths.
     * @param currentNode the node being looked at
     * @param currentPathBlack the number of black nodes encountered on this path
     * @param totalPathBlack the total number of nodes that should be encountered on a path
     * @return totalPathBlack to make sure the number stays updated
     */
    public int validateTree(RedBlackTreeNode currentNode, int currentPathBlack, int totalPathBlack)
    {
    	if(currentNode == null)
    	{
    		// if no path number has been set, set it
    		if(totalPathBlack == 0)
    		{
    			totalPathBlack = currentPathBlack;
    		}
    		// else, compare current path number with old path number, should be the same
    		else
    		{
    			if(currentPathBlack != totalPathBlack)
    			{
    				System.out.println("WRONG NUMBER OF BLACK NODES");
    			}
    		}
    		
    		return totalPathBlack;
    	}
    	
    	// check that both children are black
    	else if( currentNode.getIsRed() )
    	{
    		if(currentNode.getLeftChild()!=null)
    		{
    			if(currentNode.getLeftChild().getIsRed())
    			{
    				System.out.println("RED-RED CLASH");
    			}
    		}
    		
    		if(currentNode.getRightChild()!=null)
    		{
    			if(currentNode.getRightChild().getIsRed())
    			{
    				System.out.println("RED-RED CLASH");
    			}
    		}
    	}
    	
    	// node is black, one more black node on the path
    	else
    	{
    		++currentPathBlack;
    	}
    	
    	//continue along left and right paths
    	totalPathBlack = validateTree(currentNode.getLeftChild(), currentPathBlack, totalPathBlack);
    	totalPathBlack = validateTree(currentNode.getRightChild(), currentPathBlack, totalPathBlack);
    	return totalPathBlack;
    }
}