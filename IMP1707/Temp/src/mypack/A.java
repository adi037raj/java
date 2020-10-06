package mypack;

public class A
{
	int a;
	static int b;
	static class B
	{
		int x;
		static int y;
		public B(int i,int j)
		{
			x=i;y=j;
		}
		void show()
		{
			System.out.println("x="+x+",y="+y);
			//System.out.println("A="+a);
			System.out.println("B="+b);
		}
	}
}
