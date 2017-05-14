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