package itc_with_sleep;

public class Consumer implements Runnable
{
	private Utility util;
	
	public Consumer(Utility util)
	{
		super();
		this.util = util;
	}

	@Override
	public void run()
	{
		System.out.println("Thread Started "+Thread.currentThread().getName());
		try{
			while(true)
			{
				util.readData();
				Thread.sleep(400);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}