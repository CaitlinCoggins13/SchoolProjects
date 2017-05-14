
public class RailwayPlace implements Place{

	String railway; 
	int cost;
	String owner;
	boolean isOwned;
	
	public RailwayPlace(String railway)
	{
		this.railway = railway;
		cost = -100;
	}

	public String getName() 
	{
		// TODO Auto-generated method stub
		return railway;
	}
	
	public int costToBuy()
	{
		return cost;
	}
	
	public String getOwnerName()
	{
		return owner;
	}
	
	public void setOwnerName(String owner)
	{
		this.owner = owner;
	}

	public boolean getIsBought() 
	{
		// TODO Auto-generated method stub
		return isOwned;
	}
	
	public void setIsBought(boolean change)
	{
		isOwned = change;
	}
}
