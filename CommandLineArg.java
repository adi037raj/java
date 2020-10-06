class CommandLineArg
{
	public static void main(String arr[])
	{
		
		for(int i=0;i<arr.length;i++)
		{
			System.out.println("["+i+"]:"+arr[i]);	
		}

		System.out.println("_________________________");
		for(String str:arr)
		{
			System.out.println(str);
		}		
	}
}