import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class what extends JComponent
{
	public what()
	{
		super();
	}
	
	public void paint(Graphics g)
	{
		drawBoard(g);
	}
	
	/**
	 * @pre
	 * @post
	 * @param g
	 */
	public void drawBoard(Graphics g)
	{
		// There are 11 boxes on each side, two of them are double sized so to make the math easy we used 390 for the board size.
		g.drawRect((getWidth()/2)-200, (getHeight()/2)-200, 390, 390); //multiple of 13, the main box line
		g.drawLine((getWidth()/2)-200+60, (getHeight()/2)-200, (getWidth()/2)-200+60, (getHeight()/2)-200+390); // the inner west side line
		g.drawLine((getWidth()/2)-200, (getHeight()/2)-200+60, (getWidth()/2)-200+390, (getHeight()/2)-200+60); // the inner north side line
		g.drawLine((getWidth()/2)-200, (getHeight()/2)-200+330, (getWidth()/2)-200+390, (getHeight()/2)-200+330); // the inner south side line
		g.drawLine((getWidth()/2)-200+330, (getHeight()/2)-200, (getWidth()/2)-200+330, (getHeight()/2)-200+390); // the inner east side line
		
		// this is to draw the smaller dividing lines that mark each card space
		for(int i = (getWidth()/2)-200+60; i<(getWidth()/2)-200+330; i+=30)
		{
			g.drawLine(i, (getHeight()/2)-200, i, (getHeight()/2)-200+60); // these are the north squares
			g.drawLine(i, (getHeight()/2)-200+390, i, (getHeight()/2)-200+390-60); // these are the south squares
		}
		
		// same as above, except for the sides
		for(int i = (getHeight()/2)-200+60; i<(getHeight()/2)-200+330; i+=30)
		{
			g.drawLine((getWidth()/2)-200, i, (getWidth()/2)-200+60, i); // these are the west squares
			g.drawLine((getWidth()/2)-200+390, i, (getWidth()/2)-200+390-60, i); // these are the east squares
		}
		
		// Let's draw some tiny colorful boxes. Everyone loves tiny colorful boxes.
		g.setColor(Color.YELLOW);
		g.fillRect((getWidth()/2)-200+300, (getHeight()/2)-200+330, 30, 20);
		g.fillRect((getWidth()/2)-200+240, (getHeight()/2)-200+330, 30, 20);
		
		g.setColor(Color.CYAN);
		g.fillRect((getWidth()/2)-200+150, (getHeight()/2)-200+330, 30, 20);
		g.fillRect((getWidth()/2)-200+90, (getHeight()/2)-200+330, 30, 20);
		g.fillRect((getWidth()/2)-200+60, (getHeight()/2)-200+330, 30, 20);
		
		
		g.setColor(Color.BLUE);
		g.fillRect((getWidth()/2)-200+40, (getHeight()/2)-200+300, 20, 30);
		
		g.fillRect((getWidth()/2)-200+40, (getHeight()/2)-200+240, 20, 30);
		g.fillRect((getWidth()/2)-200+40, (getHeight()/2)-200+210, 20, 30);
		
		// skip one, card, skip one, card card
		g.fillRect((getWidth()/2)-200+40, (getHeight()/2)-200+150, 20, 30);
		
		g.fillRect((getWidth()/2)-200+40, (getHeight()/2)-200+90, 20, 30);
		g.fillRect((getWidth()/2)-200+40, (getHeight()/2)-200+60, 20, 30);
		
		// color skip color color skip color color skip color
		
		// will code for food
		
		g.setColor(Color.ORANGE);
		g.fillRect((getWidth()/2)-200+60, (getHeight()/2)-200+40, 30, 20);
		
		g.fillRect((getWidth()/2)-200+120, (getHeight()/2)-200+40, 30, 20);
		g.fillRect((getWidth()/2)-200+150, (getHeight()/2)-200+40, 30, 20);
		
		g.fillRect((getWidth()/2)-200+210, (getHeight()/2)-200+40, 30, 20);
		g.fillRect((getWidth()/2)-200+240, (getHeight()/2)-200+40, 30, 20);
		
		g.fillRect((getWidth()/2)-200+300, (getHeight()/2)-200+40, 30, 20);
		
		// color color skip color skip skip color skip color
		g.setColor(Color.PINK);
		g.fillRect((getWidth()/2)-200+330, (getHeight()/2)-200+60, 20, 30);
		g.fillRect((getWidth()/2)-200+330, (getHeight()/2)-200+90, 20, 30);
		
		g.fillRect((getWidth()/2)-200+330, (getHeight()/2)-200+150, 20, 30);
		
		g.setColor(Color.BLUE);
		g.fillRect((getWidth()/2)-200+330, (getHeight()/2)-200+240, 20, 30);	
		g.fillRect((getWidth()/2)-200+330, (getHeight()/2)-200+300, 20, 30);
		
		
		
		
	}
}