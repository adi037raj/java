class A
{
	public void show()
	{
		System.out.println("Show in A");
	}		
}
class B extends A
{
	public void show()
	{
		System.out.println("Show in B");
	}	
	public void display()
	{
		System.out.println("Display in B");
	}
}
class C extends A
{

}
class RuntimePolymorphism
{
	public static void main(String arr[])
	{
		A obj=new A();
		obj.show();	
		
		A obj2=new B();
		obj2.show();
		obj2=new C();
		obj2.show();

		obj2=new B();
		B obj3=(B)obj2;
		obj3.display();		
	}	
}