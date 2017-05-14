import java.util.PriorityQueue;
import java.util.Stack;

//import lejos.nxt.Motor;
//import lejos.robotics.navigation.DifferentialPilot;

public class Robot 
{
	private World maze;
	private Cell[][] worldArray;
	private Cell[][] robotArray;
	private PriorityQueue<Cell> bfsStack;
	private PriorityQueue<Cell> bfsPQ;
	private Stack<Cell> dfsStack;
	private Stack<Cell> moveStack;
	private PriorityQueue<Cell> frontier;
	private Cell startCell;
	private Cell endCell;
	private int blackCells = 0;
	private int grayCells = 0;
	private int orientation = 0;		// An orientation of 0 means the robot is facing right.
	//DifferentialPilot myRobot;
	private int countSteps = 1;
	
	/**
	 * Initializes all stacks, queues, and the World object.
	 * Sets the starting location of the robot.
	 **/
	public Robot()
	{
		bfsStack = new PriorityQueue<Cell>();
		dfsStack = new Stack<Cell>();
		moveStack = new Stack<Cell>();
		bfsPQ = new PriorityQueue<Cell>();
		frontier = new PriorityQueue<Cell>();
		maze = new World(1);
		worldArray = maze.getWorldArray();
		robotArray = maze.getRobotArray();
		// myRobot = new DifferentialPilot(2.1f, 4.4f, Motor.A, Motor.C, true);
		setStart(worldArray, 1,1);
		endCell = maze.getEndCell();
	}
	
	/**
	 * Sets the start position of the robot.  
	 * @param c cell array
	 * @param x x-position
	 * @param y y-position
	 **/
	public void setStart(Cell[][] c, int x, int y)
	{
		startCell = c[x][y];
	}
		
	/**
	 * Starts the depth-first search for a path to the goal.
	 **/
	public void bestFirstSearchPerfectKnowledge()
	{
		bfsStack.add(startCell);
		startCell.setColorGray();
		maze.setStepsFromGoal(endCell);
		bfsIterative();
	}
	
	/**
	 * Finds a path to the goal through a depth-first search.  The cell with the lowest
	 * value is always chosen first, as this means the robot will be moving closer to the goal.
	 **/
	public void bfsIterative()
	{
		Cell frontierCell = (Cell) bfsStack.poll();

		if(maze.reachGoal(frontierCell))
		{
			System.out.println("You are at the goal!");
			getCellPath(frontierCell);
		}
		else
		{
			// The reachable state with the lowest value is chosen as the goal state.
			checkMinimum(frontierCell);
			frontierCell.setColorBlack();
			++blackCells;
			bfsIterative();	
		}
	}
	
	/**
	 * Adds all cells to the best-first search queue.
	 * @param c the current cell
	 **/
	public void checkMinimum(Cell c)
	{
		int x = c.getX();
		int y = c.getY();
		
		// Cell below
		if(x-1>=1&& !worldArray[x-1][y].isBlack() && !isWall(worldArray[x-1][y])){
			worldArray[x-1][y].setColorGray();
			++grayCells;
			bfsStack.add(worldArray[x-1][y]);
		}
		
		// Cell above
		if(x+1<=5&& !worldArray[x+1][y].isBlack() &&!isWall(worldArray[x+1][y])){
			worldArray[x+1][y].setColorGray();
			++grayCells;
			bfsStack.add(worldArray[x+1][y]);
		}
		
		// Cell to the left
		if(y-1>=1&& !worldArray[x][y-1].isBlack() &&!isWall(worldArray[x][y-1])){
			worldArray[x][y-1].setColorGray();
			++grayCells;
			bfsStack.add(worldArray[x][y-1]);
		}
		
		// Cell to the right
		if(y+1<=8&& !worldArray[x][y+1].isBlack() &&!isWall(worldArray[x][y+1])){
			worldArray[x][y+1].setColorGray(); 
			++grayCells;
			bfsStack.add(worldArray[x][y+1]);
		}
		bfsStack.peek().setParent(c);
	}
	
	/**
	 * Starts the best-first search with non-perfect world knowledge.
	 **/
	public void bestFirstSearchNonperfectWorldKnowledge()
	{
		bfsPQ.add(startCell);
		startCell.setColorGray();
		bfsNPIterative();
	}
	
