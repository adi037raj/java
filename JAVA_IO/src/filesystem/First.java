package filesystem;

import java.io.File;
import java.io.IOException;

public class First {
	public static void main(String[] args) {

		File file = new File("D:\\tmp\\abc.txt");
		if (file.isFile()) {
			System.out.println("it is file");
		}
		/*
		 * if (file.mkdirs()) { System.out.println("Created"); } else {
		 * System.out.println("No"); }
		 */
		try {
			if (file.createNewFile()) {
				System.out.println("File Created");
			} else {
				System.out.println("Not Create");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			
		}
		System.out.println("----------------------------------------------");
		file = new File("D:\\tmp\\abc.txt");
		File dest = new File("E:\\aaaa.txt");
		boolean result = file.renameTo(dest);
		System.out.println(result);
		file = new File("D:\\tmp\\program.txt");
		System.out.println(file.delete());

		
	
	}
}
