abstract class A
{
	public  int a=45;
	public A()
	{
		System.out.println("A()");
	}
	public void show()
	{
		System.out.println("Show in A");
	}			
	abstract void print();
}
final class B extends A
{
	public int a=100;
	public void print()
	{
		System.out.println("Show in B");
	}	
}
/*class C extends B
{

}*/

class ObstractClass
{
	public static void main(String arr[])
	{
		//A obj=new A();
		A obj=new B();
		obj.print();	
		System.out.println(obj.a);		
	}
}