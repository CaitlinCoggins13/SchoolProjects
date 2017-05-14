// awt
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import java.awt.Image;
// listeners
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;







import javax.swing.ImageIcon;
// swing
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;

// text
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

/**
 * MonopolyGUIPanel.java
 * @author Curtain Kaufman and Guideline Coggins
 *
 */
public class MonopolyGUIPanel extends JPanel implements ActionListener {
	// make roll dice more blue
	
	// JButtons
	private JButton diceButton;			// When clicked, generates the dice values

	// JPanels	
	private JPanel buttonPanel;			// Displays the diceButton and the infoBox.	
	private JPanel winPanel;
	
	// JTextPanes
	private JTextPane infoBox;			// Provides updates to the player on what is happening in the game.
	
	// Fonts
	Font malayalam = new Font("Malayalam MN", Font.PLAIN, 12);
	Font malayalamBold = new Font("Malayalam MN", Font.BOLD, 14);
	
	// Colors
	/**
	 * Courtney: What do you want to name the color?
	 * Caitlin: I don't know, let's name it Fred.
	 */
	
	Color fred = new Color(24, 116, 205);
	Color iceCreamCone = new Color(255, 246, 143);
	Color violet = new Color(137, 104, 205);
	Color rose = new Color(255, 181, 197);
	Color slate = new Color(99, 184, 255);
	Color purple = new Color(176, 155, 198);
	
	Game game;								// Instance of the game
	MonopolyBoard board;
	
	PlayerPanel[] playerDisplays;			// Array of displays for each player
	
	int previous;							// Holds the previous
	int currentIndex;						// Holds the current index of the JComboBox.
	
	/**
	 * 
	 */
	public MonopolyGUIPanel()
	{
		super(new BorderLayout());
		game = new Game(2);
		board = new MonopolyBoard();
		playerDisplays = new PlayerPanel[2];
		previous = -1;
		currentIndex = 0;
		
		
		for(int i = 0; i<playerDisplays.length; ++i)
		{
			playerDisplays[i] = new PlayerPanel("Player " + (i+1));
			playerDisplays[i].buyHotelButton.addActionListener(this);
			playerDisplays[i].buyHouseButton.addActionListener(this);
			playerDisplays[i].sellHotelButton.addActionListener(this);
			playerDisplays[i].sellHouseButton.addActionListener(this);
			playerDisplays[i].sellPropertyButton.addActionListener(this);
			
			ItemListener il = new ItemListener() 
			{
				  // if there is a new state
			      public void itemStateChanged(ItemEvent e) 
			      {
			    	  // get what that state is, and see if it is the selected item event
			          if (e.getStateChange() == ItemEvent.SELECTED) 
			          {
			        	  JComboBox combo = (JComboBox) e.getSource();
			        	  
			        	  for(int i = 0; i<playerDisplays.length; ++i)
			        	  {
			        		  if(combo == playerDisplays[i].dropBox)
			        		  {
			        			  System.out.println(playerDisplays[i].dropBox.getSelectedIndex());
			        			  currentIndex = playerDisplays[i].dropBox.getSelectedIndex();
			        			  System.out.println("currentIndex: " + currentIndex);
			        			  updateButtons(playerDisplays[i].dropBox.getSelectedIndex());
			        		  }
			        	  }
			        	  
			        	  
			          }
			       }
			};
			
			// add an item listener to the combo box, to each to each option of the menu
			playerDisplays[i].dropBox.addItemListener(il);
			
		}
		
		playerDisplays[0].playerNameBox.setForeground(Color.RED);
		playerDisplays[1].playerNameBox.setForeground(Color.BLUE);
		
		add(playerDisplays[0], BorderLayout.WEST);
		add(playerDisplays[1], BorderLayout.EAST);
		add(board, BorderLayout.CENTER);
		add(buttonPanel(), BorderLayout.SOUTH);
		repaint();
	}
	
	/**
	 * @pre
	 * @post
	 * @return
	 */
	public JPanel buttonPanel()
	{
		buttonPanel = new JPanel(new GridLayout(2,1));
		buttonPanel.add(diceButton());
		buttonPanel.add(infoBox());
		return buttonPanel;
	}
	
	/**
	 * @pre
	 * @post
	 * @return
	 */
	public JButton diceButton()
	{
		diceButton = new JButton();
		diceButton.setBackground(slate);
		diceButton.setText("Roll Dice!");
		diceButton.setOpaque(true);
		diceButton.setFont(malayalam);
		diceButton.setBorderPainted(false);
		diceButton.addActionListener(this);
		diceButton.setEnabled(true);
		return diceButton;
	}
	
