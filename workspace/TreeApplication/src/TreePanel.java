//TreePanel.java
//Katie Ho

//swing
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComponent;

//awt
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;



public class TreePanel extends JPanel
{
  
  public TreePanel()
  {
    //inherit methods from super constructor JPanel
    super(new BorderLayout());
    
    createPanel();
  }
  
  
  /**
  * creates a JPanel with the instructional text and a TreePainter.
  **/
  public void createPanel()
  {  
     //create a panel to add the TreePainter and instructions to
     JPanel treePanel = new JPanel();
     //set the layout to BorderLayout to organize the components
     treePanel.setLayout(new BorderLayout());
     
         //create a JLabel to display the instructions to the user
         JLabel instructions = new JLabel("<html><b>Click and drag to start a tree painting. <br/>Be patient as you draw, painting takes time!<html>");
         //set the font color to white (because black background of the panel)
      	 instructions.setForeground(Color.WHITE);
      	  //set the font of that text
         instructions.setFont(new Font("Verdana", Font.BOLD, 20));
         //set the background color to black
         treePanel.setBackground(Color.BLACK);
      	 //add the instructional text and an instance of TreePainter to the JPanel
      	 treePanel.add(instructions, BorderLayout.NORTH);
      	 treePanel.add(new TreePainter(), BorderLayout.CENTER);
      	 //System.out.println("I am printing out instructions");

  	 add(treePanel);
  }


}