import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * IceCreamLineManager creates a GUI for IceCreamLine.
 * @author caitlincoggins
 *
 */
public class IceCreamLineManager extends JPanel implements ActionListener
{
	/** instance of IceCreamLine **/
	private IceCreamLine line;
	/** instance of IceCreamLineView **/
	private IceCreamLineView view;
	
	/** button pressed for new order **/
	private JButton newCone;
	
	/** button pressed to remove order **/
	private JButton fillOrder;
	
	/**
	 * Constructor.
	 * Initializes line and view.
	 * Adds the panel of buttons and a view.
	 */
	public IceCreamLineManager()
	{
		super(new BorderLayout());
		
		line = new IceCreamLine();
		view = new IceCreamLineView(line, false);
		
		add(ButtonPanel(), BorderLayout.NORTH);
		add(view, BorderLayout.CENTER);
	}
	
	/**
	 * Adds all the buttons for this GUI into a panel.
	 * @return buttonPanel the panel of buttons
	 */
	public JPanel ButtonPanel()
	{
		JPanel buttonPanel = new JPanel(new GridLayout(2, 1));
		
		newCone = new JButton("Create a new cone");
		newCone.addActionListener(this);
		buttonPanel.add(newCone);
		
		fillOrder = new JButton("Fill an order");
		fillOrder.addActionListener(this);
		buttonPanel.add(fillOrder);
		
		return buttonPanel;
	}
	
	@Override
	/**
	 * Determines what action to perform based on the button pressed.
	 */
	public void actionPerformed(ActionEvent e) 
	{
		JButton chosenButton = (JButton)e.getSource();
		
		// add new IceCreamCone
		if(chosenButton == newCone)
		{
			line.addNewOrder();
			newView();
		}
		
		// remove first IceCreamCone
		else if(chosenButton == fillOrder)
		{
			line.deleteOrder();
			if(line.getEmpty() != true)
				newView();
		}
		
		else
			System.out.println("There's a button problem");
		
	}
	
	/**
	 * Creates a new view and repaints.
	 */
	public void newView()
	{
		view = new IceCreamLineView(line);
		validate();
		repaint();
	}
	
}