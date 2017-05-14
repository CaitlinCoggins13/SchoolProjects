import java.util.Arrays;
import java.util.Vector;
import java.util.Stack;

public class World
{
	private Cell[][] worldArray;
	private Cell[][] robotArray;
    private double cellWidth;
	private Cell endCell;
	private Cell robotEndCell;
	private static int highValue=20;
	private int stepCost;

	/**
	 * Initializes the world array and sets all values to high values. 
	 * Adds obstacles on all the outer edges of the array.
	 **/
	public World(int cost){
		stepCost = cost;
		worldArray = new Cell[7][10];
		robotArray = new Cell[7][10];
		
		for(int r = 0; r < 7; r++)
		{
			for(int c = 0; c < 10; c++)
			{
				worldArray[r][c] = new Cell(r, c);
				robotArray[r][c] = new Cell(r, c);
				worldArray[r][c].setInt(highValue);
				robotArray[r][c].setInt(highValue);
			}
		}

		//set boundaries 
		buildObstacle(0,0,6,0);
		buildObstacle(0,0,0,9);
		buildObstacle(6,0,6,9);
		buildObstacle(0,9,6,9);
		
		//buildObstacle(5,3,5,8);
		
		buildObstacle(1,3,4,3);
		buildObstacle(2,5,5,5);

		setEnd(5, 8);
	}
	
	public Cell getEndCell()
	{
		return endCell;
	}

	/**
	 * Calculates the distance the robot will have to move
	 * @param toMove the number of cells the robot is going to cross
	 * @return the actual distance needed to move
	 **/
	public double cellDistance(int toMove)
	{
		return (toMove * cellWidth);
	}
	
	/**
	 * Set the goal and other cell’s distance from the goal state
	 * @param x the x-coordinate of the goal
	 * @param y the y-coordinate of the goal
	 **/
	public void setEnd(int x, int y)
	{
		if(x>0 && x<6 && y>0 && y<9)
		{	
			worldArray[x][y].setInt(0);
			robotArray[x][y].setInt(0);
			endCell = worldArray[x][y];
			robotEndCell = robotArray[x][y];
			//setStepsFromGoal(worldArray[x][y]);
		}
	}

	/**
	 * Checks the cells above, below, left and right of the current cell, with the current
	 * cell stating as the goal state.  If the cell is not a wall and does not already have a 
	 * smaller value than the one we want to change it to, change the value of the cell to 
	 * the current cell's value plus one, then add it to the frontier to have the same process 
	 * performed on it.  This is an implementation of breadth-first search.
	 **/
	public void setStepsFromGoal(Cell c)
	{
		Vector<Cell> frontier = new Vector<Cell>();
		frontier.addElement(c);
		
		while(!frontier.isEmpty())
		{
			Cell checkCell = frontier.elementAt(0);
			frontier.removeElementAt(0);
			
			// Check cell to the left
			if(checkCell.getX()-1 >=0 && checkCell.getInt()+1<worldArray[checkCell.getX()-1][checkCell.getY()].getInt()&&!isWall(worldArray[checkCell.getX()-1][checkCell.getY()])){
				frontier.addElement(worldArray[checkCell.getX()-1][checkCell.getY()]);
				worldArray[checkCell.getX()-1][checkCell.getY()].setInt(calculateScore(checkCell, worldArray[checkCell.getX()-1][checkCell.getY()]));
			}
			
			// Check cell above
			if(checkCell.getY()-1 >=0 && checkCell.getInt()+1<worldArray[checkCell.getX()][checkCell.getY()-1].getInt()&&!isWall(worldArray[checkCell.getX()][checkCell.getY()-1])){
				frontier.addElement(worldArray[checkCell.getX()][checkCell.getY()-1]);
				worldArray[checkCell.getX()][checkCell.getY()-1].setInt(calculateScore(checkCell, worldArray[checkCell.getX()][checkCell.getY()-1]));
			}
			
			// Check cell to the right
			if(checkCell.getX() +1 < 6 && checkCell.getInt()+1<worldArray[checkCell.getX()+1][checkCell.getY()].getInt()&&!isWall(worldArray[checkCell.getX()+1][checkCell.getY()])){
				frontier.addElement(worldArray[checkCell.getX()+1][checkCell.getY()]);
				worldArray[checkCell.getX()+1][checkCell.getY()].setInt(calculateScore(checkCell, worldArray[checkCell.getX()+1][checkCell.getY()]));
			}
			
			// Check cell below
			if(checkCell.getY()+1< 9 && checkCell.getInt()+1<worldArray[checkCell.getX()][checkCell.getY()+1].getInt()&&!isWall(worldArray[checkCell.getX()][checkCell.getY()+1])){
				frontier.addElement(worldArray[checkCell.getX()][checkCell.getY()+1]);
				worldArray[checkCell.getX()][checkCell.getY()+1].setInt(calculateScore(checkCell, worldArray[checkCell.getX()][checkCell.getY()+1]));

			}
		}
	}
	
