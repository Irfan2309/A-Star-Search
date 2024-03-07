package uk.ac.hw.macs.search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Represents a search problem, by running the given search order on given search spaces.
 */
public class SearchProblem 
{
	//Variable to store the object of Search Order
	private SearchOrder searchOrder;
	//Constructor of the class
	public SearchProblem(SearchOrder searchOrder) 
	{
		this.searchOrder = searchOrder;
	}

	/**
	 * Runs the given search order on the given search space, and prints the result.
	 * 
	 * @param root The root note of the search space (the starting state)
	 * @return True if the search finds a goal state, and false if it does not
	 */
	public boolean doSearch(Node root) 
	{
		//Creating the linked list of type Frinde Node
		List<FringeNode> fringe = new LinkedList();
		//Adding root node into the fringe
		fringe.add(new FringeNode(root, null, 0));
		//Creating the hashset for the visited states
		Set<Node> visitedStates = new HashSet();
		//Creating the object for the goal state	
		FringeNode goalNode = null;
		
		//Running while loop for infinite times
		while (true) 
		{
			//If the fringe is empty then the goal state is not found
			if (fringe.isEmpty()) 
			{
				//So, breaking the loop
				break;
			}
			
			//Removing the first node in the list and storing it in object
			FringeNode searchNode = fringe.remove(0);
			//Printing the current node
			System.out.println("Current node: " + searchNode);
			
			//If the current node is already visited then continuing the loop
			if (visitedStates.contains(searchNode.node)) 
			{
				continue;
			}
			
			//Checking the current state is  the goal state or not
			if (searchNode.node.isGoal()) 
			{
				//If it is a goal state then assigning the value to goalNode
				goalNode = searchNode;
				//Breaking the loop
				break;
			}
			
			//Else we are expanding the current node and adding it into the fringe
			searchOrder.addToFringe(fringe, searchNode, searchNode.node.getChildren());
			//Adding the node into the visited list
			visitedStates.add(searchNode.node);
		}
		
		//Checking is the goal node is null or not
		if (goalNode == null) 
		{
			//If the goal node is null then printing
			System.out.println("No goal found");
			//returning false
			return false;
		} 
		else 
		{
			//Else printing the details
			System.out.println("Found goal node: " + goalNode.node);
			System.out.println("Cost: " + goalNode.gValue);
			System.out.println("Nodes expanded: " + visitedStates.size());
			System.out.println("Path to root:");
			//Printing the path
			//Creating the node storing the goal node
			FringeNode fnode = goalNode;
			//Running loop till it reaches goal node
			while (fnode != null) 
			{
				//Printing the value of the node
				System.out.println("- node: " + fnode.node.getValue());
				//Checking the value to its parent
				fnode = fnode.parent;
			}
			//Returning true
			return true;
		}

	}

}