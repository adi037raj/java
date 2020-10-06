package mypack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ReadDetails
{
	public static void main(String[] args)
	{
		ArrayList<Student> list_std=new ArrayList<>();
		try {
			FileInputStream fis=new FileInputStream("student.txt");
			ObjectInputStream ois=new ObjectInputStream(fis);
			list_std= (ArrayList<Student>) ois.readObject();
			ois.close();
			fis.close();
			System.out.println(list_std);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
