// Caitlin Coggins
// IceCreamMaker.java

import javax.swing.JButton;
import javax.swing.JPanel;

// awt
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IceCreamMaker extends JFrame implements ActionListener
{
    private IceCreamCone cone;
    JButton vanilla;
    JButton chocolate;
    JButton mint;
    JButton strawberry;
    JButton trashScoop;
    
    public IceCreamMaker()
    {
        // call super constructor
        super();
        
        add( initGUI() );
    }
    
    // private method to create the GUI components
    // returns the created main panel
    private JPanel initGUI()
    {
        JPanel iceCreamPanel = new JPanel(new BorderLayout());
        
        // first, create panel to hold input
        // and add to north
        iceCreamPanel.add( createButtonPanel(), BorderLayout.NORTH );
        
        // then, create panel for drawing the ice cream cone
        // and add to center
        iceCreamPanel.add(  new IceCreamCone(), BorderLayout.CENTER );
        
        reuturn iceCreamPanel;
    }
    
    public JPanel createButtonPanel()
    {
        JPanel allButtons = new JPanel( new GridLayout(2, 1));
        
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
    }
    
    
}