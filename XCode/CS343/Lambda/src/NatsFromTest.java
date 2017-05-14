import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class NatsFromTest {
	
	ArrayList<Integer> nats;	// holds the expected ArrayList of values
	
	@Test
	/*
	 *  Tests taking some positive integer number of values from the LazyList.
	 */
	public void testGetVal() {
		nats = new ArrayList<Integer>();
		
		nats.add(1);
		nats.add(2);
		nats.add(3);
		nats.add(4);
		nats.add(5);
		
		NatsFrom trueNats = new NatsFrom(1);
		assertEquals(nats, trueNats.take(5));
	}
	
	@Test
	/*
	 * Our original code for nats-from allowed for the possibility of negative values,
	 * even though they are not natural numbers, so I left this in in this version.
	 */
	public void testGetNegativeNats() {
		nats = new ArrayList<Integer>();
		
		nats.add(-15);
		nats.add(-14);
		nats.add(-13);
		nats.add(-12);
		
		NatsFrom trueNats = new NatsFrom(-15);
		assertEquals(nats, trueNats.take(4));
	}
	
	@Test
	/*
	 *  Tests taking 0 and negative values from the LazyList.
	 */
	public void testGetNoneOrNegative() {
		nats = new ArrayList<Integer>();
		
		NatsFrom trueNats = new NatsFrom(1);
		
		assertEquals(nats, trueNats.take(0));
		assertEquals(nats, trueNats.take(-5));
	}
	
	
	
	

}
