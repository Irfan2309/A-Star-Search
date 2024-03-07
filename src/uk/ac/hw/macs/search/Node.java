package uk.ac.hw.macs.search;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a single node in the search space: it has a value, as well as a set of child nodes with associated
 * costs on the transitions.
 */
public class Node 
{
	//Storing the object of State interface
	private State value;
	//Set of all the object of children with cost class
	private Set<ChildWithCost> children;
	
	//Costructor of the class
	public Node(State value) 
	{
		//Setting the value
		this.value = value;
		//Initializing the HashSet
		this.children = new HashSet<>();
	}
	
	//Function to create object and then add it into the set
	public boolean addChild(Node child, int cost) 
	{
		//Returning true if the value is added else false
		
		return children.add(new ChildWithCost(child, cost));
	}
	
	//Returning the set of all the children
	public Set<ChildWithCost> getChildren() 
	{
		return children;
	}
	
	//Returning the object of state interface
	public State getValue() 
	{
		return value;
	}
	
	//Returning true if the node is the goal node
	public boolean isGoal() 
	{
		return value.isGoal();
	}

	@Override
	public String toString() 
	{
		return "Node [value=" + value + "]";
	}
}
