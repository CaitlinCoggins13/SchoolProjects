import java.awt.BorderLayout;
import javax.swing.JPanel;

public class thingGUI extends JPanel
{
	public thingGUI()
	{
		super(new BorderLayout());
		add(new what(), BorderLayout.CENTER);
		repaint();
	}
}