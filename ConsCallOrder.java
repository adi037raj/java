class A
{
	/*public A()
	{
		System.out.println("A()");
	}*/
	public A(String name)
	{
		System.out.println("A(String)");
	}
	public A(int i)
	{
		System.out.println("A(int)");
	}
}
class B extends A
{
	
	public B()
	{
		super(78);
		System.out.println("B()");
	}	
	public B(String name)
	{
		super("ABC");
		System.out.println("B(String)");
	}
}
class C extends B
{
	public C(int x)
	{
		System.out.println("C(int)");
	}
}

class ConsCallOrder
{
	public static void main(String arr[])
	{
		/*B obj=new B();		
		B obj2=new B("XYZ");	
		*/
		C obj=new C(20);	
	}
}