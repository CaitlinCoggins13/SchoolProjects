/*
 * Creates a LazyList of natural numbers.
 * @author Caitlin Coggins
 */

public class NatsFrom extends LazyList
{
	public NatsFrom(int i)
	{
		super(i, (seed) -> (int)seed + 1);
	}
}
