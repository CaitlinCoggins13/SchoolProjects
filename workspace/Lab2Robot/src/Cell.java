/**
 * A Cell contains its distance from the goal, its color, and its position in the world array.
 **/
public class Cell implements Comparable
{
	// The cellInt is how far this cell is from the goal state.
	private int cellInt;
	private int x;
	private int y;
	// The color of the cell represents whether it has been checked in the depth-first search.
	// 0 means white and unchecked, 1 means gray and looked at, 2 means black and expanded.
	private int color; 
	private int heuristic;
	private int g;
	private Cell parent;

	/**
	 * Initializes the cell.
	 * @param x the x-coordinate of the cell in the array
	 * @param y the y-coordinate of the cell in the array
	 */
	public Cell(int x, int y){
		this.x = x;
		this.y = y;
		color = 0;
		heuristic = 0;
		g = 0;
	}
	
	public void setG(int newG)
	{
		g = newG;
	}
	
	public int getG()
	{
		return g;
	}

	public void setInt(int newInt)
	{
		cellInt = newInt;
	}

	public int getInt()
	{
		return cellInt;
	}

	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public int getHeuristic()
	{
		return heuristic;
	}
	
	public void setHeuristic(int h)
	{
		heuristic = h;
	}
	
	public void setParent(Cell c)
	{
		parent = c;
	}
	
	public Cell getParent()
	{
		return parent;
	}

	/**
	 * Sets this node to be gray.
	 **/
	public void setColorGray(){
		color = 1;

	}

	/**
	 *Sets this node's color to black.
	 **/
	public void setColorBlack(){
		color = 2;
	}
	
	/**
	 * Checks if this node is black.
	 * @return true if the node is black, false otherwise.
	 */
	public boolean isBlack(){
		if(color == 2)
			return true;
		else
			return false;
	}
	
	public int compareTo(Object o)
	{
		Cell c = (Cell)o;
		if(c.getInt()+c.getHeuristic()<this.getInt()+this.getHeuristic())
			return 1;
		
		else if(c.getInt()+c.getHeuristic()>this.getInt()+this.getHeuristic())
			return -1;
		else
			return 0;
	}
}