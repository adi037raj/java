package mypack;

import java.util.StringTokenizer;

public class UseTokenizer
{
	public static void main(String[] args)
	{
		String str="Welcome To Core Java";
		StringTokenizer tokenizer=new StringTokenizer(str, " ");
		while(tokenizer.hasMoreElements())
		{
			System.out.println(tokenizer.nextToken());
		}
	}
}
