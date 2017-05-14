public class DefaultBinaryTreeNode<T> implements BinaryTreeNode<T>
{
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;
	T data;
	
	public DefaultBinaryTreeNode( T data )
	{
		this.data = data;
	}
	
	/**
	   * Get the data stored at this node.
	   * @return Object data.
	   **/
	  public T getData()
	  {
		  if(data == null)
		  {
			  return null;
		  }
		  
		  return data;
	  }

	  /**
	   * Get the left child.
	   * @return BinaryTreeNode that is left child,
	   * or null if no child.
	   **/
	  public BinaryTreeNode<T> getLeftChild()
	  {
		  if(left == null)
			  return null;
		  
		  return left;
	  }

	  /**
	   * Get the right child.
	   * @return BinaryTreeNode that is right child,
	   * or null if no child.
	   **/
	  public BinaryTreeNode<T> getRightChild()
	  {
		  if(right == null)
			  return null;
		  
		  return right;
	  }

	  
	  /**
	   * Set the left child.
	   **/
	  public void setLeftChild( BinaryTreeNode<T> left )
	  {
		  this.left = left;
	  }

	  /**
	   * Set the right child.
	   **/
	  public void setRightChild( BinaryTreeNode<T> right )
	  {
		  this.right = right;
	  }

	  /**
	   * Tests if this node is a leaf (has no children).
	   * @return true if leaf node.
	   **/
	  public boolean isLeaf()
	  {
		  if(left == null && right == null)
			  return true;
		  
		  return false;
	  }
}