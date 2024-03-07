package uk.ac.hw.macs.search;
import java.util.List;
import java.util.Set;

class AStarSearchOrder implements SearchOrder
{

	//Overriding function to add states into the fringe.
	@Override
	public void addToFringe(List<FringeNode> frontier, FringeNode parent, Set<ChildWithCost> children) 
	{
		//Running the loop for all the children came as parameter
		for(ChildWithCost child: children)
		{
			//Creating new object of class to FringeNode to ass in the fringe.
			FringeNode node = new FringeNode(child.node,parent,child.cost);
			//Checking if the cost of the moving to child is less than 0 or not
			//If the cost is less than 0 then it is a wall and we cannot move through that
			if(child.cost<0)
			{
				//So, we will use continue keyword to not add that child in the list.
				continue;
			}
			else
			{
				//If the cost is not less than 0 then we can move to that child.
				//Checking the list is empty or not.
				if(frontier.isEmpty())
				{
					//If the list is empty adding the node in the front
					frontier.add(node);
				}
				else
				{
					//if the list is not empty then, first we are taking the size of the list
					int size = frontier.size();
					//We are running for here so that we can add the node at the appropriate place
					for(int i=0;i<size;i++)
					{
						//If the f value of the new node is less than the value at specific place then we will add it this place  
						if(node.getFValue()<=frontier.get(i).getFValue())
						{					
							//Adding the node at place i
							frontier.add(i,node);
						}
						//Breaking the loop after we add the node.
						break;
					}
					//if the value of the node is largest then we add it at the end
					frontier.add(size-1,node);
				}
			}
		}
	}
}