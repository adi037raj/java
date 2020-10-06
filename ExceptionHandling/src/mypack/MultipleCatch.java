package mypack;

import java.util.Scanner;

public class MultipleCatch {

	public static void main(String[] args) {
		int x = 0, y;
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter X:");
			x = sc.nextInt();
			System.out.print("Enter Y:");
			y = sc.nextInt();
			int result = x / y;
			System.out.println(result);
		} catch (ArithmeticException ex) {
			System.out.println(x + " cantnot be divided by zero");
		} catch (Exception ex) {
			System.out.println("Invalid number");
		}
	}
}
