interface I1
{
	//all fiels are public,static and final
	int x=78;
	
	//all method are public
	void show();
	void print();	
}
interface I2 extends I1
{

}
class A implements I1,I2
{
	public void show()
	{
		System.out.println("show in A");
	}
	public void print()
	{
		System.out.println("print in A");		
	}
}
class UseInterface
{
	public static void main(String arr[])
	{
		I1 obj=new A();
		//obj.x=100;
		System.out.println(obj.x);
		System.out.println(I1.x);
		System.out.println(A.x);
				
	}
}