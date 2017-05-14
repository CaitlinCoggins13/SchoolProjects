package cs201.coggi22c.unrestguessgme;

import cs201.coggi22c.util.BinaryTree;
import cs201.coggi22c.util.BinaryTreeNode;
import cs201.coggi22c.util.DefaultBinaryTree;
import cs201.coggi22c.util.DefaultBinaryTreeNode;
import cs201.coggi22c.util.LinkedList;
import cs201.coggi22c.util.LinkedListNode;
import cs201.coggi22c.util.CommutativeExpressionReader;

import java.util.ArrayList;

import javax.swing.JOptionPane;

// QuestionsGame.java
// Caitlin Coggins
/**
 * QuestionsGame runs the 20 Questions game.  It parses the XML file, keeps track of
 * the user's place in the binary tree, and displays the win and lose states.
 * @author caitlincoggins
 *
 */
public class QuestionsGame
{
	/** Tree that holds all of the tree from the XML file **/
	BinaryTree questionTree;
	/** Node that the current place in the tree is held in **/
	BinaryTreeNode holdPlace;
	
	/**
	 * Constructor.
	 */
	public QuestionsGame()
	{
		newGame();
	}
	
	/**
	 * Parses the XML file and sets holdPlace to the root of the tree.
	 */
	public void newGame()
	{
		questionTree = CommutativeExpressionReader.readCommutativeExpr( "questionTree.xml" );
		holdPlace = questionTree.getRoot();
	}
	
	/**
	 * Figures out whether the game is over, the player has chosen yes, or the player has chosen no.
	 * @param choice the user's choice
	 */
	public void chooseBranch(String choice)
	{
		// if we've reached a leaf, the player has said whether the city was right or not
		if(holdPlace.isLeaf())
			endGame(choice);
		
		// go down the yes path
		else if(choice.equals("yes"))
			holdPlace = holdPlace.getLeftChild();

		// go down the no path
		else
			holdPlace = holdPlace.getRightChild();
	}
	
	/**
	 * Invokes win or lose state.
	 * @param end the String saying whether the user picked yes or no
	 */
	public void endGame(String end)
	{
		// inform the user that the program won and reset the game
		if(end.equals("yes"))
		{
			JOptionPane.showMessageDialog(null, "Ha, I win!");
			holdPlace = questionTree.getRoot();
		}
		
		// inform the player they won, take in data, put it in tree, reset game
		else
		{
			JOptionPane.showMessageDialog(null, "I guess you won this one...");
			
			//take in name of new city, new question, answer to question
			String city = (String)JOptionPane.showInputDialog(null, "Enter the name of your city", JOptionPane.PLAIN_MESSAGE);
			String question = (String)JOptionPane.showInputDialog(null, "Enter a question that would separate your city and the city I thought you were describing:", JOptionPane.PLAIN_MESSAGE);
			String answer = (String)JOptionPane.showInputDialog(null, "For your city, is the answer to the question yes or no?", JOptionPane.PLAIN_MESSAGE);
			
			//holds the city that used to reside at this node
			String oldCity = (String)holdPlace.getData();
			
			//changes the node to hold the question
			holdPlace.setData(question);
			
			//sets up the two new left and right nodes
			BinaryTreeNode newYes = new DefaultBinaryTreeNode(city);
			BinaryTreeNode newNo = new DefaultBinaryTreeNode(oldCity);
			
			// if the answer to the question is yes
			if(answer.equals("yes"))
			{
				holdPlace.setLeftChild(newYes);
				holdPlace.setRightChild(newNo);
			}
			
			// if the answer to the question is no
			else
			{
				holdPlace.setRightChild(newYes);
				holdPlace.setLeftChild(newNo);
			}
			
			// reset game
			holdPlace = questionTree.getRoot();
		}
	}
	
	/**
	 * Gets all leaves that could still be the one the user picked
	 * @return a list of cities
	 */
	public String getCities()
	{
		String allCities = leafFind(); 
		return allCities;
	}
	
	/**
	 * Returns the new question to ask the user
	 * @return the new question
	 */
	public String getQuestion()
	{
		// just another question
		if(!holdPlace.isLeaf())
			return (String) holdPlace.getData();
		// asks the user specifically if this is their city
		return "Is your city "+(String) holdPlace.getData() +"?";
	}
	
	/**
	 * Creates a list of cities that the user could have picked in one String to be displayed
	 * @return the list of cities
	 */
	public String leafFind()
	{
		// list all cities go into
		LinkedList<String> allLeaves = new LinkedList<String>();
		
		// get all cities
		leafString(holdPlace, allLeaves);
		
		// return list of cities
		return allLeaves.toString();
	}
	
	/**
	 * Searches the binary tree for all of the leaves that the user could have picked
	 * @param searchLeaf the root of the part of the tree being searched
	 * @param cityList the list all the cities are put into
	 */
	private void leafString(BinaryTreeNode searchLeaf, LinkedList cityList)
	{
		// if it's a leaf, add it to the list
		if( searchLeaf.isLeaf() )
		{
			cityList.insertLast(searchLeaf.getData());
		}
		
		// if it's not, search the other nodes around it
		else
		{
			if(searchLeaf.getLeftChild() != null )
				leafString(searchLeaf.getLeftChild(), cityList);
			
			if(searchLeaf.getRightChild() != null )
				leafString(searchLeaf.getRightChild(), cityList);
		}
	}
}