	/**
	 * Runs the recursive best-first search with non-perfect world knowledge.
	 * 
	 **/
	public void bfsNPIterative() 
	{
		Cell frontierCell = (Cell) bfsPQ.poll();
		
		if(maze.reachGoal(frontierCell))
		{
			System.out.println("You are at the goal!");
			// Gets the path that the robot will move to the goal.
			getCellPath(frontierCell);
		}
		else
		{	
			// Updates what the robot knows about the world.
			maze.updateRobotWorld(frontierCell);
			// Updates the number of steps the robot is from the goal with the new map.
			maze.setRobotStepsFromGoal(endCell);
			// Adds the new frontier cells.
			checkMinimumNP(frontierCell);
			blackCells++;
			frontierCell.setColorBlack();
			bfsNPIterative();
		}
		//blackCells++;
		//frontierCell.setColorBlack();
	}
	
	/**
	 * 
	 * @param c
	 **/
	public void checkMinimumNP(Cell c)
	{
		int x = c.getX();
		int y = c.getY();
		
		// Cell below
		if(x-1>=1&& !robotArray[x-1][y].isBlack() &&!isWall(robotArray[x-1][y])){
			grayCells++;
			robotArray[x-1][y].setColorGray();
			bfsPQ.add(robotArray[x-1][y]);
		}
		
		// Cell above
		if(x+1<=5&& !robotArray[x+1][y].isBlack() &&!isWall(robotArray[x+1][y])){
			grayCells++;
			robotArray[x+1][y].setColorGray();
			bfsPQ.add(robotArray[x+1][y]);
		}
		
		// Cell to the left
		if(y-1>=1&& !robotArray[x][y-1].isBlack() && !isWall(robotArray[x][y-1])){
			grayCells++;
			robotArray[x][y-1].setColorGray();
			bfsPQ.add(robotArray[x][y-1]);
		}
		
		// Cell to the right
		if(y+1<=8&& !robotArray[x][y+1].isBlack() && !isWall(robotArray[x][y+1])){
			grayCells++;
			robotArray[x][y+1].setColorGray(); 
			bfsPQ.add(robotArray[x][y+1]);
		}
		
		bfsPQ.peek().setParent(c);
	}
	
	/**
	 * Starts the depth-first search.
	 **/
	public void depthFirstSearch()
	{
		dfsStack.push(startCell);
		startCell.setColorGray();
		dfsIterative();
	}
	
	/**
	 * 
	 **/
	public void dfsIterative()
	{
		Cell frontierCell = (Cell) dfsStack.pop();
		frontierCell.setColorBlack();
		blackCells++;
		if(maze.reachGoal(frontierCell))
		{
			System.out.println("You are at the goal!");
			//System.out.println("X: "+frontierCell.getX()+" Y: "+frontierCell.getY());
			getCellPath(frontierCell);
		}
		else
		{
			// The reachable state with the lowest value is chosen as the goal state.
			checkDirection(frontierCell);
		}
	}
	
	/**
	 * 
	 * @param c
	 **/
	public void checkDirection(Cell c)
	{
		int x = c.getX();
		int y = c.getY();
		
		// Cell below
		if(x-1>=1&& !worldArray[x-1][y].isBlack() &&!isWall(worldArray[x-1][y])){
			grayCells++;
			worldArray[x-1][y].setColorGray();
			worldArray[x-1][y].setParent(c);
			dfsStack.push(worldArray[x-1][y]);
			dfsIterative();	
		}
		
		// Cell above
		if(x+1<=5&& !worldArray[x+1][y].isBlack() && !isWall(worldArray[x+1][y])){
			grayCells++;
			worldArray[x+1][y].setColorGray();
			worldArray[x+1][y].setParent(c);
			dfsStack.push(worldArray[x+1][y]);
			dfsIterative();	
		}
		
		// Cell to the left
		if(y-1>=1&& !worldArray[x][y-1].isBlack() &&!isWall(worldArray[x][y-1])){
			grayCells++;
			worldArray[x][y-1].setColorGray();
			worldArray[x][y-1].setParent(c);
			dfsStack.push(worldArray[x][y-1]);
			dfsIterative();	
		}
		
		// Cell to the right
		if(y+1<=8&& !worldArray[x][y+1].isBlack() &&!isWall(worldArray[x][y+1])){
			grayCells++;
			worldArray[x][y+1].setColorGray(); 
			worldArray[x][y+1].setParent(c);
			dfsStack.push(worldArray[x][y+1]);
			dfsIterative();	
		}
	}
	
	public void AStarSearch(int stepCost){
		maze.setCellHeuristic();
		frontier.add(startCell);
		AStarIterative(stepCost);
	}
	
