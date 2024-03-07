package uk.ac.hw.macs.search.example;

import uk.ac.hw.macs.search.State;

/**
 * A simple state representing integers.
 */
public class IntState implements State 
{
	//Variable to store the value of the state
	private int value;
	//Variable to store the whether the state is goal or not
	private boolean goal;
	
	//Constructor to set value of variables
	public IntState (int value) 
	{
		this(value, false);
	}

	//Constructor to set value of variables
	public IntState (int value, boolean goal) 
	{
		this.value = value;
		this.goal = goal;
	}

	@Override
	public boolean isGoal() {
		return this.goal;
	}

	@Override
	public int getHeuristic() {
		return 0;
	}

	@Override
	public String toString() 
	{
		return "IntegerState [value=" + value + ", goal=" + goal + "]";
	}
	
}