	/**
	 * @pre
	 * @post
	 * @return
	 */
	public JTextPane infoBox()
	{
		// https://www.java.net/node/651802
		StyledDocument document = new DefaultStyledDocument();
		Style defaultStyle = document.getStyle(StyleContext.DEFAULT_STYLE);
		StyleConstants.setAlignment(defaultStyle, StyleConstants.ALIGN_CENTER);
		infoBox = new JTextPane(document);
		// message to player
		// set the colors of the box, text, and highlight
		infoBox.setSelectionColor(iceCreamCone);
		infoBox.setBackground(rose);
		//infoBox.setBackground(Color.green);
		infoBox.setForeground(Color.black);
		// set the font
		infoBox.setFont(malayalam);
		// set it up so the text looks pretty
		infoBox.setEditable(false);
		// method from Caitlin
		//infoBox.setText(getStatusUpdate());

		// return created text area
		return infoBox;
	}
	
	public ImageIcon image()
	{
		ImageIcon icon = new ImageIcon("monopoly_mary.jpg");
		Image img = icon.getImage() ;  
		Image newimg = img.getScaledInstance( 64, 64, java.awt.Image.SCALE_SMOOTH ) ;  
		icon = new ImageIcon( newimg );
		return icon;
	}
	
	public JLabel imageMary()
	{
		ImageIcon icon = new ImageIcon("monopoly_mary.jpg");
		Image img = icon.getImage() ;  
		Image newimg = img.getScaledInstance( 64, 64, java.awt.Image.SCALE_SMOOTH ) ;  
		icon = new ImageIcon( newimg );
		JLabel iconLabel = new JLabel(icon);
		return iconLabel;
	}

