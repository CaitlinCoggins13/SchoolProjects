import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/* Creates a LazyList with a seed value, a function to calculate the next seed,
 * and a LazyList containing all other values in the list.
 * 
 * @author Caitlin Coggins
 */
public class LazyList<T> implements LazyListIfc
{
	T seed;
	Function<T, T> generate;
	
	/**
     * Creates a lazy list, where start is the first value in
     * the lazy list and op is a function that generates the
     * next value in the list.
     * @param start the first value in the lazy list
     * @param op the function to generate the next value.
     */
    public LazyList (T start, Function<T, T> op)
    {
    	seed = start;
    	generate = op;
    }
	
	/**
     * @return the first value in the lazy list
     */
	public Object lazyFirst() {
		return seed;
	}

	/**
     * @return the list with the first value removed
     */
	public LazyListIfc lazyRest() {
		return new LazyList(generate.apply((T) seed), generate);
	}

	/**
     * Return the first part of a lazy list
     * @param howMany the number of values from the lazy list to return
     * @return the values at the start of the list as an ArrayList
     */
	public ArrayList take(int howMany) {
		// if you want 0 or fewer values, return an empty ArrayList
		if(howMany <= 0)
			return new ArrayList();
		
		// create an ArrayList with the original seed as the first value,
		// then loop through values in the rest of the LazyList, adding them to the 
		// ArrayList until the number of values asked for is reached.
		else
		{
			ArrayList getLazy = new ArrayList();  // holds the list of values to be returned
			getLazy.add(seed);
			LazyListIfc addToList = lazyRest(); // keeps track of where in the LazyList we are
			
			for(int i = howMany - 1; i > 0; i--)
			{
				getLazy.add(addToList.lazyFirst());
				addToList = addToList.lazyRest();
			}
			
			return getLazy;
		}
	}

}
