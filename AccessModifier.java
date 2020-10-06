class A
{
	private int id;
	private void show()
	{
		System.out.println("Show in A");
	}
	public void display()
	{
		System.out.println("Display in A");
		show();
	}
	public void setId(int id)
	{
		this.id=id;
	}
	public int getId()
	{
		return id;
	}
}
class B extends A
{
	void print()
	{
		display();
	}
}
class AccessModifier
{
	public static void main(String arr[])
	{	
		B obj=new B();
		//obj.display();			
		obj.print();
	}
}

