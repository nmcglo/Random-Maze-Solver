import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MouseInput extends MouseAdapter
	{
		Gameboard gameboard;
		
		public MouseInput(Gameboard gb)
		{
			gameboard = gb;
		}
		
		@Override
		public void mouseClicked(MouseEvent e)
		{
			super.mouseClicked(e);
			
			gameboard.init(driver.x,driver.y);
			
			Point clicked = e.getPoint();
			
			Point squareClicked = new Point(clicked.x/gameboard.gridScale, clicked.y/gameboard.gridScale);
			
//			gameboard.matrix[squareClicked.x][squareClicked.y].state = State.CHOSEN;
//			gameboard.repaint();		
			
		}
		
	}