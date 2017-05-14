/**
 * 
 * @author caitlincoggins
 *
 * @param <T>
 */

public class DefaultBinaryTree<T> implements BinaryTree<T>
{
	/** Holds the root node. **/
	BinaryTreeNode<T> root;

	/**
	 * Get the root node for this tree.
	 * 
	 * @return root or null if tree is empty.
	 **/
	public BinaryTreeNode<T> getRoot()
	{
		if(root == null)
			return null;
		
		return root;
	}

	/**
	 * Set the root node for this tree.
	 **/
	public void setRoot(BinaryTreeNode<T> root)
	{
		this.root = root;
	}

	/**
	 * Test if the tree is empty.
	 * 
	 * @return true if tree has no data.
	 **/
	public boolean empty()
	{
		if(root == null)
			return true;
		
		return false;
	}

	/**
	 * Get the data of this tree using inorder traversal.
	 * 
	 * @return inorder List.
	 **/
	public LinkedList<T> inorderTraversal()
	{
		LinkedList<T> inOrder = new LinkedList<T>();
		
		inOrderTraversalFind(root.getLeftChild(), inOrder);
		
		inOrder.insertLast(root.getData());
		
		inOrderTraversalFind(root.getRightChild(), inOrder);
		
		return inOrder;
	}
	
	/**
	 * 
	 * @param currentNode
	 * @param currentList
	 */
	private void inOrderTraversalFind( BinaryTreeNode<T> currentNode, LinkedList<T> currentList )
	{
		if( currentNode.isLeaf() )
			currentList.insertLast(currentNode.getData());
		
		else
		{
			if(currentNode.getLeftChild() != null )
				inOrderTraversalFind(currentNode.getLeftChild(), currentList);
		
			currentList.insertLast(currentNode.getData());
		
			if(currentNode.getRightChild() != null )
				inOrderTraversalFind(currentNode.getRightChild(), currentList);
		}
	}

	/**
	 * Get the data of this tree using preorder traversal.
	 * 
	 * @return preorder List.
	 **/
	public LinkedList<T> preorderTraversal()
	{
		LinkedList<T> preorder = new LinkedList<T>();
		
		preorder.insertLast(root.getData());
		
		preorderTraversalFind(root.getLeftChild(), preorder);

		preorderTraversalFind(root.getRightChild(), preorder);
		
		return preorder;
	}
	
	/**
	 * 
	 * @param currentNode
	 * @param currentList
	 */
	private void preorderTraversalFind( BinaryTreeNode<T> currentNode, LinkedList<T> currentList)
	{
		if(currentNode == null)
			return;
		
		currentList.insertLast(currentNode.getData());
			
		if(currentNode.getLeftChild() != null )
			preorderTraversalFind(currentNode.getLeftChild(), currentList);

		if(currentNode.getRightChild() != null )
			preorderTraversalFind(currentNode.getRightChild(), currentList);
	}

	/**
	 * Get the data of this tree using postorder traversal.
	 * 
	 * @return postorder List.
	 **/
	public LinkedList<T> postorderTraversal()
	{
		LinkedList<T> postorder = new LinkedList<T>();

		postorderTraversalFind(root.getLeftChild(), postorder);

		postorderTraversalFind(root.getRightChild(), postorder);
		
		postorder.insertLast(root.getData());
		
		return postorder;
	}
	
	/**
	 * 
	 * @param currentNode
	 * @param currentList
	 */
	private void postorderTraversalFind( BinaryTreeNode<T> currentNode, LinkedList<T> currentList)
	{
		if(currentNode == null)
			return;
		
		if(currentNode.getLeftChild() != null )
			postorderTraversalFind(currentNode.getLeftChild(), currentList);

		if(currentNode.getRightChild() != null )
			postorderTraversalFind(currentNode.getRightChild(), currentList);
			
		currentList.insertLast(currentNode.getData());
	}
	
	

	/**
	 * Print the tree using inorder traversal.
	 * 
	 * @return inorder String
	 **/
	public String inorderString()
	{
		LinkedList<T> printList = inorderTraversal();
		
		return printList.toString();
	}

	/**
	 * Print the tree using preorder traversal.
	 * 
	 * @return preorder String
	 **/
	public String preorderString()
	{
		LinkedList<T> printList = preorderTraversal();
		
		return printList.toString();
	}

	/**
	 * Print the tree using postorder traversal.
	 * @return postorder String
	 **/
	public String postorderString()
	{
		LinkedList<T> printList = postorderTraversal();
		
		return printList.toString();
	}
}