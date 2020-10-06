class A
{
	public void show()
	{
		System.out.println("Show In A");
	}	
}
class B extends A
{
	public void print()
	{
		System.out.println("Print In B");
	}	
}
class C extends B
{
	@Override	
	public void print()
	{	
		System.out.println("Print in C");
		super.show();
	}
	public void show()
	{
		System.out.println("Show in C");
	}
}
class Inheritance
{
	public static void main(String ar[])
	{
		B obj=new B();
		obj.print();			
		obj.show();
		System.out.println("--------------------");
	
		C obj2=new C();
		obj2.show();
		obj2.print();
			
	}
}
