/**
 * RedBlackTreeNode extends the function of a BinaryTreeNode by adding a way to keep track of 
 * the node's parent and adding a boolean value that says whether this is a red or black
 * node.  This is used by the RedBlackTree class to restructure the tree.
 * @author caitlincoggins
 *
 * @param <T>
 */

public class RedBlackTreeNode<T> extends DefaultBinaryTreeNode<T> implements BinaryTreeNode<T>
{
	/** Holds parent of node. **/
	RedBlackTreeNode<T> parent;
	
	/** Tells whether or not this node is red. **/
	boolean isRed;
	
	/**
	 * Constructor.
	 * Calls super.
	 * Sets isRed to true.
	 * @param data
	 */
	public RedBlackTreeNode(T data) 
	{
		super(data);
		isRed = true;
	}
	
	/**
	 * Sets parent of this node.
	 * @param parent the parent of this node
	 */
	public void setParent(RedBlackTreeNode<T> parent)
	{
		this.parent = parent;
	}
	
	/**
	 * Gets parent of this node.  If there is no parent, null is returned.
	 * @return parent if it exists, null if not
	 */
	public RedBlackTreeNode<T> getParent()
	{
		if(parent == null)
			return null;
		return parent;
	}
	
	/**
	 * Sets the value of isRed.
	 * @param isRed the new value of isRed
	 */
	public void setIsRed(boolean isRed)
	{
		this.isRed = isRed;
	}
	
	/**
	 * Returns the value of isRed.
	 * @return true if red, false if black.
	 */
	public boolean getIsRed()
	{
		return isRed;
	}
	
	/**
	 * Returns the left child node of this node.  If there is no left child, return null.
	 * @return left if it exists, null if not.
	 */
	public RedBlackTreeNode<T> getLeftChild()
	{
		 if(left == null)
			  return null;
		  
		 return (RedBlackTreeNode<T>) left;
	}
	
	/**
	 * Returns the right child node of this node.  If there is no right child, return null.
	 * @return right if it exists, null if not.
	 */
	public RedBlackTreeNode<T> getRightChild()
	{
		 if(right == null)
			  return null;
		  
		 return (RedBlackTreeNode<T>) right;
	}
	
	
}