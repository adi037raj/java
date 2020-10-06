package itc_with_sleep;

public class Utility
{
	int i=0;
	private boolean data_ready;
	public void writeData() throws InterruptedException
	{
		//System.out.println("Thread Entered "+Thread.currentThread().getName());
		while(data_ready)
			Thread.sleep(50);
		i++;
		//System.out.println("Thread Exited "+Thread.currentThread().getName());
		data_ready=true;
	}
	
	public void readData() throws InterruptedException
	{
		//System.out.println("Thread Entered "+Thread.currentThread().getName());
		while(!data_ready)
			Thread.sleep(30);
		System.out.println(i);
		//System.out.println("Thread Exited "+Thread.currentThread().getName());
		data_ready=false;
	}
}