	public void setRobotStepsFromGoal(Cell c)
	{
		resetRobotWorld();
		Vector<Cell> frontier = new Vector<Cell>();
		frontier.addElement(c);
		
		while(!frontier.isEmpty())
		{
			Cell checkCell = frontier.elementAt(0);
			frontier.removeElementAt(0);
			
			// Check cell to the left
			if(checkCell.getX()-1 >=0 && checkCell.getInt()+1<robotArray[checkCell.getX()-1][checkCell.getY()].getInt()&&!isWall(robotArray[checkCell.getX()-1][checkCell.getY()])){
				frontier.addElement(robotArray[checkCell.getX()-1][checkCell.getY()]);
				robotArray[checkCell.getX()-1][checkCell.getY()].setInt(calculateScore(checkCell, robotArray[checkCell.getX()-1][checkCell.getY()]));
			}
			
			// Check cell above
			if(checkCell.getY()-1 >=0 && checkCell.getInt()+1<robotArray[checkCell.getX()][checkCell.getY()-1].getInt()&&!isWall(robotArray[checkCell.getX()][checkCell.getY()-1])){
				frontier.addElement(robotArray[checkCell.getX()][checkCell.getY()-1]);
				robotArray[checkCell.getX()][checkCell.getY()-1].setInt(calculateScore(checkCell, robotArray[checkCell.getX()][checkCell.getY()-1]));
			}
			
			// Check cell to the right
			if(checkCell.getX() +1 < 6 && checkCell.getInt()+1<robotArray[checkCell.getX()+1][checkCell.getY()].getInt()&&!isWall(robotArray[checkCell.getX()+1][checkCell.getY()])){
				frontier.addElement(robotArray[checkCell.getX()+1][checkCell.getY()]);
				robotArray[checkCell.getX()+1][checkCell.getY()].setInt(calculateScore(checkCell, robotArray[checkCell.getX()+1][checkCell.getY()]));
			}
			
			// Check cell below
			if(checkCell.getY()+1< 9 && checkCell.getInt()+1<robotArray[checkCell.getX()][checkCell.getY()+1].getInt()&&!isWall(robotArray[checkCell.getX()][checkCell.getY()+1])){
				frontier.addElement(robotArray[checkCell.getX()][checkCell.getY()+1]);
				robotArray[checkCell.getX()][checkCell.getY()+1].setInt(calculateScore(checkCell, robotArray[checkCell.getX()][checkCell.getY()+1]));

			}
		}
	}
	
	public int calculateScore(Cell current, Cell next)
	{
		return current.getInt()-current.getHeuristic()+stepCost+next.getHeuristic();
	}
	
