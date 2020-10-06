package mypack;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StoreArrayList
{
	public static void main(String[] args)
	{
		ArrayList<Student> list_std=new ArrayList<>();
		list_std.add(new Student("R001", "Rakesh", "CSE", 78));
		list_std.add(new Student("R002", "a", "CE", 90));
		list_std.add(new Student("R003", "b", "ECE", 67));
		
		Collections.sort(list_std, new Comparator<Student>() {

			@Override
			public int compare(Student arg0, Student arg1) {
				int result;
				result=arg0.name.compareToIgnoreCase(arg1.name);
				return result;
			}
		});
		
		try {
			FileOutputStream fos=new FileOutputStream("student.txt");
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(list_std);
			oos.flush();
			oos.close();
			fos.close();
			System.out.println("Data Stored");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
