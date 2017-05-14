import static org.junit.Assert.*;

import org.junit.Test;


public class PointDistanceTest {

	@Test
	public void distanceBothCartesian() {
		Point point1 = new CartesianPoint(0, 5);
		Point point2 = new CartesianPoint(0, 0);
		assertEquals(PointDistance.distance(point1, point2), 5.0, 0.01);
	}
	
	@Test
	public void distanceFirstCartesianSecondPolar() {
		Point point1 = new CartesianPoint(5, 0);
		Point point2 = new PolarPoint(12, 0);
		assertEquals(PointDistance.distance(point1, point2), 7.0, 0.01);
	}
	
	@Test
	public void distanceFirstPolarSecondCartesian() {
		Point point1 = new PolarPoint(10, 0);
		Point point2 = new CartesianPoint(-1, 0);
		assertEquals(PointDistance.distance(point1, point2), 11.0, 0.01);
	}
	
	@Test
	public void distanceBothPolar() {
		Point point1 = new PolarPoint(0, 0);
		Point point2 = new PolarPoint(8, 0);
		assertEquals(PointDistance.distance(point1, point2), 8.0, 0.01);
	}
	
	@Test
	public void testConvertPolar() {
		Point point1 = new PolarPoint(Math.sqrt(2.0), (5 * Math.PI) / 4);
		assertEquals(((CartesianPoint)PointDistance.convert(point1)).getX(), -1, 0.01);
		assertEquals(((CartesianPoint)PointDistance.convert(point1)).getY(), -1, 0.01);
	}
	
	@Test
	public void testConvertCartesian() {
		Point point1 = new CartesianPoint(16, 12);
		assertEquals(((CartesianPoint)PointDistance.convert(point1)).getX(), 16.0, 0.01);
		assertEquals(((CartesianPoint)PointDistance.convert(point1)).getY(), 12.0, 0.01);
	}
	
	@Test
	public void testCalcDistance() {
		Point point1 = new CartesianPoint(0, 0);
		Point point2 = new CartesianPoint(10, 10);
		assertEquals(PointDistance.calcDistance(point1, point2), Math.sqrt(200), 0.01);
	}
}
