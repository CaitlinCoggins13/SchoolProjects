import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This class tests the RedBlackTree class methods.  All cases of color changes and tree rotations
 * are checked, as well as getRoot() and search(). 
 * @author caitlincoggins
 *
 */
public class RedBlackTreeTest 
{

	@Test
	/**
	 * Tests a Case 1 clash where the newNode was added to the left side of the tree.
	 */
	public void testCase1Left() 
	{
		RedBlackTree testTree = new RedBlackTree();
		// creates case
		testTree.insert(5);
		testTree.insert(6);
		testTree.insert(4);
		testTree.insert(3);
		
		assertEquals("Should be set to black", testTree.getRoot().getLeftChild().getIsRed(), false);
		assertEquals("Should be set to black", testTree.getRoot().getRightChild().getIsRed(), false);
		assertEquals("Should stay red", testTree.getRoot().getLeftChild().getLeftChild().getIsRed(), true);
	}
	
	@Test
	/**
	 *  Tests a Case 1 clash where the newNode was added to the right side of the tree. 
	 */
	public void testCase1Right() 
	{
		RedBlackTree testTree = new RedBlackTree();
		// creates case
		testTree.insert(5);
		testTree.insert(6);
		testTree.insert(4);
		testTree.insert(7);
		
		assertEquals("Should be set to black", testTree.getRoot().getLeftChild().getIsRed(), false);
		assertEquals("Should be set to black", testTree.getRoot().getRightChild().getIsRed(), false);
		assertEquals("Should stay red", testTree.getRoot().getRightChild().getRightChild().getIsRed(), true);
	}
	
	@Test
	/**
	 * Tests a Case 2 clash where the clash is with right children.
	 */
	public void testCase2Right()
	{
		RedBlackTree testTree = new RedBlackTree();
		// creates case
		testTree.insert(5);
		testTree.insert(8);
		testTree.insert(12);
		
		assertEquals("Shold be moved to root", testTree.getRoot().getData(), 8);
		assertEquals("Should be left child of root", testTree.getRoot().getLeftChild().getData(), 5);
		assertEquals("Should be right child of root", testTree.getRoot().getRightChild().getData(), 12);
	}
	
	@Test
	/**
	 * Tests a Case 2 clash where the clash is with left children.
	 */
	public void testCase2Left()
	{
		RedBlackTree testTree = new RedBlackTree();
		// creates case
		testTree.insert(12);
		testTree.insert(8);
		testTree.insert(5);
		
		assertEquals("Shold be moved to root", testTree.getRoot().getData(), 8);
		assertEquals("Should be left child of root", testTree.getRoot().getLeftChild().getData(), 5);
		assertEquals("Should be right child of root", testTree.getRoot().getRightChild().getData(), 12);
	}
	
	@Test
	/**
	 * Tests the outcome of a Case 3 clash where the clash is with a left child whose parent
	 * is a right child.
	 */
	public void testCase3Right()
	{
		RedBlackTree testTree = new RedBlackTree();
		// creates case
		testTree.insert(5);
		testTree.insert(3);
		testTree.insert(4);
		
		assertEquals("Shold be moved to root", testTree.getRoot().getData(), 4);
		assertEquals("Should be left child of root", testTree.getRoot().getLeftChild().getData(), 3);
		assertEquals("Should be right child of root", testTree.getRoot().getRightChild().getData(), 5);
	}
	
	@Test
	/**
	 * Tests the outcome of a Case 3 clash where the clash is with a right child whose parent
	 * is a left child.
	 */
	public void testCase3Left()
	{
		RedBlackTree testTree = new RedBlackTree();
		// creates case
		testTree.insert(13);
		testTree.insert(3);
		testTree.insert(7);
		
		assertEquals("Shold be moved to root", testTree.getRoot().getData(), 7);
		assertEquals("Should be left child of root", testTree.getRoot().getLeftChild().getData(), 3);
		assertEquals("Should be right child of root", testTree.getRoot().getRightChild().getData(), 13);
	}
	
	@Test
	/**
	 * Tests the ability to get the root of the RedBlackTree.
	 */
	public void testGetRoot()
	{
		RedBlackTree testTree = new RedBlackTree();
		testTree.insert(13);
		assertEquals("The data values will be equal if the RedBlackTreeNode was inserted correctly", testTree.getRoot().getData(), 13);
	}
	
	@Test
	/**
	 * Tests the search method as implemented by the RedBlackTree class.
	 */
	public void testSearch()
	{
		RedBlackTree testTree = new RedBlackTree();
		testTree.insert(13);
		testTree.insert(3);
		testTree.insert(7);
		testTree.insert(24);
		testTree.insert(5);
		
		assertEquals("Should be root", testTree.search(7), testTree.getRoot());
		assertEquals("Should be right child", testTree.search(13), testTree.getRoot().getRightChild());
		assertEquals("Making sure lower nodes are not dropped or missed", testTree.search(5), testTree.getRoot().getLeftChild().getRightChild());
	}
}
