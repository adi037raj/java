package mypack;

public class MultiThread
{
	public static void main(String[] args) throws InterruptedException
	{
		System.out.println("Main Start");
		PrintAlpha th1=new PrintAlpha();
		
		PrintDigit obj=new PrintDigit();
		Thread th2=new Thread(obj);
		
		th1.start();
		th2.start();
		System.out.println("Main Continue");
		th1.join(5000);
		th2.join();
		System.out.println("Main End");
	}
}
class PrintAlpha extends Thread
{
	@Override
	public void run()
	{
		for(char ch='A';ch<='Z';ch++)
		{
			System.out.println(ch);
			try {
				Thread.sleep(600);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
class PrintDigit implements Runnable
{
	@Override
	public void run()
	{
		for(int i=1;i<=50;i++)
		{
			System.out.println(i);;
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}