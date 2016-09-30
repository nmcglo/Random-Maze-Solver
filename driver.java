import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;


public class driver
{
	static int x = 200;
	static int y = 200;
	
	public static int gridScale = 3;
	
	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Random Game Board");
		frame.setSize(100,100);
		frame.setLocation(100, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(new FlowLayout());
		
		Gameboard gameboard = new Gameboard(x,y,gridScale);
		frame.add(gameboard);
		
		gameboard.setSize(x*gridScale, y*gridScale);
		gameboard.setPreferredSize(new Dimension(x*gridScale, y*gridScale));
		
		frame.pack();
		frame.setVisible(true);
		
		
		
	}
	
	
	

}
