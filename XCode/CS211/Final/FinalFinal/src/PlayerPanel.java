import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

public class PlayerPanel extends JPanel
{

	public JButton buyHouseButton;
	public JButton buyHotelButton;
	public JButton sellHotelButton;
	public JButton sellHouseButton;
	public JButton sellPropertyButton;
	
	// JTextPanes
	public JTextPane playerNameBox;
	public JTextPane totalMoneyBox;
	
	// JComboBox
	public JComboBox dropBox;
	
	// JPanels	
	private JPanel basPanel;
	private JPanel buyAndSellPanel;
	private JPanel dropPanel;
	private JPanel mapPanel;
	
	Font malayalam = new Font("Malayalam MN", Font.PLAIN, 12);
	Font malayalamBold = new Font("Malayalam MN", Font.BOLD, 14);

	Color purple = new Color(176, 155, 198);
	
	public Vector options;
	
	/**
	 * @pre
	 * @post
	 * @return
	 */
	public PlayerPanel(String name)
	{
		super(new BorderLayout());
		
		options = new Vector();
		options.add("Select a property:");
		
		add(moneyAndPlacePanel(), BorderLayout.NORTH);
		add(dropPanel(), BorderLayout.CENTER);
		add(buyAndSellHHPanel(), BorderLayout.SOUTH);
		
		playerNameBox.setText(name);
	}
/**
	 * @pre
	 * @post
	 * @return
	 */
	public JButton buyHouseButton()
	{
		buyHouseButton = new JButton();
		buyHouseButton.setText("Buy House?");
		buyHouseButton.setFont(malayalam);
		buyHouseButton.setEnabled(false);
		return buyHouseButton;
	}
	
	/**
	 * @pre
	 * @post
	 * @return
	 */
	public JButton buyHotelButton()
	{
		buyHotelButton = new JButton();
		buyHotelButton.setText("Buy Hotel?");
		buyHotelButton.setFont(malayalam);
		buyHotelButton.setEnabled(false);
		return buyHotelButton;
	}
	
	/**
	 * @pre
	 * @post
	 * @return
	 */
	public JPanel buyAndSellHHPanel()
	{
		buyAndSellPanel = new JPanel(new GridLayout(2,1));
		buyAndSellPanel.add(buyHouseButton());
		buyAndSellPanel.add(sellHouseButton());
		buyAndSellPanel.add(buyHotelButton());
		buyAndSellPanel.add(sellHotelButton());
		buyAndSellPanel.setBackground(purple);
		return buyAndSellPanel;
	}
	
	/**
	 * Create a new panel with a drop down box on it
	 * @pre
	 * @post
	 * @return the panel with the drop down box
	 */
	private JPanel createDropDownBox()
	{
		// create a new jcombo box that takes in the strings with the options
		dropBox = new JComboBox(options);
		// set the index to zero
		dropBox.setSelectedIndex(0);
		dropBox.setFont(malayalam);
		// create a new JPanel to hold the combo box
		JPanel comboBoxPanel = new JPanel();
		// add the dropbox to the panel
		comboBoxPanel.add(dropBox);
		comboBoxPanel.setBackground(purple);
		// return the updated panel
		return comboBoxPanel;
	}
	
	/**
	 * @pre
	 * @post
	 * @return
	 */
	public JPanel dropPanel()
	{
		dropPanel = new JPanel(new BorderLayout());
		dropPanel.add(createDropDownBox(), BorderLayout.CENTER);
		dropPanel.add(buyAndSellPropertyPanel(), BorderLayout.SOUTH);
		return dropPanel;
	}
	
	/**
	 * @pre
	 * @post
	 * @return
	 */
	public JPanel buyAndSellPropertyPanel()
	{
		basPanel = new JPanel(new GridLayout(1,1));
		basPanel.add(sellPropertyButton());
		basPanel.setBackground(purple);
		return basPanel;
	}
	
	/**
	 * @pre
	 * @post
	 * @return
	 */
	public JButton sellPropertyButton()
	{
		sellPropertyButton = new JButton();
		sellPropertyButton.setFont(malayalam);
		sellPropertyButton.setText("Sell Property?");
		sellPropertyButton.setEnabled(false);
		return sellPropertyButton;
	}
	
	/**
	 * @pre
	 * @post
	 * @return
	 */
	public JButton sellHouseButton()
	{
		sellHouseButton = new JButton();
		sellHouseButton.setFont(malayalam);
		sellHouseButton.setText("Sell House?");
		sellHouseButton.setEnabled(false);
		return sellHouseButton;
	}
	
	/**
	 * @pre
	 * @post
	 * @return
	 */
	public JButton sellHotelButton()
	{
		sellHotelButton = new JButton();
		sellHotelButton.setFont(malayalam);
		sellHotelButton.setText("Sell Hotel?");
		sellHotelButton.setEnabled(false);
		return sellHotelButton;
	}
	
	/**
	 * @pre
	 * @post
	 * @return
	 */
	public JTextPane moneyArea()
	{
		StyledDocument document = new DefaultStyledDocument();
		Style defaultStyle = document.getStyle(StyleContext.DEFAULT_STYLE);
		StyleConstants.setAlignment(defaultStyle, StyleConstants.ALIGN_CENTER);
		totalMoneyBox = new JTextPane(document);
		totalMoneyBox.setText("Total Cash: $ " + "1500");
		totalMoneyBox.setBackground(purple);
		totalMoneyBox.setEditable(false);
		totalMoneyBox.setFont(malayalam);
		return totalMoneyBox;
	}
	
	/**
	 * @pre
	 * @post
	 * @return
	 */
	public JTextPane playerLabel()
	{
		StyledDocument document = new DefaultStyledDocument();
		Style defaultStyle = document.getStyle(StyleContext.DEFAULT_STYLE);
		StyleConstants.setAlignment(defaultStyle, StyleConstants.ALIGN_CENTER);
		playerNameBox = new JTextPane(document);
		playerNameBox.setBackground(purple);
		playerNameBox.setEditable(false);
		playerNameBox.setText("Player Name Here");
		playerNameBox.setFont(malayalamBold);
		return playerNameBox;
	}
	
	/**
	 * @pre
	 * @post
	 * @return
	 */
	public JPanel moneyAndPlacePanel()
	{
		mapPanel = new JPanel(new GridLayout(2,1));
		mapPanel.add(playerLabel());
		mapPanel.add(moneyArea());
		mapPanel.setBackground(purple);
		return mapPanel;
	}

}
	