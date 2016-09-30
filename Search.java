import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;


public abstract class Search
{

	public static LinkedList<Node> BFS(HashMap<Integer, Node> graph, Node start, Node goal)
	{
		HashMap<Node,Boolean> visited = new HashMap<Node, Boolean>();
		HashMap<Node,Node> previous = new HashMap<Node, Node>();
		
		LinkedList<Node> directions = new LinkedList<Node>();
		LinkedList<Node> Q = new LinkedList<Node>();
//		Vector<Node> V = new Vector<Node>();
		Node current = start;
		Q.add(current);
//		V.add(start);
		
		visited.put(current, true);
		
		while(!(Q.isEmpty()))
		{
			current = Q.remove();

			if(current.equals(goal))
				break;
			else
			{
				for(int i = 0; i < current.adjacencyList.size(); i++)
				{
//					String str = current.adjacencyList.get(i).label;
					if (!(visited.containsKey(current.adjacencyList.get(i))))
					{
						Q.add(current.adjacencyList.get(i));
						visited.put(current.adjacencyList.get(i), true);
						previous.put(current.adjacencyList.get(i), current);

					}
					
				}
			}
			
			
			
		}
		if (!current.equals(goal))
		{
			System.out.println("CANT REACH THE DESTINATION");
			return null;
		}


		for(Node node = goal; node != null; node = previous.get(node))
		{
			directions.add(node);
		}
		Collections.reverse((List<?>) directions.clone());
		directions.removeFirst();
		directions.removeLast();
		return directions;
	}
	
	
	
}
