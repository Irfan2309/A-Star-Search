package uk.ac.hw.macs.search;

/**
 * Represents a state in the search space. You need to include a method for determining whether a state is a 
 * goal state, and one for computing the heuristic value.
 */
public interface State 
{
	//Functiont to check whether it is goal or not
	public boolean isGoal();
	//Function to return the heuristics
	public int getHeuristic();
}

