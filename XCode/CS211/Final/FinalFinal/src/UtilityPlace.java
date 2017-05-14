
public class UtilityPlace implements Place
{

	String utility;
	String owner;
	int cost;
	boolean isBought;
	
	public UtilityPlace (String utility)
	{
		this.utility = utility;
		cost = -150;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return utility;
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
		return isBought;
	}
	
	public void setIsBought(boolean bought)
	{
		isBought = bought;
	}
	
	public int getCost()
	{
		return cost;
	}
}