	public void AStarIterative(int stepCost)
	{
			Cell checkCell = frontier.poll();

			if(maze.reachGoal(checkCell))
			{
				System.out.println("You are at the goal!");
				getCellPath(checkCell);
			}
			else
			{
				//checkCell.setInt(checkCell.getInt()+stepCost);
				// Check cell to the left
				if(checkCell.getX()-1 >=0 &&!worldArray[checkCell.getX()-1][checkCell.getY()].isBlack() &&!isWall(worldArray[checkCell.getX()-1][checkCell.getY()])){
					frontier.add(worldArray[checkCell.getX()-1][checkCell.getY()]);
					grayCells++;
					worldArray[checkCell.getX()-1][checkCell.getY()].setColorGray(); 
					worldArray[checkCell.getX()-1][checkCell.getY()].setG(checkCell.getG()+stepCost);
					worldArray[checkCell.getX()-1][checkCell.getY()].setParent(checkCell);
					worldArray[checkCell.getX()-1][checkCell.getY()].setInt(worldArray[checkCell.getX()-1][checkCell.getY()].getHeuristic()+worldArray[checkCell.getX()-1][checkCell.getY()].getG());
					System.out.println("X: "+worldArray[checkCell.getX()-1][checkCell.getY()].getX()+" Y: "+worldArray[checkCell.getX()-1][checkCell.getY()].getY()+" score: "+worldArray[checkCell.getX()-1][checkCell.getY()].getInt());

				}
				
				// Check cell above
				if(checkCell.getY()-1 >=0 &&!worldArray[checkCell.getX()][checkCell.getY()-1].isBlack()&&!isWall(worldArray[checkCell.getX()][checkCell.getY()-1])){
					frontier.add(worldArray[checkCell.getX()][checkCell.getY()-1]);
					worldArray[checkCell.getX()][checkCell.getY()-1].setColorGray(); 
					grayCells++;
					worldArray[checkCell.getX()][checkCell.getY()-1].setParent(checkCell);
					worldArray[checkCell.getX()][checkCell.getY()-1].setG(checkCell.getG()+stepCost);
					worldArray[checkCell.getX()][checkCell.getY()-1].setInt(worldArray[checkCell.getX()][checkCell.getY()-1].getHeuristic()+worldArray[checkCell.getX()][checkCell.getY()-1].getG());
					System.out.println("X: "+worldArray[checkCell.getX()][checkCell.getY()+1].getX()+" Y: "+worldArray[checkCell.getX()][checkCell.getY()+1].getY()+" score: "+worldArray[checkCell.getX()][checkCell.getY()+1].getInt());
				}
				
				// Check cell to the right
				if(checkCell.getX() +1 < 6 &&!worldArray[checkCell.getX()+1][checkCell.getY()].isBlack()&&!isWall(worldArray[checkCell.getX()+1][checkCell.getY()])){
					frontier.add(worldArray[checkCell.getX()+1][checkCell.getY()]);	
					grayCells++;
					worldArray[checkCell.getX()+1][checkCell.getY()].setColorGray(); 
					worldArray[checkCell.getX()+1][checkCell.getY()].setParent(checkCell);
					worldArray[checkCell.getX()+1][checkCell.getY()].setG(checkCell.getG()+stepCost);
					worldArray[checkCell.getX()+1][checkCell.getY()].setInt(worldArray[checkCell.getX()+1][checkCell.getY()].getHeuristic()+worldArray[checkCell.getX()+1][checkCell.getY()].getG());
					System.out.println("X: "+worldArray[checkCell.getX()-1][checkCell.getY()].getX()+" Y: "+worldArray[checkCell.getX()-1][checkCell.getY()].getY()+" score: "+worldArray[checkCell.getX()-1][checkCell.getY()].getInt());
				}
				
				// Check cell below
				if(checkCell.getY()+1< 9 &&!worldArray[checkCell.getX()][checkCell.getY()+1].isBlack()&&!isWall(worldArray[checkCell.getX()][checkCell.getY()+1])){
					frontier.add(worldArray[checkCell.getX()][checkCell.getY()+1]);
					worldArray[checkCell.getX()][checkCell.getY()+1].setColorGray(); 
					grayCells++;
					worldArray[checkCell.getX()][checkCell.getY()+1].setParent(checkCell);
					worldArray[checkCell.getX()][checkCell.getY()+1].setG(checkCell.getG()+stepCost);
					worldArray[checkCell.getX()][checkCell.getY()+1].setInt(worldArray[checkCell.getX()][checkCell.getY()+1].getHeuristic()+worldArray[checkCell.getX()][checkCell.getY()+1].getG());
				}
				checkCell.setInt(checkCell.getInt()+stepCost);
				//frontier.peek().setParent(checkCell);
				checkCell.setColorBlack();
				++blackCells;
				++countSteps;
				AStarIterative(stepCost);
			}
			
		}

