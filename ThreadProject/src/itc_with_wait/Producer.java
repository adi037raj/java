package itc_with_wait;

public class Producer implements Runnable
{
	private Utility util;
	
	public Producer(Utility util)
	{
		super();
		this.util = util;
	}


	@Override
	public void run()
	{
		System.out.println("Started Thread "+Thread.currentThread().getName());
		try {
			while(true)
			{
			util.writeData();
			Thread.sleep(10);
			}
		}
		catch (InterruptedException e)
		{
				e.printStackTrace();
		}
	}

}