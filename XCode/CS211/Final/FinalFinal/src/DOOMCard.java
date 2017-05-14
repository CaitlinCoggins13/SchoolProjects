public class DOOMCard implements Card
{
	String outputText;
	int houseLoss;
	int hotelLoss;
	
	public DOOMCard(String outputText, int houseLoss, int hotelLoss)
	{
		this.outputText = outputText;
		this.houseLoss = houseLoss;
		this.hotelLoss = hotelLoss;
	}
	
	@Override
	public String getText() 
	{
		return outputText;
	}
	
	public int getHouseLossRate()
	{
		return houseLoss;
	}
	
	public int getHotelLossRate()
	{
		return hotelLoss;
	}
	
}