	/**
	 * Checks if the robot reaches a wall.
	 **/
	public boolean isWall(Cell c)
	{
		if(c.getInt()==-1)
			return true;
		else
			return false;
	}
	
		
	/**
	 * Commands the robot to turn left and move forward, then updates the orientation.
	 **/
	public void turnLeft(){
		//myRobot.rotate(130);
		//myRobot.travel(-8);
		if(orientation < 3)
			orientation = (orientation +1 )%4;
		else
			orientation = 0;
	}
	
	/**
	 * Commands the robot to turn right and move forward, then updates the orientation.
	 **/
	public void turnRight(){
		//myRobot.rotate(-130);
		//myRobot.travel(-8);
		if(orientation > 0)
			orientation = (orientation -1 )%4;
		else
			orientation = 3;
	}
	
	/**
	 * Commands the robot to move forward.
	 **/
	public void forward(){
		//myRobot.travel(-8);
	}
	
	/**
	 * Commands the robot to move backward.
	 **/
	public void backward(){
		//myRobot.travel(8);
	}
	
	/**
	 * Creates a stack with the path the robot will travel in reverse order.
	 * @param c the goal cell
	 **/
	public void getCellPath(Cell c)
	{
		moveStack.push(c);
		if(c.equals(startCell))
		{
			moveRobot();
		}
		else
		{
			getCellPath(c.getParent());
		}
	}
	
	/**
	 * Pops new cells of the stack moveStack and moves the robot to those locations.
	 **/
	public void moveRobot()
	{
		int pathCells =1;
		Cell currentCell = moveStack.pop();
		while(!moveStack.isEmpty())
		{
			Cell c = moveStack.pop();
			++pathCells;
			System.out.println("X: " +c.getX()+ " Y: " +c.getY());
			int goalX = c.getX();
			int goalY = c.getY();
			// Figures out the direction the robot needs to move from the goal state 
					// and the current orientation of the robot.
					if(orientation == 0 )
					{
						if(goalX<currentCell.getX())
							turnLeft();
						else if(goalX>currentCell.getX())
							turnRight();
						else
						{
							if(goalY>currentCell.getY())
								forward();
							else
								backward();
						}
					}
					else if(orientation == 1 )
					{
						if(goalY<currentCell.getY())
							turnLeft();
						else if(goalY>currentCell.getY())
							turnRight();
						else
						{
							if(goalX<currentCell.getX())
								forward();
							else
								backward();
						}		
					}
					else if(orientation == 2 )
					{
						if(goalX>currentCell.getX())
							turnLeft();
						else if(goalX<currentCell.getX())
							turnRight();
						else
						{
							if(goalY<currentCell.getY())
								forward();
							else
								backward();
						}
					}
					else if(orientation == 3 )
					{
						if(goalY>currentCell.getY())
						{
							turnLeft();
						}
						else if(goalY<currentCell.getY())
							turnRight();
						else
						{
							if(goalX>currentCell.getX())
								forward();
							else
								backward();
						}
					}
					currentCell = c;
		}
		System.out.println("Black cells: "+blackCells);
		System.out.println("Gray cells: "+grayCells);
		System.out.println("Path length: "+pathCells);
	}
		
	/**
	 * Starts the program.
	 * @param args
	 */
	public static void main (String[]args)
	{
		Robot mazeRobot = new Robot();
		long startTime = System.nanoTime();
		mazeRobot.bestFirstSearchPerfectKnowledge();
		long endTime = System.nanoTime();
		System.out.println("Duration: "+((endTime - startTime)/1000000)+" ms"); 
		
		mazeRobot = new Robot();
		startTime = System.nanoTime();
		mazeRobot.bestFirstSearchNonperfectWorldKnowledge();
		endTime = System.nanoTime();
		System.out.println("Duration: "+((endTime - startTime)/1000000)+" ms"); 
		
		mazeRobot = new Robot();
		startTime = System.nanoTime();
		mazeRobot.depthFirstSearch();
		endTime = System.nanoTime();
		System.out.println("Duration: "+((endTime - startTime)/1000000)+" ms"); 
		
		mazeRobot = new Robot();
		startTime = System.nanoTime();
		mazeRobot.AStarSearch(1);
		endTime = System.nanoTime();
		System.out.println("Duration: "+((endTime - startTime)/1000000)+" ms"); 
		
		
	}
}

