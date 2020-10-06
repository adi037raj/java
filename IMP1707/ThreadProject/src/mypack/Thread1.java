package mypack;

public class Thread1
{
	public static void main(String[] args) throws InterruptedException
	{
		Thread th=Thread.currentThread();
		System.out.println(th.getName());
		th.setName("Primary");
		for(int i=1;i<=10;i++)
		{
			System.out.println(i);
			Thread.sleep(1000);
		}
		System.out.println(th.getName());
	}
}
