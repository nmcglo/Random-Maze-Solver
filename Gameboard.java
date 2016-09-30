import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.JPanel;




public class Gameboard extends JPanel
{
	private static final long serialVersionUID = 1L;
	static gamespace[][] matrix;
	int gridScale;
	MouseInput mi;
	
	gamespace start;
	gamespace goal;
	
	HashMap<Integer, Node> graph = new HashMap<Integer, Node>();
	
	

	
	public Gameboard(int x, int y, int gridScaleParam)
	{
		gridScale = gridScaleParam;
		mi = new MouseInput(this);
		this.addMouseListener(mi);
		init(x,y);
		
		
	}
	
	
	public void init(int x, int y)
	{
		matrix = new gamespace[x][y];
		
		for(int i = 0; i < x; i++)
		{
			for(int j = 0; j < y; j++)
			{
				matrix[i][j] = new gamespace(i,j);
				Node node = new Node(i,j);
				graph.put(node.hashCode(), node);
				
			}	
		}
		createStart();
		createGoal();
		
		for (Node value : graph.values()) {
		    value.initAdjacency(graph);
		}
		
		Long startTime = System.currentTimeMillis();
		LinkedList<Node> directions = Search.BFS(graph, graph.get(start.hashCode()), graph.get(goal.hashCode()));
		Long endTime = System.currentTimeMillis();
		Long execTime = endTime - startTime;
		
		System.out.println(execTime);
		
		if(directions != null)
		{
			for(int i = 0; i < directions.size(); i++)
			{
				Point tempCoord = directions.get(i).coord;
				matrix[tempCoord.x][tempCoord.y].state = State.CHOSEN;
				
			}
		}
		
		
		repaint();
	}
	
	public void createStart()
	{
		int randomX;
		int randomY;
		do
		{
			randomX = (int) (Math.random() * matrix.length);
			randomY = (int) (Math.random() * matrix[0].length);
		
		}while(matrix[randomX][randomY].state != State.OPEN);

		
		matrix[randomX][randomY].state = State.START;
		start = matrix[randomX][randomY];
		repaint();
	}
	
	public void createGoal()
	{
		int randomX;
		int randomY;
		do
		{
			randomX = (int) (Math.random() * matrix.length);
			randomY = (int) (Math.random() * matrix[0].length);
		
		}while(matrix[randomX][randomY].state != State.OPEN);

		
		matrix[randomX][randomY].state = State.GOAL;
		goal = matrix[randomX][randomY];
		repaint();
		
		
		
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		this.paintComponent(g2d);
		
	}

	public void paintComponent(Graphics g)
	{
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[0].length; j++)
			{
				matrix[i][j].draw(g);
				
			}	
		}	
	}


	public void update()
	{

	}
	


}
