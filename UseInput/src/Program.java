import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		System.out.print("Enter Name:");

		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();

		System.out.print("Enter Marks:");
		int marks = sc.nextInt();

		System.out.println("Name:" + name + ",Marks:" + marks);

	}
}
