import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This class tests the LinkedList class methods.
 * @author caitlincoggins
 *
 */
public class LinkedListTester 
{
	/**
	 * Tests insertFirst, insertAfter, getFirstNode, toString, and deleteNext all together.
	 */
	@Test
	public void testILoveLava() 
	{
		LinkedList<String> testList = new LinkedList<String>();
		
		testList.insertFirst("a");
		testList.insertFirst("v");
		testList.insertFirst("a");
		testList.insertFirst("l");
		testList.insertFirst("o");
		testList.insertFirst("i");
		testList.insertAfter(testList.getFirstNode().getNext(), "j");
		testList.insertAfter(testList.getFirstNode().getNext(), "e");
		testList.insertAfter(testList.getFirstNode().getNext(), "v");
		testList.insertAfter(testList.getFirstNode(), "l");
		testList.deleteNext(testList.getFirstNode().getNext().getNext().getNext().getNext());
		
		assertEquals("The text should read i love lava with arrows in between the letters", "i => l => o => v => e => l => a => v => a", testList.toString());
	}

	/**
	 * Tests insertFirst.
	 */
	@Test
	public void testGetFirstNode() 
	{
		LinkedList<String> testList = new LinkedList<String>();
		testList.insertFirst("a");
		//LinkedListNode<String> testNode = new LinkedListNode<String>("a");
		
		assertEquals("The first node should contain a", "a", testList.toString());
	}

	/*
	 * Tests getLast.
	 */
	@Test
	public void testGetLastNode() 
	{
		LinkedList<String> testList = new LinkedList<String>();
		testList.insertFirst("f");
		testList.insertFirst("a");
		testList.insertFirst("f");
		testList.insertFirst("o");
		testList.insertFirst("l");

		assertEquals("The last node should contain f", "f", testList.getLast());
	}

	/**
	 * Tests insertFirst.
	 */
	@Test
	public void testInsertFirst() 
	{
		LinkedList<String> testList = new LinkedList<String>();
		testList.insertFirst("a");
		
		assertEquals("", "a", testList.toString());
	}
	
	/*
	 * Tests deleteLast.
	 */
	@Test
	public void testDeleteLast()
	{
		LinkedList<String> testList = new LinkedList<String>();
		testList.insertFirst("a");
		testList.deleteLast();
		
		assertEquals("", "a", testList.toString());
	}
	
	/**
	 * This tests the deleteNext method.
	 */
	@Test
	public void testDeleteNext()
	{
		LinkedList<String> testList = new LinkedList<String>();
		testList.insertFirst("a");
		testList.insertAfter(testList.getFirstNode(), "o");
		testList.deleteNext(testList.getFirstNode());
		
		assertEquals("", "a", testList.toString());
	}
	
	/*
	 * Tests the size method, which counts the number of nodes in a list.
	 */
	@Test
	public void testNumberOfElements()
	{
		int length = 6;
		
		LinkedList<String> testList = new LinkedList<String>();
		
		testList.insertFirst("a");
		testList.insertFirst("b");
		testList.insertFirst("c");
		testList.insertFirst("d");
		testList.insertFirst("e");
		testList.insertFirst("f");
		
		assertEquals("The number of elements is 6", length, testList.size());
	}
}
