package mypack;

import java.io.File;

public class ReadFilesFromDrives
{
	public static void main(String[] args)
	{
		File drives[]= File.listRoots();
		for(File f : drives)
		{
			System.out.println(f.getAbsolutePath());
			System.out.println("---------------------");
			try
			{
				File files[]= f.listFiles();
				for(File temp_f: files)
				{
					if(temp_f.isFile())
						System.out.println(temp_f.getAbsolutePath());
				}
				for(File temp_f: files)
				{
					if(temp_f.isDirectory())
						System.out.println(temp_f.getAbsolutePath());
				}
			}
			catch(NullPointerException ex){}
		}
	}
}
