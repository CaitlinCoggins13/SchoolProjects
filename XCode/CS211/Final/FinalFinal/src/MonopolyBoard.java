// awt
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
// swing
import javax.swing.JComponent;

/**
 * 
 * @author Curtain Kaufman and Guideline Coggins
 *
 */
public class MonopolyBoard extends JComponent
{
	//Colors
	Color eggplant = new Color(148, 0, 211);
	Color darkPurple = new Color(85, 26, 139);
	Color powderBlue = new Color(135, 206, 250);
	Color fuchsia = new Color(255, 0, 127);
	Color hunterGreen = new Color(0, 139, 0);
	Color purple = new Color(176, 155, 198);
	
	int drawP1;
	int drawP2;
	boolean P1inJail;
	boolean P2inJail;
	boolean endgame;
	private ImageIcon mary;
	/**
	 * @pre
	 * @post
	 */
	public MonopolyBoard()
	{
		super();
		drawP1 = 0;
		P1inJail = false;
		drawP2 = 0;
		P2inJail = false;
		mary = image();
		endgame = false;
	}
	
	public ImageIcon image()
	{
		ImageIcon icon = new ImageIcon("monopoly_mary.jpg");
		Image img = icon.getImage() ;  
		Image newimg = img.getScaledInstance( 850, 850, java.awt.Image.SCALE_SMOOTH ) ;  
		icon = new ImageIcon( newimg );
		return icon;
	}
	
	/**
	 * @pre
	 * @post
	 * @param
	 */
	public void paint(Graphics g)
	{
		if(!endgame)
		{
			drawBoard(g);
			drawPlayer1(g);
			drawPlayer2(g);
		}
		
		else
			drawMary(g);
	}
	
	public void drawMary(Graphics g)
	{
		super.paintComponent(g);

        mary.paintIcon(this, g, 0, 0);
	}
	
