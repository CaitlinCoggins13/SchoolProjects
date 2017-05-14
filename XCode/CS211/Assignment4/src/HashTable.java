/**
 * HashTable holds Entries in a linked list array.  Each key in the entry has a generated code, and that code determines
 * what cell in the array, or bucket, the entry goes in.  A user can search for one or all values with a particular
 * key, delete one or all values with a particular key, or insert a new key and value.
 * @author caitlincoggins
 *
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HashTable
{
	int numBuckets = 10007;			// number of buckets
	LinkedList[] hashBuckets;		// array of buckets
	
	/**
	 * Constructor.
	 * Initializes the array of buckets.
	 * Calls function to enter initial values from the text file.
	 * @throws IOException
	 */
	public HashTable() throws IOException
	{
		hashBuckets = new LinkedList[numBuckets];
		init();
	}
	
	/**
	 * Reads in each word and definition, then inserts the word and definition as an Entry in the array.
	 * @throws IOException
	 */
	public void init() throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader("Dictionary.txt"));
		
		String line = reader.readLine();
		
		while(line != null)
		{
			//parse line
			int endWord = line.indexOf(",");
			
			String word = line.substring(0, endWord);
			
			//skip the comma and the space
			String definition = line.substring(endWord + 2);

			insert(word, definition);
			
			line = reader.readLine();
		}
	}

	/**
	 * Picks the bucket based off the code for the key.
	 * @param key the key for the word
	 * @return the generated hash code
	 */
	public int pickBucket(String key)
	{
		// picks the bucket
		int hashCode = hash(key) % numBuckets;
		
		// keeps values positive
		if(hashCode < 0)
			hashCode += numBuckets;
		
		return hashCode;
	}
	
	/**
	 * Creates the unique code for the word.
	 * @param key
	 * @return the hashed key for the word
	 * @post a unique code will be generated
	 */
	public int hash(String key)
	{
		int hash = 0;
		
		// generates the unique code for the word
		for(int i = 0; i<key.length(); ++i)
			hash = ((127 * hash + key.charAt(i)) % 16908799);
		
		return hash;
	}
	
	/**
	 * Finds a definition for a given word.
	 * @param key the word to be searched for
	 * @return a definition of the word or a phrase that tells the user that the word isn't in the dictionary
	 */
	public String find(String key)
	{
		// gets the hash code
		int searchBucket = pickBucket(key);
		
		// if there are no nodes, there's no word there
		if(hashBuckets[searchBucket] == null)
		{
			return "Sorry, that word isn't in this dictionary.";
		}
		
		// gets the head of the list
		LinkedListNode checkKey = hashBuckets[searchBucket].getFirstNode();
		
		// checks each node to see if it contains the key
		while(checkKey != null)
		{
			if(((Entry) checkKey.getData()).getKey().equals(key))
				return ((Entry) checkKey.getData()).getValue();
			
			checkKey = checkKey.getNext();
		}
		
		return "Sorry, that word isn't in this dictionary.";
	}
	
	/**
	 * Finds all definitions for a given word.
	 * @param key the word to be searched for
	 * @return all definitions of the word or a phrase that tells the user that the word isn't in the dictionary
	 */
	public String findAll(String key)
	{
		String allValues = "";
		
		int searchBucket = pickBucket(key);

		// if there are no nodes, there's no word there
		if(hashBuckets[searchBucket] == null)
		{
			return "Sorry, that word isn't in this dictionary.";
		}
		
		LinkedListNode checkKey = hashBuckets[searchBucket].getFirstNode();
		
		// checks every node for the key
		while(checkKey != null)
		{
			// if the key matches, the definition is concatenated onto the end of a string
			if(((Entry) checkKey.getData()).getKey().equals(key))
				allValues += ((Entry) checkKey.getData()).getValue() + "; ";
			
			checkKey = checkKey.getNext();
		}
		
		// if none of the nodes contained the searched-for word, tell the user
		if(allValues.equals(""))
			return "Sorry, that word isn't in this dictionary.";
		
		return allValues;
	}
	
	/**
	 * Creates an Entry and inserts it into its hashCode LinkedList.
	 * If the LinkedList has not been initialized yet, it is initialized.
	 * @param key the word
	 * @param value the definition
	 * @post the new Entry is inserted in its proper bucket
	 */
	public void insert(String key, String value)
	{
		// creates a new entry
		Entry add = new Entry(key, value);
		
		// initializes the list if necessary
		if(hashBuckets[pickBucket(key)] == null)
			hashBuckets[pickBucket(key)] = new LinkedList();
		
		// adds the new entry to the list
		hashBuckets[pickBucket(key)].insertFirst(add);
	}
	
	/**
	 * Deletes the first encountered instance of the word.  If the word isn't there, nothing happens.
	 * @param key the word to be deleted
	 * @post if the word was in its bucket, the first instance of it was deleted
	 */
	public void delete(String key)
	{
		// gets the bucket the key hashes into
		int searchBucket = pickBucket(key);
		
		// if there are any entries at all
		if(hashBuckets[searchBucket] != null)
		{
			// gets the head of the linked list
			LinkedListNode checkKey = hashBuckets[searchBucket].getFirstNode();
			
			// if the head is the key, delete the head
			if(((Entry) checkKey.getData()).getKey().equals(key))
				hashBuckets[searchBucket].deleteFirst();
			
			else
			{
				// while there is a next node
				while(checkKey.getNext() != null)
				{
					// if the next node matches the key, delete it
					if(((Entry) checkKey.getNext().getData()).getKey().equals(key))
					{
						hashBuckets[searchBucket].deleteNext(checkKey);
						break;
					}
					
					checkKey = checkKey.getNext();
				}
			}
		}
	}
	
	/**
	 * Deletes all instances of a word.  If the word isn't there, nothing happens.
	 * @param key the word to be deleted
	 * @post if the word was in its bucket, any instance of it was deleted
	 */
	public void deleteAll(String key)
	{
		int searchBucket = pickBucket(key);
		
		// if there are any entries at all
		if(hashBuckets[searchBucket].size() != 0)
		{
			// gets the head of the list
			LinkedListNode checkKey = hashBuckets[searchBucket].getFirstNode();

			// while the node holds a value
			while(checkKey != null)
			{
				// if the first entry needs for be deleted, get the next node, then delete the first node
				if(((Entry) checkKey.getData()).getKey().equals(key))
				{
					checkKey = checkKey.getNext();
					hashBuckets[searchBucket].deleteFirst();
				}
			}
		}
	}
}