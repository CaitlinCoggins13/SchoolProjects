//TreeApplication.java
//Katie Ho

// swing
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TreeApplication 
{
  
  public static void main( String[] args )
  {
	
			//create a JFrame with an instance of TreePanel in it when the application is launched
      JFrame treeFrame = new JFrame();
			//set size
	    treeFrame.setSize( 800, 600 );
	    //add an instance of TreePanel to the frame
			treeFrame.add( new TreePanel() );
			//make sure it exits when the x of the window is clicked
		  treeFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		  //set it to visible
	    treeFrame.setVisible( true );
	
	 }




}