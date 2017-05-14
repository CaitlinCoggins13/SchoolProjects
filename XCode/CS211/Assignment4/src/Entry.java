/**
 * Entries store both a key and a value.
 * @author caitlincoggins
 *
 */
public class Entry
{
	String entryKey;		// holds the key
	String entryValue;		// holds the value
	
	/**
	 * Constructor.
	 * Initializes the instances of the key and value.
	 * @param key 
	 * @param value
	 */
	public Entry(String key, String value)
	{
		entryKey = key;
		entryValue = value;
	}
	
	/**
	 * Returns the key stored in the entry.
	 * @return entryKey
	 */
	public String getKey()
	{
		return entryKey;
	}
	
	/**
	 * Returns the value stored in the entry.
	 * @return entryValue
	 */
	public String getValue()
	{
		return entryValue;
	}
}