import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class PowersOfTwoTest {

	ArrayList<Integer> powersOfTwo;		// holds the expected ArrayList of values
	
	@Test
	/*
	 * Tests taking some positive integer number of values from the LazyList.
	 */
	public void testGetSomeVals() {
		powersOfTwo = new ArrayList<Integer>();
		
		powersOfTwo.add(1);
		powersOfTwo.add(2);
		powersOfTwo.add(4);
		powersOfTwo.add(8);
		powersOfTwo.add(16);
		
		PowersOfTwo powersList = new PowersOfTwo();
		assertEquals(powersOfTwo, powersList.take(5));
		
		powersOfTwo.remove(4);
		powersOfTwo.remove(3);
		
		assertEquals(powersOfTwo, powersList.take(3));
	}
	
	@Test
	/*
	 * Tests taking 0 and negative values from the LazyList.
	 */
	public void testGetNoneOrNegative() {
		powersOfTwo = new ArrayList<Integer>();
		PowersOfTwo powersList = new PowersOfTwo();
		
		assertEquals(powersOfTwo, powersList.take(0));
		assertEquals(powersOfTwo, powersList.take(-3));
	}
	
	@Test
	/*
	 * Tests getting one value from the LazyList.
	 */
	public void testGetOne() {
		powersOfTwo = new ArrayList<Integer>();
		powersOfTwo.add(1);
		
		PowersOfTwo powersList = new PowersOfTwo();
		
		assertEquals(powersOfTwo, powersList.take(1));
	}

}
