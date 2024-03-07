package uk.ac.hw.macs.search;
public class SearchState implements State
{
	//Declaring variable for state name
	private char stateName;
	//Declaring variable to store whether this state is goal state or not. 
	private boolean isGoal;
	//Declaring variable to store the heuristic value
	private int heuristicVal;

	//Constructor to set values
	public SearchState(char stateName,boolean isGoal,int xCord,int yCord, int xGoal, int yGoal ) 
	{
		this.stateName = stateName;
		this.heuristicVal = this.setheuristic(xCord, yCord, xGoal, yGoal);
		this.isGoal = isGoal;
	}
	
	//Declaring function to set the goals
	public void setGoal(boolean isGoal)
	{
		this.isGoal = isGoal;
	}
	
	//Declaring function to return the name of the state
	public char getStateName()
	{
		return this.stateName;
	}
	
	//Overriding the isGoal function to return whether this state is goal state or not.
	@Override
	public boolean isGoal() 
	{
		return this.isGoal;
	}

	//Declaring function to set the heuristic value 
	private int setheuristic(int xCord,int yCord, int xGoal, int yGoal)
	{
		//Calculating the value by subtracting the goal coordinates with the state coordinates and returning it 
		return (Math.abs(xGoal - xCord) + Math.abs(yGoal-yCord));
	}
	
	
	//Overriding the getHeuristic function to return the heuristic value.
	@Override
	public int getHeuristic() 
	{
		return this.heuristicVal;
	}

	@Override
	public String toString() 
	{
		return "State [value=" + stateName + "]";
	}
	
}