	/**
	 * @pre
	 * @post
	 * @param g
	 */
	public void drawPlayer1(Graphics g)
	{
		Graphics2D x = (Graphics2D) g;
		
		if(drawP1 == 0)
		{
			 x.setPaint(Color.red);
		     g.drawOval(900, 760, 25, 25);
		     g.fillOval(900, 760, 25, 25);
		}
		
		else if(drawP1 == 1)
		{
			 x.setPaint(Color.red);
		     g.drawOval(835, 755, 25, 25);
		     g.fillOval(835, 755, 25, 25);
		}
		
		else if(drawP1 == 2)
		{
			x.setPaint(Color.red);
		    g.drawOval(775, 755, 25, 25);
		    g.fillOval(775, 755, 25, 25);
		}
		
		else if(drawP1 == 3)
		{
			x.setPaint(Color.red);
		     g.drawOval(715, 755, 25, 25);
		     g.fillOval(715, 755, 25, 25);
		}
		
		else if(drawP1 == 4)
		{
			x.setPaint(Color.red);
		     g.drawOval(655, 755, 25, 25);
		     g.fillOval(655, 755, 25, 25);
		}
		
		else if(drawP1 == 5)
		{
			x.setPaint(Color.red);
		     g.drawOval(595, 755, 25, 25);
		     g.fillOval(595, 755, 25, 25);
		}
		
		else if(drawP1 == 6)
		{
			x.setPaint(Color.red);
		     g.drawOval(535, 755, 25, 25);
		     g.fillOval(535, 755, 25, 25);
		}
		
		else if(drawP1 == 7)
		{
			 x.setPaint(Color.red);
		     g.drawOval(475, 755, 25, 25);
		     g.fillOval(475, 755, 25, 25);
		}
		
		else if(drawP1 == 8)
		{
			 x.setPaint(Color.red);
		     g.drawOval(415, 755, 25, 25);
		     g.fillOval(415, 755, 25, 25);
		}
		
		else if(drawP1 == 9)
		{
			 x.setPaint(Color.red);
		     g.drawOval(355, 755, 25, 25);
		     g.fillOval(355, 755, 25, 25);
		}
		
		else if(drawP1 == 10 && P1inJail)
		{
			 x.setPaint(Color.red);
		     g.drawOval(260, 730, 25, 25);
		     g.fillOval(260, 730, 25, 25);
		}
		
		else if(drawP1 == 10 && !P1inJail)
		{
			x.setPaint(Color.red);
		     g.drawOval(260, 795, 25, 25);
		     g.fillOval(260, 795, 25, 25);
		}
		
		else if(drawP1 == 11)
		{
			x.setPaint(Color.red);
		     g.drawOval(260, 670, 25, 25);
		     g.fillOval(260, 670, 25, 25);
		}
		
		else if(drawP1 == 12)
		{
			x.setPaint(Color.red);
		     g.drawOval(260, 610, 25, 25);
		     g.fillOval(260, 610, 25, 25);
		}
		
		else if(drawP1 == 13)
		{
			 x.setPaint(Color.red);
		     g.drawOval(260, 550, 25, 25);
		     g.fillOval(260, 550, 25, 25);
		}
		
		else if(drawP1 == 14)
		{
			 x.setPaint(Color.red);
		     g.drawOval(260, 490, 25, 25);
		     g.fillOval(260, 490, 25, 25);
		}
		
		else if(drawP1 == 15)
		{
			x.setPaint(Color.red);
		     g.drawOval(260, 430, 25, 25);
		     g.fillOval(260, 430, 25, 25);
		}
		
		else if(drawP1 == 16)
		{
			x.setPaint(Color.red);
		     g.drawOval(260, 370, 25, 25);
		     g.fillOval(260, 370, 25, 25);
		}
		
		else if(drawP1 == 17)
		{
			x.setPaint(Color.red);
		     g.drawOval(260, 310, 25, 25);
		     g.fillOval(260, 310, 25, 25);
		}
		
		else if(drawP1 == 18)
		{
			x.setPaint(Color.red);
		     g.drawOval(260, 250, 25, 25);
		     g.fillOval(260, 250, 25, 25);
		}
		
		else if(drawP1 == 19)
		{
			x.setPaint(Color.red);
		     g.drawOval(260, 190, 25, 25);
		     g.fillOval(260, 190, 25, 25);
		}
		
		else if(drawP1 == 20)
		{
			 x.setPaint(Color.red);
		     g.drawOval(245, 100, 25, 25);
		     g.fillOval(245, 100, 25, 25); 
		}
		
		else if(drawP1 == 21)
		{
			x.setPaint(Color.red);
		     g.drawOval(350, 90, 25, 25);
		     g.fillOval(350, 90, 25, 25);
		}
		
		else if(drawP1 == 22)
		{
			x.setPaint(Color.red);
		     g.drawOval(410, 90, 25, 25);
		     g.fillOval(410, 90, 25, 25);
		}
		
		else if(drawP1 == 23)
		{
			 x.setPaint(Color.red);
		     g.drawOval(470, 90, 25, 25);
		     g.fillOval(470, 90, 25, 25);
		}
		
		else if(drawP1 == 24)
		{
			x.setPaint(Color.red);
		     g.drawOval(530, 90, 25, 25);
		     g.fillOval(530, 90, 25, 25);
		}
		
		else if(drawP1 == 25)
		{
			x.setPaint(Color.red);
		     g.drawOval(590, 90, 25, 25);
		     g.fillOval(590, 90, 25, 25);
		}
		
		else if(drawP1 == 26)
		{
			 x.setPaint(Color.red);
		     g.drawOval(650, 90, 25, 25);
		     g.fillOval(650, 90, 25, 25);
		}
		
		else if(drawP1 == 27)
		{
			 x.setPaint(Color.red);
		     g.drawOval(710, 90, 25, 25);
		     g.fillOval(710, 90, 25, 25);
		}
		
		else if(drawP1 == 28)
		{
			x.setPaint(Color.red);
		     g.drawOval(770, 90, 25, 25);
		     g.fillOval(770, 90, 25, 25);
		}
		
		else if(drawP1 == 29)
		{
			x.setPaint(Color.red);
		     g.drawOval(830, 90, 25, 25);
		     g.fillOval(830, 90, 25, 25);
		}
		
		else if(drawP1 == 30)
		{
			x.setPaint(Color.red);
		     g.drawOval(900, 100, 25, 25);
		     g.fillOval(900, 100, 25, 25);
		}
		
		else if(drawP1 == 31)
		{
			x.setPaint(Color.red);
		     g.drawOval(925, 190, 25, 25);
		     g.fillOval(925, 190, 25, 25);
		}
		
		else if(drawP1 == 32)
		{
			x.setPaint(Color.red);
		     g.drawOval(925, 250, 25, 25);
		     g.fillOval(925, 250, 25, 25);
		}
		
		else if(drawP1 == 33)
		{
			 x.setPaint(Color.red);
		     g.drawOval(925, 310, 25, 25);
		     g.fillOval(925, 310, 25, 25);
		}
		
		else if(drawP1 == 34)
		{
			x.setPaint(Color.red);
		     g.drawOval(925, 370, 25, 25);
		     g.fillOval(925, 370, 25, 25);
		}
		
		else if(drawP1 == 35)
		{
			x.setPaint(Color.red);
		     g.drawOval(925, 430, 25, 25);
		     g.fillOval(925, 430, 25, 25);
		}
		
		else if(drawP1 == 36)
		{
			x.setPaint(Color.red);
		     g.drawOval(925, 490, 25, 25);
		     g.fillOval(925, 490, 25, 25);
		}
		
		else if(drawP1 == 37)
		{
			x.setPaint(Color.red);
		     g.drawOval(925, 550, 25, 25);
		     g.fillOval(925, 550, 25, 25);
		}
		
		else if(drawP1 == 38)
		{
			x.setPaint(Color.red);
		     g.drawOval(925, 610, 25, 25);
		     g.fillOval(925, 610, 25, 25);
		}
		
		else if(drawP1 == 39)
		{
			x.setPaint(Color.red);
		     g.drawOval(925, 670, 25, 25);
		     g.fillOval(925, 670, 25, 25);
		}

	}
	