	//NEW
	public void setCellHeuristic()
	{
		for(int i=1; i<6; ++i)
		{
			for(int j=1; j<9; ++j)
			{
				if(worldArray[i][j].getInt()!= -1){
					worldArray[i][j].setInt(0);
					worldArray[i][j].setHeuristic(getManhattanDistance(worldArray[i][j], endCell));
				}
			}
		}
	}
	
	//NEW
	public int getManhattanDistance(Cell current, Cell goal)
	{
		System.out.println((Math.abs(goal.getX()-current.getX()))+Math.abs(goal.getY()-current.getY()));
		return (Math.abs(goal.getX()-current.getX()))+Math.abs(goal.getY()-current.getY());
	}

	/**
	 * Sets the positions of the obstacles. Uses the top left of the array as (0, 0).
	 * @param x1 the x-coordinate of the start of the obstacle
	 * @param y1 the y-coordinate of the start of the obstacle
	 * @param x2 the x-coordinate of the end of the obstacle
	 * @param y2 the y-coordinate of the end of the obstacle
	 **/
	public void buildObstacle(int x1, int y1, int x2, int y2)
	{
		for(int i=x1; i<=x2; ++i)
		{
			for(int j=y1; j<=y2; ++j)
			{
				worldArray[i][j].setInt(-1);
			}
		}
	}

	/**
	 * Resets the game.
	 **/
	public void reset(){
		worldArray = new Cell[7][10];

		for(int r = 0; r < 7; r++){
			for(int c = 0; c < 10; c++){
				worldArray[r][c] = new Cell(r, c);
				worldArray[r][c].setInt(20);
		
			}
		}

		//set boundaries 
		buildObstacle(0, 0, 0, 6);
		buildObstacle(0,0,9,0);
		buildObstacle(0,6,9,6);
		buildObstacle(9,0,9,6);

		setEnd(5, 8);
	}
	
	public void resetRobotWorld()
	{
		for(int r = 0; r < 7; r++){
			for(int c = 0; c < 10; c++){
				if(!isWall(robotArray[r][c]))
					robotArray[r][c].setInt(20);
		
			}
		}
		robotEndCell.setInt(0);
	}
	
	/**
	 * Checks if the robot has reached the goal.
	 * @param c the cell that may be the goal cell
	 * @return true if c is the goal cell, false otherwise
	 **/
	public boolean reachGoal(Cell c){
		if(c.getX()==endCell.getX() && c.getY()==endCell.getY())
			return true;
		else
			return false;
	}

	/**
	 * Checks if a cell is a wall.
	 * @param c the cell that may be a wall
	 * @return true if c is a wall, false otherwise
	 **/
	public boolean isWall(Cell c){
		if(c.getInt()==-1)
			return true;
		else
			return false;
	}
	
	public void updateRobotWorld(Cell c)
	{
		System.out.println(c.getX() + " " + c.getY());
		if(isWall(worldArray[c.getX()+1][c.getY()]))
			robotArray[c.getX()+1][c.getY()].setInt(-1);
				
		if(isWall(worldArray[c.getX()-1][c.getY()]))
			robotArray[c.getX()-1][c.getY()].setInt(-1);
		
		if(isWall(worldArray[c.getX()][c.getY()+1]))
			robotArray[c.getX()][c.getY()+1].setInt(-1);
		
		if(isWall(worldArray[c.getX()][c.getY()-1]))
			robotArray[c.getX()][c.getY()-1].setInt(-1);
	}

	/**
	 * Checks if a cell has not been given a steps-from-goal number.
	 * @param c the cell that may have a high value
	 * @return true if c contains a high value, false otherwise
	 */
	public boolean checkHighValueCell(Cell c){
		if(c.getInt()==highValue)
			return true;
		else
			return false;
	}
	
	/**
	 * Returns the world to the robot for finding a path to the goal.
	 * @return worldArray the array containing the walls and steps to the goal
	 */
	public Cell[][] getWorldArray(){
		return worldArray;
	}
	
	public Cell[][] getRobotArray()
	{
		return robotArray;
	}
}
		
