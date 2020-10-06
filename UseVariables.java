class UseVariables
{
	int a;
	static int b;
	
	public static void main(String arr[])
	{
		//System.out.println(a);			
		System.out.println(b);		
	
		//System.out.println(UseVariables.a);			
		System.out.println(UseVariables.b);
		

		UseVariables obj=new UseVariables();
		UseVariables obj2=new UseVariables();
		
		System.out.println(obj.a);
		System.out.println(obj.b);	
		
		System.out.println("------------------------");		
		obj.a=100;
		obj.b=200;

		System.out.println(obj.a);
		System.out.println(obj2.a);
		
		obj2.a=300;	
		System.out.println(obj.a);
		System.out.println(obj2.a);
		
		
		System.out.println("------------------------");		
		
		UseVariables.b=500;			
	
		System.out.println(obj.b);
		System.out.println(obj2.b);
		
		obj.b=600;
		obj2.b=40;
		
		b=99;
			
		System.out.println(obj.b);
		System.out.println(obj2.b);
		System.out.println(b);
		System.out.println(UseVariables.b);
		
		System.out.println("------------------------------------");

		obj2.a=30;
		
		UseVariables obj3=obj2;
		
		System.out.println(obj2.a);
		System.out.println(obj3.a);

	}
';}