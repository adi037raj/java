package mypack;

class P{
	
}
public class UseAnonymous
{
	void show()
	{
		new P(){
			void display()
			{
				System.out.println("Display of P");
			}
		}.display();
	}
	public static void main(String[] args)
	{
		UseAnonymous obj=new UseAnonymous();
		obj.show();
	}
}
