/*
 * Creates a LazyList of powers of 2.
 * @author Caitlin Coggins
 */

public class PowersOfTwo extends LazyList
{
	public PowersOfTwo()
	{
		super(1, (seed) -> (int)seed * 2);
	}
}
