package mypack;
public class LocalInner
{
	public static void main(String[] args)
	{
		X obj=new X();
		obj.show();
	}
}
class X
{
	int i=30;
	void show()
	{
		final int p=50;
		class Y
		{
			int a;
			Y(int a)
			{
				this.a=a;
			}
			void display()
			{
				System.out.println("a="+a+",p="+p+",i="+i);
			}
		}
		System.out.println("Show Start");
		System.out.println("Show Continue");
		Y ob=new Y(10);
		ob.display();
		System.out.println("Show End");
	}
}
