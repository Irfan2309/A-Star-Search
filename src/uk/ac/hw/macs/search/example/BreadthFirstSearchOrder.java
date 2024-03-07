package uk.ac.hw.macs.search.example;

import java.util.List;
import java.util.Set;

import uk.ac.hw.macs.search.ChildWithCost;
import uk.ac.hw.macs.search.FringeNode;
import uk.ac.hw.macs.search.SearchOrder;

/**
 * A simple search order that adds all nodes to the end of the fringe.
 */
public class BreadthFirstSearchOrder implements SearchOrder 
{

	@Override
	public void addToFringe(List<FringeNode> frontier, FringeNode parent, Set<ChildWithCost> children) 
	{
		//Accessing all the children of the list came as parameter
		for (ChildWithCost child : children) 
		{
			//Adding the object of FringeNode into the list
			frontier.add(new FringeNode(child.node, parent, child.cost));
		}
	}

}