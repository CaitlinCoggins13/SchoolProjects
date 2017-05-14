
public class PropertyPlace implements Place 
{
	String propertyName;
	int costProperty;
	int costRent;
	int costHouse;
	int costHotel;
	String color;
	int numHouses;
	int numHotels;
	boolean isBought;
	
	public PropertyPlace(String propertyName, int costProperty, int costRent, int costHouse, int costHotel, String color)
	{
		this.propertyName = propertyName;
		this.costProperty = costProperty;
		this.costRent = costRent;
		this.costHouse = costHouse;
		this.costHotel = costHotel;
		this.color = color;
		isBought = false;
		numHouses = 0;
		numHotels = 0;
	}
	
	public String getName() 
	{
		return propertyName;
	}
	
	public int getPropertyCost()
	{
		return costProperty;
		
	}
	
	public int getHouseCost()
	{
		return costHouse;
	}
	
	public int getHotelCost()
	{
		return costHotel;
	}
	
	public String getColor()
	{
		return color;
	}
	
	public int numHouses()
	{
		return numHouses;
	}
	
	public int numHotels()
	{
		return numHotels;
	}
	
	public void addHouse()
	{
		numHouses++;
	}
	
	public void addHotel()
	{
		numHotels++;
	}
	
	public void removeHouse()
	{
		numHouses--;
	}
	
	public void removeHotel()
	{
		numHotels--;
	}
	
	public void setIsBought(boolean value)
	{
		isBought = value;
	}
	
	public boolean getIsBought()
	{
		return isBought;
	}
	
	public int getRent()
	{
		return costRent;
	}

}
