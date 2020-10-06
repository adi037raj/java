class UseArray
{
	public static void main(String arr[])
	{
		int num[]={47,58,69,98};	

		/*for(int i=0;i<num.length;i++)
		{
			System.out.println(num[i]);
		}*/


		for(int i:num)
		{
			System.out.println(i);
		}
	}
}