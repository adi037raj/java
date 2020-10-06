package mypack;

import java.io.File;
import java.util.Scanner;

public class SearchFile
{
	static String file_name;
	static void readFiles(File file)
	{
		try
		{
			File files[]= file.listFiles();
			for(File temp_f: files)
			{
				if(temp_f.isFile())
				{
					if(temp_f.getName().toLowerCase().contains(file_name.toLowerCase()))
					{
						if(temp_f.getName().toLowerCase().endsWith(".java"))
							System.out.println(temp_f.getAbsolutePath());
					}
				}
			}
			for(File temp_f: files)
			{
				if(temp_f.isDirectory())
					readFiles(temp_f);
			}
		}
		catch(NullPointerException ex){}
	}
	public static void main(String[] args)
	{
		System.out.println("Enter File Name");;
		Scanner sc=new Scanner(System.in);
		file_name=sc.nextLine();
		File drives[]= File.listRoots();
		for(File f : drives)
		{
			System.out.println(f.getAbsolutePath());
			System.out.println("---------------------");
			readFiles(f);
		}
	}
}