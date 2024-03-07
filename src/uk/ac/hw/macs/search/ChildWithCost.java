package uk.ac.hw.macs.search;

/**
 * Represents a connection in the state graph: a node, and the cost of getting from the parent to this node.
 */
public class ChildWithCost  
{
	//Creating the new node
	public final Node node;
	//Variable for storing the cost
	public final int cost;
	
	//Constructor to initialize value
	public ChildWithCost(Node child, int cost) 
	{
		this.node = child;
		this.cost = cost;
	}
	
}
