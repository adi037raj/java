class StaticMethod
{
	int x;
	static int y;
	
	static void f1()
	{
		//System.out.println(x);
		System.out.println(y);	
		//f2();

	}
	void f2()
	{
		System.out.println(x);
		System.out.println(y);
		f1();
	}
	

	public static void main(String arr[])
	{
		f1();	
		StaticMethod obj=new StaticMethod();
		obj.f2();
		//obj.f1();

	
	}
}