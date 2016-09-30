import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;


public class gamespace implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	static int gridScale = driver.gridScale;
	
	Point coord = new Point();
	int label;
	Point realCoord;
	State state;
	
	



	public gamespace()
	{
		coord = new Point();
		realCoord = new Point(coord.x*gridScale, coord.y*gridScale);
		state = randInit();
		label = hashCode();
		
	}
	
	public gamespace(int x, int y)
	{
		coord = new Point(x,y);
		realCoord = new Point(x*gridScale, y*gridScale);
		state = randInit();
		label = hashCode();
		
		
	}
	
	public State randInit()
	{
		State output;
		double rand = Math.random();
		if(rand <= .6)
			output = State.OPEN;
		else
			output = State.BLOCKED;
		
		return output;

	}
	
    public int hashCode()
    {
    	int hash = 10000*coord.x + coord.y;
    	
    	return hash;
    }
	
	

	public void draw(Graphics g)
	{
//		g.drawRect(realCoord.x, realCoord.y, gridScale, gridScale);

		if(state == State.OPEN)
		{
			g.setColor(Color.WHITE);
			g.fillRect(realCoord.x, realCoord.y,gridScale,gridScale);
		}
		if(state == State.BLOCKED)
		{
			g.setColor(Color.BLACK);
			g.fillRect(realCoord.x, realCoord.y,gridScale,gridScale);
		}
		if(state == State.CONSIDERED)
		{
			g.setColor(Color.ORANGE);
			g.fillRect(realCoord.x, realCoord.y,gridScale,gridScale);
		}
		if(state == State.CHOSEN)
		{
			g.setColor(Color.GREEN);
			g.fillRect(realCoord.x, realCoord.y,gridScale,gridScale);
		}
		if(state == State.GOAL)
		{
			g.setColor(Color.YELLOW);
			g.fillRect(realCoord.x, realCoord.y,gridScale,gridScale);
		}
		if(state == State.START)
		{
			g.setColor(Color.BLUE);
			g.fillRect(realCoord.x, realCoord.y,gridScale,gridScale);
		}
		
		
	}
	
	
	

}

