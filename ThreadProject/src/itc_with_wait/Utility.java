package itc_with_wait;

public class Utility
{
	int i=0;
	private boolean data_ready;
	public synchronized void writeData() throws InterruptedException
	{
		//System.out.println("Thread Entered "+Thread.currentThread().getName());
		if(data_ready)
			wait();
		i++;
		//System.out.println("Thread Exited "+Thread.currentThread().getName());
		data_ready=true;
		notify();
	}
	
	public synchronized void readData() throws InterruptedException
	{
		//System.out.println("Thread Entered "+Thread.currentThread().getName());
		if(!data_ready)
			wait();
		System.out.println(i);
		//System.out.println("Thread Exited "+Thread.currentThread().getName());
		data_ready=false;
		notify();
	}
}
