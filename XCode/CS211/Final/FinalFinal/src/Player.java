import java.util.Vector;

public class Player
{
	String name;
	int totalCash;
	int currentLocation;
	boolean inJail;
	boolean inGame;
	Vector placesOwned;
	
	public Player(String name)
	{
		this.name = name;
		totalCash = 1500;
		currentLocation = 0;
		inJail = false;
		inGame = true;
		placesOwned = new Vector();
	}
	
	public void setInJail(boolean changeValue)
	{
		inJail = changeValue;
	}
	
	public boolean getInJail()
	{
		return inJail;
	}
	
	public void setCurrentLocation(int newLocation)
	{
		currentLocation = newLocation;
	}
	
	public int getLocation()
	{
		return currentLocation;
	}
	
	public void addPlace(int newPlace)
	{
		placesOwned.add(newPlace);
	}
	
	public void removePlace(int cell)
	{
		placesOwned.remove(cell);
	}
	
	public boolean getInGame()
	{
		return inGame;
	}
	
	public void setInGame(boolean out)
	{
		inGame = out;
	}
	public Vector getAllPlaces()
	{
		return placesOwned;
	}
	
	public void setTotalCash(int newTotal)
	{
		totalCash = newTotal;
	}
	
	public int getTotalCash()
	{
		return totalCash;
	}
	
	public String getName()
	{
		return name;
	}
	
	
	
	
	/**
	 * Player - holds player’s name, cell number of their current location, total cash they have, vector 
	 * holding the cell numbers of Places they have bought, inJail boolean

	  constructor(name)
	  get methods for everything; set methods for inJail, current location, one method 		  
	  to add a new place to the vector

	 */
}