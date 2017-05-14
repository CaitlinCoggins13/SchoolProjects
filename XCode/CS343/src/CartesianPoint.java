/*
 * This class creates a CartesianPoint, which takes in an x value and a y value.
 * @author Caitlin Coggins
 */
public class CartesianPoint extends Point
{
	/*
	 * Creates a new CartesianPoint.
	 * @param xVal the x coordinate of the point
	 * @param yVal the y coordinate of the point
	 */
	public CartesianPoint(double xVal, double yVal)
	{
		val1 = xVal;
		val2 = yVal;
	}
	
	/*
	 * Returns the x coordinate.
	 * @return val1 the x coordinate
	 */
	public double getX() 
	{
		return val1;
	}

	/*
	 * Returns the y coordinate.
	 * @return val2 the y coordinate
	 */
	public double getY() 
	{
		return val2;
	}
	
	/*
	 * Sets the x coordinate to a new value.
	 * @param newX the new x coordinate
	 */
	public void setX(double newX) 
	{
		val1 = newX;
	}

	/*
	 * Sets the y coordinate to a new value.
	 * @param newY the new y coordinate
	 */
	public void setY(double newY) 
	{
		val2 = newY;
	}
}