	/**
	 * @pre
	 * @post
	 */
	public void actionPerformed(ActionEvent e)
	{
		JButton src = (JButton) e.getSource();
		System.out.println("Source text: " + src.getText());
		//button.setEnabled(true) 
		
		if(src == diceButton) 
		{
			// roll the dice
			game.rollDice();
			updateAll();
			System.out.println(game.getBuyPlace());
			if(game.getBuyPlace())
			{
				//JOptionPane.showMessageDialog(null, "hi" , "title", JOptionPane.QUESTION_MESSAGE, image()); 
				if (JOptionPane.showConfirmDialog(null, "Would you like to buy this property?  Cost: $" + Math.abs(((PropertyPlace)game.boardPlaces[game.tellPlayer]).getPropertyCost()), game.boardPlaces[game.tellPlayer].getName(), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, image()) == JOptionPane.YES_OPTION)
				{
					// update list of properties owned if bought
					System.out.println("property purchased");
					playerDisplays[game.playerNum].options.add(game.boardPlaces[game.tellPlayer].getName());
					System.out.println("player " + game.playerNum);
					System.out.println("options " +playerDisplays[game.playerNum].options.toString());
					game.completeAction();
					updateAll();
				}
				
				else
				{
					System.out.println("go to checkEnd pls");
					game.setBuyPlace(false);
					game.checkEnd();
					updateAll();
				}
				
				game.setBuyPlace(false);
					
			}
			
			else if(game.getBuyRailway())
			{
				if (JOptionPane.showConfirmDialog(null, "Would you like to buy this railway?  Cost: $" + Math.abs(((RailwayPlace)game.boardPlaces[game.tellPlayer]).costToBuy()), game.boardPlaces[game.tellPlayer].getName(), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, image()) == JOptionPane.YES_OPTION)
				{
					// update list of properties owned if bought
					System.out.println("property purchased");
					playerDisplays[game.playerNum].options.add(game.boardPlaces[game.tellPlayer].getName());
					game.completeAction();
					updateAll();
				}
				
				else
				{
					System.out.println("go to checkEnd pls");
					game.checkEnd();
					updateAll();
				}
				
				game.setBuyRailway(false);
			}
			
			else if(game.getBuyUtility())
			{
				if (JOptionPane.showConfirmDialog(null, "Would you like to buy this utility?  Cost: $" + Math.abs(((UtilityPlace)game.boardPlaces[game.tellPlayer]).getCost()), game.boardPlaces[game.tellPlayer].getName(), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, image()) == JOptionPane.YES_OPTION)
				{
					// update list of properties owned if bought
					System.out.println("property purchased");
					playerDisplays[game.playerNum].options.add(game.boardPlaces[game.tellPlayer].getName());
					game.completeAction();
					updateAll();
				}
				
				else
				{
					System.out.println("go to checkEnd pls");
					game.checkEnd();
					updateAll();
				}
				
				game.setBuyUtility(false);
			}
			board.newSettings(game.playerArray[0].getLocation(), game.playerArray[1].getLocation(), game.playerArray[0].getInJail(), game.playerArray[1].getInJail(), game.endGame);
			refreshDisplay();
		}
		
		for(int i = 0; i< playerDisplays.length; ++i)
		{
		if(src == playerDisplays[i].buyHouseButton)
		{
			//JOptionPane.showOptionDialog(null, "Which property are you buying for?", "Property Name", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, OPTIONS, OPTIONS[0]);
			//{
					if(JOptionPane.showConfirmDialog(null, "Would you like to buy a house? It will cost $" +Math.abs(((PropertyPlace)game.boardPlaces[(int) game.currentPlayer.getAllPlaces().elementAt(currentIndex-1)]).getHouseCost()), ((PropertyPlace)game.boardPlaces[(int) game.currentPlayer.getAllPlaces().elementAt(currentIndex-1)]).getName(), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, image()) == JOptionPane.YES_OPTION)
					{
						((PropertyPlace)(game.boardPlaces[game.tellPlayer])).addHouse();
					}
			//}
		}
		
		if(src == playerDisplays[i].buyHotelButton)
		{
			//JOptionPane.showOptionDialog(null, "Which property are you buying for?", "Property Name", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, OPTIONS, OPTIONS[0]);
			//{
					if(JOptionPane.showConfirmDialog(null, "Would you like to buy a hotel?  It will cost $" +Math.abs(((PropertyPlace)game.boardPlaces[(int) game.currentPlayer.getAllPlaces().elementAt(currentIndex-1)]).getHotelCost()), ((PropertyPlace)game.boardPlaces[(int) game.currentPlayer.getAllPlaces().elementAt(currentIndex-1)]).getName(), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, image()) == JOptionPane.YES_OPTION)
					{
						((PropertyPlace)(game.boardPlaces[game.tellPlayer])).addHotel();
					}
			//}
		}
		 
		if(src == playerDisplays[i].sellPropertyButton)
		{
			//JOptionPane.showOptionDialog(null, "Which property would you like to sell?", "Property Name", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, OPTIONS, OPTIONS[0]);
			if(currentIndex != 0)
			{
				if(JOptionPane.showConfirmDialog(null, "Would you like to sell this property? You will receive half of its cost", (game.boardPlaces[(int) game.currentPlayer.getAllPlaces().elementAt(currentIndex-1)]).getName(), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, image()) == JOptionPane.YES_OPTION)
				{
					playerDisplays[game.playerNum].options.remove(currentIndex);
					System.out.println("deleting " + currentIndex);
					System.out.println(playerDisplays[game.playerNum].options.toString());
					game.sellThing(currentIndex-1);
					playerDisplays[game.playerNum].dropBox.setSelectedIndex(0);
					updateAll();
				}	
			}
		}	
		
		if(src == playerDisplays[i].sellHouseButton)
		{
			//JOptionPane.showOptionDialog(null, "From which property?", "Property Name", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, OPTIONS, OPTIONS[0]);
				if(JOptionPane.showConfirmDialog(null, "Would you like to sell a house from this property? You will receive $" +((PropertyPlace)game.boardPlaces[(int) game.currentPlayer.getAllPlaces().elementAt(currentIndex-1)]).getHouseCost()/2, ((PropertyPlace)game.boardPlaces[(int) game.currentPlayer.getAllPlaces().elementAt(currentIndex-1)]).getName(), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, image()) == JOptionPane.YES_OPTION)
				{
					((PropertyPlace)(game.boardPlaces[(int) game.currentPlayer.getAllPlaces().elementAt(currentIndex-1)])).removeHouse();
					game.addOrSubtractMoney(((PropertyPlace)game.boardPlaces[(int) game.currentPlayer.getAllPlaces().elementAt(currentIndex-1)]).getHouseCost(), game.currentPlayer);
				}	
		}	
		
		if(src == playerDisplays[i].sellHotelButton)
		{
			//JOptionPane.showOptionDialog(null, "From which property?", "Property Name", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, OPTIONS, OPTIONS[0]);
				if(JOptionPane.showConfirmDialog(null, "Would you like to sell a hotel from this property? You will receive $" + ((PropertyPlace)game.boardPlaces[(int) game.currentPlayer.getAllPlaces().elementAt(currentIndex-1)]).getHotelCost()/2, ((PropertyPlace)game.boardPlaces[(int) game.currentPlayer.getAllPlaces().elementAt(currentIndex-1)]).getName(), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, image()) == JOptionPane.YES_OPTION)
				{
					((PropertyPlace)(game.boardPlaces[(int) game.currentPlayer.getAllPlaces().elementAt(currentIndex-1)])).removeHotel();
					game.addOrSubtractMoney(((PropertyPlace)game.boardPlaces[(int) game.currentPlayer.getAllPlaces().elementAt(currentIndex-1)]).getHotelCost(), game.currentPlayer);
				}	
		}	
		}
		
		System.out.println("FINAL UPDATE");
		updateAll();
	}
			
	public void refreshDisplay()
	{
		repaint();
	}
	// pick number of players
	
