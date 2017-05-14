// IceCreamLine.java

public class IceCreamLine
{
	QueueLL<IceCreamCone> lineQueue;
	
	public IceCreamLine()
	{
		lineQueue = new QueueLL<IceCreamCone>();
	}
	
	public void addNewOrder()
	{
		int scoops = (int) (Math.random()*4 )+1;
		
		IceCreamCone newCone = new IceCreamCone();
		
		for(int i = 0; i<scoops; ++i)
		{
			newCone.addScoop();
		}
		System.out.println(newCone);
		lineQueue.enqueue(newCone);
	}
	
	public void deleteOrder()
	{
		if(lineQueue.empty() == false)
			lineQueue.dequeue();
	}
	
	public boolean getEmpty()
	{
		boolean empty = lineQueue.empty();
		
		return empty;
	}
	
	public QueueLL getQueue()
	{
		QueueLL dontAlter = lineQueue;
    	return dontAlter;
	}
	
	
}