package mypack;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class StoreData
{
	public static void main(String[] args)
	{
		String reg,name,branch;
		int marks;
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter RegNo\t");
		reg=sc.next();
		System.out.print("Enter Name\t");;
		sc.nextLine();
		name=sc.nextLine();
		System.out.print("Enter Branch\t");;
		branch=sc.next();
		System.out.print("Enter Marks\t");;
		marks=sc.nextInt();
		
		/*try {
			PrintStream pw=new PrintStream("details.xls");
			pw.print(reg+"\t");
			pw.print(name+"\t");
			pw.print(branch+"\t");
			pw.print(marks+"\n");
			pw.flush();
			pw.close();
			System.out.println("Data Stored");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		try(RandomAccessFile rFile=new RandomAccessFile("details.xls", "rw");)
		{
		rFile.seek(rFile.length());
		rFile.writeChars(reg+"\t"+name+"\t"+branch+"\t"+marks+"\n");
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
