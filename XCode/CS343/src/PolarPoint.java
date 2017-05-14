/*
 * This class creates a PolarPoint, which takes in a magnitude and an angle.
 * @author Caitlin Coggins
 */
public class PolarPoint extends Point
{
	/*
	 * Creates a new PolarPoint.
	 * @param magVal the magnitude of the point
	 * @param angleVal the angle of the point
	 */
	public PolarPoint(double magVal, double angleVal)
	{
		val1 = magVal;
		val2 = angleVal;
	}
	
	/*
	 * Returns the magnitude of the point.
	 * @return val1 the magnitude of the point
	 */
	public double getMagnitude() 
	{
		return val1;
	}

	/*
	 * Returns the angle of the point.
	 * @return val2 the angle of the point
	 */
	public double getAngle() 
	{
		return val2;
	}

	/*
	 * Sets the magnitude to a new value.
	 * @param newMag the new magnitude of the point
	 */
	public void setMagnitude(int newMag) 
	{
		val1 = newMag;
	}

	/*
	 * Sets the angle to a new value.
	 * @param newAngle the new angle of the point
	 */
	public void setAngle(int newAngle) 
	{
		val2 = newAngle;
	}
}