	public void drawPlayer2(Graphics g)
	{
		Graphics2D x = (Graphics2D) g;
		
		if(drawP2 == 0)
		{
			 x.setPaint(Color.blue);
		     g.drawOval(940, 760, 25, 25);
		     g.fillOval(940, 760, 25, 25);
		}
		
		else if(drawP2 == 1)
		{
			 x.setPaint(Color.blue);
		     g.drawOval(835, 790, 25, 25);
		     g.fillOval(835, 790, 25, 25);
		}
		
		else if(drawP2 == 2)
		{
			 x.setPaint(Color.blue);
		     g.drawOval(775, 790, 25, 25);
		     g.fillOval(775, 790, 25, 25);
		}
		
		else if(drawP2 == 3)
		{
			x.setPaint(Color.blue);
		     g.drawOval(715, 790, 25, 25);
		     g.fillOval(715, 790, 25, 25);
		}
		
		else if(drawP2 == 4)
		{
			 x.setPaint(Color.blue);
		     g.drawOval(655, 790, 25, 25);
		     g.fillOval(655, 790, 25, 25);
		}
		
		else if(drawP2 == 5)
		{
			x.setPaint(Color.blue);
		     g.drawOval(595, 790, 25, 25);
		     g.fillOval(595, 790, 25, 25);
		}
		
		else if(drawP2 == 6)
		{
			x.setPaint(Color.blue);
		     g.drawOval(535, 790, 25, 25);
		     g.fillOval(535, 790, 25, 25);
		}
		
		else if(drawP2 == 7)
		{
			x.setPaint(Color.blue);
		     g.drawOval(475, 790, 25, 25);
		     g.fillOval(475, 790, 25, 25);
		}
		
		else if(drawP2 == 8)
		{
			x.setPaint(Color.blue);
		     g.drawOval(415, 790, 25, 25);
		     g.fillOval(415, 790, 25, 25);
		}
		
		else if(drawP2 == 9)
		{
			x.setPaint(Color.blue);
		     g.drawOval(355, 790, 25, 25);
		     g.fillOval(355, 790, 25, 25); 
		}
		
		else if(drawP2 == 10)
		{
			x.setPaint(Color.blue);
		     g.drawOval(300, 730, 25, 25);
		     g.fillOval(300, 730, 25, 25); 
		}
		
		else if(drawP2 == 10)
		{
			x.setPaint(Color.blue);
		     g.drawOval(300, 795, 25, 25);
		     g.fillOval(300, 795, 25, 25);
		}
		
		else if(drawP2 == 11)
		{
			x.setPaint(Color.blue);
		     g.drawOval(225, 670, 25, 25);
		     g.fillOval(225, 670, 25, 25); 
		}
		
		else if(drawP2 == 12)
		{
			x.setPaint(Color.blue);
		     g.drawOval(225, 610, 25, 25);
		     g.fillOval(225, 610, 25, 25);
		}
		
		else if(drawP2 == 13)
		{
			x.setPaint(Color.blue);
		     g.drawOval(225, 550, 25, 25);
		     g.fillOval(225, 550, 25, 25); 
		}
		
		else if(drawP2 == 14)
		{
			x.setPaint(Color.blue);
		     g.drawOval(225, 490, 25, 25);
		     g.fillOval(225, 490, 25, 25); 
		}
		
		else if(drawP2 == 15)
		{
			x.setPaint(Color.blue);
		     g.drawOval(225, 430, 25, 25);
		     g.fillOval(225, 430, 25, 25); 
		}
		
		else if(drawP2 == 16)
		{
			x.setPaint(Color.blue);
		     g.drawOval(225, 370, 25, 25);
		     g.fillOval(225, 370, 25, 25); 
		}
		
		else if(drawP2 == 17)
		{
			x.setPaint(Color.blue);
		     g.drawOval(225, 310, 25, 25);
		     g.fillOval(225, 310, 25, 25);
		}
		
		else if(drawP2 == 18)
		{
			x.setPaint(Color.blue);
		     g.drawOval(225, 250, 25, 25);
		     g.fillOval(225, 250, 25, 25); 
		}
		
		else if(drawP2 == 19)
		{
			x.setPaint(Color.blue);
		     g.drawOval(225, 190, 25, 25);
		     g.fillOval(225, 190, 25, 25); 
		}
		
		else if(drawP2 == 20)
		{
			x.setPaint(Color.blue);
		     g.drawOval(280, 100, 25, 25);
		     g.fillOval(280, 100, 25, 25);
		}
		
		else if(drawP2 == 21)
		{
			x.setPaint(Color.blue);
		     g.drawOval(350, 55, 25, 25);
		     g.fillOval(350, 55, 25, 25); 
		}
		
		else if(drawP2 == 22)
		{
			x.setPaint(Color.blue);
		     g.drawOval(410, 55, 25, 25);
		     g.fillOval(410, 55, 25, 25); 
		}
		
		else if(drawP2 == 23)
		{
			x.setPaint(Color.blue);
		     g.drawOval(470, 55, 25, 25);
		     g.fillOval(470, 55, 25, 25); 
		}
		
		else if(drawP2 == 24)
		{
			x.setPaint(Color.blue);
		     g.drawOval(530, 55, 25, 25);
		     g.fillOval(530, 55, 25, 25); 
		}
		
		else if(drawP2 == 25)
		{
			x.setPaint(Color.blue);
		     g.drawOval(590, 55, 25, 25);
		     g.fillOval(590, 55, 25, 25);
		}
		
		else if(drawP2 == 26)
		{
			x.setPaint(Color.blue);
		     g.drawOval(650, 55, 25, 25);
		     g.fillOval(650, 55, 25, 25); 
		}
		
		else if(drawP2 == 27)
		{
			x.setPaint(Color.blue);
		     g.drawOval(710, 55, 25, 25);
		     g.fillOval(710, 55, 25, 25);
		}
		
		else if(drawP2 == 28)
		{
			 x.setPaint(Color.blue);
		     g.drawOval(770, 55, 25, 25);
		     g.fillOval(770, 55, 25, 25);
		}
		
		else if(drawP2 == 29)
		{
			x.setPaint(Color.blue);
		     g.drawOval(830, 55, 25, 25);
		     g.fillOval(830, 55, 25, 25);
		}
		
		else if(drawP2 == 30)
		{
			x.setPaint(Color.blue);
		     g.drawOval(935, 100, 25, 25);
		     g.fillOval(935, 100, 25, 25);
		}
		
		else if(drawP2 == 31)
		{
			x.setPaint(Color.blue);
		     g.drawOval(960, 190, 25, 25);
		     g.fillOval(960, 190, 25, 25);
		}
		
		else if(drawP2 == 32)
		{
			x.setPaint(Color.blue);
		     g.drawOval(960, 250, 25, 25);
		     g.fillOval(960, 250, 25, 25);
		}
		
		else if(drawP2 == 33)
		{
			x.setPaint(Color.blue);
		     g.drawOval(960, 310, 25, 25);
		     g.fillOval(960, 310, 25, 25);
		}
		
		else if(drawP2 == 34)
		{
			x.setPaint(Color.blue);
		     g.drawOval(960, 365, 25, 25);
		     g.fillOval(960, 365, 25, 25);
		}
		
		else if(drawP2 == 35)
		{
			x.setPaint(Color.blue);
		     g.drawOval(960, 430, 25, 25);
		     g.fillOval(960, 430, 25, 25);
		}
		
		else if(drawP2 == 36)
		{
			x.setPaint(Color.blue);
		     g.drawOval(960, 490, 25, 25);
		     g.fillOval(960, 490, 25, 25);
		}
		
		else if(drawP2 == 37)
		{
			x.setPaint(Color.blue);
		     g.drawOval(960, 550, 25, 25);
		     g.fillOval(960, 550, 25, 25);
		}
		
		else if(drawP2 == 38)
		{
			x.setPaint(Color.blue);
		     g.drawOval(960, 610, 25, 25);
		     g.fillOval(960, 610, 25, 25);
		}
		
		else if(drawP2 == 39)
		{
			x.setPaint(Color.blue);
		     g.drawOval(960, 670, 25, 25);
		     g.fillOval(960, 670, 25, 25); 
		}
	}
	
