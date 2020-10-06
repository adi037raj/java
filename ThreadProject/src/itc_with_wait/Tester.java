package itc_with_wait;

public class Tester
{
	public static void main(String[] args) throws InterruptedException
	{
		Utility util=new Utility();
		Producer produce=new Producer(util);
		Consumer consume=new Consumer(util);
		
		Thread th_produce=new Thread(produce, "Producer");
		th_produce.start();
		Thread th_consume=new Thread(consume, "Consumer");
		th_consume.start();
		th_consume.join();
		th_produce.join();
		System.out.println("Main End");
	}
}