	public void updateAll()
	{
		infoBox.setText(game.getStatusUpdate());
		for(int i = 0; i<playerDisplays.length; ++i)
		{
			playerDisplays[i].totalMoneyBox.setText("Total Cash: $" +Integer.toString(game.playerArray[i].getTotalCash()));
		}
		
		if(game.playerNum != previous)
		{
			previous = game.playerNum;
			
			for(int i = 0; i< playerDisplays.length; ++i)
			{
				if(i == previous)
					playerDisplays[i].dropBox.setEnabled(true);
				
				else
				{
					playerDisplays[i].dropBox.setEnabled(false);
					playerDisplays[i].dropBox.setSelectedIndex(0);
				}
			}
		}
		
		if(game.currentPlayer.totalCash<0)
			diceButton.setEnabled(false);
		
		else
			diceButton.setEnabled(true);
		
		
	}
	
	public void updateButtons(int currentPlace)
	{
		for(int i = 0; i<playerDisplays.length; ++i)
		{
			if( i == game.playerNum)
			{
				//int currentPlace = playerDisplays[i].dropBox.getSelectedIndex();
				System.out.println("currentPlace " + currentPlace);
				System.out.println(i);
				if(currentPlace>0)
				{
				if(game.boardPlaces[(int)(game.currentPlayer.placesOwned.get(currentPlace-1))] instanceof PropertyPlace)
				{
					System.out.println("yup");
					if(((PropertyPlace)game.boardPlaces[(int)(game.currentPlayer.placesOwned.get(currentPlace-1))]).numHotels() == 0 )
						playerDisplays[i].sellHotelButton.setEnabled(false);
					
					else
						playerDisplays[i].sellHotelButton.setEnabled(true);
					
					if(((PropertyPlace)game.boardPlaces[(int)(game.currentPlayer.placesOwned.get(currentPlace-1))]).numHouses() == 0 )
						playerDisplays[i].sellHouseButton.setEnabled(false);
					
					else
						playerDisplays[i].sellHouseButton.setEnabled(true);
					
					if(!(game.allColor(((PropertyPlace)game.boardPlaces[(int)(game.currentPlayer.placesOwned.get(currentPlace-1))]).getColor(), game.playerArray[i])) || ((PropertyPlace)game.boardPlaces[(int)(game.currentPlayer.placesOwned.get(currentPlace-1))]).numHotels() == 1 || ((PropertyPlace)game.boardPlaces[(int)(game.currentPlayer.placesOwned.get(currentPlace-1))]).getHotelCost()>game.currentPlayer.getTotalCash() || ((PropertyPlace)game.boardPlaces[(int)(game.currentPlayer.placesOwned.get(currentPlace-1))]).numHouses() != 4)
						playerDisplays[i].buyHotelButton.setEnabled(false);
					
					else
						playerDisplays[i].buyHotelButton.setEnabled(true);
					
					if(!(game.allColor(((PropertyPlace)game.boardPlaces[(int)(game.currentPlayer.placesOwned.get(currentPlace-1))]).getColor(), game.playerArray[i])) || ((PropertyPlace)game.boardPlaces[(int)(game.currentPlayer.placesOwned.get(currentPlace-1))]).numHouses() == 4 || ((PropertyPlace)game.boardPlaces[(int)(game.currentPlayer.placesOwned.get(currentPlace-1))]).getHouseCost()>game.currentPlayer.getTotalCash())
						playerDisplays[i].buyHouseButton.setEnabled(false);
					
					else
						playerDisplays[i].buyHouseButton.setEnabled(true);
					
					playerDisplays[i].sellPropertyButton.setEnabled(true);
				}
				
				else if(game.boardPlaces[(int)(game.currentPlayer.placesOwned.get(currentPlace-1))] instanceof UtilityPlace || game.boardPlaces[(int)(game.currentPlayer.placesOwned.get(currentPlace-1))] instanceof RailwayPlace)
				{
					playerDisplays[i].buyHotelButton.setEnabled(false);
					playerDisplays[i].buyHouseButton.setEnabled(false);
					playerDisplays[i].sellHotelButton.setEnabled(false);
					playerDisplays[i].sellHouseButton.setEnabled(false);
					playerDisplays[i].sellPropertyButton.setEnabled(true);
					playerDisplays[i].dropBox.setEnabled(true);
				}
				}
			}
			
			else
			{
				playerDisplays[i].buyHotelButton.setEnabled(false);
				playerDisplays[i].buyHouseButton.setEnabled(false);
				playerDisplays[i].sellHotelButton.setEnabled(false);
				playerDisplays[i].sellHouseButton.setEnabled(false);
				playerDisplays[i].sellPropertyButton.setEnabled(false);
				playerDisplays[i].dropBox.setEnabled(false);
			}
		}
	}
}