	public void newSettings(int player1Place, int player2Place, boolean player1Jail, boolean player2Jail, boolean end)
	{
		drawP1 = player1Place;
		drawP2 = player2Place;
		P1inJail = player1Jail;
		P2inJail = player2Jail;
		endgame = end;
	}

	
	/**
	 * @pre
	 * @post
	 * @param g
	 */
	public void drawBoard(Graphics g)
	{
		g.setColor(purple);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		g.setColor(Color.WHITE);
		g.fillRect((getWidth()/2)-400, (getHeight()/2)-400, 780, 780);
		// Let's draw some tiny colorful boxes. Everyone loves tiny colorful boxes.
		
		//g.setColor(Color.YELLOW);
		//g.setColor(eggplant);
		g.setColor(darkPurple);
		g.fillRect((getWidth()/2)-400+600, (getHeight()/2)-400+660, 60, 40);
		g.fillRect((getWidth()/2)-400+480, (getHeight()/2)-400+660, 60, 40);
		
		//g.setColor(Color.CYAN);
		g.setColor(powderBlue);
		g.fillRect((getWidth()/2)-400+300, (getHeight()/2)-400+660, 60, 40);
		g.fillRect((getWidth()/2)-400+180, (getHeight()/2)-400+660, 60, 40);
		g.fillRect((getWidth()/2)-400+120, (getHeight()/2)-400+660, 60, 40);
		
		
		//g.setColor(Color.PINK);
		g.setColor(fuchsia);
		g.fillRect((getWidth()/2)-400+80, (getHeight()/2)-400+600, 40, 60);
		g.fillRect((getWidth()/2)-400+80, (getHeight()/2)-400+480, 40, 60);
		g.fillRect((getWidth()/2)-400+80, (getHeight()/2)-400+420, 40, 60);
		
		g.setColor(Color.orange);
		g.fillRect((getWidth()/2)-400+80, (getHeight()/2)-400+300, 40, 60);
		g.fillRect((getWidth()/2)-400+80, (getHeight()/2)-400+180, 40, 60);
		g.fillRect((getWidth()/2)-400+80, (getHeight()/2)-400+120, 40, 60);
		
		g.setColor(Color.red); 
		g.fillRect((getWidth()/2)-400+120, (getHeight()/2)-400+80, 60, 40);
		g.fillRect((getWidth()/2)-400+240, (getHeight()/2)-400+80, 60, 40);
		g.fillRect((getWidth()/2)-400+300, (getHeight()/2)-400+80, 60, 40);
		
		g.setColor(Color.yellow);
		g.fillRect((getWidth()/2)-400+420, (getHeight()/2)-400+80, 60, 40);
		g.fillRect((getWidth()/2)-400+480, (getHeight()/2)-400+80, 60, 40);
		g.fillRect((getWidth()/2)-400+600, (getHeight()/2)-400+80, 60, 40);
	
		g.setColor(hunterGreen);
		g.fillRect((getWidth()/2)-400+660, (getHeight()/2)-400+120, 40, 60);
		g.fillRect((getWidth()/2)-400+660, (getHeight()/2)-400+180, 40, 60);
		g.fillRect((getWidth()/2)-400+660, (getHeight()/2)-400+300, 40, 60);
		
		g.setColor(Color.blue);
		g.fillRect((getWidth()/2)-400+660, (getHeight()/2)-400+480, 40, 60);	
		g.fillRect((getWidth()/2)-400+660, (getHeight()/2)-400+600, 40, 60);
		
		g.setColor(Color.BLACK);
		// There are 11 boxes on each side, two of them are double sized so to make the math easy we used 390 for the board size.
		g.drawRect((getWidth()/2)-400, (getHeight()/2)-400, 780, 780); //multiple of 13, the main box line
		
		g.drawLine((getWidth()/2)-400+120, (getHeight()/2)-400, (getWidth()/2)-400+120, (getHeight()/2)-400+780); // the inner west side line
		g.drawLine((getWidth()/2)-400, (getHeight()/2)-400+120, (getWidth()/2)-400+780, (getHeight()/2)-400+120); // the inner north side line
		g.drawLine((getWidth()/2)-400, (getHeight()/2)-400+660, (getWidth()/2)-400+780, (getHeight()/2)-400+660); // the inner south side line
		g.drawLine((getWidth()/2)-400+660, (getHeight()/2)-400, (getWidth()/2)-400+660, (getHeight()/2)-400+780); // the inner east side line
				
		// this is to draw the smaller dividing lines that mark each card space
		for(int i = (getWidth()/2)-400+120; i<(getWidth()/2)-400+660; i+=60)
		{
			g.drawLine(i, (getHeight()/2)-400, i, (getHeight()/2)-400+120); // these are the north squares
			g.drawLine(i, (getHeight()/2)-400+780, i, (getHeight()/2)-400+780-120); // these are the south squares
		}
		
		// same as above, except for the sides
		for(int i = (getHeight()/2)-400+120; i<(getHeight()/2)-400+660; i+=60)
		{
			g.drawLine((getWidth()/2)-400, i, (getWidth()/2)-400+120, i); // these are the west squares
			g.drawLine((getWidth()/2)-400+780, i, (getWidth()/2)-400+780-120, i); // these are the east squares
		}
	}
	
	
}