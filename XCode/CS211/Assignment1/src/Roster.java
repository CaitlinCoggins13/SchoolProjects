/**
 * This class holds the list of students on the roster and the list of students on the
 * waitlist.  A student can be removed from or added to the roster or waitlist.  If a
 * student is removed from the roster and there are students on the waitlist, the
 * first student on the waitlist is added to the roster.
 * @author caitlincoggins
 *
 */

public class Roster
{
	/** Holds all students in the class roster. **/
	private DoublyLinkedList<String> classRoster;
	
	/** Holds all students in the waitlist. **/
	private DoublyLinkedList<String> waitlist;
	
	/**
	 * Constructor.
	 * Initializes both DoublyLinkedLists.
	 * @post both lists are initialized
	 */
	public Roster()
	{
		classRoster = new DoublyLinkedList<String>();
		waitlist = new DoublyLinkedList<String>();
	}
	
	/**
	 * Removes the student inputted if they are in the roster or waitlist.
	 * @param studentName
	 * @post if the student was on a list, they were removed and if this opened a
	 * spot on the roster and there were people on the waitlist, the first person
	 * on the waitlist was added to the roster
	 */
	public void removeStudent(String studentName)
	{
		DoublyLinkedListNode<String> holdNode = classRoster.head;
		String currentString = holdNode.getData();
		
		// holds place in the list
		int count = 1;
		
		// if there are students
		if(!classRoster.isEmpty())
		{
			// for every node
			for(int i=0; i<classRoster.size(); ++i)
			{
				// if there's a matched name with the one to be deleted
				if(studentName.equals(currentString))
				{
					//if this is the first node
					if(holdNode == classRoster.head)
						classRoster.deleteFirst();
				
					// if this is the last node
					else if(count == classRoster.size())
						classRoster.deleteLast();
				
					// if it is somewhere in the middle
					else 
						classRoster.deleteNext(holdNode.getPrevious());	

					// moves the first student from the waitlist to the roster
					if(!waitlist.isEmpty())
					{
						String newStudent = waitlist.head.getData();
						waitlist.deleteFirst();
						addStudent(newStudent);
						
					}
					break;
				}
				
				// moves though the list
				holdNode = holdNode.getNext();
				currentString = holdNode.getData();
				++count;
			}
		}
		
		count = 1;
		
		//checks waitlist the same way as the roster
		//if there are students
		if(!waitlist.isEmpty())
		{
			holdNode = waitlist.head;
			currentString = holdNode.getData();
		
			// for each student
			for(int i=0; i<classRoster.size(); ++i)
			{
				// if the name matches the name to be deleted
				if(studentName.equals(currentString))
				{
					// first node
					if(holdNode == waitlist.head)
						waitlist.deleteFirst();
				
					// last node
					else if(count == waitlist.size())
						waitlist.deleteLast();
				
					// somewhere in the middle
					else 
						waitlist.deleteNext(holdNode.getPrevious());	
				}
				
				holdNode = holdNode.getNext();
				currentString = holdNode.getData();
				++count;
			}
		}
		
	}
	
	/**
	 * Finds where the new student fits in the roster or waitlist and adds it.
	 * @param studentName the name of the new student
	 * @post the new student is added
	 */
	public void addStudent(String studentName)
	{
		// inserts first student
		if(classRoster.isEmpty())
			classRoster.insertLast(studentName);
		
		// starts adding students to waitlist after class reaches a certain size
		else if(classRoster.size()==10)
			waitlist.insertLast(studentName);
		
		else
		{	
			DoublyLinkedListNode<String> nextNode = classRoster.head;
			
			String currentName = nextNode.getData();
			
			// holds place in the list to be compared with the list size, used to find out when to use insertLast() instead of insertAfter()
			int count = 1;
			
			// checks each name
			for(int i=0; i<classRoster.size(); ++i)
			{
				// compared the values of the names
				int compare = studentName.compareTo(currentName);
				
				// if the last name in the list is identical to the new name, add the new name to the end of the list
				if(compare==0 && count == classRoster.size())
				{
					classRoster.insertLast(studentName);
					break;
				}
				
				// if a name in the list is identical to te new name, add the new name after the old name.
				if(compare == 0)
				{
					classRoster.insertAfter(nextNode, studentName);
					break;
				}
				
				// if the new name is before the current head in the alphabet, the new name is inserted at the front of the list.
				if(compare < 0 && nextNode == classRoster.head)
				{
					classRoster.insertFirst(studentName);
					break;
				}
				
				// if the new name is before the current node in the alphabet, the new name is inserted before it.
				if(compare < 0)
				{
					classRoster.insertAfter(nextNode.getPrevious(), studentName);
					break;
				}
				
				// if the new name is later in the alphabet than any other name, insert it at the end of the list.
				if(compare > 0 && count == classRoster.size())
				{
					classRoster.insertLast(studentName);
					break;
				}
				
				// prepare to check next String
				nextNode = nextNode.getNext();
				currentName = nextNode.getData();	
				++count;
			}
		}
	}
	
	/**
	 * Returns a string containing all names in the roster.
	 * @return classRoster.toString() a String containing the roster names in order
	 */
	public String getRosterNames()
	{
		return(classRoster.toString());
	}
	
	/**
	 * Returns a string containing all names in the waitlist.
	 * @return waitlist.toString() a String containing the waitlist names in order
	 */
	public String getWaitlistNames()
	{
		return(waitlist.toString());
	}
}