package uk.ac.hw.macs.search.example;

import uk.ac.hw.macs.search.Node;
import uk.ac.hw.macs.search.SearchOrder;
import uk.ac.hw.macs.search.SearchProblem;

/**
 * Demonstrates how to use the provided classes.
 */
public class Main 
{
	//Function to add new child of the parent node
	private static Node addChild(int value, boolean goal, Node parent) 
	{
		//Creating the Node to store the details of the child node
		Node child = new Node(new IntState(value, goal));
		//Calling the function in the node class to add the child into the list.
		parent.addChild(child, 1);
		//Returning the child node created here
		return child;
	}
	//Main child
	public static void main(String[] args) 
	{
		
		//Creating the new states for the search problem
		//State 1 - as a root node
		Node root = new Node(new IntState(0));
		//State 2 - as a goal node
		Node goal = new Node(new IntState(5, true));
		//Creating child node where parent is the root node
		//State 3
		Node child = addChild(1, false, root);
		//Adding new child node to the state 3
		//State - 4
		child = addChild(2, false, child);
		//Adding new child node to the state 4
		//State - 5
		child = addChild(3, false, child);
		//Adding new child node to the state 5
		//State - 6
		addChild(4, false, child);

		//Adding the goal node as a child of root node
		root.addChild(goal, 1);

		//Creating the object of the BreadthFirstSearchOrderClass
		SearchOrder order = new BreadthFirstSearchOrder();
		//Creating the object of the SearchProrblem Class by passing order object created above.
		SearchProblem problem = new SearchProblem(order);
		//Prforming the search from the root node
		problem.doSearch(root);
	}
}
