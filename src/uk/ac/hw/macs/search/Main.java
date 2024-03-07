package uk.ac.hw.macs.search;

public class Main 
{
	//Declaring function to add all the children of the specific state.
	public static void addChildren(Node[][] grid,int rows, int cols,int cost[][])
	{
		//Creating the 2D array for all the possible moves.
		int allMoves[][] = {{0,-1},{0,1},{1,0},{-1,0}};
		//Running for loop for the rows
		for(int i=0;i<rows;i++)
		{
			//Running for loop for the columns
			for(int j=0;j<cols;j++)
			{
				//Running for loop for all the values of the moves
				for(int k=0;k<4;k++)
				{
					//Checking whether the value is negative or not or the value is not higher than the possible values.
					if(!(i + allMoves[k][0]<0) && !(j+ allMoves[k][1]<0) && !(i + allMoves[k][0]>(rows-1)) && !(j+ allMoves[k][1]>(cols-1)) )
					{
						//Calling the add child function of node class to add child in set of children 
						grid[i][j].addChild(grid[i+ allMoves[k][0]][j+ allMoves[k][1]],cost[i+ allMoves[k][0]][j + allMoves[k][1]]);
					}
				}
			}	
		}
	}
	
	//Declaring function to initialize grid with Node objects
	public static Node[][] createGrid(Node[][] grid,int rows, int cols,int cost[][],int xGoal,int yGoal) 
	{
		//Declaring variable to store the ASCII value of state name 
		int ch = 65;
		//Running for loop for the rows
		for(int i=0;i<rows;i++)
		{
			//Running for loop for the columns
			for(int j=0;j<cols;j++)
			{
				//Creating the object of Node class and assigning it to specific location in grid
				grid[i][j] = new Node(new SearchState((char)ch,false,i,j,xGoal,yGoal));
				//Incrementing the character
				ch++;
			}
		}
		//Setting the goal state of the grid by accessing the object
		((SearchState) grid[xGoal][yGoal].getValue()).setGoal(true);
		
		//Calling function to add all the children
		addChildren(grid,rows,cols,cost);
		
		//Returning the created grid
		return grid;
	}
	
	public static void main(String[] args) 
	{
		Node[][] grid = new Node[4][6];
		int[][] cost = {{1,3,1,1,1,1},{1,3,1,1,-1,1},{1,1,-1,-1,1,1},{1,1,3,3,1,1}};
		int xGoal = 2;
		int yGoal = 4;
		grid = createGrid(grid,4,6,cost,xGoal,yGoal);
		
		//Creating 2D array for the grid
//		Node[][] grid = new Node[4][6];
		
		//Creating 2D array for the cost of each state.
//		int[][] cost = {{1,1,1,1,1,1},{3,-1,-1,-1,3,1},{1,3,-1,1,1,3},{1,3,3,1,1,1}};
		//Declaring variable to store the x Coordinate of the goal 
//		int xGoal = 3;
//		Declaring variable to store the y Coordinate of the goal
//		int yGoal = 3;
		
		//Calling function to create the grid by adding all the values of each state
//		grid = createGrid(grid,4,6,cost,xGoal,yGoal);
		
		//Creating object of A* search class.
		SearchOrder order = new AStarSearchOrder();
		//Creating object of SearchProblem class and passing the above object.
		SearchProblem problem = new SearchProblem(order);
		
		//Performing the search on grid with starting value as 0,0 which is initial state
		problem.doSearch(grid[0][0]);
		
	}

}
