public class MoneyCard implements Card
{
	String outputText;
	int cashAmount;
	
	public MoneyCard(String outputText, int cashAmount)
	{
		this.outputText = outputText;
		this.cashAmount = cashAmount;
	}

	@Override
	public String getText() 
	{
		return outputText;
	}
	
	public int getCash()
	{
		return cashAmount;
	}
}