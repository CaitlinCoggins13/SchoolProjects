import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This class tests the new methods in DoublyLinkedList and DoublyLinkedListNode.
 * @author caitlincoggins
 *
 */
public class DoublyLinkedListTest 
{

	@Test
	/**
	 * Tests the insertFirst() method.
	 */
	public void testInsertFirst()
	{
		DoublyLinkedList<String> testList = new DoublyLinkedList<String>();
		testList.insertFirst("a");
		String print = testList.toString();
		assertEquals("The list String should match the expected result", print, "a");
	}
	
	/**
	 * Tests the insertLast() method when given a node that is also the head.
	 */
	public void testInsertLastFirstNode()
	{
		DoublyLinkedList<String> testList = new DoublyLinkedList<String>();
		testList.insertLast("a");
		String print = testList.toString();
		assertEquals("The list String should match the expected result", print, "a");
	}
	
	/**
	 * Tests the insertLast() method when given a node that goes at the end of an 
	 * existing list of nodes.
	 */
	public void testInsertLastLastNode()
	{
		DoublyLinkedList<String> testList = new DoublyLinkedList<String>();
		testList.insertFirst("m");
		testList.insertLast("a");
		String print = testList.toString();
		assertEquals("The list String should match the expected result", print, "m    a");
	}
	
	/**
	 * Tests the insertAfter() method when the inserted node is at the end of the list.
	 */
	public void testInsertAfterEnd()
	{
		DoublyLinkedList<String> testList = new DoublyLinkedList<String>();
		testList.insertFirst("m");
		testList.insertAfter(testList.head, "e");
		String print = testList.toString();
		assertEquals("The list String should match the expected result", print, "m    e");
	}
	
	/**
	 *  Tests the insertAfter() method when the inserted node is in the middle of the list.
	 */
	public void testInsertAfterMiddle()
	{
		DoublyLinkedList<String> testList = new DoublyLinkedList<String>();
		testList.insertFirst("m");
		testList.insertLast("m");
		testList.insertAfter(testList.head, "o");
		String print = testList.toString();
		assertEquals("The list String should match the expected result", print, "m    o    m");
	}
	
	/**
	 * Tests the deleteFirst() method.
	 */
	public void testDeleteFirst()
	{
		DoublyLinkedList<String> testList = new DoublyLinkedList<String>();
		testList.insertFirst("a");
		testList.insertFirst("b");
		testList.insertFirst("c");
		testList.deleteFirst();
		String print = testList.toString();
		assertEquals("The list String should match the expected result", print, "b    a");
	}
	
	/**
	 * Tests the deleteLast() method when the node to be deleted is also the head.
	 */
	public void testDeleteLastFirstNode()
	{
		DoublyLinkedList<String> testList = new DoublyLinkedList<String>();
		testList.insertFirst("a");
		testList.deleteLast();
		String print = testList.toString();
		assertEquals("The list String should match the expected result", print, "");
	}
	
	/**
	 * Tests the deleteLast() method when given a node that is at the end of an 
	 * existing list of nodes.
	 */
	public void testDeleteLastLastNode()
	{
		DoublyLinkedList<String> testList = new DoublyLinkedList<String>();
		testList.insertFirst("a");
		testList.insertLast("b");
		testList.insertLast("c");
		testList.insertLast("d");
		testList.deleteLast();
		String print = testList.toString();
		assertEquals("The list String should match the expected result", print, "c    b    a");
	}
	
	/**
	 * Tests the deleteNext() method when given a node that is at the end of an 
	 * existing list of nodes.
	 */
	public void testDeleteNextLast()
	{
		DoublyLinkedList<String> testList = new DoublyLinkedList<String>();
		testList.insertFirst("m");
		testList.insertLast("e");
		testList.deleteNext(testList.head);
		String print = testList.toString();
		assertEquals("The list String should match the expected result", print, "m");
	}
	
	/**
	 * Tests the deleteNext() method when given a node that is in the middle of an 
	 * existing list of nodes.
	 */
	public void testDeleteNextMiddle()
	{
		DoublyLinkedList<String> testList = new DoublyLinkedList<String>();
		testList.insertFirst("m");
		testList.insertLast("o");
		testList.insertLast("m");
		testList.deleteNext(testList.head);
		String print = testList.toString();
		assertEquals("The list String should match the expected result", print, "m    m");
	}
	
	/**
	 * Tests the method setPrevious() when setting the head node.
	 */
	public void testSetPreviousFirst()
	{
		DoublyLinkedList<String> testList = new DoublyLinkedList<String>();
		testList.insertFirst("a");
		testList.insertFirst("b");
		DoublyLinkedListNode<String> testNode = new DoublyLinkedListNode<String>("c");
		testList.head.getNext().setPrevious(testNode);
		String print = testList.toString();
		assertEquals("The list String should match the expected result", print, "c    b");
	}
	
	/**
	 * Tests the method setPrevious() when setting a node in the middle of a list.
	 */
	public void testSetPreviousMiddle()
	{
		DoublyLinkedList<String> testList = new DoublyLinkedList<String>();
		testList.insertFirst("a");
		testList.insertFirst("b");
		testList.insertFirst("c");
		DoublyLinkedListNode<String> testNode = new DoublyLinkedListNode<String>("d");
		testList.head.getNext().getNext().setPrevious(testNode);
		String print = testList.toString();
		assertEquals("The reverse list String should match the expected result", print, "a    d    c");
	}
	
	/**
	 * Tests the isEmpty() method when the list is empty.
	 */
	public void testIsEmptyTrue()
	{
		DoublyLinkedList<String> testList = new DoublyLinkedList<String>();
		boolean empty = testList.isEmpty();
		assertEquals("Testing a true instance of isEmpty()", empty, true);
	}
	
	/**
	 * Tests the isEmpty() method when the list is not empty.
	 */
	public void testIsEmptyFalse()
	{
		DoublyLinkedList<String> testList = new DoublyLinkedList<String>();
		testList.insertFirst("p");
		boolean empty = testList.isEmpty();
		assertEquals("Testing a true instance of isEmpty()", empty, false);
	}
	
	/**
	 * Tests the getPrevious() method.
	 */
	public void testGetPrevious()
	{
		DoublyLinkedList<String> testList = new DoublyLinkedList<String>();
		testList.insertFirst("a");
		testList.insertLast("b");
		testList.insertLast("c");
		testList.insertLast("d");
		String data = testList.getLastNode().getPrevious().getData();
		assertEquals("Testing getPrevious()", data, "c");
	}
	
	/**
	 * Tests the reverseList() method; ensures that previous pointers are not misplaced
	 */
	public void testReverseTraversal()
	{
		DoublyLinkedList<String> testList = new DoublyLinkedList<String>();
		testList.insertFirst("a");
		testList.insertLast("b");
		testList.insertAfter(testList.head, "c");
		testList.insertFirst("d");
		testList.insertLast("e");
		String reverseList = testList.toStringReversed();
		assertEquals("The reverse list String should match the expected result", reverseList, "e    b    c    a    d");
	}
	
	

}
