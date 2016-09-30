import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;


public class Node 
{
    String label;
    ArrayList<Node> adjacencyList;
    
    Point coord;
    
    
    public Node(int x, int y)
    {
    	label = "x" + x + "y" +y;
    	coord = new Point(x,y);
    	adjacencyList = new ArrayList<Node>();
    	

    	
    }
    
    public void initAdjacency(HashMap<Integer, Node> graph)
    {
    	if(graph.containsKey(hashCode(coord.x-1, coord.y)))
    	{
    		if(Gameboard.matrix[coord.x-1][coord.y].state != State.BLOCKED)
    			adjacencyList.add(graph.get(hashCode(coord.x-1, coord.y)));
    	}
    		
    	if(graph.containsKey(hashCode(coord.x+1, coord.y)))
    	{
    		if(Gameboard.matrix[coord.x+1][coord.y].state != State.BLOCKED)
    			adjacencyList.add(graph.get(hashCode(coord.x+1, coord.y)));
    	}
    		
    	
    	if(graph.containsKey(hashCode(coord.x, coord.y-1)))
    	{
    		if(Gameboard.matrix[coord.x][coord.y-1].state != State.BLOCKED)
    			adjacencyList.add(graph.get(hashCode(coord.x, coord.y-1)));
    	}
    	
    	if(graph.containsKey(hashCode(coord.x, coord.y+1)))
    	{
    		if(Gameboard.matrix[coord.x][coord.y+1].state != State.BLOCKED)
        		adjacencyList.add(graph.get(hashCode(coord.x, coord.y+1)));
    	}

    	
    }
    
    public String toString()
    {
    	return label;
    }
    
    public int hashCode()
    {
    	int hash = 10000*coord.x + coord.y;
    	
    	return hash;
    }
    
    public int hashCode(int x, int y)
    {
    	int hash = 10000*x + y;
    	
    	return hash;
    }
    
}

