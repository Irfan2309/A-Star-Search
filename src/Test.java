import java.util.Set;

import uk.ac.hw.macs.search.*;
import uk.ac.hw.macs.search.example.IntState;
public class Test 
{
	public static void main(String[] args) 
	{ 
		Node[][] arr = new Node[4][6];
		int hu[][] = {{4,4,2,2,1,2},{3,2,1,1,1,1},{2,1,1,1,0,1},{3,2,1,1,1,2}};
		int ch = 65;
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<6;j++)
			{
//				arr[i][j] = new Node(new SearchState((char)ch,hu[i][j]));
				ch++;
			}
		}
		((SearchState) arr[2][4].getValue()).setGoal(true);
		
		
		
		int[][] cost = {{1,3,1,1,1,1},{1,3,1,1,-1,1},{1,1,-1,-1,1,1},{1,1,3,3,1,1}};
		
		int arr1[][] = {{0,-1},{0,1},{1,0},{-1,0}};
		
		
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<6;j++)
			{
				System.out.println("=======================================");
				System.out.println("Value is : "+((SearchState)arr[i][j].getValue()).getStateName()); 
				for(int k=0;k<4;k++)
				{
					if(!(i + arr1[k][0]<0) && !(j+ arr1[k][1]<0) && !(i + arr1[k][0]>3) && !(j+ arr1[k][1]>5) )
					{
						System.out.println(((SearchState)arr[i+ arr1[k][0]][j+ arr1[k][1]].getValue()).getStateName());
						arr[i][j].addChild(arr[i+ arr1[k][0]][j+ arr1[k][1]], cost[i][j]);
					}
				}
			}	
		}
	}
}