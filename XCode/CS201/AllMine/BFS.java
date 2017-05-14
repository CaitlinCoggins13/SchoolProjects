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
System.out.println("X: " +frontierCell.getX()+ " Y: " +frontierCell.getY());
if(maze.reachGoal(frontierCell))
{
System.out.println("You are at the goal!");
getCellPath(frontierCell);
}
else
{
// The reachable state with the lowest value is chosen as the goal state.
checkMinimum(frontierCell);
bfsIterative();
}
frontierCell.setColorBlack();
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
bfsStack.add(worldArray[x-1][y]);
}

// Cell above
if(x+1<=5&& !worldArray[x+1][y].isBlack() &&!isWall(worldArray[x+1][y])){
worldArray[x+1][y].setColorGray();
bfsStack.add(worldArray[x+1][y]);
}

// Cell to the left
if(y-1>=1&& !worldArray[x][y-1].isBlack() &&!isWall(worldArray[x][y-1])){
worldArray[x][y-1].setColorGray();
bfsStack.add(worldArray[x][y-1]);
}

// Cell to the right
if(y+1<=8&& !worldArray[x][y+1].isBlack() &&!isWall(worldArray[x][y+1])){
worldArray[x][y+1].setColorGray();
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
System.out.println("X: " +frontierCell.getX()+ " Y: " +frontierCell.getY());
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
/**for(int i=0; i<7; ++i)
 {
 for(int j=0; j<10; ++j)
 {
 System.out.print(robotArray[i][j].getInt() +" ");
 }
 System.out.println();
 }
 try {
 Thread.sleep(2000);
 } catch (InterruptedException e) {
 // TODO Auto-generated catch block
 e.printStackTrace();
 }**/
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