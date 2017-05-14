/**
 * HashTableText displays a HashTable to a user.  It also reads in and interprets input.
 * 
 * @author caitlincoggins
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HashTableText
{
	HashTable useTable;		// instance of HashTable
	
	/**
	 * Creates a new HashTableText.
	 * @param args empty
	 * @throws IOException
	 */
	public static void main( String[] args ) throws IOException
	{
		new HashTableText();
	}
	
	/**
	 * Initializes the hash table and begins to read in user input.
	 * @throws IOException
	 */
	public HashTableText() throws IOException
	{
		useTable = new HashTable();
		readLine();
	}
	
	/**
	 * Reads in what the user types, interprets it, and gives feedback to the user.
	 * @throws IOException
	 */
	public void readLine() throws IOException{
		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
		
		System.out.println( "Hello! Type help for a list of commands." );
		// I/O almost always requires a try/catch
        // block as exceptions may be thrown
        try
        {
            String line;
            
            // loop until the user types "end"
            do {
            	String word;
                // prompt the user for input
            	System.out.println( "\nEnter a command: " );
                
                // try to read a line
                // this function potentially throws an IOException
                line = reader.readLine();
                int endWord = line.indexOf(" ");
                
                // only one word
                if(endWord == -1)
                	word = line;
                
                // gets next word
                else	
                	word = line.substring(0, endWord);
                
                // adding a word and definition
                if(word.equals("add"))
                {
                	int endNewWord = line.indexOf(',');
                	
                	// no comma, wrong syntax
                	if(endNewWord == -1)
                	{
                		System.out.println("Improper usage of add! Type help to view a list of commands.");
                	}
                	
                	else
                	{
                		// get the word and definition, insert them
                		String newWord = line.substring(endWord + 1, endNewWord);
                		String newDefinition = line.substring(endNewWord + 2);
                		
                		useTable.insert(newWord, newDefinition);
                		
                		System.out.println("The word " + newWord + " and its definition have been added.");
                	}
                }
                
                // delete one definition
                else if(word.equals("delete"))
                {
                	// get the key and delete
                	String key = line.substring(endWord + 1);
                	useTable.delete(key);
                	System.out.println("A definition for " + key +" has been deleted.");
                }
                
                // gets the first definition encountered
                else if(word.equals("define"))
                {
                	String key = line.substring(endWord + 1);
                	System.out.println(useTable.find(key));
                }
                
                // delete all definitions for a word
                else if(word.equals("deleteAll"))
                {
                	String key = line.substring(endWord + 1);
                	useTable.deleteAll(key);
                	System.out.println("All definitions for " + key +" have been deleted.");
                }
                
                // gets all definitions for a word
                else if(word.equals("defineAll"))
                {
                	String key = line.substring(endWord + 1);
                	System.out.println(useTable.findAll(key));
                }
                
                // prints a list of commands
                else if(word.equals("help"))
                {
                	System.out.println("Commands and Usages");
                	System.out.println("'add word, definition' - add a word and definition to the dictonary. ");
                	System.out.println("'define word' - get a definition for this word, provided it is in the dictionary. ");
                	System.out.println("'defineAll word' - get all definitions for this word, provided it is in the dictionary. ");
                	System.out.println("'delete word' - delete a definition for this word, provided it is in the dictionary. ");
                	System.out.println("'deleteAll word' - delete all definitions for this word, provided it is in the dictionary. ");
                	System.out.println("'end' - quit the program");
                }
                
                // ends program
                else if(word.equals("end"))
                {
                	System.out.println("Goodbye!");
                }
                
                else
                	System.out.println("Not a valid command! Type 'help' to see a list of commands. ");
                String key = line.substring(endWord + 2);

            } while ( (!line.equals( "end" ) ) );
        }
        // catch I/O exception
        catch ( IOException ioe )
        {
            // tell exception to print its error log
            ioe.printStackTrace();
        }
	}
}