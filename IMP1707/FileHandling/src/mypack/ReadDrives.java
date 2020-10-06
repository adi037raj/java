package mypack;

import java.io.File;

public class ReadDrives
{
	public static void main(String[] args)
	{
		File drives[]= File.listRoots();
		for(File f : drives)
		{
			System.out.println(f.getAbsolutePath());
		}
	}
}
