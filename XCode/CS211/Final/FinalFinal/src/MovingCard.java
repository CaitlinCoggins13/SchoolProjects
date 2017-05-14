public class MovingCard implements Card
{
	String outputText;
	int placeCellNum;
	
	public MovingCard(String outputText, int placeCellNum)
	{
		this.outputText = outputText;
		this.placeCellNum = placeCellNum;
	}

	@Override
	public String getText() 
	{
		return outputText;
	}
	
	public int getPlace()
	{
		return placeCellNum;
	}
}