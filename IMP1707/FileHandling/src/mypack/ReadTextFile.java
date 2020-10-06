package mypack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadTextFile
{
	public static void main(String[] args)
	{
		//File f=new File("src\\mypack/Student.java");
		File f=new File("c:/UseListSelection.java");
		String str;
		try(Scanner sc=new Scanner(f);)
		{
			while(sc.hasNext())
			{
				str=sc.nextLine();
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
