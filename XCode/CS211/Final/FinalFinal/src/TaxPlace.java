
public class TaxPlace implements Place{

	String tax;
	int taxTaken;

	public TaxPlace(String tax, int taxTaken)
	{
		this.tax = tax;
		this.taxTaken = taxTaken;
	}
	
	public String getName() {
		// TODO Auto-generated method stub
		return tax;
	}
	
	// luxury is 100
	// income is 200
	public int takeTax()
	{
		return taxTaken;
	}
}
