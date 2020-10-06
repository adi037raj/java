class VarArg
{
	int sum()
	{
		System.out.println("sum() called");
		return 0;
	}
	int sum(int x,int y,int ...num)
	{
		int result=x+y;
		for(int i:num)
		{
			result=result+i;
		}
		return result;
	}
	public static void main(String arr[])
	{
		VarArg obj=new  VarArg();
		int result=obj.sum(10,20,10,20,20);
		System.out.println(result);		
	}
}