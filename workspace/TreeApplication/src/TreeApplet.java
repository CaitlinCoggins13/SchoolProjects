//TreeApplet.java
//Katie Ho

// swing 
import javax.swing.JApplet;
import javax.swing.JPanel;
import java.awt.BorderLayout;



public class TreeApplet extends JApplet
{
  
  public TreeApplet()
  {
    //inherit methods from super constructor JApplet
    super(); 
    
    start();
   
  }
  
   /** 
	 * Special method that will be invoked when applet is created
	 **/
	public void start()
	{
	    //create a new instance of TreePanel 
	    JPanel panelTree = new TreePanel();
	    	//add a panelTree to the applet when this method runs
	    	add(panelTree);
	}
	
}