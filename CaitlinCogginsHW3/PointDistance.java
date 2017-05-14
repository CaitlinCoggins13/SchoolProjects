/*
 * The methods in this class are used to calculate the distance between two CartesianPoints, two PolarPoints,
 * or one CartesianPoint and one PolarPoint.
 * @author Caitlin Coggins
 */
public class PointDistance 
{	
	/* Determines what type of Points were passed in, converts all PolarPoints to
	 * CartesianPoints, calls calcDistance() to calculate the distance between the points.
	 * @param pointA, one of the points passed in
	 * @param pointB, the second point passed in
	 * @return distance, the distance between pointA and pointB
	 */
	public static double distance(Point pointA, Point pointB)
	{
		if(pointA instanceof CartesianPoint && pointB instanceof CartesianPoint)
		{
			return calcDistance(pointA, pointB);
		}
		
		else if(pointA instanceof PolarPoint && pointB instanceof CartesianPoint)
		{
			Point newA = convert(pointA);
			return calcDistance(newA, pointB);
		}
		
		else if(pointA instanceof CartesianPoint && pointB instanceof PolarPoint)
		{
			Point newB = convert(pointB);
			return calcDistance(pointA, newB);
		}
		
		else
		{
			Point newA = convert(pointA);
			Point newB = convert(pointB);
			return calcDistance(newA, newB);
		}
	}
	
	/* Converts a PolarPoint to a CartesianPoint and returns it. 
	 * If the point passed in is already Cartesian, that same point is returned. 
	 * @param p, the point to be converted to a CartesianPoint
	 * @return new CartesianPoint if p was a PolarPoint, or the same point if it was already Cartesian.
	 */
	public static Point convert(Point p)
	{
		if(p instanceof CartesianPoint)
			return p;
		
		return new CartesianPoint(((PolarPoint)p).getMagnitude() * Math.cos(((PolarPoint)p).getAngle()), ((PolarPoint)p).getMagnitude() * Math.sin(((PolarPoint)p).getAngle()));
	}
	
	/* Calculates the distance between two CartesianPoints.
	 * @param pointA, one of the CartesianPoints
	 * @param pointB, the second CartesianPoint
	 * @return the distance between the two points
	 */
	public static double calcDistance(Point pointA, Point pointB)
	{
		double xDist = ((CartesianPoint)pointA).getX() - ((CartesianPoint)pointB).getX();
		double yDist = ((CartesianPoint)pointA).getY() - ((CartesianPoint)pointB).getY();
		return Math.sqrt(((xDist * xDist) + (yDist * yDist)));
	}

}
