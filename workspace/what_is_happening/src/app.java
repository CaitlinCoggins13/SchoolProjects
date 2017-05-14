import javax.swing.JFrame;
import java.awt.Color;

public class app extends JFrame
{
	public static void main(String[] args)
	{
		JFrame monopolyFrame = new JFrame("monopoly");
		monopolyFrame.setSize(10000, 10000);
		monopolyFrame.add(new thingGUI());
		monopolyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		monopolyFrame.setVisible(true);
	}
}