import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
/**
 * IceCreamMaker creates the GUI for the IceCreamCone.
 * @author caitlincoggins
 *
 */
public class IceCreamMaker extends JPanel implements ActionListener
{
	/** Instance of IceCreamCone **/
	private IceCreamCone cone;
	/** Instance of IceCreamView **/
	private IceCreamConeView view;
	
	/** flavor buttons **/
	JButton vanilla;
    JButton chocolate;
    JButton mint;
    JButton strawberry;
    
    /** button pressed to remove the top scoop **/
    JButton trashScoop;
	
    /**
     * Constructor.
     */
	public IceCreamMaker()
    {
        // calls super
        super(new BorderLayout());
        
        // initializing
        cone = new IceCreamCone();
        view = new IceCreamConeView(cone);
        
        // adding score and board
        add(createButtonPanel(), BorderLayout.NORTH);
        add(view, BorderLayout.CENTER);
        
    }

	/**
	 * Creates panel of buttons for the GUI.
	 * @return allButtons the panel of buttons for the GUI.
	 */
	 public JPanel createButtonPanel()
	 {
		 // panel for all butons
	        JPanel allButtons = new JPanel( new GridLayout(2, 1));
	        
	        // panel for ice cream flavor buttons
	        JPanel iceCreamButtons = new JPanel(new GridLayout(1, 4));
	        
	        vanilla = new JButton("vanilla");
	        vanilla.addActionListener(this);
	        iceCreamButtons.add(vanilla);
	        
	        chocolate = new JButton("chocolate");
	        chocolate.addActionListener(this);
	        iceCreamButtons.add(chocolate);
	        
	        mint = new JButton("mint");
	        mint.addActionListener(this);
	        iceCreamButtons.add(mint);
	        
	        strawberry = new JButton("strawberry");
	        strawberry.addActionListener(this);
	        iceCreamButtons.add(strawberry);
	        
	        allButtons.add(iceCreamButtons);
	        
	        trashScoop = new JButton("Trash the top scoop!");
	        trashScoop.addActionListener(this);
	        allButtons.add(trashScoop);
	        
	        return allButtons;
	    }

	 /**
	  * Performs different actions depending on which button was clicked.
	  */
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			JButton clickedButton = (JButton)e.getSource();
			
			// add a scoop of vanilla and repaint
			if(clickedButton.equals(vanilla))
			{
				cone.addScoop("vanilla");
				newView();
			}
			
			// add a scoop of chocolate and repaint
			else if(clickedButton.equals(chocolate))
			{
				cone.addScoop("chocolate");
				newView();
			}
			
			// add a scoop of mint and repaint
			else if(clickedButton.equals(mint))
			{
				cone.addScoop("mint");
				newView();
			}
			
			// add a scoop of strawberry and repaint
			else if(clickedButton.equals(strawberry))
			{
				cone.addScoop("strawberry");
				newView();
			}
			
			// remove the top scoop and repaint
			else if(clickedButton.equals(trashScoop))
			{
				cone.removeScoop();
				newView();
			}
			
			// shouldn't get here
			else
			{
				System.out.println("Something's wrong with the buttons");
			}
			
		}
		
		/**
		 * Creates a new view and repaints.
		 */
		public void newView()
		{
			view = new IceCreamConeView(cone);
			repaint();
		}
	
}