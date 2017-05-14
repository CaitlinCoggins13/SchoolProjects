import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 * IceCreamLineView paints the ice cream cones in a box layout.
 * @author caitlincoggins
 *
 */
public class IceCreamLineView extends JComponent
{
	/** Current instance of IceCreamLine. **/
	private IceCreamLine line;
	
	/**
	 * Constructor.
	 * @param line current instance of IceCreamLine
	 */
	public IceCreamLineView(IceCreamLine line)
	{
		super();
		
		add(BoxLayoutPanel());
		this.line = line;
	}
	
	/**
	 * Constructor with nothing in queue.
	 * @param line current instance of IceCreamLine
	 * @param noQueue differentiates from constructor with something in the queue
	 */
	public IceCreamLineView(IceCreamLine line, boolean noQueue)
	{
		super();
		
		JPanel boxLayout = new JPanel();
		boxLayout.setLayout(new BoxLayout(boxLayout, BoxLayout.Y_AXIS));
		
		add(boxLayout);
	}
	
	/**
	 * Creates a panel that displays all queued IceCreamCones.
	 * @return boxLayout the queued cones in a BoxLayout
	 */
	public JPanel BoxLayoutPanel()
	{
		JPanel boxLayout = new JPanel(new BoxLayout(this, BoxLayout.Y_AXIS));

		// holds queue
		QueueLL<IceCreamCone> fullQueue = line.getQueue(); 
		
		// puts everything back in queue
		QueueLL<IceCreamCone> holdQueue = new QueueLL();
		
		// empty queue and paint IceCreamCones
		while(fullQueue.empty() == false)
		{
			boxLayout.add(new IceCreamConeView((IceCreamCone)fullQueue.peek()));
			holdQueue.enqueue((IceCreamCone)fullQueue.peek());
			fullQueue.dequeue();
			
		}
		
		// put everything back in queue
		while(holdQueue.empty() == false)
		{
			fullQueue.enqueue(holdQueue.peek());
			holdQueue.dequeue();
		}
		
		return boxLayout;
	}
	
	
	
}